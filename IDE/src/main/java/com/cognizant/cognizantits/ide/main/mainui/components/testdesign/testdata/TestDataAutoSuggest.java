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

import com.cognizant.cognizantits.datalib.component.Project;
import com.cognizant.cognizantits.engine.util.data.fx.FParser;
import com.cognizant.cognizantits.ide.main.utils.Utils;
import com.cognizant.cognizantits.ide.main.utils.table.autosuggest.AutoSuggest;
import com.cognizant.cognizantits.ide.main.utils.table.autosuggest.AutoSuggestCellEditor;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * 
 */
public class TestDataAutoSuggest {

    private final Project sProject;
    private final JTable table;

    private AutoSuggest scenarioSugg;
    private AutoSuggest testCaseSugg;
    private AutoSuggest functionSugg;

    public TestDataAutoSuggest(Project sProject, JTable table) {
        this.sProject = sProject;
        this.table = table;
        init();
    }

    private void init() {
        functionSugg = new AutoSuggest() {
            @Override
            public void beforeSearch(String text) {
                if (text.startsWith("=")) {
                    setSearchList(getFunctionList());
                } else {
                    clearSearchList();
                }
            }

            private List<String> getFunctionList() {
                List<String> functions = new ArrayList<>();
                for (String func : FParser.getFuncList()) {
                    functions.add("=".concat(func));
                }
                return functions;
            }

        }.withOnHide(stopEditingOnFocusLost());
        scenarioSugg = new AutoSuggest().withOnHide(stopEditingOnFocusLost());
        testCaseSugg = new AutoSuggest().withOnHide(stopEditingOnFocusLost());
    }

    private Action stopEditingOnFocusLost() {
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }
            }
        };
    }

    private void updateScenarios() {
        scenarioSugg.setSearchList(Utils.asStringList(sProject.getScenarios()));
    }

    private void updateTestCases() {
        testCaseSugg.clearSearchList();
        if (table.getSelectedRow() != -1) {
            String scenario = Objects.toString(
                    table.getValueAt(table.getSelectedRow(), 0), "");
            if (!scenario.trim().isEmpty()
                    && sProject.getScenarioByName(scenario) != null) {
                testCaseSugg.setSearchList(
                        Utils.asStringList(
                                sProject.getScenarioByName(scenario).getTestCases()));
            }
        }
    }

    public TableCellEditor getCellEditorFor(int column, TableCellEditor cellEditor) {
        switch (column) {
            case 0:
                updateScenarios();
                return new AutoSuggestCellEditor(scenarioSugg);
            case 1:
                updateTestCases();
                return new AutoSuggestCellEditor(testCaseSugg);
            case 2:
            case 3:
                return cellEditor;
            default:
                return new AutoSuggestCellEditor(functionSugg);
        }
    }
}
