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
public class TestSetNode extends CommonNode {

    TestSet testSet;

    public TestSetNode(TestSet testSet) {
        this.testSet = testSet;
    }

    public TestSet getTestSet() {
        return testSet;
    }

    @Override
    public String toString() {
        return testSet.getName();
    }

   public static List<TestSetNode> toList(Enumeration<TreeNode> children){
       return Collections.list(children).stream().map(tsNode -> (TestSetNode) tsNode).collect(Collectors.toList());       
   }
}
