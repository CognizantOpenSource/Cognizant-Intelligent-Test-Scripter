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
import java.awt.Font;
import javax.swing.JComponent;

/**
 *
 * 
 */
public class StepRenderer extends AbstractRenderer {

    public StepRenderer() {
        super(null);
    }

    @Override
    public void render(JComponent comp, TestStep step, Object value) {
        comp.setForeground(getColor(step));
        if (step.isCommented() || step.hasBreakPoint()) {
            comp.setFont(new Font("Default", Font.BOLD, 11));
        }
    }

    private Color getColor(TestStep step) {
        if (step.isCommented()) {
            return Color.GRAY;
        } else if (step.hasBreakPoint()) {
            return Color.BLUE;
        }
        return Color.BLACK;
    }

}
