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
package com.cognizant.cognizantits.ide.main.mainui;

import com.cognizant.cognizantits.datalib.component.Project;
import com.cognizant.cognizantits.datalib.component.Release;
import com.cognizant.cognizantits.datalib.component.Scenario;
import com.cognizant.cognizantits.datalib.component.TestCase;
import com.cognizant.cognizantits.datalib.component.TestData;
import com.cognizant.cognizantits.datalib.component.TestSet;
import com.cognizant.cognizantits.datalib.component.TestStep;
import com.cognizant.cognizantits.datalib.settings.testmgmt.Option;
import com.cognizant.cognizantits.datalib.settings.testmgmt.TestMgModule;
import com.cognizant.cognizantits.datalib.testdata.model.AbstractDataModel;
import com.cognizant.cognizantits.datalib.testdata.model.GlobalDataModel;
import com.cognizant.cognizantits.datalib.testdata.model.TestDataModel;
import com.cognizant.cognizantits.datalib.util.data.FileScanner;
import com.cognizant.cognizantits.engine.core.TMIntegration;
import com.cognizant.cognizantits.ide.main.Main;
import com.cognizant.cognizantits.ide.main.dashboard.server.DashBoardManager;
import com.cognizant.cognizantits.ide.main.mainui.components.DashBoard;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.TestDesign;
import com.cognizant.cognizantits.ide.main.mainui.components.testexecution.TestExecution;
import com.cognizant.cognizantits.ide.main.shr.SHR;
import com.cognizant.cognizantits.ide.main.ui.About;
import com.cognizant.cognizantits.ide.main.ui.StartUp;
import com.cognizant.cognizantits.ide.main.utils.LoaderScreen;
import com.cognizant.cognizantits.ide.main.utils.StepMap;
import com.cognizant.cognizantits.ide.main.utils.recentItem.RecentItems;
import com.cognizant.cognizantits.ide.settings.AppSettings;
import com.cognizant.cognizantits.ide.util.Notification;
import com.cognizant.cognizantits.ide.util.SystemInfo;
import com.cognizant.cognizantits.ide.util.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import org.apache.commons.codec.binary.Base64;

public class AppMainFrame extends JFrame {

    private final SlideShow slideShow;

    private final SimpleDock docker;

    private final AppMenuBar menuBar;

    private final AppToolBar toolBar;

    private final TestDesign testDesign;

    private final TestExecution testExecution;

    private final DashBoard dashBoard;

    private final DashBoardManager dashBoardManager;

    private final SHR spyHealReco;

    private final AppActionListener sActionListener;

    private final RecentItems recentItems;

    private final StartUp startUp;

    private final StepMap stepMap;

    private Project sProject;

    private final LoaderScreen loader;

    private QUIT_TYPE quitType = QUIT_TYPE.NORMAL;

    private enum QUIT_TYPE {
        NORMAL,
        FORCE,
        RESTART
    }

    private Consumer<Integer> onProgress;

    public AppMainFrame() {
        this(null);
    }

    public AppMainFrame(Consumer<Integer> onProgress) {
        this.onProgress = onProgress;
        recentItems = new RecentItems(this);
        startUp = new StartUp(this);
        progressed(25);
        sActionListener = new AppActionListener(this);
        slideShow = new SlideShow();
        docker = new SimpleDock(this);
        progressed(35);
        testDesign = new TestDesign(this);
        progressed(45);
        testExecution = new TestExecution(this);
        progressed(50);
        dashBoard = new DashBoard(testExecution);
        progressed(60);
        dashBoardManager = new DashBoardManager(this);
        spyHealReco = new SHR(this);
        progressed(70);
        menuBar = new AppMenuBar(sActionListener);
        toolBar = new AppToolBar(sActionListener);
        stepMap = new StepMap();
        loader = new LoaderScreen();
        progressed(75);
        init();
    }

