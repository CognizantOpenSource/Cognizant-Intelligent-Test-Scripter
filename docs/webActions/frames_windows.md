# Frames and Browser Windows
------------------------

## **waitForFrameAndSwitch**

**Description**:  This function will `wait` for the **frame to be available and switch to it.**

**Details** : [See here](https://theforge.ing.net/product/239813/documentation/latest/pages/webActions/dynamicwaits.html#waitforframeandswitch)

------------------------

## **switchToFrameByIndex**

**Description**:  This function is used for **switching control to a frame** by the frame `index`.

**Input Format** :  @Frame `index`. Typically, in an HTML, frame indices start with 0.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*switchToFrameByIndex*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*switchToFrameByIndex*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*switchToFrameByIndex*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Internally uses the following** `Selenium` **logic for Frame** `Element`:
```java
Driver.switchTo().frame(frameIndex)
```

----------------------

## **switchToFrame**

**Description**:  This function is used for **switching control to a frame** by the frame `name` or `id`.

**Input Format** : @Frame `name` or `id`

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*switchToFrame*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*switchToFrame*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*switchToFrame*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>

**Internally uses the following** `Selenium` **logic for Frame** `Element`:
```java
Driver.switchTo().frame(strTargetFrame); //strTargetFrame is the `name` or `id`
```

--------------------------

## **switchToWindowByIndex**

**Description**:  This function is used for switching control to a window by given index.

**Input Format** : @WindowIndex

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*switchToWindowByIndex*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*switchToWindowByIndex*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*switchToWindowByIndex*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>

**Internally uses the following** `Selenium` **logic for Frame** `Element`:
```java
int wndIndex = Integer.parseInt(Data);
Set<String> handles = Driver.getWindowHandles();
if (handles.size() > wndIndex) {
    String handle = handles.toArray()[wndIndex].toString();
    Driver.switchTo().window(handle);
}
```
----------------------------------

## **switchToWindowByTitle**

**Description**:   This function is used for switching control to a Browser Window/Tab by  given title.

**Input Format** : @WindowTitle

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*switchToWindowByTitle*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*switchToWindowByTitle*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*switchToWindowByTitle*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>

**Internally uses the following** `Selenium` **logic**:

Loops through all open Windows and switches to the one where :
```java
Driver.getTitle().trim().equals(Data);
```

----------------------

## **switchToWindowByTitleStartsWith**

**Description**: This function is used for switching control to another window whose title **begins with the provided data.**

**Input Format** : @Starting part of the title

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*switchToWindowByTitleStartsWith*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*switchToWindowByTitleStartsWith*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*switchToWindowByTitleStartsWith*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>

**Internally uses the following** `Selenium` **logic**:

Loops through all open Windows and switches to the one where :
```java
Driver.getTitle().trim().startsWith(Data);
```

---------------------------

## **switchToWindowByTitleContains**

**Description**: This function is used for switching control to another window whose title **contains** the provided data.

**Input Format** : @Partial Text in the Title

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*switchToWindowByTitleContains*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*switchToWindowByTitleContains*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*switchToWindowByTitleContains*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>

**Internally uses the following** `Selenium` **logic**:

Loops through all open Windows and switches to the one where :
```java
Driver.getTitle().trim().contains(Data);
```

---------------------------

## **switchToWindowByTitleEndsWith**

**Description**: This function is used for switching control to another window whose title **ends with the provided data**

**Input Format** : @Ending part of the title

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*switchToWindowByTitleEndsWith*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*switchToWindowByTitleEndsWith*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*switchToWindowByTitleEndsWith*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>

**Internally uses the following** `Selenium` **logic**:

Loops through all open Windows and switches to the one where :
```java
Driver.getTitle().trim().endsWith(Data);
```

---------------------------

## **switchToWindowByTitleMatches**

**Description**: This function is used for switching control to another window whose title **matches with the provided data (can use regex also).** 

**Input Format** : @Expected text

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*switchToWindowByTitleEndsWith*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*switchToWindowByTitleEndsWith*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*switchToWindowByTitleEndsWith*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>

**Internally uses the following** `Selenium` **logic**:

Loops through all open Windows and switches to the one where :
```java
Driver.getTitle().trim().matches(Data);
```
----------------------------------------

## **switchToDefaultContent**

**Description**:  This function is used for switching control to the default window.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Browser     |*switchToDefaultContent*   |       |       | |

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc ="Switching control to the default window")
public void switchToDefaultContent() {
        try {
            Driver.switchTo().defaultContent();
            Report.updateTestLog(Action,"Webdriver switched to default content", Status.DONE);
        } catch (Exception e) {
            Report.updateTestLog(Action, e.getMessage(),Status.DEBUG);
            Logger.getLogger(this.getClass().getName()).log(Level.OFF, null, e);
        }
    }
```    

---------------------------

## **createAndSwitchToWindow**

**Description**:  This function is used to create a new window and then for switching control to the newly created window.

**Input Format** :  @`Url` to open after creating a new window. If this input column is empty then empty url will be loaded

**Usage:**

**1**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Browser     |*createAndSwitchToWindow*   |       |       | |

**2**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*createAndSwitchToWindow*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*createAndSwitchToWindow*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*createAndSwitchToWindow*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
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
```
---------------------------


## **closeAndSwitchToWindow**

**Description**:  This function will close the current window and switch back to the default window.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Browser     |*closeAndSwitchToWindow*   |       |       | |

**Corresponding Code:**

```java
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
```    
