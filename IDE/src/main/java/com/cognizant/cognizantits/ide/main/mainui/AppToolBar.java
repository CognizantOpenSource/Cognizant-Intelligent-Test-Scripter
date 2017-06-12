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
package com.cognizant.cognizantits.ide.main.mainui;

import com.cognizant.cognizantits.ide.main.utils.Utils;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 *
 * 
 */
public class AppToolBar extends JToolBar {

    AppActionListener sActionListener;

    public AppToolBar(AppActionListener sActionListener) {
        this.sActionListener = sActionListener;
        init();
    }

    private void init() {
        setFloatable(false);
        setBorder(BorderFactory.createEtchedBorder());
        add(createButton("New Project"));
        add(createButton("Open Project"));
        add(createButton("Save Project"));
        addSeparator();
        add(createButton("Object Spy"));
        add(createButton("Object Heal"));
        addSeparator();
        add(createButton("Mobile Spy"));
        add(createButton("Image Spy"));
        addSeparator();
        add(createButton("Run Settings"));
        add(createButton("Browser Configuration"));
        add(createButton("Test Management Configuration"));
        addSeparator();
        add(new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767)));
        add(createButton("Refresh"));
    }

    private JButton createButton(String action) {
        JButton btn = new JButton();
        btn.setActionCommand(action);
        btn.setToolTipText(action);
        btn.setIcon(Utils.getIconByResourceName("/ui/resources/main/" + action.replace(" ", "")));
        btn.addActionListener(sActionListener);
        return btn;
    }

}
