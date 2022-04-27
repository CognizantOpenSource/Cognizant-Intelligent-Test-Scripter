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
package com.cognizant.cognizantits.ide.main.scheduler;

import com.cognizant.cognizantits.ide.util.logging.UILogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Necessary implementations for Scheduling
 *
 */
public abstract class SchedulerImpl implements Scheduler {

    private final Runtime sRuntime = Runtime.getRuntime();
    private static final org.slf4j.Logger LOG = UILogger.getLogger(SchedulerImpl.class.getName());

    /**
     *
     * @param cmd command to add new task
     * @return  <code>true</code> if added else <code>false</code>
     */
    @Override
    public boolean addTask(String cmd) {
        return exeCommand(cmd);
    }

    /**
     *
     * @param taskName task to check
     * @return <code>true</code> if exist else <code>false</code>
     */
    @Override
    public boolean isTask(String taskName) {

        return exeCommand(getQueryCmd(taskName));
    }

    /**
     *
     * @param taskName the task to delete
     * @return <code>true</code> if deleted else <code>false</code>
     */
    @Override
    public boolean deleteTask(String taskName) {
        return isTask(taskName) ? exeCommand(getDeleteCmd(taskName)) : false;
    }

    /**
     *
     * @param cmd command to change task
     * @return  <code>true</code> if modified else <code>false</code>
     */
    @Override
    public boolean changeTask(String cmd) {
        return exeCommand(cmd);
    }

    /**
     * scheduler command syntax
     *
     * @return
     */
    @Override
    public String getSyntax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exeCommand(String cmd) {
        try {
            LOG.info("Executing Task \n" + cmd);
            Process sProcess = sRuntime.exec(cmd);
            printOutput(sProcess);
            sProcess.waitFor();
            return sProcess.exitValue() == 0;
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(SchedulerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @param taskName the task name
     * @return the Query-command
     */
    abstract String getQueryCmd(String taskName);

    /**
     *
     * @param taskName the task name
     * @return the Delete-command
     */
    abstract String getDeleteCmd(String taskName);

    /**
     *
     * @return the scheduler location
     */
    static String getScheduler() {
        return "";
    }

    private void printOutput(Process proc) {

        try {
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
            StringBuilder builder = new StringBuilder();
            String inp = stdInput.readLine();
            while (inp != null) {
                builder.append(inp).append("\n");
                inp = stdInput.readLine();
            }
            if (builder.length() > 0) {
                LOG.info("ADD TASK RES:\n");
                LOG.info(builder.toString());
            }
            builder = new StringBuilder();
            inp = stdError.readLine();
            while (inp != null) {
                inp = stdError.readLine();
            }
            if (builder.length() > 0) {
                LOG.info("ADD TASK ERROR:\n");
                LOG.info(builder.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(SchedulerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
