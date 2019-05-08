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
package com.cognizant.cognizantits.ide.main;

import com.cognizant.cognizantits.datalib.testdata.TestDataFactory;
import com.cognizant.cognizantits.engine.cli.LookUp;
import com.cognizant.cognizantits.engine.constants.SystemDefaults;
import com.cognizant.cognizantits.engine.drivers.findObjectBy.support.ByObjectProp;
import com.cognizant.cognizantits.engine.support.methodInf.MethodInfoManager;
import com.cognizant.cognizantits.ide.main.cli.UICli;
import com.cognizant.cognizantits.ide.main.mainui.AppMainFrame;
import com.cognizant.cognizantits.ide.main.mainui.Splash;
import com.cognizant.cognizantits.ide.main.ui.About;
import com.cognizant.cognizantits.ide.util.logging.UILogger;
import com.cognizant.cognizantits.util.encryption.Encryption;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.Painter;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import org.apache.commons.lang3.time.StopWatch;

public class Main {

    private static final StopWatch STOP_WATCH = new StopWatch();

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS:%1$tmS %1$tz [%4$-4s] %2$s:%5$s%6$s%n");
    }

    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            commandLineExecution(args);
        } else {
            UILogger.get();
            Logger.getLogger(Main.class.getName()).info("Launching Cognizant Intelligent Test Scripter IDE");
            STOP_WATCH.start();
            launchUI();
        }
    }

    private static void commandLineExecution(String[] args) {
        initCommonDependencies();
        if (!UICli.exe(args)) {
            LookUp.exe(args);
        }
    }

    private static void initCommonDependencies() {
        TestDataFactory.load();
        About.init();
        Encryption.getInstance();
        SystemDefaults.getClassesFromJar.set(true);
    }

    private static void launchUI() {
        Splash splash = new Splash();
        splash.setVisible(true);
        new Thread(() -> {
            setUpUI("Nimbus");
            splash.progressed(10);
            initDependencies();
            splash.progressed(20);
            AppMainFrame mainFrame = new AppMainFrame(splash::progressed);
            mainFrame.setVisible(false);
            mainFrame.setMinimumSize(new Dimension(1000, 700));
            mainFrame.setPreferredSize(new Dimension(1000, 700));
            mainFrame.setLocationRelativeTo(null);
            splash.progressed(99);
            splash.setVisible(false);
            mainFrame.checkAndLoadRecent();
            mainFrame.setDefaultCloseOperation(AppMainFrame.DO_NOTHING_ON_CLOSE);
            Boolean IS_MAXI_SUPPORTED = Toolkit.getDefaultToolkit().isFrameStateSupported(JFrame.MAXIMIZED_BOTH);
            if (IS_MAXI_SUPPORTED) {
                mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
            splash.dispose();
            mainFrame.setVisible(true);
        }, "UI:MainUI").start();

    }

    private static void initDependencies() {
        initCommonDependencies();
        MethodInfoManager.load();
        ByObjectProp.load();
    }

    private static void setUpUI(String ui) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (ui.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    if (ui.equals("Nimbus")) {
                        tweakNimbusUI();
                    }
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void tweakNimbusUI() {
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.put("nimbusOrange", defaults.get("nimbusBase"));
        defaults.put("Table.gridColor", new Color(214, 217, 223));
        defaults.put("Table.disabled", false);
        defaults.put("Table.showGrid", true);
        defaults.put("Table.intercellSpacing", new Dimension(1, 1));
        defaults.put("CheckBoxMenuItem.font", new java.awt.Font("sansserif", 0, 11));
        defaults.put("RadioButtonMenuItem.font", new java.awt.Font("sansserif", 0, 11));
        defaults.put("MenuItem.font", new java.awt.Font("sansserif", 0, 11));
        defaults.put("Menu.font", new java.awt.Font("sansserif", 0, 11));
        defaults.put("Table.font", new java.awt.Font("sansserif", 0, 11));
        defaults.put("Label.font", new java.awt.Font("sansserif", 0, 11));
        defaults.put("TextField.font", new java.awt.Font("sansserif", 0, 11));
        defaults.put("TextArea.font", new java.awt.Font("sansserif", 0, 11));
        defaults.put("CheckBox.font", new java.awt.Font("sansserif", 0, 11));
        defaults.put("ComboBox.font", new java.awt.Font("sansserif", 0, 11));
        defaults.put("ToolTip.font", new java.awt.Font("sansserif", 0, 11));
        defaults.put("Button.font", new java.awt.Font("sansserif", 0, 11));
        defaults.put("TableHeader.font", new java.awt.Font("sansserif", 0, 11));
        defaults.put("FileChooser.font", new java.awt.Font("sansserif", 0, 11));
        /**
         * custom tab-area border painter
         */
        Painter tabborder = (Painter) (Graphics2D g, Object object, int width, int height) -> {
            //add code to customize
        };
        defaults.put("TabbedPane:TabbedPaneTabArea[Disabled].backgroundPainter", tabborder);
        defaults.put("TabbedPane:TabbedPaneTabArea[Enabled+MouseOver].backgroundPainter", tabborder);
        defaults.put("TabbedPane:TabbedPaneTabArea[Enabled+Pressed].backgroundPainter", tabborder);
        defaults.put("TabbedPane:TabbedPaneTabArea[Enabled].backgroundPainter", tabborder);
        PopupFactory.setSharedInstance(new PopupFactory() {
            @Override
            public Popup getPopup(Component owner, final Component contents, int x, int y) throws IllegalArgumentException {
                Popup popup = super.getPopup(owner, contents, x, y);
                SwingUtilities.invokeLater(() -> {
                    contents.repaint();
                });
                return popup;
            }
        });
    }

    public static void finish() {
       STOP_WATCH.stop();
       Logger.getLogger(Main.class.getName()).log(Level.INFO, "Cognizant Intelligent Test Scripter IDE has been Terminated - [ Total Time : {0} ]", STOP_WATCH.toString());
    }
}
