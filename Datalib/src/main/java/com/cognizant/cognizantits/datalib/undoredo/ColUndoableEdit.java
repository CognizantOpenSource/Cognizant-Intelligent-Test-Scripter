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
package com.cognizant.cognizantits.datalib.undoredo;

import javax.swing.table.AbstractTableModel;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

/**
 *
 * 
 */
public class ColUndoableEdit extends CommonUndoableEdit {

    private final String colName;
    private final int colIndex;
    private final Object[] values;

    private final Boolean added;

    public ColUndoableEdit(AbstractTableModel model, UndoRedoProgress progress,
            String colName, int colIndex, Boolean added) {
        super(model, progress);
        this.colName = colName;
        this.colIndex = colIndex;
        this.added = added;
        this.values = new Object[model.getRowCount()];
        loadValuesFromModel();
    }

    public ColUndoableEdit(AbstractTableModel model, UndoRedoProgress progress,
            int colIndex, Boolean added) {
        super(model, progress);
        this.colName = getModel().getColumnName(colIndex);
        this.colIndex = colIndex;
        this.added = added;
        this.values = new Object[model.getRowCount()];
        loadValuesFromModel();
    }

    public ColUndoableEdit(AbstractTableModel model, UndoRedoProgress progress,
            String colName, Boolean added) {
        super(model, progress);
        this.colName = colName;
        this.colIndex = getModel().findColumn(colName);
        this.added = added;
        this.values = new Object[model.getRowCount()];
        loadValuesFromModel();
    }

    private void loadValuesFromModel() {
        for (int i = 0; i < values.length; i++) {
            values[i] = getModel().getValueAt(i, colIndex);
        }
    }

    @Override
    public void redo() throws CannotRedoException {
        startProgress();
        if (added) {
            getModel().insertColumnAt(colIndex, colName, values);
        } else {
            getModel().removeColumn(colIndex);
        }
        super.redo();
        stopProgress();
    }

    @Override
    public void undo() throws CannotUndoException {
        startProgress();
        if (added) {
            getModel().removeColumn(colIndex);
        } else {
            getModel().insertColumnAt(colIndex, colName, values);
        }
        super.undo();
        stopProgress();
    }

    @Override
    public final UndoRedoModel getModel() {
        return (UndoRedoModel) super.getModel();
    }
}
