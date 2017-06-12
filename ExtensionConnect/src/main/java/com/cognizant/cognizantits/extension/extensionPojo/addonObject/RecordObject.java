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
package com.cognizant.cognizantits.extension.extensionPojo.addonObject;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "action",
    "method",
    "input",
    "type",
    "page",
    "prop",
    "frame",
    "objectname"
})
public class RecordObject {

    @JsonProperty("action")
    private String action;
    @JsonProperty("method")
    private String method;
    @JsonProperty("input")
    private String input;
    @JsonProperty("type")
    private String type;
    @JsonProperty("page")
    private Page page;
    @JsonProperty("prop")
    private List<Prop> prop;
    @JsonProperty("frame")
    private Object frame;
    @JsonProperty("objectname")
    private String objectname;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    /**
     *
     * @return The method
     */
    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    /**
     *
     * @param method The method
     */
    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     *
     * @return The input
     */
    @JsonProperty("input")
    public String getInput() {
        return input;
    }

    /**
     *
     * @param input The input
     */
    @JsonProperty("input")
    public void setInput(String input) {
        this.input = input;
    }

    /**
     *
     * @return The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     *
     * @param type The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return The page
     */
    @JsonProperty("page")
    public Page getPage() {
        return page;
    }

    /**
     *
     * @param page The page
     */
    @JsonProperty("page")
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     *
     * @return The prop
     */
    @JsonProperty("prop")
    public List<Prop> getProp() {
        return prop;
    }

    /**
     *
     * @param prop The prop
     */
    @JsonProperty("prop")
    public void setProp(List<Prop> prop) {
        this.prop = prop;
    }

    /**
     *
     * @return The frame
     */
    @JsonProperty("frame")
    public Object getFrame() {
        return frame;
    }

    /**
     *
     * @param frame The frame
     */
    @JsonProperty("frame")
    public void setFrame(Object frame) {
        this.frame = frame;
    }

    /**
     *
     * @return The objectname
     */
    @JsonProperty("objectname")
    public String getObjectname() {
        return objectname;
    }

    /**
     *
     * @param objectname The objectname
     */
    @JsonProperty("objectname")
    public void setObjectname(String objectname) {
        this.objectname = objectname;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
