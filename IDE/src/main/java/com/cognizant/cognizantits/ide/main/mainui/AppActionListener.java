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

import com.cognizant.cognizantits.engine.support.methodInf.MethodInfoManager;
import com.cognizant.cognizantits.ide.main.bdd.BddParser;
import com.cognizant.cognizantits.ide.main.explorer.ExplorerBar;
import com.cognizant.cognizantits.ide.main.help.Help;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.testdata.ImportTestData;
import com.cognizant.cognizantits.ide.main.scheduler.SchedulerUI;
import com.cognizant.cognizantits.ide.main.server.SeleniumServer;
import com.cognizant.cognizantits.ide.main.settings.CognizantITSSettings;
import com.cognizant.cognizantits.ide.main.settings.DriverSettings;
import com.cognizant.cognizantits.ide.main.settings.TMSettings;
import com.cognizant.cognizantits.ide.main.ui.AboutUI;
import com.cognizant.cognizantits.ide.main.ui.InjectScript;
import com.cognizant.cognizantits.ide.main.ui.NewProject;
import com.cognizant.cognizantits.ide.main.ui.Options;
import com.cognizant.cognizantits.ide.main.utils.CMProjectCreator;
import com.cognizant.cognizantits.ide.main.utils.Utils;
import com.cognizant.cognizantits.ide.util.logging.UILogger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppActionListener implements ActionListener {

    private final AppMainFrame sMainFrame;

    private final NewProject nProject;

    private final CognizantITSSettings cogITSSettings;

    private final DriverSettings driverSettings;

    private final TMSettings tmSettings;

    private final Options options;

    private final SchedulerUI scheduler;

    private final BddParser bddParser;

    private final InjectScript injectScript;

    private final ImportTestData importTestData;

    public AppActionListener(AppMainFrame sMainFrame) {
        this.sMainFrame = sMainFrame;
        nProject = new NewProject(sMainFrame);
        cogITSSettings = new CognizantITSSettings(sMainFrame);
        driverSettings = new DriverSettings(sMainFrame);
        tmSettings = new TMSettings(sMainFrame);
        options = new Options();
        scheduler = new SchedulerUI();
        bddParser = new BddParser(sMainFrame);
        injectScript = new InjectScript();
        importTestData = new ImportTestData(sMainFrame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "New Project":
                newProject();
                break;
            case "Open Project":
                openProject();
                break;
            case "Save Project":
                sMainFrame.save();
                break;
            case "Restart":
                sMainFrame.restart();
                break;
            case "Quit":
                sMainFrame.quit();
                break;
            case "Object Spy":
                sMainFrame.getSpyHealReco().showObjectSpy();
                break;
            case "Object Heal":
                sMainFrame.getSpyHealReco().showObjectHeal();
                break;
            case "Recorder":
                sMainFrame.getTestDesign().getTestCaseComp().record();
                break;
            case "Image Spy":
                sMainFrame.getSpyHealReco().showImageSpy();
                break;
            case "Mobile Spy":
                sMainFrame.getSpyHealReco().showMobileSpy();
                break;
            case "Exploratory":
                ExplorerBar.showExplorerBar(sMainFrame);
                break;
            case "Multiple Environment":
                sMainFrame.getTestDesign().getTestDatacomp().switchEnvView();
                break;
            case "Import TestData":
                importTestData.importTestData();
                break;
            case "Inject Script":
                injectScript.load();
                break;
            case "Run Settings":
                openSettings();
                break;
            case "Browser Configuration":
                driverSettings.open();
                break;
            case "Test Management Configuration":
                tmSettings.open();
                break;
            case "Options":
                options.showOptions();
                break;
            case "Schedule Run":
                scheduler.showScheduler(sMainFrame.getProject());
                break;
            case "Start Server":
                SeleniumServer.get().loadFor(sMainFrame.getProject());
                break;
            case "Import Feature File":
                bddParser.parse(Utils.openDialog("Feature File", "feature"));
                break;
            case "Open Feature Editor":
                bddParser.openEditor();
                break;
            case "Har Compare":
                sMainFrame.getDashBoardManager().openHarComapareInBrowser();
                break;
            case "Help":
                Help.openHelp();
                break;
            case "About":
                AboutUI.showUI();
                break;
            case "Show Log":
                UILogger.get().openLog();
                break;
            case "Test Design":
                sMainFrame.showTestDesign();
                break;
            case "Test Execution":
                sMainFrame.showTestExecution();
                break;
            case "Dashboard":
                sMainFrame.showDashBoard();
                break;
            case "Refresh":
                doRefresh();
                break;
            case "AdjustUI":
                sMainFrame.adjustUI();
                break;
            case "Create CM Project":
                CMProjectCreator.createCMProject();
                break;
            default:
                System.out.println(ae.getActionCommand());
                sMainFrame.getLoader().showIDontCare();

        }
    }

    private void newProject() {
        nProject.createNew();
        if (nProject.isCreated()) {
            sMainFrame.afterProjectChange();
        }
    }

    private void openProject() {
        File file = Utils.openCognizantITSProject();
        if (file != null) {
            sMainFrame.loadProject(file.getAbsolutePath());
        }
    }

    private void openSettings() {
        if (sMainFrame.isTestExecution()) {
            com.cognizant.cognizantits.datalib.component.TestSet obj = sMainFrame.getTestExecution().getTestSetComp()
                    .getCurrentTestSet();
            if (obj != null) {
                cogITSSettings.loadSettings(obj.getExecSettings());
            }
        } else if (sMainFrame.isTestDesign()) {
            cogITSSettings.loadSettings();
        }
    }

    public AppMainFrame getMainFrame() {
        return sMainFrame;
    }

    public void afterProjectChange() {
        cogITSSettings.afterProjectChange();
        driverSettings.load();
        tmSettings.load();
    }

    private void doRefresh() {
        MethodInfoManager.load();
    }

}
