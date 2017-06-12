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
package com.cognizant.cognizantits.datalib.settings;

import com.cognizant.cognizantits.datalib.util.data.LinkedProperties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class PropUtils {

    public static LinkedProperties load(File file) {
        return load(new LinkedProperties(), file);
    }

    public static LinkedProperties load(LinkedProperties properties, File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            properties.load(fis);
        } catch (IOException ex) {
            Logger.getLogger(PropUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return properties;
    }

    public static void save(Properties prop, String filename) {
        if (!new File(filename).getParentFile().exists()) {
            new File(filename).getParentFile().mkdirs();
        }
        try (FileOutputStream fout = new FileOutputStream(new File(filename))) {
            prop.store(fout, null);
        } catch (Exception ex) {
            Logger.getLogger(PropUtils.class.getName()).log(Level.SEVERE, filename, ex);
        }
    }
}
