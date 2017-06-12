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
package com.cognizant.cognizantits.ide.main.utils.dnd;

/*
 * TransferActionListener.java is used by the ListCutPaste example.
 */
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

/**
 * A class that tracks the focused component. This is necessary to delegate the
 * menu cut/copy/paste commands to the right component. An instance of this
 * class is listening and when the user fires one of these commands, it calls
 * the appropriate action on the currently focused component.
 */
public class TransferActionListener implements ActionListener,
        PropertyChangeListener {

    private JComponent focusOwner = null;

    public TransferActionListener() {
        KeyboardFocusManager manager = KeyboardFocusManager.
                getCurrentKeyboardFocusManager();
        manager.addPropertyChangeListener("permanentFocusOwner", this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        Object o = e.getNewValue();
        if (o instanceof JComponent) {
            focusOwner = (JComponent) o;
        } else {
            focusOwner = null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (focusOwner == null) {
            return;
        }
        String action = (String) e.getActionCommand();
        Action a = focusOwner.getActionMap().get(action);
        if (a != null) {
            a.actionPerformed(new ActionEvent(focusOwner,
                    ActionEvent.ACTION_PERFORMED,
                    null));
        }
    }
}
