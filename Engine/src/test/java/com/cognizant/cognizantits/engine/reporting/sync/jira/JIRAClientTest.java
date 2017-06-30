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
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class JIRAClientTest {

    @Test(enabled = false)
    public void testUpdateResult_0args() throws Exception {
        JIRAClient jc = new JIRAClient(Data.server, Data.uname, Data.pass);
        String f = "report.txt";
        JIRAHttpClient httpclient = new JIRAHttpClient(jc.url, Data.uname, Data.pass, null);
        int eid = jc.updateResult(ZAPIClient.status.UNEXECUTED, "buyProduct",
                "TestSet_Demo", "Release_Demo", "DemonProject", httpclient);
        jc.updateResult(ZAPIClient.status.PASS, eid, httpclient);
        String out = jc.addAttachment(eid, new File(f), httpclient);
        DLogger.Log(out);
    }

    @Test(enabled = false)
    public void testCreateIssue_JSONObject_List() {
        JSONObject res = null;
        try {
            JIRAClient jc = new JIRAClient(Data.server, Data.uname, Data.pass);
            JIRAHttpClient httpclient = new JIRAHttpClient(
                    jc.url, Data.uname, Data.pass, null);
            Map issue = getIssue(Data.project);
            List<File> attach = null;
            res = jc.createIssue(httpclient, (JSONObject) issue, attach);
        } catch (Exception ex) {
            Logger.getLogger(JIRAClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static JSONObject getIssue(String proj) {
        JSONObject fields = new JSONObject();

        JSONObject project = new JSONObject();
        project.put("key", proj);

        JSONObject issueType = new JSONObject();
        issueType.put("name", "Test");

        JSONObject priority = new JSONObject();
        priority.put("name", "Critical");
        fields.put("project", project);
        fields.put("summary", "api test ");
        fields.put("description", "desc");
        fields.put("issuetype", issueType);
        fields.put("priority", priority);
        fields.put("environment", "WIN 7 32 bit chrome 36");

        JSONObject data = new JSONObject();
        data.put("fields", fields);
        return data;
    }

    public static class Data {

        public static String server = "https://jira.domain.com",
                uname = "user", pass = "pass", project = "STJZI";

    }
}
