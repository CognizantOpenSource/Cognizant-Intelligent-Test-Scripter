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
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * 
 */
public class Capabilities {

    private final Map<String, LinkedProperties> browserCapabilties = new HashMap<>();

    private String location;

    public Capabilities(String location) {
        this.location = location;
        load();
    }

    public Map<String, LinkedProperties> getBrowserCapabilties() {
        return browserCapabilties;
    }

    public LinkedProperties getCapabiltiesFor(String browserName) {
        return browserCapabilties.get(browserName);
    }

    private void load() {
        File caps = new File(getLocation());
        if (caps.exists()) {
            for (File cap : caps.listFiles()) {
                if (cap.getName().endsWith(".properties")) {
                    browserCapabilties.put(cap.getName().replace(".properties", ""), PropUtils.load(cap));
                }
            }
        }
    }

    public void addCapability(String browserName) {
        addCapability(browserName, new LinkedProperties());
    }

    public void addCapability(String browserName, LinkedProperties props) {
        browserCapabilties.put(browserName, props);
    }

    public void addDefaultAppiumCapability(String browserName) {
        addDefaultAppiumCapability(browserName, "", "", "");
    }

    public void addDefaultAppiumCapability(String browserName, String udid, String appPackage, String appiumActivity) {
        LinkedProperties x = new LinkedProperties();
        if (appiumActivity.isEmpty()) {
            x.setProperty("browserName", "chrome");
        }
        x.setProperty("platformName", "Android");
        x.setProperty("deviceName", browserName);
        x.setProperty("platformVersion", "");
        x.setProperty("udid", udid);
        x.setProperty("appActivity", appiumActivity);
        x.setProperty("appPackage", appPackage);
        addCapability(browserName, x);
    }

    public void save() {
        createCapsFolder();
        for (Map.Entry<String, LinkedProperties> entry : browserCapabilties.entrySet()) {
            String capName = entry.getKey();
            Properties capProp = entry.getValue();
            PropUtils.save(capProp, getCapLocation(capName));
        }
    }

    public void save(String capsName) {
        createCapsFolder();
        if (browserCapabilties.containsKey(capsName)) {
            PropUtils.save(browserCapabilties.get(capsName), getCapLocation(capsName));
        }
    }

    public void delete(String capsName) {
        if (browserCapabilties.containsKey(capsName)) {
            File caps = new File(getCapLocation(capsName));
            if (caps.exists()) {
                caps.delete();
            }
            browserCapabilties.remove(capsName);
        }
    }

    public Boolean rename(String oldCapsName, String newCapsName) {
        if (browserCapabilties.containsKey(oldCapsName) && !browserCapabilties.containsKey(newCapsName)) {
            File caps = new File(getCapLocation(oldCapsName));
            if (caps.exists()) {
                if (caps.renameTo(new File(getCapLocation(newCapsName)))) {
                    browserCapabilties.put(newCapsName, browserCapabilties.remove(oldCapsName));
                    return true;
                }
            } else {
                browserCapabilties.put(newCapsName, browserCapabilties.remove(oldCapsName));
            }
        }
        return false;
    }

    public String getCapLocation(String capsName) {
        return getLocation() + File.separator + capsName + ".properties";
    }

    public String getLocation() {
        return location + File.separator + "Capabilities";
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private void createCapsFolder() {
        File caps = new File(getLocation());
        if (!caps.exists()) {
            caps.mkdirs();
        }
    }

}
