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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign.testdata;


import com.cognizant.cognizantits.ide.main.utils.Utils;
import com.cognizant.cognizantits.ide.main.utils.keys.Keystroke;
import com.cognizant.cognizantits.ide.util.Canvas;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * 
 */
public class TestDataPopupMenu extends JPopupMenu {

    private final ActionListener actionListener;
    private JMenuItem saveMenuItem;

    public TestDataPopupMenu(ActionListener tdProxy) {
        this.actionListener = tdProxy;
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

        add(Utils.createMenuItem("Add Column", "Alt+Plus", Keystroke.ADD_COLP, actionListener));
        add(Utils.createMenuItem("Delete Columns", "Alt+Minus", Keystroke.REMOVE_COL, actionListener));
        addSeparator();

        add(Utils.createMenuItem("Create Selected Column's In All Env", "", null, actionListener));

        add(Utils.createMenuItem("Create Selected Rows's In All Env", "", null, actionListener));

        add(Utils.createMenuItem("Encrypt", "", null, actionListener));
        addSeparator();
        add(Utils.createMenuItem("Go To TestCase", "", null, actionListener));
        addSeparator();

        add(Utils.createMenuItem("Cut", "Ctrl+X", Keystroke.CUT, actionListener));
        add(Utils.createMenuItem("Copy", "Ctrl+C", Keystroke.COPY, actionListener));
        add(Utils.createMenuItem("Paste", "Ctrl+V", Keystroke.PASTE, actionListener));
        addSeparator();

        add(saveMenuItem = Utils.createMenuItem("Save", "Ctrl+S", Keystroke.SAVE, actionListener));
        add(Utils.createMenuItem("Reload", "F5", Keystroke.F5, actionListener));

        saveMenuItem.setIcon(Canvas.EmptyIcon);
    }
}
