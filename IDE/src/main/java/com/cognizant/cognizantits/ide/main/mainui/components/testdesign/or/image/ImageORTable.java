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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign.or.image;

import com.cognizant.cognizantits.datalib.or.image.ImageORObject;
import com.cognizant.cognizantits.ide.main.utils.Utils;
import com.cognizant.cognizantits.ide.main.utils.table.XTable;
import com.cognizant.cognizantits.ide.util.Canvas;
import com.cognizant.cognizantits.ide.util.Notification;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

/**
 *
 *
 */
public class ImageORTable extends JPanel implements ActionListener, ItemListener {

    private final XTable table;

    private final Toolbar toolBar;

    private final ImageORPanel imageOR;

    private final CardLayout cardLayout;

    private final JPanel cardPanel;

    private final ImagePanel imagePanel;

    private final PropertyEditor propertyEditor;

    private Timer findOnScreenTimer;

    public ImageORTable(ImageORPanel imageOR) {
        this.imageOR = imageOR;
        table = new XTable();
        toolBar = new Toolbar();
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        imagePanel = new ImagePanel();
        propertyEditor = new PropertyEditor() {
            @Override
            public void onClose(ImageORObject object) {
                if (Objects.deepEquals(getObject(), object)) {
                    loadObject(object);
                    table.repaint();
                }
            }
        };
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        cardPanel.add(new JScrollPane(table), "Table");
        cardPanel.add(imagePanel, "Image");
        add(cardPanel, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH);
        findOnScreenTimer = new Timer(1000, this);
        findOnScreenTimer.setActionCommand("FindOnScreenTimer");
        findOnScreenTimer.setRepeats(false);
    }

    public XTable getTable() {
        return table;
    }

    public void loadObject(ImageORObject object) {
        table.setModel(object);
        imagePanel.setImage(object.getRepLocation() + File.separator + object.getImageLocation());
    }

    public void reset() {
        table.setModel(new DefaultTableModel());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Show Offset":
                findOffset();
                break;
            case "FindOnScreenTimer":
                findOnScreen();
                break;
            case "Find on Screen":
                imageOR.getTestDesign().getsMainFrame().setExtendedState(JFrame.ICONIFIED);
                findOnScreenTimer.start();
                break;
            case "Show Property Editor":
                showEditor();
                break;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getStateChange() == ItemEvent.SELECTED) {
            showImage();
        } else {
            hideImage();
        }
    }

    public ImageORObject getObject() {
        if (table.getModel() instanceof ImageORObject) {
            return (ImageORObject) table.getModel();
        }
        return null;
    }

    private void findOffset() {
        if (getObject() != null) {
            toolBar.toggleImage.setSelected(true);
            imagePanel.findOffset(getObject().getOffset());
        }
    }

    private void findOnScreen() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (getObject() != null) {
                    findandClickMatch(getObject());
                }
                findOnScreenTimer.stop();
            }
        }).start();
    }

    private void findandClickMatch(ImageORObject target) {
        try {
            Canvas c = new Canvas();
            Screen screen = new Screen();
            screen.setROI(target.getRoi());
            Pattern p = new Pattern(
                    target.getRepLocation() + File.separator + target.getImageLocation())
                    .targetOffset(target.getOffset().x, target.getOffset().y).similar((float) target.getPrecision());
            Region r = screen.find(p);
            if (r != null) {
                c.addBox(r.getRect()).display(3);
                r.mouseMove(p);
            }
        } catch (FindFailed ex) {
            Logger.getLogger(ImageORTable.class.getName()).log(Level.SEVERE, null, ex);
            Notification.show("Target Not Found");
        } catch (IllegalThreadStateException ex) {
            Logger.getLogger(ImageORTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showEditor() {
        ImageORObject obj = getObject();
        if (obj != null) {
            new Thread(() -> {
                propertyEditor.showEditor(obj);
            }, "propertyEditor").start();
        }
    }

    private void showImage() {
        cardLayout.show(cardPanel, "Image");
    }

    private void hideImage() {
        cardLayout.show(cardPanel, "Table");
    }

    class ImagePanel extends JPanel {

        final JLabel imageLabel;

        public ImagePanel() {
            imageLabel = new JLabel();
            init();
        }

        private void init() {
            setLayout(new BorderLayout());
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(new JScrollPane(imageLabel), BorderLayout.CENTER);
        }

        private void setImage(String location) {
            imageLabel.setIcon(new ImageIcon(location));
        }

        private void findOffset(Point offset) {
            Point dz = getImageViewerLabelPoint();
            drawTarget(new Point(offset.x + dz.x, offset.y + dz.y));
        }

        private Point getImageViewerLabelPoint() {
            return new Point(imageLabel.getWidth() / 2, imageLabel.getHeight() / 2);
        }

        private void drawTarget(Point e) {
            try {
                imageLabel.paintImmediately(imageLabel.getVisibleRect());
                Graphics g = imageLabel.getGraphics();
                Canvas.paintOffset((Graphics2D) g, e);
            } catch (Exception ex) {
                Logger.getLogger(ImageORTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class Toolbar extends JToolBar {

        JToggleButton toggleImage;

        public Toolbar() {
            setFloatable(false);
            setBorder(BorderFactory.createEtchedBorder());
            init();
        }

        private void init() {

            add(new javax.swing.Box.Filler(new java.awt.Dimension(10, 0),
                    new java.awt.Dimension(10, 0),
                    new java.awt.Dimension(10, 32767)));
            JLabel label = new JLabel("Properties");
            label.setFont(new Font("Default", Font.BOLD, 12));
            add(label);

            add(new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767)));
            toggleImage = new JToggleButton(Utils.getIconByResourceName("/ui/resources/or/image/image"));
            toggleImage.addItemListener(ImageORTable.this);
            toggleImage.setActionCommand("ToggleImage");
            toggleImage.setToolTipText("Show/Hide Image");
            add(toggleImage);

            JButton offset = new JButton(Utils.getIconByResourceName("/ui/resources/or/image/findOffset"));
            offset.addActionListener(ImageORTable.this);
            offset.setToolTipText("Show Offset");
            offset.setActionCommand("Show Offset");
            add(offset);

            JButton findOn = new JButton(Utils.getIconByResourceName("/ui/resources/or/image/findOnScreen"));
            findOn.addActionListener(ImageORTable.this);
            findOn.setToolTipText("Find on Screen");
            findOn.setActionCommand("Find on Screen");
            add(findOn);

            JButton editor = new JButton(Utils.getIconByResourceName("/ui/resources/or/image/propViewer"));
            editor.addActionListener(ImageORTable.this);
            editor.setToolTipText("Show Property Editor");
            editor.setActionCommand("Show Property Editor");
            add(editor);
        }

    }

}
