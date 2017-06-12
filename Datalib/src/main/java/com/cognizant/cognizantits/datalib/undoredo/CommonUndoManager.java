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

import java.util.ArrayList;
import java.util.List;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

/**
 *
 * 
 */
public class CommonUndoManager extends UndoManager {

    private final UndoRedoProgress progress;

    private final List<UndoableEdit> groupEdits;

    private Boolean isGroupEdit = false;

    public CommonUndoManager() {
        progress = new UndoRedoProgress();
        groupEdits = new ArrayList<>();
    }

    public void startGroupEdit() {
        groupEdits.clear();
        isGroupEdit = true;
    }

    @Override
    public synchronized boolean addEdit(UndoableEdit ue) {
        if (!progress.isInProgress()) {
            if (isGroupEdit) {
                groupEdits.add(ue);
                return false;
            } else {
                return super.addEdit(ue);
            }
        }
        return false;
    }

    public void stopGroupEdit() {
        isGroupEdit = false;
        addEdit(new GroupUndoableEdit(null, progress, groupEdits));
    }

    public void removeEdits(int till) {
        int to = super.edits.size() - 1;
        int from = super.edits.size() - till;
        trimEdits(from, to);
    }

    public void clearEdits() {
        super.discardAllEdits();
    }

    public UndoRedoProgress getProgress() {
        return progress;
    }

    @Override
    public UndoableEdit lastEdit() {
        return super.lastEdit();
    }

    @Override
    public synchronized void redo() throws CannotRedoException {
        if (canRedo()) {
            super.redo();
        }
    }

    @Override
    public synchronized void undo() throws CannotUndoException {
        if (canUndo()) {
            super.undo();
        }
    }

}
