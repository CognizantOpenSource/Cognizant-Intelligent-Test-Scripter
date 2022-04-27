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
package com.cognizant.cognizantits.ide.main.explorer.settings;

import com.cognizant.cognizantits.engine.reporting.sync.Sync;
import com.cognizant.cognizantits.engine.reporting.sync.jira.JIRASync;
import com.cognizant.cognizantits.ide.main.utils.table.JtableUtils;
import com.cognizant.cognizantits.ide.main.utils.table.TableCheckBoxColumn;
import com.cognizant.cognizantits.ide.util.Notification;
import com.cognizant.cognizantits.ide.util.Utility;
import com.cognizant.cognizantits.util.encryption.Encryption;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 */
public class SettingsUI extends javax.swing.JFrame {

    /**
     * Creates new form SettingsUI
     */
    ReportingModuleSettings conn;
    String[] column = new String[]{"show", "fieldId", "fieldName", "fieldType", "fieldValue"};
    List<String> modules = new ArrayList<>();
    Map<String, String> settingsMap = new LinkedHashMap<>();

    public SettingsUI() {
        conn = ReportingModuleSettings.get();
        initComponents();
        configFields.setCursor(java.awt.Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateModuleDropDown();
        TableCheckBoxColumn.installFor(fieldsTable, 0);
        JtableUtils.addlisteners(fieldsTable, true);
        fieldsTable.getTableHeader().setReorderingAllowed(false);
        JtableUtils.addlisteners(modulesTable, false);
        loadExplorerSettings();
        fieldConfig.setAlwaysOnTop(true);
        moduleConfig.setAlwaysOnTop(true);
        setLocationRelativeTo(null);
    }

    void loadFields(String moduleId) {
        List<String[]> rows = getDataList(moduleId);
        JtableUtils.populatetable(fieldsTable, rows);
        fieldConfig.setTitle(moduleId);
        fieldConfig.setSize(450, 450);
        fieldConfig.setMinimumSize(fieldConfig.getSize());
        fieldConfig.setLocationRelativeTo(null);
        fieldConfig.setVisible(true);
    }

    void loadModules() {
        List<String[]> rows = getModulesList();
        ((DefaultTableModel) modulesTable.getModel()).setColumnCount(0);
        JtableUtils.populatetable(modulesTable, new String[]{"No", "Module"}, rows);
        moduleConfig.setSize(300, 300);
        moduleConfig.setMinimumSize(fieldConfig.getSize());
        moduleConfig.setLocationRelativeTo(null);
        moduleConfig.setVisible(true);
    }

    void saveFields(String moduleId) {
        List<HashMap<String, String>> data = getTableData(fieldsTable, moduleId);
        conn.updateFields(data, moduleId);
        Notification.show("Field Settings Successfully Saved!!");
    }

    void saveModules() {
        List<HashMap<String, String>> data = getTableData(modulesTable);
        conn.updateModules(data);
        Notification.show("Modules Successfully Saved!!");
    }

    private List<String[]> getDataList(String moduleId) {
        List<String[]> rows = new ArrayList<>();
        for (HashMap<String, String> row : conn.getFields(moduleId)) {
            rows.add(new String[]{row.get(column[0]), row.get(column[1]), row.get(column[2]), row.get(column[3]), row.get(column[4])});
        }
        return rows;
    }

    private List<String[]> getModulesList() {
        updateModuleList();
        List<String[]> rows = new ArrayList<>();
        for (String module : modules) {
            rows.add(new String[]{"" + (rows.size() + 1), module});
        }
        return rows;
    }

    private List<HashMap<String, String>> getTableData(JTable table, String moduleId) {
        List<HashMap<String, String>> data = new ArrayList<>();
        HashMap<String, String> row;
        JtableUtils.removeEmptyRows(table);
        int colCount = table.getColumnCount(),
                rowCount = table.getRowCount(), i;

        for (i = 0; i < rowCount; i++) {
            row = new HashMap<>();
            row.put("moduleId", moduleId);
            for (int j = 0; j < colCount; j++) {
                Object val = table.getValueAt(i, j);
                row.put(column[j], (val == null) ? "" : val.toString());
            }
            data.add(row);
        }
        return data;
    }

    private List<HashMap<String, String>> getTableData(JTable table) {
        List<HashMap<String, String>> data = new ArrayList<>();
        HashMap<String, String> row;
        JtableUtils.removeEmptyRows(table);
        int rowCount = table.getRowCount(), i;
        for (i = 0; i < rowCount; i++) {
            row = new HashMap<>();
            Object val = table.getValueAt(i, 1);
            row.put("moduleId", (val == null) ? "" : val.toString());
            data.add(row);
        }
        return data;
    }

    private void updateModuleDropDown() {

        updateModuleList();
        moduleList.setModel(new DefaultComboBoxModel(modules.toArray()));
    }

    void updateModuleList() {
        modules.clear();
        modules.add("JIRA");
        /**
         * for (HashMap<String, String> row : conn.getModules()) { Removed until
         * further notice modules.add(row.get("moduleId")); }
         */

    }

    private void selectImageEditor() {
        int res = Settings.FC_IMG_EDITOR.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            imageEditor.setText(Settings.FC_IMG_EDITOR.getSelectedFile().getAbsolutePath());
        }
    }

