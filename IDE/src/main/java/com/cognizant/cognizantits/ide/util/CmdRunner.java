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

import com.cognizant.cognizantits.engine.support.DesktopApi;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public abstract class CmdRunner implements CmdSettings {

    private String cmdLoc;

    @Override
    public void runCMD() {
        DesktopApi.open(new File(getCMDFile()));
    }

    @Override
    public void writeCMD(String command) {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(getCMDFile()))) {
            wr.write(getCurrentDir());
            wr.newLine();
            wr.write(command);
        } catch (IOException ex) {
            Logger.getLogger(CmdRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * returns the batch script file
     *
     * @return batch-file
     */
    String getCMDFile() {
        return cmdLoc;
    }

    public void setCMDFile(String loc) {
        cmdLoc = loc;
    }

    public static class WinSettings extends CmdRunner {

        @Override
        public String getCMDFile() {
            return super.getCMDFile() + ".bat";
        }

        @Override
        public String getCurrentDir() {
            return "pushd %~dp0";
        }
    }

    public static class MacSettings extends CmdRunner {

        @Override
        public String getCMDFile() {
            return super.getCMDFile() + ".command";
        }

        @Override
        public String getCurrentDir() {
            return "DIRNAME=\"$( cd \"$( dirname \"${BASH_SOURCE[0]}\" )\" && pwd )\""
                    + System.lineSeparator()
                    + "cd \"$DIRNAME\"";
        }
    }
}

interface CmdSettings {

    /**
     * instructions to execute the command line code
     */
    public void runCMD();

    /**
     * writes the batch file
     *
     * @param command
     */
    public void writeCMD(String command);

    public String getCurrentDir();
}
