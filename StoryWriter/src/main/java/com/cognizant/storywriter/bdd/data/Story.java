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
package com.cognizant.storywriter.bdd.data;

import static java.lang.String.format;
import static java.lang.System.lineSeparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import static java.util.regex.Pattern.compile;
import org.json.simple.JSONObject;
import static com.cognizant.storywriter.bdd.data.DS.LN;

/**
 *
 */
public class Story {

    public String type = "Feature", name, desc;
    Map<String, Object> meta;

    String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        update();
    }

    public Story(String name) {
        this(name, "");
    }

    public Story(String name, String desc) {
        this.name = name;
        this.desc = name;
        meta = new LinkedHashMap();
        data = getDefData(name, desc);
    }

    public Map meta() {
        return meta;
    }

    public void addMeta(Map meta) {
        if (meta != null) {
            this.meta.putAll(meta);
        }
    }

    @Override
    public String toString() {
        return "Feature: " + name + LN + desc + LN + data;
    }

    public JSONObject toJSON() {
        JSONObject js = new JSONObject();
        js.put("type", "Feature");
        js.put("name", name);
        js.put("desc", desc);
        js.put("data", data);
        return js;
    }

    private String getDefData(String name, String desc) {
        return format("#BDD-Feature File\n\nFeature: %s\n%s", name, desc);
    }

    public void update() {
        if (data.startsWith("Feature:")) {
            data = lineSeparator() + data;
        }
        Matcher m = compile(".*Feature: (.*)\n.*").matcher(data);
        while (m.find()) {
            name = m.group(1);
        }
    }
}
