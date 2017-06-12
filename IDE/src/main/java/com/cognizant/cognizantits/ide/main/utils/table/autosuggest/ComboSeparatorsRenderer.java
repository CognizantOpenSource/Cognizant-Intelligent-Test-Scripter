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
package com.cognizant.cognizantits.ide.main.utils.table.autosuggest;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @email santhosh.tekuri@gmail.com
 */
public abstract class ComboSeparatorsRenderer implements ListCellRenderer {

    private final ListCellRenderer delegate;
    private final JPanel separatorPanel = new JPanel(new BorderLayout());
    private final JSeparator separator = new JSeparator();

    public ComboSeparatorsRenderer(ListCellRenderer delegate) {
        this.delegate = delegate;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component comp = delegate.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (index != -1 && addSeparatorAfter(list, value, index)) { // index==1 if renderer is used to paint current value in combo
            separatorPanel.removeAll();
            separatorPanel.add(comp, BorderLayout.CENTER);
            separatorPanel.add(separator, BorderLayout.SOUTH);
            return separatorPanel;
        } else {
            return comp;
        }
    }

    protected abstract boolean addSeparatorAfter(JList list, Object value, int index);
}
