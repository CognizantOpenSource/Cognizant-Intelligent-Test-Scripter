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
    "prop",
    "objectname",
    "pageName",
    "frame"
})
public class HealObject {

    @JsonProperty("prop")
    private List<Prop> prop = new ArrayList<Prop>();
    @JsonProperty("objectname")
    private String objectname;
    @JsonProperty("pageName")
    private String pageName;
    @JsonProperty("frame")
    private String frame;
    @JsonIgnore
    private Map<String, java.lang.Object> additionalProperties = new HashMap<String, java.lang.Object>();

    /**
     * 
     * @return
     *     The prop
     */
    @JsonProperty("prop")
    public List<Prop> getProp() {
        return prop;
    }

    /**
     * 
     * @param prop
     *     The prop
     */
    @JsonProperty("prop")
    public void setProp(List<Prop> prop) {
        this.prop = prop;
    }

    /**
     * 
     * @return
     *     The objectname
     */
    @JsonProperty("objectname")
    public String getObjectname() {
        return objectname;
    }

    /**
     * 
     * @param objectname
     *     The objectname
     */
    @JsonProperty("objectname")
    public void setObjectname(String objectname) {
        this.objectname = objectname;
    }

    /**
     * 
     * @return
     *     The pageName
     */
    @JsonProperty("pageName")
    public String getPageName() {
        return pageName;
    }

    /**
     * 
     * @param pageName
     *     The pageName
     */
    @JsonProperty("pageName")
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    /**
     * 
     * @return
     *     The frame
     */
    @JsonProperty("frame")
    public String getFrame() {
        return frame;
    }

    /**
     * 
     * @param frame
     *     The frame
     */
    @JsonProperty("frame")
    public void setFrame(String frame) {
        this.frame = frame;
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
