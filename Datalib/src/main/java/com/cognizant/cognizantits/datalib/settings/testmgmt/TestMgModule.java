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
package com.cognizant.cognizantits.datalib.settings.testmgmt;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "module",
    "options"
})
public class TestMgModule {

    @JsonProperty("module")
    private String module;
    @JsonProperty("options")
    private List<Option> options = new ArrayList<Option>();

    public TestMgModule() {
    }

    public TestMgModule(String module) {
        this.module = module;
    }

    /**
     *
     * @return The module
     */
    @JsonProperty("module")
    public String getModule() {
        return module;
    }

    /**
     *
     * @param module The module
     */
    @JsonProperty("module")
    public void setModule(String module) {
        this.module = module;
    }

    /**
     *
     * @return The options
     */
    @JsonProperty("options")
    public List<Option> getOptions() {
        return options;
    }

    /**
     *
     * @param options The options
     */
    @JsonProperty("options")
    public void setOptions(List<Option> options) {
        this.options = options;
    }

}
