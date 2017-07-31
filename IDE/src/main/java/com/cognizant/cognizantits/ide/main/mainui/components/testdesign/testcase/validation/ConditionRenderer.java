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
import java.awt.Color;
import com.cognizant.cognizantits.engine.support.methodInf.MethodInfoManager;
import java.util.Objects;
import javax.swing.JComponent;

public class ConditionRenderer extends AbstractRenderer {

    String objNotPresent = "Object is not present in the Object Repository";
    String shouldBeEmpty = "Syntax error. Condition should be empty for the Action";
    String inValidInput = "Syntax error. Invalid object";

    public ConditionRenderer() {
        super("Condition Shouldn't be empty. Additonal Object is needed for the action");
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
            } else if (step.isPageObjectStep()) {
                if (isObjectPresent(step)) {
                    setDefault(comp);
                } else {
                    setNotPresent(comp, objNotPresent);
                }
            } else if (isValidObject(value)) {
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
                    get(step.getAction()).condition().isMandatory();
        }
        return true;
    }

    private Boolean isNotNeeded(TestStep step) {
        if (step.getObject().matches("Execute")) {
            return false;
        } else if (MethodInfoManager.methodInfoMap.containsKey(step.getAction())) {
            return !MethodInfoManager.methodInfoMap.
                    get(step.getAction()).condition().isMandatory();
        }
        return true;
    }

    private Color getColor(Object value) {
        String val = Objects.toString(value, "").trim();
        switch (val) {
            case "Execute":
                return Color.BLUE;//.darker();
            case "App":
                return Color.CYAN;//.darker();
            case "Browser":
                return Color.RED;//.darker();
            default:
                return new Color(204, 0, 255);
        }
    }

    private Boolean isObjectPresent(TestStep step) {
        return step.getProject().getObjectRepository()
                .isObjectPresent(step.getReference(), step.getCondition());
    }

    private Boolean isValidObject(Object value) {
        return Objects.toString(value, "").trim()
                .matches("Execute|WebService|App|Browser");
    }

}
