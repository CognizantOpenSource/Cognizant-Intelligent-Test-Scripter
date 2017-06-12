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
package com.cognizant.cognizantits.testdata.csv;

import com.cognizant.cognizantits.datalib.component.utils.CSVHParser;
import com.cognizant.cognizantits.datalib.component.utils.FileUtils;
import com.cognizant.cognizantits.datalib.testdata.model.AbstractDataModel;
import com.cognizant.cognizantits.datalib.testdata.model.GlobalDataModel;
import com.cognizant.cognizantits.datalib.testdata.model.Record;
import com.cognizant.cognizantits.datalib.testdata.model.TestDataModel;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CSVUtils {

    public static void load(File location, AbstractDataModel sAbstractData) {
        CSVHParser parser = FileUtils.getCSVHParser(location);
        if (parser != null) {
            for (CSVRecord crecord : parser.getRecords()) {
                List record = sAbstractData.getNewRecord();
                for (int i = 0; i < crecord.size(); i++) {
                    record.add(crecord.get(i));
                }
                sAbstractData.addRecord(record);
            }
        }
    }

    public static Set<String> loadColumns(File location) {
        CSVHParser parser = FileUtils.getCSVHParser(location);
        if (parser != null) {
            return parser.getHeaderMap().keySet();
        }
        return new HashSet<>();
    }

    private static void createIfNotExists(String fileLoc) {
        File file = new File(fileLoc);
        file.getParentFile().mkdirs();
    }

    public static void saveChanges(GlobalDataModel globalData) {
        createIfNotExists(globalData.getLocation());
        try (FileWriter out = new FileWriter(new File(globalData.getLocation()));
                CSVPrinter printer = new CSVPrinter(out, CSVFormat.EXCEL.withIgnoreEmptyLines());) {
            for (String header : globalData.getColumns()) {
                printer.print(header);
            }
            printer.println();
            globalData.removeEmptyRecords();
            for (List<String> record : globalData.getRecords()) {
                for (String value : record) {
                    printer.print(value);
                }
                printer.println();
            }
        } catch (Exception ex) {
            Logger.getLogger(CSVUtils.class.getName()).log(Level.SEVERE, "Error while saving", ex);
        }
    }

    public static void saveChanges(TestDataModel testData) {
        createIfNotExists(testData.getLocation());
        try (FileWriter out = new FileWriter(new File(testData.getLocation()));
                CSVPrinter printer = new CSVPrinter(out, CSVFormat.EXCEL.withIgnoreEmptyLines());) {
            for (String header : testData.getColumns()) {
                printer.print(header);
            }
            printer.println();
            testData.removeEmptyRecords();
            for (Record record : testData.getRecords()) {
                for (String value : record) {
                    printer.print(value);
                }
                printer.println();
            }
        } catch (Exception ex) {
            Logger.getLogger(CSVUtils.class.getName()).log(Level.SEVERE, "Error while saving", ex);
        }
    }
}
