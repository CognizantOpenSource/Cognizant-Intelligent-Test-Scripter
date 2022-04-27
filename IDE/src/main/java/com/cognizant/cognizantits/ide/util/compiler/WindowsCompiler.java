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

import com.cognizant.cognizantits.engine.support.DesktopApi;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class WindowsCompiler extends Compiler {

    public WindowsCompiler(String src, String lib, String jpath) {
        super(src, lib, jpath);
    }

    @Override
    public File createScript() {

        String script = getScriptFile();

        try (BufferedWriter out = new BufferedWriter(new FileWriter(script))) {
            out.write("@echo off");
            out.newLine();
            out.write("pushd %~dp0");
            out.newLine();
            out.write("PATH " + javaPath);
            out.newLine();
            out.write(getCompileScript());
            out.newLine();
            out.write("set /p key=Completed. Hit ENTER to Exit");
            out.newLine();
        } catch (Exception ex) {
            Logger.getLogger(WindowsCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new File(script);
    }

    @Override
    public String getScriptFile() {
        return System.getProperty("user.dir") + File.separatorChar + "CompileRunScript.bat";
    }

    @Override
    String getSep() {
        return ";";
    }

    @Override
    public String compile() {
        if (DesktopApi.open(new File(getScriptFile()))) {
            return "true";
        }
        return "false";
    }

}
