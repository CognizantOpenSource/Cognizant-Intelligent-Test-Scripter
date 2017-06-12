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
package com.cognizant.cognizantits.datalib.component;

import com.cognizant.cognizantits.datalib.undoredo.UndoRedoModel;

/**
 *
 * 
 */
public abstract class DataModel extends UndoRedoModel {

    public abstract void loadTableModel();

    public abstract Boolean rename(String newName);

    public abstract Boolean delete();

    public abstract Boolean addRow();

    @Override
    public void insertColumnAt(int colIndex, String name, Object[] values) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeColumn(int colIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
