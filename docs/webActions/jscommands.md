# JS Commands
------------------------

## **setByJS**
Check [here](webelement.md) more details

------------------------

## **clickByJS**
Check [here](webelement.md) more details

-------------------------------

## **clearByJS**

**Description**:  This function will use JavaScript to clear an objects text content  (useful when selenium functions do not work).

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Object     |*clearByJS*   |       |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Clear the element [<Object>]")
    public void clearByJS() {
        if (elementPresent()) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) Driver;
                js.executeScript("arguments[0].value=''", Element);
                Report.updateTestLog(Action, "Cleared value from '" + ObjectName + "'", Status.DONE);
            } catch (Exception ex) {
                Logger.getLogger(JSCommands.class.getName()).log(Level.SEVERE, null, ex);
                Report.updateTestLog(Action,"Couldn't clear value on " + ObjectName + " - Exception " + ex.getMessage(), Status.FAIL);
            }
        } else {
            throw new ElementException(ElementException.ExceptionType.Element_Not_Found, ObjectName);
        }
    }
```    

---------------------------

## **selectByJS**

**Description**: This function is used to select a given option from a drop down and is useful when selenium functions do not work.  

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*selectByJS*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*selectByJS*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*selectByJS*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Select element [<Object>] ", input = InputType.YES)
    public void selectByJS() {
        if (elementPresent()) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) Driver;
                Object value = js.executeScript(
                        "var options=arguments[0].getElementsByTagName('option');" + "for(var i=0;i<options.length;i++)"
                        + "{" + "var value=options[i].textContent?options[i].textContent:options[i].innerText;"
                        + "if(value.trim()==='" + Data.trim() + "')" + "{"
                        + "options[i].setAttribute('selected','selected');" + "return true;" + "}" + "}"
                        + "return false;",
                        Element);
                if (value != null && value.toString().trim().toLowerCase().equals("true")) {
                    Report.updateTestLog(Action, "Item " + Data + " is selected from" + ObjectName, Status.DONE);
                } else {
                    Report.updateTestLog(Action, "Item " + Data + " is not available in the" + ObjectName, Status.FAIL);
                }
            } catch (Exception ex) {
                Logger.getLogger(JSCommands.class.getName()).log(Level.SEVERE, null, ex);
                Report.updateTestLog(Action,"Couldn't select value from " + ObjectName + " - Exception " + ex.getMessage(), Status.FAIL);
            }
        } else {
            throw new ElementException(ElementException.ExceptionType.Element_Not_Found, ObjectName);
        }
    }
```

----------------------


## **assertInsideBounds**

**Description**: To function uses Javascript to check if the given object is inside the boundary.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Object     |*assertInsideBounds*   |       |       | PageName|



**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "To check if [<Object>] is inside the boundary ")
    public void assertInsideBounds() {
        if (elementPresent()) {
            JavascriptExecutor js = (JavascriptExecutor) Driver;
            Object value = js.executeScript("" + "return isOutside(arguments[0]);" + "function isOutside(x){"
                    + "     return x.scrollWidth <= x.offsetWidth;" + "}", Element);
            if (value != null && Boolean.valueOf(value.toString())) {
                Report.updateTestLog(Action, "Element " + ObjectName + " is inside bounds", Status.PASS);
            } else {
                Report.updateTestLog(Action, "Element " + ObjectName + " is outside bounds", Status.FAIL);
            }
        } else {
            throw new ElementException(ElementException.ExceptionType.Element_Not_Found, ObjectName);
        }

    }
```

-----------------------------------
## **executeEval**

**Description**: This function is used to execute the JavaScript commands 

**Input Format** : @`Javascript`

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*executeEval*   | @value       |       | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*executeEval*   | Sheet:Column |       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*executeEval*   | %dynamicVar% |       | |<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
@Action(object = ObjectType.ANY, desc = "To execute the JavaScript commands", input = InputType.YES)
    public void executeEval() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Driver;
            if (Element != null) {
                js.executeScript(Data, Element);
            } else {
                js.executeScript(Data);
            }
            Report.updateTestLog(Action, "Javascript executed", Status.DONE);
        } catch (Exception ex) {
            Logger.getLogger(JSCommands.class.getName()).log(Level.SEVERE, null, ex);
            Report.updateTestLog(Action, "Javascript execution failed", Status.DEBUG);
        }
    }
```

------------------------

## **storeEval**

**Description**:  Function to store a `return` value of a Javascript command, in a variable.

**For example** if you have a variable as **'a' and 'b'** and want to add them and store the sum in a variable, you can follow the following syntax.

| ObjectName | Action | Input        | Condition |Reference|
|------------|--------|--------------|-----------|---------|
| Object     |*storeEval*   | @`var a=20;var b=30;return c=a+b;`       |       |

Now the value **50**(a+b), will be stored in var.

**Input Format** :  @`Javascript` 

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*storeEval*   | @value       |  %var%     | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*storeEval*   | Sheet:Column |  %var%     | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*storeEval*   | %dynamicVar% |  %var%     | |<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
    @Action(object = ObjectType.BROWSER, desc = "Store the result of Javascript expression value in a variable", input = InputType.YES, condition = InputType.YES)
    public void storeEval() {
        String javaScript = Data;
        String variableName = Condition;
        if (variableName.matches("%.*%")) {
            JavascriptExecutor js = (JavascriptExecutor) Driver;
            addVar(variableName, js.executeScript(javaScript).toString());
            Report.updateTestLog(Action, "Eval Stored", Status.DONE);
        } else {
            Report.updateTestLog(Action, "Variable format is not correct", Status.FAIL);
        }
    }
```