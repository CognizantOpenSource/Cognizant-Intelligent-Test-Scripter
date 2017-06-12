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
package com.cognizant.cognizantits.engine.reporting.sync;

import com.cognizant.cognizantits.engine.support.DLogger;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BasicHttpClient {

    public URL url;

    CloseableHttpClient client;
    HttpContext context;
    /**
     * false - if the server has untrusted SSL (accept all cert) true - for
     * default system keystore
     */
    boolean trusted = false;
    UsernamePasswordCredentials creds;

    public BasicHttpClient(URL urL, String userName, String password) {
        url = urL;
        client = trusted ? getClient() : getCustomClient();
        try {
            context = getContext(url.toURI(), (creds = new UsernamePasswordCredentials(userName, password)));
        } catch (Exception ex) {
            Logger.getLogger(BasicHttpClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HttpHost getProxy() {
        return new HttpHost(System.getProperties().getProperty("http.proxyHost", proxyHost()),
                Integer.valueOf(System.getProperties().getProperty("http.proxyPort", proxyPort())));
    }

    public String proxyHost() {
        return "proxy.cognizant.com";
    }

    public String proxyPort() {
        return "6050";
    }

    public boolean hasProxy() {
        return true;
    }

    /**
     * returns systen Def client
     *
     * @return
     */
    final CloseableHttpClient getClient() {
        return HttpClients.createSystem();
    }

    /**
     * custom http client for server with SSL errors
     *
     * @return
     */
    final CloseableHttpClient getCustomClient() {
        try {
            HttpClientBuilder builder = HttpClientBuilder.create();
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    return true;
                }
            }).build();
            builder.setSSLContext(sslContext);
            HostnameVerifier hostnameVerifier = new NoopHostnameVerifier();
            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslSocketFactory)
                    .build();
            PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            builder.setConnectionManager(connMgr);
            return builder.build();
        } catch (Exception ex) {
            Logger.getLogger(BasicHttpClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getClient();
    }

    /**
     * execute the given URI request
     *
     * @param req
     * @return
     * @throws Exception
     */
    public CloseableHttpResponse execute(HttpUriRequest req) throws Exception {
        DLogger.Log(req.toString());
        if (hasProxy()) {
            ((HttpRequestBase) req).setConfig(RequestConfig.custom().setProxy(getProxy()).build());
        }
        return client.execute(req, context);
    }

    private HttpContext getContext(URI uri,
            UsernamePasswordCredentials creds) throws Exception {
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(uri.getHost(), uri.getPort()),
                creds);
        org.apache.http.HttpHost host = new org.apache.http.HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        AuthCache authCache = new BasicAuthCache();
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(host, basicAuth);
        HttpClientContext context1 = HttpClientContext.create();
        context1.setCredentialsProvider(credsProvider);
        context1.setAuthCache(authCache);
        return context1;
    }

    /**
     * custom header for respective client
     *
     * @param httppost
     */
    public void setHeader(HttpPost httppost) {
        httppost.addHeader("Accept", "application/json");
    }

    /**
     * custom header for respective client
     *
     * @param httppatch
     */
    public void setHeader(HttpPatch httppatch) {

    }

    /**
     * custom header for respective client
     *
     * @param httpGet
     */
    public void setHeader(HttpGet httpGet) {
        httpGet.addHeader("Accept", "application/json");
    }

    /**
     * custom header for respective client
     *
     * @param httpput
     */
    public void setHeader(HttpPut httpput) {
        httpput.addHeader("Accept", "application/json");
    }

    public void auth(HttpRequest req) throws AuthenticationException {
        req.addHeader(new BasicScheme().authenticate(creds, req, context));

    }

    /**
     * Http Post request for given data as JSON string
     *
     * @param targetUrl
     * @param jsonStr
     * @return
     * @throws Exception
     */
    public JSONObject put(URL targetUrl, String data) throws Exception {
        HttpPut httpput = new HttpPut(targetUrl.toURI());
        setHeader(httpput);
        setPutEntity(data, httpput);
        auth(httpput);
        HttpResponse response = execute(httpput);
        return parseResponse(response);

    }

    public void setPutEntity(String xmlstr, HttpPut httpput) throws UnsupportedEncodingException {
        StringEntity input = new StringEntity(xmlstr);
        if (xmlstr != null && !xmlstr.isEmpty()) {
            input.setContentType("application/json");
        }
        httpput.setEntity(input);
    }

    /**
     * Http Post request for uploading files
     *
     * @param targetUrl
     * @param toUplod
     * @return
     * @throws Exception
     */
    public JSONObject post(URL targetUrl, File toUplod) throws Exception {
        HttpPost httppost = new HttpPost(targetUrl.toURI());
        setHeader(httppost);
        auth(httppost);
        setPostEntity(toUplod, httppost);
        return doPost(httppost);
    }

    /**
     * Http Post request for uploading files
     *
     * @param targetUrl
     * @param data
     * @param toUplod
     * @return
     * @throws Exception
     */
    public JSONObject post(URL targetUrl, String data, File toUplod) throws Exception {
        HttpPost httppost = new HttpPost(targetUrl.toURI());
        setHeader(httppost);
        auth(httppost);
        setPostEntity(data, toUplod, httppost);
        return doPost(httppost);
    }

    public void setPostEntity(File toUplod, HttpPost httppost) {
        final MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("file", toUplod,
                ContentType.APPLICATION_OCTET_STREAM, toUplod.getName());
        httppost.setEntity(builder.build());
    }

    public void setPostEntity(String data, File file, HttpPost httppost) {
        final MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("file", file, ContentType.APPLICATION_OCTET_STREAM, file.getName());
        builder.addTextBody("body", data, ContentType.APPLICATION_XML);
        httppost.setEntity(builder.build());
    }

    /**
     * Http Post request for given data as JSON string
     *
     * @param targetUrl
     * @param payload
     * @return
     * @throws Exception
     */
    public JSONObject post(URL targetUrl, String payload) throws Exception {
        HttpPost httppost = new HttpPost(targetUrl.toURI());
        setHeader(httppost);
        setPostEntity(payload, httppost);
        return doPost(httppost);
    }

    public JSONObject patch(URL targetUrl, String payload) throws Exception {
        HttpPatch httppatch = new HttpPatch(targetUrl.toURI());
        setHeader(httppatch);
        setPatchEntity(payload, httppatch);
        return doPatch(httppatch);
    }

    protected JSONObject doPost(HttpPost httppost) throws Exception {
        HttpResponse response = execute(httppost);
        return parseResponse(response);
    }

    protected JSONObject doPatch(HttpPatch httppatch) throws Exception {
        HttpResponse response = execute(httppatch);
        return parseResponse(response);
    }

    public void setPostEntity(String jsonStr, HttpPost httppost) throws UnsupportedEncodingException {
        StringEntity input = new StringEntity(jsonStr);
        input.setContentType("application/json");
        httppost.addHeader("accept", "application/json");
        httppost.setEntity(input);
    }

    public void setPatchEntity(String jsonStr, HttpPatch httppatch) throws UnsupportedEncodingException {
        StringEntity input = new StringEntity(jsonStr);
        input.setContentType("application/json");
        httppatch.setEntity(input);
    }

    /**
     * Http Get request for given url
     *
     * @param targetUrl
     * @return
     * @throws Exception
     */
    public JSONObject Get(URL targetUrl) throws Exception {
        return Get(targetUrl.toURI());
    }

    public JSONObject Get(URL targetUrl, String key, String val) throws Exception {
        URIBuilder builder = new URIBuilder(targetUrl.toString());
        builder.setParameter(key, val);
        return Get(builder.build());
    }

    /**
     * Http Get request for given params as JSON string
     *
     * @param targetUrl
     * @param jsonStr
     * @return
     * @throws Exception
     */
    public JSONObject Get(URL targetUrl, String jsonStr) throws Exception {
        URIBuilder builder = new URIBuilder(targetUrl.toString());
        setParams(builder, jsonStr);
        return Get(setParams(builder, jsonStr).build());
    }

    public JSONObject Get(URI uri) throws Exception {
        HttpGet httpGet = new HttpGet(uri);
        setHeader(httpGet);
        auth(httpGet);
        HttpResponse response = execute(httpGet);
        return parseResponse(response);
    }

    /**
     * Parse http response as JSON
     *
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public JSONObject parseResponse(HttpResponse response) throws Exception {
        HttpEntity entity = response.getEntity();
        String resp = "";
        try {
            if (entity != null) {
                resp = EntityUtils.toString(entity);
                JSONParser parser = new JSONParser();
                Object data = parser.parse(resp);
                JSONObject jobj;
                if (data instanceof JSONObject) {
                    jobj = (JSONObject) data;
                } else {
                    jobj = new JSONObject();
                    jobj.put("array", (JSONArray) data);
                }
                EntityUtils.consume(entity);
                return jobj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            DLogger.Log("Unknown Response : ", resp);
            Logger.getLogger(BasicHttpClient.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        }
    }

    /**
     * Builds URL params from input JSON string
     *
     * @param builder
     * @param jsonStr
     * @return
     * @throws ParseException
     */
    private URIBuilder setParams(URIBuilder builder, String jsonStr) throws ParseException {

        if (jsonStr != null && !"".equals(jsonStr)) {
            try {
                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(jsonStr);

                for (Object Key : json.keySet()) {
                    builder.setParameter(Key.toString(), (String) json.get(Key));
                }

            } catch (Exception ex) {
                DLogger.LogE(ex.getMessage());
                Logger.getLogger(BasicHttpClient.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return builder;
    }

}
