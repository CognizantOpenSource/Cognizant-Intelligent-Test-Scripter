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
package com.cognizant.cognizantits.ide.main.utils.dnd;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * 
 * @param <T>
 */
public class TransferableNode<T> implements Transferable {

    private final T sourceNode;
    private final DataFlavor dataFlavor;

    public TransferableNode(T sourceNode, DataFlavor dataFlavor) {
        this.sourceNode = sourceNode;
        this.dataFlavor = dataFlavor;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {

        return new DataFlavor[]{dataFlavor};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(dataFlavor);
    }

    @Override
    public T getTransferData(DataFlavor flavor)
            throws UnsupportedFlavorException, IOException {

        if (flavor.equals(dataFlavor)) {
            return sourceNode;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}
