/**
 *
 */
package com.cognizant.cognizantits.engine.reporting.sync.jiracloud;

import java.net.URL;
import java.util.Map;

import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.json.simple.JSONObject;

import com.cognizant.cognizantits.engine.reporting.sync.BasicHttpClient;

/**
 * @author 576250
 *
 */
public class JiraCloudHttpClient extends BasicHttpClient {

    final String encodedToken;

    public JiraCloudHttpClient(URL url, String userName, String apiToken, Map<String, String> config) {
        super(url, userName, apiToken, config);
        encodedToken = java.util.Base64.getEncoder().encodeToString((userName + ":" + apiToken).getBytes());
    }

    @Override
    public void setHeader(HttpPost httppost) {
        httppost.setHeader("X-Atlassian-Token", "nocheck");
    }

    @Override
    public void setHeader(HttpGet httpget) {
        httpget.setHeader("Authorization", "Basic " + encodedToken);
        httpget.setHeader("Accept", "application/json");
    }

    @Override
    public void auth(HttpRequest req) throws AuthenticationException {
    }

    @Override
    public JSONObject Get(URL targetUrl) throws Exception {
        HttpGet httpGet = new HttpGet(targetUrl.toURI());
        setHeader(httpGet);
        return parseResponse(doGet(httpGet));
    }

}
