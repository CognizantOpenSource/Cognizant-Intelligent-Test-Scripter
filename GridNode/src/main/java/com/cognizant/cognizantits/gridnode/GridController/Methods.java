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

import javax.swing.JTextField;

/**
 *
 * @author 499538
 */
public class Methods {

    private String getOsName() {
        return System.getProperty("os.name");
    }

    public boolean isWindows() {
        return getOsName().startsWith("Windows");
    }

    public boolean validate(JTextField br, JTextField inst) {
        boolean brState = br.getText().trim().length() == 0;
        boolean instState = inst.getText().trim().length() == 0;
        boolean result;

        if (brState || instState) {
            if (brState) {
//                if (!brStyleClass.contains("error")) {
//                    brStyleClass.add("error");
//                }
            } else {
//                brStyleClass.removeAll(Collections.singleton("error"));
            }

            if (instState) {
//                if (!instStyleClass.contains("error")) {
//                    instStyleClass.add("error");
//                }
            } else {
//                instStyleClass.removeAll(Collections.singleton("error"));
            }
            result = false;
        } else {
//            brStyleClass.removeAll(Collections.singleton("error"));
//            instStyleClass.removeAll(Collections.singleton("error"));
            result = true;
        }
        return result;
    }
}
