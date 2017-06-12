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
package com.cognizant.cognizantits.ide.main.mainui.components.testexecution.testset;

import com.cognizant.cognizantits.engine.drivers.WebDriverFactory;
import com.cognizant.cognizantits.ide.main.utils.Utils;
import com.cognizant.cognizantits.ide.main.utils.keys.Keystroke;
import com.cognizant.cognizantits.ide.util.Canvas;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * 
 */
public class TestSetPopupMenu extends JPopupMenu {

    private final ActionListener actionListener;
    private JMenuItem saveMenuItem;
    private JMenu changeBrowser;

    public TestSetPopupMenu(ActionListener actionListener) {
        this.actionListener = actionListener;
        init();
    }

    public void setSave(Boolean flag) {
        saveMenuItem.setEnabled(flag);
    }

    private void init() {
        JMenuItem addRowButton = Utils.createMenuItem("Add Row", ""
                + "Ctrl+Plus to add a row at last"
                + "<br>"
                + "Ctrl+I to insert a row before the selected row"
                + "<br>"
                + "Ctrl+R to replicate the row", Keystroke.ADD_ROWP, actionListener);
        add(addRowButton);
        add(Utils.createMenuItem("Delete Rows", "Ctrl+Minus", Keystroke.REMOVE_ROW, actionListener));

        addSeparator();

        JMenu resetStatus = new JMenu("Change Status");

        JMenuItem noRun = Utils.createMenuItem("NoRun", actionListener);
        noRun.setActionCommand("Change Status");
        noRun.setIcon(Canvas.EmptyIcon);
        resetStatus.add(noRun);

        JMenuItem passed = Utils.createMenuItem("Passed", actionListener);
        passed.setActionCommand("Change Status");
        resetStatus.add(passed);

        JMenuItem failed = Utils.createMenuItem("Failed", actionListener);
        failed.setActionCommand("Change Status");
        resetStatus.add(failed);

        add(resetStatus);

        changeBrowser = new JMenu("Change Browser");
        add(changeBrowser);
        addSeparator();

        add(Utils.createMenuItem("Cut", "Ctrl+X", Keystroke.CUT, actionListener));
        add(Utils.createMenuItem("Copy", "Ctrl+C", Keystroke.COPY, actionListener));
        add(Utils.createMenuItem("Paste", "Ctrl+V", Keystroke.PASTE, actionListener));

        addSeparator();
        add(Utils.createMenuItem("Go To TestCase", "Alt+Click", null, actionListener));
        addSeparator();
        add(saveMenuItem = Utils.createMenuItem("Save", "Ctrl+S", Keystroke.SAVE, actionListener));
        add(Utils.createMenuItem("Reload", "F5", Keystroke.F5, actionListener));
        saveMenuItem.setIcon(Canvas.EmptyIcon);
    }

    void loadBrowsers(List<String> emulators) {
        changeBrowser.removeAll();
        loadBrowsersToMenu(WebDriverFactory.Browser.getValuesAsList());
        if (!emulators.isEmpty()) {
            changeBrowser.addSeparator();
            loadBrowsersToMenu(emulators);
        }
    }

    private void loadBrowsersToMenu(List<String> browsers) {
        for (String browser : browsers) {
            JMenuItem menuItem = new JMenuItem(browser);
            menuItem.setActionCommand("ChangeBrowser");
            menuItem.addActionListener(actionListener);
            changeBrowser.add(menuItem);
            menuItem.setIcon(Canvas.EmptyIcon);
        }
    }

}
