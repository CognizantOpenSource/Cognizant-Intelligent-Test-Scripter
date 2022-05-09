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
package com.cognizant.cognizantits.engine.reporting.sync.octane;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FilenameUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.tools.ant.types.FileList.FileName;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cognizant.cognizantits.datalib.component.ExecutionStep;
import com.cognizant.cognizantits.datalib.component.TestSet;
import com.cognizant.cognizantits.engine.core.Control;
import com.cognizant.cognizantits.engine.core.RunManager;
import com.cognizant.cognizantits.engine.reporting.util.TestInfo;
import com.cognizant.cognizantits.engine.support.DLogger;

class OctaneClient {

	private static final Logger LOG = Logger.getLogger(OctaneClient.class.getName());
	public final String usr, pass, project, sharedspaceid;
	public String serverUrl;
	private final OctaneHttpClient oClient;

	public static String createdsuiterunID = "";
	
	public static int flag = 1;

	public OctaneClient(String hostURL, String username, String password, String project, String sharedspaceid,
			Map config) {
		setServerUrl(hostURL);
		this.usr = username;

		this.pass = password;
		this.project = project;

		this.sharedspaceid = sharedspaceid;

		oClient = new OctaneHttpClient(getUrl(serverUrl), username, password, config);

	}

	private void setServerUrl(String url) {
		if (!url.endsWith("/")) {
			url = url.concat("/");
		}
		serverUrl = url;
	}

	private static final String IS_LOGGED_IN = "api/shared_spaces";

	public boolean isConnected() throws ClientProtocolException, IOException {

		try {
			// https://almoctane-apj.saas.microfocus.com/api/shared_spaces/space_id/workspaces

			String res = oClient.Get(new URL(oClient.url + IS_LOGGED_IN + "/" + sharedspaceid + "/workspaces"))
					.toString();
			// System.out.println("Res : " + res);
			DLogger.Log(res);
			return true;
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
			return false;
		}
	}

	public boolean containsProject(String project) {
		try {
			// https://almoctane-apj.saas.microfocus.com/api/shared_spaces/64027/workspaces?fields=name

			String res = oClient
					.Get(new URL(oClient.url + IS_LOGGED_IN + "/" + sharedspaceid + "/workspaces" + "?fields=name"))
					.toString();
			// System.out.println("response contains workspace name" +
			// res.contains("\"name\":\"" + project + "\""));

			return res.contains("\"name\":\"" + project + "\"");
		}

		catch (Exception ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
			return false;
		}

	}

	public String getworkspaceID(String workspacename) throws MalformedURLException, Exception {

		JSONObject res = oClient.Get(

				new URL(oClient.url + IS_LOGGED_IN + "/" + sharedspaceid + "/workspaces" + "?fields=id,name"));

		try {
			JSONArray getworkspacelist = (JSONArray) res.get("data");
			for (int i = 0; i < getworkspacelist.size(); i++) {
				JSONObject proj = (JSONObject) getworkspacelist.get(i);
				if (proj.get("name").toString().equalsIgnoreCase(workspacename)) {
					return proj.get("id").toString();
				}
			}
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
		}
		return "";

	}

