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
package com.cognizant.cognizantits.ide.main.shr.web;

import com.cognizant.cognizantits.datalib.or.common.ObjectGroup;
import com.cognizant.cognizantits.datalib.or.web.WebOR;
import com.cognizant.cognizantits.datalib.or.web.WebORObject;
import com.cognizant.cognizantits.datalib.or.web.WebORPage;
import com.cognizant.cognizantits.extension.conector.DataConnector;
import com.cognizant.cognizantits.extension.extensionPojo.addonObject.Prop;
import com.cognizant.cognizantits.extension.extensionPojo.addonObject.RecordObject;
import com.cognizant.cognizantits.extension.extensionPojo.heal.FindResults;
import com.cognizant.cognizantits.extension.server.ExtensionServer;
import com.cognizant.cognizantits.ide.main.mainui.AppMainFrame;
import com.cognizant.cognizantits.ide.main.utils.table.XTable;
import com.cognizant.cognizantits.ide.main.utils.tree.TreeSelectionRenderer;
import com.cognizant.cognizantits.ide.settings.IconSettings;
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * 
 */
public class ObjectSpy extends javax.swing.JFrame {

    WebORObject dummyObject;
    DataConnector dataConnector;
    WebOR webOR;

    XTable objectTable;

    private final AppMainFrame sMainFrame;

