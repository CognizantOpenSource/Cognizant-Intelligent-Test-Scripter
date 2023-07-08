package com.cognizant.cognizantits.engine.reporting.sync.jiracloud;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

import com.cognizant.cognizantits.engine.core.RunManager;
import com.cognizant.cognizantits.engine.reporting.sync.Sync;
import com.cognizant.cognizantits.engine.reporting.sync.jira.JIRASync;
import com.cognizant.cognizantits.engine.reporting.util.TestInfo;
import com.cognizant.cognizantits.engine.support.DLogger;

/**
 * @author 576250
 *
 */
public class JIRACloudSync implements Sync {

    private static final Logger LOG = Logger.getLogger(JIRASync.class.getName());
    private JIRACloudClient restClient;
    private String project;

    public JIRACloudSync(JIRACloudClient restClient, String project) {
        super();
        this.restClient = restClient;
        this.project = project;
    }

    public JIRACloudSync(String jiraUrl, String username, String password, String project, Map options)
            throws MalformedURLException {
        restClient = new JIRACloudClient(jiraUrl, username, password, options);
        this.project = project;
    }

    public JIRACloudSync(Properties options) throws MalformedURLException {
        this(options.getProperty("JiraBaseURL"), options.getProperty("Username"), options.getProperty("API Token"),
                options.getProperty("project"), options);
    }

    @Override
    public String getModule() {
        return "jiraoncloud";
    }

    @Override
    public boolean isConnected() {
        try {
            return restClient.isConnected() && restClient.containsProject(project);
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
            int eid = restClient.updateResult(getStatus(status), test.testCase, tset, rls, project, attach);
            DLogger.LogE("Results updated for TestCase/Test [" + test.testCase + "]");
            return true;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return false;
    }

    @Override
    public String createIssue(JSONObject issue, List<File> attach) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void disConnect() {
        // TODO Auto-generated method stub

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

}
