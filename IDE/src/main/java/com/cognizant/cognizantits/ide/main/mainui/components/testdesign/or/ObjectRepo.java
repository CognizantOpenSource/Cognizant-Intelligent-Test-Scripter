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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign.or;

import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.TestDesign;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.or.image.ImageORPanel;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.or.mobile.MobileORPanel;
import com.cognizant.cognizantits.ide.main.mainui.components.testdesign.or.web.WebORPanel;
import com.cognizant.cognizantits.ide.main.utils.Utils;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 *
 * 
 */
public class ObjectRepo extends JPanel implements ItemListener {

    private final TestDesign testDesign;

    private final SwitchToolBar switchToolBar;

    private final JPanel repos;

    private final WebORPanel webOR;

    private final ImageORPanel imageOR;

    private final MobileORPanel mobileOR;

    public ObjectRepo(TestDesign testDesign) {
        this.testDesign = testDesign;
        switchToolBar = new SwitchToolBar();
        repos = new JPanel();
        webOR = new WebORPanel(testDesign);
        imageOR = new ImageORPanel(testDesign);
        mobileOR = new MobileORPanel(testDesign);
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        add(switchToolBar, BorderLayout.NORTH);
        add(repos, BorderLayout.CENTER);
        initRepos();
    }

    private void initRepos() {
        repos.setLayout(new CardLayout());
        repos.add(webOR, "Web");
        repos.add(imageOR, "Image");
        repos.add(mobileOR, "Mobile");
        switchToolBar.bgroup.getElements().nextElement().setSelected(true);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getStateChange() == ItemEvent.SELECTED) {
            CardLayout layout = (CardLayout) repos.getLayout();
            layout.show(repos, ((JToggleButton) ie.getSource()).getActionCommand());
        }
    }

    public void load() {
        webOR.load();
        imageOR.load();
        mobileOR.load();
    }

    public void adjustUI() {
        webOR.adjustUI();
        imageOR.adjustUI();
        mobileOR.adjustUI();
    }

    public WebORPanel getWebOR() {
        return webOR;
    }

    public ImageORPanel getImageOR() {
        return imageOR;
    }

    public MobileORPanel getMobileOR() {
        return mobileOR;
    }

    public Boolean navigateToObject(String objectName, String pageName) {
        if (webOR.navigateToObject(objectName, pageName)) {
            switchToolBar.webButton.setSelected(true);
            return true;
        } else if (imageOR.navigateToObject(objectName, pageName)) {
            switchToolBar.imageButton.setSelected(true);
            return true;
        } else if (mobileOR.navigateToObject(objectName, pageName)) {
            switchToolBar.mobileButton.setSelected(true);
            return true;
        }
        return false;
    }

    class SwitchToolBar extends JToolBar {

        private ButtonGroup bgroup;

        private JToggleButton webButton;
        private JToggleButton imageButton;
        private JToggleButton mobileButton;

        public SwitchToolBar() {
            init();
        }

        private void init() {
            setFloatable(false);
            bgroup = new ButtonGroup();
            JLabel label = new JLabel("Object Repository");
            label.setFont(new Font("Default", Font.BOLD, 12));
            add(new javax.swing.Box.Filler(new java.awt.Dimension(10, 0),
                    new java.awt.Dimension(10, 0),
                    new java.awt.Dimension(10, 32767)));
            add(label);
            add(new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767)));
            add(webButton = create("Web"));
            add(imageButton = create("Image"));
            add(mobileButton = create("Mobile"));
        }

        private JToggleButton create(String text) {
            JToggleButton togg = new JToggleButton();
            togg.setIcon(Utils.getIconByResourceName("/ui/resources/or/" + text.toLowerCase()));
            togg.setToolTipText(text);
            togg.setActionCommand(text);
            togg.addItemListener(ObjectRepo.this);
            bgroup.add(togg);
            return togg;
        }
    }
}
