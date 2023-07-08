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
package com.cognizant.cognizantits.engine.reporting.impl.html;

import com.cognizant.cognizantits.datalib.util.data.FileScanner;
import com.cognizant.cognizantits.engine.constants.FilePath;
import com.cognizant.cognizantits.engine.core.Control;
import com.cognizant.cognizantits.engine.core.RunContext;
import com.cognizant.cognizantits.engine.drivers.SeleniumDriver;
import com.cognizant.cognizantits.engine.reporting.TestCaseReport;
import com.cognizant.cognizantits.engine.reporting.impl.handlers.PrimaryHandler;
import com.cognizant.cognizantits.engine.reporting.impl.handlers.TestCaseHandler;
import com.cognizant.cognizantits.engine.reporting.util.DateTimeUtils;
import com.cognizant.cognizantits.engine.reporting.util.RDS;
import com.cognizant.cognizantits.engine.reporting.util.RDS.TestCase;
import com.cognizant.cognizantits.engine.reporting.util.ReportUtils;
import com.cognizant.cognizantits.engine.support.Status;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 *
 */
@SuppressWarnings({"unchecked"})
public class HtmlTestCaseHandler extends TestCaseHandler implements PrimaryHandler {

    JSONObject testCaseData = new JSONObject();
    JSONArray Steps = new JSONArray();
    JSONObject iteration;
    JSONObject reusable;
    String DATAF = "[<DATA>]";
    boolean isIteration = true;
    Stack<JSONObject> reusableStack = new Stack<>();

    private StringBuffer SourceDoc;
    public File ReportFile;

    String CurrentComponent = "";

    int ComponentCounter = 0;
    int iterCounter = 0;

    int FailedSteps = 0;
    int PassedSteps = 0;
    int DoneSteps = 0;

    public HtmlTestCaseHandler(TestCaseReport report) {
        super(report);

    }

    @Override
    public void setDriver(SeleniumDriver driver) {
        testCaseData.put(TestCase.B_VERSION, getDriver().getBrowserVersion());
        testCaseData.put(TestCase.PLATFORM, getDriver().getPlatformName());
        testCaseData.put(TestCase.BROWSER, getDriver().getCurrentBrowser());
    }

