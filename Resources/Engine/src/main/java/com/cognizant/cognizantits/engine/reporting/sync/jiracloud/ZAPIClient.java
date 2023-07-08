/**
 *
 */
package com.cognizant.cognizantits.engine.reporting.sync.jiracloud;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cognizant.cognizantits.engine.support.DLogger;
import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;

/**
 * @author 576250
 *
 */
public class ZAPIClient {

    private static final Logger LOG = Logger.getLogger(ZAPIClient.class.getName());

    private static final String ZAPI_FIELDVALUES = "/connect/public/rest/api/1.0/zql/fields/values";
    private static final String ZAPI_CLOUDURL = "https://prod-api.zephyr4jiracloud.com";
    private static String API_GET_EXECUTIONS = "{SERVER}/connect/public/rest/api/1.0/executions/search/cycle/";
    private static String API_UPDATE_EXECUTION = "{SERVER}/connect/public/rest/api/1.0/execution/";
    private static final String API_ADD_ATTACHMENT = "{SERVER}/connect/public/rest/api/1.0/attachment";

    private static int projectID = -1;
    private static int versionID = -1;
    private static String cycleID = "";
    private static Map<String, String> executionIds = new HashMap<String, String>();

    class array {

        static final String PROJ = "project", VERSIONS = "fixVersion", EXECUTIONS = "executions", CYCLE = "cycleName";
    }

    public class status {

        public static final int PASS = 1, FAIL = 2, WIP = 3, BLOCKED = 4, UNEXECUTED = -1;

    }

