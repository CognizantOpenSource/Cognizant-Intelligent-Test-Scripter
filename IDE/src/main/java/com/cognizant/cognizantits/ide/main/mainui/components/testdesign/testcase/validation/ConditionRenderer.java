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

    public ConditionRenderer() {
        super("Condition Shouldn't be empty. Additonal Object/Data is needed for the action");
    }

    @Override
    public void render(JComponent comp, TestStep step, Object value) {
        if (!step.isCommented() && isEmpty(value) && !isOptional(step)) {
            setEmpty(comp);
        } else {
            setDefault(comp);
        }
    }

    private Boolean isOptional(TestStep step) {
        if (MethodInfoManager.methodInfoMap.containsKey(step.getAction())) {
            return !MethodInfoManager.methodInfoMap.get(step.getAction()).condition().isMandatory();
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

}
