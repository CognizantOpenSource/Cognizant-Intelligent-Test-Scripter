# **Customization & Source Code Maintenance**  
---------------------- 

The tool mostly covers all the functions under the predefined list of available actions. But some times your scenario might demand a new **`action`** or **`utility`** to be implemented, for example performing PDF or Excel validation. This can be done by creating your own custom method.


### Requirements For Custom Methods which will appear in the UI of the tool

* Custom Methods should be **`public`**.
 
* The return type of Custom Methods should be **`void`**.

* Custom Methods should not contain parameters (use **Data** or **Input** or **Condition** variable for fetching data from the test case).

* Custom Method should contain the **`@Action`** annotation in order for it to get auto-suggested in the UI of the tool.

* Ensure that you import all the jars mentioned below, in your java file containing the
Custom Method.

```java
import com.cognizant.cognizantits.engine.commands.General;
import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;
```

* The java class file containing the Custom Method should always have a **`constructor`** as shown below, since it must extend the **General** class.

```java
public class SampleScript extends General {
    public SampleScript(CommandControl cc) {
        super(cc);
    }

    @Action(object = ObjectType.BROWSER, desc = "<Description of the Method>", input = InputType.YES)
    public void customfunction() {
        try {

            // Here in goes the logic of the method 

        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.OFF, null, ex);
        }
    }
}
```
---------------------- 

### Reporting

To display the status of the custom action in the report, you can use the function **`Report.updateTestLog`** as described below.

```java
Report.updateTestLog("Userdefined Action", "Operation Done successfully", Status.PASS);

// Possible Statuses are Status.PASS, Status.PASSNS, Status.FAIL, Status.FAILNS, Status.DONE, Status.DEBUG, Status.WARNING,Status.SCREENSHOT

//NS = No Screenshot
```

To display with **custom html tags** in the report, use the following,

```java
Report.updateTestLog("Userdefined Action", "#CTAG &lt;b&gt; Operation Done successfully&lt;b&gt;;", Status.PASS);
```

---------------------- 


### Adding External Libraries

- Create your custom method that uses external jar(s) apart from the existing set
of libraries under the lib folder.

- Always ensure that your custom method is working fine from your source code
before introducing it in to the tool

- Place the jar files of your external libraries in the `./lib/clib` folder

- Export your custom method as a jar file as explained in the **Engine** Section.

------------------------------

### Globally Exposed Variables You Can Use In Your Custom Method


Following variables are defined internally and can be used in your custom method for deriving various kinds of information like the action in execution or the value stored under the Input column and etc. Given below is the description about each of the variable or keyword on the basis of it's functionality and usage.



 #### **Driver**
- **Type** : `WebDriver`
- **Description** : This variable will store the instance of the Webdriver class for the current browser in
execution. Hence you can perform all the Driver related functions using this.
- **Usage** :
```java
Driver.findElement(By.className(className));
WebElement element = Driver.findElement(By.id(Data));
```

 #### **Element**
- **Type** : `WebElement`
- **Description** : This variable corresponds to the Object used under the ObjectName column of your currently executing test step. If there is no Object used in the ObjectName column of your Test step, then this variable will be `Null`. You can perform all WebElement related functions using this variable like for instance.
- **Usage** :
```java
Element.click();//This will click on the respective Object which is used in the current test step.
```

#### **Data**
- **Type** : `String`
- **Description** : This variable stores the **resolved data** from the **Input Column** of the current test step
in execution. That means if the step is being fed a data from the datasheet like **SheetName:ColumnName** or variable like **%var%** or hardcoded as **@data**, the `Data` variable will hold the **actual value** inside.

- **Usage** :
```java
System.out.println(Data + "Resolved Input used in InputColumn in the currentTestStep");
```

#### **Input**
- **Type** : `String`
- **Description** : This variable stores the **visible text/string** in the **Input Column** of the current test step
in execution. That means if the step is being fed a data from the datasheet like **SheetName:ColumnName** or variable like **%var%** or hardcoded as **@data**, the `Input` variable will hold the values as **SheetName:ColumnName**, **%var%** and **@data** respectivey

- **Usage** :
```java
System.out.println(Input + "Input used in InputColumn in the currentTestStep");
```

#### **ObjectName**
- **Type** : `String`
- **Description** : This variable stores the name of the object given under the ObjectName column of the current test step in execution.

