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
package com.cognizant.cognizantits.ide.util.compiler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;

/**
 *
 *
 */
public class MacCompiler extends Compiler {

    public MacCompiler(String src, String lib, String jpath) {
        super(src, lib, jpath);
    }

    @Override
    public File createScript() {

        String script = getScriptFile();

        try (BufferedWriter out = new BufferedWriter(new FileWriter(script))) {
            out.newLine();
            out.write("cd \"" + System.getProperty("user.dir") + "\"");
            out.newLine();
            out.write(setPathScript());
            out.newLine();
            out.write(getCompileScript());
            out.newLine();
            out.newLine();
        } catch (Exception ex) {
            Logger.getLogger(MacCompiler.class.getName()).log(Level.SEVERE, null, ex);

        }
        return new File(script);
    }

    @Override
    String getSep() {
        return ":";
    }

    @Override
    public String getScriptFile() {
        return System.getProperty("user.dir") + File.separator + "CompileRunScript.sh";
    }

    @Override
    public String compile() {
        try {

            final ProcessBuilder pb = new ProcessBuilder("/bin/sh", getScriptFile());
            pb.directory(new File(System.getProperty("user.dir")));
            final Process p = pb.start();
            p.waitFor();
            String sb = IOUtils.toString(p.getErrorStream(), "UTF-8");
            if (!"".equals(sb)) {
                return sb;
            }
            return "Completed.";
        } catch (Exception ex) {
            Logger.getLogger(MacCompiler.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }

    }

    @Override
    public String setPathScript() {
        return "PATH=\"" + javaPath + "\":$PATH;";
    }
}
