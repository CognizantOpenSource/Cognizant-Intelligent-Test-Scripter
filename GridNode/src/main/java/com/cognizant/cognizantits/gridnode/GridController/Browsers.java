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
package com.cognizant.cognizantits.gridnode.GridController;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author 499538
 */
public class Browsers {

    private final SimpleStringProperty browser;
    private final SimpleStringProperty maxInst;

    public Browsers(String bName, String maxInstance) {
        
        this.browser = new SimpleStringProperty(bName);
        this.maxInst = new SimpleStringProperty(maxInstance);
    }

    public String getBrowser() {
        return browser.get();
    }

    public void setBrowser(String bName) {
        browser.set(bName);
    }

    public String getMaxInst() {
        return maxInst.get();
    }

    public void setMaxInst(String maxInstance) {
        maxInst.set(maxInstance);
    }
    
}
