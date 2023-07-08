# Additional Assertions
------------------------------------

## **assertPageSource**

**Description**: This function will check if the page source content of the current page is matching with the expected page source content provided by the user.

**Input Format** : @Expected PageSource content

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertPageSource*| @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertPageSource*| Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertPageSource*| %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
	@Action(object = ObjectType.BROWSER, desc = "Assert if Page source of current page is: [<Data>]", input = InputType.YES)
	public void assertPageSource() {
		if (Driver.getPageSource().equals(Data)) {
			Report.updateTestLog(Action, "Current Page Source is matched with the expected Page Source", Status.DONE);
		} else {
			throw new ForcedException(Action, "Current Page Source doesn't match with the expected Page Source");
		}
	}
```


**Description**:  This function will check if the text of the input element adjacent to provided label element equals the given text(in the Input Column)

**Usage:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Object     | @value       |           |
| Object     | Sheet:Column |           |
| Object     | %dynamicVar% |           |

## **assertVariable**

**Description**:  This function will assert a `stored variable's` value with the value given by the user.

**Input Format** : @%var_name%=Expected Value

**Usage:**

| ObjectName | Action            | Input        | Condition |Reference|  |
|------------|-------------------|--------------|-----------|---------|--|
| Browser     |*assertVariable*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span>
| Browser     |*assertVariable*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*assertVariable*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER,desc = "Assert if Key:Value -> [<Data>] is valid",input = InputType.YES)
    public void assertVariable() throws RuntimeException {
        try {
            String strObj = Data;
            String[] strTemp = strObj.split("=", 2);
            String strAns = strTemp[0].matches("%.+%") ? getVar(strTemp[0]) : strTemp[0];
            if (strAns.equals(strTemp[1])) {
                System.out.println("Condition '" + Input + "' is true ");
                Report.updateTestLog("assertVariable","Variable matched with Provided data", Status.PASS);

            } else {
                 System.out.println("Condition '" + Input + "' is false ");
                throw new Exception("Variable did not match with provided data");
            }
        } catch (Exception ex) {
            Logger.getLogger(Assertions.class.getName()).log(Level.SEVERE, null, ex);
            throw new ForcedException("assertVariable", ex.getMessage());
        }
    }
```
----------------------


## **assertCookiePresent**

**Description**: This function will assert the presence of a `cookie` by it's specified name and store the result in a variable.

**Input Format** :   @CookieName

**Usage:**

| ObjectName | Action                 | Input        | Condition   |Reference|  |
|------------|------------------------|--------------|-------------|---------|--|
| Browser    |*assertCookiePresent*   | @value       | %variable%       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser    |*assertCookiePresent*   | Sheet:Column | %variable%       | PageName|<span style="color:Blue"><< *Input from Datasheet*<span> 
| Browser    |*assertCookiePresent*   | %dynamicVar% | %variable%       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Assert if cookie name: [<Data>] is present", input = InputType.YES)
    public void assertCookiePresent() {
        try {
            String strCookieName = Data;
            if ((Driver.manage().getCookieNamed(strCookieName) != null)) {
                System.out.println("assertCookiePresent Passed");
                Report.updateTestLog("assertCookiePresent","Cookie name matched with the data provided",Status.PASS);
            } else {
                throw new Exception("Cookie name did not match with data provided");
            }
        } catch (Exception ex) {
            System.out.println("assertCookiePresent Failed");
            Logger.getLogger(Assertions.class.getName()).log(Level.SEVERE, null, ex);
            throw new ForcedException("assertCookiePresent", ex.getMessage());
        }
    }
```
----------------------

## **assertCookieByName**

**Description**:  This function will assert the `cookie's` (the name of the cookie is given is specified in the input column) value with the one in the input column

**Input Format** :   @CookieName:CookieValue

**Usage:**

| ObjectName | Action                 | Input      | Condition   |Reference|  |
|------------|------------------------|------------|-------------|---------|--|
| Browser    |*assertCookieByName*    |  @data     |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
     
Inputs in the Input column can be passed from `hardcoded` (in this case the data is preceded by a "**@**"), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Assert if cookie: [<Object>] has name: [<Data>]", input = InputType.YES)
    public void assertCookieByName() {
        try {

            String strCookieName = Data.split(":", 2)[0];
            String strCookieValue = Data.split(":", 2)[1];
            if (Driver.manage().getCookieNamed(strCookieName) != null) {
                if ((Driver.manage().getCookieNamed(strCookieName).getValue().equals(strCookieValue))) {
                    System.out.println("assertCookieByName Passed");
                    Report.updateTestLog("assertCookieByName","Cookie name matched with provided data",Status.PASS);

                } else {
                    throw new Exception("Cookie value did not match with provided data");
                }
            } else {
                throw new Exception("Cookie  with the name '" + strCookieName + "' did not exist");
            }
        } catch (Exception ex) {
            System.out.println("assertCookieByName Failed");
            Logger.getLogger(Assertions.class.getName()).log(Level.SEVERE, null, ex);
            throw new ForcedException("assertCookieByName", ex.getMessage());
        }
    }
