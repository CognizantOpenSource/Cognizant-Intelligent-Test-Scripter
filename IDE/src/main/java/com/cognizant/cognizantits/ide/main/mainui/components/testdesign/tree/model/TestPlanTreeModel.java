/*
 * Copyright 2014 - 2019 Cognizant Technology Solutions
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
import java.util.List;
/**
 *
 * 
 */
public class TestPlanTreeModel extends ProjectTreeModel<TestPlanNode> {

    Project project;

    public TestPlanTreeModel() {
        super(new TestPlanNode());
    }

    public TestPlanTreeModel(TestPlanNode tpn) {
        super(tpn);
    }

    @Override
    public final void setProject(Project project) {
        this.project = project;
        getRoot().setProject(project);
    }

    @Override
    public TestPlanNode getRoot() {
        return (TestPlanNode) super.getRoot();
    }

    @Override
    public ScenarioNode addScenario(TestPlanNode groupNode, Scenario scenario) {
        if (groupNode == null) {
            groupNode = getRoot();
        }
        return super.addScenario(groupNode, scenario);
    }

    @Override
    public TestCaseNode addTestCase(TestCase testCase) {
        if (getRoot().getChildCount() > 0) {
            //for (ScenarioNode scenarioNode : ScenarioNode.toList(getRoot().children())) {
        	List<ScenarioNode> scenarioNodes = ScenarioNode.toList(getRoot().children());
        	for (ScenarioNode scenarioNode :scenarioNodes) {
                if (scenarioNode.getScenario().equals(testCase.getScenario())) {
                    return addTestCase(scenarioNode, testCase);
                }
            }
        }
        return addTestCase(addScenario(getRoot(), testCase.getScenario()), testCase);
    }

    @Override
    public void onScenarioRename(Scenario scenario) {
        if (getRoot().getChildCount() > 0) {
            ScenarioNode sNode = getRoot().getScenarioNodeBy(scenario);
            if (sNode != null) {
                reload(sNode);
            }
        }
    }

}
