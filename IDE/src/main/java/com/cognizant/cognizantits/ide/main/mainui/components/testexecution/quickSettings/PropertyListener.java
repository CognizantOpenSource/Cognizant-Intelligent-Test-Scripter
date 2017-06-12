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
package com.cognizant.cognizantits.ide.main.mainui.components.testexecution.quickSettings;

/**
 *
 * Listener for settings update.
 * <br>
 * Interfaces the model and view.
 * 
 * 
 * 
 * <br><br><br>
 *
 */
public interface PropertyListener {
/**
 * notifies when change happens to the property from view
 * 
 * 
 * @param prop key
 * @param value value
 */
    public void onPropertyChange(String prop, String value);
}
