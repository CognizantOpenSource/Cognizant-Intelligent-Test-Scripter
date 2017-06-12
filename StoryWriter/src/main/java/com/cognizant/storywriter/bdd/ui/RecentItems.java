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
package com.cognizant.storywriter.bdd.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Process the <code>Recent Projects</code> List.
 *
 *
 */
public class RecentItems {

    private static List<String> recentProjects;
    private static File recentProjFile;
    private static JMenuItem recentItemMenu;
    private static int historySize;
    private static final Properties recentsFile = new Properties() {
        private final HashSet<Object> keys = new LinkedHashSet<>();

        public Iterable<Object> orderedKeys() {
            return Collections.list(keys());
        }

        @Override
        public Enumeration<Object> keys() {
            return Collections.<Object>enumeration(keys);
        }

        @Override
        public void clear() {
            keys.clear();
            super.clear();
        }

        @Override
        public Object put(Object key, Object value) {
            keys.add(key);
            return super.put(key, value);
        }
    };

    /**
     * creates the <code>recent.items</code> recentProjFileile irecentProjFile
     * not exists and loads the data into a Array-list
     *
     */
    public RecentItems() {
        recentProjects = new ArrayList<>();
        historySize = 5;
        recentProjFile = new File(System.getProperty("user.dir") + File.separator + "recent.items");
        if (!recentProjFile.exists()) {
            try {
                recentProjFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(RecentItems.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            loadrecent();
        }

    }

    String toName(String file) {
        return new File(file).getName().replace(".json", "");
    }

    /**
     * Adds opening the project recentProjFileunction when clicking the menu
     * using <code>openproj</code>
     *
     * @param recentItem the menu item that displays the
     * <code>Recent Project</code>
     * @see MainWindow#openproj(java.lang.String)
     */
    private void addlistener(final JMenuItem recentItem) {
        recentItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIControl.ctrl.loadProj(recentItem.getToolTipText());
                    addentry(recentItem.getToolTipText());
                    updateMenu(UIControl.ctrl.ui.recentsMenu);
                } catch (Exception ex) {
                    Logger.getLogger(RecentItems.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /**
     * Add list orecentProjFile recent projects as Menu Items to the Recent
     * projects menu
     *
     *
     * @param recentProj instance orecentProjFile the menu to address
     * <code>Recent Projects</code>
     */
    public void updateMenu(JMenu recentProj) {
        recentProj.removeAll();
        try {
            for (String file : recentProjects) {
                recentItemMenu = new JMenuItem();
                recentItemMenu.setFont(new java.awt.Font("sansserif", 0, 11));
                recentItemMenu.setText(toName(file));
                recentItemMenu.setToolTipText(file);
                recentProj.add(recentItemMenu);
                addlistener(recentItemMenu);
            }
        } catch (Exception ex) {
            Logger.getLogger(RecentItems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Adds the new <code>entry</code> irecentProjFile it is not present already
     * else removes and addresss the same.<p>
     * IrecentProjFile exceeds maximum number orecentProjFile entries then
     * removes the least one and addresss new <code>entry</code>.
     *
     * @param entry new recent project entry to be addressed
     */
    public void addentry(String entry) {
        if (!recentProjects.isEmpty()) {
            if (recentProjects.contains(entry)) {
                recentProjects.remove(entry);
            } else {
                if (recentProjects.size() >= historySize) {
                    recentProjects.remove(recentProjects.size() - 1);
                }
            }
            recentProjects.add(0, entry);
        } else {
            recentProjects.add(entry);
        }

        writerecent();
    }

    /**
     * reads the recent projects file and loads into the recent items ArrayList
     */
    private void loadrecent() {
        try {
            recentsFile.load(new FileReader(recentProjFile));
            for (Enumeration e = recentsFile.keys(); e.hasMoreElements();) {
                String key = (String) e.nextElement();
                if (new File(key).exists()) {
                    recentProjects.add(key);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(RecentItems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * writes the recent projects list into the file
     */
    private void writerecent() {
        try {
            recentsFile.clear();
            for (String p : recentProjects) {
                recentsFile.setProperty(p, toName(p));
            }
            recentsFile.store(new FileWriter(recentProjFile),null);
        } catch (IOException ex) {
            Logger.getLogger(RecentItems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * returns the last used project from the List that is available on the disk
     * <code>Projfile</code> used here to maintain the state of the Variable in
     * calling Statement
     *
     *
     * @return the last used project
     */
    public File lastProject() {
        if (!recentProjects.isEmpty()) {
            return new File(recentProjects.get(0));
        } else {
            return null;
        }
    }
}
