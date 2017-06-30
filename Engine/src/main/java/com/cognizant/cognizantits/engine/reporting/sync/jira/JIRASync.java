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

import com.cognizant.cognizantits.engine.core.RunManager;
import com.cognizant.cognizantits.engine.reporting.sync.Sync;
import com.cognizant.cognizantits.engine.reporting.util.TestInfo;
import com.cognizant.cognizantits.engine.support.DLogger;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

public class JIRASync implements Sync {

    private JIRAClient conn;
    private String project = "";
    private JIRAHttpClient jc;

    public JIRASync(String server, String uname, String pass, String project) {
        this(server, uname, pass, project, null);
    }

    public JIRASync(String server, String uname, String pass, String project, Map options) {
        conn = new JIRAClient(server, uname, pass);
        this.project = project;
        jc = new JIRAHttpClient(conn.url, conn.userName, conn.password, options);
    }

    /**
     *
     * @param options
     */
    public JIRASync(Properties options) {
        this(options.getProperty("JIRAZephyrUrl"),
                options.getProperty("JIRAZephyrUserName"),
                options.getProperty("JIRAZephyrPassword"),
                options.getProperty("JIRAZephyrProject"),
                options);

    }

    @Override
    public boolean isConnected() {
        try {
            return conn.isConnected(jc) && conn.containsProject(project, jc);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            return false;
        }
    }
    private static final Logger LOG = Logger.getLogger(JIRASync.class.getName());

    @Override
    public synchronized boolean updateResults(TestInfo tc, String status,
            List<File> attach) {
        try {
            String rls = RunManager.getGlobalSettings().getRelease();
            String tset = RunManager.getGlobalSettings().getTestSet();

            int eid = conn.updateResult(getStatus("UE"), tc.testCase, tset,
                    rls, project, jc);
            if (eid > 0) {
                conn.updateResult(getStatus(status), eid, jc);
                for (File f : attach) {
                    String res = conn.addAttachment(eid, f, jc);
                    DLogger.Log(res);
                }
            } else {
                return false;
            }
            DLogger.LogE("Results updated for TestCase/Test [" + tc.testCase + "]");
            return true;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public synchronized String createIssue(JSONObject issue, List<File> attach) {
        String result = "[JIRA : Issue Creation Failed!!]\n";
        try {
            JSONObject res = conn.createIssue(jc, issue, attach);
            Object key = res.get("key");
            if (key != null) {
                result = "[JIRA : Issue " + key + " Created successfully!!]";
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            result += ex.getMessage();
        }

        return result;
    }

    private int getStatus(String status) {
        switch (status.toUpperCase()) {
            case "PASSED":
                return 1;
            case "FAILED":
                return 2;
            case "WIP":
                return 3;
            default:
                return -1;

        }

    }

    @Override
    public void disConnect() {
        conn = null;
    }

    @Override
    public String getModule() {
        return "JIRA";
    }

}
