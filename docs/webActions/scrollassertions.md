# Scroll Assertions
--------------------------

## **assertHScrollBarPresent**

**Description**: This function will check if horizontal scrollbar is present.

**Usage:**

| ObjectName | Action                    | Input           | Condition |Reference| 
|------------|--------                   |--------------   |-----------|---------|
| Object     |*assertHScrollBarPresent*  |                 |           | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Assert if the Horizontal Scrollbar is present")
	public void assertHScrollBarPresent() {
		assertHScorllBar(isHScrollBarPresent());
	}
```
**Internally uses the following** `Javascript` **logic**:

Checks whether the scroll bar is present ( see code below ),then using the derived Boolean result in the above method:
```javascript
 document.documentElement.scrollWidth>document.documentElement.clientWidth
```
---------------------------

## **assertHScrollBarNotPresent**

**Description**: This function will check if horizontal scrollbar is not present.

**Usage:**

| ObjectName | Action                       | Input           | Condition |Reference| 
|------------|--------                      |--------------   |-----------|---------|
| Object     |*assertHScrollBarNotPresent*  |                 |           | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Assert if the Horizontal Scrollbar is not present")
	public void assertHScrollBarNotPresent() {
		assertHScorllBar(isHScrollBarPresent());
	}
```
**Internally uses the following** `Javascript` **logic**:

Checks whether the scroll bar is present ( see code below ),then uses the derived Boolean result in the above method:
```java
document.documentElement.scrollWidth>document.documentElement.clientWidth
```
---------------------------

## **assertVScrollBarPresent**

**Description**:   This function will check if vertical scrollbar is present.

**Usage:**

| ObjectName | Action                    | Input           | Condition |Reference| 
|------------|--------                   |--------------   |-----------|---------|
| Object     |*assertVScrollBarPresent*  |                 |           | PageName|

**Corresponding Code:**

```java
@Action(object = ObjectType.BROWSER, desc = "Assert if the Vertical Scrollbar is present")
	public void assertVScrollBarPresent() {
		assertVScorllBar(isvScrollBarPresent());
	}
```
**Internally uses the following** `Javascript` **logic**:

Checks whether the scroll bar is present ( see code below ),then uses the derived Boolean result in the above method:
```java
document.documentElement.scrollHeight>document.documentElement.clientHeight
```
---------------------------

## **assertVScrollBarNotPresent**

**Description**: This function will check if vertical scrollbar is not present.

**Usage:**

| ObjectName | Action                    | Input           | Condition |Reference| 
|------------|--------                   |--------------   |-----------|---------|
| Object     |*assertVScrollBarNotPresent*  |                 |           | PageName|

**Corresponding Code:**

```java
	@Action(object = ObjectType.BROWSER, desc = "Assert if the Vertical Scrollbar is not present")
	public void assertVScrollBarNotPresent() {
		assertVScorllBar(isvScrollBarPresent());
	}
```
**Internally uses the following** `Javascript` **logic**:

Checks whether the scroll bar is present ( see code below ),then negates the derived Boolean result in the above method:
```java
document.documentElement.scrollHeight>document.documentElement.clientHeight
```
---------------------------