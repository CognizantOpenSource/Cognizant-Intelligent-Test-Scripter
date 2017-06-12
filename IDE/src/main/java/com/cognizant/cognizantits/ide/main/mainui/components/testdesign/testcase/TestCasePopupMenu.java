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

import com.cognizant.cognizantits.ide.main.utils.Utils;
import com.cognizant.cognizantits.ide.main.utils.keys.Keystroke;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * 
 */
public class TestCasePopupMenu extends JPopupMenu {

    private final ActionListener actionListener;
    private JMenuItem saveMenuItem;

    public TestCasePopupMenu(ActionListener actionListener) {
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

        add(Utils.createMenuItem("Toggle BreakPoint", "Ctrl+B", Keystroke.BREAKPOINT, actionListener));
        add(Utils.createMenuItem("Toggle Comment", "Ctrl+/", Keystroke.COMMENT, actionListener));

        addSeparator();
        add(Utils.createMenuItem("Cut", "Ctrl+X", Keystroke.CUT, actionListener));
        add(Utils.createMenuItem("Copy", "Ctrl+C", Keystroke.COPY, actionListener));
        add(Utils.createMenuItem("Paste", "Ctrl+V", Keystroke.PASTE, actionListener));
        addSeparator();
        add(Utils.createMenuItem("Create Reusable", actionListener));

        JMenu goToMenu = new JMenu("Go To");
        goToMenu.add(Utils.createMenuItem("Go To Reusable", actionListener));
        goToMenu.add(Utils.createMenuItem("Go To Object", actionListener));
        goToMenu.add(Utils.createMenuItem("Go To TestData", actionListener));
        add(goToMenu);
        add(Utils.createMenuItem("Paramterize", actionListener));
        addSeparator();

        JRadioButtonMenuItem toggleValidation = new JRadioButtonMenuItem("Toggle Validation", true);
        toggleValidation.addActionListener(actionListener);
        add(toggleValidation);
        addSeparator();

        add(saveMenuItem = Utils.createMenuItem("Save", "Ctrl+S", Keystroke.SAVE, actionListener));
        add(Utils.createMenuItem("Reload", "F5", Keystroke.F5, actionListener));
    }

}
