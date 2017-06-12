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
package com.cognizant.cognizantits.ide.main.utils.keys;

import com.cognizant.cognizantits.ide.main.utils.table.XTableUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;

/**
 *
 * 
 */
public class ClipboardKeyAdapter extends KeyAdapter {

    private final JTable table;

    public ClipboardKeyAdapter(JTable table) {
        this.table = table;
    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (event.isControlDown() || event.isMetaDown()) {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_C:
                    // Copy
                    cancelEditing();
                    XTableUtils.copyToClipboard(table, false);
                    break;
                case KeyEvent.VK_X:
                    // Cut
                    cancelEditing();
                    XTableUtils.copyToClipboard(table, true);
                    break;
                case KeyEvent.VK_V:
                    // Paste
                    cancelEditing();
                    XTableUtils.pasteFromClipboard(table);
                    break;
                default:
                    break;
            }
        }

    }

    private void cancelEditing() {
        if (table.getCellEditor() != null) {
            table.getCellEditor().cancelCellEditing();
        }
    }

}
