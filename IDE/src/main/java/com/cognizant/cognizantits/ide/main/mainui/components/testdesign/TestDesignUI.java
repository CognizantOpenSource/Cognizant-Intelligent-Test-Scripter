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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign;

import com.cognizant.cognizantits.ide.main.utils.Utils;
import com.cognizant.cognizantits.ide.main.utils.tree.TreeSearch;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JTree;

/**
 *
 * 
 */
public class TestDesignUI extends JPanel {

    TestDesign testDesign;

    JSplitPane projectNReusableTreeSplitPane;

    JSplitPane testCaseNTestDataSplitPane;

    JSplitPane oneTwo;

    JSplitPane oneThree;

    JPanel appReusablePanel;

    JButton reusableSwitch;

    public TestDesignUI(TestDesign testDesign) {
        this.testDesign = testDesign;
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        projectNReusableTreeSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        projectNReusableTreeSplitPane.setOneTouchExpandable(true);
        projectNReusableTreeSplitPane.setResizeWeight(0.5);

        projectNReusableTreeSplitPane.setTopComponent(getTreeInPanel("Test Plan", testDesign.getProjectTree().getTree()));

        appReusablePanel = getRTreeInPanel("Reusable Component", testDesign.getReusableTree().getTree());
        projectNReusableTreeSplitPane.setBottomComponent(appReusablePanel);

        testCaseNTestDataSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        testCaseNTestDataSplitPane.setOneTouchExpandable(true);
        testCaseNTestDataSplitPane.setResizeWeight(0.5);

        testCaseNTestDataSplitPane.setTopComponent(testDesign.getTestCaseComponent());
        testCaseNTestDataSplitPane.setBottomComponent(testDesign.getTestDatacomp());

        oneTwo = new JSplitPane();
        oneTwo.setOneTouchExpandable(true);
        oneTwo.setResizeWeight(0.25);

        oneTwo.setLeftComponent(projectNReusableTreeSplitPane);
        oneTwo.setRightComponent(testCaseNTestDataSplitPane);

        oneThree = new JSplitPane();
        oneThree.setOneTouchExpandable(true);
        oneThree.setResizeWeight(0.8);

        oneThree.setLeftComponent(oneTwo);
        oneThree.setRightComponent(testDesign.getObjectRepo());

        add(oneThree);

    }

    public void resetAfterRecorder() {
        testCaseNTestDataSplitPane.setTopComponent(testDesign.getTestCaseComponent());
        testCaseNTestDataSplitPane.setDividerLocation(0.5);
    }

    private JPanel getTreeInPanel(String labelText, JTree tree) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setBorder(BorderFactory.createEtchedBorder());
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Default", Font.BOLD, 12));
        toolBar.add(new javax.swing.Box.Filler(new java.awt.Dimension(10, 0),
                new java.awt.Dimension(10, 0),
                new java.awt.Dimension(10, 32767)));
        toolBar.add(label);
        toolBar.add(new javax.swing.Box.Filler(new java.awt.Dimension(0, 0),
                new java.awt.Dimension(0, 0),
                new java.awt.Dimension(32767, 32767)));
        toolBar.add(getPrevoiusTestCaseButton());

        toolBar.add(getEditTagButton());
        toolBar.setPreferredSize(new java.awt.Dimension(toolBar.getPreferredSize().width, 30));
        panel.add(toolBar, BorderLayout.NORTH);
        panel.add(TreeSearch.installFor(tree), BorderLayout.CENTER);
        return panel;
    }

    private JButton getPrevoiusTestCaseButton() {
        return Utils.createButton(
                "Up One Level",
                "uponelevel",
                "Go to Prevoius TestCase",
                testDesign.getTestCaseComp());
    }

    private JButton getEditTagButton() {
        return Utils.createButton(
                "Edit Tag",
                "tag",
                "Add/Remove Tags",
                testDesign.getProjectTree());
    }

    private JPanel getRTreeInPanel(String labelText, JTree tree) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setBorder(BorderFactory.createEtchedBorder());
        reusableSwitch = new JButton(labelText);
        reusableSwitch.setFont(new Font("Default", Font.BOLD, 12));
        reusableSwitch.setContentAreaFilled(false);

        toolBar.add(new javax.swing.Box.Filler(new java.awt.Dimension(10, 0),
                new java.awt.Dimension(10, 0),
                new java.awt.Dimension(10, 32767)));
        toolBar.add(reusableSwitch);
        toolBar.setPreferredSize(new java.awt.Dimension(toolBar.getPreferredSize().width, 30));

        panel.add(toolBar, BorderLayout.NORTH);
        panel.add(TreeSearch.installFor(tree), BorderLayout.CENTER);
        return panel;
    }

    public void adjustUI() {
        oneTwo.setDividerLocation(0.25);
        oneThree.setDividerLocation(0.8);
        oneTwo.setDividerLocation(0.25);
        projectNReusableTreeSplitPane.setDividerLocation(0.5);
        testCaseNTestDataSplitPane.setDividerLocation(0.5);
        testDesign.getObjectRepo().adjustUI();
    }

}