```
----------------------


## **assertAlertText**

**Description**:  This function will assert the text present in alert with the given text.

**Input Format** :  @Expected Text

**Usage:**

| ObjectName | Action                 | Input        | Condition   |Reference|  |
|------------|------------------------|--------------|-------------|---------|--|
| Browser    |*assertAlertText*       | @value       |        | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser    |*assertAlertText*       | Sheet:Column |        | PageName|<span style="color:Blue"><< *Input from Datasheet*<span> 
| Browser    |*assertAlertText*       | %dynamicVar% |        | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Assert if an alert with text: [<Data>] is present", input = InputType.YES)
    public void assertAlertText() {

        try {
            String strExpAlertText = Data;
            if (isAlertPresent()) {
                if ((Driver.switchTo().alert().getText().equals(strExpAlertText))) {
                    System.out.println("assertAlertText Passed");
                    Report.updateTestLog("assertAlertText","Alert text matched with provided data",Status.PASSNS);
                } else {
                    throw new Exception("Alert text did not match with the provided data");
                }
            } else {
                throw new Exception("Alert not present");
            }

        } catch (Exception ex) {
            System.out.println("assertAlertText Failed");
            Logger.getLogger(Assertions.class.getName()).log(Level.SEVERE, null, ex);
            throw new ForcedException("assertAlertText", ex.getMessage());
        }
    }
```
----------------------

## **assertAlertPresent**

**Description**:  This function will assert the presence of an `alert`

**Usage:**

| ObjectName | Action                 | Input        | Condition   |Reference|  |
|------------|------------------------|--------------|-------------|---------|--|
| Browser    |*assertAlertPresent*    |              |             | 

**Corresponding Code:**

```java
 @Action(object = ObjectType.BROWSER, desc = "Assert if an alert is present ")
    public void assertAlertPresent() {
        try {
            if ((isAlertPresent())) {
                System.out.println("assertAIertPresent Passed");
                Report.updateTestLog("assertAIertPresent", "Alert present",Status.PASSNS);
            } else {
                throw new Exception("Alert not present");
            }
        } catch (Exception ex) {
            System.out.println("assertAIertPresent Failed");
            Logger.getLogger(Assertions.class.getName()).log(Level.SEVERE, null, ex);
            throw new ForcedException("assertAIertPresent", ex.getMessage());
        }
    }
```
----------------------

## **assertEval**
**Description**:   This function will assert if the `evaluated javascript expression` equals the expected value provided.

**Input Format** :   @javascript:expectedvalue.

**Usage:**

| ObjectName | Action                 | Input        | Condition   |Reference|  |
|------------|------------------------|--------------|-------------|---------|--|
| Browser    |*assertEval*            | @value       |        | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser    |*assertEval*            | Sheet:Column |        | PageName|<span style="color:Blue"><< *Input from Datasheet*<span> 
| Browser    |*assertEval*            | %dynamicVar% |        | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER,desc = "Assert if the evaluated javascript expression equals [<Data>]",input = InputType.YES)
    public void assertEval() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Driver;

            String strExpScript = Data.split(":", 2)[0];
            String strExpValue = Data.split(":", 2)[1];
            Object result = js.executeScript(strExpScript);
            if (result != null && result.toString().trim().equals(strExpValue)) {
                System.out.println("assertEval Passed");
                Report.updateTestLog("assertEval","JS script return value matched with the expected result",Status.DONE);
            } else {
                throw new Exception("JS script return value did not match with the expected result");
            }
        } catch (Exception ex) {
            System.out.println("assertEval Failed");
            Logger.getLogger(Assertions.class.getName()).log(Level.SEVERE, null, ex);
            throw new ForcedException("assertEval", ex.getMessage());
        }
    }
```
----------------------

## **assertVariableFromDataSheet**

**Description**:   This function will check if the `variable` given in the condition column has a value equals to the value from the datasheet mentioned in the input column. 

**Input Format** :   Datasheet name:Column name

**Condition Format**: %Variable name%

**Usage:**


| ObjectName | Action                       | Input        | Condition   |Reference|  |
|------------|------------------------------|--------------|-------------|---------|--|
| Browser    |*assertVariableFromDataSheet* | Sheet:Column | %variable% |PageName|<span style="color:Blue"><< *Input from Datasheet*</span> 

Inputs in the Input column can be either passed from the data sheet (`datasheet name : column name`)  as given in the above example.

**Corresponding Code:**

```java
8@Action(object = ObjectType.BROWSER,
            desc = "Assert if  the  variable value matches with given value from datasheet(variable:datasheet->  [<Data>] )",
            input = InputType.YES,
            condition = InputType.YES)
    public void assertVariableFromDataSheet() throws RuntimeException {
        try {
            String strAns = getVar(Condition);
            if (strAns.equals(Data)) {
                System.out.println("Variable " + Condition + " equals " + Input);
                Report.updateTestLog(Action, "Variable is matched with the expected result", Status.DONE);

            } else {
                System.out.println("Variable " + Condition + " is not equal " + Input);
                throw new ForcedException(Action, "Variable did not match with provided data");
            }
        } catch (Exception e) {
            Logger.getLogger(Assertions.class.getName()).log(Level.SEVERE, null, e);
            throw new ForcedException("assertVariableFromDataSheet", e.getMessage());
        }
    }
```
----------------------