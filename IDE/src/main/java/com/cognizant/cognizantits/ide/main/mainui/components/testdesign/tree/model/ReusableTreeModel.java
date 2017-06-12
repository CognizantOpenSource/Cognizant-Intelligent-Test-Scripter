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
import com.cognizant.cognizantits.datalib.component.Reusable;
import com.cognizant.cognizantits.datalib.component.Scenario;
import com.cognizant.cognizantits.datalib.component.TestCase;
import com.cognizant.cognizantits.datalib.component.utils.XMLOperation;
import java.io.File;
import java.util.Collections;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * 
 */
public class ReusableTreeModel extends ProjectTreeModel {

    Project project;

    public ReusableTreeModel() {
        super(new ReusableNode());
    }

    @Override
    public final void setProject(Project project) {
        this.project = project;
        getRoot().setProject(project);
    }

    @Override
    public ReusableNode getRoot() {
        return (ReusableNode) super.getRoot();
    }

    public GroupNode addGroup(String name) {
        if (getRoot().getGroupByName(name) == null) {
            GroupNode gNode = new GroupNode(name);
            insertNodeInto(gNode, getRoot(), getRoot().getChildCount());
            return gNode;
        }
        return null;
    }

    public void toggleAllTestCasesFrom(GroupNode groupNode) {
        for (ScenarioNode scenarioNode : Collections.list(groupNode.children())) {
            for (TestCaseNode testCaseNode : Collections.list(scenarioNode.children())) {
                testCaseNode.getTestCase().toggleAsReusable();
            }
        }
    }

    @Override
    public TestCaseNode addTestCase(TestCase testCase) {
        GroupNode groupNode;
        if (getRoot().getChildCount() > 0) {
            for (GroupNode group : Collections.list(getRoot().children())) {
                for (ScenarioNode scenarioNode : Collections.list(group.children())) {
                    if (scenarioNode.getScenario().equals(testCase.getScenario())) {
                        return addTestCase(scenarioNode, testCase);
                    }
                }
            }
            groupNode = (GroupNode) getRoot().getChildAt(0);
        } else {
            groupNode = addGroup("New Group");
        }
        return addTestCase(addScenario(groupNode, testCase.getScenario()), testCase);
    }

    @Override
    public TestCaseNode addTestCase(ScenarioNode scNode, TestCase testCase) {
        TestCaseNode tcNode = super.addTestCase(scNode, testCase);
        Reusable reusable = tcNode.getTestCase().getReusable();
        if (reusable == null) {
            reusable = new Reusable();
        }
        reusable.setGroup(scNode.getParent().toString());
        tcNode.getTestCase().setReusable(reusable);
        return tcNode;
    }

    @Override
    public void onScenarioRename(Scenario scenario) {
        if (getRoot().getChildCount() > 0) {
            for (GroupNode group : Collections.list(getRoot().children())) {
                ScenarioNode sNode = group.getScenarioNodeBy(scenario);
                if (sNode != null) {
                    reload(sNode);
                }
            }
        }
    }

    public void save() {
        String xml = project.getLocation() + File.separator + "ReusableComponent.xml";
        Document doc = XMLOperation.initTreeOp();
        Element rootElement = doc.createElement("Root");
        rootElement.setAttribute("type", "RC");
        rootElement.setAttribute("ref", project.getName());
        doc.appendChild(rootElement);
        saveProjectXML(rootElement);
        XMLOperation.finishTreeOp(doc, xml);
    }

    private void saveProjectXML(Element rootElement) {
        if (getRoot().getChildCount() > 0) {
            for (GroupNode group : Collections.list(getRoot().children())) {
                Element groupElement = createAndSetAttribute(rootElement, group);
                for (ScenarioNode scenarioNode : Collections.list(group.children())) {
                    Element scenarioElement = createAndSetAttribute(groupElement, scenarioNode.scenario);
                    for (TestCaseNode testCaseNode : Collections.list(scenarioNode.children())) {
                        createAndSetAttribute(scenarioElement, testCaseNode.testCase);
                    }
                }
            }
        }
    }

    private Element createAndSetAttribute(Element parentElement, GroupNode group) {
        Element newElement = parentElement.getOwnerDocument().createElement("Folder");
        newElement.setAttribute("ref", group.toString());
        parentElement.appendChild(newElement);
        return newElement;
    }

    private Element createAndSetAttribute(Element parentElement, Scenario scenario) {
        Element newElement = parentElement.getOwnerDocument().createElement("Scenario");
        newElement.setAttribute("ref", scenario.getName());
        parentElement.appendChild(newElement);
        return newElement;
    }

    private void createAndSetAttribute(Element parentElement, TestCase testCase) {
        Element newElement = parentElement.getOwnerDocument().createElement("TestCase");
        newElement.setAttribute("ref", testCase.getName());
        newElement.setAttribute("exeType", testCase.getReusable().getExecutableType());
        parentElement.appendChild(newElement);
    }

}
