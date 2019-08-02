/**
 *
 */
package com.cognizant.cognizantits.engine.reporting.sync.jiracloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

import com.cognizant.cognizantits.engine.reporting.sync.BasicHttpClient;

/**
 * @author 576250
 *
 */
public class ZephyrHttpClient extends BasicHttpClient {

    private Map<String, String> OPTIONS = new HashMap<String, String>();

    public ZephyrHttpClient(URL url, String userName, String password, Map<String, String> config) throws MalformedURLException {
        super(new URL(config.get("ZephyrBaseURL")), userName, password, config);
        OPTIONS = config;
    }

    @Override
    public void setHeader(HttpGet httpget) {
        httpget.setHeader("zapiAccessKey", OPTIONS.get("AccessKey"));
        httpget.setHeader("Content-Type", "application/json");
    }

    @Override
    public void setHeader(HttpPut httput) {
        httput.setHeader("zapiAccessKey", OPTIONS.get("AccessKey"));
        httput.setHeader("Content-Type", "application/json");
    }

    @Override
    public void setHeader(HttpPost httppost) {
        httppost.setHeader("zapiAccessKey", OPTIONS.get("AccessKey"));
    }

}
