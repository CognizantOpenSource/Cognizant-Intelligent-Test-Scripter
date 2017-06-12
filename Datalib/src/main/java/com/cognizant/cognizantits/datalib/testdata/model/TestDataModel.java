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
package com.cognizant.cognizantits.datalib.testdata.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 *
 * 
 */
public abstract class TestDataModel extends AbstractDataModel<Record> {

    public TestDataModel(String location, Boolean isFromFile) {
        super(location, isFromFile);
    }

    @Override
    public Record getNewRecord() {
        return new Record();
    }

    @Override
    public List<Record> getRecords() {
        return super.getRecords();
    }

    @Override
    public boolean canEditOnExecution(int columnIndex) {
        return columnIndex > 3;
    }

    public Queue<Integer> getDataIteration(String scenario, String testcase,
            int startIteration, int endIteration) {
        List<Integer> iterations = new LinkedList<>();
        iterations.addAll(getIterations(view().withTestcase(scenario, testcase).get(),
                getColumnIndex("Iteration"), startIteration, endIteration)
        );
        return (Queue<Integer>) iterations;
    }

    private List getIterations(List<List<String>> rows, int iter, int start, int end) {
        List<Integer> iterations = new LinkedList<>();
        if (rows != null && !rows.isEmpty()) {
            for (List<String> row : rows) {
                int i = parseInt(row.get(iter), 0);
                if (i >= start
                        && (i <= end || end == -1)) {
                    if (!iterations.contains(i)) {
                        iterations.add(i);
                    }
                }
            }
        }
        return iterations;
    }

    private int parseInt(String val, int def) {
        if (Objects.toString(val, "").matches("[0-9]+")) {
            return Integer.valueOf(val);
        }
        return def;
    }

    public void refactorScenario(String oldScenarioName, String newScenarioName) {
        Boolean clearOnExit = getRecords().isEmpty();
        loadTableModel();
        for (Record record : getRecords()) {
            if (record.getScenario().equals(oldScenarioName)) {
                record.setScenario(newScenarioName);
                fireTableCellUpdated(getRecords().indexOf(record), 0);
            }
        }
        if (clearOnExit) {
            save();
            getRecords().clear();
        }
    }

    public void refactorTestCase(String scenarioName, String oldTestCaseName, String newTestCaseName) {
        Boolean clearOnExit = getRecords().isEmpty();
        loadTableModel();
        for (Record record : getRecords()) {
            if (record.getScenario().equals(scenarioName) && record.getTestcase().equals(oldTestCaseName)) {
                record.setTestcase(newTestCaseName);
                fireTableCellUpdated(getRecords().indexOf(record), 1);
            }
        }
        if (clearOnExit) {
            save();
            getRecords().clear();
        }
    }

    public void refactorTestCaseScenario(String testCaseName, String oldScenarioName, String newScenarioName) {
        Boolean clearOnExit = getRecords().isEmpty();
        loadTableModel();
        for (Record record : getRecords()) {
            if (record.getScenario().equals(oldScenarioName) && record.getTestcase().equals(testCaseName)) {
                record.setScenario(newScenarioName);
                fireTableCellUpdated(getRecords().indexOf(record), 1);
            }
        }
        if (clearOnExit) {
            save();
            getRecords().clear();
        }
    }

}
