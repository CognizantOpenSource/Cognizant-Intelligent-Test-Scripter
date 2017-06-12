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
import com.cognizant.cognizantits.engine.execution.exception.element.ElementException;
import com.cognizant.cognizantits.engine.execution.exception.element.ElementException.ExceptionType;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods extends Command {

    // ##############################################################
    // Category : Navigation
    // ##############################################################
    public CommonMethods(CommandControl cc) {
        super(cc);
    }

    /**
     * **************************************
     * Function to refresh the page
     *
     * **************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Refresh current page ")
    public void refreshDriver() {
        try {
            Driver.navigate().refresh();
            Report.updateTestLog("refreshDriver", "Page is refreshed",
                    Status.DONE);
        } catch (WebDriverException e) {
            Report.updateTestLog("refreshDriver", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    /**
     * **************************************
     * Function to navigate previous page *************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Navigate to previous page")
    public void back() {
        try {
            Driver.navigate().back();
            Report.updateTestLog("back", "Navigate page back is success",
                    Status.DONE);
        } catch (WebDriverException e) {
            Report.updateTestLog("back", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * **************************************
     * Function to navigate Next page *************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "browser navigates to next page.")
    public void forward() {
        try {
            Driver.navigate().forward();
            Report.updateTestLog("forward", "Navigate page forward is success",
                    Status.DONE);
        } catch (WebDriverException e) {
            Report.updateTestLog("forward", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * **************************************
     * Function to close the page. *************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Close the current browser session")
    public void close() {
        try {
            Driver.close();
            Report.updateTestLog("close", "Selenium Webdriver is closed",
                    Status.DONE);
        } catch (WebDriverException e) {
            Report.updateTestLog("close", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Action(desc = "To Perform Right Click action on WebPage/Element")
    public void rightClick() {
        String desc = "Right click action performed on ";
        Actions action = new Actions(Driver);
        if (Element != null) {
            action.contextClick(Element).build().perform();
            desc += "Element - " + ObjectName;
        } else {
            action.contextClick().build().perform();
            desc += "Webpage";
        }
        Report.updateTestLog(Action, desc, Status.DONE);
    }

    /**
     *
     * **************************************
     * Function to double click on the object
     * **************************************
     */
    @Action(object = ObjectType.SELENIUM, desc = "Double click [<Object>] element")
    public void doubleClickElement() {
        try {
            if (Element != null) {
                new Actions(Driver).doubleClick(Element).build().perform();
                Report.updateTestLog("doubleClickElement", "'" + Element
                        + "' is doubleClicked", Status.DONE);
            } else {
                Report.updateTestLog(Action, "Object[" + ObjectName + "] not found", Status.FAIL);
            }
        } catch (Exception e) {
            Report.updateTestLog("doubleClickElement", e.getMessage(),
                    Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    /**
     * **************************************
     * Function to mouse over to specific object
     *
     * **************************************
     */
    @Action(object = ObjectType.SELENIUM, desc = "Hover over the [<Object>] element")
    public void mouseOverElement() {
        try {
            if (Element != null) {
                new Actions(Driver).moveToElement(Element).build().perform();
                Report.updateTestLog("mouseOverElement",
                        "Mouse Over to Element '" + ObjectName + "'.",
                        Status.DONE);
            } else {
                Report.updateTestLog(Action, "Object[" + ObjectName + "] not found", Status.FAIL);
            }
        } catch (Exception e) {
            Report.updateTestLog("mouseOverElement", e.getMessage(),
                    Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * **************************************
     * Function to drag and drop the action to the specific object
     * **************************************
     */
    @Action(object = ObjectType.SELENIUM, desc = "Drags the [<Object>]")
    public void dragElement() {
        try {
            if (Element != null) {
                getRunTimeElement().push(Element);
                Report.updateTestLog("dragElement", "'" + ObjectName
                        + "' dragged", Status.DONE);
            } else {
                Report.updateTestLog(Action, "Object[" + ObjectName + "] not found", Status.FAIL);
            }
        } catch (Exception e) {
            Report.updateTestLog("dragElement", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Action(object = ObjectType.SELENIUM, desc = "Drops the Dragged Object to [<Object>]")
    public void dropElement() {
        try {
            if (Element != null) {
                if (!getRunTimeElement().empty()) {
                    new Actions(Driver)
                            .dragAndDrop(getRunTimeElement().pop(), Element)
                            .build().perform();
                    Report.updateTestLog("dropElement", "Element  dropped to '"
                            + ObjectName + "' ", Status.DONE);
                } else {
                    throw new Exception("No Element selected to drop");
                }
            } else {
                Report.updateTestLog(Action, "Object[" + ObjectName + "] not found", Status.FAIL);
            }
        } catch (Exception e) {
            Report.updateTestLog("dropElement", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Action(object = ObjectType.SELENIUM, desc = "Drad and drop the element [<Object>] at location [<Data>]", input = InputType.YES)
    public void dragAndDropBy() {
        try {
            if (Element != null) {
                String[] coords = Data.split(",", 2);
                new Actions(Driver).dragAndDropBy(Element, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]))
                        .build().perform();
                Report.updateTestLog(Action, "Element [" + ObjectName + "] dropped at '"
                        + Data + "' ", Status.PASS);

            } else {
                Report.updateTestLog(Action, "Object[" + ObjectName + "] not found", Status.FAIL);
            }
        } catch (Exception e) {
            Report.updateTestLog(Action, e.getMessage(), Status.DEBUG);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Action(object = ObjectType.SELENIUM, desc = "drag and drop operation of ", input = InputType.YES)
    public void dragToAndDropElement() {
        try {
            String Page = Data.split(":", 2)[0];
            String Object = Data.split(":", 2)[1];
            if (Element != null) {
                WebElement DropElement = AObject.findElement(Object, Page);
                if (DropElement != null) {
                    new Actions(Driver).dragAndDrop(Element, DropElement)
                            .build().perform();
                    Report.updateTestLog("dragToAndDropElement", "'"
                            + ObjectName
                            + "' has been dragged and dropped to '" + Object
                            + "'", Status.PASS);
                } else {
                    throw new Exception("Drop Element not found");
                }
            } else {
                throw new Exception("Drag Element not found");
            }
        } catch (Exception e) {
            Report.updateTestLog("dragToAndDropElement", e.getMessage(),
                    Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * **************************************
     * Function to click and hold the Element
     *
     * **************************************
     */
    @Action(object = ObjectType.SELENIUM, desc = "Click and hold the [<Object>] element ")
    public void clickAndHoldElement() {
        try {
            if (Element != null) {
                new Actions(Driver).clickAndHold(Element).build().perform();
                Report.updateTestLog("clickAndHoldElement",
                        "clickAndHoldElement action is done", Status.DONE);
            } else {
                Report.updateTestLog(Action, "Object[" + ObjectName + "] not found", Status.FAIL);
            }
        } catch (Exception e) {
            Report.updateTestLog("clickAndHoldElement", e.getMessage(),
                    Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    /**
     * **************************************
     * Function to release the hold Element
     * **************************************
     */
    @Action(object = ObjectType.SELENIUM,
            desc = "Release the dragged element over the [<Object>] element ")
    public void releaseElement() {
        try {
            if (Element != null) {
                new Actions(Driver).release(Element).build().perform();
                Report.updateTestLog("releaseElement",
                        "releaseElement action is done", Status.DONE);
            } else {
                Report.updateTestLog(Action, "Object[" + ObjectName + "] not found", Status.FAIL);
            }
        } catch (Exception e) {
            Report.updateTestLog("releaseElement", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * **************************************
     * Function to add a name in the cookie
     *
     * *************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Add the cookie of name with value [<Data>].", input = InputType.YES)
    public void addCookie() {

        try {
            String strCookieName = Data.split(":", 2)[0];
            String strCookieValue = Data.split(":", 2)[1];
            Cookie oCookie = new Cookie.Builder(strCookieName, strCookieValue)
                    .build();
            Driver.manage().addCookie(oCookie);
            Report.updateTestLog("addCookie", "Cookie Name- '" + strCookieName
                    + "' with value '" + strCookieValue + "' is added",
                    Status.DONE);
        } catch (Exception e) {
            Report.updateTestLog("addCookie", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * **************************************
     * Function to delete the cookie by name
     *
     * *************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "delete the cookie having name [<Data>].", input = InputType.YES)
    public void deleteCookie() {
        try {
            String strCookieName = Data;
            Cookie oCookie = Driver.manage().getCookieNamed(strCookieName);
            if (oCookie != null) {
                Driver.manage().deleteCookie(oCookie);
                Report.updateTestLog("deleteCookie", "Cookie Name- '"
                        + strCookieName + "' is deleted", Status.DONE);
            } else {
                Report.updateTestLog("deleteCookie", "Cookie doesn't exist",
                        Status.FAIL);
            }
        } catch (Exception e) {
            Report.updateTestLog("deleteCookie", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * **************************************
     * Function to capture the screen-shot and save in the specific location
     * *************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Take screenshot of the current page and store it in the location [<Input>]", input = InputType.YES)
    public void saveScreenshot() {
        try {
            String strFullpath = Data;

            File scrFile = getDriverControl().createScreenShot();
            FileUtils.copyFile(scrFile, new File(strFullpath));
            Report.updateTestLog("saveScreenshot",
                    "Screenshot is taken and saved in this path -'"
                    + strFullpath + "'", Status.PASS);
        } catch (IOException e) {
            Report.updateTestLog("saveScreenshot", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Action(object = ObjectType.BROWSER, desc = "Take a Screen Shot ")
    public void takeScreenshot() {
        try {
            Report.updateTestLog(Action, "Screenshot is taken", Status.PASS);
        } catch (Exception e) {
            Report.updateTestLog("saveScreenshot", e.getMessage(), Status.DEBUG);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * **************************************
     * Function to print
     *
     * ***********************************
     */
    @Action(object = ObjectType.BROWSER, desc = "print the data [<Data>]", input = InputType.YES)
    public void print() {
        System.out.println(Data);
        Report.updateTestLog("print", String.format("printed %s", Data), Status.DONE);
    }

    /**
     * **************************************
     * Function to pause
     *
     * ***********************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Wait for [<Data>] milli seconds", input = InputType.YES)
    public void pause() {
        try {
            Thread.sleep(Long.parseLong(Data));
            Report.updateTestLog("pause",
                    "Thread sleep for '" + Long.parseLong(Data), Status.DONE);
        } catch (Exception e) {
            Report.updateTestLog("pause", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    /**
     * ******************************************
     * Function to handle alert popup
     *
     ****************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Answer the alert present with [<Data>]", input = InputType.YES)
    public void answerAlert() {
        String setAlertText = Data;
        try {
            Driver.switchTo().alert().sendKeys(setAlertText);
            Report.updateTestLog("answerAlert", "Message '" + setAlertText
                    + "' is set in the alert window", Status.DONE);
        } catch (Exception e) {
            Report.updateTestLog("answerAlert", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * ******************************************
     * Function to accept the alert popup
     *
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Accept the alert present")
    public void acceptAlert() {
        try {
            Driver.switchTo().alert().accept();
            Report.updateTestLog("acceptAlert", "Alert is accepted",
                    Status.DONE);
        } catch (Exception e) {
            Report.updateTestLog("acceptAlert", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * ******************************************
     * Function to dismiss the alert popup
     *
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Dismiss the alert present")
    public void dismissAlert() {
        try {
            Driver.switchTo().alert().dismiss();
            Report.updateTestLog("dismissAlert", "Alert is dismissed",
                    Status.DONE);
        } catch (Exception e) {
            Report.updateTestLog("dismissAlert", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * *****************************************
     * Function to getCellValue from the table
     *
     * ****************************************** @param Element
     * @param tr
     * @param td
     * @return
     */
    public HashMap<String, String> getCellValue(WebElement Element, int tr,
            int td) {
        int rowCounter = 0;
        int colCounter = 0;
        String rowKey = null;
        String colKey = null;
        HashMap<String, String> HashTable = new HashMap<>();

        String strObj = Data;
        List<WebElement> tableList = Element.findElements(By
                .cssSelector("div[class='" + strObj + "'] tr td"));
        for (WebElement listIterator : tableList) {
            String TagName = listIterator.getTagName();
            if (TagName.equals("tr")) {
                rowKey = "R" + rowCounter++;
            }
            if (TagName.equals("td")) {
                colKey = "C" + colCounter++;
            }
            HashTable.put(rowKey + colKey, listIterator.getText());
        }
        return HashTable;
    }

    /**
     * *****************************************
     * Function to store a given text in variable
     * ******************************************
     */
    /**
     * ******************************************
     * Function to store url in a variable
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Store the current page url into the Runtime variable: [<Data>]", input = InputType.YES)

    public void storeCurrentUrl() {
        String strObj = Input;

        if (strObj.startsWith("%") && strObj.endsWith("%")) {
            addVar(strObj, Driver.getCurrentUrl());
            Report.updateTestLog("storeCurrentUrl",
                    "Current URL '" + Driver.getCurrentUrl()
                    + "' is stored in variable '" + strObj + "'",
                    Status.PASS);
        } else {
            Report.updateTestLog("storeCurrentUrl",
                    "Variable format is not correct", Status.FAIL);
        }
    }

    /**
     * ******************************************
     * Function to store title in a variable
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "store the webpage title in variable named [<Data>].", input = InputType.YES)
    public void storeTitle() {
        String strObj = Input;

        if (strObj.startsWith("%") && strObj.endsWith("%")) {
            addVar(strObj, Driver.getTitle());
            Report.updateTestLog("storeTitle",
                    "Page title '" + Driver.getTitle() + "' is stored in '"
                    + strObj + "'", Status.PASS);
        } else {
            Report.updateTestLog("storeTitle",
                    "Variable format is not correct", Status.FAIL);
        }
    }

   

    /**
     * ******************************************
     * Function to store text in a variable
     * ******************************************
     */
    @Action(object = ObjectType.SELENIUM, desc = "Store the [<Object>] element's text into the Runtime variable: [<Data>]", input = InputType.YES)
    public void storeText() {
        if (Element != null) {
            String strObj = Input;
            if (strObj.startsWith("%") && strObj.endsWith("%")) {
                addVar(strObj, getElementText());
                Report.updateTestLog(Action, "Element text " + getElementText()
                        + " is stored in variable " + strObj, Status.PASS);
            } else {
                Report.updateTestLog(Action,
                        "Variable format is not correct", Status.FAIL);
            }
        } else {
            throw new ElementException(ExceptionType.Element_Not_Found, ObjectName);
        }
    }

    @Action(object = ObjectType.SELENIUM, desc = "Store the [<Object>] element's text into datasheet:columname [<Data>]", input = InputType.YES)

    public void storeTextinDataSheet() {
        if (Element != null) {
            String strObj = Input;
            if (strObj.matches(".*:.*")) {
                try {
                    System.out.println("Updating value in SubIteration " + userData.getSubIteration());
                    String sheetName = strObj.split(":", 2)[0];
                    String columnName = strObj.split(":", 2)[1];
                    String elText = getElementText();
                    userData.putData(sheetName, columnName, elText.trim());
                    Report.updateTestLog(Action, "Element text [" + elText
                            + "] is stored in variable " + strObj, Status.DONE);
                } catch (Exception ex) {
                    Logger.getLogger(this.getClass().getName()).log(Level.OFF, null, ex);
                    Report.updateTestLog(Action, "Error Storing text in datasheet" + ex.getMessage(), Status.DEBUG);
                }

            } else {
                Report.updateTestLog(Action,
                        "Given input [" + Input + "] format is invalid. It should be [sheetName:ColumnName]", Status.DEBUG);
            }
        } else {
            throw new ElementException(ExceptionType.Element_Not_Found, ObjectName);
        }
    }

    /**
     * ******************************************
     * Function to store text present in a variable
     * ******************************************
     */
    @Action(object = ObjectType.SELENIUM, desc = "Store in variable true or false based on presence of text in [<Object>] element -> [<Data>]", input = InputType.YES, condition = InputType.YES)
    public void storeTextPresent() {
        try {
            if (Element != null) {
                if (getElementText().contains(Data)) {
                    addVar(Condition, "true");
                } else {
                    addVar(Condition, "false");
                }
                Report.updateTestLog("storeTextPresent", "Variable Stored", Status.DONE);
            } else {
                throw new Exception("Element not found");
            }
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.OFF, null, ex);
            Report.updateTestLog("storeTextPresent", ex.getMessage(), Status.FAIL);
        }
    }

    private String getElementText() {
        if (Element.getTagName().equalsIgnoreCase("input")) {
            return Element.getAttribute("value");
        } else if (Element.getTagName().equalsIgnoreCase("select")) {
            return new Select(Element).getFirstSelectedOption().getText();
        } else {
            return Element.getText();
        }
    }

    /**
     * ******************************************
     * Function to store page source in a variable
     *
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Store the [<Object>] page source into the Runtime variable: -> [<Data>]", input = InputType.YES)

    public void storePageSource() {
        String strObj = Input;

        if (strObj.startsWith("%") && strObj.endsWith("%")) {
            addVar(strObj, Driver.getPageSource());
            Report.updateTestLog("storePageSource",
                    "Page source is stored in variable '" + strObj + "'",
                    Status.DONE);
        } else {
            Report.updateTestLog("storePageSource",
                    "Variable format is not correct", Status.FAIL);
        }
    }

    /**
     * ******************************************
     * Function to store Element selected n a variable
     * ******************************************
     */
    @Action(object = ObjectType.SELENIUM, desc = "Store [<Object>] element  selection state into Runtime variable: -> [<Data>]", input = InputType.YES)

    public void storeElementSelected() {
        if (Element != null) {
            String strObj = Input;

            if (strObj.startsWith("%") && strObj.endsWith("%")) {

                if (Element.isSelected()) {
                    addVar(strObj, "true");
                } else {
                    addVar(strObj, "false");
                }
                Report.updateTestLog("storeElementSelected",
                        "Element selected flag has been stored into variable '"
                        + strObj + "'", Status.DONE);
            } else {
                Report.updateTestLog("storeElementSelected",
                        "Variable format is not correct", Status.FAIL);
            }
        } else {
            Report.updateTestLog("storeElementSelected", "Element not found",
                    Status.FAIL);
        }
    }

    /**
     * ******************************************
     * Function to store Element attribute n a variable
     * ******************************************
     */
    @Action(object = ObjectType.SELENIUM, desc = "Store [<Object>] element's  attribute into Runtime variable ->  [<Data>]", input = InputType.YES, condition = InputType.YES)

    public void storeElementAttribute() {
        if (Element != null) {

            addVar(Condition, Element.getAttribute(Data));
            Report.updateTestLog("storeEIementAttribute",
                    "Element's attribute value is stored in variable", Status.PASS);
        } else {
            Report.updateTestLog("storeElementAttribute", "Element not found", Status.FAIL);
        }
    }

    /**
     * ******************************************
     * Function to store Element value n a variable
     * ******************************************
     */
    @Action(object = ObjectType.SELENIUM, desc = "Store [<Object>] element's  value  into Runtime variable: -> [<Data>]", input = InputType.YES)

    public void storeElementValue() {
        if (Element != null) {
            String strObj = Input;

            if (strObj.startsWith("%") && strObj.endsWith("%")) {

                addVar(strObj, Element.getAttribute("value"));
                Report.updateTestLog("storeElementValue", "Element's value "
                        + Element.getAttribute("value")
                        + " is stored in variable '" + strObj + "'",
                        Status.DONE);
            } else {
                Report.updateTestLog("storeElementValue",
                        "Variable format is not correct", Status.FAIL);
            }
        } else {
            Report.updateTestLog("storeElementValue", "Element not found",
                    Status.FAIL);
        }
    }

    /**
     * ******************************************
     * Function to store a cookie present status
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Store in Runtime variable Exist/Not Exist based on the  presence of cookie ->[<Data>]", input = InputType.YES, condition = InputType.YES)

    public void storeCookiePresent() {
        String variableName = Condition;
        String cookieName = Data;
        if (variableName.matches("%.*%")) {
            if (Driver.manage().getCookieNamed(cookieName) != null) {
                addVar(variableName, "Exist");
            } else {
                addVar(variableName, "Not Exist");
            }

            Report.updateTestLog(
                    "storeCookiePresent",
                    "Cookie presense flag is stored in variable " + variableName + "",
                    Status.DONE);
        } else {
            Report.updateTestLog("storeCookiePresent",
                    "Variable format is not correct", Status.DEBUG);
        }
    }

    /**
     * ******************************************
     * Function to store a cookie by name in a variable
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Store value of cookie into Runtime variable -> [<Data>]", input = InputType.YES, condition = InputType.YES)

    public void storeCookieByName() {
        String variableName = Condition;
        String cookieName = Data;
        if (variableName.matches("%.*%")) {
            addVar(variableName, Driver.manage().getCookieNamed(cookieName)
                    .getValue());
            Report.updateTestLog("storeCookieByName", "Cookie Stored",
                    Status.DONE);
        } else {
            Report.updateTestLog("storeCookieByName",
                    "Variable format is not correct", Status.DEBUG);
        }
    }

    /**
     * ******************************************
     * Function to store a alert text in a variable
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Store the text of alert present into -> [<Data>] Runtime variable", input = InputType.YES)

    public void storeAlertText() {
        String strObj = Input;

        if (strObj.startsWith("%") && strObj.endsWith("%")) {
            addVar(strObj, Driver.switchTo().alert().getText());
            Report.updateTestLog("storeAIertText", "Alert Text "
                    + Driver.switchTo().alert().getText()
                    + " is Stored in variable " + strObj + "", Status.DONE);
        } else {
            Report.updateTestLog("storeAIertText",
                    "Variable format is not correct", Status.FAIL);
        }
    }

    /**
     * ******************************************
     * Function to store a alert present in a variable
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Store \"Exist\" or \"Not Exist\" based on the alert presence into -> [<Data>] Runtime variable", input = InputType.YES)

    public void storeAlertPresent() {
        String strObj = Input;

        if (strObj.startsWith("%") && strObj.endsWith("%")) {
            if (isAlertPresent(Driver)) {
                addVar(strObj, "Exist");
            } else {
                addVar(strObj, "Not Exist");
            }
            Report.updateTestLog("storeAlertPresent",
                    "Alert Text Status Stored", Status.DONE);

        } else {
            Report.updateTestLog("storeAlertPresent",
                    "Variable format is not correct", Status.FAIL);
        }
    }

    @Action(object = ObjectType.BROWSER, desc = "store variable value [<Condition>] in data sheet[<Data>]", input = InputType.YES, condition = InputType.YES)
    public void storeVariableInDataSheet() {
        if (Input != null && Condition != null) {
            if (!getVar(Condition).isEmpty()) {
                System.out.println(Condition);
                String[] sheetDetail = Input.split(":");
                String sheetName = sheetDetail[0];
                String columnName = sheetDetail[1];
                userData.putData(sheetName, columnName, getVar(Condition));
                Report.updateTestLog("addVariableToDataSheet", "Value of variable " + Condition + " has been stored into " + "the data sheet", Status.DONE);
            } else {
                Report.updateTestLog("addVariableToDataSheet", "The variable " + Condition + " does not contain any value", Status.FAIL);
            }
        } else {
            Report.updateTestLog("addVariableToDataSheet", "Incorrect input format", Status.FAIL);
            System.out.println("Invalid Data " + Condition);
        }
    }

    @Action(object = ObjectType.BROWSER, desc = "store  value [<Data>] in Variable [<Condition>]", input = InputType.YES, condition = InputType.YES)
    public void storeVariable() {
        if (Condition.startsWith("%") && Condition.endsWith("%")) {
            addVar(Condition, Data);
            Report.updateTestLog("storeVariable", "Value" + Data
                    + "' is stored in Variable '" + Condition + "'",
                    Status.DONE);
        } else {
            Report.updateTestLog("storeVariable",
                    "Variable format is not correct", Status.FAIL);
        }
    }

    /**
     * ******************************************
     * Function to store a JS script executor in a variable
     * ******************************************
     */
    @Action(object = ObjectType.BROWSER, desc = "Store the result of Javascript expression value in a variable", input = InputType.YES, condition = InputType.YES)

    public void storeEval() {
        String javaScript = Data;
        String variableName = Condition;
        if (variableName.matches("%.*%")) {
            JavascriptExecutor js = (JavascriptExecutor) Driver;
            addVar(variableName, js.executeScript(javaScript).toString());
            Report.updateTestLog("storeEval", "Eval Stored", Status.DONE);
        } else {
            Report.updateTestLog("storeEval", "Variable format is not correct",
                    Status.FAIL);
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

    @Action(object = ObjectType.SELENIUM, desc = "Send Keys [<Data>]  to object [<Object>].", input = InputType.YES)
    public void sendKeysToElement() {
        try {
            if (Element != null) {
                String[] Values = Data.toLowerCase().split("\\+");
                if (Values.length == 4) {
                    Element.sendKeys(Keys
                            .chord(getKeyCode(Values[0]),
                                    getKeyCode(Values[1]),
                                    getKeyCode(Values[2]),
                                    getKeyCode(Values[3]) != null ? getKeyCode(Values[3])
                                    : Values[3]));
                    Report.updateTestLog("sendKeysToElement", "Keys Submitted",
                            Status.DONE);
                } else if (Values.length == 3) {
                    Element.sendKeys(Keys
                            .chord(getKeyCode(Values[0]),
                                    getKeyCode(Values[1]),
                                    getKeyCode(Values[2]) != null ? getKeyCode(Values[2])
                                    : Values[2]));
                    Report.updateTestLog("sendKeysToElement", "Keys Submitted",
                            Status.DONE);
                } else if (Values.length == 2) {
                    Element.sendKeys(Keys
                            .chord(getKeyCode(Values[0]),
                                    getKeyCode(Values[1]) != null ? getKeyCode(Values[1])
                                    : Values[1]));
                    Report.updateTestLog("sendKeysToElement", "Keys Submitted",
                            Status.DONE);
                } else if (Values.length == 1) {
                    Element.sendKeys(Keys.chord(getKeyCode(Values[0])));
                    Report.updateTestLog("sendKeysToElement", "Keys Submitted",
                            Status.DONE);
                }
            } else {
                throw new Exception("Element not found");
            }
        } catch (Exception e) {
            Report.updateTestLog("sendKeysToElement", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    @Action(object = ObjectType.BROWSER, desc = "Send Keys [<Data>]  to Window.", input = InputType.YES)
    public void sendKeysToWindow() {
        Actions builder = new Actions(Driver);
        try {
            String[] Values = Data.toLowerCase().split("\\+");
            switch (Values.length) {
                case 4:
                    builder.sendKeys(
                            Keys.chord(
                                    getKeyCode(Values[0]),
                                    getKeyCode(Values[1]),
                                    getKeyCode(Values[2]),
                                    getKeyCode(Values[3]) != null ? getKeyCode(Values[3])
                                    : Values[3])).perform();
                    Report.updateTestLog("sendKeysToWindow", "Keys Submitted", Status.DONE);
                    break;
                case 3:
                    builder.sendKeys(
                            Keys.chord(
                                    getKeyCode(Values[0]),
                                    getKeyCode(Values[1]),
                                    getKeyCode(Values[2]) != null ? getKeyCode(Values[2])
                                    : Values[2])).perform();
                    Report.updateTestLog("sendKeysToWindow", "Keys Submitted", Status.DONE);
                    break;
                case 2:
                    builder.sendKeys(
                            Keys.chord(
                                    getKeyCode(Values[0]),
                                    getKeyCode(Values[1]) != null ? getKeyCode(Values[1])
                                    : Values[1])).build().perform();
                    Report.updateTestLog("sendKeysToWindow", "Keys Submitted", Status.DONE);
                    break;
                case 1:
                    builder.sendKeys(Keys.chord(getKeyCode(Values[0]))).build()
                            .perform();
                    Report.updateTestLog("sendKeysToWindow", "Keys Submitted", Status.DONE);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            Report.updateTestLog("sendKeysToWindow", "Input format is not correct",
                    Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    Keys getKeyCode(String data) {
        switch (data) {
            case "tab":
                return Keys.TAB;
            case "enter":
                return Keys.ENTER;
            case "shift":
                return Keys.SHIFT;
            case "ctrl":
                return Keys.CONTROL;
            case "alt":
                return Keys.ALT;
            case "esc":
                return Keys.ESCAPE;
            case "delete":
                return Keys.DELETE;
            case "backspace":
                return Keys.BACK_SPACE;
            case "home":
                return Keys.HOME;
            default:
                try {
                    return Keys.valueOf(data.toUpperCase());
                } catch (Exception ex) {
                    return null;
                }
        }
    }

}
