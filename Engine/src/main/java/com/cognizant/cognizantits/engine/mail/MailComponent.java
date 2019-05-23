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
package com.cognizant.cognizantits.engine.mail;

import com.cognizant.cognizantits.engine.constants.FilePath;
import com.cognizant.cognizantits.engine.core.Control;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 *
 */
public class MailComponent {

    public static String getHTMLBody() {
        try {
            JSONObject testData = (JSONObject) Control.ReportManager.pHandler.getData();
            File file = new File(FilePath.getMailReportTemplatePath(), "mailBody.html");
            String str = FileUtils.readFileToString(file, Charset.defaultCharset());

            str = str.replace("{releaseName}", get(testData, "releaseName")).
                    replace("{testSetName}", get(testData, "testsetName")).
                    replace("{parallelThreads}", get(testData, "maxThreads")).
                    replace("{runConfig}", get(testData, "runConfiguration")).
                    replace("{startTime}", get(testData, "startTime")).
                    replace("{endTime}", get(testData, "endTime")).
                    replace("{totalDuration}", get(testData, "exeTime")).
                    replace("{passedTests}", get(testData, "nopassTests")).
                    replace("{failedTests}", get(testData, "nofailTests"));

            StringBuilder html = new StringBuilder();
            for (Object tc : (JSONArray) testData.get("EXECUTIONS")) {
                if (tc != null) {
                    JSONObject json = (JSONObject) tc;
                    html.append("</tr>")
                            .append("<td>").append(json.get("scenarioName")).append("</td>\n")
                            .append("<td>").append(json.get("testcaseName")).append("</td>\n")
                            .append("<td>").append(json.get("browser")).append("</td>\n")
                            .append("<td>").append(json.get("exeTime")).append("</td>\n")
                            .append("<td>").append(json.get("status")).append("</td>\n")
                            .append("<td>").append(json.get("bversion")).append("</td>\n")
                            .append("<td>").append(json.get("platform")).append("</td>\n")
                            .append("<td>").append(json.get("iterations")).append("</td>\n")
                            .append("</tr>");
                }
            }
            str = str.replace("{reportData}", html.toString());
            return str;
        } catch (IOException ex) {
            Logger.getLogger(MailComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static String get(JSONObject testData, String value) {
        String data = "";
        Object get = testData.get(value);
        if (get == null) {
            return data;
        } else {
            data = get.toString();
        }
        return data;
    }
}
