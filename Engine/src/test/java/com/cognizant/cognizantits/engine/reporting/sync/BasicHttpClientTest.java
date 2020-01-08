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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.simple.JSONObject;
import static org.testng.Assert.*;
import org.testng.annotations.*;

public class BasicHttpClientTest {

    private JSONObject getArgs;
    private static final int PORT = 3210;
    
    public BasicHttpClientTest() throws Exception {

    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        getArgs = new JSONObject();
        getArgs.put("data", "vola");
        getArgs.put("empty", "");
        getArgs.put("special", "^\\d{5,}$");
    }

    /**
     * Test of Get method, of class BasicHttpClient.
     * @throws java.lang.Exception
     */
    @Test(enabled = false,description = "http-get of remote address")
    public void testGetHttp() throws Exception {
        System.out.println("Get-http");
        URL targetUrl = new URL("http://postman-echo.com/get");
        BasicHttpClient instance = new BasicHttpClient(targetUrl, "anon", "anon");        
        JSONObject result = instance.Get(targetUrl, getArgs.toJSONString());
        assertEquals(result.get("args"), getArgs);
    }

    /**
     * Test of Get method, of class BasicHttpClient.
     * @throws java.lang.Exception
     */
    @Test(enabled = false,description = "https-get of remote address")
    public void testGetHttps() throws Exception {
        System.out.println("Get-https");
        URL targetUrl = new URL("https://postman-echo.com/get");
        BasicHttpClient instance = new BasicHttpClient(targetUrl, "anon", "anon");
        JSONObject result = instance.Get(targetUrl, getArgs.toJSONString());
        assertEquals(result.get("args"), getArgs);
    }

    /**
     * Test of Get method, of class BasicHttpClient.
     * @throws java.lang.Exception
     */
    @Test(enabled = false,description = "http-get of local address")
    public void testGetHttpLocal() throws Exception {
        System.out.println("Get-http-local");
        URL targetUrl = new URL("http://127.0.0.1:" + PORT);
        BasicHttpClient instance = new BasicHttpClient(targetUrl, "anon", "anon");        
        JSONObject result = instance.Get(targetUrl, "data", "vola");
        assertEquals(result.toString(), "{\"data\":\"vola\"}");
    }

}
