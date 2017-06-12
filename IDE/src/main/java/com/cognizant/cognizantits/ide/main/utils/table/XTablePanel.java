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
package com.cognizant.cognizantits.ide.main.utils.table;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 */
public class XTablePanel extends JPanel {

    public final XTable table;

    private final JTextArea textArea;

    private JPanel cardPanel;

    private CardLayout cardLayout;

    private int expandedRow;

    public JToolBar toolBar;

    public XTablePanel() {
        super();
        table = new XTable(new DefaultTableModel(new Object[]{"Property", "Value"}, 0));
        textArea = new JTextArea();
        init();
        addExpandArea();
    }

    private void init() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createRaisedBevelBorder());
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(new JScrollPane(table), "Table");
        cardPanel.add(new JScrollPane(textArea), "TextArea");

        add(cardPanel, BorderLayout.CENTER);
        add(toolBar = getTopToolBar(), BorderLayout.NORTH);

        textArea.setBorder(BorderFactory.createTitledBorder("S"));
    }

    private void addExpandArea() {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.isControlDown() && SwingUtilities.isRightMouseButton(me)) {
                    int row = table.rowAtPoint(me.getPoint());
                    int col = table.columnAtPoint(me.getPoint());
                    if (row >= 0 && col == 1) {
                        expandedRow = row;
                        ((TitledBorder) textArea.getBorder()).setTitle(
                                Objects.toString(table.getValueAt(row, 0), "Prop")
                        );
                        textArea.setText(Objects.toString(table.getValueAt(row, col), ""));
                        cardLayout.show(cardPanel, "TextArea");
                    }
                }
            }
        });

        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.isControlDown() && SwingUtilities.isRightMouseButton(me)) {
                    table.setValueAt(textArea.getText(), expandedRow, 1);
                    cardLayout.show(cardPanel, "Table");
                }
            }
        });
    }

    public void addToolBarComp(JComponent comp) {
        toolBar.addSeparator();
        toolBar.add(comp);
    }

    private JToolBar getTopToolBar() {
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        toolbar.setPreferredSize(new Dimension(92, 32));
        toolbar.setMinimumSize(new Dimension(92, 32));

        JButton addRow = new JButton(
                new javax.swing.ImageIcon(getClass().getResource("/ui/resources/add.png")));
        addRow.setToolTipText("Add Row");
        addRow.addActionListener((ActionEvent ae) -> {
            JtableUtils.addrow(table);
        });
        JButton delete = new JButton(
                new javax.swing.ImageIcon(getClass().getResource("/ui/resources/rem.png")));
        delete.setToolTipText("Delete Rows");
        delete.addActionListener((ActionEvent ae) -> {
            JtableUtils.deleterow(table);
        });
        toolbar.add(new Box.Filler(
                new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 32767)));
        toolbar.add(addRow);
        toolbar.add(delete);

        return toolbar;
    }

}
