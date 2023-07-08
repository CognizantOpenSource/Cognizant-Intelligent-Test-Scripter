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
package com.cognizant.cognizantits.engine.drivers;

import com.cognizant.cognizantits.util.encryption.Encryption;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.http.HttpClient;

public class RemoteProxy {

    public static void setProxy(Properties prop) {
        prop = decrypt(prop);

        String proxyHost = prop.getProperty("proxyHost");
        String proxyPort = prop.getProperty("proxyPort");
        String proxyUserDomain = prop.getProperty("proxyUserDomain");
        String proxyUser = prop.getProperty("proxyUser");
        String proxyPassword = prop.getProperty("proxyPassword");

        System.setProperty("http.proxyHost", proxyHost);
        System.setProperty("http.proxyPort", proxyPort);
        System.setProperty("https.proxyHost", proxyHost);
        System.setProperty("https.proxyPort", proxyPort);
        Authenticator.setDefault(new CITSAuthenticator(proxyUser, proxyPassword));

        System.setProperty("http.proxyUser", proxyUserDomain + "\\" + proxyUser);
        System.setProperty("http.proxyPassword", proxyPassword);
    }

    static class CITSAuthenticator extends Authenticator {

        String user;
        String password;

        public CITSAuthenticator(String user, String password) {
            this.user = user;
            this.password = password;
        }

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password.toCharArray());
        }

    }

    public static HttpCommandExecutor getProxyExecutor(URL url, Properties prop) {

        prop = decrypt(prop);

        String proxyHost = prop.getProperty("proxyHost");
        int proxyPort = Integer.valueOf(prop.getProperty("proxyPort"));
        String proxyUserDomain = prop.getProperty("proxyUserDomain");
        String proxyUser = prop.getProperty("proxyUser");
        String proxyPassword = prop.getProperty("proxyPassword");

        HttpClientBuilder builder = HttpClientBuilder.create();
        HttpHost proxy = new HttpHost(proxyHost, proxyPort);
        CredentialsProvider credsProvider = new BasicCredentialsProvider();

        credsProvider.setCredentials(new AuthScope(proxyHost, proxyPort),
                new NTCredentials(proxyUser, proxyPassword, getWorkstation(), proxyUserDomain));
        if (url.getUserInfo() != null && !url.getUserInfo().isEmpty()) {
            credsProvider.setCredentials(new AuthScope(url.getHost(), (url.getPort() > 0 ? url.getPort() : url.getDefaultPort())),
                    new UsernamePasswordCredentials(proxyUser, proxyPassword));
        }
        builder.setProxy(proxy);
        builder.setDefaultCredentialsProvider(credsProvider);
        //HttpClient.Factory factory = new SimpleHttpClientFactory(builder);
        HttpClient.Factory factory = new SimpleHttpClientFactory(new okhttp3.OkHttpClient.Builder());

        return new HttpCommandExecutor(new HashMap<>(), url, factory);

    }

   private static Properties decrypt(Properties prop) {
        Properties dprop = new Properties();
        dprop.putAll(prop);
        dprop.forEach((key, val) -> {
            if (val.toString().matches((".* Enc"))) {
                dprop.put(key, Encryption.getInstance().decrypt(val.toString().replace(" Enc", "")));
            }
        });
        return dprop;
    }

    private static String getWorkstation() {
        Map<String, String> env = System.getenv();

        if (env.containsKey("COMPUTERNAME")) {
            // Windows
            return env.get("COMPUTERNAME");
        } else if (env.containsKey("HOSTNAME")) {
            // Unix/Linux/MacOS
            return env.get("HOSTNAME");
        } else {
            // From DNS
            try {
                return InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException ex) {
                return "Unknown";
            }
        }
    }
}

class SimpleHttpClientFactory implements HttpClient.Factory {

    final okhttp3.OkHttpClient.Builder builder;

    public SimpleHttpClientFactory(okhttp3.OkHttpClient.Builder builder) {
        this.builder = builder;
    }

    @Override
    public org.openqa.selenium.remote.http.HttpClient createClient(URL url) {
        return new org.openqa.selenium.remote.internal.OkHttpClient(builder.build(), url);
    }

    @Override
    public HttpClient.Builder builder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cleanupIdleClients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
