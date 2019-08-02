/*
 * Copyright 2014 - 2017 Cognizant Technology Solutions
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
package com.cognizant.cognizantits.engine.reporting.sync.zephyr;

import com.cognizant.cognizantits.engine.support.DLogger;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ZephyrClient {

	String userName;
	String password;
	String testPhase;
	Map config;
	public URL url;

	private static final String PROJLIST = "flex/services/rest/latest/project/details",
			VERSIONLIST = "flex/services/rest/latest/release/project/",
			CYCLELIST = "flex/services/rest/latest/cycle/release/", EXELIST = "flex/services/rest/latest/execution/",
			TCASEID = "flex/services/rest/v1/testcase",
			UPLOAD = "flex/services/rest/v3/execution/statusandattachment/";

	class array {

		static final String ID = "id", NAME = "name", REMOTE_PHASES = "cyclePhases", REMOTE_REPO = "remoteRepository",
				REMOTE_DATA = "remoteData", TESTCASE = "testcase";
	}

	public ZephyrClient(String url, String username, String password, String phase, Map options) {
		this.setUrl(url);
		this.userName = username;
		this.password = password;
		this.testPhase = phase;
		this.config = options;
	}

	private void setUrl(String zephyrUrl) {
		try {
			if (!zephyrUrl.endsWith("/")) {
				zephyrUrl = zephyrUrl.concat("/");
			}
			URL main = new URL(zephyrUrl);
			this.url = main;
		} catch (MalformedURLException ex) {
			Logger.getLogger(ZephyrClient.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	/**
	 * connect with Zephyr REST API get execution id and call the update result
	 *
	 * @param tc
	 * @param ts
	 * @param rc
	 * @param proj
	 * @param httpclient
	 * @param status
	 * @param list 
	 * @return
	 * @throws Exception
	 * @see #updateResult(int, int,
	 *      com.cognizant.reporting.sync.jira.JIRAHttpClient)
	 */
	public int updateResult(String tc, String ts, String rc, String proj, ZephyrHttpClient httpclient, int status, List<File> list)
			throws Exception {
		DLogger.Log("Req EID with", "Testcase : ", tc, "TestSet :", ts, "Release :", rc, "Project :", proj);
		int eid = getExecutionID(tc, ts, rc, proj, httpclient, status,list);
		return eid;
	}

	/**
	 * connect with Zephyr REST API to update execution(test case) attachment
	 * (report )
	 *
	 * @param eid
	 *            execution ID
	 * @param toattach
	 *            file to upload
	 * @param httpclient
	 * @return
	 */
	public String addAttachment(int eid, File toattach, ZephyrHttpClient httpclient) {
		// return ZAPIClient.addAttachment(eid, toattach, httpclient);
		return null;
	}

	/**
	 * Connect with Zephyr REST API check for project existence , used for test
	 * connection feature
	 *
	 * @param project
	 * @param jc
	 * @return
	 */
	public boolean containsProject(String project, ZephyrHttpClient jc) {
		try {
			return (getProjID(project, jc) != -1);
		} catch (Exception ex) {
			Logger.getLogger(ZephyrClient.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	/**
	 * 
	 * @param tc
	 * @param ts
	 * @param rc
	 * @param proj
	 * @param client
	 * @param status
	 * @param list 
	 * @return
	 */
	public int getExecutionID(String tc, String ts, String rc, String proj, ZephyrHttpClient client, int status, List<File> list) {
		int id = getProjID(proj, client);
		if (id > 0) {
			id = getVersionID(rc, id, client);
			if (id > 0) {
				id = getCyclePhaseID(ts, id, testPhase, client);
				if (id > 0) {
					id = getExecutionID(tc, id, client, status,list);
				}
			}
		}
		return id;
	}

	private int getProjID(String projectName, ZephyrHttpClient client) {
              int pid = -1;
              try {
                     String url = client.url + PROJLIST;
                     DLogger.Log("Req Project ID ", url);
                     JSONObject projList = client.Get(new URL(url));
                     DLogger.Log("Looking for [", projectName, "] in", projList);
                     for (Object proj : (Iterable<? extends Object>) projList.get("array")) {
                           String projName = ((Map<?, ?>) proj).get(ZephyrClient.array.NAME).toString();
                           if (projectName.equals(projName)) {
                                  String id = ((Map<?, ?>) proj).get(ZephyrClient.array.ID).toString();
                                  pid = Integer.valueOf(id);
                                  break;
                           }
                     }
                     if (pid == -1) {
                           DLogger.LogE("Project [", projectName, "] not found");
                     }
              } catch (Exception ex) {
                     Logger.getLogger(ZephyrClient.class.getName()).log(Level.SEVERE, null, ex);
              }
              return pid;
    }



	/**
	 * 
	 * @param release
	 * @param projId
	 * @param client
	 * @return
	 */
	private int getVersionID(String release, int projId, ZephyrHttpClient client) {
		int releaseID = -1;
		try {
			String url = client.url + VERSIONLIST + URLEncoder.encode(Integer.toString(projId), "UTF-8");
			DLogger.Log("Req Release ID ", url);
			JSONObject releaseList = client.Get(new URL(url));
			DLogger.Log("Looking for [", release, "] in", releaseList);
			for (Object proj : (Iterable<? extends Object>) releaseList.get("array")) {
				String id = ((Map<?, ?>) proj).get(ZephyrClient.array.NAME).toString();
				if (Objects.equals(id, release)) {
					releaseID = Integer.valueOf(((Map<?, ?>) proj).get(ZephyrClient.array.ID).toString());
				}
			}
			if (releaseID == -1) {
				DLogger.LogE("Project/Release [", release, "] not found");
			}
		} catch (Exception ex) {
			Logger.getLogger(ZephyrClient.class.getName()).log(Level.SEVERE, null, ex);
		}
		return releaseID;
	}

	/**
	 * 
	 * @param testSet
	 * @param releaseID
	 * @param phase
	 * @param client
	 * @return
	 */
	private int getCyclePhaseID(String testSet, int releaseID, String phase, ZephyrHttpClient client) {
		int cycleId = -1;
		try {
			String url = client.url + CYCLELIST + URLEncoder.encode(Integer.toString(releaseID), "UTF-8");
			DLogger.Log("Req CyclePhase ID ", url);
			JSONObject releaseList = client.Get(new URL(url));
			DLogger.Log("Looking for [", testSet, "] in", releaseList);
			for (Object proj : (Iterable<? extends Object>) releaseList.get("array")) {
				String id = ((Map<?, ?>) proj).get(ZephyrClient.array.NAME).toString();
				if (Objects.equals(id, testSet)) {
					JSONArray remotePhases = (JSONArray) ((Map<?, ?>) proj).get(ZephyrClient.array.REMOTE_PHASES);
					Iterator remotePhase = remotePhases.iterator();
					while (remotePhase.hasNext()) {
						JSONObject testphase = (JSONObject) remotePhase.next();
						String phaseName = testphase.get(ZephyrClient.array.NAME).toString();
						if (Objects.equals(phaseName, phase)) {
							cycleId = Integer.valueOf(testphase.get(ZephyrClient.array.ID).toString());
							break;
						}
					}
				}
			}
			if (cycleId == -1) {
				DLogger.LogE("Phase [", phase, "] not found");
			}
		} catch (Exception ex) {
			Logger.getLogger(ZephyrClient.class.getName()).log(Level.SEVERE, null, ex);
		}
		return cycleId;
	}

	/**
	 * 
	 * @param testcase
	 * @param cyclePhaseId
	 * @param client
	 * @param status
	 * @param list 
	 * @return
	 */
	private int getExecutionID(String testcase, int cyclePhaseId, ZephyrHttpClient client, int status, List<File> list) {
		Long executionId = (long) -1;
		Long tcrCatalogueId = (long) -1;
		Long testerId = (long) -1;
		try {
			String url = client.url + EXELIST + "?cyclephaseid="
					+ URLEncoder.encode(Integer.toString(cyclePhaseId), "UTF-8");
			DLogger.Log("Req Execution ID ", url);
			JSONObject releaseList = client.Get(new URL(url));
			DLogger.Log("Looking for [", cyclePhaseId, "] in", releaseList);
			JSONArray exeList = (JSONArray) releaseList.get("results");
			Iterator testcases = exeList.iterator();
			while (testcases.hasNext()) {
				JSONObject tc = (JSONObject) testcases.next();
				testerId = (Long) tc.get("testerId");
				JSONObject tcrtc = (JSONObject) tc.get("tcrTreeTestcase");
				tcrCatalogueId = (Long) tcrtc.get("tcrCatalogTreeId");
				JSONObject actualTC = (JSONObject) tcrtc.get("testcase");
				String testname = (String) actualTC.get("name");
				if (testname.equals(testcase)) {
					executionId = (long) tc.get("id");
					break;
				}
			}
			if (executionId > 0) {
				/*JSONObject payload = new JSONObject();
				payload.put("createRTSList", null);
				payload.put("updateRTSList", null);
				payload.put("unassignedRtsIds", null);
				payload.put("notes", null);
				payload.put("tcrCatalogTreeId", tcrCatalogueId.intValue());
				payload.put("selectedAll", null);
				payload.put("unselectedIds", null);
				payload.put("executedOn", null);
				payload.put("testerId", testerId.intValue());
				payload.put("cyclePhaseId", cyclePhaseId);
				String statusurl = client.url + EXELIST
						+ URLEncoder.encode(Integer.toString(executionId.intValue()), "UTF-8") + "?status=" + status
						+ "&testerid=" + testerId.intValue();
				JSONObject response = client.put(new URL(statusurl), payload.toJSONString());
				if (response != null) {
					JSONObject lastRes = (JSONObject) response.get("lastTestResult");
					int updatedStatus = Integer.parseInt((String) lastRes.get("executionStatus"));
					if (status == updatedStatus) {
						DLogger.LogE("Status updated successfully");
					}
				}*/
				
				///Upload the files
				String uploadURL = client.url+UPLOAD+ URLEncoder.encode(Integer.toString(executionId.intValue()), "UTF-8") + "?status=" + status
						+ "&testerid=" + testerId.intValue();
				for (File file : list) {
					JSONObject upload = client.put(new URL(uploadURL), file);
				}
			}
			
		} catch (Exception ex) {
			Logger.getLogger(ZephyrClient.class.getName()).log(Level.SEVERE, null, ex);
		}
		return executionId.intValue();
	}

	/**
	 * 
	 * @param testcase
	 * @param client
	 * @return
	 */
	private int getTestCaseId(String testcase, ZephyrHttpClient client) {
		int tcaseId = -1;
		try {
			String url = client.url + TCASEID + "?testcase.name=" + URLEncoder.encode(testcase, "UTF-8");
			DLogger.Log("Req Testcase ID ", url);
			JSONObject releaseList = client.Get(new URL(url));
			DLogger.Log("Looking for [", testcase, "] in", releaseList);
			for (Object proj : (Iterable<? extends Object>) releaseList.get("array")) {
				JSONObject tcaseObj = (JSONObject) ((JSONObject) proj).get(ZephyrClient.array.TESTCASE);
				tcaseId = Integer.valueOf(tcaseObj.get(ZephyrClient.array.ID).toString());
				if (tcaseId == -1) {
					DLogger.LogE("Testcase [", testcase, "] not found");
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(ZephyrClient.class.getName()).log(Level.SEVERE, null, ex);
		}
		return tcaseId;
	}

	public void updateStatus(int executionId, ZephyrHttpClient client, int status) {
		/*
		 * String url = client.url + STATUS + Long.valueOf(executionId) + "/?status=" +
		 * status; URL targetUrl = null; try { targetUrl = new URL(url);
		 * DLogger.Log("Req Testcase ID ", url); String data = "$jsonRequestSingleLine";
		 * client.put(targetUrl, data); } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

	}
}