	private URL getUrl(String url) {
		try {
			return new URL(url);
		} catch (MalformedURLException ex) {
			LOG.log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public boolean updateResult(TestInfo TestCase, String status, List<File> attach) throws Exception {

		// make post to create test suite run for a test suite
		// fetch the test case run id under the test suite run
		// update status flag for this test case run id
		// send attachment for this test case run id

		// make post to create test suite run for a test suite

		String workspaceid = getworkspaceID(project);

		String statusname = getStatus(status);

		try {
			
			createSuiteRun(workspaceid);

			if ((workspaceid != null && !workspaceid.equals("")) && (statusname != null && !statusname.equals(""))
					&& (createdsuiterunID != null && !createdsuiterunID.equals(""))) {

				System.out.println("Created SuiteRuns id " + createdsuiterunID);
					
				String testcaserunID = getTestCaseRunID(TestCase.testCase, workspaceid);

				// System.out.println("workspace name" + project);
				// System.out.println("workspace id" + workspaceid);
				// System.out.println("put url is" + oClient.url + IS_LOGGED_IN + "/" +
				// sharedspaceid + "/workspaces/"
				// + workspaceid + "/manual_runs/" + TestCase.testCase);

				URL targeturl = new URL(oClient.url + IS_LOGGED_IN + "/" + sharedspaceid + "/workspaces/" + workspaceid
						+ "/manual_runs/" + testcaserunID);

				JSONObject json = new JSONObject();
				JSONObject statusArray = new JSONObject();
				statusArray.put("type", "list_node");
				statusArray.put("id", statusname);
				json.put("native_status", statusArray);
				String upload = json.toJSONString();
				// System.out.println("json object is " + json.toString());

				JSONObject res = oClient.put(targeturl, json.toString());

				for (int i = 0; i < attach.size(); i++) {
					addAttachments(workspaceid, testcaserunID, TestCase.testCase, attach.get(i));
				}

				TestSet testSet = Control.exe.getTestSet();

				testSet.loadTableModel();
				int total = testSet.getExecutableSteps().size();
				
				//System.out.println("step size" + total);
				
				
						if (flag == total) {
							
						
								createdsuiterunID = "";
							flag = 1;
 						} else
							flag++;
							
					}

				

				return true;

			}

		 catch (Exception ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
		}
		return false;
	}

	public boolean addAttachments(String workspaceid, String testcaserunID, String testcasename, File attach)
			throws Exception {

		URL targeturl = new URL(
				oClient.url + IS_LOGGED_IN + "/" + sharedspaceid + "/workspaces/" + workspaceid + "/attachments");

		JSONObject json = new JSONObject();
		JSONObject statusArray = new JSONObject();
		statusArray.put("type", "run_manual");
		statusArray.put("id", testcaserunID);
		json.put("owner_run", statusArray);
		String filename = testcasename + "." + FilenameUtils.getExtension(attach.getAbsolutePath());
		json.put("name", filename);
		String payload = json.toJSONString();
		// System.out.println("json object is " + json.toString());

		oClient.post(targeturl, payload, attach);

		return true;

	}

	public String createSuiteRun(String workspaceid) throws MalformedURLException, Exception {
		String suiteid = getSuiteID(workspaceid);
		//System.out.println("suiteid" + suiteid);
		String releaseID = getReleaseID(workspaceid);
		String testsetname = RunManager.getGlobalSettings().getTestSet();

		try {

			if (createdsuiterunID.isEmpty()) {
				if (suiteid != null && !suiteid.equals("")) {

					JSONObject json = new JSONObject();
					JSONObject testjson = new JSONObject();
					testjson.put("id", suiteid);
					testjson.put("type", "test_suite");
					json.put("test", testjson);

					JSONObject nativestatusjson = new JSONObject();
					nativestatusjson.put("id", "list_node.run_native_status.planned");
					nativestatusjson.put("type", "list_node");
					json.put("native_status", nativestatusjson);

					json.put("name", testsetname);

					JSONObject releaseob = new JSONObject();
					releaseob.put("id", releaseID);
					releaseob.put("type", "release");
					json.put("release", releaseob);

					JSONArray ja = new JSONArray();
					ja.add(json);

					JSONObject mainObj = new JSONObject();
					mainObj.put("data", ja);

					String postentity = mainObj.toString();

					JSONObject res = oClient.post(new URL(oClient.url + IS_LOGGED_IN + "/" + sharedspaceid
							+ "/workspaces/" + workspaceid + "/suite_run"), mainObj.toString());

					JSONArray getcreatedsuite = (JSONArray) res.get("data");
					JSONObject suite = (JSONObject) getcreatedsuite.get(0);
				
					createdsuiterunID = (String) suite.get("id");
					return createdsuiterunID;
				}
			}

		}

		catch (Exception ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
		}
		return "";

	}

	public String getSuiteID(String workspaceid) throws MalformedURLException, Exception {
		JSONObject res = oClient.Get(new URL(oClient.url + IS_LOGGED_IN + "/" + sharedspaceid + "/workspaces/"
				+ workspaceid + "/test_suites?fields=id,name"));

		try {
			JSONArray getsuitelist = (JSONArray) res.get("data");
			for (int i = 0; i < getsuitelist.size(); i++) {
				JSONObject suite = (JSONObject) getsuitelist.get(i);

				String suiteName = RunManager.getGlobalSettings().getTestSet();

				if (suite.get("name").toString().equalsIgnoreCase(suiteName)) {
					return suite.get("id").toString();
				}
			}
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
		}
		return "";

	}

	public String getTestCaseRunID(String testcasename, String workspaceid) throws MalformedURLException, Exception {
		JSONObject res = oClient.Get(new URL(oClient.url + IS_LOGGED_IN + "/" + sharedspaceid + "/workspaces/"
				+ workspaceid + "/runs?fields=id,name,release,test_name"));
		String suiteName = RunManager.getGlobalSettings().getTestSet();
		ArrayList<String> alltestcaseruns = getAllTestCaseRunIDS(workspaceid);
		String releaseID = getReleaseID(workspaceid);
		try {
			if (alltestcaseruns != null) {
				JSONArray getruns = (JSONArray) res.get("data");
				for (int i = 0; i < getruns.size(); i++) {
					JSONObject run = (JSONObject) getruns.get(i);

					JSONObject release = (JSONObject) run.get("release");

					if (run.get("name").toString().equalsIgnoreCase(suiteName)
							&& release.get("id").toString().equalsIgnoreCase(releaseID)
							&& run.get("test_name").toString().equalsIgnoreCase(testcasename)) {
						if (alltestcaseruns.contains(run.get("id").toString())) {

							return run.get("id").toString();
						}
					}
				}

			}
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
		}
		return "";

	}

	public ArrayList<String> getAllTestCaseRunIDS(String workspaceid) throws MalformedURLException, Exception {
		JSONObject res = oClient.Get(new URL(oClient.url + IS_LOGGED_IN + "/" + sharedspaceid + "/workspaces/"
				+ workspaceid + "/runs/" + createdsuiterunID + "?fields=id,name,runs_in_suite"));
//System.out.println("response" + res);
		ArrayList<String> testcaserunids = new ArrayList<>();

		try {
			JSONObject runs = (JSONObject) res.get("runs_in_suite");
			//System.out.println("runs " + runs);
			JSONArray runsarray = (JSONArray) runs.get("data");
			//System.out.println("runsarray" + runsarray);
			for (int i = 0; i < runsarray.size(); i++) {
				JSONObject run = (JSONObject) runsarray.get(i);
				testcaserunids.add((String) run.get("id"));

			}
			return testcaserunids;
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
		}
		return null;
	}

	public String getReleaseID(String workspaceid) throws MalformedURLException, Exception {
		JSONObject res = oClient.Get(new URL(oClient.url + IS_LOGGED_IN + "/" + sharedspaceid + "/workspaces/"
				+ workspaceid + "/releases?fields=id,name"));

		try {
			JSONArray getreleases = (JSONArray) res.get("data");
			for (int i = 0; i < getreleases.size(); i++) {
				JSONObject release = (JSONObject) getreleases.get(i);

				String releasename = RunManager.getGlobalSettings().getRelease();

				if (release.get("name").toString().equalsIgnoreCase(releasename)) {
					return release.get("id").toString();
				}
			}
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
		}
		return "";

	}

	private String getStatus(String status) {
		switch (status.toUpperCase()) {
		case "PASSED":
			return "list_node.run_native_status.passed";
		case "FAILED":
			return "list_node.run_native_status.failed";

		default:
			return "";
		}
	}
}
