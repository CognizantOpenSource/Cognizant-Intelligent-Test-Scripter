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
package com.cognizant.storywriter.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 */
public class Tools {

    static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private static final long millisinDay = 1000 * 60 * 60 * 24;
    public static FileNameExtensionFilter json = new FileNameExtensionFilter("BDD proj", "json"),
            feature = new FileNameExtensionFilter("BDD Story", "feature");

    synchronized public static void writeFile(File f, String s) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(f));) {
            out.write((s));
        } catch (Exception ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    synchronized public static String readFile(File path) throws Exception {
        return (new Scanner(path).useDelimiter("\\A").next());
    }

    synchronized public static long getMillisNow(String dateInString) {

        try {
            Date date = formatter.parse(dateInString), now = new Date();
            return date.getTime() - now.getTime();
        } catch (java.text.ParseException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static String today() {
        return formatter.format(new Date());
    }

    public static String after(int days) {
        return formatter.format(getDateafter(days));
    }

    private static Date getDateafter(int days) {
        return new Date(new Date().getTime() + toMillis(days));
    }

    private static long toMillis(int days) {
        return millisinDay * (long) days;
    }

    public static Date toDate(String edate) {
        try {
            return formatter.parse(edate);
        } catch (ParseException ex) {
            return new Date();
        }
    }
}
