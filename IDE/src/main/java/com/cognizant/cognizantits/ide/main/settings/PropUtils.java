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
package com.cognizant.cognizantits.ide.main.settings;

import com.cognizant.cognizantits.datalib.util.data.LinkedProperties;
import com.cognizant.cognizantits.ide.main.utils.table.JtableUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 */
public class PropUtils {

    public static void loadPropertiesInTable(LinkedProperties x, JTable table) {
        ((DefaultTableModel) table.getModel()).setRowCount(0);
        if (x != null) {
            for (Object key : x.orderedKeys()) {
                addValueinTable(table, key, (String) x.get(key.toString()));
            }
        }
    }

    public static void loadPropertiesInTable(Properties x, JTable table, String exculdeKey) {
        ((DefaultTableModel) table.getModel()).setRowCount(0);
        if (x != null) {
            for (Object key : x.keySet()) {
                if (!exculdeKey.equals(key)) {
                    addValueinTable(table, key, (String) x.get(key.toString()));
                }
            }
        }
    }

    public static void addValueinTable(JTable table, Object value1, String value2) {
        ((DefaultTableModel) table.getModel()).addRow(new Object[]{value1, value2});
    }

    public static Properties getPropertiesFromTable(JTable table) {
        return getPropertiesFromTable(new Properties(), table);
    }

    public static Properties getPropertiesFromTable(Properties x, JTable table) {
        JtableUtils.stopEditing(table);
        int rowcount = table.getRowCount();
        for (int i = 0; i < rowcount; i++) {
            String prop = getString(table.getValueAt(i, 0));
            String val = getString(table.getValueAt(i, 1));
            if (!prop.isEmpty()) {
                x.setProperty(prop, val);
            }
        }
        return x;
    }

    private static String getString(Object x) {
        return x != null ? x.toString().trim() : "";
    }

    public static String createFolder(String location) {
        if (!new File(location).exists()) {
            new File(location).mkdirs();
        }
        return location;
    }

    public static Properties loadProperties(String location) {
        Properties prop = new Properties();
        if (new File(location).exists()) {
            try (FileInputStream inputStream = new FileInputStream(location)) {
                prop.load(inputStream);
            } catch (IOException ex) {
                Logger.getLogger(PropUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return prop;
    }

    public static void saveProperties(Properties prop, String location) {
        try (FileOutputStream fout = new FileOutputStream(location)) {
            prop.store(fout, null);
        } catch (IOException ex) {
            Logger.getLogger(PropUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
