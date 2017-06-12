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

import com.cognizant.cognizantits.datalib.component.Project;
import java.io.File;

/**
 *
 * 
 */
public class ProjectSettings {

    private final Project sProject;

    private final UserDefinedSettings userDefinedSettings;

    private final DriverSettings driverSettings;
    private final Capabilities capabilities;
    private final Emulators emulators;
    private final TestMgmtModule testMgmtModule;

    private final MailSettings mailSettings;
    
    private final DatabaseSettings dbSettings;

    private final ExecutionSettings execSettings;

    public ProjectSettings(Project sProject) {
        this.sProject = sProject;
        this.userDefinedSettings = new UserDefinedSettings(getLocation());
        this.driverSettings = new DriverSettings(getLocation());
        this.capabilities = new Capabilities(getLocation());
        this.emulators = new Emulators(getLocation());
        this.testMgmtModule = new TestMgmtModule(getLocation());
        this.execSettings = new ExecutionSettings(getLocation());
        this.mailSettings = new MailSettings(getLocation());
        this.dbSettings = new DatabaseSettings(getLocation());
    }

    public void resetLocation() {
        userDefinedSettings.setLocation(getLocation());
        driverSettings.setLocation(getLocation());
        capabilities.setLocation(getLocation());
        emulators.setLocation(getLocation());
        testMgmtModule.setLocation(getLocation());
        execSettings.setLocation(getLocation());
        mailSettings.setLocation(getLocation());
        dbSettings.setLocation(getLocation());
    }

    public final String getLocation() {
        return sProject.getLocation() + File.separator + "Settings";
    }

    public Project getProject() {
        return sProject;
    }

    public MailSettings getMailSettings() {
        return mailSettings;
    }
    
    public DatabaseSettings getDatabaseSettings(){
        return dbSettings;
    }
    
    public DriverSettings getDriverSettings() {
        return driverSettings;
    }

    public Capabilities getCapabilities() {
        return capabilities;
    }

    public Emulators getEmulators() {
        return emulators;
    }

    public TestMgmtModule getTestMgmtModule() {
        return testMgmtModule;
    }

    public ExecutionSettings getExecSettings() {
        return execSettings;
    }

    public ExecutionSettings getExecSettings(String release, String testset) {
        return sProject.getReleaseByName(release).getTestSetByName(testset).getExecSettings();
    }

    public UserDefinedSettings getUserDefinedSettings() {
        return userDefinedSettings;
    }

    public void save() {
        userDefinedSettings.save();
        execSettings.save();
        driverSettings.save();
        emulators.save();
        capabilities.save();
        testMgmtModule.save();
        mailSettings.save();
        dbSettings.save();
    }
}
