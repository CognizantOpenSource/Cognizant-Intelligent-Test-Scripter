/*
* Copyright 2014 - 2021 Cognizant Technology Solutions
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
package com.cognizant.cognizantits.engine.reporting.impl.rp;

import java.io.File;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;

import com.cognizant.cognizantits.engine.core.Control;
import com.cognizant.cognizantits.engine.core.RunContext;
import com.cognizant.cognizantits.engine.core.RunManager;
import com.cognizant.cognizantits.engine.reporting.SummaryReport;
import com.cognizant.cognizantits.engine.reporting.TestCaseReport;
import com.cognizant.cognizantits.engine.reporting.impl.handlers.PrimaryHandler;
import com.cognizant.cognizantits.engine.reporting.impl.handlers.SummaryHandler;
import com.cognizant.cognizantits.engine.reporting.reportportal.ReportPortalClient;
import com.cognizant.cognizantits.engine.support.Status;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RPSummaryHandler extends SummaryHandler implements PrimaryHandler {

    private static final Logger LOGGER = Logger.getLogger(RPSummaryHandler.class.getName());
    
    int FailedTestCases = 0;
    int PassedTestCases = 0;

    String testcasename = "";
    

    public RPSummaryHandler(SummaryReport report) {
        super(report);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public synchronized void createReport(String runTime, int size) {
        if (!RunManager.getGlobalSettings().isTestRun()) {
            try {
                startLaunch(RunManager.getGlobalSettings().getTestSet());
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }

    public boolean isRPEnabled() {
        if (!RunManager.getGlobalSettings().isTestRun()) {
            return Control.getCurrentProject().getProjectSettings()
                    .getExecSettings(RunManager.getGlobalSettings().getRelease(), RunManager.getGlobalSettings().getTestSet()).getRunSettings().isRPUpdate();
        }
        return false;
    }

    private String getRPValue(String property) {
        return Control.getCurrentProject().getProjectSettings().getRPSettings().getProperty(property);
    }

    private void startLaunch(String testset) {
        if (isRPEnabled()) {
            try {
                startLaunch(getRPValue("rp.endpoint"), getRPValue("rp.uuid"), RunManager.getGlobalSettings().getTestSet(), getRPValue("rp.project"));
            } catch (IOException | ParseException e) {
                // TODO Auto-generated catch block
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    @Override
    public Object getData() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public File getFile() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Status getCurrentStatus() {
        if (FailedTestCases > 0 || PassedTestCases == 0) {
            return Status.FAIL;
        } else {
            return Status.PASS;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public synchronized void updateTestCaseResults(RunContext runContext, TestCaseReport report, Status state,
            String executionTime) {
        String status;
        if (state.equals(Status.PASS)) {
            status = "Passed";
            PassedTestCases++;
        } else {
            FailedTestCases++;
            status = "Failed";
        }

        try {
            //testcasename = runContext.Scenario + "_" + runContext.TestCase + "_" + runContext.Iteration + "_" + runContext.BrowserName;
            testcasename = runContext.Scenario + ":" + runContext.TestCase; 
            if (isRPEnabled()) {
            finishItem(getRPValue("rp.endpoint"), getRPValue("rp.uuid"),
                    RunManager.getGlobalSettings().getTestSet(), getRPValue("rp.project"), testcasename, status);
             }
        } catch (IOException | ParseException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    public synchronized void finalizeReport() {
        if (!RunManager.getGlobalSettings().isTestRun()) {
            // System.out.println("TestSet Completed");            
            if (isRPEnabled()) {
                try {
                    if(getCurrentStatus().toString().equalsIgnoreCase("FAIL"))
                        finishLaunch("FAILED");
                    else 
                        finishLaunch("PASSED");
                } catch (IOException | ParseException ex) {
                     LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }

    }
    
    public void finishLaunch(String status)
            throws ClientProtocolException, IOException, ParseException {
        ReportPortalClient.finishLaunch(getRPValue("rp.endpoint"), getRPValue("rp.uuid"), RunManager.getGlobalSettings().getTestSet(),
                            getRPValue("rp.project"), status);
    }

    public void startLaunch(String rp_endpoint, String rp_uuid, String rp_launch, String rp_project)
            throws ClientProtocolException, IOException, ParseException {
        ReportPortalClient.startLaunch(rp_endpoint, rp_project, rp_uuid, rp_launch);
    }

    public void finishLaunch(String rp_endpoint, String rp_uuid, String rp_launch, String rp_project, String status)
            throws ClientProtocolException, IOException, ParseException {
        ReportPortalClient.finishLaunch(rp_endpoint, rp_uuid, rp_launch, rp_project, status);
    }

    public void finishItem(String rp_endpoint, String rp_uuid, String rp_launch, String rp_project, String testitemID,
            String status) throws IOException, ParseException {
        ReportPortalClient.finishItem(rp_endpoint, rp_uuid, rp_launch, rp_project, testitemID, status);
    }

}
