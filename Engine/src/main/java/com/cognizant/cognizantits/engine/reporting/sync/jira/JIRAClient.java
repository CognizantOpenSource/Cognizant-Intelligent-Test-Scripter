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
package com.cognizant.cognizantits.engine.reporting.sync.jira;

import com.cognizant.cognizantits.engine.support.DLogger;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

public class JIRAClient {

    String userName;
    String password;
    public URL url;

    public Map<String, Map<Object, Integer>> tsets = new HashMap<>();
    public static String JIRAIssue = "/rest/api/latest/issue",
            JIRAIssueAttach = "/rest/api/latest/issue/issuekey/attachments";
    
    String jsonStr = null;

    public JIRAClient(String url, String username, String password) {
        this.setUrl(url);
        this.userName = username;
        this.password = password;
    }

    private void setUrl(String jiraUrl) {
        try {
            if (!jiraUrl.endsWith("/")) {
                jiraUrl = jiraUrl.concat("/");
            }
            URL main = new URL(jiraUrl);
            this.url = main;
        } catch (MalformedURLException ex) {
            Logger.getLogger(JIRAClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * connect with ZAPIClient to execution get execution id and call the update
     * result
     *
     * @param status
     * @param tc
     * @param ts
     * @param rc
     * @param proj
     * @param httpclient
     * @return
     * @throws Exception
     * @see #updateResult(int, int,
     * com.cognizant.reporting.sync.jira.JIRAHttpClient)
     */
    public int updateResult(int status, String tc, String ts, String rc,
            String proj, JIRAHttpClient httpclient) throws Exception {
        DLogger.Log("Req EID with", "Testcase : ", tc, "TestSet :", ts,
                "Release :", rc, "Project :", proj);
        int eid = ZAPIClient.getExecutionID(tc, ts, rc, proj, httpclient);
        if (eid > 0) {
            updateResult(status, eid, httpclient);
        }
        return eid;
    }

    /**
     *
     * connect with ZAPIClient to update execution(test case) result
     *
     * @param status execution status
     * @param eid execution ID
     * @param httpclient
     * @throws Exception
     */
    public void updateResult(int status, int eid, JIRAHttpClient httpclient)
            throws Exception {
        ZAPIClient.updateResult(status, eid, httpclient);
    }

    /**
     * connect with ZAPIClient to update execution(test case) attachment (report
     * )
     *
     * @param eid execution ID
     * @param toattach file to upload
     * @param httpclient
     * @return
     */
    public String addAttachment(int eid, File toattach,
            JIRAHttpClient httpclient) {
        return ZAPIClient.addAttachment(eid, toattach, httpclient);
    }

    /**
     * upload the bug from given details (using JIRA rest api)
     *
     * @param client
     * @param issue issue details to upload
     * @param attchmns dependent attachments to upload(report)
     * @return
     */
    @SuppressWarnings("unchecked")
    public JSONObject createIssue(JIRAHttpClient client, JSONObject issue,
            List<File> attchmns) {
        JSONObject res = null;
        try {
            res = client
                    .post(new URL(client.url + JIRAIssue), issue.toString());
            String issyeKey = (String) res.get("id");
            String restAttach = JIRAIssueAttach.replace("issuekey", issyeKey);
            for (File f : attchmns) {
                res.put("Attachments",
                        client.post(new URL(client.url + restAttach), f));
            }

        } catch (Exception ex) {
            Logger.getLogger(JIRAClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    /**
     * create the json data for JIRA api from map
     *
     * @param dataMap
     * @return
     */
    @SuppressWarnings("unchecked")
    public static JSONObject getJsonified(LinkedHashMap<String, String> dataMap) {
        JSONObject fields = new JSONObject();

        JSONObject project = new JSONObject();
        project.put("key", dataMap.get("project"));
        dataMap.remove("project");

        JSONObject issueType = new JSONObject();
        issueType.put("name", dataMap.get("issueType"));
        dataMap.remove("issueType");

        fields.put("project", project);
        fields.put("issuetype", issueType);

        for (String key : dataMap.keySet()) {
            JSONObject obj;
            switch (key) {
                case "priority":
                    obj = new JSONObject();
                    obj.put("name", dataMap.get(key));
                    fields.put(key, obj);
                    break;
                case "assignee":

                    obj = new JSONObject();
                    obj.put("name", dataMap.get(key));
                    fields.put(key, obj);
                    break;
                default:
                    fields.put(key, dataMap.get(key));
                    break;
            }
        }

        JSONObject data = new JSONObject();
        data.put("fields", fields);
        DLogger.Log(data);
        return data;

    }

    /**
     * check for project existence , used for test connection feature
     *
     * @param project
     * @param jc
     * @return
     */
    public boolean containsProject(String project, JIRAHttpClient jc) {

        try {
            String res = jc.Get(new URL(jc.url + "/rest/api/latest/project"))
                    .toString();
            return res.contains("\"key\":\"" + project + "\"")
                    || ZAPIClient.getProjID(project, jc) != -1;

        } catch (Exception ex) {
            Logger.getLogger(JIRAClient.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }

    public boolean isConnected(JIRAHttpClient httpclient) {
        try {
            DLogger.Log(httpclient.Get(
                    new URL(httpclient.url + "/rest/api/latest/project"))
                    .toString());
            return true;
        } catch (Exception ex) {
            Logger.getLogger(JIRAClient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
