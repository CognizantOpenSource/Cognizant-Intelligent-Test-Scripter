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
import com.cognizant.cognizantits.ide.main.utils.fileoperation.FileOptions;
import com.cognizant.cognizantits.ide.util.Canvas;
import com.cognizant.cognizantits.ide.util.Notification;
import com.cognizant.cognizantits.ide.util.SelectionManager;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Finder;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;

/**
 *
 *
 */
public class PropertyEditor extends javax.swing.JFrame {

    private static final BasicStroke BS24 = new BasicStroke(3.0f);
    private static final BasicStroke BS18 = new BasicStroke(1.8f);

    private static final Boolean IS_MAXI_SUPPORTED = Toolkit.getDefaultToolkit().isFrameStateSupported(JFrame.MAXIMIZED_BOTH);

    private ImageORObject object;

    private ImageORObject tempObject;

    private File imageLocation;

    private File refImageLocation;

    private final List<Shape> shapes = new ArrayList<>();

    private final List<Shape> lastmatch = new ArrayList<>();

    private SelectionManager pageSelection;

    private MouseAdapter offsetAdapter;

    private JLabel referenceLabel;

    public PropertyEditor() {
        initComponents();
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/equalizer.png")).getImage());
        imageLocation = new File("");
        refImageLocation = new File("");
        initReferenceLabel();
        initDependencies();
    }

