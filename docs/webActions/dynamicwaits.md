# Dynamic Waits
------------------------

## **changeWaitTime**

**Description**: This function is used to change the override the default `wait time`(Default is 10 seconds) with the provided value. The default wait time for all the wait actions defined after **changeWaitTime** action will be the same as defined in the **changeWaitTime** action.

**Input Format** : @Time in seconds as `Integer`. Example : 20,30 etc.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*changeWaitTime*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*changeWaitTime*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*changeWaitTime*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "changing wait time by [<Data>] seconds", input = InputType.YES)
    public void changeWaitTime() {
        try {
            int t = Integer.parseInt(Data);
            if (t > 0) {
                SystemDefaults.waitTime.set(t);
                Report.updateTestLog("changeWaitTime", "Wait time changed to "+ t + " second/s", Status.DONE);
            } else {
                Report.updateTestLog("changeWaitTime","Couldn't change Wait time (invalid input)",Status.DEBUG);                        
            }

        } catch (NumberFormatException ex) {
            Report.updateTestLog("changeWaitTime","Couldn't change Wait time ", Status.DEBUG);
            Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
```
-------------------------------------------------

## **setElementTimeOut**

**Description**: This function is used to override the default `timeout` for web element finding logic(Default is 10 seconds) with the provided value.

**Input Format** : @Time in seconds as `Integer`. Example : 20,30 etc.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*setElementTimeOut*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*setElementTimeOut*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*setElementTimeOut*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>


**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Change Default Element finding wait time by [<Data>] seconds", input = InputType.YES)
    public void setElementTimeOut() {
        if (Data != null && Data.matches("[0-9]+")) {
            SystemDefaults.elementWaitTime.set(Integer.valueOf(Data));
            Report.updateTestLog(Action, "Element Wait time changed to " + Data + " second/s", Status.DONE);
        } else {
            Report.updateTestLog(Action,"Couldn't change Element Wait time (invalid input) " + Data,Status.DEBUG);
        }
    }
```
-------------------------------------------------

## Difference between the changeWaitTime and setElementTimeOut actions

 * The **changeWaitTime** action is used to change the default wait time (10 seconds) for all the wait actions. Once the default wait time is changed using this action, all the **wait actions** used subsequently will have an explicit timeout for that set duration.


 * The **setElementTimeout** action is used to change the default time (10 seconds) taken to find an object in your application during execution. Once the default time is changed using this action, for each step following that action will try to find the object within the specified time duration before performing the respective action on that object. If the object cannot be found within the specified time frame, an exception will be thrown.


**Note**: The wait time(changeWaitTime) and the element wait time(setElementTimeOut) can also be set from the UI be navigating to **Configurations-> Options**.



-------------------------------------------------

## **waitForElementToBeVisible**

**Description**:  This function will `wait` till the element is **visible on the screen**. The default wait time for all elements is 10 seconds, which can be overriden using the  **changeWaitTime** action

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|
|------------|--------|--------------|-----------|---------|
| Object     |*waitForElementToBeVisible*   |      | PageName      | 

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Wait for [<Object>] to be visible ", condition = InputType.OPTIONAL)
    public void waitForElementToBeVisible() {
        waitForElement(WaitType.VISIBLE, "'"+ this.ObjectName+ "' Element becomes visible in stipulated time");
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
wait.until(ExpectedConditions.visibilityOf(Element))
```
-------------------------------------------------
## **waitForElementToBeInVisible**

**Description**: This function will `wait` till the element is no longer visible on the screen.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|
|------------|--------|--------------|-----------|---------|
| Object     |*waitForElementToBeInVisible*   |      |  PageName     | 

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Wait for [<Object>] to be invisible ", condition = InputType.OPTIONAL)
    public void waitForElementToBeInVisible() {
        waitForElement(WaitType.INVISIBLE, "'"+ this.ObjectName+ "' Element becomes invisible in stipulated time");
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(Element)))
```
-------------------------------------------------

## **waitForElementToBeClickable**

**Description**: This function will `wait` till the element becomes clickable.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|
|------------|--------|--------------|-----------|---------|
| Object     |*waitForElementToBeClickable*   |      |  PageName     | 

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Wait for [<Object>] to be clickable ", condition = InputType.OPTIONAL)
    public void waitForElementToBeClickable() {
        waitForElement(WaitType.CLICKABLE, "'"+ this.ObjectName+ "' Element becomes Clickable in stipulated time");
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
wait.until(ExpectedConditions.elementToBeClickable(Element))
```
-------------------------------------------------

## **waitForElementToBeSelected**

**Description**: This function will `wait` till the specified element is selected

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|
|------------|--------|--------------|-----------|---------|
| Object     |*waitForElementToBeSelected*   |      | PageName      | 

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Wait for [<Object>] to be selected ", condition = InputType.OPTIONAL)
    public void waitForElementToBeSelected() {
        waitForElement(WaitType.SELECTED, "'"+ this.ObjectName+ "' Element Selected in stipulated time");
    }
```
**Internally uses the following** `Selenium` **logic :**
```java
wait.until(ExpectedConditions.elementToBeSelected(Element))
```
-------------------------------------------------

## **waitForElementToContainText**

**Description**: This function will `wait` till the element contains the given text

**Input Format** : @ExpectedText

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*waitForElementToContainText*   | @value       |       |PageName |<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*waitForElementToContainText*   | Sheet:Column |       |PageName |<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*waitForElementToContainText*   | %dynamicVar% |       |PageName |<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Wait for element: [<Object>] to contain text [<Data>]", condition = InputType.OPTIONAL, input = InputType.YES)
    public void waitForElementToContainText() {
        waitForElement(WaitType.TEXT_CONTAINS, "'"+ this.ObjectName + "' Element contained the text: "+ Data + " in stipulated Time");
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
wait.until(ExpectedConditions.textToBePresentInElement(Element, Data))
```
-------------------------------------------------
## **waitForElementToContainValue**

**Description**:  This function will `wait` till the element contains the given value

**Input Format** : @ExpectedValue

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*waitForElementToContainValue*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*waitForElementToContainValue*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*waitForElementToContainValue*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Wait for [<Object>] element to contain value: [<Data>]", condition = InputType.OPTIONAL, input = InputType.YES)
    public void waitForElementToContainValue() {
        waitForElement(WaitType.VALUE_CONTAINS, "'"+ this.ObjectName + "' Element contained the value: "+ Data + " in stipulated Time");
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
wait.until(ExpectedConditions.textToBePresentInElementValue(Element, Data))
```
--------------------------------------------------------

## **waitForElementToBePresent**

**Description**: This function will `wait` till the element loads in the DOM.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|
|------------|--------|--------------|-----------|---------|
| Object     |*waitForElementToBePresent*   |      |  PageName     | 

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Wait  for the element [<Object>] to be present", condition = InputType.OPTIONAL)
    public void waitForElementToBePresent() {
        AObject.setWaitTime(getWaitTime());
        try {
            Element = AObject.findElement(ObjectName, Reference);
            AObject.resetWaitTime();
            if (Element != null) {
                Report.updateTestLog(Action, "'" + this.ObjectName+ "' Element Present in the stipulated time", Status.PASS);
            } else {
                throw new ElementException(ElementException.ExceptionType.Element_Not_Found, Condition);
            }

        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.OFF, null, ex);
            throw new ForcedException(Action,ex.getMessage());
        }
    }
```
-------------------------------------------------

## **waitForFrameAndSwitch**

**Description**:  This function will `wait` for the **frame to be available and switch to it.**

**Input**: @`id` or `name` or `index` [This is only applicable when the *ObjectName* is set as *Browser*]

The input is optional if you choose to give the web element (the frame itself) under the *ObjectName*.This element can be added as an object under the Object repository.

**Usage:**

**1**

| ObjectName | Action | Input        | Condition |Reference|
|------------|--------|--------------|-----------|---------|
|Browser    |*waitForFrameAndSwitch*   | frame `id` or `name` or `index`     |       | 


**2**

| ObjectName | Action | Input        | Condition |Reference|
|------------|--------|--------------|-----------|---------|
|`Frame` Object     |*waitForFrameAndSwitch*   |                             |  PageName     | 

**Corresponding Code:**

```java
@Action(object = ObjectType.ANY, desc = "Wait for Frame To Be Available and Switch to it",input=InputType.OPTIONAL,
            condition = InputType.OPTIONAL)
    public void waitForFrameAndSwitch() {
        if (Element != null) {
            waitFor(WaitType.FRAME_EL, "Switched to Frame By Object '"+ ObjectName + "' in stipulated Time");
        } else if (Data != null) {
            if (Data.matches("[0-9]+")) {
                waitFor(WaitType.FRAME_IND, "Switched to Frame By Index '"+ Data + "' in stipulated Time");
            } else {
                waitFor(WaitType.FRAME_STR, "Switched to Frame By Value '"+ Data + "' in stipulated Time");
            }
        }
    }
```

**Internally uses the following** `Selenium` **logic for Frame** `Element`:
```java
wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Element))
```

**Internally uses the following** `Selenium` **logic for Frame** `index`:
```java
wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Integer.valueOf(Data, 0)))
```

**Internally uses the following** `Selenium` **logic for Frame** `name`:
```java
wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Data))
```
--------------------------------------------------------------------------------
## **waitForPageLoaded**

**Description**: This function will wait till the page is loaded. **Note: This is not for Ajax calls**

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|
|------------|--------|--------------|-----------|---------|
|Browser    |*waitForPageLoaded*   |      |       | 

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Wait for Page to be loaded", condition = InputType.OPTIONAL)
    public void waitForPageLoaded() {
        waitFor(WaitType.CUSTOM_SCRIPT,"Page load completed in stipulated time",
                "return document.readyState==='complete'");
    }
```

