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

import static com.cognizant.cognizantits.ide.util.Border.focusBorder;
import static com.cognizant.cognizantits.ide.util.Border.thumbPrevOffFocus;
import static com.cognizant.cognizantits.ide.util.Border.thumbPrevOnFocus;
import static com.cognizant.cognizantits.ide.util.Border.transBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * 
 */
public class Listeners {

    public static MouseListener buttonFocus = new MouseAdapter() {

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton now = (JButton) e.getSource();
            if (!now.isSelected()) {
                now.setBorder(focusBorder);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton now = (JButton) e.getSource();
            if (!now.isSelected()) {
                now.setBorder(transBorder);
            }

        }

    };
    public static MouseListener thumbPrevFocus = new MouseAdapter() {

        @Override
        public void mouseEntered(MouseEvent e) {
            JComponent now = (JComponent) e.getSource();
            if (now.getBorder() != Border.thumbPrevSelected) {
                now.setBorder(thumbPrevOnFocus);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JComponent now = (JComponent) e.getSource();
            if (now.getBorder() != Border.thumbPrevSelected) {
                now.setBorder(thumbPrevOffFocus);
            }
        }

    };

}
