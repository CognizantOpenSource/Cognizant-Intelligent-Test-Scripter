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

public class DriverSettings extends AbstractPropSettings {

    private static String geckoDriverPath, chromeDriverPath;

    static {
        setDriverPath();
    }

    public DriverSettings(String location) {
        super(location, "DriverSettings");
        if (isEmpty()) {
            loadDefault();
        }
    }

    private void loadDefault() {
        setFirefoxBinaryPath(getFirefoxBinaryPath());
        setGeckcoDriverPath(getGeckcoDriverPath());
        setChromeDriverPath(getChromeDriverPath());
        setIEDriverPath(getIEDriverPath());
        setEdgeDriverPath(getEdgeDriverPath());
    }

    private static void setDriverPath() {
        if (System.getProperty("os.name", "")
                .toLowerCase().contains("win")) {
            geckoDriverPath = "./lib/Drivers/geckodriver.exe";
            chromeDriverPath = "./lib/Drivers/chromedriver.exe";
        } else {
            geckoDriverPath = "./lib/Drivers/geckodriver";
            chromeDriverPath = "./lib/Drivers/chromedriver";
        }
    }

    public void setFirefoxBinaryPath(String path) {
        setProperty("FirefoxBinaryPath", path);
    }

    public void setGeckcoDriverPath(String path) {
        setProperty("GeckoDriverPath", path);
    }

    public void setChromeDriverPath(String path) {
        setProperty("ChromeDriverPath", path);
    }

    public void setIEDriverPath(String path) {
        setProperty("IEDriverPath", path);
    }

    public void setEdgeDriverPath(String path) {
        setProperty("EdgeDriverPath", path);
    }

    public String getFirefoxBinaryPath() {
        return getProperty("FirefoxBinaryPath", "");
    }

    public String getGeckcoDriverPath() {
        return getProperty("GeckoDriverPath", geckoDriverPath);
    }

    public String getChromeDriverPath() {
        return getProperty("ChromeDriverPath", chromeDriverPath);
    }

    public String getIEDriverPath() {
        return getProperty("IEDriverPath", "./lib/Drivers/IEDriverServer.exe");
    }

    public String getEdgeDriverPath() {
        return getProperty("EdgeDriverPath", "./lib/Drivers/MicrosoftWebDriver.exe");
    }

    public Boolean useProxy() {
        return Boolean.valueOf(getProperty("useProxy", "false"));
    }

}