    private void init() {
        setIconImage(new ImageIcon(getClass().getResource("/ui/resources/favicon.png")).getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(getAppTitle());
        setLayout(new BorderLayout());
        setGlassPane(docker);
        setJMenuBar(menuBar);
        progressed(80);
        slideShow.addSlide("TestDesign", testDesign.getTestDesignUI());
        slideShow.addSlide("TestExecution", testExecution.getTestExecutionUI());
        slideShow.addSlide("DashBoard", dashBoard);
        progressed(85);
        add(slideShow, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH);
        add(simpleFiller(), BorderLayout.WEST);
        dashBoard.load();
        loader.setFrame(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (iCanQuit()) {
                    setDefaultCloseOperation(AppMainFrame.EXIT_ON_CLOSE);
                    dispose();
                    if (quitType == QUIT_TYPE.RESTART) {
                        doRestart();
                    }
                }
            }
        });
        progressed(90);
    }

    private void progressed(int val) {
        if (Objects.nonNull(this.onProgress)) {
            this.onProgress.accept(val);
        } else {
            onProgressed(val);
        }
    }

    public void onProgressed(int val) {

    }

    private Box.Filler simpleFiller() {
        Box.Filler filler = new Box.Filler(
                new java.awt.Dimension(10, 0),
                new java.awt.Dimension(10, 0),
                new java.awt.Dimension(10, 32767));

        filler.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                setGlassPane(docker);
                SwingUtilities.invokeLater(() -> {
                    getGlassPane().setVisible(true);
                });
            }

        });
        return filler;
    }

    public void showTestDesign() {
        getGlassPane().setVisible(false);
        slideShow.showSlide("TestDesign");
    }

    public void showTestExecution() {
        getGlassPane().setVisible(false);
        slideShow.showSlide("TestExecution");
    }

    public void showDashBoard() {
        getGlassPane().setVisible(false);
        slideShow.showSlide("DashBoard");
    }

    private String getAppTitle() {
        return "Cognizant Intelligent Test Scripter - IDE " + About.getBuildVersion();
    }

    public String getCurrentSlide() {
        return slideShow.getCurrentCard();
    }

    public SlideShow getSlideShow() {
        return slideShow;
    }

    public Boolean isTestDesign() {
        return getCurrentSlide().equals("TestDesign");
    }

    public Boolean isTestExecution() {
        return getCurrentSlide().equals("TestExecution");
    }

    public Boolean isDashBoard() {
        return getCurrentSlide().equals("DashBoard");
    }

    public TestDesign getTestDesign() {
        return testDesign;
    }

    public TestExecution getTestExecution() {
        return testExecution;
    }

    public DashBoard getDashBoard() {
        return dashBoard;
    }

    public DashBoardManager getDashBoardManager() {
        return dashBoardManager;
    }

    public SHR getSpyHealReco() {
        return spyHealReco;
    }

    public RecentItems getRecentItems() {
        return recentItems;
    }

    public StepMap getStepMap() {
        return stepMap;
    }

    public LoaderScreen getLoader() {
        return loader;
    }

    public void replaceToolBar(JToolBar newToolBar) {
        remove(toolBar);
        add(newToolBar, BorderLayout.NORTH);
    }

    public void resetToolBar(JToolBar oldToolBar) {
        remove(oldToolBar);
        add(toolBar, BorderLayout.NORTH);
    }

    public void checkAndLoadRecent() {
        if (!AppSettings.canOpenRecentProjects() || recentItems.isEmpty()) {
            startUp.showIt();
        } else {
            setVisible(true);
            loadProject(recentItems.getRecentProjectLocation());
            toFront();
        }
    }

    public void loadProject(final String location) {
        beforeProjectChange();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                sProject = new Project(location);
                if (sProject.getInfo().getVersion() == null) {
                    migrate(sProject);
                    Notification.show("CITS Project Migration is done");
                    Logger.getLogger(AppMainFrame.class.getName()).log(Level.INFO, "Migration is Done ");
                }
                load();
                afterProjectChange();
            }
        });
    }

    private boolean migrate(Project project) {
        final String _Enc = " Enc";
        boolean isMigrted = true;
        try {
            //Mail Settings updated
            project.getProjectSettings().getMailSettings().put("mail.smtp.starttls.required", "true");
            Logger.getLogger(AppMainFrame.class.getName()).log(Level.INFO, "Mail setting new property is copied ");

            //Updating new TM Properties
            List<TestMgModule> modules = project.getProjectSettings().getTestMgmtModule().getModules();
            for (TestMgModule module : modules) {
                List<Option> options = module.getOptions();
                for (Option option : options) {
                    String key = option.getName();
                    String value = option.getValue();
                    if (value != null && !value.isEmpty()) {
                        if (value.contains("TMENC:")) {
                            value = value.replaceFirst("TMENC:", "");
                            byte[] encoded = Base64.decodeBase64(value);
                            TMEncrypt(new String(encoded), module, option);
                        } else {
                            if (key.toLowerCase().contains("passw")) {
                                TMEncrypt(value, module, option);
                            }
                        }
                    }
                }
            }

            ObjectMapper objMapper = new ObjectMapper();
            List<TestMgModule> modules13 = objMapper.readValue(FileScanner.getResourceString("TMModules.json"),
                    objMapper.getTypeFactory().constructCollectionType(List.class, TestMgModule.class));
            modules13.forEach((module) -> {
                String modulename = module.getModule();
                if (modulename.equals("qTestManager") || modulename.equals("JiraCloud") || modulename.equals("TestRail")) {
                    Logger.getLogger(AppMainFrame.class.getName()).
                            log(Level.INFO, "Adding 1.3 TM Module {0}  ", new Object[]{module.getModule()});
                    project.getProjectSettings().getTestMgmtModule().putValues(module.getModule(), module.getOptions());
                }
            });
            Logger.getLogger(AppMainFrame.class.getName()).log(Level.INFO, "Test Management settings are copied ");

            //Modify Encoding to Encryption in TestData and GlobalData
            Set<String> envs = project.getTestData().getEnvironments();
            envs.forEach((environments) -> {
                TestData testDataFor = project.getTestData().getTestDataFor(environments);
                GlobalDataModel gbData = testDataFor.getGlobalData();
                gbData.load();
                int row_size = gbData.getRowCount();
                int col_size = gbData.getColumnCount();

                for (int row = 0; row < row_size; row++) {
                    for (int col = 0; col < col_size; col++) {
                        if (col == 0) {
                            continue;
                        }
                        String value = (String) gbData.getValueAt(row, col);
                        if (value != null && !value.trim().isEmpty()) {
                            if (value.endsWith(_Enc)) {
                                value = value.substring(0, value.lastIndexOf(_Enc));
                                Logger.getLogger(AppMainFrame.class.getName()).
                                        log(Level.INFO, "Migrating the {0} Environment {1} Global Data in the {2} row and {3} column", new Object[]{environments, gbData.getName(), row, col});
                                enableEncrypt(value, gbData, row, col);
                            }
                        }
                    }
                }
                gbData.saveChanges();
                List<TestDataModel> testDataList = testDataFor.getTestDataList();
                for (TestDataModel model : testDataList) {
                    model.load();
                    row_size = model.getRowCount();
                    col_size = model.getColumnCount();
                    for (int row = 0; row < row_size; row++) {
                        for (int col = 0; col < col_size; col++) {
                            if (col < 4) {
                                continue;
                            }
                            String value = (String) model.getValueAt(row, col);
                            if (value != null && !value.trim().isEmpty()) {
                                if (value.endsWith(_Enc)) {
                                    value = value.substring(0, value.lastIndexOf(_Enc));
                                    Logger.getLogger(AppMainFrame.class.getName()).
                                            log(Level.INFO, "Migrating the {0} Environment and {1} Test Data in the {2} row and {3} column", new Object[]{environments, model.getName(), row, col});
                                    enableEncrypt(value, model, row, col);
                                }
                            }
                        }
                    }
                    model.saveChanges();
                }
            });

            //Migrating Encrypted Actions 
            List<Scenario> scenarios = project.getScenarios();
            for (Scenario scenario : scenarios) {
                List<TestCase> cases = scenario.getTestCases();
                enableEncryptTC(cases);
            }

            //Migrating Driver Settings
            Enumeration<Object> keysObj = project.getProjectSettings().getDriverSettings().keys();
            Iterator<Object> keys = keysObj.asIterator();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                String property = project.getProjectSettings().getDriverSettings().getProperty(key);
                if (property != null && !property.isEmpty()) {
                    if (property.endsWith(_Enc)) {
                        property = property.substring(0, property.lastIndexOf(_Enc));
                        byte[] encoded = Base64.decodeBase64(property);
                        String encrypted = new String(encoded);
                        if (key.equals("proxyPassword")) {
                            encrypted = Utility.encrypt(new String(encoded));
                            Logger.getLogger(AppMainFrame.class.getName()).log(Level.INFO, "Migrating the Driver Settings Key {0} and Value {1}", new Object[]{key, encrypted});
                        }
                        project.getProjectSettings().getDriverSettings().put(key, encrypted);
                    } else {
                        if (key.equals("proxyPassword")) {
                            String encrypted = Utility.encrypt(property);
                            Logger.getLogger(AppMainFrame.class.getName()).log(Level.INFO, "Migrating the Driver Settings Key {0} and Value {1}", new Object[]{key, encrypted});
                            project.getProjectSettings().getDriverSettings().put(key, encrypted);
                        }
                    }
                }
            }

            //Migarting Test Management settings at Release level
            List<Release> releases = project.getReleases();
            for (Release release : releases) {
                List<TestSet> testsets = release.getTestSets();
                for (TestSet testset : testsets) {
                    Enumeration<Object> keys1 = project.getProjectSettings().getExecSettings(release.getName(), testset.getName()).getTestMgmgtSettings().keys();
                    Iterator<Object> keysls = keys1.asIterator();
                    while (keysls.hasNext()) {
                        String key = (String) keysls.next();
                        String property = project.getProjectSettings().getExecSettings(release.getName(), testset.getName()).getTestMgmgtSettings().getProperty(key);
                        if (property != null && !property.isEmpty()) {
                            if (property.contains("TMENC:")) {
                                property = property.replaceFirst("TMENC:", "");
                                byte[] encoded = Base64.decodeBase64(property);
                                String encrypt = TMIntegration.encrypt(new String(encoded));
                                Logger.getLogger(AppMainFrame.class.getName()).
                                        log(Level.INFO, "Migrating the Execution Settings of {0} Release ->  {1} Testset . Key {2} and Value {3}", new Object[]{release.getName(), testset.getName(), key, encrypt});
                                project.getProjectSettings().getExecSettings(release.getName(), testset.getName()).getTestMgmgtSettings().put(key, encrypt);
                            } else {
                                if (key.toLowerCase().contains("passw")) {
                                    String encrypt = TMIntegration.encrypt(property);
                                    Logger.getLogger(AppMainFrame.class.getName()).
                                            log(Level.INFO, "Migrating the Execution Settings of {0} Release ->  {1} Testset . Key {2} and Value {3}", new Object[]{release.getName(), testset.getName(), key, encrypt});
                                    project.getProjectSettings().getExecSettings(release.getName(), testset.getName()).getTestMgmgtSettings().put(key, encrypt);
                                }
                            }
                        }
                    }
                }
            }

            //Migarting Test Management settings at Design level
            Enumeration<Object> keys1 = project.getProjectSettings().getExecSettings().getTestMgmgtSettings().keys();
            Iterator<Object> keysls = keys1.asIterator();
            while (keysls.hasNext()) {
                String key = (String) keysls.next();
                String property = project.getProjectSettings().getExecSettings().getTestMgmgtSettings().getProperty(key);
                if (property != null && !property.isEmpty()) {
                    if (property.contains("TMENC:")) {
                        property = property.replaceFirst("TMENC:", "");
                        byte[] encoded = Base64.decodeBase64(property);
                        String encrypt = TMIntegration.encrypt(new String(encoded));
                        Logger.getLogger(AppMainFrame.class.getName()).log(Level.INFO, "Migrating the Execution Settings Key {0} and Value {1}", new Object[]{key, encrypt});
                        project.getProjectSettings().getExecSettings().getTestMgmgtSettings().put(key, encrypt);
                    } else {
                        if (key.toLowerCase().contains("passw")) {
                            String encrypt = TMIntegration.encrypt(property);
                            Logger.getLogger(AppMainFrame.class.getName()).log(Level.INFO, "Migrating the Execution Settings Key {0} and Value {1}", new Object[]{key, encrypt});
                            project.getProjectSettings().getExecSettings().getTestMgmgtSettings().put(key, encrypt);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Notification.show("CITS Project Migration is not successful. Refer logs");
            Logger.getLogger(AppMainFrame.class.getName()).log(Level.SEVERE, "Migration is not successful", ex.getMessage());
            return false;
        }

        project.getInfo()
                .setVersion(About.getBuildVersion());
        project.save();
        return isMigrted;
    }

    private void TMEncrypt(String value, TestMgModule module, Option option) {
        String encrypt = TMIntegration.encrypt(value);
        Logger.getLogger(AppMainFrame.class.getName()).log(Level.INFO, "Migrating the {0} TM Module. Property {1} value {2} ", new Object[]{module.getModule(), option.getName(), encrypt});
        option.setValue(encrypt);
    }

    private void enableEncryptTC(List<TestCase> cases) {
        for (TestCase tcase : cases) {
            tcase.loadTableModel();
            List<TestStep> steps = tcase.getTestSteps();
            for (TestStep step : steps) {
                if (step.getAction().contains("Encrypted")) {
                    String input = step.getInput();
                    if (input != null && input.startsWith("@")) {
                        input = input.substring(1);
                        input = input.substring(0, input.lastIndexOf(" Enc"));
                        byte[] decode = Base64.decodeBase64(input);
                        String encrypted = Utility.encrypt(new String(decode));
                        step.setInput("@" + encrypted);
                        Logger.getLogger(AppMainFrame.class.getName()).log(Level.INFO, "Encrypting the value in {0}_{1} -> Data in the step {2} ", new Object[]{tcase.getScenario().getName(), tcase.getName(), step});
                    }
                }
            }
        }
    }

    private void enableEncrypt(String value, AbstractDataModel model, int row, int col) {
        byte[] decode = Base64.decodeBase64(value);
        String encrypted = Utility.encrypt(new String(decode));
        model.setValueAt(encrypted, row, col);

    }

    public void createProject(final String name, final String location, final String testDatatype) {
        beforeProjectChange();
        SwingUtilities.invokeLater(() -> {
            sProject = new Project(name, location, testDatatype).createProject();
            load();
            afterProjectChange();
            saveLoadedProject();
        });
    }

    public void saveLoadedProject() {
        if (sProject != null && !sProject.getName().isEmpty()) {
            sProject.save();
            testDesign.save();
        }
    }

    private void load() {
        testDesign.load();
        testExecution.load();
        spyHealReco.load();
    }

    public void save() {
        if (sProject != null) {
            saveLoadedProject();
            Notification.show("Project [" + sProject.getName() + "] Saved");
        }
    }

    public Project getProject() {
        return sProject;

    }

    public Boolean renameProject(String newProjName) {
        saveLoadedProject();
        if (sProject.rename(newProjName)) {
            loadProject(sProject.getLocation());
            return true;
        }
        return false;
    }

    public void reloadBrowsers() {
        testDesign.reloadBrowsers();
        testExecution.reloadBrowsers();
    }

    public void reloadSettings() {
        testExecution.getTestSetComp().reloadSettings();
    }

    void beforeProjectChange() {
        saveLoadedProject();
    }

    void afterProjectChange() {
        recentItems.addItem(sProject);
        testDesign.afterProjectChange();
        testExecution.afterProjectChange();
        dashBoard.loadTree();
        dashBoardManager.onProjectChanged();
        sActionListener.afterProjectChange();
        setTitle(sProject.getName() + " - " + getAppTitle());
        menuBar.setMultiEnvironment();
    }

    public void adjustUI() {
        testDesign.getTestDesignUI().adjustUI();
        testExecution.getTestExecutionUI().adjustUI();

    }

    public void quit() {
        SwingUtilities.invokeLater(() -> {
            dispatchEvent(new WindowEvent(AppMainFrame.this, WindowEvent.WINDOW_CLOSING));
        });
    }

    public void forceQuit() {
        quitType = QUIT_TYPE.FORCE;
        quit();
    }

    private Boolean iCanQuit() {
        return iCanQuit(quitType == QUIT_TYPE.FORCE
                ? JOptionPane.YES_NO_OPTION
                : JOptionPane.YES_NO_CANCEL_OPTION);
    }

    private Boolean iCanQuit(int optionType) {
        int option = JOptionPane.YES_OPTION;
        if (sProject != null) {
            option = JOptionPane.showConfirmDialog(this,
                    "Do you want to save the Project before Quitting?",
                    "Quit",
                    optionType);
            if (option == JOptionPane.YES_OPTION) {
                saveLoadedProject();
            }
        }
        if (option == -1 || option == JOptionPane.CANCEL_OPTION) {
            return false;
        } else {
            recentItems.save();
            spyHealReco.stopServerIfAny();
            dashBoardManager.stopServer();
            Main.finish();
            return true;
        }
    }

    public void restart() {
        quitType = QUIT_TYPE.RESTART;
        quit();
    }

    private void doRestart() {
        if (Desktop.isDesktopSupported()) {
            try {
                String file = SystemInfo.isWindows() ? "Run.bat" : "Run.command";
                Desktop.getDesktop().open(new File(file));
            } catch (Exception ex) {
                // Do Nothing
            }
        }
    }
}
