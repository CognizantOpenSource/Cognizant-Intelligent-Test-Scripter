/*
 * Copyright 2014 - 2019 Cognizant Technology Solutions
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

/**
 *
 *
 */
public class RunSettings extends AbstractPropSettings {

    public RunSettings(String location) {
        super(location, "RunSettings");
    }

    public void setExecutionMode(String value) {
        setProperty("ExecutionMode", value);
    }

    public String getExecutionMode() {
        return getProperty("ExecutionMode", "Local");
    }

    public Boolean isGridExecution() {
        return getExecutionMode().equalsIgnoreCase("grid");
    }

    public void useExistingDriver(Boolean value) {
        setProperty("ExistingDriver", String.valueOf(value));
    }

    public Boolean useExistingDriver() {
        return Boolean.valueOf(getProperty("ExistingDriver", "false"));
    }

    public void setExecutionTimeOut(String value) {
        setProperty("ExecutionTimeOut", value);
    }

    public Integer getExecutionTimeOut() {
        return Integer.valueOf(getProperty("ExecutionTimeOut", "300"));
    }

    public void setScreenShotFor(String value) {
        setProperty("ScreenShotFor", value);
    }

    public String getScreenShotFor() {
        return getProperty("ScreenShotFor", "Both");
    }

    public void setThreadCount(String value) {
        setProperty("ThreadCount", value);
    }

    public Integer getThreadCount() {
        return Integer.valueOf(getProperty("ThreadCount", "1"));
    }

    public void setTakeFullPageScreenShot(Boolean value) {
        setProperty("TakeFullPageScreenShot", String.valueOf(value));
    }

    public Boolean getTakeFullPageScreenShot() {
        return Boolean.valueOf(getProperty("TakeFullPageScreenShot", "true"));
    }

    public void setReportPerformanceLog(Boolean value) {
        setProperty("reportPerformanceLog", String.valueOf(value));
    }

    public Boolean isPerformanceLogEnabled() {
        return Boolean.valueOf(getProperty("reportPerformanceLog", "false"));
    }

    public void setBddReport(Boolean value) {
        setProperty("bddReport", String.valueOf(value));
    }

    public Boolean isBddReportEnabled() {
        return Boolean.valueOf(getProperty("bddReport", "false"));
    }

    public void setRemoteGridURL(String value) {
        setProperty("RemoteGridURL", value);
    }

    public String getRemoteGridURL() {
        return getProperty("RemoteGridURL", "http://localhost:4444/wd/hub");
    }

    public void setIterationMode(String value) {
        setProperty("IterationMode", value);
    }

    public String getIterationMode() {
        return getProperty("IterationMode", "ContinueOnError");
    }

    public void setRerunTimes(String value) {
        setProperty("RerunTimes", value);
    }

    public Integer getRerunTimes() {
        return Integer.valueOf(getProperty("RerunTimes", "0"));
    }

    public void setTestEnv(String value) {
        setProperty("TestEnv", value);
    }

    public String getTestEnv() {
        return getProperty("TestEnv", "Default");
    }

    public Boolean isMailSend() {
        return Boolean.valueOf(getProperty("SendMail", "false"));
    }

    public void setMailSend(Boolean value) {
        setProperty("SendMail", String.valueOf(value));
    }

    public Boolean isExcelReport() {
        return Boolean.valueOf(getProperty("excelReport", "false"));
    }

    public void setExcelReport(Boolean value) {
        setProperty("excelReport", String.valueOf(value));
    }
}
