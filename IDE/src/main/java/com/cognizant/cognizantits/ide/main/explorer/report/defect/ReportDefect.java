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
package com.cognizant.cognizantits.ide.main.explorer.report.defect;

import com.cognizant.cognizantits.datalib.component.TestCase;
import com.cognizant.cognizantits.datalib.component.TestStep;
import com.cognizant.cognizantits.engine.reporting.sync.DefectModules;
import com.cognizant.cognizantits.engine.support.methodInf.MethodInfoManager;
import com.cognizant.cognizantits.ide.main.explorer.ExplorerBar;
import com.cognizant.cognizantits.ide.main.explorer.settings.ReportingModuleSettings;
import com.cognizant.cognizantits.ide.util.SystemInfo;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;

/**
 *
 * 
 */
public class ReportDefect extends javax.swing.JPanel {

    private static JPanel cards;
    private JTextArea temp;

    /**
     * populate the attachments field with the selected images in the list
     *
     * @param selectedImages - list of images to upload
     */
    public static void setSelectedImages(List<?> selectedImages) {
        attachments.setText("");
        for (Object iFile : selectedImages) {
            attachments.setText(attachments.getText() + iFile + File.pathSeparator);
        }
    }

    /**
     * Creates new form ReportDefect
     */
    ReportingModuleSettings conn;
    String[] column = new String[]{"show", "fieldId", "fieldName", "fieldType", "fieldValue"};
    List<String> modules = new ArrayList();
    Component parent;
    Map<String, JComponent> fieldsMap = new LinkedHashMap<>();

    ExplorerBar explorer;

    static ReportDefect r;

    public ReportDefect() {
        conn = ReportingModuleSettings.get();
        initComponents();

    }

    /**
     * prepare the upload defect user interface
     *
     * @param parent the parent/ container for the interface
     * @return the interface panel
     */
    public static JPanel getPanel(Component parent) {
        if (r == null) {
            r = new ReportDefect();
            r.setSize(500, 450);
            r.setMinimumSize(r.getSize());
            r.setPreferredSize(r.getSize());
        }
        r.defectModule.setText(com.cognizant.cognizantits.ide.main.explorer.settings.Settings.getSettings("DefectModule"));
        r.initiateFormUI(r.defectModule.getText());
        r.parent = parent;
        return r;
    }

    /**
     * prepare the upload defect user interface with the text area in(full size)
     * card layout
     *
     * @param parent the parent/ container for the interface
     * @return the interface panel
     * @see #getPanel(java.awt.Component)
     */
    public static JPanel getreportDefectPanel(Component parent) {
        cards = new JPanel(new CardLayout());
        JPanel p = getPanel(parent);
        cards.add(p, "Report");
        cards.add(r.textAreaPanel, "TextArea");
        return cards;
    }

    public static void setExplorer(ExplorerBar explorer) {
        r.explorer = explorer;
    }

    /**
     * displays the user interface and the text area in a toggle mode
     */
    public void showNext() {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.next(cards);
    }

