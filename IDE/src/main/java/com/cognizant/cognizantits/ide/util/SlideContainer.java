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
package com.cognizant.cognizantits.ide.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import static javax.swing.JLayeredPane.putLayer;
import javax.swing.Timer;

/**
 *
 * 
 */
public class SlideContainer extends JLayeredPane {

    private static int PREF_W = 400;
    private static int PREF_H = PREF_W;
    private static final int DELAY = 1;
    protected static final int DY = 4;
    private Component oldComponent;

    public SlideContainer(int w, int h) {
        PREF_W = w;
        PREF_H = h;
        setLayout(null);
    }

    public SlideContainer() {
        setLayout(null);
    }

    void setsize(Dimension d) {
        PREF_W = d.width;
        PREF_H = d.height;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    public Component add(Component comp) {
        setsize(comp.getPreferredSize());
        Component[] comps = getComponents();
        if (comps.length > 0) {
            oldComponent = comps[0];
        }
        if (comp.equals(oldComponent)) {
            return super.add(comp);
        }
        if (oldComponent != null) {
            putLayer((JComponent) oldComponent, JLayeredPane.DEFAULT_LAYER);
        }
        Component returnResult = super.add(comp);
        putLayer((JComponent) comp, JLayeredPane.DRAG_LAYER);
        comp.setSize(getPreferredSize());
        comp.setVisible(true);
        comp.setLocation(0, 0 - getPreferredSize().height);
        slideFromTop(comp, oldComponent);
        return returnResult;
    }

    private void slideFromTop(final Component comp,
            final Component oldComponent2) {
        new Timer(DELAY, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent aEvt) {
                int y = comp.getY();
                if (y >= -2) {
                    comp.setLocation(0, 0);
                    putLayer((JComponent) comp, JLayeredPane.DEFAULT_LAYER);
                    if (oldComponent2 != null) {
                        remove(oldComponent2);
                    }
                    ((Timer) aEvt.getSource()).stop();
                } else {
                    y += DY;
                    comp.setLocation(0, y);
                }
                repaint();
            }
        }).start();
    }
}
