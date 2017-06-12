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
package com.cognizant.cognizantits.testdata.csv;

import com.cognizant.cognizantits.datalib.component.Project;
import com.cognizant.cognizantits.datalib.component.TestData;
import java.io.File;
import com.cognizant.cognizantits.datalib.component.utils.FileUtils;
import com.cognizant.cognizantits.datalib.testdata.DataProvider;
import com.cognizant.cognizantits.datalib.testdata.model.Record;

@DataProvider(type = "csv")
public class CsvDataProvider extends TestData {

    public CsvDataProvider(Project sProject, String enviroment) {
        super(sProject, enviroment);
    }

    @Override
    public void load() {
        File file = new File(getLocation());
        if (file.exists()) {
            for (File tData : file.listFiles(FileUtils.CSV_FILTER)) {
                if (!tData.getName().equals("GlobalData.csv")) {
                    addTestData(new CsvTestData(tData.getAbsolutePath()));
                }
            }
        }
        loadGlobalData();
    }

    private void loadGlobalData() {
        File file = new File(getLocation() + File.separator + "GlobalData.csv");
        setGlobalData(new CsvGlobalData(file.getAbsolutePath()));
    }

    @Override
    public CsvTestData getNewTestData(String name) {
        CsvTestData csvData = new CsvTestData(getLocation() + File.separator + name + ".csv");
        csvData.setColumns(Record.HEADERS);
        csvData.addColumn("Data1");
        csvData.addColumn("Data2");
        return csvData;
    }

    @Override
    public CsvTestData importTestData(File file) {
        CsvTestData csvData = new CsvTestData(file.getAbsolutePath());
        csvData.loadTableModel();
        csvData.setLocation(getLocation() + File.separator + file.getName());
        csvData.saveChanges();
        return csvData;
    }

}
