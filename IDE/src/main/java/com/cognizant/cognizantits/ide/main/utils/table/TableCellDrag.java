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
package com.cognizant.cognizantits.ide.main.utils.table;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JTable;

public class TableCellDrag extends MouseAdapter implements MouseMotionListener {

    Cell startLocation = null;

    List<Integer[]> rowsRColumns = new ArrayList<>();

    private boolean isInDragOperation = false;

    public static void install(JTable table) {
        TableCellDrag tcellDrag = new TableCellDrag();
        table.addMouseListener(tcellDrag);
        table.addMouseMotionListener(tcellDrag);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object s = e.getSource();
        if (s instanceof JTable) {
            JTable t = (JTable) s;
            int x = t.getSelectedRow();
            int y = t.getSelectedColumn();
            if (x != -1 && y != -1) {
                Object d = Objects.toString(t.getModel().getValueAt(x, y), "");
                startLocation = new Cell(x, y, d);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (startLocation != null && isInDragOperation) {
            Object s = e.getSource();
            JTable t = (JTable) s;
            for (Integer[] index : rowsRColumns) {
                t.setValueAt(startLocation.getData(), index[0], index[1]);
            }
            startLocation = null;
        }
        rowsRColumns.clear();
        isInDragOperation = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.isAltDown() && startLocation != null) {
            isInDragOperation = true;
            JTable t = (JTable) e.getSource();
            int selRow = t.rowAtPoint(e.getPoint());
            int selColumn = t.columnAtPoint(e.getPoint());
            if (selRow != -1 && selColumn != -1) {
                rowsRColumns.add(new Integer[]{selRow, selColumn});
            }
        } else {
            isInDragOperation = false;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // leave empty.
    }

    class Cell {

        int x = 0;
        int y = 0;
        Object data = null;

        public Cell(int a, int b, Object d) {
            x = a;
            y = b;
            data = d;
        }

        public void setCell(int a, int b, Object d) {
            x = a;
            y = b;
            data = d;
        }

        public int getRow() {
            return x;
        }

        public int getColumn() {
            return y;
        }

        public Object getData() {
            return data;
        }
    }
}
