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
package com.cognizant.cognizantits.ide.main.utils.recentItem;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "projectName",
    "location"
})
public class RecentItem {

    @JsonProperty("projectName")
    private String projectName;
    @JsonProperty("location")
    private String location;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public RecentItem() {
    }

    /**
     *
     * @param location
     * @param projectName
     */
    public RecentItem(String projectName, String location) {
        this.projectName = projectName;
        this.location = location;
    }

    /**
     *
     * @return The projectName
     */
    @JsonProperty("projectName")
    public String getProjectName() {
        return projectName;
    }

    /**
     *
     * @param projectName The projectName
     */
    @JsonProperty("projectName")
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     *
     * @return The location
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location The location
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return projectName + " - " + location;
    }

}
