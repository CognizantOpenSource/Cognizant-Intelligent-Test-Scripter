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
package com.cognizant.cognizantits.ide.main.server;

import com.cognizant.cognizantits.datalib.component.Project;
import com.cognizant.cognizantits.ide.util.CmdRunner;
import com.cognizant.cognizantits.ide.util.Notification;
import com.cognizant.cognizantits.ide.util.SystemInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 *
 */
public class SeleniumServer extends javax.swing.JFrame {

    private static final String APPIUM_CMD = "\"#NODE\"  \"#APPIUM\" --address  #SERVER --port #PORT #ARGS";
    private static final String SELENIUM_CMD = "java -jar \"#JARLOC\" -port #PORT -role hub -timeout #TIMEOUT #ARGS";
    private final transient CmdRunner cmdRunner;
    private static final String SELENIUM_GRID_PROP_FILE = "SeleniumGrid.properties";
    private static final String APPIUM_SERVER_PROP_FILE = "AppiumServer.properties";

    private final ImageIcon serverIcon = new ImageIcon(getClass().getResource("/ui/resources/server.png"));
    private static SeleniumServer seleniumServer;

    Project sProject;

    private enum seleniumGridProp {

        Port,
        TimeOut,
        JarLoc,
        Additional
    }

    private enum AppiumServerProp {

        AppiumLocation,
        Server,
        Port,
        Additional
    }

    public static SeleniumServer get() {
        if (seleniumServer == null) {
            seleniumServer = new SeleniumServer();
        }
        return seleniumServer;
    }

    private SeleniumServer() {
        initComponents();
        setIconImage(serverIcon.getImage());
        if (SystemInfo.isWindows()) {
            cmdRunner = new CmdRunner.WinSettings();
        } else {
            cmdRunner = new CmdRunner.MacSettings();
        }
    }

