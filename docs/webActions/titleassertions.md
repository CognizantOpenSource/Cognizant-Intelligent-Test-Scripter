# Browser Title Assertions

------------------------------

## **assertTitleEquals**

**Description**:  This function will validate if the title of the current page is equals the user-provided data.

**Input Format** : @Expected text

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertTitleEquals*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertTitleEquals*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertTitleEquals*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc ="Assert if Browser's Title Equals [<Data>]", input =InputType.YES)
    public void assertTitleEquals() {
        assertTitle(SpecText.Type.IS);
    }
```
**Internally uses `Galen Specs Language` to check that URL text is **Equal** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text is**  *- checks that text is exactly as expected*

----------------------


## **assertTitleContains**

**Description**:  This function will validate if the title of the current page has the user-provided data.

**Input Format** : @Expected text

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertTitleContains*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertTitleContains*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertTitleContains*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc ="Assert if Browser's Title Contains [<Data>]", input =InputType.YES)
    public void assertTitleContains() {
        assertTitle(SpecText.Type.CONTAINS);
    }
```
**Internally uses `Galen Specs Language` to check that URL text **Contains** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text contains**  *- checks element contains expected text*

----------------------


## **assertTitleStartsWith**

**Description**:   This function will validate if the title of the current page begins with the user-provided data.

**Input Format** : @Expected text

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertTitleStartsWith*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertTitleStartsWith*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertTitleStartsWith*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.


```java
 @Action(object = ObjectType.BROWSER, desc ="Assert if Browser's Title StartsWith [<Data>]", input =InputType.YES)
    public void assertTitleStartsWith() {
        assertTitle(SpecText.Type.STARTS);
    }

```
**Internally uses `Galen Specs Language` to check that URL text **StartsWith** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text starts**  *- element should start with expected text*

----------------------


## **assertTitleEndsWith**

**Description**:   This function will validate if the title of the current page ends with the user-provided data.

**Input Format** : @Expected text

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertTitleEndsWith*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertTitleEndsWith*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertTitleEndsWith*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

```java
 @Action(object = ObjectType.BROWSER, desc ="Assert if Browser's Title EndsWith [<Data>]", input =InputType.YES)
    public void assertTitleEndsWith() {
        assertTitle(SpecText.Type.ENDS);
    }

```
**Internally uses `Galen Specs Language` to check that URL text **EndsWith** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text ends**  *- element should end with expected text*

----------------------


## **assertTitleMatches**

**Description**:   This function will validate if the title current page matches  the user-provided data. You can also use regular expression in the Input field.

**Input Format** : @Expected text

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertTitleMatches*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertTitleMatches*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertTitleMatches*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

```java
 @Action(object = ObjectType.BROWSER, desc ="Assert if Browser's Title Matches [<Data>]", input =InputType.YES)
    public void assertTitleMatches() {
        assertTitle(SpecText.Type.MATCHES);
    }

```
**Internally uses `Galen Specs Language` to check that URL text **Matches** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text matches**  *- verifies that text matches Java Regular Expression*

----------------------


## **assertTitleIEquals**

**Description**:  This function will validate if the title of the current page is equals the user-provided data. This function will ignore case of user provided data.

**Input Format** : @Expected text

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertTitleIEquals*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertTitleIEquals*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertTitleIEquals*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

```java
 @Action(object = ObjectType.BROWSER, desc ="Assert if Browser's Title Equals [Ignorecase] [<Data>]", input =InputType.YES)
    public void assertTitleIEquals() {
        assertTitleI(SpecText.Type.IS);
    }

```
**Internally uses `Galen Specs Language` to check that URL text is **Equal** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text is**  *- checks that text is exactly as expected*

----------------------


## **assertTitleIContains**

**Description**:  This function will validate if the title of the current page contains the user-provided data. This function will ignore case of the user-provided data.

**Input Format** : @Expected text

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertTitleIContains*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertTitleIContains*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertTitleIContains*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

```java
 @Action(object = ObjectType.BROWSER, desc ="Assert if Browser's Title Contains [Ignorecase] [<Data>]", input =InputType.YES)
    public void assertTitleIContains() {
        assertTitleI(SpecText.Type.CONTAINS);
    }

```
**Internally uses `Galen Specs Language` to check that URL text **Contains** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text contains**  *- checks element contains expected text*

----------------------


## **assertTitleIStartsWith**

**Description**: This function will validate if the current page title begins with the user-provided data. This function will ignore case of the user-provided data.

**Input Format** : @Expected text

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertTitleIStartsWith*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertTitleIStartsWith*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertTitleIStartsWith*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc ="Assert if Browser's Title StartsWith [Ignorecase] [<Data>]", input =InputType.YES)
    public void assertTitleIStartsWith() {
        assertTitleI(SpecText.Type.STARTS);
    }
```
**Internally uses `Galen Specs Language` to check that URL text **StartsWith** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text starts**  *- element should start with expected text*

----------------------


## **assertTitleIEndsWith**

**Description**:  This function will validate if the title of the current page ends with the user-provided data. This function will ignore case of the user-provided data.

**Input Format** : @Expected text

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertTitleIEndsWith*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertTitleIEndsWith*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertTitleIEndsWith*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

```java
 @Action(object = ObjectType.BROWSER, desc ="Assert if Browser's Title EndsWith [Ignorecase] [<Data>]", input =InputType.YES)
    public void assertTitleIEndsWith() {
        assertTitleI(SpecText.Type.ENDS);
    }

```
**Internally uses `Galen Specs Language` to check that URL text **EndsWith** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text ends**  *- element should end with expected text*