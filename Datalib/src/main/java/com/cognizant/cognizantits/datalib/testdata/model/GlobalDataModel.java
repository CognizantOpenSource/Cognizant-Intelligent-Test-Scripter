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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * 
 */
public abstract class GlobalDataModel extends AbstractDataModel<List<String>> {

    public GlobalDataModel(String location, Boolean isFromFile) {
        super(location, isFromFile);
        afterConst();
    }

    private void afterConst() {
        if (getColumnCount() == 0) {
            setColumns(new String[]{"GlobalDataID"});
            setSaved(false);
        }
    }

    @Override
    public List<String> getNewRecord() {
        return new ArrayList<>();
    }

    @Override
    public List<List<String>> getRecords() {
        return super.getRecords();
    }

    @Override
    public boolean canEditOnExecution(int columnIndex) {
        return columnIndex > 0;
    }

    @Override
    public Boolean delete() {
        return true;
    }

    public List<String> getRecordByKey(String key) {
        if (hasColumn("GlobalDataID")) {
            return getRecordByColumn("GlobalDataID", key);
        }
        return null;
    }

    public List<String> getKeys() {
        List<String> keys = new ArrayList<>();
        if (hasColumn("GlobalDataID")) {
            for (int i = 0; i < getRowCount(); i++) {
                String val = Objects.toString(getValueAt(i, findColumn("GlobalDataID")));
                if (!val.trim().isEmpty()) {
                    keys.add(val);
                }
            }
        }
        return keys;
    }

    public int getRecordIndexByKey(String key) {
        if (getRecordByKey(key) != null) {
            return getRecords().indexOf(getRecordByKey(key));
        }
        return -1;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            if (!Objects.toString(aValue, "").trim().isEmpty()
                    && !aValue.toString().startsWith("#")) {
                aValue = "#" + aValue.toString();
            }
        }
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

}