**Internally uses the following** `javascript` **logic to check for the page readiness:**
```javascript
return document.readyState==='complete'
```
--------------------------------------------------------------------------------
## **waitForAlertPresent**

**Description**:  This function will `wait` for alert to appear on the page.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|
|------------|--------|--------------|-----------|---------|
|Browser    |*waitForAlertPresent*   |      |       | 

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Wait for alert to be present ", condition = InputType.OPTIONAL)
    public void waitForAlertPresent() {
        waitFor(WaitType.ALERT_PRESENT,"Alert popped up in stipulated time");
    }

```
**Internally uses the following** `Selenium` **logic :**
```java
wait.until(ExpectedConditions.alertIsPresent())
```
-------------------------------------------

## **waitForTitleToBe**

**Description**:  This function will `wait` till the title of the page matches with the given text.

**Input Format** : @ExpectedPageTitle

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*waitForTitleToBe*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*waitForTitleToBe*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*waitForTitleToBe*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Wait for page's title to be [<Data>]", input = InputType.YES, condition = InputType.OPTIONAL)
    public void waitForTitleToBe() {
        waitFor(WaitType.TITLE_IS,"Title Equals '"+ Data + "' in stipulated Time");
    }

```
**Internally uses the following** `Selenium` **logic :**
```java
wait.until(ExpectedConditions.titleIs(Data));
```
-------------------------------------------

