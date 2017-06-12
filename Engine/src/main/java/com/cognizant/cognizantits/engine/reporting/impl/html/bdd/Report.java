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
package com.cognizant.cognizantits.engine.reporting.impl.html.bdd;

import java.util.List;

public class Report {

    String projectName;
    String releaseName;
    String testsetName;
    String iterationMode;
    String runConfiguration;
    String maxThreads;
    String startTime;
    String endTime;
    String exeTime;
    String noTests;
    String nopassTests;
    String nofailTests;
    String theme;
    List<String> themes;
    String testRun;
    List<Execution> EXECUTIONS;

    public List<Execution> getEXECUTIONS() {
        return EXECUTIONS;
    }

    public static class Execution {

        String scenarioName;

        public String getScenarioName() {
            return scenarioName;
        }

        public String getExeTime() {
            return exeTime;
        }

        public String getStatus() {
            return status;
        }

        String testcaseName;
        String description;
        String iterations;

        public List<IterData> getIterData() {
            return STEPS;
        }

        String iterationType;
        String platform;
        String bversion;
        String startTime;
        String endTime;
        String exeTime;
        String noTests;
        String nopassTests;
        String nofailTests;
        String browser;
        String status;
        List<IterData> STEPS;

    }

    public static class IterData {

        String name;
        String type;

        String startTime;
        String endTime;
        String description;
        List<Step> data;

        public List<Step> getSteps() {
            return data;
        }

    }

    public static class Step {

        String name;
        String type;
        String description;
        String status;
        String startTime;
        String endTime;
        Object data;

        public String getStatus() {
            return this.status;
        }

        enum StepInfo {
            stepno, stepName, action, description, status, tStamp, link,
            expected, actual, comparison, objects;
        }

    }

    public static class Data {

        String stepno;
        String stepName;
        String action;
        String description;
        String status;
        String tStamp;
        String link;
        String expected;
        String actual;
        String comparison;
        String objects;
        
        public String getDescription() {
            return description;
        }

        public String getLink() {
            return link;
        }
        
    }
}
