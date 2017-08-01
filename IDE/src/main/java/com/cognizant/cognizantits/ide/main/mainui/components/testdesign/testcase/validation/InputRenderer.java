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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign.testcase.validation;

import com.cognizant.cognizantits.datalib.component.TestStep;
import com.cognizant.cognizantits.datalib.testdata.model.TestDataModel;
import com.cognizant.cognizantits.engine.support.methodInf.MethodInfoManager;
import java.util.Objects;
import javax.swing.JComponent;

/**
 *
 * 
 */
public class InputRenderer extends AbstractRenderer {

    String testDataNotPresent = "TestData/Column not avaliable in the Project";
    String inValidInput = "Syntax error. Input should be one of [@val ,%var% ,=Function ,Sheet:Column]";

    String shouldBeEmpty = "Syntax error. Input should be empty for the Action";

    public InputRenderer() {
        super("Input Shouldn't be empty.It should be one of [@val ,%var% ,=Function ,Sheet:Column]");
    }

    @Override
    public void render(JComponent comp, TestStep step, Object value) {
        if (!step.isCommented()) {
            if (isEmpty(value)) {
                if (!isOptional(step)) {
                    setEmpty(comp);
                } else {
                    setDefault(comp);
                }
            } else if (isNotNeeded(step)) {
                setNotPresent(comp, shouldBeEmpty);
            } else if (step.isTestDataStep()) {
                if (isTestDataPresent(step)) {
                    setDefault(comp);
                } else {
                    setNotPresent(comp, testDataNotPresent);
                }
            } else if (isInputValid(value)) {
                setDefault(comp);
            } else {
                setNotPresent(comp, inValidInput);
            }
        } else {
            setDefault(comp);
        }
    }

    private Boolean isOptional(TestStep step) {
        if (step.getObject().matches("Execute")) {
            return true;
        } else if (MethodInfoManager.methodInfoMap.containsKey(step.getAction())) {
            return !MethodInfoManager.methodInfoMap.
                    get(step.getAction()).input().isMandatory();
        }
        return true;
    }

    private Boolean isNotNeeded(TestStep step) {
        if (step.getObject().matches("Execute")) {
            return false;
        } else if (MethodInfoManager.methodInfoMap.containsKey(step.getAction())) {
            return MethodInfoManager.methodInfoMap.
                    get(step.getAction()).input().isNotNeeded();
        }
        return true;
    }

    private Boolean isTestDataPresent(TestStep step) {
        String[] data = step.getTestDataFromInput();
        return step.getProject().getTestData().getAllEnvironments()
                .stream()
                .map((sTestData) -> sTestData.getByName(data[0]))
                .anyMatch((tdModelDef) -> hasColumn(tdModelDef, data[1]));
    }

    private boolean hasColumn(TestDataModel tdModel, String column) {
        return tdModel != null && tdModel.getColumnIndex(column) >= 0;
    }

    private Boolean isInputValid(Object value) {
        String val = Objects.toString(value, "").trim();
        return val.matches("(@.+)|(=.+)|(%.+%)");
    }
}
