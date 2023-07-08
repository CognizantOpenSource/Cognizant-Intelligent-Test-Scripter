# Web Element Actions
------------------------

## **Set**

**Description**: This function is used to **enter data** in an `input` type object.

**Input Format** : @Expected Text

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*Set*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*Set*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*Set*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Enter the value [<Data>] in the Field [<Object>]", input = InputType.YES)
    public void Set() {
        if (elementEnabled()) {
            Element.clear();
            Element.sendKeys(Data);
            Report.updateTestLog(Action, "Entered Text '" + Data + "' on '" + ObjectName + "'", Status.DONE);
        } else {
            throw new ElementException(ExceptionType.Element_Not_Enabled, ObjectName);
        }
    }
```

----------------------

## **SetIfExists**

**Description**: This function will check if an element **exists**. If the element exists, data will be `set` for that element else that step will be ignored.

**Input Format** : @Expected Text

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*SetIfExists*| @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*SetIfExists*| Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*SetIfExists*| %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Enter the value [<Data>] in the [<Object>] if it exists", input = InputType.YES)
    public void SetIfExists() {
        if (Element != null) {
            Set();
        } else {
            Report.updateTestLog(Action, "Element [" + ObjectName + "] not Exists", Status.DONE);
        }
    }
```    
---------------------------------------------

## **setAndCheck**

**Description**: This function is used to **enter data** in object and check if the **element's value matches with the entered value.**

**Input Format** : @Expected Text

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*SetAndCheck*| @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*SetAndCheck*| Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*SetAndCheck*| %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Enter the value [<Data>] in the Field [<Object>] and check [<Data>] matches with [<Object>] value", input = InputType.YES)
    public void SetAndCheck() {
        if (elementEnabled()) {
            Element.clear();
            Element.sendKeys(Data);
            if (Element.getAttribute("value").equals(Data)) {
                Report.updateTestLog("Set", "Entered Text '" + Data + "' on '"
                        + ObjectName + "'", Status.DONE);
            } else {
                Report.updateTestLog("Set", "Unable Enter Text '" + Data
                        + "' on '" + ObjectName + "'", Status.FAIL);
            }
        } else {
            throw new ElementException(ExceptionType.Element_Not_Enabled, ObjectName);
        }
    }
```    
---------------------------------------------

## **setEncrypted**

**Description**: This function is used to **enter encrypted data** to an object

**Input Format** : @Encrypted text

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*setEncrypted*| @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*setEncrypted*| Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>

**Note**: If the data is passed from a data sheet, the data in the datasheet should be `encrypted`. To manually encrypt a data, select the data cell, **right click and select Encrypt**

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Enter the Decrypted value [<Data>] in the Field [<Object>]", input = InputType.YES)
    public void setEncrypted() {
        if (Data != null && Data.matches(".* Enc")) {
            if (elementEnabled()) {
                try {
                    Element.clear();
                    Data = Data.substring(0, Data.lastIndexOf(" Enc"));
                    byte[] valueDecoded = Encryption.getInstance().decrypt(Data).getBytes();
                    Element.sendKeys(new String(valueDecoded));
                    Report.updateTestLog(Action, "Entered Encrypted Text " + Data + " on " + ObjectName, Status.DONE);
                } catch (Exception ex) {
                    Report.updateTestLog("setEncrypted", ex.getMessage(), Status.FAIL);
                    Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                throw new ElementException(ExceptionType.Element_Not_Enabled, ObjectName);
            }
        } else {
            Report.updateTestLog(Action, "Data not encrypted '" + Data + "'", Status.DEBUG);
        }
    }
```    
---------------------------------------------

## **setInputByLabel**

**Description**: This function is used to **enter data** in an `input` type object which is adjacent to the provided `label` type element.

**Input Format** : @Expected Text

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| `label` object     |*setInputByLabel*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| `label` object       |*setInputByLabel*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| `label` object       |*setInputByLabel*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
 @Action(object = ObjectType.SELENIUM, 
    		desc ="Set the data [<Data>] to an input element that is adjacent to the provided label element [<Object>]", 
    		input =InputType.YES)
    public void setInputByLabel() {
        cc.Element = findInputElementByLabelTextByXpath();
        new Basic(cc).Set();
    }
