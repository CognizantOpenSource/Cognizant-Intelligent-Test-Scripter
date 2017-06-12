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

/**
 * Shows Splash Screen with Logo and Progress bar until the UI loads
 *
 */
public class Splash extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    javax.swing.JProgressBar  pbar;
    /**
     * creates a Splash Screen instance with <code> splasScreen</code> image and
     * starts progress bar in a separate thread
     *
     */
    public Splash() {
        super("loading");
        javax.swing.ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/ui/resources/favicon.png"));
        javax.swing.ImageIcon splasScreen = new javax.swing.ImageIcon(getClass().getResource("/ui/resources/splash.png"));
        int topbar = 0;
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setIconImage(icon.getImage());
        setSize(splasScreen.getIconWidth(), splasScreen.getIconHeight() + progreessBarHeight() + topbar);
        setLayout(null);
        setLocationRelativeTo(null);
        javax.swing.JLabel imglabel = new javax.swing.JLabel(splasScreen);
        pbar = new javax.swing.JProgressBar(0, 100);
        pbar.setStringPainted(false);
        pbar.setBorderPainted(false);
        pbar.setBorder(null);
        imglabel.setBounds(0, topbar, splasScreen.getIconWidth(), splasScreen.getIconHeight() - topbar);
        pbar.setForeground(java.awt.Color.decode("#73D8FA"));
        pbar.setBackground(java.awt.Color.BLACK);
        pbar.setPreferredSize(new java.awt.Dimension(splasScreen.getIconWidth(), progreessBarHeight()));
        pbar.setBounds(0, splasScreen.getIconHeight() + topbar, splasScreen.getIconWidth(), progreessBarHeight());
        add(pbar);
        add(imglabel);
    }

    private static int progreessBarHeight() {
        return 3;
    }

    public void progressed(int val) {
        pbar.setValue(val);
    }

}
