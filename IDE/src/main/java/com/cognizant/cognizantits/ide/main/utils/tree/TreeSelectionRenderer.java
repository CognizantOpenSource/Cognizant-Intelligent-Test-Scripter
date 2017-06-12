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
package com.cognizant.cognizantits.ide.main.utils.tree;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.UIDefaults;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * 
 */
public class TreeSelectionRenderer extends DefaultTreeCellRenderer {

    public Boolean cellFocused = false;
    final Color DEF_SELECTION_COLOR = Color.decode("#39698a");
    final Color NOFOCUS_SELECTION_COLOR = Color.decode("#9AB2C2");

    public TreeSelectionRenderer(JTree tree) {
        editLaF(tree);
        install(tree);
        tree.setCellRenderer(this);
    }

    public final void editLaF(JTree tree) {
        UIDefaults paneDefaults = new UIDefaults();
        paneDefaults.put("Tree.selectionBackground", null);
        tree.putClientProperty("Nimbus.Overrides", paneDefaults);
        tree.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
        tree.setBackground(Color.WHITE);
    }

    public final void install(JTree tree) {
        editLaF(tree);
        tree.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                cellFocused = true;
                repaint();
            }

            @Override
            public void focusLost(FocusEvent fe) {
                cellFocused = false;
                repaint();
            }
        });
        tree.setCellEditor(new DefaultTreeCellEditor(
                tree, (DefaultTreeCellRenderer) this) {
            @Override
            public Color getBorderSelectionColor() {
                return Color.darkGray;
            }

            @Override
            public boolean isCellEditable(EventObject arg0) {
                if (arg0 instanceof MouseEvent) {
                    return false;
                }
                return super.isCellEditable(arg0);
            }
        });
    }

    public static void installFor(JTree tree) {
        TreeSelectionRenderer renderer = (TreeSelectionRenderer) tree.getCellRenderer();
        renderer.install(tree);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree jtree, Object o, boolean bln, boolean bln1, boolean bln2, int i, boolean bln3) {
        JComponent comp = (JComponent) super.getTreeCellRendererComponent(jtree, o, bln, bln1, bln2, i, bln3);
        comp.setOpaque(true);
        if (selected) {
            if (cellFocused) {
                comp.setBackground(DEF_SELECTION_COLOR);
            } else {
                comp.setBackground(NOFOCUS_SELECTION_COLOR);
            }
        } else {
            comp.setBackground(jtree.getBackground());
        }
        return comp;
    }

}