    private void loadExplorerSettings() {

        settingsMap = Settings.getSettings();
        imageEditor.setText(settingsMap.get(Settings.SETTINGS[0]));
        args.setText(settingsMap.get(Settings.SETTINGS[1]));
        moduleList.setSelectedItem(settingsMap.get(Settings.SETTINGS[2]));
        url.setText(settingsMap.get(Settings.SETTINGS[3]));
        uname.setText(getDecoded(settingsMap.get(Settings.SETTINGS[4])));
        pass.setText(getDecoded(settingsMap.get(Settings.SETTINGS[5])));
        domain.setText(settingsMap.get(Settings.SETTINGS[6]));
        project.setText(settingsMap.get(Settings.SETTINGS[7]));

    }

    private void saveExplorerSettings() {
        settingsMap.clear();
        settingsMap.put(Settings.SETTINGS[0], imageEditor.getText());
        settingsMap.put(Settings.SETTINGS[1], args.getText());
        settingsMap.put(Settings.SETTINGS[2], moduleList.getSelectedItem().toString());
        settingsMap.put(Settings.SETTINGS[3], url.getText());
        settingsMap.put(Settings.SETTINGS[4], getEncoded(uname.getText()));
        settingsMap.put(Settings.SETTINGS[5], getEncoded(String.valueOf(pass.getPassword())));
        settingsMap.put(Settings.SETTINGS[6], domain.getText());
        settingsMap.put(Settings.SETTINGS[7], project.getText());
        Settings.saveSettings(settingsMap);

    }