- **Usage** :
```java
System.out.println(ObjectName + "ObjectName used in ObjectColumn in the currentTestStep");
```

#### **Description**
- **Type** : `String`
- **Description** : This variable stores the description present in the description column of the current test step.

- **Usage** :
```java
System.out.println(Description + "Description used in DescriptionColumn in the currentTestStep");
```

#### **Action**
- **Type** : `String`
- **Description** : This variable stores the name of the action used in the Action column of the current test step.

- **Usage** :
```java
System.out.println(Action + "Action/Command used in ActionColumn in the currentTestStep");
```

#### **Reference**
- **Type** : `String`
- **Description** : TThis variable stores the **Name of the Page** given under the Reference column of the current test step in execution. This Name of the Page is actually defined in the Object Repository.

- **Usage** :
```java
System.out.println(Reference + "Reference/PageName used in ReferenceColumn in the currentTestStep");
```

------------------------------

### Execute A Specific Test Case From Custom Method

There is an inbuilt method available called **`executeTestCase`**, which can be used to execute a particular test case under a particular scenario.

```java
public void executeTestCase(String scenarioName, String testCaseName);
public void executeTestCase(String scenarioName, String testCaseName, int subIteration);
```

The above method will execute the test case under the particular scenario and for that particular **subiteration**.

------------------------------
### Execute An Action From A Custom Method

A method called **executeMethod** is available with the Engine and is overloaded in 4 different ways as follows.
The name of the Action to be executed, should be passed as an argument and must be same as the action in the Engine.

- **Type 1**
```java
public void executeMethod(WebElement element, String Action);
```
Using this function you can provide the element and the action name, in the argument list, to execute the action on the element passed. For example,

```java
executeMethod(element, "Click");
```

- **Type 2**
```java
public void executeMethod(String Action, String Input);
```

Using this function you can execute the action on the **`current`** element which also requires the information under the Input column or some String information that can be given directly.For example,

```java
executeMethod("Open", "@http://something");
executeMethod("Open", input);
```

- **Type 3**
```java
 public void executeMethod(WebElement element, String Action, String Input);
```

Using this function you can execute the action on the **supplied element** which requires the information under the **Input column** or some String information that can be given directly.For example,

```java
executeMethod(element, "Set", input);
```

- **Type 4**

```java
public void executeMethod(String Action);
```
This will just call the method of the action that was instructed. 

**Any of these overloaded methods can be used that suits your requirements best.**


Another method to call an action without using the **executeMethod** function is to go with the code described below, Here, we have to set the **Data variable** for the current step and call the `Set` action for execution.

```java
getCommander().Data = "guest";//This line will assign a value to the Data variable used in the current test step.
new Basic(getCommander()).Set();//This line will call the Set action under the Basic java class file.
```

Another example of using the **getCommander()** function to call an action is as follows.Here the method containing the definition for the action **assertElementNotDisplayed** is available under the **AssertElement** java class file.

```java
new AssertElement(getCommander()).assertElementNotDisplayed();//This line will just make a call to the action "assertlementNotDisplayed"
```

------------------------------------
### Access An Object From The Object Repository

It is possible to access a specific object from the object repository using the function **AObject.findElement** as shown below.

```java
WebElement element=AObject.findElement(ObjectName, Reference);
```

Now all element related functions can be used for this **`element`** variable like;

```java
element.sendKeys(Data);
```

It is also possible to use **conditioned find** method.Suppose you want to find an object on a web page using a particular property,obtained from the **stored set of object properties in the Object Repository (OR)**, then you can use the following function.

```java
WebElement element = AObject.findElement("p", "Yahoo", ObjectProperty.Id);
```

In the example below, a list of objects so obtained can be accessed by storing them in an **ArrayList**.

```java
List <WebElement> elementList= AObject.findElements("p", "Yahoo", ObjectProperty.ClassName);
```

In the above example `object` **p** under the `page` with name **Yahoo** (from the object repository) is found on the web page by using the Id property.

-----------------------------------------------

### If-Else or other Conditions Inside A Custom Method

It is possible to write a custom function, that checks for a condition and if the
condition passes it will execute a set of code and if it fails then it will execute a
different set of code.The custom method example **`handleCondition`** defined below, will check
if the element is displayed and if so, it will execute the test case cancelTicket but if
it is not displayed then it will just update the report with a *DONE* status.

