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
public class CellUndoableEdit extends CommonUndoableEdit {

    private final int row, column;
    private final Object oldValue, newValue;

    public CellUndoableEdit(AbstractTableModel model, UndoRedoProgress progress,
            int row, int column, Object oldValue, Object newValue) {
        super(model, progress);
        this.row = row;
        this.column = column;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @Override
    public void redo() throws CannotRedoException {
        startProgress();
        getModel().setValueAt(newValue, row, column);
        super.redo();
        stopProgress();
    }

    @Override
    public void undo() throws CannotUndoException {
        startProgress();
        getModel().setValueAt(oldValue, row, column);
        super.undo();
        stopProgress();
    }

}
