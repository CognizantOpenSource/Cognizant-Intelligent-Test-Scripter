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
package com.cognizant.cognizantits.gridnode.GridController;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONWriter;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author 499538
 */

import org.json.simple.parser.ParseException;

public class ParseJSON {

    final String jsonFile = "nodeconfig.json";
    private static String jsonString;
    JSONParser parser = new JSONParser();

    public ArrayList<Browsers> getBrData() {
        try {
            if (new File(jsonFile).exists()) {
                Object obj = parser.parse(new FileReader(jsonFile));
                JSONObject jsonObject = (JSONObject) obj;
                JSONArray caps = (JSONArray) jsonObject.get("capabilities");
                Iterator<JSONObject> iterator = caps.iterator();
                ArrayList<Browsers> brList = new ArrayList<>();
                while (iterator.hasNext()) {
                    JSONObject objt = iterator.next();
                    brList.add(new Browsers(objt.get("browserName").toString(), objt.get("maxInstances").toString()));
                }
                return brList;
            }
        } catch (IOException | ParseException ex) {
            Logger.getLogger(ParseJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String readJSON() {
        try {
            Object obj = parser.parse(new FileReader(jsonFile));
            JSONObject jsonObject = (JSONObject) obj;
            jsonString = JSONWriter.getJSONString(jsonObject);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(ParseJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonString;
    }

    public void saveJson(ArrayList<Browsers> data, String svrIP, String srvPort, long clientPort, long mxBrInst) {
        JSONObject mainObj = new JSONObject();
        JSONArray capList = new JSONArray();
        for (int i = 0; i < data.size(); i++) {
            if (!data.get(i).getBrowser().isEmpty() && !data.get(i).getMaxInst().isEmpty()) {
                JSONObject cap = new JSONObject();
                cap.put("browserName", data.get(i).getBrowser());
                cap.put("maxInstances", Long.parseLong(data.get(i).getMaxInst()));
                cap.put("seleniumProtocol", "WebDriver");
                capList.add(cap);
            } else {
                Logger.getLogger(ParseJSON.class.getName()).log(Level.WARNING, "The empty browser fields in the table won't be saved!", "");
            }
        }
        mainObj.put("capabilities", capList);
        mainObj.put("proxy", "org.openqa.grid.selenium.proxy.DefaultRemoteProxy");
        mainObj.put("maxSession", mxBrInst);
        mainObj.put("port", clientPort);
        mainObj.put("register", true);
        mainObj.put("registerCycle", 5000);
        mainObj.put("hub", "http://" + svrIP + ":" + srvPort);

        try ( FileWriter file = new FileWriter(jsonFile)) {
            file.write(JSONWriter.getJSONString(mainObj));
            file.flush();
        } catch (IOException ex) {
            Logger.getLogger(ParseJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveTA(String ta) {
        try ( FileWriter file = new FileWriter(jsonFile)) {
            if (!ta.trim().isEmpty()) {
                file.write(ta);
            } else {
                file.write(jsonString);
            }
            file.flush();
        } catch (IOException ex) {
            Logger.getLogger(ParseJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
