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
package com.cognizant.cognizantits.ide.util;

/**
 *
 * 
 */
public class SystemInfo {

    private static final String[] OS_INFO = {"os.name", "os.version", "os.arch"},
            OS_INFO_NAME = {"OS Name         : ",
                "OS Version      : ",
                "OS Architecture : "},
            JAVA_INFO = {"java.vm.version", "java.home", "java.version", "java.runtime.version", "java.class.path", "sun.io.unicode.encoding"},
            FILE_SYS_INFO = {"user.dir", "file.separator", "path.separator"},
            JAVA_INFO_NAME = {"Java VM Version      : ",
                "Java Home            : ",
                "Java Version         : ",
                "Java Runtime Version : ",
                "Java ClassPath       : ",
                "IO Unicode Encoding  : "},
            FIEL_SYS_INFO_NAME = {"User Directory : ",
                "File Separator : ",
                "Path Separator : "};

   private SystemInfo(){
       
   }

    public static String getOSInfo() {
        String info = "";
        int index = 0;
        for (String key : OS_INFO) {
            info += OS_INFO_NAME[index++] + System.getProperty(key) + System.lineSeparator();
        }

        return info;
    }

    public static String getFileSystemInfo() {
        String info = "";
        int index = 0;
        for (String key : FILE_SYS_INFO) {
            info += FIEL_SYS_INFO_NAME[index++] + System.getProperty(key) + System.lineSeparator();
        }

        return info;
    }

    public static String getJavaInfo() {
        String info = "";
        int index = 0;
        for (String key : JAVA_INFO) {
            info += JAVA_INFO_NAME[index++] + System.getProperty(key) + System.lineSeparator();
        }

        return info;
    }

    public static boolean isWindows() {
        return System.getProperty(OS_INFO[0]).toLowerCase().contains("windows");
    }
     public static boolean osx() {
        return System.getProperty(OS_INFO[0]).toLowerCase().contains("mac");
    }

}
