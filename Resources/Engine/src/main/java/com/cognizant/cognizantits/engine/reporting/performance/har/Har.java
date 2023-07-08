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
package com.cognizant.cognizantits.engine.reporting.performance.har;

import com.cognizant.cognizantits.engine.reporting.TestCaseReport;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * har helper api for json storage
 *
 * 
 * @param <K> key
 * @param <Log> log entry
 * 
 * @see https://dvcs.w3.org/hg/webperf/raw-file/tip/specs/HAR/Overview.html
 */
@SuppressWarnings("unchecked")
public class Har<K, V> extends JSONObject {
    
    private static final long serialVersionUID = 1L;
    private final Log log;
    public Map<Object, Object> raw;
    
    public Har() {
        log = new Log();
        put("log", log);
        raw = new LinkedHashMap<>();
    }
    
    public void addRaw(java.lang.String pt, java.lang.String rt) {
        raw.put(JSONValue.parse(pt), JSONValue.parse(rt));
    }
    
    public void addPage(Page p) {
        log.pages.add(p);
        addEntry(getPageEntry(p));
    }
    
    public int pages() {
        return log.pages.size();
    }
    
    public Log log() {
        return log;
    }
    
    public void addEntry(com.cognizant.cognizantits.engine.reporting.performance.har.Entry e) {
        log.entries.add(e);
    }
    
    private com.cognizant.cognizantits.engine.reporting.performance.har.Entry getPageEntry(Page p) {
        return new com.cognizant.cognizantits.engine.reporting.performance.har.Entry(p);
    }
    
    public void updateConfig(TestCaseReport testCaseReport, java.lang.String pageName, int index) {
        put("config", Prop.getConfig(testCaseReport, pageName, index));
    }
    
    public void updateMetrics(StringBuilder b) {
        put("metrics", b);
    }
    
    public Object getMetrics() {
        return get("metrics");
    }
    
    public void removeMetrics() {
        remove("metrics");
    }
    
    public class Log extends JSONObject {
        
        private static final long serialVersionUID = 1L;
        public final JSONArray pages;
        public final JSONArray entries;
        
        public Log() {
            pages = new JSONArray();
            entries = new JSONArray();
            put("version", Prop.version);
            put("creator", Prop.creator);
            put("pages", pages);
            put("entries", entries);
        }
        
        public JSONArray pages() {
            return pages;
        }
    }
    
}

@SuppressWarnings("unchecked")
class Prop {
    
    public static String version = "1.2";
    public static Creator creator = new Creator();
    
    static class Creator extends JSONObject {
        
        private static final long serialVersionUID = 1L;
        
        public Creator() {
            put("name", System.getProperty("user.name"));
            put("version", "<version>");
        }
    }
    
    public static Object getEmpty() {
        return new JSONObject();
    }
    
    public static JSONArray getEmptyArray() {
        return new JSONArray();
    }
    
    public static Object getConfig(TestCaseReport r, String pageName, int index) {
        
        Map<String, Object> conf = new JSONObject();
        conf.put("name", pageName);
        conf.put("index", index);
        conf.put("testcase", r.TestCase);
        conf.put("scenario", r.TestCase);
        conf.put("iteration", r.getIter());
        conf.put("version", r.getDriver().getBrowserVersion());
        conf.put("browser", r.getDriver().getCurrentBrowser());
        conf.put("platform", r.getDriver().getPlatformName());
        conf.put("driver", r.getDriver().getDriverName(r.getDriver().getCurrentBrowser()));
        return conf;
    }
;
}
