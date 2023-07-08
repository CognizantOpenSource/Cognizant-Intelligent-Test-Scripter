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
import com.cognizant.cognizantits.engine.execution.exception.ForcedException;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;
import com.galenframework.specs.SpecText;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.JavascriptExecutor;

public class SwitchTo extends Command {

    public SwitchTo(CommandControl cc) {
        super(cc);
    }

    /**
     * **************************************
     * Function to switch between frames
     *
     * **************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Switch to frame by name: [<Data>]", input = InputType.YES)
    public void switchToFrame() {
        String strTargetFrame = Data;
        try {
            Driver.switchTo().frame(strTargetFrame);
            Report.updateTestLog(Action,
                    "Webdriver switched to new frame by name[" + strTargetFrame + "]",
                    Status.DONE);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.OFF, null, e);
            Report.updateTestLog(Action, e.getMessage(), Status.DEBUG);
        }
    }

    /**
     * ****************************************** Function to switch between
     * frames by index ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Switch to frame which has index: [<Data>]", input = InputType.YES)
    public void switchToFrameByIndex() {
        if (Data != null && Data.matches("[0-9]+")) {
            int frameIndex = Integer.parseInt(Data);
            try {
                Driver.switchTo().frame(frameIndex);
                Report.updateTestLog(Action,
                        "Webdriver switched to new frame by index[" + frameIndex + "]", Status.DONE);
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.OFF, null, e);
                Report.updateTestLog(Action, e.getMessage(),
                        Status.DEBUG);
            }
        } else {
            Report.updateTestLog(Action,
                    "Invalid Frame Index[" + Data + "]", Status.DEBUG);
        }
    }

    /**
     * ******************************************
     * Function to switch between windows By Name
     *
     * ******************************************
     */
    private void switchToWindow(String title, SpecText.Type type) {
        Boolean windowFlag = false;
        Set<String> Handles = Driver.getWindowHandles();
        for (String handle : Handles) {
            Driver.switchTo().window(handle);
            String drivertitle = Driver.getTitle().trim();
            switch (type) {
                case IS:
                    windowFlag = drivertitle.equals(title);
                    break;
                case CONTAINS:
                    windowFlag = drivertitle.contains(title);
                    break;
                case STARTS:
                    windowFlag = drivertitle.startsWith(title);
                    break;
                case ENDS:
                    windowFlag = drivertitle.endsWith(title);
                    break;
                case MATCHES:
                    windowFlag = drivertitle.matches(title);
                    break;
            }
            if (windowFlag) {
                break;
            }
        }

        if (windowFlag) {
            Report.updateTestLog(Action, "Webdriver switched to new window by title[" + title + "]", Status.DONE);
        } else {
            throw new ForcedException(Action, "Can't find a Window by the given Title [" + Data + "]");
        }
    }

    @Action(object = ObjectType.BROWSER, desc = "switching to window by title [<Data>] is done", input = InputType.YES)
    public void switchToWindowByTitle() {
        switchToWindow(Data, SpecText.Type.IS);
    }

    @Action(object = ObjectType.BROWSER, desc = "switching to window by title [<Data>]", input = InputType.YES)
    public void switchToWindowByTitleContains() {
        switchToWindow(Data, SpecText.Type.CONTAINS);
    }

    @Action(object = ObjectType.BROWSER, desc = "switching to window by title starts with [<Data>]", input = InputType.YES)
    public void switchToWindowByTitleStartsWith() {
        switchToWindow(Data, SpecText.Type.STARTS);
    }

    @Action(object = ObjectType.BROWSER, desc = "switching to window by title ends with [<Data>]", input = InputType.YES)
    public void switchToWindowByTitleEndsWith() {
        switchToWindow(Data, SpecText.Type.ENDS);
    }

    @Action(object = ObjectType.BROWSER, desc = "switching to window by title matches with [<Data>]", input = InputType.YES)

    public void switchToWindowByTitleMatches() {
        switchToWindow(Data, SpecText.Type.MATCHES);
    }

    /**
     * ******************************************
     * Function to switch between windows By Index
     * ****************************************** *
     */
    @Action(object
            = ObjectType.BROWSER, desc = "Switch to Window by Index: [<Data>]", input
            = InputType.YES)

    public void switchToWindowByIndex() {
        int wndIndex
                = Integer.parseInt(Data);
        Set<String> handles = Driver.getWindowHandles();
        if (handles.size() > wndIndex) {
            String handle
                    = handles.toArray()[wndIndex].toString();
            Driver.switchTo().window(handle);
            Report.updateTestLog("switchToWindowByIndex", "Webdriver switched to new window            ", Status.DONE);
        } else {
            throw new ForcedException(Action,
                    "There are only[" + handles.size() + "]"
                    + " windows present at the moment.Requested window is[" + wndIndex + "] which is out of range  ");
        }
    }

    /**
     * ******************************************
     * Function to switch to default content
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc ="Switching control to the default window")

    public void switchToDefaultContent() {
        try {
            Driver.switchTo().defaultContent();
            Report.updateTestLog(Action,
                    "Webdriver switched to default content", Status.DONE);
        } catch (Exception e) {
            Report.updateTestLog(Action, e.getMessage(),
                    Status.DEBUG);
            Logger.getLogger(this.getClass().getName()).log(Level.OFF, null, e);
        }
    }

    @Action(object = ObjectType.BROWSER, desc ="Open a new Browser window", input =InputType.OPTIONAL)
    public void createAndSwitchToWindow() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Driver;
            js.executeScript("window.open(arguments[0])", Data);
            Set<String> Handles = Driver.getWindowHandles();
            Driver.switchTo().window((String) Handles.toArray()[Handles.size() - 1]);
            Report.updateTestLog(Action, "New Window Created and Switched to that ", Status.DONE);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.OFF, null, ex);
            Report.updateTestLog(Action, "Error in Switching Window -" + ex.getMessage(), Status.DEBUG);
        }
    }

    @Action(object = ObjectType.BROWSER, desc ="Close the current window and switch to default window")
    public void closeAndSwitchToWindow() {
        try {
            Driver.close();
            Driver.switchTo().window((String) Driver.getWindowHandles().toArray()[0]);
            Report.updateTestLog(Action, "Current Window Closed and Switched to Default window ", Status.DONE);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.OFF, null, ex);
            Report.updateTestLog(Action, "Error in Switching Window -" + ex.getMessage(), Status.FAIL);
        }
    }

}
