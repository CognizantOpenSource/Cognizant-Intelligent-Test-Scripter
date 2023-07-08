# Dropdowns
------------------------

## **selectByIndex**

**Description**:  This function will `select` an option from a `dropdown` whose index matches the given index.

**Input Format** :  @`Index` of item to be selected from dropdown. Example : `0` or `1` or `2` etc.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*selectByIndex*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*selectByIndex*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*selectByIndex*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Select all options from a select Element [<Object>]", input = InputType.YES)
    public void selectByIndex() {
        select(SelectType.Select, SelectRange.Single, SelectBy.Index);
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
select.selectByIndex(Integer.parseInt(Data))
```
--------------------------------

## **selectByVisibleText**

**Description**:  This function will select an option from a `dropdown` whose visible text matches the given text.

**Input Format** :  @`Text` of item to be selected from dropdown.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*selectByVisibleText*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*selectByVisibleText*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*selectByVisibleText*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>


**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Select item in [<Object>] which has text: [<Data>]", input = InputType.YES)
    public void selectByVisibleText() {
        select(SelectType.Select, SelectRange.Single, SelectBy.Text);
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
select.selectByVisibleText(Data)
```
-------------------------------------------------

## **selectByValue**

**Description**:  This function will select an option from a `dropdown` whose value (`value` attribute of `option` HTML tag) matches the given value.

**Input Format** :  @`value` attribute of item to be selected from dropdown.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*selectByValue*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*selectByValue*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*selectByValue*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>


**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Select item in [<Object>] which has the value: [<Data>]", input = InputType.YES)
    public void selectByValue() {
        select(SelectType.Select, SelectRange.Single, SelectBy.Value);
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
select.selectByValue(Data)
```

-------------------------------------------------------

## **selectMultipleByIndex**

**Description**:  This function will `select`  **all options** that have index matching the given set of indices.

**Input Format** : @Expected index1,Expected index2

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*selectMultipleByIndex*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*selectMultipleByIndex*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*selectMultipleByIndex*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>


**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Select items [<Data>] of [<Object>] by index", input = InputType.YES)
    public void selectMultipleByIndex() {
        select(SelectType.Select, SelectRange.Multiple, SelectBy.Index);
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
String[] values = Data.split(",");
for (String value : values) {
    select.selectByIndex(Integer.parseInt(value));
}
```

-----------------------------------------------------

## **selectMultipleByText**

**Description**:  This function will `select` **all options** that display the text matching the given text.

**Input Format** :  @Expected Text1,Expected Text2

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*selectMultipleByText*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*selectMultipleByText*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*selectMultipleByText*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>


**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Select items [<Data>] of [<Object>] by visible Text", input = InputType.YES)
    public void selectMultipleByText() {
        select(SelectType.Select, SelectRange.Multiple, SelectBy.Text);
    }

```

**Internally uses the following** `Selenium` **logic :**
```java
String[] values = Data.split(",");
for (String value : values) {
    select.selectByVisibleText(value);
}
```
-----------------------------------------

## **selectMultipleByValue**

**Description**:  This function will `select` **all options** that have value (`value` attribute of `option` HTML tag) matching the given value.

**Input Format** :  @Expected value1,Expected value2

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*selectMultipleByText*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*selectMultipleByText*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*selectMultipleByText*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>


**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Select items [<Data>] of [<Object>] by value", input = InputType.YES)
    public void selectMultipleByValue() {
        select(SelectType.Select, SelectRange.Multiple, SelectBy.Value);
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
String[] values = Data.split(",");
for (String value : values) {
    select.selectByValue(value);
}
```
-------------------------------------------------

## **selectIndexFromUnorderedList**

**Description**:  This function will `select` the value from an **unordered list based on the index.**

**Input Format** :@`Index` of item to be selected from dropdown. Example : `0` or `1` or `2` etc.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*selectIndexFromUnorderedList*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*selectIndexFromUnorderedList*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*selectIndexFromUnorderedList*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>


**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "selecting value by index [<Data>] from unordered list .", input = InputType.YES)
    public void selectIndexFromUnorderedList() {
        selectFromUnorderedList(SelectBy.Index);
    }
```

---------------------------------------------------

## **selectValueFromUnorderedList**

**Description**:  This function will `select` the value based on the **visible text from an unordered list.**

**Input Format** : @`Text` of item to be selected from dropdown.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*selectValueFromUnorderedList*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*selectValueFromUnorderedList*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*selectValueFromUnorderedList*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>


**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "selecting value [<Data>] from unordered list .", input = InputType.YES)
    public void selectValueFromUnorderedList() {
        selectFromUnorderedList(SelectBy.Text);
    }

```

---------------------------------------------------

## **deSelectByIndex**

**Description**:  This function will `de-select` an option that has index matching the given index.

**Input Format** : @`Index` of item to be de-selected from dropdown. Example : `0` or `1` or `2` etc.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*deSelectByIndex*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*deSelectByIndex*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*deSelectByIndex*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>


**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM,
            desc = "Deselect  item in [<Object>] which has index: [<Data>]", input = InputType.YES)
    public void deSelectByIndex() {
        select(SelectType.DeSelect, SelectRange.Single, SelectBy.Index);
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
select.deselectByIndex(Integer.parseInt(Data))
```
-----------------------------------------------------------------


## **deSelectByVisibleText**

**Description**:  This function will `de-select` an option that displays text matching the given text.

**Input Format** :  @`Text` of item to be de-selected from dropdown.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*deSelectByVisibleText*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*deSelectByVisibleText*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*deSelectByVisibleText*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>


**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM,
            desc = "Deselect item in [<Object>] which has text: [<Data>]", input = InputType.YES)
    public void deSelectByVisibleText() {
        select(SelectType.DeSelect, SelectRange.Single, SelectBy.Text);
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
select.deselectByVisibleText(Data)  
```
-----------------------------------------------------------------

## **deSelectByValue**

**Description**:  This function will `de-select` an option from a `dropdown` whose value (`value` attribute of `option` HTML tag) matches the given value.

**Input Format** : @`value` attribute of item to be de-selected from dropdown.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*deSelectByValue*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*deSelectByValue*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*deSelectByValue*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>


**Corresponding Code:**

```java
  @Action(object = ObjectType.SELENIUM,
            desc = "Deselect item in [<Object>] which has value: [<Data>]",
            input = InputType.YES)
    public void deSelectByValue() {
        select(SelectType.DeSelect, SelectRange.Single, SelectBy.Value);
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
select.deselectByValue(Data)
```

-------------------------------------------------------

## **deSelectMultipleByIndex**

**Description**:  This function will `de-select` all options that has index matching the given indices. This is done by examining the `index` attribute of an element, and not merely by counting.If there is no index attribute used then use the `option index` by count

**Input Format** :  @Expected index1,Expected index2

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*deSelectMultipleByIndex*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*deSelectMultipleByIndex*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*deSelectMultipleByIndex*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>


**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Deselect items [<Data>] of [<Object>] by index", input = InputType.YES)
    public void deSelectMultipleByIndex() {
        select(SelectType.DeSelect, SelectRange.Multiple, SelectBy.Index);
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
String[] values = Data.split(",");
for (String value : values) {
    select.deselectByIndex(Integer.parseInt(value));
}
```

-------------------------------------------

## **deSelectMultipleByText**

**Description**:  This function will `de-select` all options that display text matching the given text.

**Input Format** :  @Expected Text1,Expected Text2

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*deSelectMultipleByText*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*deSelectMultipleByText*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*deSelectMultipleByText*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>


**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Deselect items [<Data>] of [<Object>] by visible Text", input = InputType.YES)
    public void deSelectMultipleByText() {
        select(SelectType.DeSelect, SelectRange.Multiple, SelectBy.Text);
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
String[] values = Data.split(",");
for (String value : values) {
    select.deselectByVisibleText(value);
}
```
-----------------------------------------------------------

## **deSelectMultipleByValue**

**Description**:  This function will `de-select` **all options** that have value (`value` attribute of `option` HTML tag) matching the given value.

**Input Format** :  @Expected value1,Expected value2

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*deSelectMultipleByValue*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*deSelectMultipleByValue*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*deSelectMultipleByValue*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>


**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Deselect items [<Data>] of [<Object>] by value", input = InputType.YES)
    public void deSelectMultipleByValue() {
        select(SelectType.DeSelect, SelectRange.Multiple, SelectBy.Value);
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
String[] values = Data.split(",");
for (String value : values) {
    select.deselectByValue(value);
}
```
---------------------------------------------------------------

## **selectAll**

**Description**:   This function will select all options from a select element.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|
|------------|--------|--------------|-----------|---------|
| Object     |*selectAll*   |        |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Select all options from a select Element [<Object>]")
    public void selectAll() {
        select(SelectType.Select, SelectRange.All, null);
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
Select select = new Select(Element);
for (int i = 0; i < select.getOptions().size(); i++) {
     select.selectByIndex(i);
    }
```

-----------------------------------------

## **deSelectAll**

**Description**:  This function will clear all the **selected entries** in a dropdown. This is only valid when there is support for multiple selections in the dropdown.

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|
|------------|--------|--------------|-----------|---------|
| Object     |*deSelectAll*   |        |       | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc = "Deselect all items in  [<Object>]")
    public void deSelectAll() {
        select(SelectType.DeSelect, SelectRange.All, null);
    }
```

**Internally uses the following** `Selenium` **logic :**
```java
new Select(Element).deselectAll()
```

---------------------------

## **assertSelectContains**

**Description**: This function will `assert` if the selected element from the `dropdown` matches the user-specified input.

**Input Format** :  @Expected Text

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertSelectContains*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertSelectContains*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertSelectContains*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>


**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM,desc = "Assert if the  select list [<Object>] contains [<Data>]",
            input = InputType.YES)
    public void assertSelectContains() {
        if (elementPresent()) {
            Boolean isPresent = false;
            Select select = new Select(Element);
            for (WebElement option : select.getOptions()) {
                if (option.getText().trim().equals(Data)) {
                    isPresent = true;
                    break;
                }
            }
            if (isPresent) {
                Report.updateTestLog(Action, ObjectName + " Contains the Option " + Data, Status.DONE);
            } else {
                Report.updateTestLog(Action, ObjectName + " doesn't Contains the Option " + Data, Status.DEBUG);
            }
        } else {
            throw new ElementException(ElementException.ExceptionType.Element_Not_Found, ObjectName);
        }
    }
```
