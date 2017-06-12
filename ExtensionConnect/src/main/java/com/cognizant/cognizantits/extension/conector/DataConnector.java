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
package com.cognizant.cognizantits.extension.conector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.cognizant.cognizantits.extension.extensionPojo.addonObject.RecordObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cognizant.cognizantits.extension.extensionPojo.ActionFinder;
import com.cognizant.cognizantits.extension.extensionPojo.heal.FindObjects;
import com.cognizant.cognizantits.extension.extensionPojo.heal.FindResults;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 394173
 */
public abstract class DataConnector {
    
    private final static ObjectMapper MAPPER = new ObjectMapper();
    
    public final void onRecieve(String data, Boolean forHeal) {
        try {
            if (forHeal && !isSpyAction(data)) {
                onRecieve(MAPPER.readValue(data, FindResults.class));
            } else {
                onRecieve(MAPPER.readValue(data, RecordObject.class));
            }
        } catch (IOException ex) {
            Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Boolean isSpyAction(String data) throws IOException {
        String action = MAPPER.readValue(data, ActionFinder.class).getAction();
        return action.equalsIgnoreCase("PREV") || action.equalsIgnoreCase("SAVE");
    }

    /**
     * For Spy and Recorder
     *
     * @param rObject
     */
    public abstract void onRecieve(RecordObject rObject);

    /**
     * For Heal
     *
     * @param rObject
     */
    public abstract void onRecieve(FindResults rObject);
    
    public static String parse(FindObjects fObjs) {
        try {
            return MAPPER.writeValueAsString(fObjs);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
}
