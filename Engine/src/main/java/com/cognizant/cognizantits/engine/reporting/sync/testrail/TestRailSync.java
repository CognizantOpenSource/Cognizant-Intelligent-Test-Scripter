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

import com.cognizant.cognizantits.engine.core.RunManager;
import com.cognizant.cognizantits.engine.reporting.sync.Sync;
import com.cognizant.cognizantits.engine.reporting.util.TestInfo;
import com.cognizant.cognizantits.engine.support.DLogger;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

public class TestRailSync implements Sync {

    private static final Logger LOG = Logger.getLogger(TestRailSync.class.getName());
    private TestRailClient restClient;
    private String project;

    public TestRailSync(Properties options) throws MalformedURLException {
        this(options.getProperty("TestRailURL"), options.getProperty("Username"), options.getProperty("Password"),
                options.getProperty("Project"), options);
    }

    public TestRailSync(String url, String uname, String pwd, String project, Map options)
            throws MalformedURLException {
        restClient = new TestRailClient(url, uname, pwd, project, options);
        this.project = project;
    }

    @Override
    public String getModule() {
        return "testrail";
    }

    @Override
    public boolean isConnected() {
        try {
            return restClient.containsProject(project);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
    }

    @Override
    public boolean updateResults(TestInfo test, String status, List<File> attach) {
        try {
            String rls = RunManager.getGlobalSettings().getRelease();
            String tset = RunManager.getGlobalSettings().getTestSet();
            restClient.updateResult(getStatus(status), test.testCase, tset, rls, project, attach);
            DLogger.Log("Results updated for TestCase/Test [" + test.testCase + "]");
            return true;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return false;
    }

    @Override
    public void disConnect() {

    }

    private int getStatus(String status) {
        switch (status.toUpperCase()) {
            case "PASSED":
                return 1;
            case "BLOCKED":
                return 2;
            case "UNTESTED":
                return 3;
            case "FAILED":
                return 5;
            default:
                return -1;
        }
    }

    @Override
    public String createIssue(JSONObject issue, List<File> attach) {
        // TODO Auto-generated method stub
        return null;
    }

}