    public final void loadFor(Project sProject) {
        this.sProject = sProject;
        loadAppiumServer();
        loadSeleniumGridServer();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadAppiumServer() {
        Properties prop = loadProperties(getLocation(APPIUM_SERVER_PROP_FILE));
        appiumLocation.setText(prop.getProperty(AppiumServerProp.AppiumLocation.toString(), ""));
        appiumServer.setText(prop.getProperty(AppiumServerProp.Server.toString(), "127.0.0.1"));
        appiumPortNo.setValue(Integer.valueOf(prop.getProperty(AppiumServerProp.Port.toString(), "4723")));
        appiumAddnlConf.setText(prop.getProperty(AppiumServerProp.Additional.toString(), ""));
        if (SystemInfo.isWindows()) {
            appiumStart.setEnabled(isAppiumExist());
        }
    }

    private void loadSeleniumGridServer() {
        Properties prop = loadProperties(getLocation(SELENIUM_GRID_PROP_FILE));
        seleniumGridPort.setValue(Integer.valueOf(prop.getProperty(seleniumGridProp.Port.toString(), "4444")));
        seleniumGridTimeout.setValue(Integer.valueOf(prop.getProperty(seleniumGridProp.TimeOut.toString(), "600")));
        selJarLoc.setText(prop.getProperty(seleniumGridProp.JarLoc.toString(), "selenium-server-standalone-x.jar"));
        seleniumGridAddnlConf.setText(prop.getProperty(seleniumGridProp.Additional.toString(), ""));
    }

    private void saveAppiumServer() {
        Properties prop = loadProperties(getLocation(APPIUM_SERVER_PROP_FILE));
        prop.setProperty(AppiumServerProp.AppiumLocation.toString(), appiumLocation.getText());
        prop.setProperty(AppiumServerProp.Server.toString(), appiumServer.getText());
        prop.setProperty(AppiumServerProp.Port.toString(), appiumPortNo.getValue().toString());
        prop.setProperty(AppiumServerProp.Additional.toString(), appiumAddnlConf.getText());
        saveProperties(prop, getLocation(APPIUM_SERVER_PROP_FILE));
    }

    private void saveSeleniumGridServer() {
        Properties prop = loadProperties(getLocation(SELENIUM_GRID_PROP_FILE));
        prop.setProperty(seleniumGridProp.Port.toString(), seleniumGridPort.getValue().toString());
        prop.setProperty(seleniumGridProp.TimeOut.toString(), seleniumGridTimeout.getValue().toString());
        prop.setProperty(seleniumGridProp.JarLoc.toString(), selJarLoc.getText());
        prop.setProperty(seleniumGridProp.Additional.toString(), seleniumGridAddnlConf.getText());
        saveProperties(prop, getLocation(SELENIUM_GRID_PROP_FILE));
    }

    private String getLocation(String fileName) {
        return createFolder(sProject.getProjectSettings().getLocation()) + File.separator + fileName;
    }

    private Properties loadProperties(String location) {
        Properties prop = new Properties();
        if (new File(location).exists()) {
            try (FileInputStream inputStream = new FileInputStream(location)) {
                prop.load(inputStream);
            } catch (IOException ex) {
                Logger.getLogger(SeleniumServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return prop;
    }

    private String createFolder(String location) {
        if (!new File(location).exists()) {
            new File(location).mkdirs();
        }
        return location;
    }

    private static void saveProperties(Properties prop, String location) {
        try (FileOutputStream fout = new FileOutputStream(location)) {
            prop.store(fout, null);
        } catch (IOException ex) {
            Logger.getLogger(SeleniumServer.class.getName()).log(Level.SEVERE, null, ex);
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

        appiumBrowser = new javax.swing.JFileChooser();
        selJarFileChooser = new javax.swing.JFileChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        seleniumGridStart = new javax.swing.JButton();
        seleniumGridPort = new javax.swing.JSpinner();
        seleniumGridTimeout = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        seleniumGridAddnlConf = new javax.swing.JEditorPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        selJarLoc = new javax.swing.JTextField();
        selBrowseLoc = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        appiumLocation = new javax.swing.JTextField();
        browseAppiumLoc = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        appiumServer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        appiumPortNo = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        appiumAddnlConf = new javax.swing.JEditorPane();
        jLabel7 = new javax.swing.JLabel();
        appiumStart = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        appiumError = new javax.swing.JLabel();

        appiumBrowser.setCurrentDirectory(getCurrentDir());
        appiumBrowser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Start Server");
        setResizable(false);

        jTabbedPane1.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        jLabel1.setText("Port No");

        seleniumGridStart.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        seleniumGridStart.setText("Start Server");
        seleniumGridStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleniumGridStartActionPerformed(evt);
            }
        });

        seleniumGridPort.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        seleniumGridPort.setModel(new javax.swing.SpinnerNumberModel(4444, 1024, 65536, 1));
        seleniumGridPort.setEditor(new javax.swing.JSpinner.NumberEditor(seleniumGridPort, "0000"));

        seleniumGridTimeout.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        seleniumGridTimeout.setModel(new javax.swing.SpinnerNumberModel(600, 100, null, 1));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        jLabel2.setText("TimeOut");

        seleniumGridAddnlConf.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        seleniumGridAddnlConf.setToolTipText("-xconfig xvalue -yconfig yvalue");
        jScrollPane1.setViewportView(seleniumGridAddnlConf);

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        jLabel3.setText("Additional Arguments");

        jLabel8.setText("sec");

        selJarLoc.setText("selenium-server-standalone-x.jar");

        selBrowseLoc.setText("...");
        selBrowseLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selBrowseLocActionPerformed(evt);
            }
        });

