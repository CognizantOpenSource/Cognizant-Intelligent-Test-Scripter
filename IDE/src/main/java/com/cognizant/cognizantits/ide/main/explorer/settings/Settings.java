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
package com.cognizant.cognizantits.ide.main.explorer.settings;

import com.cognizant.cognizantits.ide.util.Notification;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * 
 */
public class Settings {

    final static FileSystemView FSV = null;
    public static final JFileChooser FC_IMG_EDITOR = new JFileChooser("", FSV);
    public static final String[] SETTINGS = {"ImageEditor", "EditorArguments", "DefectModule", "URL", "UserName", "Password", "Domain", "Project"};
    public static final File CONFIG_FILE = new File(getConfigFileLoc());
    static Properties prop = new Properties();
    static Map<String, String> settingsMap = new LinkedHashMap();
    public static final CharSequence FILE_ARGS = "#file";
    static String screenshotLoc = ".", scriptLoc = ".";

    static {
        updateSettings();
    }

    static String getConfigFileLoc() {
        return getAppDir() + File.separator + "Configuration" + File.separator + "ExplorerConfig.properties";
    }

    public static String getDefectModule() {
        return settingsMap.get(SETTINGS[2]);
    }

    static void saveSettings(Map<String, String> settingsMap) {
        try {
            checkFile(CONFIG_FILE);
            for (String key : settingsMap.keySet()) {
                prop.setProperty(key, settingsMap.get(key));
            }
            prop.store(new FileWriter(CONFIG_FILE), "Exploratory Module Settings!!");
            Notification.show("Settings Successfully Saved!!");
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateSettings();
    }

    public static String getSettings(String key) {
        return settingsMap.get(key);
    }

    public static Map<String, String> updateSettings() {
        settingsMap.clear();
        try {
            checkFile(CONFIG_FILE);
            prop.load(new FileReader(CONFIG_FILE));
            for (Object key : prop.keySet()) {
                settingsMap.put(key.toString(), prop.getProperty(key.toString()));
            }

        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        return settingsMap;
    }

    public static Map<String, String> getSettings() {
        return settingsMap;
    }

    private static String getAppDir() {
        return System.getProperty("user.dir");
    }

    private static void checkFile(File configFile) {
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String getScreenShotLoc() {
        return screenshotLoc;
    }

    public static String getScriptLoc() {
        return scriptLoc;
    }

    public static void setScreenShotLoc(String screenshotLoc) {
        Settings.screenshotLoc = screenshotLoc;
    }

    public static void setScriptLoc(String scriptLoc) {
        Settings.scriptLoc = scriptLoc;
    }

    public static String getImageEditor() {
        return settingsMap.get(SETTINGS[0]);
    }

    public static String getImageEditorArgs() {
        return settingsMap.get(SETTINGS[1]);
    }

}
