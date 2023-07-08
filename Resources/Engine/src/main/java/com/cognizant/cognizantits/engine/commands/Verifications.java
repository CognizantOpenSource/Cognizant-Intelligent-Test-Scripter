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
package com.cognizant.cognizantits.engine.commands;

import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class Verifications extends Command {

    public Verifications(CommandControl cc) {
        super(cc);
    }

    /**
     * ******************************************
     * Function to verify the title
     *
     * ******************************************
     */
    
    @Action(object = ObjectType.BROWSER, desc = "Verify if the title is [<Input>]", input = InputType.YES)
    public void verifyTitle() {
        String strObj = Data;
        if (Driver.getTitle().equals(strObj)) {
            System.out.println(Action + " Passed");
            Report.updateTestLog(Action,
                    "Element Title value " + Driver.getTitle()
                    + " is matched with the expected result",
                    Status.PASS);
        } else {
            System.out.println(Action + " failed");
            Report.updateTestLog(Action,
                    "Element Title value " + Driver.getTitle()
                    + " doesn't match with the expected result",
                    Status.FAIL);

        }
    }

    /**
     * ******************************************
     * Function to verify the text present
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Assert if text: [<Data>] is present on the page", input = InputType.YES)

    public void verifyTextPresentInPage() {
        String strObj = Data;
        if (Driver.findElement(By.tagName("html")).getText().contains(strObj)) {
            Report.updateTestLog(Action, "Expected text "
                    + Data + " is present in the page", Status.PASS);
        } else {
            Report.updateTestLog(Action, "Expected text "
                    + Data + " is not present in the page", Status.FAIL);

        }
    }

    /**
     * ******************************************
     * Function to verify cookies present
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Verify if cookie: [<Data>] is present", input = InputType.YES)

    public void verifyCookiePresent() {
        try {

            String strCookieName = Data;
            if ((Driver.manage().getCookieNamed(strCookieName) != null)) {
                System.out.println(Action + " Passed");
                Report.updateTestLog(Action,
                        "Cookie with name [" + Data + "] is available",
                        Status.PASS);
            } else {
                System.out.println(Action + " Failed");
                Report.updateTestLog(Action,
                        "Cookie with name [" + Data + "] is not available",
                        Status.FAIL);
            }
        } catch (Exception e) {
            Report.updateTestLog(Action, e.getMessage(),
                    Status.FAIL);
            Logger.getLogger(Verifications.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * ******************************************
     * Function to verify cookies by name
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Verify if cookie by name: [<Data>] is present ", input = InputType.YES)

    public void verifyCookieByName() {
        try {

            String strCookieName = Data.split(":", 2)[0];
            String strCookieValue = Data.split(":", 2)[1];
            Cookie cookie = Driver.manage().getCookieNamed(strCookieName);
            if (cookie != null) {
                if ((strCookieValue.equals(cookie.getValue()))) {
                    System.out.println(Action + " Passed");
                    Report.updateTestLog(Action,
                            "Cookie value  is matched with the expected result",
                            Status.PASS);
                } else {
                    Report.updateTestLog(Action, "Cookie value doesn't match with the expected result",
                            Status.FAIL);
                }
            } else {
                System.out.println(Action + " Failed");
                Report.updateTestLog(Action,
                        "Cookie with name [" + Data + "] is not available",
                        Status.FAIL);
            }
        } catch (Exception e) {
            Report.updateTestLog(Action, e.getMessage(),
                    Status.FAIL);
            Logger.getLogger(Verifications.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * ******************************************
     * Function to verify AlertText
     *
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Verify the specified [<Data>] text is present in the alert pop up box [<Object>]", input = InputType.YES)

    public void verifyAlertText() {
        try {

            String strExpAlertText = Data;
            if ((Driver.switchTo().alert().getText().equals(strExpAlertText))) {
                System.out.println(Action + " Passed");
                Report.updateTestLog(Action,
                        "Alert text is matched with the expected result",
                        Status.PASSNS);
            } else {
                Report.updateTestLog(Action,
                        "Alert text doesn't match with the expected result",
                        Status.FAILNS);
            }
        } catch (Exception e) {
            Report.updateTestLog(Action, e.getMessage(), Status.FAILNS);
            Logger.getLogger(Verifications.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * ******************************************
     * Function to verify AlertTextPresent
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Verify if the specific alert[<Object>] is present ")

    public void verifyAlertPresent() {
        try {
            if ((isAlertPresent(Driver))) {
                System.out.println(Action + " Passed");
                Report.updateTestLog(Action,
                        "Alert is present",
                        Status.PASSNS);
            } else {
                Report.updateTestLog(Action,
                        "Alert is not present",
                        Status.FAILNS);
            }
        } catch (Exception e) {
            Report.updateTestLog(Action, e.getMessage(),
                    Status.FAILNS);
            Logger.getLogger(Verifications.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * ******************************************
     * Function to verify variable
     *
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Verify if the specific [<Data>] is present", input = InputType.YES)

    public void verifyVariable() {
        String strObj = Data;
        String[] strTemp = strObj.split("=", 2);
        System.out.println(strTemp[0]);
        System.out.println(strTemp[1]);
        String strAns = strTemp[0];//getVar(strTemp[0]);
        System.out.println("********"+strAns);
        System.out.println("********"+strTemp[0]);
        if (strAns.equals(strTemp[1])) {
        	
            System.out.println("Variable " + strTemp[0] + " equals "
                    + strTemp[1]);
            Report.updateTestLog(Action,
                    "Variable is matched with the expected result", Status.PASS);
        } else {
            System.out.println("Variable " + strTemp[0] + " not equals "
                    + strTemp[1]);
            Report.updateTestLog(Action,
                    "Variable doesn't match with the expected result",
                    Status.FAIL);
        }
    }

    @Action(object = ObjectType.BROWSER, desc = "Verify of variable [<Data>] from given datasheet", input = InputType.YES, condition = InputType.YES)
    public void verifyVariableFromDataSheet() {
        String strAns = getVar(Condition);
        if (strAns.equals(Data)) {
            System.out.println("Variable " + Condition + " equals "
                    + Input);
            Report.updateTestLog(Action,
                    "Variable is matched with the expected result", Status.DONE);

        } else {
            System.out.println("Variable " + Condition + " is not equal "
                    + Input);
            Report.updateTestLog(Action,
                    "Variable doesn't matched with the expected result",
                    Status.DEBUG);
        }
    }

    private boolean isAlertPresent(WebDriver Driver) {
        try {
            Driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.OFF, null, e);
            return false;
        }
    }   
    

}
