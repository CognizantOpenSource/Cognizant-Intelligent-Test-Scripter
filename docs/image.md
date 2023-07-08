# **Image Based Testing**

----------------------------------
!!! Documentation on this is currently in progress

-----------------------------------------------

### **<u>Text</u>**

* **imgAssertText**

**Description**: This function is used to check if the given expected text is present in the image object.

**Input Format** : @Expected Text

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgVerifyText**

**Description**: This function is used to verify if the given expected text is present in the image object.

**Input Format** : @Expected Text

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgStoreText**

**Description**: This function is used to store image text in a user-defined variable.

**Input Format** : %Variable_Name%

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | %dynamicVar% |           |
  
* **imgAssertTextAbove**

**Description**: This function is used to check if the expected text is above the image object.

**Input Format** : @Expected Text

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgAssertTextBelow**

**Description**:  This function is used to check if the expected text is below the image object.

**Input Format** : @Expected Text

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgAssertTextRight**

**Description**:This function is used to check if the expected text is at the right to the image object.

**Input Format** : @Expected Text

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgAssertTextLeft**

**Description**: This function is used to check if the expected text is at the left of the image object.

**Input Format** : @Expected Text

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgVerifyTextAbove**

**Description**: TThis function is used to check if the expected text is above the image object.

**Input Format** : @Expected Text

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgVerifyTextBelow**

**Description**:  This function is used to check if the expected text is below the image object.

**Input Format** : @Expected Text

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgVerifyTextRight**

**Description**: This function is used to check if the expected text is to the right of the image object.

**Input Format** : @Expected Text

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgVerifyTextLeft**

**Description**: This function is used to check if the expected text is to the left of the image object.

**Input Format** : @Expected Text

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgStoreTextAbove**

**Description**: This function is used to store a text above the object in a user-defined

**Input Format** : %Variable_Name%

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | %dynamicVar% |           |

* **imgStoreTextBelow**

**Description**: This function is used to store a text below the object in a user-defined

**Input Format** : %Variable_Name%

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | %dynamicVar% |           |

* **imgStoreTextRight**

**Description**: This function is used to store a text to the right of the object in a userdefined variable.

**Input Format** : %Variable_Name%

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | %dynamicVar% |           |

* **imgStoreTextLeft**

**Description**: This function is used to store a text to the left of the object in a user-defined variable.

**Input Format** : %Variable_Name%

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | %dynamicVar% |           |

### **<u>Common Image Methods</u>**

* **imgClearAndSet**

**Description**: This function will clear an image object and then it will set the user provided data in that object.

**Input Format** : @Expected data. 

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgSetEncrypted**

**Description**: This function is used to enter the encrypted data into image objects.

**Input Format** : @Expected data. 

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

**Note**: If the data is passed from data sheet, then the data in the sheet should be encrypted.

* **imgDoubleClick**

**Description**: This function is used to find and double-click the image on the screen.

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      |              |           |

* **imgVerifyImage**

**Description**: This function is used to verify if the image object is on the screen.

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      |              |           |

* **imgAssertImage**

**Description**: This function is used to check if the image is on the screen.

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      |              |           |

* **imgClick**

**Description**:  Finds and clicks the image on the screen.

**Input Format** : Give Optional parameter as keyModifiers (i.e., Ctrl/Shift/Alt)

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      |              |           |
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgType**

**Description**: This function is used for typing any user given data in an image.

**Input Format** : @Expected Data

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **typeOnScreen**

**Description**: This function is used to type any text on the screen where the cursor/focus is currently available.

**Input Format** : @Text to be typed

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
|  App       | @value       |           |
|  App       | Sheet:Column |           |
|  App       | %dynamicVar% |           |

* **imgClearText**

**Description**: This function is used to delete the whole text from the image objects such as from a text. 

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      |              |           |

* **imgHover**

**Description**:  This function is used to hover the mouse over the image object on the screen.

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      |              |           |

* **imgSet**

**Description**: This function is used to set (Paste) the input data on the image.

**Input Format** : @Expected Data

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgRightClick**

**Description**: This function is used to right-click the specificed image on the screen.

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      |              |           |

* **imgWait**

**Description**: Waits for the image to appear on the screen

**Input Format** : @time in seconds .If the input column is left empty default time of 10
seconds will be used.

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      |              |           |
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgWaitVanish**

**Description**:  This function is used to wait for the image to disappear from the screen.

