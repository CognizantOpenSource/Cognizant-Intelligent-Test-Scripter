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
package com.cognizant.cognizantits.ide.main.mainui.components.testexecution.testset;

import static com.cognizant.cognizantits.datalib.component.ExecutionStep.HEADERS.Browser;
import static com.cognizant.cognizantits.datalib.component.ExecutionStep.HEADERS.Iteration;
import static com.cognizant.cognizantits.datalib.component.ExecutionStep.HEADERS.Platform;
import static com.cognizant.cognizantits.datalib.component.ExecutionStep.HEADERS.TestCase;
import static com.cognizant.cognizantits.datalib.component.ExecutionStep.HEADERS.TestScenario;
import com.cognizant.cognizantits.datalib.component.Project;
import com.cognizant.cognizantits.engine.drivers.WebDriverFactory;
import com.cognizant.cognizantits.ide.main.utils.Utils;
import com.cognizant.cognizantits.ide.main.utils.table.autosuggest.AutoSuggest;
import com.cognizant.cognizantits.ide.main.utils.table.autosuggest.AutoSuggestCellEditor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JTable;

public class TestSetAutoSuggest {

    private final Project sProject;

    private final JTable table;

    private AutoSuggest scenarioAutoSuggest;

    private AutoSuggest testCaseAutoSuggest;

    private AutoSuggest iterationAutoSuggest;

    private AutoSuggest browserAutoSuggest;

    private AutoSuggest platformAutoSuggest;

    public TestSetAutoSuggest(Project sProject, JTable table) {
        this.sProject = sProject;
        this.table = table;
        initAutoSuggest();
    }

    private void initAutoSuggest() {
        scenarioAutoSuggest = new AutoSuggest() {

            @Override
            public void beforeSearch(String text) {
                setSearchList(Utils.asStringList(sProject.getScenarios()));
            }
        };
        testCaseAutoSuggest = new AutoSuggest() {
            @Override
            public void beforeSearch(String text) {
                clearSearchList();
                String scenario = Objects.toString(table.getValueAt(table.getSelectedRow(), 1), "");
                if (!scenario.trim().isEmpty()
                        && sProject.getScenarioByName(scenario) != null) {
                    setSearchList(Utils.asStringList(sProject.getScenarioByName(scenario).getTestCases()));
                }
            }

        };
        iterationAutoSuggest = new AutoSuggest().withSearchList(getIterationList());
        browserAutoSuggest = new AutoSuggest();
        platformAutoSuggest = new AutoSuggest().withSearchList(getPlatformList());
    }

    public void installForTestSet() {
        table.getColumnModel().getColumn(0).setMaxWidth(70);
        table.getColumnModel().getColumn(TestScenario.getIndex()).setCellEditor(new AutoSuggestCellEditor(scenarioAutoSuggest));
        table.getColumnModel().getColumn(TestCase.getIndex()).setCellEditor(new AutoSuggestCellEditor(testCaseAutoSuggest));
        table.getColumnModel().getColumn(Iteration.getIndex()).setCellEditor(new AutoSuggestCellEditor(iterationAutoSuggest));
        table.getColumnModel().getColumn(Browser.getIndex()).setCellEditor(new AutoSuggestCellEditor(browserAutoSuggest));
        table.getColumnModel().getColumn(Platform.getIndex()).setCellEditor(new AutoSuggestCellEditor(platformAutoSuggest));
    }

    private List<String> getIterationList() {
        List<String> iterationList = new ArrayList<>();
        iterationList.add("All");
        iterationList.add("Single");
        iterationList.add("n");
        iterationList.add("n:n");
        return iterationList;
    }

    private List<String> getPlatformList() {
        return WebDriverFactory.getPlatFormList();
    }

    void loadBrowsers() {
        List<String> browsers = WebDriverFactory.Browser.getValuesAsList();
        browsers.addAll(sProject.getProjectSettings().getEmulators().getEmulatorNames());
        browserAutoSuggest.setSearchList(browsers);
    }
}
