# Element Assertions

------------------------------------

## **assertElementPresent**

**Description**:  This function will check if specified element is present in the web page ie. In the DOM of the page

**Usage:**

| ObjectName | Action                    | Input           | Condition |Reference| 
|------------|--------                   |--------------   |-----------|---------|
| Object     |*assertElementPresent*     |                 |           | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Assert if [<Object>] is present")
	public void assertElementPresent() {
		assertElement(elementPresent());
	}
```
**Internally uses the following** `Selenium` **logic**:

Checks whether driver is alive and element is present ( see code below ),then using the derived Boolean result in the above method:
```java
checkIfDriverIsAlive() && Element != null
```
---------------------------
## **assertElementNotPresent**

**Description**: This function will check if the specified element is not present in the web page ie. In the DOM itself.

**Usage:**

| ObjectName | Action                   | Input           | Condition |Reference| 
|------------|--------                  |--------------   |-----------|---------|
| Object     |*assertElementNotPresent* |                 |           | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Assert if [<Object>] is not present")
	public void assertElementNotPresent() {
		assertNotElement(!elementPresent());
	}
```    
**Internally uses the following** `Selenium` **logic**:

Checks whether driver is alive and element is present ( see code below ),then negating the derived Boolean result in the above method:
```java
checkIfDriverIsAlive() && Element != null
```
---------------------------
## **assertElementSelected**

**Description**: This function will check if the element is selected.

**Usage:**

| ObjectName | Action                    | Input           | Condition |Reference| 
|------------|--------                   |--------------   |-----------|---------|
| Object     |*assertElementSelected*    |                 |           | PageName|

**Corresponding Code:**

```java
	@Action(object = ObjectType.SELENIUM, desc = "Assert if [<Object>] element is selected")
	public void assertElementSelected() {
		assertElement(elementSelected());
	}
```
**Internally uses the following** `Selenium` **logic**:

Checks whether the element is selected ( see code below ),then using the derived Boolean result in the above method:
```java
Element.isSelected()
```
---------------------------
## **assertElementNotSelected**

**Description**:  This function will check if the specified element is not selected

**Usage:**

| ObjectName | Action                    | Input           | Condition |Reference| 
|------------|--------                   |--------------   |-----------|---------|
| Object     |*assertElementNotSelected* |                 |           | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Assert if [<Object>] is not selected")
	public void assertElementNotSelected() {
		assertNotElement(!elementSelected());
	}
```
**Internally uses the following** `Selenium` **logic**:

Checks whether the element is selected ( see code below ),then negating the derived Boolean result in the above method:
```java
Element.isSelected()
```
---------------------------

## **assertElementDisplayed**

**Description**:  This function will check if the object is displayed on web page.

**Usage:**

| ObjectName | Action                    | Input           | Condition |Reference| 
|------------|--------                   |--------------   |-----------|---------|
| Object     |*assertElementDisplayed*   |                 |           | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Assert if [<Object>] element is displayed")
	public void assertElementDisplayed() {
		assertElement(elementDisplayed());
	}
```
**Internally uses the following** `Selenium` **logic**:

Checks whether the element is enabled ( see code below ),then using the derived Boolean result in the above method:
```java
Element.isDisplayed()
```
---------------------------

## **assertElementNotDisplayed**

**Description**: This function will check if the specified element is not displayed.

**Usage:**

| ObjectName | Action                    | Input           | Condition |Reference| 
|------------|--------                   |--------------   |-----------|---------|
| Object     |*assertElementNotDisplayed* |                 |           | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Assert if [<Object>] is not displayed")
	public void assertElementNotDisplayed() {
		assertNotElement(!elementDisplayed());
	}
```
**Internally uses the following** `Selenium` **logic**:

Checks whether the element is displayed ( see code below ),then negating the derived Boolean result in the above method:
```java
Element.isDisplayed()
```
---------------------------
## **assertElementEnabled**

**Description**: This function will check if the element is enabled.

**Usage:**

| ObjectName | Action                    | Input           | Condition |Reference| 
|------------|--------                   |--------------   |-----------|---------|
| Object     |*assertElementEnabled*  |                 |           | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Assert if [<Object>] is enabled on the current page")
public void assertElementEnabled() {
		assertElement(elementEnabled());
	}
```
**Internally uses the following** `Selenium` **logic**:

Checks whether the element is enabled ( see code below ),then using the derived Boolean result in the above method:
```java
Element.isEnabled()
```
---------------------------
## **assertElementNotEnabled**

**Description**:  This function will check if the specified element is not enabled.

**Usage:**

| ObjectName | Action                    | Input           | Condition |Reference| 
|------------|--------                   |--------------   |-----------|---------|
| Object     |*assertElementNotEnabled*  |                 |           | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Assert if [<Object>] is not enabled")
	public void assertElementNotEnabled() {
		assertNotElement(!elementEnabled());
	}
```
**Internally uses the following** `Selenium` **logic**:

Checks whether the element is enabled ( see code below ),then negating the derived Boolean result in the above method:
```java
Element.isEnabled()
```
---------------------------