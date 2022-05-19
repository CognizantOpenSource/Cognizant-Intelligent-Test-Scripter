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

/**
 * Necessary functions to implement Scheduling
 *
 */
public interface Scheduler {

    /**
     * scheduler command syntax
     *
     * @return
     */
    public abstract String getSyntax();

    /**
     *
     * @param cmd command to add new task
     * @return  <code>true</code> if added else <code>false</code>
     */
    public boolean addTask(String cmd);

    /**
     *
     * @param taskName task to check
     * @return <code>true</code> if exist else <code>false</code>
     */
    public boolean isTask(String taskName);

    /**
     *
     * @param taskName the task to delete
     * @return <code>true</code> if deleted else <code>false</code>
     */
    public boolean deleteTask(String taskName);

    /**
     *
     * @param cmd command to change task
     * @return  <code>true</code> if modified else <code>false</code>
     */
    public boolean changeTask(String cmd);

    /**
     * Executes the command
     *
     * @param cmd command to execute
     * @return <code>true</code> if executed else <code>false</code>
     */
    public boolean exeCommand(String cmd);

    /**
     * Creates a new task with the given parameters
     *
     * @param taskName name of the new task
     * @param arg
     * @param date run date
     * @param time run time
     * @return <code>true</code> if created else <code>false</code>
     */
    public boolean createTask(String taskName, String arg, String date, String time);
}
