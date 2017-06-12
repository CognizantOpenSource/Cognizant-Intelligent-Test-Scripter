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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign.or;

import com.cognizant.cognizantits.datalib.or.common.ORObjectInf;
import com.cognizant.cognizantits.datalib.or.common.ORPageInf;
import com.cognizant.cognizantits.datalib.or.common.ObjectGroup;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class ObjectRepDnD {

    Boolean isPage = false;
    Boolean isGroup = false;
    Boolean isObject = false;
    List<String> values = new ArrayList<>();
    List<Object> components = new ArrayList<>();

    public Boolean isPage() {
        return isPage;
    }

    public Boolean isGroup() {
        return isGroup;
    }

    public Boolean isObject() {
        return isObject;
    }

    public List<String> getValues() {
        return values;
    }

    public List<Object> getComponents() {
        return components;
    }

    public ObjectRepDnD withPages(List<ORPageInf> pages) {
        isPage = true;
        for (ORPageInf page : pages) {
            values.add(page.getName());
            components.add(page);
        }
        return this;
    }

    public ObjectRepDnD withObjectGroups(List<ObjectGroup> groups) {
        isGroup = true;
        for (ObjectGroup group : groups) {
            values.add(
                    group.getName()
                    + "###"
                    + group.getParent().getName());
            components.add(group);
        }
        return this;
    }

    public ObjectRepDnD withObjects(List<ORObjectInf> objects) {
        isObject = true;
        for (ORObjectInf object : objects) {
            values.add(
                    object.getName()
                    + "###"
                    + object.getParent().toString()
                    + "###"
                    + object.getPage().getName()
            );
            components.add(object);
        }
        return this;
    }

    public String getPageName(String value) {
        if (isPage()) {
            return value;
        }
        if (isGroup()) {
            return value.split("###")[1];
        }
        if (isObject()) {
            return value.split("###")[2];
        }
        return null;
    }

    public String getObjectName(String value) {
        if (isGroup()) {
            return value.split("###")[0];
        }
        if (isObject()) {
            return value.split("###")[1];
        }
        return null;
    }
}
