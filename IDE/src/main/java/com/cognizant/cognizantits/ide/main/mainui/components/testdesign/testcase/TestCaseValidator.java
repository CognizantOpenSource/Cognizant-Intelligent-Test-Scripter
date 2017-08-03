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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign.testcase;

import com.cognizant.cognizantits.datalib.component.TestStep;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.testcase.validation.ActionRenderer;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.testcase.validation.ConditionRenderer;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.testcase.validation.InputRenderer;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.testcase.validation.ObjectRenderer;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.testcase.validation.ReferenceRenderer;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.testcase.validation.StepRenderer;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class TestCaseValidator {

    StepRenderer stepRenderer;
    ObjectRenderer objectRenderer;
    ReferenceRenderer referenceRenderer;
    ActionRenderer actionRenderer;
    InputRenderer inputRenderer;
    ConditionRenderer conditionRenderer;

    private Boolean validate = true;
    private final JTable testCaseTable;

    public TestCaseValidator(JTable testCaseTable) {
        this.testCaseTable = testCaseTable;
        init();
    }

    private void init() {
        stepRenderer = new StepRenderer();
        objectRenderer = new ObjectRenderer();
        referenceRenderer = new ReferenceRenderer();
        actionRenderer = new ActionRenderer();
        inputRenderer = new InputRenderer();
        conditionRenderer = new ConditionRenderer();
    }

    public void initValidations() {
        validate();
    }

    private void setValidations() {
        testCaseTable.getColumnModel().getColumn(TestStep.HEADERS.Step.getIndex())
                .setCellRenderer(stepRenderer);
        testCaseTable.getColumnModel().getColumn(TestStep.HEADERS.ObjectName.getIndex())
                .setCellRenderer(objectRenderer);
        testCaseTable.getColumnModel().getColumn(TestStep.HEADERS.Reference.getIndex())
                .setCellRenderer(referenceRenderer);
        testCaseTable.getColumnModel().getColumn(TestStep.HEADERS.Action.getIndex())
                .setCellRenderer(actionRenderer);
        testCaseTable.getColumnModel().getColumn(TestStep.HEADERS.Input.getIndex())
                .setCellRenderer(inputRenderer);
        testCaseTable.getColumnModel().getColumn(TestStep.HEADERS.Condition.getIndex())
                .setCellRenderer(conditionRenderer);
    }

    private void removeValidations() {
        testCaseTable.getColumnModel().getColumn(TestStep.HEADERS.Step.getIndex())
                .setCellRenderer(null);
        testCaseTable.getColumnModel().getColumn(TestStep.HEADERS.ObjectName.getIndex())
                .setCellRenderer(null);
        testCaseTable.getColumnModel().getColumn(TestStep.HEADERS.Reference.getIndex())
                .setCellRenderer(null);
        testCaseTable.getColumnModel().getColumn(TestStep.HEADERS.Action.getIndex())
                .setCellRenderer(null);
        testCaseTable.getColumnModel().getColumn(TestStep.HEADERS.Input.getIndex())
                .setCellRenderer(null);
        testCaseTable.getColumnModel().getColumn(TestStep.HEADERS.Condition.getIndex())
                .setCellRenderer(null);
    }

    public final void enableValidation() {
        validate = true;
        validate();
    }

    public final void toggleValidation() {
        validate = !validate;
        validate();
    }

    public final void disableValidation() {
        validate = false;
        validate();
    }

    private void validate() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (validate) {
                    setValidations();
                } else {
                    removeValidations();
                }
                testCaseTable.repaint();
            }
        });
    }

}