```

-----------------------------------------------

## **setByJS**

**Description**:  This function is used to **enter data** in an `input` type object using `JavaScript`. This is useful when selenium functions do not work.

**Input Format** : @Expected data

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*setByJS*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*setByJS*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*setByJS*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
 @Action(object = ObjectType.SELENIUM, desc = "Set [<Data>] on [<Object>]", input = InputType.YES)
    public void setByJS() {
        if (elementPresent()) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) Driver;
                js.executeScript("arguments[0].value='" + Data + "'", Element);
                Report.updateTestLog(Action, "Entered Text '" + Data + "' on '" + ObjectName + "'", Status.DONE);
            } catch (Exception ex) {
                Logger.getLogger(JSCommands.class.getName()).log(Level.SEVERE, null, ex);
                Report.updateTestLog(Action, "Couldn't set value on " + ObjectName + " - Exception " + ex.getMessage(),
                        Status.FAIL);
            }
        } else {
            throw new ElementException(ElementException.ExceptionType.Element_Not_Found, ObjectName);
        }
    }

```

-------------------------------------------------------------------

## **setEncryptedByJS**

**Description**:  This function is used to **enter encrypted data** to an object using `JavaScript`. This is useful when selenium functions do not work.

**Input Format** : @Expected encrypted data

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*setEncryptedByJS*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*setEncryptedByJS*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>

**Corresponding Code:**

```java
 @Action(object = ObjectType.SELENIUM, desc = "Set encrypted data on [<Object>]", input=InputType.YES)
    public void setEncryptedByJS() {
        if (Data != null && Data.matches(".* Enc")) {
            if (elementEnabled()) {
                try {
                    Data = Data.substring(0, Data.lastIndexOf(" Enc"));
                    byte[] valueDecoded = Encryption.getInstance().decrypt(Data).getBytes();
                    JavascriptExecutor js = (JavascriptExecutor) Driver;
                    js.executeScript("arguments[0].value='" + new String(valueDecoded) + "'", Element);
                    Report.updateTestLog(Action, "Entered Text '" + Data + "' on '" + ObjectName + "'", Status.DONE);
                } catch (Exception ex) {
                    Report.updateTestLog(Action, ex.getMessage(), Status.FAIL);
                    Logger.getLogger(JSCommands.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                throw new ElementException(ElementException.ExceptionType.Element_Not_Enabled, ObjectName);
            }
        } else {
            Report.updateTestLog(Action, "Data not encrypted '" + Data + "'", Status.DEBUG);
        }
    }

```
-------------------------------------------------

## **Click**

**Description**: This function is used to perform `click` operation on a Web Element.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Object     |*Click*   |       |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Click the [<Object>] ")
    public void Click() {
        if (elementEnabled()) {
            Element.click();
            Report.updateTestLog(Action, "Clicking on " + ObjectName, Status.DONE);
        } else {
            throw new ElementException(ExceptionType.Element_Not_Enabled, ObjectName);
        }
    }
```    

---------------------------

## **clickIfExists**

**Description**:  This function is used to perform `click` operation on a Web Element if the element exists in the DOM. If it does not exist, the step will be ignored.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Object     |*clickIfExists*   |       |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Click the [<Object>] if it exists")
    public void ClickIfExists() {
        if (Element != null) {
            Click();
        } else {
            Report.updateTestLog(Action, "Element [" + ObjectName + "] not Exists", Status.DONE);
        }
    }
```    

---------------------------

## **ClickIfVisible**

**Description**:  This function is used to perform `click` operation on a Web Element if the element is visible on the page. If it is not visible, the step will be ignored.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Object     |*ClickIfVisible*   |       |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Click the [<Object>] if it is displayed")
    public void ClickIfVisible() {
        if (Element != null) {
            if (Element.isDisplayed()) {
                Click();
            } else {
                Report.updateTestLog(Action, "Element [" + ObjectName + "] not Visible", Status.DONE);
            }
        } else {
            Report.updateTestLog(Action, "Element [" + ObjectName + "] not Exists", Status.DONE);
        }
    }
