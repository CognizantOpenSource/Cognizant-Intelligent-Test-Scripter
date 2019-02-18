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
public class TestCaseNode extends CommonNode {

    TestCase testCase;

    public TestCaseNode(TestCase testCase) {
        this.testCase = testCase;
    }

    public TestCase getTestCase() {
        return testCase;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String toString() {
        return testCase.getName();
    }

    public static List<TestCaseNode> toList(Enumeration<TreeNode> children) {
        return Collections.list(children).stream().map(tsNode -> (TestCaseNode) tsNode).collect(Collectors.toList());
    }
}
