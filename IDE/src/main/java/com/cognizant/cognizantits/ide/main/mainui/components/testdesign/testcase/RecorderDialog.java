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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign.testcase;

import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.TestDesign;
import com.cognizant.cognizantits.ide.settings.IconSettings;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class RecorderDialog extends JFrame {

    private final TestDesign testDesign;

    public RecorderDialog(TestDesign testDesign) {
        this.testDesign = testDesign;
        setAlwaysOnTop(true);
        setPreferredSize(new Dimension(500, 300));
        setIconImage(IconSettings.getIconSettings().getRecorderLarge().getImage());
        setLayout(new BorderLayout());
        setTitle("Recorder");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                hideRecorder();
            }
        });
        pack();
    }

    public void toggleRecorder() {
        if (isVisible()) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    RecorderDialog.this.dispatchEvent(new WindowEvent(RecorderDialog.this, WindowEvent.WINDOW_CLOSING));
                }
            });
        } else {
            showRecorder();
        }
    }

    private void showRecorder() {
        testDesign.getsMainFrame().setVisible(false);
        add(testDesign.getTestCaseComponent());
        pack();
        setSize(800, 300);
        setLocation();
        setVisible(true);
        testDesign.getsMainFrame().getSpyHealReco().startRecorder();
    }

    private void setLocation() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        setLocation((int) rect.getCenterX() - getWidth() / 2, (int) rect.getHeight() - getHeight() - 40);
    }

    private void hideRecorder() {
        testDesign.getsMainFrame().getTestDesign().getTestDesignUI().resetAfterRecorder();
        testDesign.getsMainFrame().setVisible(true);
        testDesign.getsMainFrame().getSpyHealReco().stopRecorder();
    }

}
