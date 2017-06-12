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
package com.cognizant.cognizantits.ide.main.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * 
 */
public class SearchBox extends JTextField implements DocumentListener {

    private final ActionListener actionListener;

    private TextBoxPlaceHolder textPrompt;

    public SearchBox(ActionListener actionListener) {
        this.actionListener = actionListener;
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        textPrompt = new TextBoxPlaceHolder("Search Text", this);
        textPrompt.setForeground(Color.GRAY);
        setActionCommand("Search");

        setToolTipText("<html>"
                + "Press <b>F3</b> to go to next search"
                + "<br/>"
                + "Press <b>Shift+F3</b> to go to previous search"
                + "<br/>"
                + "To perfrom regex search add <b>$</b> before the search string"
                + "<br/>"
                + "Press <b>Esc</b> to Clear"
                + "<br/>"
                + "</html>");
        addActionListener(actionListener);

        getDocument().addDocumentListener(this);

        getActionMap().put("GoToPrevoiusSearch", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                actionListener.actionPerformed(new ActionEvent(ae.getSource(), ae.getID(), "GoToPrevoiusSearch"));
            }
        });

        getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("shift F3"), "GoToPrevoiusSearch");

        getActionMap().put("GoToNextSearch", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                actionListener.actionPerformed(new ActionEvent(ae.getSource(), ae.getID(), "GoToNextSearch"));
            }
        });
        getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("F3"), "GoToNextSearch");

        getActionMap().put("ClearText", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setText("");
            }
        });
        getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ESCAPE"), "ClearText");

    }

    public void focus() {
        requestFocusInWindow();
        selectAll();
    }

    @Override
    public void insertUpdate(DocumentEvent de) {
        actionListener.actionPerformed(new ActionEvent(this, 0, "Search"));
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        actionListener.actionPerformed(new ActionEvent(this, 0, "Search"));
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        actionListener.actionPerformed(new ActionEvent(this, 0, "Search"));
    }

    public void setPlaceHolder(String text, String toolTip) {
        textPrompt.setText("<html>Search in [ <b><font color='#C49300'>" + text + "</font></b> ]<html>");
        textPrompt.setToolTipText(toolTip);
    }

}
