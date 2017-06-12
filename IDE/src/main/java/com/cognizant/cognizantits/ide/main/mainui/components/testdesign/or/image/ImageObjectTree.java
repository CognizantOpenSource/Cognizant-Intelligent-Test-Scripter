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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign.or.image;

import com.cognizant.cognizantits.datalib.component.Project;
import com.cognizant.cognizantits.datalib.component.TestCase;
import com.cognizant.cognizantits.datalib.or.common.ORObjectInf;
import com.cognizant.cognizantits.datalib.or.common.ORRootInf;
import com.cognizant.cognizantits.datalib.or.image.ImageORObject;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.or.ObjectTree;
import java.util.List;
import javax.swing.tree.TreePath;

/**
 *
 * 
 */
public class ImageObjectTree extends ObjectTree {

    private final ImageORPanel oRPanel;

    public ImageObjectTree(ImageORPanel sProxy) {
        this.oRPanel = sProxy;
    }

    @Override
    public void loadTableModelForSelection() {
        TreePath path = tree.getSelectionPath();
        if (path != null) {
            oRPanel.loadTableModelForSelection(path.getLastPathComponent());
        }
    }

    @Override
    public Project getProject() {
        return oRPanel.getProject();
    }

    @Override
    public void showImpactedTestCases(List<TestCase> testcases, String pageName, String objectName) {
        oRPanel.getTestDesign().getImpactUI().loadForObject(testcases, pageName, objectName);
    }

    @Override
    public ORRootInf getOR() {
        return oRPanel.getProject().getObjectRepository().getImageOR();
    }

    @Override
    protected void objectRemoved(ORObjectInf object) {
        if (getLoadedObject() != null
                && getLoadedObject().equals(object)) {
            oRPanel.getObjectTable().reset();
        }
        super.objectRemoved(object);
    }

    public ImageORObject getLoadedObject() {
        return oRPanel.getObjectTable().getObject();
    }
}