    /**
     * upload the defect to the given module
     *
     * @param moduleId - defect module id
     */
    void uploadDefect(String moduleId) {
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        JComponent jc;

        for (String key : fieldsMap.keySet()) {
            jc = fieldsMap.get(key);
            if (jc instanceof JTextField) {
                data.put(key, ((JTextField) jc).getText());
            } else if (jc instanceof JTextArea) {
                data.put(key, ((JTextArea) jc).getText());
            } else if (jc instanceof JComboBox) {
                data.put(key, (String) ((JComboBox) jc).getSelectedItem());
            }
        }
        List<File> attach = getAttachFiles();
        String result = DefectModules.uploadDefect(moduleId, data, attach);
        JOptionPane.showMessageDialog(this, result, "Defect Status", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * creates the list of files from the selected files in the attachments
     * fields
     *
     * @return
     */
    List<File> getAttachFiles() {
        List<File> attach = new ArrayList<>();
        String[] files = attachments.getText().split(File.pathSeparator, 0);
        for (String fd : files) {
            File f = new File(fd);
            if (f.exists() && f.isFile()) {
                attach.add(f);
            }
        }
        return attach;
    }

    /**
     * gets the list of fields and it's UI definitions
     *
     * @param moduleId - the defect module id
     * @return fields def. list
     */
    private List<String[]> getDataList(String moduleId) {
        List<String[]> rows = new ArrayList<>();
        for (HashMap<String, String> row : conn.getFields(moduleId)) {
            rows.add(new String[]{row.get(column[0]), row.get(column[1]), row.get(column[2]), row.get(column[3]), row.get(column[4])});
        }
        return rows;
    }

    /**
     * set up the UI from the field definitions
     *
     * @param moduleId
     * @see #setupFields(java.util.List)
     */
    protected void initiateFormUI(String moduleId) {
        List<String[]> fields = getDataList(moduleId);
        fieldsPaneInner.removeAll();
        fieldsMap.clear();
        List<JPanel> panels = new ArrayList();
        for (String[] field : fields) {
            //add it to UI if its enabled
            if ("true".equals(field[0])) {
                JPanel p = getFieldPanel(field);
                panels.add(p);
            }
        }
        setupFields(panels);
    }

    /**
     * set up the UI layout for the fields
     *
     * @param panels - list of fields
     */
    private void setupFields(List<JPanel> panels) {
        GroupLayout fieldsLayout = new GroupLayout(fieldsPaneInner);
        fieldsPaneInner.setLayout(fieldsLayout);

        ParallelGroup pg = fieldsLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        for (JPanel p : panels) {
            pg.addComponent(p, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        }
        fieldsLayout.setHorizontalGroup(pg);

        SequentialGroup sg = fieldsLayout.createSequentialGroup();
        for (JPanel p : panels) {
            sg.addComponent(p, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
            sg.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        }
        sg.addContainerGap(10, Short.MAX_VALUE);
        fieldsLayout.setVerticalGroup(fieldsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(sg));

    }

    /**
     * set up the UI for the single field
     *
     * @param field - field and its def.
     * @return the field UI
     * @see #getUsableControl(javax.swing.JComponent)
     */
    private JPanel getFieldPanel(String[] field) {

        JPanel p = new JPanel();
        JToolBar tl = getToolBar();
        JToolBar tr = getToolBar();

        JLabel fname = new JLabel(field[2]);
        JLabel sep = new JLabel("    ");
        JComponent jc = getControl(field[3], field[4]);

        p.setLayout(new java.awt.BorderLayout());
        p.add(tl, java.awt.BorderLayout.WEST);
        p.add(tr, java.awt.BorderLayout.EAST);

        tl.add(Box.createHorizontalStrut(50));
        tl.add(fname);
        tr.add(sep);
        tr.add(getUsableControl(jc));
        tr.add(Box.createHorizontalStrut(90));

        fieldsMap.put(field[1], jc);
        return p;
    }

    /**
     * set up the editor control of the field
     *
     * @param jc
     * @return
     */
    JComponent getUsableControl(JComponent jc) {
        if (jc instanceof JTextArea) {
            JScrollPane js = new JScrollPane();
            js.setPreferredSize(new Dimension(200, 100));
            js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            js.setViewportView(jc);
            return js;
        } else {
            return jc;
        }
    }

    /**
     *
     * @return - the tool bar object
     */
    JToolBar getToolBar() {
        JToolBar p = new JToolBar();
        p.setFloatable(false);
        p.setBorderPainted(false);
        return p;
    }

    /**
     * creates the control object based on the field def.
     *
     * @param type - field type
     * @param values - field values/data if any
     * @return
     */
    private JComponent getControl(String type, String values) {
        JComponent jc = null;
        Dimension size = new Dimension(200, 25);
        switch (type) {
            case "TEXTFIELD":
                jc = new JTextField();
                ((JTextField) jc).setText(values);
                jc.setMinimumSize(size);
                jc.setPreferredSize(size);
                break;
            case "TEXTAREA":
                jc = new JTextArea();
                setListener((JTextArea) jc);
                ((JTextArea) jc).setText(values);
                ((JTextArea) jc).setColumns(8);
                ((JTextArea) jc).setRows(4);
                break;
            case "DROPDOWN":
                jc = new JComboBox();
                ((JComboBox) jc).setModel(new DefaultComboBoxModel(values.split(",", -1)));
                jc.setMinimumSize(size);
                jc.setPreferredSize(size);
                break;
            default:
                break;

        }
        jc.setAlignmentX(LEFT_ALIGNMENT);
        return jc;
    }

    /**
     * set up the listener for the text area editor open the full size editor on
     * right click
     *
     * @param jTextArea - target text area control
     */
    private void setListener(final JTextArea jTextArea) {
        jTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    panelTextArea.setText(jTextArea.getText());
                    temp = jTextArea;
                    showNext();
                    panelTextArea.requestFocus();
                }
            }
        });
        jTextArea.setToolTipText("Press Right click to edit in Full Mode");
    }

    /**
     * browse and select the attachment files
     */
    private void selectFile() {
        JFileChooser chooser = new JFileChooser(com.cognizant.cognizantits.ide.main.explorer.settings.Settings.getScreenShotLoc());
        chooser.setMultiSelectionEnabled(true);
        chooser.showOpenDialog(this);
        File[] files = chooser.getSelectedFiles();
        for (File f : files) {
            attachments.setText(attachments.getText() + f.getAbsolutePath() + File.pathSeparator);
        }
    }

    /**
     * copy the recorded steps to the clipboard
     */
    private void copyTestSteps() {

        String steps = "Test Steps : " + System.lineSeparator() + getDesc();

        Toolkit.getDefaultToolkit().
                getSystemClipboard().setContents(new StringSelection(steps), null);

    }

