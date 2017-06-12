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
package com.cognizant.cognizantits.ide.main.mainui.components.testexecution;

import com.cognizant.cognizantits.datalib.component.Project;
import com.cognizant.cognizantits.datalib.component.Scenario;
import com.cognizant.cognizantits.datalib.component.TestCase;
import com.cognizant.cognizantits.datalib.model.Tag;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.tree.TagEditorDialog;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.tree.model.ScenarioNode;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.tree.model.TestCaseNode;
import com.cognizant.cognizantits.ide.main.mainui.components.testexecution.tree.model.FilterableTestPlanTreeModel;
import com.cognizant.cognizantits.ide.main.utils.ConsolePanel;
import com.cognizant.cognizantits.ide.main.utils.Utils;
import com.cognizant.cognizantits.ide.main.utils.tree.JCheckBoxTree;
import com.cognizant.cognizantits.ide.main.utils.tree.TreeSearch;
import com.cognizant.cognizantits.ide.settings.IconSettings;
import com.cognizant.cognizantits.ide.util.Notification;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * 
 */
public class TestExecutionUI extends JPanel implements ActionListener {

    TestExecution testExecution;

    private TestPlanPullPanel testPullPanel;

    JSplitPane testSetCompNtestPlan;
    JSplitPane treeSNTableSplitPane;

    JSplitPane testSettreeNSettingsSplitPane;

    JSplitPane testplanTreeNSettingsSplitPane;

    JSplitPane executionAndConsoleSplitPane;

    ConsolePanel consolePanel;

    public TestExecutionUI(TestExecution testExecution) {
        this.testExecution = testExecution;
        init();
    }

    private void init() {

        setLayout(new BorderLayout());

        testSetCompNtestPlan = new JSplitPane();
        testSetCompNtestPlan.setOneTouchExpandable(true);

        treeSNTableSplitPane = new JSplitPane();
        treeSNTableSplitPane.setOneTouchExpandable(true);

        testSettreeNSettingsSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        testSettreeNSettingsSplitPane.setOneTouchExpandable(true);

        testplanTreeNSettingsSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        testplanTreeNSettingsSplitPane.setOneTouchExpandable(true);

        executionAndConsoleSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        executionAndConsoleSplitPane.setOneTouchExpandable(true);

        testSettreeNSettingsSplitPane.setTopComponent(
                getCompInPanel(
                        "TestLab",
                        TreeSearch.installFor(testExecution.getTestSetTree().getTree())));

        testSettreeNSettingsSplitPane.setBottomComponent(
                getCompInPanel(
                        "QuickSettings",
                        new JScrollPane(
                                testExecution.getTestSetComp()
                                .getQuickSettings().getUILeft(this))));

        testSettreeNSettingsSplitPane.setDividerLocation(0.5);

        treeSNTableSplitPane.setResizeWeight(0.25);
        treeSNTableSplitPane.setLeftComponent(testSettreeNSettingsSplitPane);

        executionAndConsoleSplitPane.setTopComponent(testExecution.getTestSetComp());
        executionAndConsoleSplitPane.setOneTouchExpandable(true);

        consolePanel = new ConsolePanel();

        treeSNTableSplitPane.setRightComponent(executionAndConsoleSplitPane);

        testSetCompNtestPlan.setLeftComponent(treeSNTableSplitPane);

        testPullPanel = new TestPlanPullPanel();
        testplanTreeNSettingsSplitPane.setTopComponent(testPullPanel);

        testplanTreeNSettingsSplitPane.setBottomComponent(
                getCompInPanel(
                        "QuickSettings",
                        new JScrollPane(
                                testExecution.getTestSetComp()
                                .getQuickSettings().getUIRight(this))));
        testSetCompNtestPlan.setRightComponent(testplanTreeNSettingsSplitPane);
        testSetCompNtestPlan.setResizeWeight(0.8);

        add(testSetCompNtestPlan, BorderLayout.CENTER);
    }

    public void loadTestPlanModel() {
        testPullPanel.loadTestPlanModel();
    }

