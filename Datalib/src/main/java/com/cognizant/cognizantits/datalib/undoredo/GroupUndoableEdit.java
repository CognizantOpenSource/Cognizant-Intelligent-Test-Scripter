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

import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;

/**
 *
 * 
 */
public class GroupUndoableEdit extends CommonUndoableEdit {

    private final List<UndoableEdit> groupEdits;

    public GroupUndoableEdit(AbstractTableModel model, UndoRedoProgress progress,
            List<UndoableEdit> groupEdits) {
        super(model, progress);
        Collections.reverse(groupEdits);
        this.groupEdits = groupEdits;
    }

    @Override
    public synchronized void redo() throws CannotRedoException {
        startProgress();
        for (int i = groupEdits.size() - 1; i >= 0; i--) {
            groupEdits.get(i).redo();
        }
        super.redo();
        stopProgress();
    }

    @Override
    public synchronized void undo() throws CannotUndoException {
        startProgress();
        for (int i = 0; i < groupEdits.size(); i++) {
            groupEdits.get(i).undo();
        }
        super.undo();
        stopProgress();
    }

}