```java
public void handleCondition() throws FrameworkException {

    // No argument should be given here. Only then will this function be executed


    //Step 1: Getting object from the object repository
    WebElement element = AObject.findElement("ObjectName", "PageName");

    //Step 2: Base the condition on object being displayed or not
    if (element.isDisplayed()) {

        //Calling another test case if the condition is matched

        //Pass the Scenario name,Test case name and sub-iteration index
        executeTestCase("testscenario1", "cancelTicket", 1);
        Report.updateTestLog("Userdefined Action ", "inside reusable", Status.PASS);


        //If needed you can break the test case also by calling existing functions
        executeMethod("StopBrowser");

    } else {

        Report.updateTestLog("Userdefined Action ", "switch to origional", Status.DONE);

    }
}
```

-----------------------------------------------

### Access Test Data Sheet In Custom Method

#### Local Data sheet

##### **getData**

There are functions to access the data from the datasheet. The **getData**
function is overloaded in the following ways and can be used accordingly in your
custom method.

- **Type 1**

```java
public String getData(String DataSheetName, String ColumnName);
```

Provide the name of the data sheet (**Sample**) and column (**Data1**) that contains the data
and this function will return a string which is the value of the required data.For
instance,

```java
String input = userData.getData("Sample", "Data1");
```

- **Type 2**
```java
public String getData(String DataSheetName, String ColumnName, String Iteration, String SubIteration);
```

Provide the name of the **sheet,column,iteration and subiteration** values if you want
to be specific, as shown in the example below;

```java
String input = userData.getData("Sample", "Data1", "1", "1");
```
Here the data stored in the sheet **Sample** ,under the column **Data1** having the
**subiteration** and **iteration** value as 1 is stored in the input string variable.
Another way is to provide all the information as given above in the argument list and
also include the scenario and test case name.

- **Type 3**

```java
public String getData(String DataSheetName, String ColumnName, String ScenarioName,String TestCase, String Iteration, String SubIteration);
```
Example :
```java
String input = userData.getData("Sample", "Data1", "scenario","testcase", "1", "1");
```

In the example above the data stored in the sheet **Sample** under the column **Data1**
and belonging to the testcase named **testcase** and **scenario** named scenario having
the iteration and subiteration value as **1** is stored in input string.

##### **putData**

It is also possible to write in to the data sheet using the **"putData"** function:
The **putData()** function is overloaded in the following ways,

- **Type 1**
```java
userData.putData("DatasheetName", "ColumnName", "value to be written");
```
Example:

```java
userData.putData("Sample", "Data1", "kk");
```

where **Sample** is the datasheet name ,**Data1** is the column name and **kk** is the value
to be written under the respective column.

- **Type 2**

You can also provide the **iteration** and **subiteration** values in the argument list.

```java
userData.putData("DatasheetName", "ColumnName", "value to be written", "Iterationvalue", "SubIteration value");
```
An example for this is,

```java
userData.putData("Sample", "Data1", "kk", "1", "1");
```

where **Sample** is the datasheet name ,**Data1** is the column name and **kk** is the value
to be written under the respective column for the iteration value of **1** and subiteration value of **1**.

- **Type 3**

Apart from the information above you can also include the test case and scenario name as shown below,

```java
userData.putData("DatasheetName","columnName","value to be written","scenario name","test case name","Iteration value","SubIteration value");
```

An example for the above scenario is shown below,

```java
userData.putData("Sample", "Data1", "kk", "scenario", "testcase", "1", "1");
```

where **Sample** is the datasheet name ,**Data1** is the column name,**testcase** is the
testcase name,**scenario** is the scenario name and **kk** is the value to be written under
the respective column for the iteration and subiteration value of **1**.


#### Global Data Sheet

To access a global data sheet from the custom method to read a global data value, use the method below :

```java
userData.getGlobalData(globalDataID, columnName);
```
Example:
```java 
String datavalue = userData.getGlobalData("Glob1", "username");
```

To write or update a global data sheet, call the method below in your custom method,

```java
userData.putGlobalData(globalDataID, columnName, value);
```
Example:
```java
userData.putGlobalData("Glob1", "username", "LukeSkywalker");
```

#### TestDataModel

