# Element Attribute Assertions
--------------------------------

## **assertElementAttrEquals**

**Description**: This function will validate if specified attribute for an element is equal to the user-provided data.

**Input Format** : attributeName attributeValue

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertElementAttrEquals*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementAttrEquals*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementAttrEquals*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc ="Assert if [<Object>]'s Attribute Equals [<Data>]", input =InputType.YES)
    public void assertElementAttrEquals() {
        assertElementAttr(SpecText.Type.IS);
    }
```
**Internally uses `Galen Specs Language` to check that URL text is **Equal** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text is**  *- checks that text is exactly as expected*

----------------------

## **assertElementAttrContains**

**Description**:  This function will validate if the specified attribute for an element contains the user-provided data.

**Input Format** : attributeName attributeValue

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertElementAttrContains*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementAttrContains*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementAttrContains*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc ="Assert if [<Object>]'s Attribute Contains [<Data>]", input =InputType.YES)
    public void assertElementAttrContains() {
        assertElementAttr(SpecText.Type.CONTAINS);
    }
```
**Internally uses `Galen Specs Language` to check that URL text **Contains** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text contains**  *- checks element contains expected text*

----------------------

## **assertElementAttrStartsWith**

**Description**:   This function will validate if specified attribute for an element begins with the user-provided data.

**Input Format** : attributeName attributeValue

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertElementAttrStartsWith*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementAttrStartsWith*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementAttrStartsWith*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
@Action(object = ObjectType.SELENIUM, desc ="Assert if [<Object>]'s Attribute StartsWith [<Data>]", input =InputType.YES)
    public void assertElementAttrStartsWith() {
        assertElementAttr(SpecText.Type.STARTS);
    }
```
**Internally uses `Galen Specs Language` to check that URL text **StartsWith** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text starts**  *- element should start with expected text*

----------------------

## **assertElementAttrEndsWith**

**Description**:   This function will validate if specified attribute for an element ends with user provided data.

**Input Format** : attributeName attributeValue

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertElementAttrEndsWith*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementAttrEndsWith*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementAttrEndsWith*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
 @Action(object = ObjectType.SELENIUM, desc ="Assert if [<Object>]'s Attribute EndsWith [<Data>]", input =InputType.YES)
    public void assertElementAttrEndsWith() {
        assertElementAttr(SpecText.Type.ENDS);
    }
```
**Internally uses `Galen Specs Language` to check that URL text **EndsWith** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text ends**  *- element should end with expected text*

----------------------

## **assertElementAttrMatches**

**Description**:    This function will validate if specified attribute for an element matches with the user-provided data. You can also use regular expression in the Input field.

**Input Format** : attributeName attributeValue

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertElementAttrMatches*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementAttrMatches*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementAttrMatches*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
 @Action(object = ObjectType.SELENIUM, desc ="Assert if [<Object>]'s Attribute Matches [<Data>]", input =InputType.YES)
    public void assertElementAttrMatches() {
        assertElementAttr(SpecText.Type.MATCHES);
    }
```
**Internally uses `Galen Specs Language` to check that URL text **Matches** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text matches**  *- verifies that text matches Java Regular Expression*

----------------------

## **assertElementAttrIEquals**

**Description**:    This function will validate if specified attribute for an element is equals the user-provided data.This function will ignore case of the user-provided data.

**Input Format** : attributeName attributeValue

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertElementAttrIEquals*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementAttrIEquals*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementAttrIEquals*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
 @Action(object = ObjectType.SELENIUM, desc ="Assert if [<Object>]'s Attribute Equals [Ignorecase] [<Data>]", input =InputType.YES)
    public void assertElementAttrIEquals() {
        assertElementAttrI(SpecText.Type.IS);
    }
```
**Internally uses `Galen Specs Language` to check that URL text is **Equal** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text is**  *- checks that text is exactly as expected*

----------------------

## **assertElementAttrIContains**

**Description**:   This function will validate if specified attribute contains user-provided data.This function will ignore case of the user-provided data.

**Input Format** : attributeName attributeValue

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertElementAttrIContains*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementAttrIContains*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementAttrIContains*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
 @Action(object = ObjectType.SELENIUM, desc ="Assert if [<Object>]'s Attribute Contains [Ignorecase] [<Data>]", input =InputType.YES)
    public void assertElementAttrIContains() {
        assertElementAttrI(SpecText.Type.CONTAINS);
    }
```
**Internally uses `Galen Specs Language` to check that URL text **Contains** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text contains**  *- checks element contains expected text*

----------------------

## **assertElementAttrIStartsWith**

**Description**:    This function will validate if specified attribute for an element begins with the user-provided data. This function will ignore case of the user-provided data.

**Input Format** : attributeName attributeValue

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertElementAttrIStartsWith*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementAttrIStartsWith*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementAttrIStartsWith*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
 @Action(object = ObjectType.SELENIUM, desc ="Assert if [<Object>]'s Attribute StartsWith [Ignorecase] [<Data>]", input =InputType.YES)
    public void assertElementAttrIStartsWith() {
        assertElementAttrI(SpecText.Type.STARTS);
    }
```
**Internally uses `Galen Specs Language` to check that URL text **StartsWith** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text starts**  *- element should start with expected text*

----------------------

## **assertElementAttrIEndsWith**

**Description**:  This function will validate if specified attribute for an element ends with the user-provided data. This function will ignore case of the user-provided data.

**Input Format** : attributeName attributeValue

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Object     |*assertElementAttrIEndsWith*   | @value       |       | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertElementAttrIEndsWith*   | Sheet:Column |       | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertElementAttrIEndsWith*   | %dynamicVar% |       | PageName|<span style="color:Brown"><<*Input from variable*</span>

Inputs in the Input column can be either `hardcoded` (in this case the data is preceded by a "**@**"), passed from the data sheet (`datasheet name : column name`) or passed from a variable value (`%variable name%`), as given in the above example.

**Corresponding Code:**

```java
 @Action(object = ObjectType.SELENIUM, desc ="Assert if [<Object>]'s Attribute EndsWith [Ignorecase] [<Data>]", input =InputType.YES)
    public void assertElementAttrIEndsWith() {
        assertElementAttrI(SpecText.Type.ENDS);
    }
```
**Internally uses `Galen Specs Language` to check that URL text **EndsWith** or not to the given URL.As Galen relies on Selenium – the text will be returned the same way it appears in a real browser (e.g. white space is ignored).**

**text ends**  *- element should end with expected text*