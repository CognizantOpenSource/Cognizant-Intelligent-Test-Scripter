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
package com.cognizant.cognizantits.ide.main.dashboard.server;

import java.io.File;

/**
 *
 * 
 */
public class DashBoardData {

    public static final File REPORT = new File("web");
    public static final File DASH_BOARD = new File(REPORT, "dashboard");
    public static final File HAR_COMPARE = new File(DASH_BOARD, "harCompare");

    private static String projectLocation;

    public static void setProjLocation(String projectLocation) {
        DashBoardData.projectLocation = projectLocation;
    }

    public static String project() {
        return projectLocation;
    }

    public static File report() {
        return REPORT;
    }

    public static File dashBoard() {
        return DASH_BOARD;
    }

    public static File harCompare() {
        return HAR_COMPARE;
    }

    public static File results() {
        return new File(project(), "Results");
    }

    public static File perf() {
        return new File(results(), "perf");
    }

    public static File hars() {
        return new File(perf(), "har");
    }

    public static File refHars() {
        return new File(perf(), "refhar");
    }

    public static File config() {
        return new File(perf(), "config.json");
    }
}
