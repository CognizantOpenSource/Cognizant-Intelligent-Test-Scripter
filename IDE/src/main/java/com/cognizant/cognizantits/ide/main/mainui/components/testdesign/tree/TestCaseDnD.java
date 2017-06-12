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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign.tree;

import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.tree.model.ProjectTreeModel;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.tree.model.ScenarioNode;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.tree.model.TestCaseNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class TestCaseDnD {

    final ProjectTreeModel model;
    
    private List<TestCaseNode> testCaseList = new ArrayList<>();

    private List<ScenarioNode> scenarioList = new ArrayList<>();

    public TestCaseDnD(ProjectTreeModel model) {
        this.model = model;
    }

    public List<TestCaseNode> getTestCaseList() {
        return testCaseList;
    }

    public TestCaseDnD withTestCaseList(List<TestCaseNode> testCaseList) {
        this.testCaseList = testCaseList;
        return this;
    }

    public List<ScenarioNode> getScenarioList() {
        return scenarioList;
    }

    public TestCaseDnD withScenarioList(List<ScenarioNode> scenarioList) {
        this.scenarioList = scenarioList;
        return this;
    }

    public Boolean isTestCases() {
        return !testCaseList.isEmpty();
    }

}