As an alternative, you can use the following code to access the data sheet by its name and update the same, traversing through every record in the test data sheet.

```java
TestDataModel tdModel = Control.getCurrentProject().getTestData().getTestDataByName("TestDataSheetName");
tdModel.loadTableModel();
int rowsCount = tdModel.getRowCount();
for (int row = 0; row < tdModel.getRowCount(); row++) {

    // Where orderId is a column in my data sheet
    int colIndex = tdModel.getColumnIndex("orderId");

    //To get value
    String orderId = (String) tdModel.getValueAt(row, colIndex);

    // To put values in to the sheet
    tdModel.setValueAt("New Value", row, colIndex);
}

```
------------------------------------------------
### Stop Current Execution/Iteration Based On A Condition

The following code can be used to stop the **current iteration** based on a condition.

```java
Boolean something = false;
if (something) {
    SystemDefaults.stopCurrentIteration.set(true);//Stop the iteration
}
```

The following code can be used to stop the **current execution** based on a condition.

```java
Boolean something = false;
if (something) {
    SystemDefaults.stopExecution.set(true);//Stop the execution
}
```

------------------------------------------------

### Get Iteration/Subiteration Value Of The Current TestStep

It is possible to get the value of current iteration using the function **"getIteration"**

```java
String iterationValue=userData.getIteration();
```

This function returns a string value containing the **Iteration number** of the current iteration.


It is also possible to get the value of current subiteration using the function **getSubIteration**

```java
String subiterationValue=userData.getSubIteration();
```

This function returns a string value containing the **Subiteration number** of the current sub iteration that is in execution.

------------------------------------------------

### Get Current Scenario/TestCase Name

The **getScenario** function returns a string value containing the name of the current scenario that is in execution.

```java
String scenarioName=userData.getScenario();
```

The **getCurrentScenario** function returns a string value containing the name of the current `Reusable` scenario that is in execution.

```java
String reusableScenarioName=userData.getCurrentScenario();
```

The **getTestCase** function returns a string value containing the name of the current test case in execution.

```java
String testcaseName= userData.getTestCase();
```

The **getCurrentTestCase** function returns a string value containing the name of the current `Reusable` test case in execution.

```java
String testcaseName= userData.getCurrentTestCase();
```

------------------------------------------------

### Get ObjectRepository Properties Of WebElement


It is possible to access the specific property of an element stored in the Object Repository  using the function **AObject.getObjectProperty** described below.

```java
String prop = AObject.getObjectProperty("pageName", "objectName", ObjectProperty.Id);
```

In the above scenario, pass the name of the **page** (under which the object is present
in the Object Repository),**objectName** and **object property** that you want to access.
You can also use the following method to get the particular property of the object from the OR.

```java
String prop = AObject.getWebObject("pageName", "objectName").getId();
prop = AObject.getWebObject(Reference, ObjectName).getAttributeByName(ObjectProperty.Id); //to get current step object's Id property
```

------------------------------------------------

### Add Value To A Variable

Suppose you want to create a variable and define a value to it, you can go for **addVar(arg1,arg2)** function or **addGlobalVar(arg1,arg2)** methods.

The **`addVar(arg1,arg2)`** function takes the variable name and it's value as parameters and is defined under the **com.cognizant.cognizantits.engine.commands.Command** java file as shown below,

```java
public void addVar(String key, String val) {
  Commander.addVar(key, val);
}
```

This method can be used as shown below:

```java
addVar("%nameVar%", "LukeSkywalker");
```

The scope of this variable is only till the end of the execution of the test case in which it is defined.

The **addGlobalVar(arg1,arg2)** function is used to add a value to a variable whose scope is till the end of the execution of the testset ie. till the end of execution of the last test case under the test set. This function can be used in your custom code as
shown below:

```java
addGlobalVar("%nameVar%", "LukeSkywalker");
```

This function is defined as shown below under the **com.cognizant.cognizantits.engine.commands.Command** java file.

```java
public void addGlobalVar(String key, String val) {
    if (key.matches("%.*%")) {
      key = key.substring(1, key.length() - 1);
    }
    Commander.putUserDefinedData(key, val);
}
```

----------------------------------------------
### Access A Variable's Value In Custom Method


The value of a **`variable`** created in your test case can be accessed using the function
**getVar** which is defined, as shown below, under the **com.cognizant.cognizantits.engine.commands.Command** java file.

