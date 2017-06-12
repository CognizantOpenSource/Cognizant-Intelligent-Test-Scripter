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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign.testdata;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JTabbedPane;
import javax.swing.plaf.synth.SynthTabbedPaneUI;

public class XJTabbedPane extends JTabbedPane {

    private boolean showTabsHeader = false;

    public XJTabbedPane() {
        setUI(new MyTabbedPaneUI());
    }

    public void setShowTabsHeader(boolean showTabsHeader) {
        this.showTabsHeader = showTabsHeader;
    }

    public boolean isShowTabsHeader() {
        return showTabsHeader;
    }

    private class MyTabbedPaneUI extends SynthTabbedPaneUI {

        @Override
        protected int calculateTabAreaHeight(
                int tabPlacement, int horizRunCount, int maxTabHeight) {
            if (isShowTabsHeader()) {
                return super.calculateTabAreaHeight(
                        tabPlacement, horizRunCount, maxTabHeight);
            } else {
                return 0;
            }
        }

        @Override
        protected void paintTab(
                Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex,
                Rectangle iconRect, Rectangle textRect) {
            if (isShowTabsHeader()) {
                super.paintTab(
                        g, tabPlacement, rects, tabIndex, iconRect, textRect);
            }
        }

        @Override
        protected void paintContentBorder(
                Graphics g, int tabPlacement, int selectedIndex) {
            if (isShowTabsHeader()) {
                super.paintContentBorder(g, tabPlacement, selectedIndex);
            }
        }

        @Override
        public int tabForCoordinate(JTabbedPane pane, int x, int y) {
            if (isShowTabsHeader()) {
                return super.tabForCoordinate(pane, x, y);
            } else {
                return -1;
            }
        }
    }
}
