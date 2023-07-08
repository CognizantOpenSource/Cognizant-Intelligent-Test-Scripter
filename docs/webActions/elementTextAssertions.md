# Element Text Assertions

----------------------------------

## **assertTextPresentInPage**

**Description**:  This function will search for the expected `text` within the html tag of the page and assert the same

**Input Format** :   @Expected Text

**Usage:**

| ObjectName | Action                     | Input         | Condition |Reference|  |
|------------|----------------------------|---------------|-----------|---------|--|
| Browser     |*assertTextPresentInPage*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Browser     |*assertTextPresentInPage*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Browser     |*assertTextPresentInPage*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Assert if text: [<Data>] is present on the page", input = InputType.YES)
    public void assertTextPresentInPage() throws RuntimeException {

        try {
            String strObj = Data;
            if (Driver.findElement(By.tagName("html")).getText().contains(strObj)) {
                System.out.println("assertTextPresent passed");
                Report.updateTestLog("assertTextPresentInPage",
                        "Expected text '" + strObj + "' is  present in the page", Status.PASS);

            } else {
                System.out.println("assertTextPresentInPage failed");
                throw new Exception("Expected text  '" + strObj + "' is not present in the page");
            }

        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.OFF, null, e);
            throw new ForcedException("assertTextPresentInPage", e.getMessage());
        }
    }
```

----------------------
## **assertElementTextEquals**

**Description**:  This function will validate if a specified `element text` is equal to the user-provided text.

**Input Format** : @Expected Text

**Usage:**

| ObjectName | Action                     | Input         | Condition |Reference|  |
|------------|----------------------------|---------------|-----------|---------|--|
| Object     |*assertElementTextEquals*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementTextEquals*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementTextEquals*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
    @Action(object = ObjectType.SELENIUM,desc = "Assert if [<Object>]'s Text Equals [<Data>]",input = InputType.YES)
    public void assertElementTextEquals() {
        assertElementText(Type.IS);
    }

```
**Internally uses `Galen Specs Language` to check that element text is **Equal** or not to the given text. As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text is**  *- checks that text is exactly as expected*

----------------------

## **assertElementTextContains**

**Description**:  This function will check if an `element text` contains the expected text.

**Input Format** : @Expected Text

**Usage:**

| ObjectName | Action                       | Input         | Condition |Reference|  |
|------------|------------------------------|---------------|-----------|---------|--|
| Object     |*assertElementTextContains*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementTextContains*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementTextContains*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
    @Action(object = ObjectType.SELENIUM,
            desc = "Assert if [<Object>]'s Text Contains [<Data>]",input = InputType.YES)
    public void assertElementTextContains() {
        assertElementText(Type.CONTAINS);
    }
```
**Internally uses `Galen Specs Language` to check that element text is **Contains** or not to the given text. As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text is**  *- checks that text is exactly as expected*

----------------------


## **assertElementTextStartsWith**

**Description**:  This function will validate if specified `element text` starts with user provided data.

**Input Format** : @Expected Text

**Usage:**

| ObjectName | Action                       | Input         | Condition |Reference|  |
|------------|------------------------------|---------------|-----------|---------|--|
| Object     |*assertElementTextStartsWith*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementTextStartsWith*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementTextStartsWith*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
    @Action(object = ObjectType.SELENIUM,desc = "Assert if [<Object>]'s Text StartsWith [<Data>]",input = InputType.YES)
    public void assertElementTextStartsWith() {
        assertElementText(Type.STARTS);
    }

```
**Internally uses `Galen Specs Language` to check that element text is **Start With** or not to the given text. As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text is**  *- checks that text is exactly as expected*

----------------------

## **assertElementTextEndsWith**

**Description**:   This function will validate if the specified `element text` ends with user-provided data.

**Input Format** : @Expected Text

**Usage:**

| ObjectName | Action                       | Input         | Condition |Reference|  |
|------------|------------------------------|---------------|-----------|---------|--|
| Object     |*assertElementTextEndsWith*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementTextEndsWith*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementTextEndsWith*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
    @Action(object = ObjectType.SELENIUM,desc = "Assert if [<Object>]'s Text EndsWith [<Data>]",input = InputType.YES)
    public void assertElementTextEndsWith() {
        assertElementText(Type.ENDS);
    }

```
**Internally uses `Galen Specs Language` to check that element text is **Ends With** or not to the given text. As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text is**  *- checks that text is exactly as expected*

----------------------


## **assertElementTextMatches**

**Description**:  This function will validate if a specified `element text` matches with the user-provided data. You can also use regular expression in the Input field .

**Input Format** : @Expected Text

**Usage:**

| ObjectName | Action                       | Input         | Condition |Reference|  |
|------------|------------------------------|---------------|-----------|---------|--|
| Object     |*assertElementTextMatches*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementTextMatches*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementTextMatches*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
    @Action(object = ObjectType.SELENIUM,desc = "Assert if [<Object>]'s Text Matches [<Data>]",input = InputType.YES)
    public void assertElementTextMatches() {
        assertElementText(Type.MATCHES);
    }

```
**Internally uses `Galen Specs Language` to check that element text is **Matches** or not to the given text. As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text is**  *- checks that text is exactly as expected*

----------------------

## **assertElementTextIEquals**

**Description**:  This function will validate if a specified `element text` is equal to the user-provided data. This function will ignore case of the user-provided data.

