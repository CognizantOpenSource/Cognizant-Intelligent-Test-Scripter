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

import com.cognizant.cognizantits.ide.main.mainui.AppMainFrame;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * 
 */
public class ImportTestData {

    private final AppMainFrame sMainFrame;

    JFileChooser tdFileChooser;

    public ImportTestData(AppMainFrame sMainFrame) {
        this.sMainFrame = sMainFrame;
        tdFileChooser = new JFileChooser(new File(System.getProperty("user.dir")));
        tdFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        tdFileChooser.setFileFilter(new FileNameExtensionFilter("TestData Files", "csv"));
    }

    public void importTestData() {
        int val = tdFileChooser.showOpenDialog(sMainFrame);
        if (val == JFileChooser.APPROVE_OPTION) {
            File file = tdFileChooser.getSelectedFile();
            sMainFrame.getTestDesign().getTestDatacomp().importTestData(file);
        }
    }
}
