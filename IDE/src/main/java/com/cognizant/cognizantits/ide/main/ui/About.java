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
package com.cognizant.cognizantits.ide.main.ui;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class About {

    private final static String DETAILS = "<html>\n"
            + "	<body>\n"
            + "			<strong>Build Version</strong>: ##bversion## \n"
            + "			<br />\n"
            + "			<strong>Build Date</strong>: ##bdate##\n"
            + "			<br />\n"
            + "			<strong>Java</strong>: ##jversion##\n"
            + "			<br />\n"
            + "			<strong>Installation directory</strong>: ##insdir##\n"
            + "	</body>\n"
            + "</html>";

    private static Properties buildProperties;

    public static void init() {
        buildProperties = new Properties();
        try {
            buildProperties.load(About.class.getResourceAsStream("/ui/resources/build.properties"));
        } catch (IOException ex) {
            Logger.getLogger(About.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public static String getDetailsAsHTML() {
        return DETAILS
                .replace("##bversion##", getBuildVersion())
                .replace("##bdate##", getBuildDate())
                .replace("##jversion##", getJavaVersion())
                .replace("##insdir##", getRoot());
    }

    public static String getBuildVersion() {
        return buildProperties.getProperty("Bundle-Version");
    }

    public static String getBuildDate() {
        return buildProperties.getProperty("Build-Date");
    }

    public static String getJavaVersion() {
        return System.getProperty("java.home");
    }

    public static String getRoot() {
        return System.getProperty("user.dir");
    }

}
