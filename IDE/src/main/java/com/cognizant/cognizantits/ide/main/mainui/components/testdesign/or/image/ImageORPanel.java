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
import com.cognizant.cognizantits.datalib.or.common.ObjectGroup;
import com.cognizant.cognizantits.datalib.or.image.ImageORObject;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.TestDesign;
import com.cognizant.cognizantits.ide.main.utils.tree.TreeSearch;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * 
 */
public class ImageORPanel extends JPanel {

    private final ImageObjectTree objectTree;
    private final ImageORTable objectTable;

    private final TestDesign testDesign;

    private JSplitPane splitPane;

    public ImageORPanel(TestDesign testDesign) {
        this.testDesign = testDesign;
        this.objectTree = new ImageObjectTree(this);
        this.objectTable = new ImageORTable(this);
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setOneTouchExpandable(true);
        splitPane.setBottomComponent(objectTable);
        TreeSearch tSearch = TreeSearch.installForOR(objectTree.getTree());
        splitPane.setTopComponent(tSearch);
        splitPane.setResizeWeight(.5);
        splitPane.setDividerLocation(.5);
        add(splitPane);
    }

    void loadTableModelForSelection(Object object) {
        if (object instanceof ImageORObject) {
            objectTable.loadObject((ImageORObject) object);
        } else if (object instanceof ObjectGroup) {
            objectTable.loadObject((ImageORObject) ((ObjectGroup) object).getChildAt(0));
        } else {
            objectTable.reset();
        }
    }

    public TestDesign getTestDesign() {
        return testDesign;
    }

    public Project getProject() {
        return testDesign.getProject();
    }

    public void load() {
        objectTable.reset();
        objectTree.load();
        splitPane.setDividerLocation(.5);
    }

    public void adjustUI() {
        splitPane.setDividerLocation(0.5);
    }

    public ImageObjectTree getObjectTree() {
        return objectTree;
    }

    public Boolean navigateToObject(String objectName, String pageName) {
        return objectTree.navigateToObject(objectName, pageName);
    }

    public ImageORTable getObjectTable() {
        return objectTable;
    }

}
