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

import com.cognizant.cognizantits.datalib.testdata.model.AbstractDataModel;
import com.cognizant.cognizantits.datalib.testdata.model.GlobalDataModel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CsvGlobalData extends GlobalDataModel {

    public CsvGlobalData(String location) {
        super(location, true);
    }

    @Override
    public List<String> getNewRecord() {
        return new ArrayList<>();
    }

    @Override
    public Boolean rename(String newName) {
        //Not Supported
        return false;
    }

    @Override
    public void saveChanges() {
        CSVUtils.saveChanges(this);
    }

    @Override
    public String getName() {
        String name = new File(getLocation()).getName();
        return name.substring(0, name.lastIndexOf("."));
    }

    @Override
    public Set<String> loadColumns(File location) {
        return CSVUtils.loadColumns(location);
    }

    @Override
    public CsvGlobalData loadRecords(File location) {
        CSVUtils.load(location, this);
        return this;
    }

    @Override
    public Set<String> loadColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AbstractDataModel loadRecords() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
