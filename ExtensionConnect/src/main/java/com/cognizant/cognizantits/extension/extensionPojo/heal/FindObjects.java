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
package com.cognizant.cognizantits.extension.extensionPojo.heal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "objects",
    "action"
})
public class FindObjects {

    @JsonProperty("objects")
    private List<HealObject> objects = new ArrayList<HealObject>();
    @JsonProperty("action")
    private String action = "find";
    @JsonIgnore
    private Map<String, java.lang.Object> additionalProperties = new HashMap<String, java.lang.Object>();

    /**
     *
     * @return The objects
     */
    @JsonProperty("objects")
    public List<HealObject> getObjects() {
        return objects;
    }

    /**
     *
     * @param objects The objects
     */
    @JsonProperty("objects")
    public void setObjects(List<HealObject> objects) {
        this.objects = objects;
    }

    /**
     *
     * @return The action
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     *
     * @param action The action
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    @JsonAnyGetter
    public Map<String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

}
