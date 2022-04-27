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

import com.cognizant.cognizantits.datalib.component.Release;
import com.cognizant.cognizantits.datalib.component.TestSet;
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
public class ReleaseNode extends CommonNode {

    Release release;

    public ReleaseNode(Release release) {
        this.release = release;
    }

    public Release getRelease() {
        return release;
    }

    public TestSetNode addTestSetIfNotPresent(TestSet testSet) {
        addTestSet(testSet);
        return getTestSetBy(testSet);
    }

    public TestSetNode addTestSet(TestSet testSet) {
        if (getTestSetBy(testSet) == null) {
            TestSetNode node = new TestSetNode(testSet);
            add(node);
            return node;
        }
        return null;
    }

     public TestSetNode getTestSetBy(TestSet testSet) {
        //for (TestSetNode testSetNode : TestSetNode.toList(children())) {
    	List<TestSetNode> testSetNodes = TestSetNode.toList(children());
     	for (TestSetNode testSetNode :testSetNodes) {
            if (testSetNode.getTestSet().equals(testSet)) {
                return testSetNode;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return release.getName();
    }

   public static List<ReleaseNode> toList(Enumeration<TreeNode> children){
       return Collections.list(children).stream().map(tsNode -> (ReleaseNode) tsNode).collect(Collectors.toList());
       
   }
}
