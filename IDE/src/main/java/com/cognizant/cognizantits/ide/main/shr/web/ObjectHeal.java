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

import com.cognizant.cognizantits.datalib.or.common.ORAttribute;
import com.cognizant.cognizantits.datalib.or.common.ObjectGroup;
import com.cognizant.cognizantits.datalib.or.web.WebOR;
import com.cognizant.cognizantits.datalib.or.web.WebORObject;
import com.cognizant.cognizantits.datalib.or.web.WebORPage;
import com.cognizant.cognizantits.engine.drivers.findObjectBy.support.ByObjectProp;
import com.cognizant.cognizantits.extension.conector.DataConnector;
import com.cognizant.cognizantits.extension.extensionPojo.addonObject.RecordObject;
import com.cognizant.cognizantits.extension.extensionPojo.heal.FindObjects;
import com.cognizant.cognizantits.extension.extensionPojo.heal.FindResults;
import com.cognizant.cognizantits.extension.extensionPojo.heal.HealObject;
import com.cognizant.cognizantits.extension.extensionPojo.heal.Prop;
import com.cognizant.cognizantits.extension.server.ExtensionServer;
import com.cognizant.cognizantits.ide.main.mainui.AppMainFrame;
import com.cognizant.cognizantits.ide.main.utils.table.XTable;
import com.cognizant.cognizantits.ide.main.utils.tree.TreeSelectionRenderer;
import com.cognizant.cognizantits.ide.settings.IconSettings;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowEvent;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * 
 */
public class ObjectHeal extends javax.swing.JFrame {

    WebORObject dummyObject;
    DataConnector dataConnector;
    WebOR webOR;

    XTable objectTable;

    XTable newPropTable;

    private final AppMainFrame sMainFrame;

    private TreeCellRenderer renderer;

    enum Found {
        YES,
        NO,
        MANY,
        DEFAULT;

        public static Found parseString(String value) {
            switch (value) {
                case "true":
                    return YES;
                case "false":
                    return NO;
                case "partial":
                    return MANY;
            }
            return DEFAULT;
        }
    }

