package com.cognizant.cognizantits.engine.reporting.sync.jiracloud;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cognizant.cognizantits.engine.reporting.sync.jiracloud.JiraCloudHttpClient;
import com.cognizant.cognizantits.engine.reporting.sync.jiracloud.ZAPIClient;
import com.cognizant.cognizantits.engine.reporting.sync.jiracloud.ZephyrHttpClient;
import com.cognizant.cognizantits.engine.support.DLogger;

/**
 * @author 576250
 *
 */
public class JIRACloudClient {

    private static final Logger LOG = Logger.getLogger(JIRACloudClient.class.getName());

    private final JiraCloudHttpClient client;
    private final ZephyrHttpClient zclient;
    private Map OPTIONS = new HashMap();
    public static final String PROJECT = "rest/api/latest/project";

    public JIRACloudClient(String urlStr, String userName, String password, Map options)
            throws MalformedURLException {
        client = new JiraCloudHttpClient(toURL(urlStr), userName, password, options);
        zclient = new ZephyrHttpClient(toURL(urlStr), userName, password, options);
        OPTIONS = options;
    }

    private static URL toURL(String url) throws MalformedURLException {
        if (!url.endsWith("/")) {
            url = url.concat("/");
        }
        return new URL(url);
    }

    /**
     * check for project existence , used for test connection feature
     *
     * @param project
     * @return
     */
    public boolean containsProject(String project) {
        try {
            String res = client.Get(new URL(client.url + PROJECT)).toString();
            return res.contains("\"name\":\"" + project + "\"");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
    }

    public boolean isConnected() {
        try {
            DLogger.Log(client.Get(new URL(client.url + PROJECT)).toString());
            return true;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
    }

    public int updateResult(int status, String tc, String ts, String rc, String proj, List<File> attach) {
        DLogger.Log("Req EID with", "Testcase : ", tc, "TestSet :", ts,
                "Release :", rc, "Project :", proj);
        int eid = ZAPIClient.getExecutionID(tc, ts, rc, proj, zclient, OPTIONS, status, attach);
        return eid;
    }

}
