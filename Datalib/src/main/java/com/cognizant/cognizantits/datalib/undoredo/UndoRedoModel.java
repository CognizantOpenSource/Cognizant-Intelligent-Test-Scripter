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

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.swing.table.AbstractTableModel;

/**
 *
 * 
 */
public abstract class UndoRedoModel extends AbstractTableModel {

    private final CommonUndoManager undoManager;

    public UndoRedoModel() {
        undoManager = new CommonUndoManager();
    }

    @JsonIgnore
    public CommonUndoManager getUndoManager() {
        return undoManager;
    }

    public void clearUndoRedo() {
        undoManager.clearEdits();
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        Object oldValue = getValueAt(row, column);
        undoManager.addEdit(new CellUndoableEdit(
                this, undoManager.getProgress(),
                row, column, oldValue, value));
    }

    public void clearValues(int[] rows, int columns[]) {
        startGroupEdit();
        for (int row : rows) {
            for (int column : columns) {
                setValueAt("", row, column);
            }
        }
        stopGroupEdit();
    }

    public void startGroupEdit() {
        undoManager.startGroupEdit();
    }

    public void stopGroupEdit() {
        undoManager.stopGroupEdit();
    }

    public void rowDeleted(int row) {
        undoManager.addEdit(new RowUndoableEdit(
                this, undoManager.getProgress(), row, false));
    }

    public void rowAdded(int row) {
        undoManager.addEdit(new RowUndoableEdit(
                this, undoManager.getProgress(), row, true));
    }

    public void columnAdded(String name) {
        undoManager.addEdit(new ColUndoableEdit(
                this, undoManager.getProgress(), name, true));
    }

    public void columnRemoved(int index) {
        undoManager.addEdit(new ColUndoableEdit(
                this, undoManager.getProgress(), index, false));
    }

    public abstract void removeRow(int row);

    public abstract void insertRow(int row, Object[] values);

    public abstract void insertColumnAt(int colIndex, String colName, Object[] values);

    public abstract void removeColumn(int colIndex);

}
