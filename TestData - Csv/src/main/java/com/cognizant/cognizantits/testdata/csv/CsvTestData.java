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
import com.cognizant.cognizantits.datalib.testdata.model.Record;
import com.cognizant.cognizantits.datalib.testdata.model.TestDataModel;
import java.io.File;
import java.util.Set;

/**
 *
 * @author 394173
 */
public class CsvTestData extends TestDataModel {

    public CsvTestData(String location) {
        super(location, true);
    }

    @Override
    public Record getNewRecord() {
        return new Record();
    }

    @Override
    public Boolean rename(String newName) {
        File f = new File(getLocation());
        File newFile = new File(f.getParent() + File.separator + newName + ".csv");
        if (f.exists()) {
            if (f.renameTo(newFile)) {
                setLocation(newFile.getAbsolutePath());
            } else {
                return false;
            }
        } else {
            setLocation(newFile.getAbsolutePath());
        }
        return true;
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
    public CsvTestData loadRecords(File location) {
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

    @Override
    public Boolean delete() {
        File f = new File(getLocation());
        if (f.exists()) {
            return f.delete();
        }
        return true;
    }

}
