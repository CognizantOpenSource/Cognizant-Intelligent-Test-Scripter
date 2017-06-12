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
package com.cognizant.cognizantits.ide.main.shr.mobile.ios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.cognizant.cognizantits.ide.util.Notification;
import io.appium.java_client.ios.IOSDriver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * 
 */
public class IOSpy {

    private static IOSDriver wd;
    private static String url;
    private static final Map<String, String> caps = new HashMap<>();

    private static void startIOSSpy() {
        try {
            if (wd == null) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                for (String key : caps.keySet()) {
                    capabilities.setCapability(key, caps.get(key));
                }
                wd = new IOSDriver(new URL(url), capabilities);
            }
        } catch (Exception ex) {
            Logger.getLogger(IOSpy.class.getName()).log(Level.SEVERE, null, ex);
            Notification.show("Couldn't Connect to Device/Simulator Check Settings/Appium Logs");
        }
    }

    public static String getXML() {
        startIOSSpy();
        if (wd != null) {
            JSONObject ob = getJSONObject(url + "/session/" + wd.getSessionId() + "/source");
            return ob.get("value").toString();
        }
        return null;
    }

    public static String getScreenShot() {
        startIOSSpy();
        if (wd != null) {
            JSONObject ob = getJSONObject(url + "/session/" + wd.getSessionId() + "/screenshot");
            return ob.get("value").toString();
        }
        return null;
    }

    public static void quit() {
        if (wd != null) {
            wd.quit();
            wd = null;
        }

    }

    private static JSONObject getJSONObject(String url) {
        try {
            HttpClient client = HttpClients.createSystem();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder sb = new StringBuilder();
            String line = rd.readLine();
            while (line != null) {
                sb.append(line);
                line = rd.readLine();
            }
            return parseData(sb.toString());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(IOSpy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IOSpy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static JSONObject parseData(String value) {
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(value);
        } catch (Exception ex) {
            Logger.getLogger(IOSpy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }

    public static void setSettings(String appurl, JTable table) {
        url = appurl;
        caps.clear();
        for (int i = 0; i < table.getRowCount(); i++) {
            String key = table.getValueAt(i, 0).toString();
            Object val = table.getValueAt(i, 1);
            if (val == null || val.toString().isEmpty()) {
                continue;
            }
            caps.put(key, val.toString());
        }
    }
}
