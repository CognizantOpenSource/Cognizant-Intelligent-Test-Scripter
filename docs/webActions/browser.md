# Browser/Driver Actions
------------------------

## **Open**

**Description**: This function will **open the URL** provided by the user in the selected browser

**Input Format** : @URL

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*Open*   | @value       |`optional` page timeout in secs | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*Open*   | Sheet:Column |`optional` page timeout in secs       | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*Open*   | %dynamicVar% | `optional` page timeout in secs      | |<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER,desc = "Open the Url [<Data>] in the Browser",input = InputType.YES)
    public void Open() {
        Boolean pageTimeOut = false;
        try {
            if (Condition.matches("[0-9]+")) {
                setPageTimeOut(Integer.valueOf(Condition));
                pageTimeOut = true;
            }
            Driver.get(Data);
            Report.updateTestLog("Open", "Opened Url: " + Data, Status.DONE);
        } catch (TimeoutException e) {
            Report.updateTestLog("Open", "Opened Url: " + Data + " and cancelled page load after " + Condition + "seconds", Status.DONE);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.OFF, null, e);
            Report.updateTestLog("Open", e.getMessage(), Status.FAIL);
            throw new ForcedException("Open", e.getMessage());
        }
        if (pageTimeOut) {
            setPageTimeOut(300);
        }
    }
```

-----------------------------------------------------
## **setBrowserSize**

**Description**: This function will set the **size of the browser** to dimensions provided

**Input Format** : In pixels. Examples : **@700x800** or **@700,800** or **@700 800**

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*setBrowserSize*   | @value       | | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*setBrowserSize*   | Sheet:Column | | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*setBrowserSize*   | %dynamicVar% |  | |<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Changes the browser size into [<Data>]", input = InputType.YES)
    public void setBrowserSize() {
        try {
            if (Data.matches("\\d*(x|,| )\\d*")) {
                String size = Data.replaceFirst("(x|,| )", " ");
                String[] sizes = size.split(" ", 2);
                Driver.manage().window().setSize(new Dimension(Integer.parseInt(sizes[0]), Integer.parseInt(sizes[1])));
                Report.updateTestLog(Action, " Browser is resized to " + Data,
                        Status.DONE);
            } else {
                Report.updateTestLog(Action, " Invalid Browser size [" + Data + "]",
                        Status.DEBUG);
            }
        } catch (Exception ex) {
            Report.updateTestLog(Action, "Unable to resize the Window ",
                    Status.FAIL);
            Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
```
-----------------------------------------------------
## **StartBrowser**

**Description**: This function is used to **start** a specified browser.

**Input Format** : @BrowserName. Example: `Chrome`, `Chrome Headless`, `Firefox`, `Edge` etc.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*StartBrowser*   | @value       | | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*StartBrowser*   | Sheet:Column | | |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*StartBrowser*   | %dynamicVar% |  | |<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Start a specified browser", input = InputType.YES)
    public void StartBrowser() {
        try {
            getDriverControl().StartBrowser(Data);
            Report.setDriver(getDriverControl());
            Report.updateTestLog("StartBrowser", "Browser Started: " + Data,
                    Status.DONE);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.OFF, null, e);
            Report.updateTestLog("StartBrowser", "Error: " + e.getMessage(),
                    Status.FAIL);
        }

    }
```

-----------------------------------------------------
## **StopBrowser**

**Description**: This function is used to **stop** the current browser

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  
|------------|--------|--------------|-----------|---------|
| Browser     |*StopBrowser*   |   | | 
| Browser     |*StopBrowser*   |  | | 
| Browser     |*StopBrowser*   |  |  | 

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Stop the current browser")

    public void StopBrowser() {
        getDriverControl().StopBrowser();
        Report.updateTestLog("StopBrowser", "Browser Stopped: ", Status.DONE);
    }
```
----------------------


## **RestartBrowser**

