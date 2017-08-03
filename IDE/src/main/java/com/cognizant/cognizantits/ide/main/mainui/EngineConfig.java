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
package com.cognizant.cognizantits.ide.main.mainui;

import com.cognizant.cognizantits.datalib.component.Project;
import com.cognizant.cognizantits.engine.constants.SystemDefaults;
import com.cognizant.cognizantits.engine.core.Control;
import com.cognizant.cognizantits.engine.execution.exception.UnCaughtException;
import com.cognizant.cognizantits.ide.settings.AppSettings;
import com.cognizant.cognizantits.ide.settings.AppSettings.APP_SETTINGS;
import com.cognizant.cognizantits.ide.util.logging.UILogger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class EngineConfig {

    public static void runProject(Project project) {
        try {
            int defWaitTime = Integer.valueOf(AppSettings.get(APP_SETTINGS.DEFAULT_WAIT_TIME.getKey()));
            int elementWaitTime = Integer.valueOf(AppSettings.get(APP_SETTINGS.ELEMENT_WAIT_TIME.getKey()));
            SystemDefaults.elementWaitTime.set(elementWaitTime);
            SystemDefaults.waitTime.set(defWaitTime);
            Boolean standAlone = Boolean.valueOf(AppSettings.get(APP_SETTINGS.STANDALONE_REPORT.getKey()));
            if (standAlone) {
                SystemDefaults.CLVars.put("createStandaloneReport", "true");
            } else {
                SystemDefaults.CLVars.remove("createStandaloneReport");
            }
            Control.call(project);
            UILogger.get().revertToDefault();
        } catch (UnCaughtException ex) {
            Logger.getLogger(EngineConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
