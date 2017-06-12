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
package com.cognizant.cognizantits.ide.main.utils.tree;

import com.cognizant.cognizantits.datalib.component.Project;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * 
 */
public abstract class CommonTreeModel extends DefaultTreeModel {

    public CommonTreeModel(TreeNode tn) {
        super(tn);
    }

    public abstract void setProject(Project project);

    public void sort(Object selectedObject) {
        if (selectedObject instanceof CommonNode) {
            CommonNode selectedNode = (CommonNode) selectedObject;
            selectedNode.sort();
            reload(selectedNode);
        }
    }

    public DefaultMutableTreeNode getFirstNode() {
        return ((DefaultMutableTreeNode) getRoot()).getFirstLeaf();
    }
}