**Description**:  This function is used to **restart** current browser.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Browser     |*RestartBrowser*   |   | | 
| Browser     |*RestartBrowser*   |  | | 
| Browser     |*RestartBrowser*   |  |  | 

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Restarts the Browser")
    public void RestartBrowser() {
        try {
            getDriverControl().RestartBrowser();
            Report.setDriver(getDriverControl());
            Report.updateTestLog("RestartBrowser", "Restarted Browser",Status.DONE);
        } catch (Exception ex) {
            Report.updateTestLog("RestartBrowser", "Unable Restart Browser",Status.FAIL);
            Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
```
------------------------------------------------------
## **maximize**

**Description**:This function is used to **maximize** the browser window.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Browser     |*maximize*   |   | | 
| Browser     |*maximize*   |  | | 
| Browser     |*maximize*   |  |  | 

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Maximize the browser.")
    public void maximize() {
        try {
            Driver.manage().window().maximize();
            Report.updateTestLog("maximize", " Window is maximized ", Status.DONE);
        } catch (Exception ex) {
            Report.updateTestLog("maximize", "Unable to maximize the Window ", Status.FAIL);
            Logger.getLogger(BrowserUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
```
> **Note** : By default the driver launched by the tool is maximized.
----------------------------------------------------------
## **refreshDriver**

**Description**: This function will **refresh** the current web page.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Browser     |*refreshDriver*   |   | | 
| Browser     |*refreshDriver*   |  | | 
| Browser     |*refreshDriver*   |  |  | 

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Refresh current page ")
    public void refreshDriver() {
        try {
            Driver.navigate().refresh();
            Report.updateTestLog("refreshDriver", "Page is refreshed",Status.DONE);
        } catch (WebDriverException e) {
            Report.updateTestLog("refreshDriver", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }

    }
```
----------------------------------------------------------

## **forward**

**Description**:  This function is used for **navigating forward to next page.**

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Browser     |*forward*   |   | | 
| Browser     |*forward*   |  | | 
| Browser     |*forward*   |  |  | 

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "browser navigates to next page.")
    public void forward() {
        try {
            Driver.navigate().forward();
            Report.updateTestLog("forward", "Navigate page forward is success",Status.DONE);
        } catch (WebDriverException e) {
            Report.updateTestLog("forward", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }
```


-----------------------------------------------------------

## **back**

**Description**: This function is used for **navigating to the previous page.**

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Browser     |*back*   |   | | 
| Browser     |*back*   |  | | 
| Browser     |*back*   |  |  | 

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Navigate to previous page")
    public void back() {
        try {
            Driver.navigate().back();
            Report.updateTestLog("back", "Navigate page back is success",Status.DONE);
        } catch (WebDriverException e) {
            Report.updateTestLog("back", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }
```

-----------------------------------------------------------
## **addCookie**

**Description**:  This function will **add a cookie** defined in the input column.

**Input Format** : @`CookieName`:`CookieValue`

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*addCookie*   | @value       | | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*addCookie*   | Sheet:Column || |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*addCookie*   | %dynamicVar% | | |<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Add the cookie name with value [<Data>].", input = InputType.YES)
    public void addCookie() {

        try {
            String strCookieName = Data.split(":", 2)[0];
            String strCookieValue = Data.split(":", 2)[1];
            Cookie oCookie = new Cookie.Builder(strCookieName, strCookieValue).build();
            Driver.manage().addCookie(oCookie);
            Report.updateTestLog(Action, "Cookie Name- '" + strCookieName+ "' with value '" + strCookieValue + "' is added",Status.DONE);
        } catch (Exception e) {
            Report.updateTestLog(Action, e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }
```

-----------------------------------------------------------

## **deleteCookie**

**Description**:  This function will delete the cookie specified by the user.

**Input Format** : @`CookieName`

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Browser     |*deleteCookie*   | @value       | | |<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*deleteCookie*   | Sheet:Column || |<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*deleteCookie*   | %dynamicVar% | | |<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "delete the cookie having name [<Data>].", input = InputType.YES)
    public void deleteCookie() {
        try {
            String strCookieName = Data;
            Cookie oCookie = Driver.manage().getCookieNamed(strCookieName);
            if (oCookie != null) {
                Driver.manage().deleteCookie(oCookie);
                Report.updateTestLog(Action, "Cookie Name- '"+ strCookieName + "' is deleted", Status.DONE);
            } else {
                Report.updateTestLog(Action, "Cookie doesn't exist",Status.FAIL);
            }
        } catch (Exception e) {
            Report.updateTestLog(Action, e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }

```

-----------------------------------------------------------------

## **close**

**Description**:  This function will **close the selenium Web Driver.**

**Usage:**

| ObjectName | Action | Input        | Condition |Reference| 
|------------|--------|--------------|-----------|---------|
| Browser     |*close*   |   | | 
| Browser     |*close*   |  | | 
| Browser     |*close*   |  |  | 

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Close the current browser session")
    public void close() {
        try {
            Driver.close();
            Report.updateTestLog("close", "Selenium Webdriver is closed",Status.DONE);
        } catch (WebDriverException e) {
            Report.updateTestLog("close", e.getMessage(), Status.FAIL);
            Logger.getLogger(CommonMethods.class.getName()).log(Level.SEVERE, null, e);
        }
    }
```



