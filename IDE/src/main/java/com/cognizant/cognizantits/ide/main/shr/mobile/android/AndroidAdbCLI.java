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
package com.cognizant.cognizantits.ide.main.shr.mobile.android;

import com.cognizant.cognizantits.ide.util.Notification;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AndroidAdbCLI {
    
    private final String adbPath = "/Users/Apple/Library/Android/sdk/platform-tools/";//For Testing
    private String serial = System.getenv("ANDROID_SERIAL");
    private ProcRunner procRunner;
    private int retCode = -1;
    
    public void setSerial(Object serial) {
        this.serial = serial != null ? serial.toString() : null;
    }
    
    public List<String> getDevices() {
        List<String> devices = new ArrayList<>();
        procRunner = getAdbRunner(serial,
                "devices");
        try {
            retCode = procRunner.run(30000);
            if (retCode != 0) {
                throw new IOException(
                        "Non-zero return code from devices command\n"
                        + procRunner.getOutputBlob());
            }
            for (int i = 1; i < procRunner.mOutput.size(); i++) {
                String val = procRunner.mOutput.get(i);
                if (!val.trim().isEmpty()) {
                    if (val.contains("\t")) {
                        devices.add(val.substring(0, val.indexOf('\t')));
                    }
                }
            }
            if (devices.isEmpty()) {
                Notification.show("No device found. Please Check whether the device is connected or not");
            }
        } catch (IOException e) {
            Notification.show(e.getMessage());
            Logger.getLogger(AndroidAdbCLI.class.getName()).log(Level.SEVERE, null, e);
        }
        return devices;
    }
    
    public File takeScreenshot() {
        File screenshotfile;
        try {
            screenshotfile = File.createTempFile("screenshot", ".png", null);
        } catch (IOException ex) {
            Notification.show("Could not create Temp file");
            Logger.getLogger(AndroidAdbCLI.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        procRunner = getAdbRunner(serial,
                "shell", "rm", "/sdcard/screenshot.png");
        try {
            retCode = procRunner.run(30000);
            if (retCode != 0) {
                throw new IOException(
                        "Non-zero return code from \"rm\" screenshot command:\n"
                        + procRunner.getOutputBlob());
            }
        } catch (IOException e) {
//            Notification.show(e.getMessage());
            Logger.getLogger(AndroidAdbCLI.class.getName()).log(Level.SEVERE, null, e);
//            return null;
        }
        procRunner = getAdbRunner(serial, "shell", "screencap", "-p", "/sdcard/screenshot.png");
        try {
            retCode = procRunner.run(30000);
            if (retCode != 0) {
                throw new IOException("Non-zero return code from screenshot command:\n"
                        + procRunner.getOutputBlob());
            }
        } catch (IOException e) {
            Logger.getLogger(AndroidAdbCLI.class.getName()).log(Level.SEVERE, null, e);
            Notification.show(e.getMessage());
            return null;
        }
        procRunner = getAdbRunner(serial, "pull", "/sdcard/screenshot.png", screenshotfile.getAbsolutePath());
        try {
            retCode = procRunner.run(30000);
            if (retCode != 0) {
                throw new IOException("Non-zero return code from pull command:\n" + procRunner.getOutputBlob());
            }
        } catch (IOException e) {
            Logger.getLogger(AndroidAdbCLI.class.getName()).log(Level.SEVERE, null, e);
            Notification.show(e.getMessage());
            return null;
        }
        return screenshotfile;
    }
    
    public File takeXML() {
        File xmlDumpFile;
        try {
            xmlDumpFile = File.createTempFile("dump", ".xml", null);
        } catch (IOException ex) {
            Notification.show("Could not create Temp xml file");
            Logger.getLogger(AndroidAdbCLI.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        procRunner = getAdbRunner(serial,
                "shell", "rm", "/sdcard/uidump.xml");
        try {
            retCode = procRunner.run(30000);
            if (retCode != 0) {
                throw new IOException(
                        "Non-zero return code from \"rm\" xml dump command:\n"
                        + procRunner.getOutputBlob());
            }
        } catch (IOException e) {
//            Notification.show(e.getMessage());
            Logger.getLogger(AndroidAdbCLI.class.getName()).log(Level.SEVERE, null, e);
//            return null;
        }
        procRunner = getAdbRunner(serial,
                "shell", "/system/bin/uiautomator", "dump", "/sdcard/uidump.xml");
        try {
            retCode = procRunner.run(30000);
            if (retCode != 0) {
                throw new IOException("Non-zero return code from dump command:\n"
                        + procRunner.getOutputBlob());
            }
        } catch (IOException e) {
            Notification.show(e.getMessage());
            Logger.getLogger(AndroidAdbCLI.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        procRunner = getAdbRunner(serial,
                "pull", "/sdcard/uidump.xml", xmlDumpFile.getAbsolutePath());
        try {
            retCode = procRunner.run(30000);
            if (retCode != 0) {
                throw new IOException("Non-zero return code from pull command:\n"
                        + procRunner.getOutputBlob());
            }
        } catch (IOException e) {
            Notification.show(e.getMessage());
            Logger.getLogger(AndroidAdbCLI.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        return xmlDumpFile;
    }
    
    public String[] getPackageNameAndActivityName() {
        procRunner = getAdbRunner(serial,
                "shell", "dumpsys", "activity", "activities");
        try {
            retCode = procRunner.run(30000);
            if (retCode != 0) {
                throw new IOException(
                        "Non-zero return code from devices command\n"
                        + procRunner.getOutputBlob());
            }
            String activity = null;
            for (int i = 1; i < procRunner.mOutput.size(); i++) {
                String val = procRunner.mOutput.get(i);
                if (!val.trim().isEmpty() && val.contains("mFocusedActivity")) {
                    activity = val.trim();
                    break;
                }
            }
            if (activity != null) {
                String[] details = new String[2];
                Matcher match = Pattern.compile("((\\w+(\\.)?)+)/(\\.)?((\\w+(\\.)?)+)").matcher(activity);
                if (match.find()) {
                    details[0] = match.group(1);
                    details[1] = match.group(5);
                }
                return details;
            }
            
        } catch (IOException e) {
            Notification.show(e.getMessage());
            Logger.getLogger(AndroidAdbCLI.class.getName()).log(Level.SEVERE, null, e);
        }
        return new String[]{};
    }

    /*
     * Convenience function to construct an 'adb' command, e.g. use 'adb' or 'adb -s NNN'
     */
    private ProcRunner getAdbRunner(String serial, String... command) {
        List<String> cmd = new ArrayList<String>();
        cmd.add("adb");
        if (serial != null) {
            cmd.add("-s");
            cmd.add(serial);
        }
        cmd.addAll(Arrays.asList(command));
        return new ProcRunner(cmd);
    }

    /**
     * Convenience class to run external process.
     *
     * Always redirects stderr into stdout, has timeout control
     *
     */
    private static class ProcRunner {
        
        ProcessBuilder mProcessBuilder;
        List<String> mOutput = new ArrayList<String>();
        
        public ProcRunner(List<String> command) {
            mProcessBuilder = new ProcessBuilder(command).redirectErrorStream(true);
        }
        
        public int run(long timeout) throws IOException {
            final Process p = mProcessBuilder.start();
            Thread t = new Thread() {
                @Override
                public void run() {
                    String line;
                    mOutput.clear();
                    try {
                        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                                p.getInputStream()))) {
                            line = br.readLine();
                            while (line != null) {
                                mOutput.add(line);
                                line = br.readLine();
                            }
                        }
                    } catch (IOException e) {
                        Logger.getLogger(AndroidAdbCLI.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
            };
            t.start();
            try {
                t.join(timeout);
            } catch (InterruptedException e) {
                Logger.getLogger(AndroidAdbCLI.class.getName()).log(Level.SEVERE, null, e);
            }
            if (t.isAlive()) {
                throw new IOException("external process not terminating.");
            }
            try {
                return p.waitFor();
            } catch (InterruptedException e) {
                Logger.getLogger(AndroidAdbCLI.class.getName()).log(Level.SEVERE, null, e);
                throw new IOException(e);
            }
        }
        
        public String getOutputBlob() {
            StringBuilder sb = new StringBuilder();
            for (String line : mOutput) {
                sb.append(line);
                sb.append(System.getProperty("line.separator"));
            }
            return sb.toString();
        }
    }
}
