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
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

public class ConsolePanel extends JPanel {

    private static final Font FONT = new Font(Font.MONOSPACED, Font.PLAIN, 12);
    private final JTextComponent consoleView;

    public ConsolePanel() {
        setLayout(new BorderLayout());
        consoleView = new JTextPane();
        consoleView.setEditable(false);
        consoleView.setFont(FONT);
        add(new JScrollPane(consoleView), BorderLayout.CENTER);
    }

    public void start() {
        consoleView.setText("");
        MessageConsole messageConsole = new MessageConsole(consoleView, true);
        messageConsole.redirectOut();
        messageConsole.redirectErr(Color.RED);
    }

}