        jLabel9.setText("Selenium Standalone server Jar Loc");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(selJarLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selBrowseLoc))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(seleniumGridPort, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(seleniumGridTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addComponent(jLabel9)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(seleniumGridStart)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seleniumGridPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seleniumGridTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selJarLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selBrowseLoc))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(seleniumGridStart)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Selenium Grid", jPanel1);

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        jLabel4.setText("Appium Location");

        appiumLocation.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N

        browseAppiumLoc.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        browseAppiumLoc.setText("...");
        browseAppiumLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseAppiumLocActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        jLabel5.setText("Server");

        appiumServer.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        appiumServer.setText("127.0.0.1");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        jLabel6.setText("Port");

        appiumPortNo.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        appiumPortNo.setModel(new javax.swing.SpinnerNumberModel(4723, 1024, 65536, 1));
        appiumPortNo.setEditor(new javax.swing.JSpinner.NumberEditor(appiumPortNo, "0000"));

        appiumAddnlConf.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        appiumAddnlConf.setToolTipText("--xconfig xvalue --yconfig yvalue");
        jScrollPane2.setViewportView(appiumAddnlConf);

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        jLabel7.setText("Additional Arguments");

        appiumStart.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        appiumStart.setText("Start Server");
        appiumStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appiumStartActionPerformed(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);

        appiumError.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        appiumError.setForeground(java.awt.Color.blue);
        jToolBar1.add(appiumError);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(appiumLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(browseAppiumLoc))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(appiumServer, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(appiumPortNo))))
                        .addContainerGap(46, Short.MAX_VALUE))))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(appiumStart)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appiumLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseAppiumLoc))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appiumServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appiumPortNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(appiumStart)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Appium Server", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seleniumGridStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleniumGridStartActionPerformed
        if (!selJarLoc.getText().isEmpty() && new File(selJarLoc.getText()).exists()) {
            saveSeleniumGridServer();
            startSeleniumServer();
        } else {
            Notification.show("Please Enter a valid Selenium server standalone.jar Location");
        }
    }//GEN-LAST:event_seleniumGridStartActionPerformed

    private void appiumStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appiumStartActionPerformed

        saveAppiumServer();
        if (SystemInfo.isWindows()) {
            if (!isAppiumExist()) {
                appiumStart.setEnabled(false);
            } else {
                startServerWin();
            }
        } else {
            startServerMac();
        }
    }//GEN-LAST:event_appiumStartActionPerformed

    private void browseAppiumLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseAppiumLocActionPerformed
        setAppiumLocation();
    }//GEN-LAST:event_browseAppiumLocActionPerformed

    private void selBrowseLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selBrowseLocActionPerformed
        int loc = selJarFileChooser.showOpenDialog(this);
        if (loc == JFileChooser.APPROVE_OPTION) {
            selJarLoc.setText(selJarFileChooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_selBrowseLocActionPerformed

    private File getCurrentDir() {
        String dir = appiumLocation.getText();
        dir = dir != null && !dir.isEmpty() ? dir : System.getProperty("user.dir");
        return new File(dir);
    }

    private void setAppiumLocation() {
        int loc = appiumBrowser.showOpenDialog(this);
        if (loc == JFileChooser.APPROVE_OPTION) {
            appiumLocation.setText(appiumBrowser.getSelectedFile().getAbsolutePath());
        }
        if (SystemInfo.isWindows()) {
            appiumStart.setEnabled(isAppiumExist());
        }
    }

    boolean isAppiumExist() {
        File node = new File(getNodeBin());
        if (!node.exists()) {
            appiumError.setText("Node binary not found!!");
        } else {
            File appium = new File(getAppiumBin());
            if (!appium.exists()) {
                appiumError.setText("Appium Module not found!!");
            } else {
                appiumError.setText("");
                return true;
            }
        }
        return false;
    }

    private void startServerWin() {
        if (isAppiumExist()) {
            startAppiumServer();
        }
    }

    private void startServerMac() {
        startAppiumServer();
    }

    private void startAppiumServer() {
        String command = APPIUM_CMD.replace("#NODE", getNodeBin()).replace("#APPIUM", getAppiumBin())
                .replace("#SERVER", appiumServer.getText()).replace("#PORT", appiumPortNo.getValue().toString())
                .replace("#ARGS", appiumAddnlConf.getText());
        runCMD(getAppiumCmdLoc(), command);
    }

    private void startSeleniumServer() {
        String Command = SELENIUM_CMD
                .replace("#JARLOC", selJarLoc.getText())
                .replace("#PORT", seleniumGridPort.getValue().toString())
                .replace("#TIMEOUT", seleniumGridTimeout.getValue().toString())
                .replace("#ARGS", seleniumGridAddnlConf.getText());
        runCMD(getSeleniumGridCmdLoc(), Command);
    }

    private void runCMD(String cmdLoc, String cmd) {
        cmdRunner.setCMDFile(cmdLoc);
        cmdRunner.writeCMD(cmd);
        cmdRunner.runCMD();
    }

    /**
     * Node binary location
     *
     * @return
     */
    private String getNodeBin() {
        return appiumLocation.getText() + File.separator + "node.exe";
    }

    /**
     * appium binary location
     *
     * @return
     */
    private String getAppiumBin() {
        return appiumLocation.getText() + "/node_modules/appium/bin/Appium.js";
    }

    private String getSeleniumGridCmdLoc() {
        return System.getProperty("user.dir") + File.separator + "StartGrid";
    }

    private String getAppiumCmdLoc() {
        return System.getProperty("user.dir") + File.separator + "StartAppium";
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane appiumAddnlConf;
    private javax.swing.JFileChooser appiumBrowser;
    private javax.swing.JLabel appiumError;
    private javax.swing.JTextField appiumLocation;
    private javax.swing.JSpinner appiumPortNo;
    private javax.swing.JTextField appiumServer;
    private javax.swing.JButton appiumStart;
    private javax.swing.JButton browseAppiumLoc;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton selBrowseLoc;
    private javax.swing.JFileChooser selJarFileChooser;
    private javax.swing.JTextField selJarLoc;
    private javax.swing.JEditorPane seleniumGridAddnlConf;
    private javax.swing.JSpinner seleniumGridPort;
    private javax.swing.JButton seleniumGridStart;
    private javax.swing.JSpinner seleniumGridTimeout;
    // End of variables declaration//GEN-END:variables
}
