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
import com.cognizant.cognizantits.ide.main.utils.tree.CommonTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * 
 * @param <T>
 */
public abstract class ProjectTreeModel<T extends GroupNode> extends CommonTreeModel {

    public ProjectTreeModel(TreeNode tn) {
        super(tn);
    }

    @Override
    public void valueForPathChanged(TreePath tp, Object o) {
        //Do nothing
    }

    public ScenarioNode addScenario(T groupNode, Scenario scenario) {
        if (groupNode.getScenarioNodeBy(scenario) == null) {
            ScenarioNode sNode = new ScenarioNode(scenario);
            insertNodeInto(sNode, groupNode, groupNode.getChildCount());
            return sNode;
        }
        return null;
    }

    public TestCaseNode addTestCase(ScenarioNode scNode, TestCase testCase) {
        if (scNode.getTestCaseNodeBy(testCase) == null) {
            TestCaseNode tcNode = new TestCaseNode(testCase);
            insertNodeInto(tcNode, scNode, scNode.getChildCount());
            return tcNode;
        }
        return null;
    }

    public abstract TestCaseNode addTestCase(TestCase testCase);
    
    public abstract void onScenarioRename(Scenario scenario);
}