```   
----------------------------------------

## **clickInputByLabel**

**Description**: This function will `click` an `input` type element that is adjacent to the provided `label` type element.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| `label` object     |*clickInputByLabel*   |       |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, 
    		desc ="Click on an element whose label is provided in the [<Object>]"
    		)
    public void clickInputByLabel() {
        cc.Element = findInputElementByLabelTextByXpath();
        new Basic(cc).Click();
    }
```    

----------------------------------------

## **clickInputByText**

**Description**: This function will `click` an input element that is adjacent to the provided text 

**Input Format** : @Label of the element

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser    |*clickInputByText*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser    |*clickInputByText*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser    |*clickInputByText*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, 
    		desc ="click on the element whose label is provided in the [<Input>]", 
    		input =InputType.YES)
    public void clickInputByText() {
        cc.Element = findInputElementByLabelTextByXpath(Data);
        new Basic(cc).Click();
    }
```    
----------------------------------------------------------------

## **clickAndWait**

**Description**: This function is used to `click` and **wait for the page to be loaded.**

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Object     |*clickAndWait*   |       |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Click the [<Object>] and Wait for Page to be loaded", condition = InputType.OPTIONAL)
    public void clickAndWait() {
        if (Element != null) {
            Element.click();
            waitForPageLoaded();
            Report.updateTestLog(Action, "Click and wait for page load is done",
                    Status.DONE);
        } else {
            throw new ElementException(ElementException.ExceptionType.Element_Not_Found, Condition);
        }
    }
```    

------------------------------------------------------------------

## **clickByJS**

**Description**:  This function will use `JavaScript` to `click` an object. This is useful when selenium functions do not work.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Object     |*clickByJS*   |       |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Click on [<Object>]")
    public void clickByJS() {
        if (elementPresent()) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) Driver;
                js.executeScript("arguments[0].click();", Element);
                Report.updateTestLog(Action, "Clicked on " + ObjectName, Status.DONE);
            } catch (Exception ex) {
                Logger.getLogger(JSCommands.class.getName()).log(Level.SEVERE, null, ex);
                Report.updateTestLog(Action, "Couldn't click on " + ObjectName + " - Exception " + ex.getMessage(),
                        Status.FAIL);
            }
        } else {
            throw new ElementException(ElementException.ExceptionType.Element_Not_Found, ObjectName);
        }
    }
```    
--------------------------------------------------------------

## **clickAndHoldElement**

**Description**:  This function is used to `click and hold` an object. 

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Object     |*clickAndHoldElement*   |       |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Click and hold the [<Object>] element ")
    public void clickAndHoldElement() {
        if (elementEnabled()) {
            new Actions(Driver).clickAndHold(Element).build().perform();
            Report.updateTestLog(Action, "Click and hold done", Status.DONE);
        } else {
            throw new ElementException(ElementException.ExceptionType.Element_Not_Enabled, ObjectName);
        }
    }
```    
------------------------------------

## **releaseElement**

**Description**:  This function is used to release the element held by **clickAndHoldElement**

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Object     |*releaseElement*   |       |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM,
            desc = "Release the dragged element over the [<Object>] element ")
    public void releaseElement() {
        if (elementEnabled()) {
            new Actions(Driver).release(Element).build().perform();
            Report.updateTestLog(Action, "releaseElement action is done", Status.DONE);
        } else {
            throw new ElementException(ElementException.ExceptionType.Element_Not_Enabled, ObjectName);
        }
    }
```    

------------------------------------

## **rightClick**

**Description**: This function is used to perform `right click` operation on an object or in the browser.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Object     |*rightClick*   |       |       | PageName|


**Corresponding Code:**

```java
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
```    
-----------------------------------

## **doubleClickElement**

**Description**: This function will perform `double-click` on an object.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Object     |*doubleClickElement*   |       |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Double click [<Object>] element")
    public void doubleClickElement() {
        if (elementEnabled()) {
            new Actions(Driver).doubleClick(Element).build().perform();
            Report.updateTestLog("doubleClickElement", "'" + Element
                    + "' is doubleClicked", Status.DONE);
        } else {
            throw new ElementException(ExceptionType.Element_Not_Enabled, ObjectName);
        }
    }
```  