```java
public String getVar(String key) {
    return Commander.getVar(key);
}
```
This function can be used,as shown below, in your custom method. 

Provide the variable name between two `percentage symbols`(%%)

```java
String value = getVar("%newVar%");
System.out.println(value);
```
Suppose you have defined some variables in the **userdefined** tab of the Settings window, which can be opened by navigating through **Run Settings icon** >> **UserDefined Tab**, then you can access them in your custom method in two ways:

- **Option 1:** Use the **getVar** function as shown below.

```java
String value;
value = getVar("%userdefinedVar%");
value = getVar("userdefinedVar");//This also will work
```

The other way is to use the **`getUserDefinedData`** method,which is similar to the **`getVar`** ,but can only be used for accessing the **user defined data.**

```java
String value = getUserDefinedData("userdefinedVar");
System.out.println(value);
```
---------------------------------

### Sample Custom Method

For creating any Custom Method, a java class is required. The following sample code can be used for understanding the usage of various variables and functions that you can access in your custom method.

```java
package com.cognizant.cognizantits.engine.commands;

import com.cognizant.cognizantits.engine.commands.General;
import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;

//extend Command to access elements

public class SampleScript extends General {

    public SampleScript(CommandControl cc) {
        super(cc);
    }

    public void textExe() {
        Report.updateTestLog(Action, "textExe", Status.DONE);
        executeTestCase("testWeb", "search");
    }

    @Action(object = ObjectType.BROWSER, desc = "open given url", input = InputType.YES)
    public void prinThis(){
        /**
        * No argument should be specifed. Only then will your custom method
        be executed.
        */
        //To do any operations before and/or after execution of eachStep add your code to
        //functions beforeStepExecution / afterStepExecution in
        //Annotation.java inside com.cognizant.cognizantits.engine.core package
        //To do any operation after execution [execution is finished] add your code to
        //afterReportComplete function in
        //SummaryReport.java inside com.cognizant.cognizantits.engine.reporting package
        // do ur action

        try {
            /**********************************/
            Element.click(); //Object in ObjectName is resolved as WebElement and assigned to this variable[Element]
            System.out.println(ObjectName + "ObjectName used in ObjectColumn in the currentTestStep");
            System.out.println(Description + "Description used in DescriptionColumn in the currentTestStep");
            System.out.println(Action + "Action/Command used in ActionColumn in the currentTestStep");
            System.out.println(Input + "Input used in InputColumn in the currentTestStep");
            System.out.println(Data + "Resolved Input used in InputColumn in the currentTestStep");
            System.out.println(Reference + "Reference/PageName used in ReferenceColumn in the currentTestStep");

            /**********************************/
            System.out.println(getCurrentBrowserName() + "To get the current browserName");

            /**********************************/
            //If you stored some dynamic value in a variable[%newVar%] you can get the value from the variable using
            String value = getVar("%newVar%");
            System.out.println(value);

            //If you want to access the userdefined data created from UserDefined Settings pane you can use it in two ways
            //1st option
            value = getVar("%userdefinedVar%");
            value = getVar("userdefinedVar"); //This also will work

            //2nd option
            value = getUserDefinedData("userdefinedVar");
            System.out.println(value);

            //If you want to store some value in a variable[%dyanmicVar%] you can store the value into a variable using
            //Scope is for Current Testcase

            addVar("%dyanmicVar%", "Value to be Stored");

            //Scope is for All
            addGlobalVar("%dyanmicVar%", "Value to be Stored");

            /**********************************/
            // Using Inbuilt findMethod
            AObject.findElement(ObjectName, Reference); //To find thecurrent step's object
            AObject.findElements(ObjectName, Reference); //To find the current step's object

            // to access the object value pass ObjectName and PageName as  inputs

            // ObjectName=p
            // PageName=Yahoo

            WebElement element = AObject.findElement("p", "Yahoo");
            List<WebElement>elementList = AObject.findElements("p", "Yahoo");

            // Using Conditioned FindMethod

            element = AObject.findElement("p", "Yahoo", ObjectProperty.Id);
            elementList = AObject.findElements("p", "Yahoo", ObjectProperty.ClassName);
            System.out.println("No of elements" + elementList.size());
            //Using Own findMethod

            element = Driver.findElement(By.id(Data));

            /**********************************/
            // using this element you can perform selenium operations

            element.sendKeys("Normal");
            element.sendKeys(Data);

            /**********************************/
            //To get a property of an object from ObjectRepository

            String prop = AObject.getWebObject("pageName","objectName").getId();

            prop = AObject.getWebObject(Reference,ObjectName).getAttributeByName(ObjectProperty.Id); //to get current step object's id property

            System.out.println(prop);

            /**********************************/

            // to access the data from DataSheets pass DataSheetName and ColumnName as inputs
            // Don't pass GlobalData as inputsheet
            
            // SheetName,Columnname
            String input = userData.getData("Sample", "Data1");

            //To get values from specified Iteration and subiteration
            input = userData.getData("Sample", "Data1", "1", "1");

            //To get values from specified Scenario, Testcase, Iteration and subiteration
            input = userData.getData("Sample", "Data1", "scenario","testcase", "1", "1");
            element.sendKeys(input);

            /**********************************/
            //To write values into DataSheet 
            //Don't pass GlobalData as inputsheet
            
            // SheetName,Columnname,value
            userData.putData("Sample", "Data1", "kk");

            //to write values for specified Iteration and subiteration
            userData.putData("Sample", "Data1", "kk", "1", "1");

            //to write values for specified Scenario, Testcase, Iteration and subiteration
            userData.putData("Sample", "Data1", "kk", "scenario", "testcase", "1", "1");

            /**********************************/

            TestDataModel tdModel = Control.getCurrentProject().getTestData().getTestDataByName(" TestDatasheetName");

            int rowsCount = tdModel.getRowCount();

            for (int row = 0; row < tdModel.getRowCount(); row++) {

                // Where orderId is a column in my data sheet
                int colIndex = tdModel.getColumnIndex("orderId");

                //To get value
                String orderId = (String) tdModel.getValueAt(row, colIndex);

                // To put values in to the sheet
                tdModel.setValueAt("New Value", row, colIndex);
            }

            /**********************************/
            //To display in Report
            Report.updateTestLog("Userdefined Action ", "Operation Done successfully", Status.PASS);

            //To display in Report with custom html tags
            Report.updateTestLog("Userdefined Action ", "#CTAG<b>Operation Done successfully<b>", Status.PASS);

           /**********************************/
            //To get the current Iteration
            userData.getIteration();

            //To get the current SubIteration
            userData.getSubIteration();

            //To get the current Scenario

            userData.getScenario();
            //To get the current Testcase

            userData.getTestCase();
            //To get the current BrowserName

            System.out.println(getCurrentBrowserName());

            /**********************************/
            // to stop the current iteration if u want to... based on condition

            Boolean something = false;

            if (something) {

                SystemDefaults.stopCurrentIteration.set(true);
                SystemDefaults.stopExecution.set(true); //Stop the execution

            }

            /**********************************/
            // To use inbuilt functions
            //simple way
            //make sure you set the Data,Element and other variables

            new Basic(getCommander()).Click();

            //Old school

            executeMethod(element, "Click");
            executeMethod("open", "@http://something");
            executeMethod("open", input);
            executeMethod(element, "Set", input);

            /**********************************/
            //To execute Other Testcases

            // scenarioname,testcasename,subiteration
            executeTestCase("OnlineShopping", "BuyProduct", 2);

            // scenarioname,testcasename
            executeTestCase("OnlineShopping", "BuyProduct");

        } catch (Exception ex) {

            Logger.getLogger(this.getClass().getName()).log(Level.OFF, null, ex);

        }
    }

   /**********************************/
    public void handleCondition() throws UnCaughtException {

        //Getting object from the object repository
        WebElement element = AObject.findElement("ObjectName", "PageName");

        //Basing the condition on a web element being displayed
        if (element.isDisplayed()) {

            //Calling another test case if the condition is matched
            
            //Pass the Scenario name,Test case name and sub-iteration index
            executeTestCase("testscenario1", "cancelTicket", 1);
            Report.updateTestLog("Userdefined Action ", "inside reusable", Status.PASS);

            //If needed you can break the test case also by calling existing functions
            executeMethod("StopBrowser");
            //
        } else {
            Report.updateTestLog("Userdefined Action ", "switch to origional", Status.DONE);
        }
    }
}
```

------------------------------