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
package com.cognizant.cognizantits.ide.main.explorer.settings;

import com.cognizant.cognizantits.ide.util.data.FileScanner;
import com.cognizant.cognizantits.ide.util.logging.UILogger;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * 
 */
public class ReportingModuleSettings {

    private static final String DBNAME = "XPLOR_SETTINGS";
    public String[] fieldHeaders = {"moduleId", "fieldId", "show", "fieldName", "fieldType", "fieldValue"},
            fieldDefValues = {"", "", "", "", "", ""},
            moduleHeaders = {"moduleId"},
            moduleDefValues = {""};
    private static ReportingModuleSettings settings;
    JSONObject data;
    private static final org.slf4j.Logger LOG = UILogger.getLogger(ReportingModuleSettings.class.getName());

    public ReportingModuleSettings() {
        init();
    }

    public static ReportingModuleSettings get() {
        if (settings == null) {
            settings = new ReportingModuleSettings();
        }
        return settings;
    }

    public void init() {
        try {
            String rawData = FileScanner.readFile(new File(getFile()));
            this.data = (JSONObject) JSONValue.parse(rawData);
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
        }
    }

    /**
     * Delete the particular Module record from json data
     *
     * @param moduleId
     */
    public void cleanModule(String moduleId) {
        ((JSONObject) data.get("fields")).remove(moduleId);
    }

    /**
     * clear all the modules
     */
    public void cleanModules() {
        ((JSONArray) data.get("modules")).clear();
    }

    /**
     * Delete the particular Field record from json data
     *
     * @param moduleID
     * @param fieldId
     */
    public void DeleteField(String moduleID, String fieldId) {
        ((JSONObject) ((JSONObject) data.get("fields")).get(moduleID)).remove(fieldId);
    }

    /**
     * returns the list of modules
     *
     * @param moduleId
     * @return
     */
    public List<HashMap<String, String>> getFields(String moduleId) {
        List<HashMap<String, String>> fields = new ArrayList<>();
        JSONObject moduleData = (JSONObject) ((JSONObject) data.get("fields")).get(moduleId);
        for (Object key : moduleData.keySet()) {
            HashMap<String, String> properties = (HashMap<String, String>) moduleData.get(key);
            fields.add(properties);
        }
        return fields;
    }

    /**
     * returns the list of defect modules
     *
     * @return
     */
    public List<HashMap<String, String>> getModules() {
        List<HashMap<String, String>> fields = new ArrayList<>();
        for (Object module : (JSONArray) data.get("modules")) {
            HashMap<String, String> properties = new HashMap<>();
            for (String val : this.moduleHeaders) {
                properties.put(val, (String) module);
            }
            fields.add(properties);
        }

        return fields;
    }

    /**
     * @return the _jsonFile
     */
    public String getFile() {
        return System.getProperty("user.dir") + File.separator
                + "Configuration" + File.separator + DBNAME + ".json";
    }

    /**
     * update the fields table with new values
     *
     * @param fields
     * @param moduleId
     */
    public void updateFields(List<HashMap<String, String>> fields, String moduleId) {

        for (HashMap<String, String> properties : fields) {
            ((JSONObject) ((JSONObject) data.get("fields")).get(moduleId))
                    .put(properties.get(fieldHeaders[1]), properties);
        }
        save();
    }

    /**
     * update the modules with the new values
     *
     * @param modules
     */
    public void updateModules(List<HashMap<String, String>> modules) {
        this.cleanModules();
        for (HashMap<String, String> properties : modules) {
            ((JSONArray) data.get("modules")).add(properties.get(moduleHeaders[0]));
        }
        save();
    }

    public void save() {
        FileScanner.writeFile(new File(getFile()), data.toJSONString());
    }
}
