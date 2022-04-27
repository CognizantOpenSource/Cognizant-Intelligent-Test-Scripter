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

import java.io.File;

/**
 *
 * Windows scheduler Implementations
 *
 */
public class WinScheduler extends SchedulerImpl {

  private static  final String DELETE = "SCHTASKS /F /DELETE /TN \"<TASKNAME>\"",
            QUERY = "SCHTASKS  /QUERY /TN \"<TASKNAME>\"",
            CHANGE = "SCHTASKS /CHANGE <VALUES> /TN \"<TASKNAME>\"",
            TRIGGER = "/SC ONCE /SD  <DATE> /ST <TIME>",
            ACTION = "/TN \"<TASKNAME>\" /TR \"\\\"" + getScheduler() + "\\\" <ARGUMENT> \" ",
            CREATE = "SCHTASKS  /CREATE  /F /IT ",
            SCHEDULER = "Run.bat";

    /**
     *
     * @param taskName the task name
     * @return the QUERY-command
     */
    @Override
    String getQueryCmd(String taskName) {
        return QUERY.replace("<TASKNAME>", taskName);
    }

    /**
     *
     * @param taskName the task name
     * @return the Delete-command
     */
    @Override
    String getDeleteCmd(String taskName) {
        return DELETE.replace("<TASKNAME>", taskName);
    }

    /**
     * Creates a new task with the given parameters
     *
     * @param taskName name of the new task
     * @param arg
     * @param date run date
     * @param time run time
     * @return <code>true</code> if created else <code>false</code>
     */
    @Override
    public boolean createTask(String taskName, String arg, String date, String time) {
        String createCMD = CREATE
                + ACTION.replace("<TASKNAME>", taskName).replace("<ARGUMENT>", arg)
                + TRIGGER.replace("<DATE>", date).replace("<TIME>", time);
        return addTask(createCMD);
    }

    /**
     *
     * @return the scheduler location
     */
   static String getScheduler() {
        return System.getProperty("user.dir") + File.separator + SCHEDULER;
    }

}