**Input Format** : @Expected Text

**Usage:**

| ObjectName | Action                       | Input         | Condition |Reference|  |
|------------|------------------------------|---------------|-----------|---------|--|
| Object     |*assertElementTextIEquals*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementTextIEquals*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementTextIEquals*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
    @Action(object = ObjectType.SELENIUM,desc = "Assert if [<Object>]'s Text Equals [Ignorecase] [<Data>]",input = InputType.YES)
    public void assertElementTextIEquals() {
        assertElementTextI(Type.IS);
    }

```
**Internally uses `Galen Specs Language` to check that element text is **Equals** or not to the given text. As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text is**  *- checks that text is exactly as expected*

----------------------

## **assertElementTextIContains**

**Description**:  This function will validate if a specified `element text` contains the user-provided data. This function will ignore case of the user-provided data.

**Input Format** : @Expected Text

**Usage:**

| ObjectName | Action                       | Input         | Condition |Reference|  |
|------------|------------------------------|---------------|-----------|---------|--|
| Object     |*assertElementTextIContains*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementTextIContains*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementTextIContains*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
    @Action(object = ObjectType.SELENIUM,desc = "Assert if [<Object>]'s Text Contains [Ignorecase] [<Data>]",input = InputType.YES)
    public void assertElementTextIContains() {
        assertElementTextI(Type.CONTAINS);
    }

```
**Internally uses `Galen Specs Language` to check that element text is **Contains** or not to the given text. As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text is**  *- checks that text is exactly as expected*

----------------------

## **assertElementTextIStartsWith**

**Description**: This function will validate if a specified `element text` begins with the user-provided data. This function will ignore case of the user-provided data.

**Input Format** : @Expected Text

**Usage:**

| ObjectName | Action                       | Input         | Condition |Reference|  |
|------------|------------------------------|---------------|-----------|---------|--|
| Object     |*assertElementTextIStartsWith*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementTextIStartsWith*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementTextIStartsWith*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
    @Action(object = ObjectType.SELENIUM,desc = "Assert if [<Object>]'s Text StartsWith [Ignorecase] [<Data>]",input = InputType.YES)
    public void assertElementTextIStartsWith() {
        assertElementTextI(Type.STARTS);
    }

```
**Internally uses `Galen Specs Language` to check that element text is **Starts With** or not to the given text. As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text is**  *- checks that text is exactly as expected*

----------------------

## **assertElementTextIEndsWith**

**Description**:  This function will validate if a specified `element text` ends with the user-provided data. This function will ignore case of the user-provided data.

**Input Format** : @Expected Text

**Usage:**

| ObjectName | Action                       | Input         | Condition |Reference|  |
|------------|------------------------------|---------------|-----------|---------|--|
| Object     |*assertElementTextIEndsWith*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementTextIEndsWith*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementTextIEndsWith*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
    @Action(object = ObjectType.SELENIUM,desc = "Assert if [<Object>]'s Text EndsWith [Ignorecase] [<Data>]",input = InputType.YES)
    public void assertElementTextIEndsWith() {
        assertElementTextI(Type.ENDS);
    }
```
**Internally uses `Galen Specs Language` to check that element text is **Ends With** or not to the given text. As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text is**  *- checks that text is exactly as expected*

----------------------

## **assertElementTextContainsByLabel**

**Description**: This function will check if the `text` of the input element adjacent to provided label element contains the given text(in the Input Column) 

**Input Format** : @Expected Text.

**Usage:**

| ObjectName | Action                       | Input         | Condition |Reference|  |
|------------|------------------------------|---------------|-----------|---------|--|
| Object     |*assertElementTextContainsByLabel*  | @value       |     | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementTextContainsByLabel*  | Sheet:Column |     | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementTextContainsByLabel*  | %dynamicVar% |    | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
    @Action(object = ObjectType.SELENIUM, 
    		desc ="Assert if [<Object>]'s Text adjacent to provided label element Contains [<Data>]", 
    		input =InputType.YES)
    public void assertElementTextContainsByLabel() {
        cc.Element = findInputElementByLabelTextByXpath();
        new Text(cc).assertElementTextContains();
    }
```
**Internally uses `Galen Specs Language` to check that element text is **Adjacent to provided label** or not to the given text. As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text is**  *- checks that text is exactly as expected*

----------------------


## **assertElementTextByLabel**

**Description**:  This function will check if the `text` of the input element adjacent to provided label element equals the given text(in the Input Column)

**Usage:**

| ObjectName | Action                       | Input         | Condition |Reference|  |
|------------|------------------------------|---------------|-----------|---------|--|
| Object     |*assertElementTextByLabel*  | @value       |     | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementTextByLabel*  | Sheet:Column |     | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementTextByLabel*  | %dynamicVar% |    | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
    @Action(object = ObjectType.SELENIUM, 
    		desc ="Assert if [<Object>]'s Text adjacent to provided label element Equals [<Data>]", 
    		input =InputType.YES)
    public void assertElementTextByLabel() {
        cc.Element = findInputElementByLabelTextByXpath();
        new Text(cc).assertElementTextEquals();
    }

```
**Internally uses `Galen Specs Language` to check that element text is **Adjacent to provided label** or not to the given text. As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text is**  *- checks that text is exactly as expected*

----------------------