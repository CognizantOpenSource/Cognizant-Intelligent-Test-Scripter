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
package com.cognizant.cognizantits.datalib.testdata.model;

import java.util.ArrayList;

/**
 *
 * 
 */
public class Record extends ArrayList<String> {

    public static final String[] HEADERS = new String[]{"Scenario", "Flow", "Iteration", "SubIteration"};

    @Override
    public String remove(int i) {
        if (i >= HEADERS.length) {
            return String.valueOf(super.remove(i));
        }
        return String.valueOf(get(i));
    }

    public String getScenario() {
        return get(0);
    }

    public String getTestcase() {
        return get(1);
    }

    public String getIteration() {
        return get(2);
    }

    public String getSubIteration() {
        return get(3);
    }

    public void setScenario(String scenario) {
        set(0, scenario);
    }

    public void setTestcase(String testCase) {
        set(1, testCase);
    }

    public void setIteration(String iteration) {
        set(2, iteration);
    }

    public void setSubIteration(String subIteration) {
        set(3, subIteration);
    }

    @Override
    public String set(int i, String e) {
        switch (i) {
            case 2:
            case 3:
                if (!validIterRSubIteration(e)) {
                    if (!validIterRSubIteration(get(i))) {
                        e = "1";
                    } else {
                        return get(i);
                    }
                }
                break;

        }
        return super.set(i, e);
    }

    private Boolean validIterRSubIteration(String value) {
        return value.isEmpty() || value.matches("[1-9][0-9]*");
    }

}
