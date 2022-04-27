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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign.testcase;

import com.cognizant.cognizantits.engine.core.RunManager;
import com.cognizant.cognizantits.engine.drivers.WebDriverFactory;
import com.cognizant.cognizantits.ide.main.utils.SearchBox;
import com.cognizant.cognizantits.ide.main.utils.Utils;
import com.cognizant.cognizantits.ide.settings.IconSettings;
import java.awt.event.ItemEvent;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;

/**
 *
 *
 */
public class TestCaseToolBar extends JToolBar {

    private final TestCaseComponent testCaseComp;

    private JButton saveButton;
    private SearchBox searchField;

    private JButton consoleButton;

    private JButton runButton;

    private JButton debugButton;

    private JButton record;

    private JPopupMenu browsersMenu;

    private ButtonGroup browserSelectButtonGroup;

    public TestCaseToolBar(TestCaseComponent testCaseComp) {
        this.testCaseComp = testCaseComp;
        setFloatable(false);
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));
        init();
    }

    public void setSave(Boolean flag) {
        saveButton.setEnabled(flag);
    }

    public void focusSearch() {
        searchField.focus();
    }

    private void init() {
        browsersMenu = new JPopupMenu();
        browserSelectButtonGroup = new ButtonGroup();

        searchField = new SearchBox(testCaseComp);
        add(searchField);
        addSeparator();

        add(consoleButton = Utils.createButton("Console", "console", null, testCaseComp));
        add(record = Utils.createButton("Record", testCaseComp));
        record.setText(null);
        record.setToolTipText("Start/Stop Recording");
        record.setIcon(IconSettings.getIconSettings().getRecordStartIcon());

        add(runButton = Utils.createButton("Run", "run", "F6", testCaseComp));
        add(debugButton = Utils.createButton("Debug", "debug", "Ctrl+F6", testCaseComp));

        runButton.setComponentPopupMenu(browsersMenu);
        debugButton.setComponentPopupMenu(browsersMenu);
        addSeparator();

        JButton addRowButton = Utils.createButton("Add Row", "add", ""
                + "Ctrl+Plus to add a row at last"
                + "<br>"
                + "Ctrl+I to insert a row before the selected row"
                + "<br>"
                + "Ctrl+R to replicate the row", testCaseComp);
        add(addRowButton);
        JButton removeRow = Utils.createButton("Delete Rows", "remove", "Ctrl+Minus", testCaseComp);
        add(removeRow);
        addSeparator();

        add(Utils.createButton("Move Rows Up", "up", "Ctrl+Up", testCaseComp));
        add(Utils.createButton("Move Rows Down", "down", "Ctrl+Down", testCaseComp));
        addSeparator();

        add(saveButton = Utils.createButton("Save", "save", "Ctrl+S", testCaseComp));
        add(Utils.createButton("Reload", "reload", "F5", testCaseComp));
        add(Utils.createButton("Open with System Editor", "openwithsystemeditor", "Ctrl+Alt+O", testCaseComp));
        saveButton.setEnabled(false);

        setConsoleVisible(false);

    }

    void setConsoleVisible(Boolean flag) {
        consoleButton.setVisible(flag);
    }

    void loadBrowsers(List<String> emulators) {
        browsersMenu.removeAll();
        List<String> browsers = WebDriverFactory.Browser.getValuesAsList();
        setBrowserListPopupMenu(browsers);
        if (!emulators.isEmpty()) {
            browsersMenu.addSeparator();
            setBrowserListPopupMenu(emulators);
        }
        selectABrowser();
    }

    String getSelectedBrowser() {
        if (browserSelectButtonGroup.getSelection() != null) {
            return browserSelectButtonGroup.getSelection().getActionCommand();
        }
        return "Chrome";
    }

    private void setBrowserListPopupMenu(List<String> browsers) {
         JRadioButtonMenuItem browserMenuItem;
        for (String browser : browsers) {
            browsersMenu.add(browserMenuItem = new JRadioButtonMenuItem(browser));
            browserMenuItem.setActionCommand(browser);
            browserMenuItem.addItemListener((ItemEvent ie) -> {
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    String selBrowser = ((JRadioButtonMenuItem) ie.getSource()).getText() + ". Right Click to change the browser";
					if(((JRadioButtonMenuItem) ie.getSource()).getText().equalsIgnoreCase("ProtractorJS"))
                    {selBrowser= "Ensure that ProtractorJS is installed globally";
                     runButton.setToolTipText(selBrowser);
                     debugButton.setToolTipText(selBrowser);
                    }
					else{
                    runButton.setToolTipText("Run [F6] - with " + selBrowser);
                    debugButton.setToolTipText("Debug [Ctrl+F6] - with " + selBrowser);
					}
                }
            });
            browserSelectButtonGroup.add(browserMenuItem);
        }
    }

    private String getPreviouslySelectedBrowser() {
        if (browserSelectButtonGroup.getSelection() != null) {
            return browserSelectButtonGroup.getSelection().getActionCommand();
        }
        return null;
    }

    private void selectABrowser() {
        String browser = getPreviouslySelectedBrowser();
        if (browser == null) {
            browser = RunManager.getGlobalSettings().getBrowser();
        }
        if (browser != null) {
            for (Enumeration<AbstractButton> buttons = browserSelectButtonGroup.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.getActionCommand().equals(browser)) {
                    button.setSelected(true);
                }
            }
        } else {
            browserSelectButtonGroup.setSelected(browserSelectButtonGroup.getElements().nextElement().getModel(), true);
        }
    }

    void setPlaceHolderText(String text, String toolTip) {
        searchField.setPlaceHolder(text, toolTip);
    }

    void startMode() {
        runButton.setActionCommand("Run");
        runButton.setIcon(Utils.getIconByResourceName("/ui/resources/run"));
    }

    void stopMode() {
        runButton.setActionCommand("StopRun");
        runButton.setIcon(Utils.getIconByResourceName("/ui/resources/stop"));
    }
}
