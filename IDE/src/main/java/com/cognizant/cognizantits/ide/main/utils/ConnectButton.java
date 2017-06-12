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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * 
 */
public class ConnectButton extends JButton implements ActionListener{

    private static final ImageIcon DEFAULT_ICON
            = new ImageIcon(ConnectButton.class.getResource("/ui/resources/toolbar/bulb_yellow.png"));
    private static final ImageIcon PASS_ICON
            = new ImageIcon(ConnectButton.class.getResource("/ui/resources/toolbar/bulb_green.png"));
    private static final ImageIcon FAIL_ICON
            = new ImageIcon(ConnectButton.class.getResource("/ui/resources/toolbar/bulb_red.png"));

    public ConnectButton() {
        super("Test Connection");
        reset();
        setHorizontalTextPosition(JButton.RIGHT);
        addActionLis();
    }
    
    private void addActionLis(){
        addActionListener(this);
    }

    public final void success() {
        setIcon(PASS_ICON);
    }

    public final void failure() {
        setIcon(FAIL_ICON);
    }

    public final void reset() {
        setIcon(DEFAULT_ICON);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }

}
