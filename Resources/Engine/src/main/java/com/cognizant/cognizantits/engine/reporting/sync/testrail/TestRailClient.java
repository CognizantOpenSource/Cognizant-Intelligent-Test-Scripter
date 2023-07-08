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
package com.cognizant.cognizantits.engine.reporting.sync.testrail;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TestRailClient {

    private static final Logger LOG = Logger.getLogger(TestRailClient.class.getName());
    private TestRailHttpClient client;
    public static final String GET_PROJECT = "index.php?/api/v2/get_projects";
    public static String GET_SUITES = "index.php?/api/v2/get_suites/<projectId>";
    public static String ADD_RUN = "index.php?/api/v2/add_run/<projectId>";
    public static String GET_TESTIDS = "index.php?/api/v2/get_cases/<projectId>&suite_id=<suiteId>";
    public static String ADD_RESULT = "index.php?/api/v2/add_result/<testId>";
    public static String ADD_RESULT_FOR_CASE = "index.php?/api/v2/add_result_for_case/<runId>/<testcaseId>";
    public static String runId = "";

    public TestRailClient(String url, String uname, String pwd, String project, Map options)
            throws MalformedURLException {
        client = new TestRailHttpClient(toURL(url), uname, pwd, options);
    }

    private static URL toURL(String url) throws MalformedURLException {
        if (!url.endsWith("/")) {
            url = url.concat("/");
        }
        return new URL(url);
    }

    boolean containsProject(String project) {
        try {
            String res = client.Get(new URL(client.url + GET_PROJECT)).toString();
            return res.contains("\"name\":\"" + project + "\"");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
    }

    public String getProjectId(String project) {
        try {
            JSONObject res = client.Get(new URL(client.url + GET_PROJECT));
            JSONArray projectList = (JSONArray) res.get("array");
            for (int i = 0; i < projectList.size(); i++) {
                JSONObject proj = (JSONObject) projectList.get(i);
                if (proj.get("name").toString().equalsIgnoreCase(project)) {
                    return proj.get("id").toString();
                }
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return "";
    }

    public String getSuiteID(String project, String suitename) {
        try {
            String GET_SUITES_URL = GET_SUITES.replace("<projectId>", getProjectId(project));
            JSONObject res = client.Get(new URL(client.url + GET_SUITES_URL));
            JSONArray suiteList = (JSONArray) res.get("array");
            for (int i = 0; i < suiteList.size(); i++) {
                JSONObject suite = (JSONObject) suiteList.get(i);
                if (suite.get("name").toString().equalsIgnoreCase(suitename)) {
                    return suite.get("id").toString();
                }
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return "";
    }

    public String addRuntoSuite(String project, String suiteid) throws MalformedURLException, Exception {
        String ADD_RUN_URL = ADD_RUN.replace("<projectId>", project);
        String payload = "{\"suite_id\": <suiteid>}";
        payload = payload.replace("<suiteid>", suiteid);
        JSONObject res = client.post(new URL(client.url + ADD_RUN_URL), payload);
        return res.get("id").toString();
    }

    public List<String> getTestCaseIDs(String project, String suiteid) throws MalformedURLException, Exception {
        List<String> testCaseIds = new ArrayList<String>();
        String GET_TESTIDS_URL = GET_TESTIDS.replace("<projectId>", project);
        GET_TESTIDS_URL = GET_TESTIDS_URL.replace("<suiteId>", suiteid);
        JSONObject res = client.Get(new URL(client.url + GET_TESTIDS_URL));
        JSONArray testcaseList = (JSONArray) res.get("array");
        for (int i = 0; i < testcaseList.size(); i++) {
            JSONObject suite = (JSONObject) testcaseList.get(i);
            testCaseIds.add(suite.get("id").toString() + ";" + suite.get("title").toString());
        }
        return testCaseIds;
    }

    public void addResultForTestId(String runId, String testId, String status) throws MalformedURLException, Exception {
        String ADD_RESULT_FOR_CASE_URL = ADD_RESULT_FOR_CASE.replace("<runId>", runId);
        ADD_RESULT_FOR_CASE_URL = ADD_RESULT_FOR_CASE_URL.replace("<testcaseId>", testId);
        String payload = "{\"status_id\": <status>}";
        payload = payload.replace("<status>", status);
        client.post((new URL(client.url + ADD_RESULT_FOR_CASE_URL)), payload);
    }

    public int updateResult(int status, String testCase, String tset, String rls, String project, List<File> attach)
            throws MalformedURLException, Exception {
        String projectId = getProjectId(project);
        String suiteId = getSuiteID(project, tset);
        if (runId.isEmpty()) {
            runId = addRuntoSuite(projectId, suiteId);
        }
        List<String> testCaseIds = getTestCaseIDs(projectId, suiteId);
        String testId = "";
        for (int i = 0; i < testCaseIds.size(); i++) {
            String text = testCaseIds.get(i);
            if (text.split(";")[1].equalsIgnoreCase(testCase)) {
                testId = text.split(";")[0];
                break;
            }
        }
        addResultForTestId(runId, testId, String.valueOf(status));
        return 0;
    }
}