    public ObjectHeal(AppMainFrame sMainFrame) {
        initComponents();
        setIconImage(IconSettings.getIconSettings().getObjectHealLarge().getImage());
        this.sMainFrame = sMainFrame;
        dummyObject = new WebORObject();
        dataConnector = new DataConnector() {
            @Override
            public void onRecieve(RecordObject rObject) {
                try {
                    setValues(rObject);
                } catch (Exception ex) {
                    Logger.getLogger(ObjectHeal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onRecieve(FindResults rObject) {
                try {
                    higlightObjects(rObject);
                } catch (Exception ex) {
                    Logger.getLogger(ObjectHeal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        initTable();
    }

    private void initTable() {
        objectTable = new XTable();
        newPropTable = new XTable();

        objectPanel.add(new JScrollPane(objectTable), BorderLayout.CENTER);
        newPropPanel.add(new JScrollPane(newPropTable), BorderLayout.CENTER);

        objectTable.setModel(new WebORObject());
        newPropTable.setModel(dummyObject);
        newPropTable.getColumnModel().removeColumn(newPropTable.getColumnModel().getColumn(0));
        setColorRenderer();
    }

    private void setColorRenderer() {
        renderer = sMainFrame.getTestDesign().getObjectRepo()
                .getWebOR().getObjectTree().getTree().getCellRenderer();
        objectTree.setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree pTree,
                    Object pValue, boolean pIsSelected, boolean pIsExpanded,
                    boolean pIsLeaf, int pRow, boolean pHasFocus) {
                Component comp = renderer.getTreeCellRendererComponent(pTree, pValue, pIsSelected, pIsExpanded, pIsLeaf, pRow, pHasFocus);
                if (pValue instanceof WebORObject) {
                    WebORObject object = (WebORObject) pValue;
                    comp.setForeground(Color.BLACK);

                    if (object.getFound() != null && object.getFound() instanceof Found) {
                        switch ((Found) object.getFound()) {
                            case YES:
                                comp.setForeground(pIsSelected ? Color.GREEN : Color.decode("#008000"));
                                break;
                            case NO:
                                comp.setForeground(Color.RED);
                                break;
                            case MANY:
                                comp.setForeground(Color.MAGENTA);
                                break;
                            case DEFAULT:
                                comp.setForeground(pIsSelected ? Color.WHITE : Color.BLACK);
                                break;
                            default:
                                break;
                        }
                    }

                }
                return comp;
            }
        });
        ((TreeSelectionRenderer) renderer).install(objectTree);
    }

    public void load() {
        this.webOR = sMainFrame.getProject().getObjectRepository().getWebOR();
        objectTree.setModel(sMainFrame.getTestDesign().getObjectRepo()
                .getWebOR().getObjectTree().getTree().getModel());
    }

    private void adjustUI() {
        jSplitPane1.setDividerLocation(.55);
    }

    public void start() {
        adjustUI();
        ExtensionServer.get().withDataReciever(dataConnector).startHeal();
        for (WebORPage page : webOR.getPages()) {
            for (ObjectGroup<WebORObject> group : page.getObjectGroups()) {
                for (WebORObject object : group.getObjects()) {
                    object.setFound(Found.DEFAULT);
                }
            }
        }
        setStatus("");
    }

    public void closeWindow() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void setValues(RecordObject rObject) {
        dummyObject.setDefaultORAttributes();
        dummyObject.setName(rObject.getObjectname());
        dummyObject.setFrame(Objects.toString(rObject.getFrame(), ""));
        for (com.cognizant.cognizantits.extension.extensionPojo.addonObject.Prop object : rObject.getProp()) {
            dummyObject.addNewAttribute(object.getProp());
            dummyObject.setAttributeByName(object.getProp(), Objects.toString(object.getVal(), ""));
        }
        newFrameVal.setText(dummyObject.getFrame());
        newPropTable.repaint();
        if (rObject.getAction().equalsIgnoreCase("save")) {
            updateObject();
        }
    }

    private void updateObject() {
        if (objectTree.getSelectionPath() != null) {
            Object obj = objectTree.getSelectionPath().getLastPathComponent();
            if (obj instanceof WebORObject) {
                dummyObject.clone((WebORObject) obj);
                setStatus(((WebORObject) obj).getName()
                        + " updated with new values");
            } else {
                setStatus("Invalid Selection - Please select an object");
            }
        } else {
            setStatus("Invalid Selection - Please select an object");
        }
    }

    private void higlightObjects(FindResults rObject) {
        if (rObject.getObjectname().contains("####")) {
            String groupName = rObject.getObjectname().split("####")[0];
            String objName = rObject.getObjectname().split("####")[1];
            WebORObject obj = webOR.getPageByName(rObject.getPageName()).getObjectGroupByName(groupName).getObjectByName(objName);
            Found objFound = (Found) obj.getFound();
            Found hFound = Found.parseString(rObject.getExist());
            if (objFound.equals(Found.DEFAULT) || objFound.equals(Found.NO)) {
                obj.setFound(hFound);
                objectTree.repaint();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        objectTree = new javax.swing.JTree();
        propSplitPane = new javax.swing.JSplitPane();
        oldObjPanel = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        jButton1 = new javax.swing.JButton();
        objectPanel = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jLabel1 = new javax.swing.JLabel();
        frameVal = new javax.swing.JTextField();
        newObjPanel = new javax.swing.JPanel();
        jToolBar4 = new javax.swing.JToolBar();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        jButton2 = new javax.swing.JButton();
        newPropPanel = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        newFrameVal = new javax.swing.JTextField();
        jToolBar5 = new javax.swing.JToolBar();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Object Heal");
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jSplitPane1.setDividerSize(8);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(0.8);

        objectTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                objectTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(objectTree);

        jSplitPane1.setTopComponent(jScrollPane1);

        propSplitPane.setDividerSize(2);
        propSplitPane.setResizeWeight(0.75);

        oldObjPanel.setLayout(new java.awt.BorderLayout());

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);
        jToolBar3.add(filler2);

        jButton1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton1.setText("Old Properties");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton1);

        oldObjPanel.add(jToolBar3, java.awt.BorderLayout.NORTH);

        objectPanel.setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(filler1);

        jLabel1.setText("Frame ");
        jToolBar1.add(jLabel1);

        frameVal.setText("Name / Id /Index");
        jToolBar1.add(frameVal);

        objectPanel.add(jToolBar1, java.awt.BorderLayout.PAGE_START);
        jToolBar1.setLayout(new javax.swing.BoxLayout(jToolBar1, javax.swing.BoxLayout.X_AXIS));

        oldObjPanel.add(objectPanel, java.awt.BorderLayout.CENTER);

        propSplitPane.setLeftComponent(oldObjPanel);

        newObjPanel.setLayout(new java.awt.BorderLayout());

        jToolBar4.setFloatable(false);
        jToolBar4.setRollover(true);
        jToolBar4.add(filler3);

        jButton2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton2.setText("New Properties");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar4.add(jButton2);

        newObjPanel.add(jToolBar4, java.awt.BorderLayout.NORTH);

        newPropPanel.setLayout(new java.awt.BorderLayout());

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        newFrameVal.setText("Name / Id / Index");
        jToolBar2.add(newFrameVal);

        newPropPanel.add(jToolBar2, java.awt.BorderLayout.PAGE_START);
        jToolBar2.setLayout(new javax.swing.BoxLayout(jToolBar2, javax.swing.BoxLayout.X_AXIS));

        newObjPanel.add(newPropPanel, java.awt.BorderLayout.CENTER);

        propSplitPane.setRightComponent(newObjPanel);

        jSplitPane1.setBottomComponent(propSplitPane);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        jToolBar5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar5.setFloatable(false);
        jToolBar5.setRollover(true);

        status.setForeground(java.awt.Color.blue);
        jToolBar5.add(status);

        getContentPane().add(jToolBar5, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void objectTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_objectTreeValueChanged
        if (evt.getOldLeadSelectionPath() != null) {
            Object old = evt.getOldLeadSelectionPath().getLastPathComponent();
            resetOldObjects(old);
        }
        Object obj = evt.getPath().getLastPathComponent();
        if (obj instanceof WebORPage) {
            findObjects((WebORPage) obj);
        } else if (obj instanceof ObjectGroup) {
            findObjects((ObjectGroup<WebORObject>) obj);
        } else if (obj instanceof WebORObject) {
            findObjects((WebORObject) obj);
            frameVal.setText(((WebORObject) obj).getFrame());
            objectTable.setModel((WebORObject) obj);
            updatePreference((WebORObject) obj);
        }

    }//GEN-LAST:event_objectTreeValueChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ExtensionServer.get().stop();
    }//GEN-LAST:event_formWindowClosing

    private void updatePreference(WebORObject obj) {
        dummyObject.getAttributes().clear();
        for (ORAttribute attr : obj.getAttributes()) {
            dummyObject.addNewAttribute(attr.getName());
            dummyObject.getAttribute(attr.getName()).setPreference(attr.getPreference());
        }
    }

    private void resetOldObjects(Object obj) {
        if (obj instanceof WebORPage) {
            WebORPage page = (WebORPage) obj;
            for (ObjectGroup<WebORObject> group : page.getObjectGroups()) {
                for (WebORObject object : group.getObjects()) {
                    object.setFound(Found.DEFAULT);
                }
            }
        } else if (obj instanceof ObjectGroup) {
            ObjectGroup<WebORObject> group = (ObjectGroup<WebORObject>) obj;
            for (WebORObject object : group.getObjects()) {
                object.setFound(Found.DEFAULT);
            }
        } else if (obj instanceof WebORObject) {
            ((WebORObject) obj).setFound(Found.DEFAULT);
        }
    }

    private void findObjects(WebORPage page) {
        FindObjects foj = new FindObjects();
        for (ObjectGroup<WebORObject> objectGroup : page.getObjectGroups()) {
            for (WebORObject object : objectGroup.getObjects()) {
                foj.getObjects().add(getPOJO(object));
            }
        }
        ExtensionServer.get().send(DataConnector.parse(foj));
    }

    private void findObjects(ObjectGroup<WebORObject> objectGroup) {
        FindObjects foj = new FindObjects();
        for (WebORObject object : objectGroup.getObjects()) {
            foj.getObjects().add(getPOJO(object));
        }
        ExtensionServer.get().send(DataConnector.parse(foj));
    }

    private void findObjects(WebORObject object) {
        FindObjects foj = new FindObjects();
        foj.getObjects().add(getPOJO(object));
        ExtensionServer.get().send(DataConnector.parse(foj));
    }

    private HealObject getPOJO(WebORObject object) {
        HealObject hoj = new HealObject();
        hoj.setPageName(object.getPage().getName());
        hoj.setFrame(object.getFrame());
        hoj.setObjectname(object.getParent().getName() + "####" + object.getName());
        for (ORAttribute attr : object.getAttributes()) {
            Object val = ByObjectProp.get().getBy(attr.getName(), attr.getValue());
            if (val != null) {
                val = val.toString().substring(val.toString().indexOf(' ') + 1);
            } else {
                val = Objects.toString(attr.getValue(), "");
            }
            hoj.getProp().add(new Prop(attr.getName(), val.toString()));
        }
        return hoj;
    }

    public void setStatus(String string) {
        status.setText(string);
        status.setToolTipText(string);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JTextField frameVal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JTextField newFrameVal;
    private javax.swing.JPanel newObjPanel;
    private javax.swing.JPanel newPropPanel;
    private javax.swing.JPanel objectPanel;
    private javax.swing.JTree objectTree;
    private javax.swing.JPanel oldObjPanel;
    private javax.swing.JSplitPane propSplitPane;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
