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
package com.cognizant.cognizantits.ide.main.mainui.components.testexecution;

import com.cognizant.cognizantits.datalib.component.Project;
import com.cognizant.cognizantits.ide.main.mainui.AppMainFrame;
import com.cognizant.cognizantits.ide.main.mainui.components.testexecution.testset.TestsetComponent;
import com.cognizant.cognizantits.ide.main.mainui.components.testexecution.tree.TestSetTree;

/**
 *
 * 
 */
public class TestExecution {

    private final TestExecutionUI testExecutionUI;

    private final TestsetComponent testSetComp;

    private final TestSetTree testSetTree;

    private final AppMainFrame sMainFrame;

    public TestExecution(AppMainFrame sMainFrame) {
        this.sMainFrame = sMainFrame;
        testSetComp = new TestsetComponent(this);
        testSetTree = new TestSetTree(this);
        testExecutionUI = new TestExecutionUI(this);
    }

    public TestExecutionUI getTestExecutionUI() {
        return testExecutionUI;
    }

    public TestsetComponent getTestSetComp() {
        return testSetComp;
    }

    public TestSetTree getTestSetTree() {
        return testSetTree;
    }

    public AppMainFrame getsMainFrame() {
        return sMainFrame;
    }

    public final void load() {
        testSetComp.load();
        testSetTree.load();
    }

    public Project getProject() {
        return sMainFrame.getProject();
    }

    public final void afterProjectChange() {
        testExecutionUI.loadTestPlanModel();
        testExecutionUI.adjustUI();
    }

    public void reloadBrowsers() {
        testSetComp.loadBrowsers();
    }

    public String getDefaultBrowser() {
        return sMainFrame.getTestDesign().getDefaultBrowser();
    }
}