## **waitForTitleToContain**

**Description**:  This function will `wait` till the title of the page has the given text.

**Input Format** : @Full or Partial text of the Title

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*waitForTitleToContain*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*waitForTitleToContain*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*waitForTitleToContain*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
    @Action(object = ObjectType.BROWSER, desc = "Wait for page's title to contain [<Data>]", condition = InputType.OPTIONAL, input = InputType.YES)
    public void waitForTitleToContain() {
        waitFor(WaitType.TITLE_CONTAINS,"Title Contains the value '"+ Data + "' in stipulated Time");
    }

```
**Internally uses the following** `Selenium` **logic :**
```java
wait.until(ExpectedConditions.titleContains(Data))
```
---------------------------------------------------------------
## **waitTillCustomScript**

**Description**:   This function will `wait` till the given JavaScript returns true. It is applicable only for JavaScript functions that return a boolean value.

**Input Format** : @`Javascript` to evaluate 

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*waitTillCustomScript*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*waitTillCustomScript*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*waitTillCustomScript*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
    @Action(object = ObjectType.BROWSER, desc = "Wait till the given javascript condition [<Data>] returns true", input = InputType.YES, condition = InputType.OPTIONAL)
    public void waitTillCustomScript() {
        if (Data != null && !Data.trim().isEmpty()) {
            if (Data.contains("return")) {
                waitFor(WaitType.CUSTOM_SCRIPT,"Condition passed in stipulated time",Data);
            } else {
                Report.updateTestLog(Action, "Javascript condition should have atleast one return and the condtion should return Boolean value", Status.DEBUG);
            }
        } else {
            Report.updateTestLog(Action, "Include a proper javascript condition to check", Status.DEBUG);
        }
    }

```

**Internally uses the following logic :**
```java
    private ExpectedCondition<?> getCustomCondition(final String javascript) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver).executeScript(javascript);
            }
        };
    }
```

---------------------------------------------------------------

## **waitForElementSelectionToBeTrue**

**Description**:  This function will wait till the element selection becomes true

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|
|------------|--------|--------------|-----------|---------|
| Object     |*waitForElementSelectionToBeTrue*   |      | PageName      | 

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Wait for [<Object>] element to be selected: [<Data>]", condition = InputType.OPTIONAL)
    public void waitForElementSelectionToBeTrue() {
        waitForElement(WaitType.EL_SELECT_TRUE, "'"+ this.ObjectName + "' Element got Selected in the stipulated time");
    }
```
**Internally uses the following** `Selenium` **logic :**
```java
wait.until(ExpectedConditions.elementSelectionStateToBe(Element, true))
```
-------------------------------------------------

## **waitForElementSelectionToBeFalse**

**Description**: This function will `wait` till the element selection becomes false.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|
|------------|--------|--------------|-----------|---------|
| Object     |*waitForElementSelectionToBeFalse*   |      | PageName      | 

**Corresponding Code:**

```java
 @Action(object = ObjectType.SELENIUM, desc = "Wait for [<Object>] element to be deselected", condition = InputType.OPTIONAL)
    public void waitForElementSelectionToBeFalse() {
        waitForElement(WaitType.EL_SELECT_FALSE, "'"+ this.ObjectName+ "' Element got Deselected in the stipulated time");
    }
```
**Internally uses the following** `Selenium` **logic :**
```java
wait.until(ExpectedConditions.elementSelectionStateToBe(Element, false))
```
-------------------------------------------------