    @SuppressWarnings("unchecked")
    public static int getProjID(String projKey, ZephyrHttpClient client, Map options) {

        int pid = -1;
        try {
            URL projListUrl = new URL(ZAPI_CLOUDURL + ZAPI_FIELDVALUES);
            DLogger.Log("Req Project List ", projListUrl.toString());
            String jwtToken = generateJWTToken(projListUrl.toString(), options, "GET");
            JSONObject projList = client.Get(projListUrl, true, "Authorization", jwtToken);
            DLogger.Log("Looking for [", projKey, "] in", projList);
            JSONObject arr = (JSONObject) projList.get("fields");
            for (Object proj : (Iterable<? extends Object>) arr.get(array.PROJ)) {
                if (((Map<?, ?>) proj).get("name").toString().equalsIgnoreCase(projKey)) {
                    pid = Integer.valueOf(((Map<?, ?>) proj).get("id").toString());
                    break;
                }
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        projectID = pid;
        return pid;
    }

    @SuppressWarnings("unchecked")
    public static int getVersionID(String projKey, ZephyrHttpClient client, Map options) {

        int pid = -1;
        try {
            URL projListUrl = new URL(ZAPI_CLOUDURL + ZAPI_FIELDVALUES);
            DLogger.Log("Req Project List ", projListUrl.toString());
            String jwtToken = generateJWTToken(projListUrl.toString(), options, "GET");
            JSONObject projList = client.Get(projListUrl, true, "Authorization", jwtToken);
            DLogger.Log("Looking for [", projKey, "] in", projList);
            JSONObject arr = (JSONObject) projList.get("fields");
            for (Object proj : (Iterable<? extends Object>) arr.get(array.VERSIONS)) {
                if (((Map<?, ?>) proj).get("name").toString().equalsIgnoreCase(projKey)) {
                    if ((Integer.valueOf(((Map<?, ?>) proj).get("projectId").toString()) == projectID)) {
                        pid = Integer.valueOf(((Map<?, ?>) proj).get("id").toString());
                        break;
                    }

                }
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        versionID = pid;
        return pid;
    }

    @SuppressWarnings("unchecked")
    public static String getCycleId(String projKey, ZephyrHttpClient client, Map options) {

        String pid = "";
        try {
            URL projListUrl = new URL(ZAPI_CLOUDURL + ZAPI_FIELDVALUES);
            DLogger.Log("Req Project List ", projListUrl.toString());
            String jwtToken = generateJWTToken(projListUrl.toString(), options, "GET");
            JSONObject projList = client.Get(projListUrl, true, "Authorization", jwtToken);
            DLogger.Log("Looking for [", projKey, "] in", projList);
            JSONObject arr = (JSONObject) projList.get("fields");
            for (Object proj : (Iterable<? extends Object>) arr.get(array.CYCLE)) {
                if (((Map<?, ?>) proj).get("name").toString().equalsIgnoreCase(projKey)) {
                    pid = ((Map<?, ?>) proj).get("id").toString();
                    break;
                }
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        cycleID = pid;
        return pid;
    }

    private static String generateJWTToken(String url, Map options, String httpMethod) {
        ZFJCloudRestClient client = ZFJCloudRestClient
                .restBuilder(options.get("ZephyrBaseURL").toString(), options.get("AccessKey").toString(),
                        options.get("ZephyrToken").toString(), options.get("API Token").toString())
                .build();
        JwtGenerator jwtGenerator = client.getJwtGenerator();
        // API to which the JWT token has to be generated
        URI uri = null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        int expirationInSec = 360;
        return jwtGenerator.generateJWT(httpMethod, uri, expirationInSec);
    }

    public static int getExecutionID(String tc, String ts, String rc, String proj, ZephyrHttpClient client, Map options,
            int status, List<File> attach) {
        String cycleName = "";
        String executionId = "";
        int id = getProjID(proj, client, options);
        if (id > 0) {
            id = getVersionID(rc, client, options);
            if (id > 0) {
                cycleName = getCycleId(ts, client, options);
                if (id > 0) {
                    executionId = getExecutionIDByCycle(tc, projectID, versionID, cycleID, client, options, status);
                    if (!(executionId.isEmpty())) {
                        final String updateExecutionURL = API_UPDATE_EXECUTION.replace("{SERVER}", ZAPI_CLOUDURL);
                        updateExecution(updateExecutionURL, client, executionId, options, status, attach);
                    }
                }
            }
        }

        return id;
    }

    private static String getExecutionIDByCycle(String tc, int projectID2, int versionID2, String cycleID2,
            ZephyrHttpClient client, Map options, int status) {
        String executionId = "";
        final String getExecutionsUri = API_GET_EXECUTIONS.replace("{SERVER}", ZAPI_CLOUDURL) + cycleID2 + "?projectId="
                + projectID2 + "&versionId=" + versionID2;
        String jwtToken = generateJWTToken(getExecutionsUri, options, "GET");
        executionId = getExecutionsByCycleId(getExecutionsUri, client, jwtToken, tc);
        return executionId;
    }

    @SuppressWarnings("unchecked")
    private static void updateExecution(String updateExecutionURL, ZephyrHttpClient client, String key, Map options,
            int status, List<File> attach) {

        JSONObject statusObj = new JSONObject();
        statusObj.put("id", status);
        JSONObject executeTestsObj = new JSONObject();
        executeTestsObj.put("status", statusObj);
        executeTestsObj.put("cycleId", cycleID);
        executeTestsObj.put("projectId", projectID);
        executeTestsObj.put("versionId", versionID);
        executeTestsObj.put("comment", "Executed by ZAPI Cloud");

        final String updateExecutionUri = updateExecutionURL + key;
        String jwtToken = generateJWTToken(updateExecutionUri, options, "PUT");
        executeTestsObj.put("issueId", executionIds.get(key));

        updateExecutions(updateExecutionUri, client, jwtToken, executeTestsObj);

        String attachmentUri = API_ADD_ATTACHMENT.replace("{SERVER}", ZAPI_CLOUDURL) + "?issueId="
                + executionIds.get(key) + "&versionId=" + versionID + "&entityName=" + "execution" + "&cycleId="
                + cycleID + "&entityId=" + key + "&projectId=" + projectID + "&comment=comment";
        String jwtToken2 = generateJWTToken(attachmentUri, options, "POST");

        for (int i = 0; i < attach.size(); i++) {
            addAttachments(attachmentUri, client, jwtToken2, key, executionIds.get(key), attach.get(i));
        }
    }

    private static void addAttachments(String attachmentUri, ZephyrHttpClient client, String jwtToken, String key,
            String string, File filename) {
        URL attachmentUrl = null;
        try {
            attachmentUrl = new URL(attachmentUri);
        } catch (MalformedURLException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        JSONObject executionResponseObj = null;
        try {
            executionResponseObj = client.post(attachmentUrl, filename, "Authorization", jwtToken);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }

    }

    private static void updateExecutions(String updateExecutionUri, ZephyrHttpClient client, String jwtToken,
            JSONObject executeTestsObj) {

        URL updateExecutionUrl = null;
        try {
            updateExecutionUrl = new URL(updateExecutionUri);
        } catch (MalformedURLException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        JSONObject executionResponseObj = null;
        try {
            executionResponseObj = client.put(updateExecutionUrl, executeTestsObj.toString(), "Authorization",
                    jwtToken);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        String executionStatus = "No Test Executed";
        JSONObject descriptionResponseObj = (JSONObject) executionResponseObj.get("execution");
        JSONObject statusResponseObj = (JSONObject) descriptionResponseObj.get("status");
        executionStatus = (String) statusResponseObj.get("description");
    }

    private static String getExecutionsByCycleId(String getExecutionsUri, ZephyrHttpClient client, String jwtToken,
            String tc) {

        String executionId = "";
        URL getExecutionsUrl = null;
        try {
            getExecutionsUrl = new URL(getExecutionsUri);
        } catch (MalformedURLException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }

        JSONObject allIssues = null;
        try {
            allIssues = client.Get(getExecutionsUrl, true, "Authorization", jwtToken);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        JSONArray IssuesArray = (JSONArray) allIssues.get("searchObjectList");

        if (IssuesArray.size() == 0) {
            return executionId;
        }
        for (int j = 0; j <= IssuesArray.size() - 1; j++) {
            JSONObject jobj = (JSONObject) IssuesArray.get(j);
            if (jobj.get("issueSummary").toString().equalsIgnoreCase(tc)) {
                JSONObject jobj2 = (JSONObject) jobj.get("execution");
                executionId = (String) jobj2.get("id");
                long IssueId = (long) jobj2.get("issueId");
                executionIds.put(executionId, String.valueOf(IssueId));
            }
        }
        return executionId;
    }

}