    private JPanel getCompInPanel(String labelText, JComponent comp) {
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
        toolBar.setPreferredSize(new java.awt.Dimension(toolBar.getPreferredSize().width, 25));

        panel.add(toolBar, BorderLayout.NORTH);
        panel.add(comp, BorderLayout.CENTER);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Pull":
                if (testExecution.getTestSetComp().getCurrentTestSet() != null) {
                    testExecution.getTestSetComp().pullTestCases(testPullPanel.getSelectedTestCases());
                } else {
                    Notification.show("Please select/load a TestSet from the TestLab tree");
                }
                break;
            case "Export":
                if (testPullPanel.isChecked()) {
                    testExecution.getsMainFrame().getStepMap().convertTestCase(Utils.saveDialog("Manual TestCase.csv"), testPullPanel.getSelectedTestCases());
                }
                break;
            case "Filter":
                testPullPanel.showFilterTag();
                break;
            default:
                throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public void adjustUI() {
        treeSNTableSplitPane.setDividerLocation(0.25);
        testSetCompNtestPlan.setDividerLocation(0.8);
        treeSNTableSplitPane.setDividerLocation(0.25);
        testSettreeNSettingsSplitPane.setDividerLocation(0.5);
        testplanTreeNSettingsSplitPane.setDividerLocation(0.5);
    }

    class TestPlanPullPanel extends JPanel {

        JCheckBoxTree testPlanTree;

        TreeModelListener modelListener;

        List<Tag> tags;
        List<String> sTags;

        private JButton filterButton;

        public TestPlanPullPanel() {
            init();
        }

        private void init() {
            setLayout(new BorderLayout());
            testPlanTree = new TestPlanCheckBoxTree();
            add(new JScrollPane(testPlanTree), BorderLayout.CENTER);
            add(createToolbar(), BorderLayout.NORTH);
            modelListener = getModelListener();
        }

        private boolean containsAny(List<String> sTags, List<Tag> nTags) {
            return nTags.stream().map(Tag::getValue).filter(sTags::contains).findFirst().isPresent();
        }

        private boolean doFilter(Object o) {
            if (sTags != null && !sTags.isEmpty()) {
                if (o instanceof Scenario) {
                    return containsAny(sTags, getTags((Scenario) o));
                } else if (o instanceof TestCase) {
                    return containsAny(sTags, getTags((TestCase) o));
                }
            }
            return true;
        }

        private List<Tag> getTags(Scenario scn) {
            return testExecution.getProject().getInfo()
                    .findScenarioOrCreate(scn.getName())
                    .getTags();
        }

        private List<Tag> getTags(TestCase tc) {
            return testExecution.getProject().getInfo().getData()
                    .findOrCreate(tc.getName(), tc.getScenario().getName())
                    .getTags();

        }

        private void showFilterTag() {
            TagEditorDialog.build(testExecution.getsMainFrame(),
                    testExecution.getProject().getInfo().getAllTags(null), tags,
                    null, null).withTitle("Filter Tags").show(this::setFilterTags);
        }

        private void setFilterTags(List<Tag> tags) {
            this.tags = tags.stream().distinct().collect(toList());
            this.sTags = tags.stream().map(Tag::getValue).distinct().collect(toList());
            reloadModel();
            if (tags.isEmpty()) {
                resetFilter();
            } else {
                enableFilter();
            }
        }

        private JToolBar createToolbar() {
            JToolBar toolBar = new JToolBar();
            toolBar.setFloatable(false);
            toolBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            toolBar.setLayout(new javax.swing.BoxLayout(toolBar, javax.swing.BoxLayout.X_AXIS));

            JButton pull = Utils.createButton("Pull", TestExecutionUI.this);
            pull.setToolTipText("Pull Selected TestCases to TestSet");
            pull.setIcon(Utils.getIconByResourceName("/ui/resources/testExecution/pull"));
            JButton export = Utils.createButton("Export", TestExecutionUI.this);
            export.setToolTipText("Export Selected TestCases into Manual TestCases");
            export.setIcon(Utils.getIconByResourceName("/ui/resources/testExecution/export"));
            filterButton = Utils.createButton("Filter", TestExecutionUI.this);
            filterButton.setToolTipText("Filter TestCases By Tags");
            filterButton.setIcon(Utils.getIconByResourceName("/ui/resources/toolbar/tag"));
            toolBar.add(pull);
            toolBar.add(export);
            toolBar.add(filterButton);
            return toolBar;
        }

        public void loadTestPlanModel() {
            testExecution.getsMainFrame().getTestDesign().getProjectTree()
                    .getTree().getModel().addTreeModelListener(modelListener);
            reloadModel();
            this.tags = null;
            this.sTags = null;
            resetFilter();
        }

        private void enableFilter() {
            filterButton.setIcon(Utils.getIconByResourceName("/ui/resources/toolbar/tagsel"));
        }

        private void resetFilter() {
            filterButton.setIcon(Utils.getIconByResourceName("/ui/resources/toolbar/tag"));
        }

        private TreeModelListener getModelListener() {
            return new TreeModelListener() {
                @Override
                public void treeNodesChanged(TreeModelEvent tme) {
                    reloadModel();
                }

                @Override
                public void treeNodesInserted(TreeModelEvent tme) {
                    reloadModel();
                }

                @Override
                public void treeNodesRemoved(TreeModelEvent tme) {
                    reloadModel();
                }

                @Override
                public void treeStructureChanged(TreeModelEvent tme) {
                    reloadModel();
                }
            };
        }

        private void reloadModel() {
            SwingUtilities.invokeLater(() -> {
                testPlanTree.setModel(null);
                testPlanTree.setModel(getModel(testExecution.getProject()));
                testPlanTree.refresh();
            });
        }

        private TreeModel getModel(Project project) {
            return new FilterableTestPlanTreeModel(project, this::doFilter);
        }

        private List<TestCase> getSelectedTestCases() {
            List<TestCase> testcases = new ArrayList<>();
            TreePath[] paths = testPlanTree.getCheckedPaths();
            for (TreePath path : paths) {
                if (path.getLastPathComponent() instanceof TestCaseNode) {
                    testcases.add(((TestCaseNode) path.getLastPathComponent())
                            .getTestCase());
                }
            }
            return testcases;
        }

        private Boolean isChecked() {
            return testPlanTree.getCheckedPaths().length > 0;
        }
    }

    class TestPlanCheckBoxTree extends JCheckBoxTree {

        @Override
        public Icon getIcon(Object value) {
            if (value instanceof ScenarioNode) {
                return IconSettings.getIconSettings().getTestPlanScenario();
            } else if (value instanceof TestCaseNode) {
                return IconSettings.getIconSettings().getTestPlanTestCase();
            } else {
                return IconSettings.getIconSettings().getTestPlanRoot();
            }
        }
    }

    public ConsolePanel getConsolePanel() {
        return consolePanel;
    }

    public void toggleConsolePanel(Object source) {
        if (source instanceof JToggleButton) {
            final Boolean flag = ((JToggleButton) source).isSelected();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    if (flag) {
                        executionAndConsoleSplitPane.setBottomComponent(consolePanel);
                        executionAndConsoleSplitPane.setDividerLocation(0.5);
                    } else {
                        executionAndConsoleSplitPane.remove(consolePanel);
                    }
                }
            });
        }
    }

}