    /**
     * copy the system information to the clipboard
     */
    private void copySystemInfo() {
        Toolkit.getDefaultToolkit()
                .getSystemClipboard()
                .setContents(new StringSelection(SystemInfo.getOSInfo()), null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        textAreaPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelTextArea = new javax.swing.JTextArea();
        modulePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        defectModule = new javax.swing.JLabel();
        jToolBar3 = new javax.swing.JToolBar();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        cpyTestSteps = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(90, 0), new java.awt.Dimension(90, 0), new java.awt.Dimension(90, 32767));
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        fieldsScrollPane = new javax.swing.JScrollPane();
        fieldsPaneInner = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        attachments = new javax.swing.JTextField();
        attachmentsBrowse = new javax.swing.JButton();

        textAreaPanel.setLayout(new java.awt.BorderLayout());

        panelTextArea.setColumns(20);
        panelTextArea.setRows(5);
        panelTextArea.setToolTipText("Press Right click to go back");
        panelTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelTextAreaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(panelTextArea);

        textAreaPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));
        setMaximumSize(new java.awt.Dimension(554, 374));
        setMinimumSize(new java.awt.Dimension(554, 374));
        setName("Report Defect"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        modulePanel.setMaximumSize(new java.awt.Dimension(550, 40));
        modulePanel.setMinimumSize(new java.awt.Dimension(550, 40));
        modulePanel.setPreferredSize(new java.awt.Dimension(550, 40));
        modulePanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setMaximumSize(new java.awt.Dimension(550, 36));
        jPanel2.setMinimumSize(new java.awt.Dimension(550, 36));
        jPanel2.setName(""); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(550, 36));
        jPanel2.setLayout(new java.awt.BorderLayout());

        defectModule.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        defectModule.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        defectModule.setText("  Defect Module ");
        jPanel2.add(defectModule, java.awt.BorderLayout.CENTER);

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);
        jToolBar3.setBorderPainted(false);
        jToolBar3.setMaximumSize(new java.awt.Dimension(88, 36));
        jToolBar3.setMinimumSize(new java.awt.Dimension(88, 36));
        jToolBar3.setPreferredSize(new java.awt.Dimension(88, 36));
        jToolBar3.add(filler4);

        cpyTestSteps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explorer/cpy_steps.png"))); // NOI18N
        cpyTestSteps.setToolTipText("Copy Test Steps");
        cpyTestSteps.setFocusable(false);
        cpyTestSteps.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cpyTestSteps.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cpyTestSteps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpyTestStepsActionPerformed(evt);
            }
        });
        jToolBar3.add(cpyTestSteps);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explorer/system config.png"))); // NOI18N
        jButton3.setToolTipText("Copy System Configuration");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton3);

        jPanel2.add(jToolBar3, java.awt.BorderLayout.EAST);
        jPanel2.add(filler3, java.awt.BorderLayout.LINE_START);

        modulePanel.add(jPanel2, java.awt.BorderLayout.CENTER);
        modulePanel.add(filler1, java.awt.BorderLayout.PAGE_END);

        add(modulePanel, java.awt.BorderLayout.PAGE_START);

        fieldsScrollPane.setBorder(null);

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10);
        flowLayout1.setAlignOnBaseline(true);
        fieldsPaneInner.setLayout(flowLayout1);
        fieldsScrollPane.setViewportView(fieldsPaneInner);

        add(fieldsScrollPane, java.awt.BorderLayout.CENTER);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explorer/upload.png"))); // NOI18N
        jButton1.setText("Upload");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jLabel4.setText("Attachments");

        attachmentsBrowse.setText("...");
        attachmentsBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachmentsBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(attachments, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(attachmentsBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(attachments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(attachmentsBrowse))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        uploadDefect(defectModule.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void attachmentsBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachmentsBrowseActionPerformed
        selectFile();
    }//GEN-LAST:event_attachmentsBrowseActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        copySystemInfo();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cpyTestStepsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpyTestStepsActionPerformed
        copyTestSteps();
    }//GEN-LAST:event_cpyTestStepsActionPerformed

    private void panelTextAreaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTextAreaMousePressed
        if (SwingUtilities.isRightMouseButton(evt)) {
            temp.setText(panelTextArea.getText());
            showNext();
        }
    }//GEN-LAST:event_panelTextAreaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField attachments;
    private javax.swing.JButton attachmentsBrowse;
    private javax.swing.JButton cpyTestSteps;
    private javax.swing.JLabel defectModule;
    private javax.swing.JPanel fieldsPaneInner;
    private javax.swing.JScrollPane fieldsScrollPane;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JPanel modulePanel;
    private javax.swing.JTextArea panelTextArea;
    private javax.swing.JPanel textAreaPanel;
    // End of variables declaration//GEN-END:variables
/**
     * get step description as a string
     *
     * @return
     */
    private String getDesc() {
        StringBuilder builder = new StringBuilder();
        TestCase testCase = explorer.testCase;
        for (TestStep testStep : testCase.getTestSteps()) {
            String desc = MethodInfoManager.getResolvedDescriptionFor(testStep);
            builder.append(desc).append("\n");
        }
        return builder.toString();
    }

}