    private void testConnection() {
        String message = "Pls, provide correct details !";
        Thread dMConn;
        dMConn = new Thread(new java.lang.Runnable() {
            @Override
            public void run() {
                conStatus.setIcon(new ImageIcon(getClass().getResource("/ui/resources/loading.gif")));
                conStatus.setToolTipText("Establishing Connection  !!!");
                conStatus.setVisible(true);
                Sync con = null;
                try {
                    String password = "";
                    char[] passarray = pass.getPassword();
                    if (passarray != null && passarray.length > 0) {
                        password = new String(passarray);
                    }
                    con = new JIRASync(url.getText(), uname.getText(), password, project.getText());

                    if (con != null && con.isConnected()) {
                        conStatus.setIcon(new ImageIcon(getClass().getResource("/ui/resources/success.png")));
                        conStatus.setToolTipText("Connection Success !!!");
                        Notification.show("Connection Success !!!");
                        con.disConnect();
                    } else {
                        conStatus.setIcon(new ImageIcon(getClass().getResource("/ui/resources/failed.png")));
                        conStatus.setToolTipText("Connection Failed !!!");
                    }

                } catch (Exception ex) {
                    conStatus.setIcon(new ImageIcon(getClass().getResource("/ui/resources/failed.png")));
                    conStatus.setToolTipText("Connection Failed !!!");
                    Notification.show("Connection Failed !!!");
                    Logger.getLogger(SettingsUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }, "UI:TestConnection");
        if (!url.getText().isEmpty() && !uname.getText().isEmpty()
                && !project.getText().isEmpty()) {
            dMConn.start();
        } else {
            Notification.show(this, message);
        }
    }

    String getEncoded(String val) {
        return Utility.encrypt(val);
        //return Base64.encodeBase64String(val.getBytes());
    }

    String getDecoded(String val) {
        byte[] valueDecoded = val.getBytes();
        if (val.matches((".* Enc"))) {
            val = val.replace(" Enc", "");
            valueDecoded = Encryption.getInstance().decrypt(val).getBytes();
        }
        //byte[] valueDecoded = Base64.decodeBase64(val);
        return new String(valueDecoded);
    }

    private void close() {
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldConfig = new javax.swing.JDialog(new JFrame());
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        migrate = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        saveFieldsTable = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        fieldtablepane = new javax.swing.JScrollPane();
        fieldsTable = new javax.swing.JTable();
        moduleConfig = new javax.swing.JDialog(new JFrame());
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jToolBar6 = new javax.swing.JToolBar();
        addrowM = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        saveModulesTable = new javax.swing.JButton();
        modulesPane = new javax.swing.JScrollPane();
        modulesTable = new javax.swing.JTable();
        domain = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        imageEditor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        args = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        moduleList = new javax.swing.JComboBox();
        jToolBar4 = new javax.swing.JToolBar();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(32767, 0));
        configFields = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        url = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        project = new javax.swing.JTextField();
        testConn = new javax.swing.JButton();
        conStatus = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        fieldConfig.setAlwaysOnTop(true);
        fieldConfig.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/explorer.png")).getImage());

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);
        jToolBar3.setBorderPainted(false);

        migrate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/ref.png"))); // NOI18N
        migrate.setToolTipText("Migrate Setting from Old version");
        migrate.setBorderPainted(false);
        migrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                migrateActionPerformed(evt);
            }
        });
        jToolBar3.add(migrate);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/add.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton2);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/rem.png"))); // NOI18N
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton6);

        saveFieldsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/saveproj.png"))); // NOI18N
        saveFieldsTable.setFocusable(false);
        saveFieldsTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveFieldsTable.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveFieldsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFieldsTableActionPerformed(evt);
            }
        });
        jToolBar3.add(saveFieldsTable);

        jLabel6.setText("Configure Fields :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        fieldsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enabled", "Field_Id", "Field_Name", "Field_Type", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        fieldsTable.setColumnSelectionAllowed(true);
        fieldtablepane.setViewportView(fieldsTable);
        fieldsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fieldtablepane, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldtablepane, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fieldConfigLayout = new javax.swing.GroupLayout(fieldConfig.getContentPane());
        fieldConfig.getContentPane().setLayout(fieldConfigLayout);
        fieldConfigLayout.setHorizontalGroup(
            fieldConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fieldConfigLayout.setVerticalGroup(
            fieldConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        moduleConfig.setTitle("Modules");
        moduleConfig.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/explorer.png")).getImage());

        jLabel7.setText("Configure Defect Reporting Modules :");

        jToolBar6.setFloatable(false);
        jToolBar6.setRollover(true);
        jToolBar6.setBorderPainted(false);

        addrowM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/add.png"))); // NOI18N
        addrowM.setFocusable(false);
        addrowM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addrowM.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addrowM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addrowMActionPerformed(evt);
            }
        });
        jToolBar6.add(addrowM);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/rem.png"))); // NOI18N
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar6.add(jButton7);

        saveModulesTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/saveproj.png"))); // NOI18N
        saveModulesTable.setFocusable(false);
        saveModulesTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveModulesTable.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveModulesTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveModulesTableActionPerformed(evt);
            }
        });
        jToolBar6.add(saveModulesTable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jToolBar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)))
        );

        modulesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "Module ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        modulesTable.setColumnSelectionAllowed(true);
        modulesTable.getTableHeader().setReorderingAllowed(false);
        modulesPane.setViewportView(modulesTable);
        modulesTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (modulesTable.getColumnModel().getColumnCount() > 0) {
            modulesTable.getColumnModel().getColumn(0).setMinWidth(100);
            modulesTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            modulesTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        javax.swing.GroupLayout moduleConfigLayout = new javax.swing.GroupLayout(moduleConfig.getContentPane());
        moduleConfig.getContentPane().setLayout(moduleConfigLayout);
        moduleConfigLayout.setHorizontalGroup(
            moduleConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(modulesPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        moduleConfigLayout.setVerticalGroup(
            moduleConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduleConfigLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modulesPane, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
        );

        jLabel11.setLabelFor(domain);
        jLabel11.setText("Domain");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/add.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Settings");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/settings.png")).getImage());
        setMaximumSize(new java.awt.Dimension(438, 391));
        setMinimumSize(new java.awt.Dimension(438, 391));
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("ScreenShot Editor :");

        jLabel2.setText("Editor ");

        imageEditor.setText("mspaint");

        jLabel3.setText("Argument  ");

        args.setText("#file ");

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("...");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imageEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(args))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(imageEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(args, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jLabel4.setText("Defect Reporting :");

        jLabel5.setLabelFor(moduleList);
        jLabel5.setText("Module ");

        moduleList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "JIRA" }));
        moduleList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                moduleListItemStateChanged(evt);
            }
        });

        jToolBar4.setFloatable(false);
        jToolBar4.setRollover(true);
        jToolBar4.setBorderPainted(false);
        jToolBar4.add(filler1);

        configFields.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        configFields.setForeground(java.awt.Color.blue);
        configFields.setText("<html><u>Configure Fields</u></html>");
        configFields.setToolTipText(null);
        configFields.setBorderPainted(false);
        configFields.setContentAreaFilled(false);
        configFields.setFocusable(false);
        configFields.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        configFields.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        configFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configFieldsActionPerformed(evt);
            }
        });
        jToolBar4.add(configFields);

        jLabel8.setLabelFor(url);
        jLabel8.setText("URL ");

        jLabel9.setLabelFor(uname);
        jLabel9.setText("UserName");

        jLabel10.setLabelFor(pass);
        jLabel10.setText("Password");

        jLabel13.setLabelFor(project);
        jLabel13.setText("Project");

        project.setToolTipText("Project Key(JIRA)");

        testConn.setText("Test");
        testConn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testConnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(42, 42, 42)
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(moduleList, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(46, 46, 46))
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(uname)
                                    .addComponent(pass, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(project, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(testConn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(moduleList, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(project, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(testConn)
                    .addComponent(conStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        selectImageEditor();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void configFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configFieldsActionPerformed
        if (moduleList.getSelectedItem() != null) {
            loadFields(moduleList.getSelectedItem().toString());
        } else {
            Notification.show("Please select a Module");
        }
    }//GEN-LAST:event_configFieldsActionPerformed

    private void moduleListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_moduleListItemStateChanged

    }//GEN-LAST:event_moduleListItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        loadModules();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void saveFieldsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFieldsTableActionPerformed
        saveFields(moduleList.getSelectedItem().toString());
    }//GEN-LAST:event_saveFieldsTableActionPerformed

    private void addrowMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addrowMActionPerformed
        JtableUtils.addrow(modulesTable);
    }//GEN-LAST:event_addrowMActionPerformed

    private void saveModulesTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveModulesTableActionPerformed
        saveModules();
    }//GEN-LAST:event_saveModulesTableActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        saveExplorerSettings();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        close();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Object rowValue = fieldsTable.getValueAt(fieldsTable.getSelectedRow(), 1);
        if (rowValue != null) {
            conn.DeleteField(moduleList.getSelectedItem().toString(), rowValue.toString());
        }
        JtableUtils.deleterow(fieldsTable);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JtableUtils.addrow(fieldsTable);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JtableUtils.deleterow(modulesTable);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void testConnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testConnActionPerformed
        testConnection();
    }//GEN-LAST:event_testConnActionPerformed

    private void migrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_migrateActionPerformed
        loadFields(moduleList.getSelectedItem().toString());
    }//GEN-LAST:event_migrateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addrowM;
    private javax.swing.JTextField args;
    private javax.swing.JLabel conStatus;
    private javax.swing.JButton configFields;
    private javax.swing.JTextField domain;
    private javax.swing.JDialog fieldConfig;
    private javax.swing.JTable fieldsTable;
    private javax.swing.JScrollPane fieldtablepane;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTextField imageEditor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JButton migrate;
    private javax.swing.JDialog moduleConfig;
    private javax.swing.JComboBox moduleList;
    private javax.swing.JScrollPane modulesPane;
    private javax.swing.JTable modulesTable;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField project;
    private javax.swing.JButton saveFieldsTable;
    private javax.swing.JButton saveModulesTable;
    private javax.swing.JButton testConn;
    private javax.swing.JTextField uname;
    private javax.swing.JTextField url;
    // End of variables declaration//GEN-END:variables

}