------------------------

## **submit**

**Description**:  This function will perform `submit` action on an element.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Object     |*submit*   |       |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Submit action on the browser")
    public void Submit() {
        if (elementEnabled()) {
            Element.submit();
            Report.updateTestLog(Action, "[" + ObjectName + "] Submitted successfully ", Status.DONE);

        } else {
            throw new ElementException(ExceptionType.Element_Not_Enabled, ObjectName);
        }
    }
```    
------------------------------------------------    

## **SubmitIfExists**

**Description**:  This function will perform `submit` action on an element only if it exists in the DOM, else the step will be ignored.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Object     |*SubmitIfExists*   |       |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Submit the [<Object>] if it exists")
    public void SubmitIfExists() {
        if (Element != null) {
            Submit();
        } else {
            Report.updateTestLog(Action, "Element [" + ObjectName + "] not Exists", Status.DONE);
        }
    }
```    
------------------------------------------------    

## **submitInputByLabel**

**Description**: This function will perform `submit` action on an `input` element adjacent to the provided `label` element.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| `label` object     |*submitInputByLabel*   |       |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc ="Submit input element adjacent to the provided label element [<Object>]")
    public void submitInputByLabel() {
        cc.Element = findInputElementByLabelTextByXpath();
        new Basic(cc).Submit();
    }
```    
------------------------------------------------

## **check**

**Description**:  This function will `check` the specified **Checkbox** element.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Object     |*check*   |       |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Check the [<Object>] element")
    public void check() {
        if (Element != null) {
            if (Element.isEnabled()) {
                if (!Element.isSelected()) {
                    Element.click();
                }
                if (Element.isSelected()) {
                    Report.updateTestLog("check", "Checkbox '" + Element+ "'  has been selected/checked successfully",Status.DONE);
                } else {
                    Report.updateTestLog("check", "Checkbox '" + Element+ "' couldn't be selected/checked", Status.FAIL);
                }
            } else {
                Report.updateTestLog("check", "Checkbox '" + Element+ "' is not enabled", Status.FAIL);
            }
        } else {
            Report.updateTestLog(Action, "Object [" + ObjectName + "] not found", Status.FAIL);
        }
    }
```    

------------------------------------------

## **checkAllCheckBoxes**

**Description**:  This function will `check` **all the checkboxes** on a page.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Browser     |*checkAllCheckBoxes*   |       |       | |

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Check all the check boxes in the context")
    public void checkAllCheckBoxes() {
        try {
            List<WebElement> checkboxes = Driver.findElements(By.cssSelector("input[type=checkbox]"));
            if (checkboxes.isEmpty()) {
                Report.updateTestLog(Action, "No Checkbox present in the page", Status.WARNING);
            } else {
                for (WebElement checkbox : checkboxes) {
                    if (checkbox.isDisplayed() && !checkbox.isSelected()) {
                        checkbox.click();
                    }
                }
                Report.updateTestLog(Action, "All checkboxes are checked", Status.PASS);
            }
        } catch (Exception ex) {
            Report.updateTestLog(Action, "Error while checking checkboxes - " + ex, Status.FAIL);
            Logger.getLogger(CheckBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
```    

---------------------------------------------

## **uncheck**

**Description**:  This function will `uncheck` the specified **Checkbox**.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Object     |*uncheck*   |       |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.WEB, desc = "Uncheck the [<Object>] element")
    public void uncheck() {
        if (Element != null) {
            if (Element.isEnabled()) {
                if (Element.isSelected()) {
                    Element.click();
                }
                if (!Element.isSelected()) {
                    Report.updateTestLog("uncheck", "Checkbox '" + Element+ "'  has been un-checked successfully",Status.DONE);
                } else {
                    Report.updateTestLog("uncheck", "Checkbox '" + Element+ "' couldn't be un-checked", Status.FAIL);
                }
            } else {
                Report.updateTestLog("uncheck", "Checkbox '" + Element+ "' is not enabled", Status.FAIL);
            }
        } else {
            Report.updateTestLog(Action, "Object[" + ObjectName + "] not found", Status.FAIL);
        }
    }
```    