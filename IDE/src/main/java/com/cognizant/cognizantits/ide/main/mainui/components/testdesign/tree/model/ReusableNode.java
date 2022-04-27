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
import com.cognizant.cognizantits.ide.main.utils.tree.CommonNode;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.tree.TreeNode;

/**
 *
 * 
 */
public class ReusableNode extends CommonNode {

    Project project;

    public void setProject(Project project) {
        removeAllChildren();
        this.project = project;
        filterGroups();
    }

    private void filterGroups() {
        for (Scenario scenario : project.getScenarios()) {
            for (TestCase reusable : scenario.getReusables()) {
                String groupName = reusable.getReusable().getGroup();
                addGroupIfNotPresent(groupName).addScenarioIfNotPresent(reusable.getScenario()).addTestCaseIfNotPresent(reusable);
            }
        }
    }

    public GroupNode addGroupIfNotPresent(String groupName) {
        addGroup(groupName);
        return getGroupByName(groupName);
    }

    public GroupNode addGroup(String groupName) {
        if (getGroupByName(groupName) == null) {
            GroupNode node = new GroupNode(groupName);
            add(node);
            return node;
        }
        return null;
    }

    public GroupNode getGroupByName(String groupName) {
      //  for (GroupNode group : GroupNode.toList(children())) {   Java 8 changes
        List<GroupNode> groups = GroupNode.toList(children());
        for (GroupNode group : groups) {

            if (group.toString().equals(groupName)) {
                return group;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return project != null ? project.getName() : "Reusable";
    }

   public static List<ReusableNode> toList(Enumeration<TreeNode> children){
       return Collections.list(children).stream().map(tsNode -> (ReusableNode) tsNode).collect(Collectors.toList());
       
   }

}
