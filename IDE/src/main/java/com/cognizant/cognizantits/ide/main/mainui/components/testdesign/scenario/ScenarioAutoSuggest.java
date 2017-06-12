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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign.scenario;

import com.cognizant.cognizantits.datalib.component.Project;
import com.cognizant.cognizantits.datalib.component.Scenario;
import com.cognizant.cognizantits.ide.main.utils.table.autosuggest.AutoSuggest;
import com.cognizant.cognizantits.ide.main.utils.table.autosuggest.AutoSuggestCellEditor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * 
 */
public class ScenarioAutoSuggest {

    private final Project sProject;

    private final JTable table;
    private AutoSuggest reusableAutoSuggest;

    public ScenarioAutoSuggest(Project sProject, JTable table) {
        this.sProject = sProject;
        this.table = table;
        initAutoSuggest();
        install();
    }

    private void initAutoSuggest() {
        reusableAutoSuggest = new AutoSuggest() {
            @Override
            public void beforeSearch(String text) {
                setSearchList(getReusables());
            }

        };
    }

    private List<String> getReusables() {
        List<String> reusableList = new ArrayList<>();
        for (Scenario scenario : sProject.getScenarios()) {
            int rcount = scenario.getReusableCount();
            for (int i = 0; i < rcount; i++) {
                reusableList.add(scenario.getName() + ":" + scenario.getReusableAt(i).getName());
            }
        }
        return reusableList;
    }

    private void stopEditing() {
        int row = table.getSelectedRow();
        int column = table.getSelectedColumn();
        if (table.isEditing()) {
            table.getCellEditor().stopCellEditing();
            table.getSelectionModel().setSelectionInterval(row, row);
            table.getColumnModel().getSelectionModel().setSelectionInterval(column, column);
        }
    }

    private void install() {
        table.setDefaultEditor(Object.class, new AutoSuggestCellEditor(reusableAutoSuggest));
    }
}
