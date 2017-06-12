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
package com.cognizant.storywriter.bdd.renderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 */
public class BDDListButton extends JButton {
    
    public static String Template = "<html><div align=left width=200px>"
            + "<font size=-2>[-NAME-]</font><br>"
            + "<em>[-DESC-]</em>"
            + "</div></html>";
    public int pixels = 2;
    
    public BDDListButton() {
        initDropShadow();    
        this.setHorizontalAlignment(LEFT);
    }
    
    public final void initDropShadow() {
        Border border = BorderFactory.createEmptyBorder(pixels, 1, pixels, 1);
        this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(1, 1, 1, 0), border));
        this.setLayout(new BorderLayout());
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int shade = 0;
        int topOpacity = 80;
        for (int i = 0; i < pixels; i++) {
            g.setColor(new Color(shade, shade, shade, ((topOpacity / pixels) * i)));
            g.drawRect(i, i, this.getWidth() - ((i * 2) + 1), this.getHeight() - ((i * 2) + 1));
        }
    }
}