    @Override
    public void createReport(RunContext runContext, String runTime) {
        try {
            ReportFile = new File(getReportLoc(), runContext.getName() + ".html");
            ReportFile.createNewFile();
            SourceDoc = new StringBuffer(FileScanner.readFile(new File(FilePath.getTCReportTemplate())));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        testCaseData.put(TestCase.SCENARIO_NAME, runContext.Scenario);
        testCaseData.put(TestCase.TESTCASE_NAME, runContext.TestCase);
        testCaseData.put(TestCase.DESCRIPTION, runContext.Description);
        testCaseData.put(TestCase.START_TIME, runTime);
        testCaseData.put(TestCase.ITERATION_TYPE, runContext.Iteration);
    }

    @Override
    public void updateTestLog(String stepName, String stepDescription, Status state,
            String link, List<String> links) {

        String time = DateTimeUtils.DateTimeNow();
        JSONObject step;
        try {
            step = RDS.getNewStep(getStep().Description);

            JSONObject data = (JSONObject) step.get(RDS.Step.DATA);
            data.put(RDS.Step.Data.STEP_NO, getStepCount());
            data.put(RDS.Step.Data.STEP_NAME, stepName);
            data.put(RDS.Step.Data.ACTION, getStep().Action);
            data.put(RDS.Step.Data.DESCRIPTION, ReportUtils.resolveDesc(stepDescription));
            data.put(RDS.Step.Data.TIME_STAMP, time);
            data.put(RDS.Step.Data.STATUS, state.toString());
            if (link != null) {
                data.put(RDS.Step.Data.LINK, link);
            }
            putStatus(state, links, link, data);
            if (isIteration) {
                ((JSONArray) iteration.get(RDS.Step.DATA)).add(step);
            } else {
                ((JSONArray) reusable.get(RDS.Step.DATA)).add(step);
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    
    /**
     * creates new iteration object
     *
     * @param iterationNo
     */
    @Override
    public void startIteration(int iterationNo) {
        reusableStack.clear();
        ++iterCounter;
        String Iterationid = "Iteration_" + iterationNo;
        iteration = RDS.getNewIteration(Iterationid);
        isIteration = true;
    }

    /**
     * creates new reusable object
     *
     * @param component
     * @param desc
     */
    @Override
    public void startComponent(String component, String desc) {
        reusable = RDS.getNewReusable(component, desc);
        reusableStack.push(reusable);
        isIteration = false;
    }

    @Override
    public void endComponent(String string) {
        reusable.put(RDS.Step.END_TIME, DateTimeUtils.DateTimeNow());
        if (reusable.get(TestCase.STATUS).equals("")) {
            /*
            * status not is updated set it to FAIL 
             */
            reusable.put(TestCase.STATUS, "FAIL");
        }
        /*
        * remove the reusable from the stack then fall back to iteration 
        * if stack is empty else update the outer reusable status.
         */
        reusableStack.pop();
        if (reusableStack.empty()) {
            ((JSONArray) iteration.get(RDS.Step.DATA)).add(reusable);
            reusable = null;
            isIteration = true;
        } else {
            ((JSONArray) reusableStack.peek().get(RDS.Step.DATA)).add(reusable);
            reusableStack.peek().put(TestCase.STATUS, reusable.get(TestCase.STATUS));
            reusable = reusableStack.peek();
        }

    }

    @Override
    public void endIteration(int CurrentTestCaseIteration) {
        if (iteration.get(TestCase.STATUS).equals("")) {
            iteration.put(TestCase.STATUS, "FAIL");
        }
        Steps.add(iteration);
    }

    private void onSetpDone() {
        DoneSteps++;                
        if (reusable != null && reusable.get(TestCase.STATUS).equals("")) {
            reusable.put(TestCase.STATUS, "PASS");
        }
        if (iteration != null && iteration.get(TestCase.STATUS).equals("")) {
            iteration.put(TestCase.STATUS, "PASS");
        }
    }

    private void onSetpPassed() {
        PassedSteps++;
        if (reusable != null && reusable.get(TestCase.STATUS).equals("")) {
            reusable.put(TestCase.STATUS, "PASS");
        }
        if (iteration != null && iteration.get(TestCase.STATUS).equals("")) {
            iteration.put(TestCase.STATUS, "PASS");
        }
    }

    private void onSetpFailed() {
        FailedSteps++;
        if (iteration != null) {
            iteration.put(TestCase.STATUS, "FAIL");
        }
        if (reusable != null) {
            reusable.put(TestCase.STATUS, "FAIL");
        }
    }

    private void putStatus(Status state, List<String> optional, String optionalLink, JSONObject data) {
        switch (state) {
            case DONE:
            case PASSNS:
                onSetpDone();
                break;
            case PASS:
            case FAIL:
            case SCREENSHOT:
                takeScreenShot(state, optional, optionalLink, data);
                break;
            case DEBUG:
            case WARNING:
            case FAILNS:
                onSetpFailed();
                break;
            case COMPLETE:            
                break;

        }
    }

    private void takeScreenShot(Status status, List<String> optional, String optionalLink, JSONObject data) {
        String imgSrc = getScreenShotName();
        switch (status) {
            case PASS:
            case FAIL:
                if (!canTakeScreenShot(status)) {
                    break;
                }
                if (optionalLink != null) {
                    break;
                }
            case SCREENSHOT:
                takeSSAndPutDetail(data, optional, imgSrc);
                break;
            default:
                break;
        }
    }

    private Boolean canTakeScreenShot(Status status) {
        if (status.equals(Status.FAIL)) {
            onSetpFailed();
            return screenShotSettings().matches("(Fail|Both)");
        }
        if (status.equals(Status.PASS)) {
            onSetpPassed();
            return screenShotSettings().matches("(Pass|Both)");

        }
        return false;
    }

    private static String screenShotSettings() {
        return Control.exe.getExecSettings().getRunSettings().getScreenShotFor();
    }

    /**
     * takes new screen shot and updates the the json object for that step
     *
     * @param data
     * @param imgSrc
     */
    private void takeSSAndPutDetail(JSONObject data, List<String> optional, String imgSrc) {
        if (optional != null && optional.size() == 3) {
            data.put(RDS.Step.Data.EXPECTED, optional.get(0));
            data.put(RDS.Step.Data.ACTUAL, optional.get(1));
            data.put(RDS.Step.Data.COMPARISION, optional.get(2));
        } else {
            if (optional != null) {
                data.put(RDS.Step.Data.OBJECTS, optional.get(0));
            }
            if (ReportUtils.takeScreenshot(getDriver(), imgSrc)) {
                data.put(RDS.Step.Data.LINK, imgSrc);
            }
        }

    }

    /**
     * finalize the test case execution and create standalone test case report
     * file for upload purpose
     *
     * @return
     */
    @Override
    public Status finalizeReport() {
        updateResults();
        try (BufferedWriter bufwriter = new BufferedWriter(new FileWriter(ReportFile));) {
            JSONObject singleTestcasereport = (JSONObject) testCaseData.clone();
            ReportUtils.loadDefaultTheme(singleTestcasereport);
            String tempDoc = SourceDoc.toString().replace(DATAF, singleTestcasereport.toJSONString());
            bufwriter.write(tempDoc);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        printReport();
        return report.getCurrentStatus();
    }
    private static final Logger LOG = Logger.getLogger(TestCaseReport.class.getName());

    /**
     * update the test case execution details to the json DATA file
     *
     * @return
     */
    private void updateResults() {
        String endTime = DateTimeUtils.DateTimeNow();
        String exeTime = startTime().timeRun();
        testCaseData.put(TestCase.STEPS, Steps);
        testCaseData.put(TestCase.END_TIME, endTime);
        testCaseData.put(TestCase.EXE_TIME, exeTime);
        testCaseData.put(TestCase.ITERATIONS, iterCounter);
        testCaseData.put(TestCase.NO_OF_TESTS, getStepCount());
        testCaseData.put(TestCase.NO_OF_FAIL_TESTS, String.valueOf(this.FailedSteps));
        testCaseData.put(TestCase.NO_OF_PASS_TESTS, String.valueOf(this.DoneSteps + this.PassedSteps));
        testCaseData.put(TestCase.STATUS, getCurrentStatus().toString());

    }

    private DateTimeUtils startTime() {
        return report.startTime;
    }

    private void printReport() {
        System.out.println("\n---------------------------------------------------");
        print("Testcase Name", testCaseData.get(TestCase.SCENARIO_NAME)
                + ":" + testCaseData.get(TestCase.TESTCASE_NAME));
        print("Executed Steps", testCaseData.get(TestCase.NO_OF_TESTS));
        print("Passed Steps", testCaseData.get(TestCase.NO_OF_PASS_TESTS));
        print("Failed Steps", testCaseData.get(TestCase.NO_OF_FAIL_TESTS));
        print("Time Taken", testCaseData.get(TestCase.EXE_TIME));
        System.out.println("-----------------------------------------------------\n");
    }

    private void print(String key, Object val) {
        System.out.println(String.format("%-20s : %s", key, val));
    }

    @Override
    public Object getData() {
        return testCaseData;
    }

    @Override
    public File getFile() {
        return ReportFile;
    }

    @Override
    public Status getCurrentStatus() {
        if (FailedSteps > 0 || (PassedSteps + DoneSteps) == 0) {
            return Status.FAIL;
        } else {
            return Status.PASS;
        }
    }
}
