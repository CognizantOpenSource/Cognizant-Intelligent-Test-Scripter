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
package com.cognizant.cognizantits.ide.main.settings;

import com.cognizant.cognizantits.engine.core.TMIntegration;
import com.cognizant.cognizantits.ide.main.utils.keys.Keystroke;
import com.cognizant.cognizantits.ide.main.utils.table.JtableUtils;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import static javax.swing.JComponent.WHEN_FOCUSED;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

/**
 *
 * 
 */
public class TMSettingsControl {

    public static void initTMTable(JTable table) {
        InputMap imTD = table.getInputMap(WHEN_FOCUSED);
        ActionMap amTD = table.getActionMap();
        JPopupMenu popup = new JPopupMenu();
        JMenuItem mItemEnc = new JMenuItem("Encrypt");
        popup.add(mItemEnc);
        Action enc = getEncryptAction(table);
        mItemEnc.setAccelerator(Keystroke.ENCRYPT);
        mItemEnc.addActionListener(enc);
        imTD.put(Keystroke.ENCRYPT, "encrypt");
        amTD.put("encrypt", enc);
        table.setComponentPopupMenu(popup);
        JtableUtils.addlisteners(table, Boolean.FALSE);
    }

    private static AbstractAction getEncryptAction(final JTable table) {
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent me) {
                try {
                    int col = table.getSelectedColumn();
                    int row = table.getSelectedRow();
                    if (col > -1 && row > -1) {
                        String data = table.getValueAt(row, col).toString();
                        table.setValueAt(TMIntegration.encrypt(data), row, col);
                    }
                } catch (HeadlessException ex) {
                    Logger.getLogger(TMSettingsControl.class.getName())
                            .log(Level.SEVERE, ex.getMessage(), ex);
                }

            }
        };
    }

}
