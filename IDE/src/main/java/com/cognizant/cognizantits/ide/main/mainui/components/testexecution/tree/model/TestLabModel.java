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
import com.cognizant.cognizantits.ide.main.utils.tree.CommonTreeModel;
import java.util.Collections;
import java.util.List;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * 
 */
public class TestLabModel extends CommonTreeModel {

    Project project;

    public TestLabModel() {
        super(new TestLabNode());
    }

    @Override
    public TestLabNode getRoot() {
        return (TestLabNode) super.getRoot();
    }

    @Override
    public void setProject(Project project) {
        this.project = project;
        getRoot().setProject(project);
    }

    @Override
    public void valueForPathChanged(TreePath tp, Object o) {
        //Not Needed
    }

    public ReleaseNode addRelease(Release release) {
        if (getRoot().getReleaseBy(release) == null) {
            ReleaseNode rNode = new ReleaseNode(release);
            insertNodeInto(rNode, getRoot(), getRoot().getChildCount());
            return rNode;
        }
        return null;
    }

    public TestSetNode addTestSet(ReleaseNode rNode, TestSet testSet) {
        if (rNode.getTestSetBy(testSet) == null) {
            TestSetNode tsNode = new TestSetNode(testSet);
            insertNodeInto(tsNode, rNode, rNode.getChildCount());
            return tsNode;
        }
        return null;
    }

    public TestSetNode addTestSet(TestSet testset) {
        if (getRoot().getChildCount() > 0) {
            //for (ReleaseNode releaseNode : ReleaseNode.toList(getRoot().children())) {
        	List<ReleaseNode> releaseNodes = ReleaseNode.toList(getRoot().children());
			for (ReleaseNode releaseNode : releaseNodes) {
                if (releaseNode.getRelease().equals(testset.getRelease())) {
                    return addTestSet(releaseNode, testset);
                }
            }
        }
        return addTestSet(addRelease(testset.getRelease()), testset);
    }

    

}
