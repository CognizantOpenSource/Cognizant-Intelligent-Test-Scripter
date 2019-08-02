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

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.HttpGet;

import com.cognizant.cognizantits.engine.reporting.sync.BasicHttpClient;

public class TestRailHttpClient extends BasicHttpClient {

    private Map<String, String> OPTIONS = new HashMap<String, String>();

    public TestRailHttpClient(URL url, String userName, String password, Map<String, String> config) {
        super(url, userName, password, config);
        OPTIONS = config;
    }

    @Override
    public void setHeader(HttpGet httpget) {
        httpget.setHeader("username", OPTIONS.get("Username").toString());
        httpget.setHeader("password", OPTIONS.get("Password").toString());
        httpget.setHeader("Content-Type", "application/json");
    }

}
