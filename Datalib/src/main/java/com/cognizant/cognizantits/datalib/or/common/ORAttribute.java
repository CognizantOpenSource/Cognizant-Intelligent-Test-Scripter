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
package com.cognizant.cognizantits.datalib.or.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ORAttribute {

    @JacksonXmlProperty(isAttribute = true, localName = "ref")
    private String name;

    @JacksonXmlProperty(isAttribute = true)
    private String value;

    @JacksonXmlProperty(isAttribute = true, localName = "pref")
    private String preference;

    public ORAttribute() {
    }

    public ORAttribute(String name, int preference) {
        this.name = name;
        this.value = "";
        this.preference = String.valueOf(preference);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    @Override
    public String toString() {
        return "ClassPojo [ref = " + name + ", value = " + value + ", pref = " + preference + "]";
    }

    @JsonIgnore
    public ORAttribute cloneAs() {
        ORAttribute attribute = new ORAttribute();
        attribute.setName(name);
        attribute.setPreference(preference);
        attribute.setValue(value);
        return attribute;
    }
}
