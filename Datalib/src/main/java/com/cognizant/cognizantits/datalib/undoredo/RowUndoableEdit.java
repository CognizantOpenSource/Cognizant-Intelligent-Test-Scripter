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
public class RowUndoableEdit extends CommonUndoableEdit {

    private final int row;
    private final Object[] values;

    private final Boolean added;

    public RowUndoableEdit(AbstractTableModel model, UndoRedoProgress progress,
            int row, Boolean added) {
        super(model, progress);
        this.row = row;
        this.values = new Object[getModel().getColumnCount()];
        for (int i = 0; i < values.length; i++) {
            values[i] = getModel().getValueAt(row, i);
        }
        this.added = added;
    }

    public RowUndoableEdit(AbstractTableModel model, UndoRedoProgress progress,
            int row, Object[] values, Boolean added) {
        super(model, progress);
        this.row = row;
        this.values = values;
        this.added = added;
    }

    @Override
    public void redo() throws CannotRedoException {
        startProgress();
        if (added) {
            getModel().insertRow(row, values);
        } else {
            getModel().removeRow(row);
        }
        super.redo();
        stopProgress();
    }

    @Override
    public void undo() throws CannotUndoException {
        startProgress();
        if (added) {
            getModel().removeRow(row);
        } else {
            getModel().insertRow(row, values);
        }
        super.undo();
        stopProgress();
    }

    @Override
    public final UndoRedoModel getModel() {
        return (UndoRedoModel) super.getModel();
    }

}
