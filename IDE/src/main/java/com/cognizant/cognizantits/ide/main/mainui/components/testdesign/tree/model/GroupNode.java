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
import com.cognizant.cognizantits.ide.main.utils.tree.CommonNode;
import java.util.Collections;
import java.util.Enumeration;

/**
 *
 * 
 */
public class GroupNode extends CommonNode {

    private String name;

    public GroupNode(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ScenarioNode addScenarioIfNotPresent(Scenario scenario) {
        addScenario(scenario);
        return getScenarioNodeBy(scenario);
    }

    public ScenarioNode addScenario(Scenario scenario) {
        if (getScenarioNodeBy(scenario) == null) {
            ScenarioNode node = new ScenarioNode(scenario);
            this.add(node);
            return node;
        }
        return null;
    }

    public ScenarioNode getScenarioNodeBy(Scenario scenario) {
        for (ScenarioNode scenarioNode : Collections.list(children())) {
            if (scenarioNode.getScenario().equals(scenario)) {
                return scenarioNode;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Enumeration<ScenarioNode> children() {
        return super.children(); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean rename(String name) {
        ReusableNode rNode = (ReusableNode) getParent();
        if (rNode.getGroupByName(name) == null) {
            setName(name);
            for (ScenarioNode scenarioNode : Collections.list(children())) {
                for (TestCaseNode testCaseNode : Collections.list(scenarioNode.children())) {
                    testCaseNode.getTestCase().getReusable().setGroup(name);
                }
            }
            return true;
        }
        return false;
    }

}
