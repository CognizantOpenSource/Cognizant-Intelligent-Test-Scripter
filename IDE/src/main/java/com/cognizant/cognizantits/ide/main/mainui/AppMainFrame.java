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
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Objects;
import java.util.function.Consumer;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

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
                load();
                afterProjectChange();
            }
        });
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
