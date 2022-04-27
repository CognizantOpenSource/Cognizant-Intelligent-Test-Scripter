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
package com.cognizant.cognizantits.ide.main.mainui.components.testexecution.tree.model;

import com.cognizant.cognizantits.datalib.component.Project;
import com.cognizant.cognizantits.datalib.component.Release;
import com.cognizant.cognizantits.datalib.component.TestSet;
import com.cognizant.cognizantits.ide.main.utils.tree.CommonNode;
import java.util.Collections;
import java.util.List;
import java.util.Enumeration;
import javax.swing.tree.TreeNode;

/**
 *
 * 
 */
public class TestLabNode extends CommonNode {

    Project project;

    public void setProject(Project project) {
        removeAllChildren();
        this.project = project;
        filterTestSets();
    }

    private void filterTestSets() {
        for (Release scenario : project.getReleases()) {
            for (TestSet testSet : scenario.getTestSets()) {
                addReleaseIfNotPresent(testSet.getRelease()).addTestSetIfNotPresent(testSet);
            }
        }
    }

    public ReleaseNode addReleaseIfNotPresent(Release release) {
        addRelease(release);
        return getReleaseBy(release);
    }

    public ReleaseNode addRelease(Release release) {
        if (getReleaseBy(release) == null) {
            ReleaseNode node = new ReleaseNode(release);
            add(node);
            return node;
        }
        return null;
    }

    public ReleaseNode getReleaseBy(Release release) {
        //for (TreeNode releaseNode : Collections.list(children())) {
    	List<TreeNode> releaseNodes = Collections.list(children());
    	for(TreeNode releaseNode :releaseNodes) {
            if (((ReleaseNode)releaseNode).getRelease().equals(release)) {
                return (ReleaseNode)releaseNode;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return project != null ? project.getName() : "Reusable";
    }

}
