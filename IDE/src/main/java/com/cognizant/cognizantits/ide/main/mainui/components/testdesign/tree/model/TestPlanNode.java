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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign.tree.model;

import com.cognizant.cognizantits.datalib.component.Project;
import com.cognizant.cognizantits.datalib.component.Scenario;
import com.cognizant.cognizantits.datalib.component.TestCase;

/**
 *
 * 
 */
public class TestPlanNode extends GroupNode {

    public Project project;

    public TestPlanNode() {
        super("TestPlan");
    }

    public void setProject(Project project) {
        removeAllChildren();
        this.project = project;
        setName(project.getName());
        filterTestCases();
    }

    public void filterTestCases() {
        for (Scenario scenario : project.getScenarios()) {
            for (TestCase testCase : scenario.getTestcasesAlone()) {
                add(testCase);
            }
        }
    }

    public void add(TestCase testCase) {
        addScenarioIfNotPresent(testCase.getScenario()).addTestCaseIfNotPresent(testCase);
    }

    @Override
    public boolean rename(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
