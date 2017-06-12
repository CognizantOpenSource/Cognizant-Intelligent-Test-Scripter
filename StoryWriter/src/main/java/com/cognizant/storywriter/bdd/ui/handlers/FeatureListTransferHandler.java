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
package com.cognizant.storywriter.bdd.ui.handlers;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.JComponent;
import javax.swing.TransferHandler;

/**
 *
 */
public class FeatureListTransferHandler extends TransferHandler {

    private static final Logger LOG = Logger.getLogger(FeatureListTransferHandler.class.getName());
    private final Consumer<File> onFeature;
    private final ToSafe<File> toSafe = new ToSafe<>();
    private final Predicate<File> FEATURE_FILE = FeatureFilter.get()::accept;

    public FeatureListTransferHandler(Consumer<File> onFeature) {
        this.onFeature = onFeature;
    }

    @Override
    public int getSourceActions(JComponent c) {
        return TransferHandler.COPY;
    }

    @Override
    public boolean importData(TransferHandler.TransferSupport support) {
        if (canImport(support)) {
            return dropFeature(support);
        }
        return false;
    }

    private Boolean dropFeature(TransferHandler.TransferSupport support) {
        try {
            dropFeature((List<File>) support.getTransferable().getTransferData(DataFlavor.javaFileListFlavor));
            return true;
        } catch (UnsupportedFlavorException | IOException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        LOG.warning("Invalid files.The files are not Feature files");
        return false;
    }

    private void dropFeature(List<File> files) {
        Stream.concat(
                toSafe.list(files).stream().filter(FEATURE_FILE),
                toSafe.list(files).stream().filter(File::isDirectory).flatMap(
                dir -> Arrays.asList(toSafe.array(dir.listFiles())).stream().filter(FEATURE_FILE))
        ).forEach(onFeature);
    }

    class ToSafe<T extends Object> {

        private List<T> list(List<T> list) {
            return list != null ? list : new ArrayList<>();
        }

        private T[] array(T[] array) {
            return array != null ? array : (T[]) new Object[0];
        }
    }

    @Override
    public boolean canImport(TransferHandler.TransferSupport support) {
        return support.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
    }

}