    private void initReferenceLabel() {
        imageChooser.setFileFilter(new FileNameExtensionFilter("Image", "jpg", "png", "gif", "bmp"));
        referenceLabel = new JLabel() {
            @Override
            public void paint(Graphics grphcs) {
                super.paint(grphcs);
                paintPage(grphcs);
            }

        };
        referenceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        referenceLabel.setComponentPopupMenu(referencePopup);
        jScrollPane2.setViewportView(referenceLabel);
        offsetAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setOffsetMarker(e);
            }
        };
        referenceLabel.addMouseListener(offsetAdapter);
    }

    private void initDependencies() {
        tempObject = new ImageORObject();

        pageSelection = new SelectionManager(referenceLabel) {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (isvalid()) {
                    searchRegion(selection.getBounds());
                }
                findObject();
            }
        };
    }

    public void showEditor(ImageORObject object) {
        try {
            org.sikuli.script.Screen.getPrimaryId();
        } catch (Throwable ex) {
            Logger.getLogger(PropertyEditor.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            Notification.show("Unable to Initialize Sikuli!");
            return;
        }
        resetImages();
        this.object = object;
        object.clone(tempObject);
        setImages();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        if (IS_MAXI_SUPPORTED) {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        setProperties();
    }

    private void setProperties() {
        precisionSlider.setValue((int) (tempObject.getPrecision() * 100));
        indexVal.setValue(tempObject.getIndex());
        offestVal.setText(getOffsetText(tempObject.getOffset()));

        status.setText("");
        loader.setVisible(false);
        imageLabel.setText(tempObject.getText());
        customRegion.setSelected(true);
        pageSelection.setCoordinates(tempObject.getRoi());
        searchRegion(tempObject.getRoi());
        findObject();
    }

    private void searchRegion(Rectangle rect) {
        regionVal.setText(getRectText(rect));
        shapes.clear();
        shapes.add(rect);
        referenceLabel.repaint();
    }

    private void paintPage(Graphics grphcs) {
        Rectangle2D tmp = null;
        Graphics2D gx = (Graphics2D) grphcs;
        gx.setStroke(BS18);
        gx.setColor(Color.RED.darker());
        for (Shape s : lastmatch) {
            if ((int) indexVal.getValue() == lastmatch.indexOf(s)) {
                tmp = s.getBounds2D();
            }
            gx.draw(s);
        }
        gx.setColor(Color.GREEN);
        shapes.forEach(gx::draw);
        if (tmp != null) {
            gx.setStroke(BS24);
            gx.setColor(Color.RED.brighter());
            gx.draw(tmp);
            paintOffset(tmp, gx);
        }
        gx.dispose();
    }

    private void paintOffset(Rectangle2D tmp, Graphics2D g2d) {
        Rectangle2D r2d = tmp;
        int x = (int) (r2d.getCenterX() + tempObject.getOffset().x);
        int y = (int) (r2d.getCenterY() + tempObject.getOffset().y);
        Canvas.paintOffset(g2d, new Point(x, y));
    }

    private void setOffsetMarker(MouseEvent e) {
        Rectangle2D tmp = null;
        for (Shape s : lastmatch) {
            if ((int) indexVal.getValue() == lastmatch.indexOf(s)) {
                tmp = s.getBounds2D();
                break;
            }
        }
        if (tmp != null) {
            Rectangle2D r2d = tmp;
            int x = (int) (e.getX() - r2d.getCenterX());
            int y = (int) (e.getY() - r2d.getCenterY());
            tempObject.setOffset(x + "," + y);
            offestVal.setText(getOffsetText(tempObject.getOffset()));
            referenceLabel.repaint();
        }
    }

    private void findObject() {
        SwingUtilities.invokeLater(() -> {
            lastmatch.clear();
            lastmatch.addAll(getMatchesList());
            ((SpinnerNumberModel) indexVal.getModel()).setMaximum(lastmatch.size() - 1);
            referenceLabel.repaint();
        });
    }

    private void setImages() {
        imageLocation = new File(object.getRepLocation() + File.separator + object.getImageLocation());
        String refLoc = object.getRepLocation() + File.separator + object.getReferenceImageLocation();
        if (!new File(refLoc).exists()) {
            refLoc = object.getPage().getRepLocation() + File.separator + object.getReferenceImageLocation();
        }
        refImageLocation = new File(refLoc);
        reloadImages();
    }

    private void reloadImages() {
        SwingUtilities.invokeLater(() -> {
            if (imageLocation.exists()) {
                imageLabel.setIcon(new ImageIcon(imageLocation.getAbsolutePath()));
                ((ImageIcon) imageLabel.getIcon()).getImage().flush();
            }
            if (refImageLocation.exists()) {
                referenceLabel.setIcon(new ImageIcon(refImageLocation.getAbsolutePath()));
                ((ImageIcon) referenceLabel.getIcon()).getImage().flush();
            }
        });
    }

    private void resetImages() {
        imageLocation = new File("");
        refImageLocation = new File("");
        customRegion.setSelected(false);
        imageLabel.setIcon(null);
        referenceLabel.setIcon(null);
    }

    public void onClose(ImageORObject object) {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagePopup = new javax.swing.JPopupMenu();
        reloadImage = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        modifyImage = new javax.swing.JMenuItem();
        referencePopup = new javax.swing.JPopupMenu();
        reloadReference = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        modifyReference = new javax.swing.JMenuItem();
        imageChooser = new javax.swing.JFileChooser();
        statusToolbar = new javax.swing.JToolBar();
        status = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        offestLabel = new javax.swing.JLabel();
        offestVal = new javax.swing.JLabel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        regionLabel = new javax.swing.JLabel();
        regionVal = new javax.swing.JLabel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        loader = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        imageLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        optionsToolBar = new javax.swing.JToolBar();
        precisionLabel = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        precisionSlider = new javax.swing.JSlider();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        precisionValue = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        indexLabel = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        indexVal = new javax.swing.JSpinner();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        customRegion = new javax.swing.JCheckBox();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        refresh = new javax.swing.JButton();
        save = new javax.swing.JButton();

        reloadImage.setText("Reload");
        reloadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadImageActionPerformed(evt);
            }
        });
        imagePopup.add(reloadImage);
        imagePopup.add(jSeparator3);

        modifyImage.setText("Modify");
        modifyImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyImageActionPerformed(evt);
            }
        });
        imagePopup.add(modifyImage);

        reloadReference.setText("Reload");
        reloadReference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadReferenceActionPerformed(evt);
            }
        });
        referencePopup.add(reloadReference);
        referencePopup.add(jSeparator4);

        modifyReference.setText("Modify");
        modifyReference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyReferenceActionPerformed(evt);
            }
        });
        referencePopup.add(modifyReference);

        imageChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        imageChooser.setDialogTitle("Open Image");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Image Property Editor");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        statusToolbar.setFloatable(false);
        statusToolbar.setRollover(true);

        status.setText("Status");
        statusToolbar.add(status);
        statusToolbar.add(filler3);

        offestLabel.setText("Offset : ");
        statusToolbar.add(offestLabel);

        offestVal.setText("0000,0000");
        statusToolbar.add(offestVal);
        statusToolbar.add(filler5);

        regionLabel.setText("Region : ");
        statusToolbar.add(regionLabel);

        regionVal.setText("0,0,0,0");
        statusToolbar.add(regionVal);
        statusToolbar.add(filler6);

        loader.setText("Loader");
        statusToolbar.add(loader);

        getContentPane().add(statusToolbar, java.awt.BorderLayout.SOUTH);

        jSplitPane1.setDividerSize(6);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setOneTouchExpandable(true);

        imageLabel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setComponentPopupMenu(imagePopup);
        imageLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        imageLabel.setIconTextGap(10);
        imageLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jScrollPane1.setViewportView(imageLabel);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        optionsToolBar.setFloatable(false);
        optionsToolBar.setRollover(true);

        precisionLabel.setText("Precision");
        optionsToolBar.add(precisionLabel);
        optionsToolBar.add(filler1);

        precisionSlider.setMajorTickSpacing(10);
        precisionSlider.setMinorTickSpacing(2);
        precisionSlider.setPaintTicks(true);
        precisionSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                precisionSliderStateChanged(evt);
            }
        });
        optionsToolBar.add(precisionSlider);
        optionsToolBar.add(filler7);

        precisionValue.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        precisionValue.setText("70%");
        optionsToolBar.add(precisionValue);
        optionsToolBar.add(jSeparator1);

        indexLabel.setText("Index");
        optionsToolBar.add(indexLabel);
        optionsToolBar.add(filler2);

        indexVal.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
        indexVal.setMaximumSize(new java.awt.Dimension(50, 32767));
        indexVal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                indexValStateChanged(evt);
            }
        });
        optionsToolBar.add(indexVal);
        optionsToolBar.add(jSeparator2);

        customRegion.setSelected(true);
        customRegion.setText("Use Custom Region");
        customRegion.setFocusable(false);
        customRegion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                customRegionItemStateChanged(evt);
            }
        });
        optionsToolBar.add(customRegion);
        optionsToolBar.add(filler4);

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/or/image/reload.png"))); // NOI18N
        refresh.setToolTipText("Reset Changes");
        refresh.setFocusable(false);
        refresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        optionsToolBar.add(refresh);

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/or/image/save.png"))); // NOI18N
        save.setToolTipText("Update Changes to Object");
        save.setFocusable(false);
        save.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        optionsToolBar.add(save);

        jPanel1.add(optionsToolBar, java.awt.BorderLayout.NORTH);
        optionsToolBar.setLayout(new javax.swing.BoxLayout(optionsToolBar, javax.swing.BoxLayout.X_AXIS));

        jSplitPane1.setRightComponent(jPanel1);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void precisionSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_precisionSliderStateChanged
        if (!precisionSlider.getValueIsAdjusting()) {
            precisionValue.setText(precisionSlider.getValue() + "%");
            findObjectOnPrecision();
        }
    }//GEN-LAST:event_precisionSliderStateChanged

    private void customRegionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_customRegionItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            pageSelection.addListener();
        } else {
            if (referenceLabel.getIcon() != null) {
                searchRegion(getDefaultRect());
            }
            pageSelection.removeListener();
            referenceLabel.addMouseListener(offsetAdapter);
        }
        findObject();
    }//GEN-LAST:event_customRegionItemStateChanged

    private void indexValStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_indexValStateChanged
        tempObject.setIndex(indexVal.getValue().toString());
        referenceLabel.repaint();
    }//GEN-LAST:event_indexValStateChanged

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        object.clone(tempObject);
        setImages();
        setProperties();
    }//GEN-LAST:event_refreshActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (customRegion.isSelected()) {
            tempObject.setRoi(pageSelection.getSelectedCoordAsString());
        }
        tempObject.clone(object);
        saveImages();
    }//GEN-LAST:event_saveActionPerformed

    private void reloadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadImageActionPerformed
        if (imageLocation.exists()) {
            imageLabel.setIcon(new ImageIcon(imageLocation.getAbsolutePath()));
        }
    }//GEN-LAST:event_reloadImageActionPerformed

    private void modifyImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyImageActionPerformed
        if (replaceSelectedFile(imageLocation)) {
            imageLocation = imageChooser.getSelectedFile();
            reloadImageActionPerformed(evt);
        }
    }//GEN-LAST:event_modifyImageActionPerformed

    private void modifyReferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyReferenceActionPerformed
        if (replaceSelectedFile(refImageLocation)) {
            refImageLocation = imageChooser.getSelectedFile();
            reloadReferenceActionPerformed(evt);
        }
    }//GEN-LAST:event_modifyReferenceActionPerformed

    private void reloadReferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadReferenceActionPerformed
        if (refImageLocation.exists()) {
            referenceLabel.setIcon(new ImageIcon(refImageLocation.getAbsolutePath()));
        }
    }//GEN-LAST:event_reloadReferenceActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        onClose(object);
    }//GEN-LAST:event_formWindowClosing

    private void saveImages() {
        File oldImageLocation = new File(object.getRepLocation() + File.separator + object.getImageLocation());

        if (!oldImageLocation.getAbsolutePath().equals(imageLocation.getAbsolutePath())) {
            String loc = oldImageLocation.getAbsolutePath();
            if (oldImageLocation.isDirectory()) {
                loc = loc + File.separator + object.getName() + ".png";
                tempObject.setImageLocation(object.getName() + ".png");
            }
            FileOptions.copyFileAs(imageLocation.getAbsolutePath(), loc);
        }

        String refLoc = object.getRepLocation() + File.separator + object.getReferenceImageLocation();
        if (!new File(refLoc).exists()) {
            refLoc = object.getPage().getRepLocation() + File.separator + object.getReferenceImageLocation();
        }

        File oldRefImageLocation = new File(refLoc);
        if (!oldRefImageLocation.getAbsolutePath().equals(refImageLocation.getAbsolutePath())) {
            String loc = oldRefImageLocation.getAbsolutePath();
            if (oldRefImageLocation.isDirectory()) {
                loc = loc + File.separator + "_Ref.png";
                tempObject.setReferenceImageLocation("_Ref.png");
            }
            FileOptions.copyFileAs(refImageLocation.getAbsolutePath(), loc);
        }
    }

    private void findObjectOnPrecision() {
        tempObject.setPrecision("" + Float.valueOf(precisionSlider.getValue()) / 100);
        findObject();
    }

    private List<Shape> getMatchesList() {
        List<Shape> rMatches = new ArrayList<>();
        try {
            Iterator<?> it = getMatches();
            if (it != null) {
                Region sRegion = Region.create(shapes.get(0).getBounds());
                while (it.hasNext()) {
                    Object region = it.next();
                    Shape rx = ((Region) region).getRect();
                    if (sRegion != null && sRegion.getRect().contains(rx.getBounds())) {
                        rMatches.add(rx);
                    }
                }
            }

        } catch (FindFailed | IOException | NullPointerException ex) {
            Logger.getLogger(PropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rMatches;
    }

    private Iterator<?> getMatches() throws FindFailed, IOException {
        if (refImageLocation.exists()) {
            Finder localFinder;
            localFinder = new Finder(refImageLocation.getAbsolutePath());
            localFinder.findAll(new Pattern(imageLocation.getAbsolutePath()).similar(tempObject.getPrecision()));
            return localFinder;
        } else {
            return null;
        }

    }

    private Rectangle getDefaultRect() {
        return new Rectangle(0, 0, referenceLabel.getIcon().getIconWidth(), referenceLabel.getIcon().getIconHeight());
    }

    private String getRectText(Rectangle r) {
        return "x: " + r.x + ", y: " + r.y + ", width: " + r.width + ", height: " + r.height;
    }

    private String getOffsetText(Point p) {
        return p.x + "," + p.y;
    }

    private Boolean replaceSelectedFile(File existingFile) {
        int option = imageChooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            if (!existingFile.getAbsolutePath().equals(imageChooser.getSelectedFile().getAbsolutePath())) {
                return true;
            }
        }
        return false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox customRegion;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.JFileChooser imageChooser;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPopupMenu imagePopup;
    private javax.swing.JLabel indexLabel;
    private javax.swing.JSpinner indexVal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel loader;
    private javax.swing.JMenuItem modifyImage;
    private javax.swing.JMenuItem modifyReference;
    private javax.swing.JLabel offestLabel;
    private javax.swing.JLabel offestVal;
    private javax.swing.JToolBar optionsToolBar;
    private javax.swing.JLabel precisionLabel;
    private javax.swing.JSlider precisionSlider;
    private javax.swing.JLabel precisionValue;
    private javax.swing.JPopupMenu referencePopup;
    private javax.swing.JButton refresh;
    private javax.swing.JLabel regionLabel;
    private javax.swing.JLabel regionVal;
    private javax.swing.JMenuItem reloadImage;
    private javax.swing.JMenuItem reloadReference;
    private javax.swing.JButton save;
    private javax.swing.JLabel status;
    private javax.swing.JToolBar statusToolbar;
    // End of variables declaration//GEN-END:variables
}
