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
package com.cognizant.cognizantits.engine.commands.mobile.nativ;

import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.Dimension;

/**
 *
 * 
 */
public class Gesture extends MobileNativeCommand {

    public Gesture(CommandControl cc) {
        super(cc);
    }

    /**
     * swipe right(from left)
     */
    @Action(object = ObjectType.BROWSER, desc ="Swipe right [<Data>]", input =InputType.OPTIONAL)
    
    public void swipeRight() {
        try {
            if (Element != null) {
                ((MobileElement) Element).swipe(SwipeElementDirection.RIGHT, getInt(Data, 1000));
                Report.updateTestLog(Action, "Sucessfully swiped towards right", Status.DONE);
            } else {
                Dimension size = ((MobileDriver) Driver).manage().window().getSize();
                int startX, endX;
                if (Data != null && Data.contains(",")) {
                    startX = (int) (size.width * (getInt(Data, 0, 10) / 100d));
                    endX = (int) (size.width * (getInt(Data, 1, 80) / 100d));
                } else {
                    startX = (int) (size.width * 0.10);
                    endX = (int) (size.width * 0.80);
                }
                int Y = size.height / 2;
                ((MobileDriver) Driver).swipe(startX, Y, endX, Y, getInt(Data, 1000));
                Report.updateTestLog(Action, "Sucessfully swiped towards right", Status.DONE);
            }
        } catch (Exception ex) {
            Report.updateTestLog(Action, ex.getMessage(), Status.FAIL);
            Logger.getLogger(Gesture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * swipe left (from right)
     */
    @Action(object = ObjectType.BROWSER, desc ="Swipe left [<Data>]", input =InputType.OPTIONAL)
    
    public void swipeLeft() {
        try {
            if (Element != null) {
                ((MobileElement) Element).swipe(SwipeElementDirection.LEFT, getInt(Data, 1000));
                Report.updateTestLog(Action, "Sucessfully swiped towards left", Status.DONE);
            } else {
                Dimension size = ((MobileDriver) Driver).manage().window().getSize();
                int startX, endX;
                if (Data != null && Data.contains(",")) {
                    startX = (int) (size.width * (getInt(Data, 0, 80) / 100d));
                    endX = (int) (size.width * (getInt(Data, 1, 10) / 100d));
                } else {
                    startX = (int) (size.width * 0.80);
                    endX = (int) (size.width * 0.10);
                }
                int Y = size.height / 2;
                ((MobileDriver) Driver).swipe(startX, Y, endX, Y, getInt(Data, 1000));
                Report.updateTestLog(Action, "Sucessfully swiped towards left", Status.DONE);
            }
        } catch (Exception ex) {
            Report.updateTestLog(Action, ex.getMessage(), Status.FAIL);
            Logger.getLogger(Gesture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * swipe Down (from up)
     */
    @Action(object = ObjectType.BROWSER, desc ="Swipe down [<Data>]", input =InputType.OPTIONAL)
    
    public void swipeDown() {
        try {
            if (Element != null) {
                ((MobileElement) Element).swipe(SwipeElementDirection.DOWN, getInt(Data, 1000));
                Report.updateTestLog(Action, "Sucessfully swiped towards down", Status.DONE);
            } else {
                Dimension size = ((MobileDriver) Driver).manage().window().getSize();
                int startY, endY;
                if (Data != null && Data.contains(",")) {
                    startY = (int) (size.width * (getInt(Data, 0, 10) / 100d));
                    endY = (int) (size.width * (getInt(Data, 1, 80) / 100d));
                } else {
                    startY = (int) (size.width * 0.10);
                    endY = (int) (size.width * 0.80);
                }
                int X = size.width / 2;
                ((MobileDriver) Driver).swipe(X, startY, X, endY, getInt(Data, 1000));
                Report.updateTestLog(Action, "Sucessfully swiped towards down", Status.DONE);
            }
        } catch (Exception ex) {
            Report.updateTestLog(Action, ex.getMessage(), Status.FAIL);
            Logger.getLogger(Gesture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * swipe Up (from Down)
     */
    @Action(object = ObjectType.BROWSER, desc ="Swipe up [<Data>]", input =InputType.OPTIONAL)
    
    public void swipeUp() {
        try {
            if (Element != null) {
                ((MobileElement) Element).swipe(SwipeElementDirection.UP, getInt(Data, 1000));
                Report.updateTestLog(Action, "Sucessfully swiped towards down", Status.DONE);
            } else {
                Dimension size = ((MobileDriver) Driver).manage().window().getSize();
                int startY, endY;
                if (Data != null && Data.contains(",")) {
                    startY = (int) (size.width * (getInt(Data, 0, 80) / 100d));
                    endY = (int) (size.width * (getInt(Data, 1, 10) / 100d));
                } else {
                    startY = (int) (size.width * 0.80);
                    endY = (int) (size.width * 0.10);
                }
                int X = size.width / 2;
                ((MobileDriver) Driver).swipe(X, startY, X, endY, getInt(Data, 1000));
                Report.updateTestLog(Action, "Sucessfully swiped towards down", Status.DONE);
            }
        } catch (Exception ex) {
            Report.updateTestLog(Action, ex.getMessage(), Status.FAIL);
            Logger.getLogger(Gesture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
