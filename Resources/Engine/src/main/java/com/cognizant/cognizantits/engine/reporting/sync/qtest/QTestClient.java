/*
 * Copyright 2014 - 2019 Cognizant Technology Solutions
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cognizant.cognizantits.engine.reporting.sync.qtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cognizant.cognizantits.engine.reporting.util.TestInfo;
import com.cognizant.cognizantits.engine.support.DLogger;
import com.cognizant.cognizantits.engine.util.data.mime.MIME;

class QTestClient {

	private static final Logger LOG = Logger.getLogger(QTestClient.class.getName());
	public final String usr, siteName, pass, cycle;
	public String serverUrl;
	private final QTestHttpClient httpClient;

	public QTestClient(String hostURL, String username, String password, String site, String cycle) {
		setServerUrl(hostURL);
		this.usr = username;
		this.siteName = site;
		this.pass = password;
		this.cycle = cycle;
		httpClient = new QTestHttpClient(getUrl(serverUrl), username, password, site);
	}

	private void setServerUrl(String url) {
		if (!url.endsWith("/")) {
			url = url.concat("/");
		}
		serverUrl = url;
	}

	private static final String IS_LOGGED_IN = "oauth/token";
	private static final String PROJECT_LIST = "/api/v3/projects";
	private static final String UPLOAD = PROJECT_LIST + "/{{projectID}}/test-runs/{{runID}}/test-logs";

	public boolean isLoggedIn() {
		try {
			JSONObject res = httpClient.post(this.getUrl(buildUrl(IS_LOGGED_IN)), getParams());
			if (res != null && Objects.toString(res.get("token_type"), "").contains("bearer")) {
				httpClient.setAuthHeader(
						Objects.toString(res.get("token_type")) + " " + Objects.toString(res.get("access_token")));
				return true;
			}
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, null, ex);
		}
		return false;
	}

	private URL getUrl(String url) {
		try {
			return new URL(url);
		} catch (MalformedURLException ex) {
			LOG.log(Level.SEVERE, null, ex);
		}
		return null;
	}

	private String buildUrl(String rest) {
		return serverUrl.concat(rest);
	}

	private List<NameValuePair> getParams() {
		List<NameValuePair> parameters = new ArrayList<>();
		parameters.add(new BasicNameValuePair("grant_type", "password"));
		parameters.add(new BasicNameValuePair("username", this.usr));
		parameters.add(new BasicNameValuePair("password", this.pass));
		return parameters;
	}

	public QTestHttpClient getHTTPClient() {
		return httpClient;
	}

	public int getProjectID(String project) {
		int projectID = -1;
		try {
			JSONObject res = httpClient.Get(this.getUrl(buildUrl(PROJECT_LIST)));
			for (Object proj : (Iterable<? extends Object>) res.get("array")) {
				if (((Map<?, ?>) proj).get("name").toString().equalsIgnoreCase(project)) {
					projectID = Integer.valueOf(((Map<?, ?>) proj).get("id").toString());
					break;
				}
			}
			if (projectID == -1) {
				DLogger.LogE("Project [", project, "] not found");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projectID;
	}

	public int getReleaseID(int projectId, String release) {
		int releaseID = -1;
		try {
			JSONObject res = httpClient.Get(this.getUrl(buildUrl(PROJECT_LIST + "/" + projectId + "/releases")));
			for (Object proj : (Iterable<? extends Object>) res.get("array")) {
				if (((Map<?, ?>) proj).get("name").toString().equalsIgnoreCase(release)) {
					releaseID = Integer.valueOf(((Map<?, ?>) proj).get("id").toString());
					break;
				}
			}
			if (releaseID == -1) {
				DLogger.LogE("Release [", release, "] not found");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return releaseID;

	}

	public int getCycleID(int projectID, int releaseID) {
		int cycleID = -1;
		try {
			JSONObject res = httpClient.Get(this.getUrl(buildUrl(
					PROJECT_LIST + "/" + projectID + "/test-cycles?parentId=" + releaseID + "&parentType=release")));
			for (Object proj : (Iterable<? extends Object>) res.get("array")) {
				if (((Map<?, ?>) proj).get("name").toString().equalsIgnoreCase(cycle)) {
					cycleID = Integer.valueOf(((Map<?, ?>) proj).get("id").toString());
					break;
				}
			}
			if (cycleID == -1) {
				DLogger.LogE("Test Cycle [", cycle, "] not found");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cycleID;
	}

	public int getSuiteID(int projectID, int cycleID, String testSet) {
		int suiteID = -1;
		try {
			JSONObject res = httpClient.Get(this.getUrl(buildUrl(
					PROJECT_LIST + "/" + projectID + "/test-suites?parentId=" + cycleID + "&parentType=test-cycle")));
			for (Object proj : (Iterable<? extends Object>) res.get("array")) {
				if (((Map<?, ?>) proj).get("name").toString().equalsIgnoreCase(testSet)) {
					suiteID = Integer.valueOf(((Map<?, ?>) proj).get("id").toString());
					break;
				}
			}
			if (suiteID == -1) {
				DLogger.LogE("Test Suite [", testSet, "] not found");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suiteID;
	}

	public List<Integer> getTestRunID(int projectID, int suiteID, String testCase) {
		ArrayList<Integer> testIDs = new ArrayList<>();
		int runID = -1;
		int versionID = -1;
		try {
			JSONObject res = httpClient.Get(this.getUrl(buildUrl(
					PROJECT_LIST + "/" + projectID + "/test-runs?parentId=" + suiteID + "&parentType=test-suite")));
			for (Object proj : (Iterable<? extends Object>) res.get("array")) {
				if (((Map<?, ?>) proj).get("name").toString().equalsIgnoreCase(testCase)) {
					runID = Integer.valueOf(((Map<?, ?>) proj).get("id").toString());
					versionID = Integer.valueOf(((Map<?, ?>) proj).get("test_case_version_id").toString());
					testIDs.add(runID);
					testIDs.add(versionID);
					break;
				}
			}
			if (runID == -1) {
				DLogger.LogE("Test run [", testCase, "] not found");
			}
			if (versionID == -1) {
				DLogger.LogE("Test Version ID is not found");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testIDs;
	}

	public boolean uploadfile(int projectID, List<Integer> runID, TestInfo testCase, String status, List<File> attach) {
		try {
			String project = UPLOAD.replace("{{projectID}}", String.valueOf(projectID));
			String runid = project.replace("{{runID}}", String.valueOf(runID.get(0)));
			// runid = "/api/v3/projects/"+projectID+"/test-logs/"+runID+"/blob-handles";
			JSONObject json = new JSONObject();
			JSONObject statusArray = new JSONObject();
			statusArray.put("id", getStatusID(status));
			statusArray.put("name", status);
			json.put("status", statusArray);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			String start = df.format(testCase.startdate);
			String end = df.format(testCase.enddate);
			json.put("exe_start_date", start);
			json.put("exe_end_date", end);
			json.put("test_case_version_id", runID.get(1));
			json.put("attachments", getAttachments(attach));
			JSONObject res = httpClient.post(this.getUrl(buildUrl(runid)), json.toString());
			if (res != null
					&& Objects.toString(res.get("test_case_version_id"), "").contains(String.valueOf(runID.get(1)))) {
				return true;
			}
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, null, ex);
		}
		return false;
	}

	private JSONArray getAttachments(List<File> attach) {
		JSONArray array = new JSONArray();
		for (File file : attach) {
			JSONObject json = new JSONObject();
			json.put("name", file.getName());
			json.put("content_type", MIME.getType(file));
			json.put("data", encodeBase64(file));
			array.add(json);
		}
		return array;
	}

	private String encodeBase64(File file) {
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(java.util.Base64.getEncoder().encodeToString(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStreamReader != null) {
				try {
					fileInputStreamReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return encodedBase64;
	}

	private String getStatusID(String status) {
		switch (status) {
		case "Passed":
			return String.valueOf(601);
		case "Failed":
			return String.valueOf(602);
		}
		return null;
	}
}
