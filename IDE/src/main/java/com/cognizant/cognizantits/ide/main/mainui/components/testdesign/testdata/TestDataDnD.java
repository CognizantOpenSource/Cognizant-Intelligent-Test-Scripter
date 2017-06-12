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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign.testdata;

import com.cognizant.cognizantits.datalib.testdata.model.TestDataModel;
import com.cognizant.cognizantits.ide.main.utils.dnd.DataFlavors;
import com.cognizant.cognizantits.ide.main.utils.dnd.TransferableNode;
import java.awt.datatransfer.Transferable;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.TransferHandler;

/**
 *
 * 
 */
public class TestDataDnD extends TransferHandler {

    @Override
    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }

    @Override
    protected Transferable createTransferable(JComponent source) {
        JTable table = (JTable) source;
        if (table.getModel() instanceof TestDataModel) {
            TestDataModel tdm = (TestDataModel) table.getModel();
            TestDataDetail td = new TestDataDetail();
            td.setSheetName(tdm.getName());
            for (int col : table.getSelectedColumns()) {
                if (col > 3) {
                    td.getColumnNames().add(table.getColumnName(col));
                }
            }
            return new TransferableNode(td, DataFlavors.TESTDATA_FLAVOR);
        }
        return null;
    }
}
