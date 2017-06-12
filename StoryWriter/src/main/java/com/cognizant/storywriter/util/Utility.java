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

import java.io.File;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utility {

    static final SimpleDateFormat DATA_FORMAT = new SimpleDateFormat("MM/dd/yyyy"),
            TIME_FORMAT = new SimpleDateFormat("hh:mm:ss a"),
            DATE_FILE_FORMAT = new SimpleDateFormat("MM-dd-yyyy"),
            TIME_FILE_FORMAT = new SimpleDateFormat("hh-mm-ssa"),
            LIC_DATE_FORMAT = new SimpleDateFormat("ddMMyyyy");

    static Path path;
    static File file;
 
    private Utility() {

    }

  

    public static boolean isEmpty(Object val) {
        return val == null || "".equals(val.toString().trim());
    }

  
    public static String getdatetimeString() {
        Date dat = new Date();
        return DATE_FILE_FORMAT.format(dat) + "_" + TIME_FILE_FORMAT.format(dat);
    }

    public static String getdateString() {
        Date dat = new Date();
        return DATE_FILE_FORMAT.format(dat);
    }

    

   
    public static String getValue(Object value) {
        if (isEmpty(value)) {
            return "";
        }
        return value.toString();
    }

    /**
     * return the Date difference in no of days
     *
     * @param exp
     * @return
     */
    public static int getDays(Date exp) {
        try {
            Date today = new Date();
            if (exp != null) {
                long diff = exp.getTime() - today.getTime();
                return (int) (diff / (24 * 60 * 60 * 1000));
            }
        } catch (Exception ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 30;
    }

}
