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
package com.cognizant.cognizantits.datalib.settings;

import com.cognizant.cognizantits.datalib.util.data.LinkedProperties;
import java.io.File;
import java.util.Properties;

/**
 *
 * 
 */
public class AbstractPropSettings extends LinkedProperties {

    private String location;

    private String name;

    public AbstractPropSettings(String location, String name) {
        this.location = location;
        this.name = name;
        load();
    }

    private void load() {
        File driverProp = new File(getLocation());
        if (driverProp.exists()) {
            PropUtils.load(this, driverProp);
        }
    }

    public void save() {
        PropUtils.save(this, getLocation());
    }

    public String getLocation() {
        return location + File.separator + name + ".Properties";
    }

    public void set(Properties prop) {
        this.clear();
        for (String key : prop.stringPropertyNames()) {
            setProperty(key, prop.getProperty(key));
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

}