    public ObjectSpy(AppMainFrame sMainFrame) {
        initComponents();
        objectTable = new XTable();
        bottomPanel.add(new JScrollPane(objectTable), BorderLayout.CENTER);
        setIconImage(IconSettings.getIconSettings().getObjectSpyLarge().getImage());
        this.sMainFrame = sMainFrame;
        dummyObject = new WebORObject();
        dataConnector = new DataConnector() {
            @Override
            public void onRecieve(RecordObject rObject) {
                try {
                    setValues(rObject);
                } catch (Exception ex) {
                    Logger.getLogger(ObjectSpy.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onRecieve(FindResults rObject) {
                //
            }
        };
        objectTable.setModel(dummyObject);
        objectTree.setCellRenderer(sMainFrame.getTestDesign().getObjectRepo()
                .getWebOR().getObjectTree().getTree().getCellRenderer());
        TreeSelectionRenderer.installFor(objectTree);
    }

    public void load() {
        this.webOR = sMainFrame.getProject().getObjectRepository().getWebOR();
        objectTree.setModel(sMainFrame.getTestDesign().getObjectRepo()
                .getWebOR().getObjectTree().getTree().getModel());
    }

    public void start() {
        ExtensionServer.get().withDataReciever(dataConnector).startSpy();
        setStatus("");
    }

    public void closeWindow() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void setValues(RecordObject rObject) {
        dummyObject.setDefaultORAttributes();
        dummyObject.setName(rObject.getObjectname());
        frameVal.setText(Objects.toString(rObject.getFrame(), ""));
        dummyObject.setFrame(Objects.toString(rObject.getFrame(), ""));
        for (Prop object : rObject.getProp()) {
            dummyObject.addNewAttribute(object.getProp());
            dummyObject.setAttributeByName(object.getProp(), Objects.toString(object.getVal(), ""));
        }
        if (rObject.getAction().equalsIgnoreCase("save")) {
            saveObject(rObject);
        }
        objectTable.repaint();
    }

    private void saveObject(RecordObject rObject) {
        if (addToSelected.isSelected()) {
            saveObjectToSelected(rObject);
        } else {
            saveObjectToRep(rObject);
        }
    }

    private void saveObjectToRep(RecordObject rObject) {
        WebORPage page = webOR.getPageByTitle(rObject.getPage().getTitle());
        if (page == null) {
            String pageName = rObject.getPage().getName();
            int i = 1;
            while (webOR.getPageByName(pageName) != null) {
                pageName = rObject.getPage().getName() + i++;
            }
            page = webOR.addPage(pageName);
            page.setTitle(rObject.getPage().getTitle());
            ((DefaultTreeModel) objectTree.getModel()).nodesWereInserted(webOR, new int[]{webOR.getChildCount() - 1});
        }
        saveObjectToPage(page, rObject);
    }

    private void saveObjectToPage(WebORPage page, RecordObject rObject) {
        WebORObject dupObj = findDuplicate(page);
        if (dupObj == null) {
            String objName = Objects.toString(rObject.getObjectname(), "Object");
            int i = 1;
            while (page.getObjectGroupByName(objName) != null) {
                objName = rObject.getObjectname() + i++;
            }
            WebORObject newObj = page.addObject(objName);
            dummyObject.clone(newObj);
            setStatus("Object Added : " + objName);
            ((DefaultTreeModel) objectTree.getModel()).nodesWereInserted(page, new int[]{page.getChildCount() - 1});
            objectTree.scrollPathToVisible(newObj.getTreePath());
        } else {
            setStatus("Object Already Present - Page : " + page.getName() + " - Object : " + dupObj.getName());
        }
    }

    private void saveObjectToGroup(ObjectGroup<WebORObject> group, RecordObject rObject) {
        WebORObject dupObj = null;
        for (WebORObject object : group.getObjects()) {
            if (object.isEqualOf(dummyObject)) {
                dupObj = object;
            }
        }
        if (dupObj == null) {
            String objName = rObject.getObjectname();
            int i = 1;
            while (group.getObjectByName(objName) != null) {
                objName = rObject.getObjectname() + i++;
            }
            WebORObject newObj = group.addObject(objName);
            dummyObject.clone(newObj);
            setStatus("Object Added : " + objName);
            ((DefaultTreeModel) objectTree.getModel()).nodesWereInserted(group, new int[]{group.getChildCount() - 1});
            if (group.getChildCount() == 2) {
                ((DefaultTreeModel) objectTree.getModel()).reload(group.getParent());
            }
            objectTree.scrollPathToVisible(newObj.getTreePath());
        } else {
            setStatus("Object Similar To [ Object : " + dupObj.getName() + " ]");
        }

    }

    private void saveObjectToSelected(RecordObject rObject) {
        if (objectTree.getSelectionPath() != null) {
            Object obj = objectTree.getSelectionPath().getLastPathComponent();
            if (obj instanceof WebORPage) {
                saveObjectToPage((WebORPage) obj, rObject);
            } else if (obj instanceof ObjectGroup) {
                saveObjectToGroup((ObjectGroup) obj, rObject);
            } else if (obj instanceof WebORObject) {
                saveObjectToGroup(((WebORObject) obj).getParent(), rObject);
            }
        } else {
            saveObjectToRep(rObject);
        }
    }

    private WebORObject findDuplicate(WebORPage page) {
        for (ObjectGroup<WebORObject> objectGroup : page.getObjectGroups()) {
            for (WebORObject object : objectGroup.getObjects()) {
                if (object.isEqualOf(dummyObject)) {
                    return object;
                }
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar3 = new javax.swing.JToolBar();
        status = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        addToSelected = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        objectTree = new javax.swing.JTree();
        bottomPanel = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jLabel1 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        frameVal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Object Spy");
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jToolBar3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        status.setForeground(java.awt.Color.blue);
        jToolBar3.add(status);

        getContentPane().add(jToolBar3, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(filler1);

        addToSelected.setText("Add to selected Page/Group");
        addToSelected.setFocusable(false);
        addToSelected.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addToSelected.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                addToSelectedItemStateChanged(evt);
            }
        });
        jToolBar1.add(addToSelected);

        jButton1.setText(" ");
        jButton1.setEnabled(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jPanel1.add(jToolBar1, java.awt.BorderLayout.NORTH);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(0.6);

        objectTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                objectTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(objectTree);

        jSplitPane1.setTopComponent(jScrollPane1);

        bottomPanel.setLayout(new java.awt.BorderLayout());

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.add(filler3);

        jLabel1.setText("Frame");
        jToolBar2.add(jLabel1);
        jToolBar2.add(filler2);

        frameVal.setText("Name / Id / Index");
        jToolBar2.add(frameVal);

        bottomPanel.add(jToolBar2, java.awt.BorderLayout.PAGE_START);
        jToolBar2.setLayout(new javax.swing.BoxLayout(jToolBar2, javax.swing.BoxLayout.X_AXIS));

        jSplitPane1.setRightComponent(bottomPanel);

        jPanel1.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void objectTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_objectTreeValueChanged
        Object obj = evt.getPath().getLastPathComponent();
        if (addToSelected.isSelected()) {
            changeToolTip(obj);
        }
    }//GEN-LAST:event_objectTreeValueChanged

    private void changeToolTip(Object obj) {
        if (obj instanceof WebORPage) {
            addToSelected.setToolTipText("Page - " + ((WebORPage) obj).getName());
        } else if (obj instanceof ObjectGroup) {
            addToSelected.setToolTipText("Group - " + ((ObjectGroup) obj).getName());
        } else if (obj instanceof WebORObject) {
            addToSelected.setToolTipText("Group - " + ((WebORObject) obj).getParent().getName());
        }
    }

    private void addToSelectedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_addToSelectedItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (objectTree.getSelectionPath() != null) {
                changeToolTip(objectTree.getSelectionPath().getLastPathComponent());
            }
        } else {
            addToSelected.setToolTipText(null);
        }
    }//GEN-LAST:event_addToSelectedItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ExtensionServer.get().stop();
    }//GEN-LAST:event_formWindowClosing

    public void setStatus(String string) {
        status.setText(string);
        status.setToolTipText(string);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox addToSelected;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JTextField frameVal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JTree objectTree;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