**Input Format** : @time in seconds. If the input column is left empty default time of 10 seconds will be used

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      |              |           |
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgFindinPage**

**Description**: This function is used to find any image on the page within the desired time.

**Input Format** : @Time in miliseconds

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

### **<u>Mouse</u>**

* **imgmouseDown**

**Description**: This function is used to perform the mouse down operation. Keys integer value can be given as the input.

**Input Format** : @Keys Integer Representation (16, 8, 4, -1, 1 respectively for mouse left, middle, right, wheel up, wheel down buttons)

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **imgmouseUp**

**Description**: This function is used to perform the mouse up operation. Keys integer value can be given as the input.

**Input Format** : @Keys Integer Representation (16, 8, 4, -1, 1 respectively for mouse left, middle, right, wheel up, and wheel down buttons)

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |

* **moveMouseTO**

**Description**: This function will move the mouse to a user-defined location.

**Input Format** : @Location

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
|  App       | @value       |           |
|  App       | Sheet:Column |           |
|  App       | %dynamicVar% |           |

### **<u>Application</u>**

* **shortcutKeys**

**Description**: This function is used to perform the keyboard shortcut actions.

**Input Format** : @Combination of keys such as Ctrl+a

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
|  App       | @value       |           |
|  App       | Sheet:Column |           |
|  App       | %dynamicVar% |           |

* **pressKeys**

**Description**:This function is used to perform the keyboard key press actions. After pressing it, do not forget to release the keys.

**Input Format** : @Keyboard Keys like Ctrl,Shift,Alt

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
|  App       | @value       |           |
|  App       | Sheet:Column |           |
|  App       | %dynamicVar% |           |

* **releaseKeys**

**Description**: This function is used to perform release actions of the keyboard keys. It will release an already pressed key.

**Input Format** : @Keyboard Keys like Ctrl,Shift,Alt

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
|  App       | @value       |           |
|  App       | Sheet:Column |           |
|  App       | %dynamicVar% |           |

* **openApp**

**Description**: This function is used to open the given application from your system.

**Input Format** : @App Name [if the path is available in the 'path' environment variable]
or App Location.

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
|  App       | @value       |           |
|  App       | Sheet:Column |           |
|  App       | %dynamicVar% |           |

* **closeApp**

**Description**:This function is used to close any application opened by using the openApp action.

**Input Format** : @App Name or App Location

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
|  App       | @value       |           |
|  App       | Sheet:Column |           |
|  App       | %dynamicVar% |           |

* **focusApp**

**Description**: This function is used to focus any application opened by using openApp action. 

**Input Format** : @App Name or App Location

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
|  App       | @value       |           |
|  App       | Sheet:Column |           |
|  App       | %dynamicVar% |           |

* **keyboardKey**

**Description**: This function is used to perform single keyboard key events.

**Input Format** : @Keyboard_Key(like Enter,Shift,Ctrl)

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
|  App       | @value       |           |
|  App       | Sheet:Column |           |
|  App       | %dynamicVar% |           |

* **pageDown**

**Description**: This function is used to perform page down actions for desired number of times.

**Input Format** : @No of page down(integer)

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
|  App       | @value       |           |
|  App       | Sheet:Column |           |
|  App       | %dynamicVar% |           |

* **clickOn**

**Description**: This function is used to perform click operations on text.

**Input Format** : @Text, which needs to be clicked.

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| App        | @value       |           |
| App        | Sheet:Column |           |
| App        | %dynamicVar% |           |

### **<u>Drag and Drop</u>**

* **imgDragandDrop**

**Description**: This function is used to drag any image and drop it on another image on the screen.

**Input Format** : @Page Name,Image Object Name

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |

* **imgDragandDropAt**

**Description**: This function is used to drag an image and drop it in a user-defined region.

**Input Format**:@x coordinate,y coordinate,width,height (All integers)

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      | @value       |           |
| Image      | Sheet:Column |           |
| Image      | %dynamicVar% |           |
 
* **imgDrag**

**Description**: This function is used to drag any image from screen.

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      |              |           |

* **imgDropAt**

**Description**: This function is used to drop the dragged image on the given image object. Be sure that dragging is not already released.

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| Image      |              |           |

* **takeDesktopScreenShot**

**Description**:This function is used to take a screenshot of the entire screen, the screenshot includes the task bar as well if the task bar is visible

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| App        |              |           |
