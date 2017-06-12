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

import java.io.File;

/**
 *
 * 
 */
public class Compiler implements CompilerF {

    public String sourceFile;
    public String libLocation = "./lib";
    public String javaPath;

    /**
     * Compiler object for the platform
     *
     * @param src the source file address
     * @param lib the library location
     * @param jpath JDK bin path
     */
    public Compiler(String src, String lib, String jpath) {
        this.javaPath = jpath;
        this.libLocation = lib;
        this.sourceFile = src;
    }

    /**
     * return the compiler object based on the platform
     *
     * @param src the source file address
     * @param lib the library location
     * @param jpath JDK bin path
     * @return compiler object
     */
    public static CompilerF get(String src, String lib, String jpath) {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows")) {
            return new WindowsCompiler(src, lib, jpath);
        } else if (os.contains("mac")) {
            return new MacCompiler(src, lib, jpath);
        }
        return null;

    }

    /**
     * create a script file to compile the java file
     *
     * @return compile script
     */
    @Override
    public File createScript() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * compile the java file
     *
     * @return the status of the process
     */
    @Override
    public String compile() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * the java path string
     *
     * @return the path string
     */
    public String setPathScript() {
        return "PATH=\"" + javaPath + "\";";
    }

    /**
     * compile the class-path string
     *
     * @return the class-path string
     */
    String getclassPaths() {
        File libLoc = new File(libLocation);
        String cPath = "";
        if (libLoc.isDirectory() && libLoc.exists()) {
            File[] files = libLoc.listFiles();
            cPath += "-cp \"";
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getAbsolutePath().contains(".jar")) {
                        cPath += file.getAbsolutePath() + getSep();
                    }
                }
            }
            cPath += "\" ";
        }
        return cPath;
    }

    /**
     *
     * @return java compile command string
     */
    String getCompileScript() {
        return "javac  " + getclassPaths() + " \"" + sourceFile + "\"";
    }

    /**
     *
     * @return seprator char
     */
    String getSep() {
        return ":";
    }

    @Override
    public String getScriptFile() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
