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

import com.cognizant.cognizantits.datalib.component.Scenario;
import com.cognizant.cognizantits.datalib.component.TestCase;
import com.cognizant.cognizantits.ide.main.utils.tree.CommonNode;
import java.util.Collections;
import java.util.Enumeration;

/**
 *
 * 
 */
public class ScenarioNode extends CommonNode {

    Scenario scenario;

    public ScenarioNode(Scenario scenario) {
        this.scenario = scenario;
    }

    public TestCaseNode addTestCaseIfNotPresent(TestCase testCase) {
        addTestCase(testCase);
        return getTestCaseNodeBy(testCase);
    }

    public TestCaseNode addTestCase(TestCase testCase) {
        if (getTestCaseNodeBy(testCase) == null) {
            TestCaseNode node = new TestCaseNode(testCase);
            add(node);
            return node;
        }
        return null;
    }

    public TestCaseNode getTestCaseNodeBy(TestCase testCaseName) {
        for (TestCaseNode testCase : Collections.list(children())) {
            if (testCase.getTestCase().equals(testCaseName)) {
                return testCase;
            }
        }
        return null;
    }

    public Scenario getScenario() {
        return scenario;
    }

    @Override
    public String toString() {
        return scenario.getName();
    }

    @Override
    public Enumeration<TestCaseNode> children() {
        return super.children(); //To change body of generated methods, choose Tools | Templates.
    }

}
