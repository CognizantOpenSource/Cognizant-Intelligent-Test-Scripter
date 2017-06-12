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
package com.cognizant.cognizantits.extension.logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author 394173
 */
public class LogUtil {

    public static Logger getLogger(String className) {
        init();
        Logger log = Logger.getLogger(className);
        log.addHandler(handler);
        return log;
    }

    private final static Logger LOG = Logger.getLogger(LogUtil.class.getName());
    private static FileHandler handler;

    static void init() {
        try {
            if (handler == null) {
                new File("logs" + File.separator + "extension").mkdirs();
                handler = new FileHandler("logs" + File.separator + "extension" + File.separator + "log-%g.txt", 4096 * 1024, 100, true);
                handler.setFormatter(new SimpleFormatter());
                LOG.addHandler(handler);
            }
        } catch (IOException | SecurityException ex) {
            LOG.log(Level.SEVERE, "Error creating log", ex);
        }
    }
}
