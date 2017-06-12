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
 */
package com.cognizant.cognizantits.ide.util.data;

import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * 
 */
public class JSONProvider {

    public static String getJSONString(Map<String, String> map) {
        return JSONObject.toJSONString(map);
    }

    public static Map<String, String> getJSONMap(String json) {        
        return (Map<String, String>) JSONValue.parse(json);
    }

}
