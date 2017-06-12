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

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;
import org.json.simple.JSONObject;
import static org.json.simple.JSONValue.parse;
import static com.cognizant.storywriter.util.SLogger.LOGE;
import static com.cognizant.storywriter.util.Tools.readFile;
import static com.cognizant.storywriter.util.Tools.writeFile;

/**
 *
 */
public class BDDProject {

    File dataFile;
    String name;
    String desc;
    List<Story> stories;

    private BDDProject(File dataFile) {
        this.dataFile = dataFile;
    }

    private BDDProject(String name, String desc) {
        this.name = name;
        this.desc = desc;
        stories = new ArrayList<>();
    }
    private BDDProject load() {
        try {
            JSONObject data = (JSONObject) parse(readFile(dataFile));
            this.name = (String) data.get("name");
            this.desc = (String) data.get("desc");
            stories = read(getDataList(data.get("data")));
        } catch (Exception ex) {
            LOGE(ex.getMessage());
        }
        return this;
    }

    public static BDDProject load(File dataFile) {      
        return new BDDProject(dataFile).load();
    }

    public List<Story> read(List<Object> datalist) {
        return (List<Story>) datalist.stream()
                .map(this::toStory)
                .collect(toList());
    }

    private ArrayList getDataList(Object data) {
        return data != null ? (ArrayList) data : new ArrayList<>();
    }

    private Story toStory(Object obj) {
        Map storyobj = (Map) obj;
        Story st = new Story((String) storyobj.get("name"));
        st.addMeta((Map) storyobj.get("meta"));
        st.setData((String) storyobj.get("data"));
        return st;
    }

    public JSONObject getProject() {
        JSONObject project = new JSONObject();
        project.put("name", name);
        project.put("desc", desc);        
        project.put("data", stories.stream()
                .map(story->story.toJSON()).collect(toList()));
        return project;
    }

    public List<Story> getStories() {
        return stories;
    }

    public static void create(File f, String name, String text) {
        writeFile(f, new BDDProject(name, text).getProject().toJSONString());
    }

    public void write() {
        writeFile(dataFile, getProject().toJSONString());
    }

    public boolean hasStories() {
        return stories != null && !stories.isEmpty();
    }

}
