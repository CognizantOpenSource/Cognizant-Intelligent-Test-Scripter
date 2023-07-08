## **Layout Validation**

----------------------------------------------
!!! Documentation on this is currently in progress

-----------------------------------------------



### **<u>CSS properties</u>**

* **assertElementCssPropEquals**

**Description**: This function will validate if the specified Css Property for an element is equal to the user-provided value. 

**Syntax** :

| ObjectName | Input               | Condition |
|------------|---------------------|-----------|
| ObjectName | @Css Property value |           |

**Example:**

| ObjectName | Input             | Condition |
|------------|-------------------|-----------|
| ObjectName | @font-size 17 px  |           |

* **assertElementCssPropContains**

**Description**: This function will validate if the specified Css Property for an element contains the user-provided value.

**Syntax** :

| ObjectName | Input               | Condition |
|------------|---------------------|-----------|
| ObjectName | @Css Property value |           |

**Example:**

| ObjectName | Input                    | Condition |
|------------|--------------------------|-----------|
| ObjectName | @font-family sans-serif  |           |

* **assertElementCssPropEndsWith**

**Description**: This function will validate if the specified Css Property for an element ends with the user-provided value.

**Syntax** :

| ObjectName | Input               | Condition |
|------------|---------------------|-----------|
| ObjectName | @Css Property value |           |

**Example:**

| ObjectName | Input             | Condition |
|------------|-------------------|-----------|
| ObjectName | @font-size 17 px  |           |

* **assertElementCssPropMatches**

**Description**: This function will validate if the specified Css Property for an element matches with the user-provided value. User can use regular expression also in input field.

**Syntax** :

| ObjectName | Input               | Condition |
|------------|---------------------|-----------|
| ObjectName | @Css Property value |           |

**Example:**

| ObjectName | Input                    | Condition |
|------------|--------------------------|-----------|
| ObjectName | @font-family (.)Arial(.) |           |

* **assertElementCssPropStartsWith**

**Description**: This function will validate if the specified Css Property for an element begins with the user-provided value.

**Syntax** :

| ObjectName | Input               | Condition |
|------------|---------------------|-----------|
| ObjectName | @Css Property value |           |

**Example:**

| ObjectName | Input                    | Condition |
|------------|--------------------------|-----------|
| ObjectName | @font-family Helvetica   |           |

### **<u>On</u>**

* **assertElementOnTopLeft**

**Description**: TThis function verifies if the element is moved from another element from a specified corner. Visually it could be considered as if one element is placed at the top left of another element.

**Input Format** : Locations

**Syntax** :

| ObjectName        | Input               | Condition            |
|-------------------|---------------------|----------------------|
| PrimaryObjectName | @Parameter          | SecondaryObjectName |

**Example:**

| ObjectName | Input                       | Condition     |
|------------|-----------------------------|---------------|
| Label      | @20 px left, 10 px bottom   | user picture  |

**NOTE**: To avoid typing the name of the secondary object, you can simply drag the
object and drop the object from the OR(Object Repository) in to the Condition
Column.

* **assertElementOnTopRight**

**Description**: This function verifies if the element is moved from another element from a specified corner. Visually it could be considered as if one element is placed at the top right of another element.

**Input Format** : Locations

**Syntax** :

| ObjectName        | Input        | Condition            |
|-------------------|--------------|----------------------|
| PrimaryObjectName | @Parameter   | SecondaryObjectName  |

**Example:**

| ObjectName | Input                       | Condition     |
|------------|-----------------------------|---------------|
| item1      | @20 px left, 10 px bottom   | item2         |

* **assertElementOnBottomLeft**

**Description**: This function verifies if the element is moved from another element from a specified corner. Visually it could be considered as if one element is placed at the bottom left of another element

**Input Format** : Locations

**Syntax** :

| ObjectName        | Input        | Condition            |
|-------------------|--------------|----------------------|
| PrimaryObjectName | @Parameter   | SecondaryObjectName  |

**Example:**

| ObjectName | Input                       | Condition     |
|------------|-----------------------------|---------------|
| item1      | @20 px left, 10 px bottom   | item2         |

* **assertElementOnBottomRight**

**Description**:  This function verifies if the element is moved from another element from a specified corner. Visually it could be considered as if one element is placed at the bottom right of another element.

**Syntax** :

| ObjectName        | Input        | Condition            |
|-------------------|--------------|----------------------|
| PrimaryObjectName | @Parameter   | SecondaryObjectName |

**Example:**

| ObjectName | Input                       | Condition     |
|------------|-----------------------------|---------------|
| item1      | @20 px left, 10 px bottom   | item2         |

### **<u>Centered</u>**

* **assertElementCenteredAInside**

**Description**: It allows to verify if the element is completely centered within another element with the user-defined error rate. Useful in case of responsive Web Design applications.

**Input Format** : Range or empty

**Syntax** :

| ObjectName        | Input        | Condition            |
|-------------------|--------------|----------------------|
| PrimaryObjectName | @Parameter   | SecondaryObjectName  |

**Example:**

| ObjectName | Input  | Condition |
|------------|--------|-----------|
| Button     |        | Box       |
| Button     | @10px  | Box       |

* **assertElementCenteredAOn**

**Description**: It allows to verify that the element is completely centered on top of another element with user-defined error rate. Useful in case of responsive Web Design applications.

**Input Format** : Range or empty

**Syntax** :

| ObjectName        | Input        | Condition            |
|-------------------|--------------|----------------------|
| PrimaryObjectName | @Parameter   | SecondaryObjectName  |

**Example:**

| ObjectName | Input  | Condition |
|------------|--------|-----------|
| Button     |        | Box       |
| Button     | @10px  | Box       |

* **assertElementCenteredHOn**

**Description**: It allows to verify if the element is horizontally centered on top of another element with the user-defined error rate. Useful in case of responsive Web Design applications.

**Input Format** : Range or empty

**Syntax** :

| ObjectName        | Input        | Condition            |
|-------------------|--------------|----------------------|
| PrimaryObjectName | @Parameter   | SecondaryObjectName  |

**Example:**

| ObjectName | Input  | Condition |
|------------|--------|-----------|
| Button     |        | Box       |
| Button     | @10px  | Box       |

* **assertElementCenteredHInside**

**Description**: It allows to verify if the element is horizontally centered within another element with the user-defined error rate. Useful in case of responsive Web Design applications.

**Input Format** : Range or empty

**Syntax** :

| ObjectName        | Input        | Condition            |
|-------------------|--------------|----------------------|
| PrimaryObjectName | @Parameter   | SecondaryObjectName  |

**Example:**

| ObjectName | Input  | Condition |
|------------|--------|-----------|
| Button     |        | Box       |
| Button     | @10px  | Box       |

* **assertElementCenteredVOn**

**Description**: It allows to verify if the element is vertically centered on top of another element with the user-defined error rate. Useful in case of responsive Web Design applications.

**Input Format** : Range or empty

**Syntax** :

| ObjectName        | Input        | Condition            |
|-------------------|--------------|----------------------|
| PrimaryObjectName | @Parameter   | SecondaryObjectName  |

**Example:**

| ObjectName | Input  | Condition |
|------------|--------|-----------|
| Button     |        | Box       |
| Button     | @10px  | Box       |

* **assertElementCenteredVInside**

**Description**:This function will validate if the given image matches with the speci

**Input Format** : Image file location

**Syntax** :

| ObjectName        | Input        | Condition            |
|-------------------|--------------|----------------------|
| PrimaryObjectName | @Parameter   | SecondaryObjectName  |

**Example:**

| ObjectName | Input  | Condition |
|------------|--------|-----------|
| Button     |        | Box       |
| Button     | @10px  | Box       |

### **<u>Image</u>**

* **assertElementImage**

**Description**: This function is used to add a user-defined variable with a desired value and the scope of this variable is till the end of the test case in which it is defined

**Syntax** :

| ObjectName         | Input        | Condition   |
|--------------------|--------------|-------------|
| ObjectToBeCompared | @Parameter   |             |

**Example:**

* The step given below will compare object on the screen pixel to pixel with image imagefolder/image1.png and will notify if the amount of mismatching pixel is higher than 10 pixels that is allowed maximum.

| ObjectName | Input                                      | Condition |
|------------|--------------------------------------------|-----------|
| Item1      | @file imagefolder/image1.png, error 10 px  |           |

* You can also change the assertion from absolute pixels values to percentage.

| ObjectName | Input                                      | Condition |
|------------|--------------------------------------------|-----------|
| Item1      | @file imagefolder/image1.png, error 4%     |           |

* When comparing images of different sizes, we place one image on top of another and assume that the missing pixels are of black color. You can change this behavior by stretching the image to 

| ObjectName | Input                                          | Condition |
|------------|------------------------------------------------|-----------|
| Item1      | @file imgs/menu-item-1.png, error 4%, stretch  |           |

* You can also define an area which should be used from the sample image as given below. The area parameter takes 4 values: left, top, width, and height.

| ObjectName | Input                                                   | Condition |
|------------|---------------------------------------------------------|-----------|
| Item1      | @file imgs/menu-item-1.png, error 4%, area 10 10 100 30 |           |

* Sometimes you may have different images for different browsers and this will break all your tests. For such cases, you can define different image samples in one step as given below.

| ObjectName | Input                                                   | Condition |
|------------|---------------------------------------------------------|-----------|
| Item1      | @file imagefolder/image1.png, imagefolder/image2.png,   |           |
|            | imagefolder/image3.png, error 20 px                     |           |
 
* Sometimes you may want to apply some filters to compared images to have a smarter image comparison. For an instance, you can apply blur to images. This might be handy if the compared image has generated noise. Or, you can also apply denoise 

| ObjectName | Input                                                                | Condition |
|------------|----------------------------------------------------------------------|-----------|
| Item1      | @file item-1.png, error 1%,filter saturation 0, map-filter denoise 5 |           |

* If you want to apply filter only to the original image, you can use filter-a expression as given below. 

| ObjectName | Input                                                   | Condition |
|------------|---------------------------------------------------------|-----------|
| Item1      | @file imgs/item-1.png, filter-a blur 10, error 4%       |           |

* If you want to apply a specific filter only to a sample image, you can use filter-b expression as given below.

| ObjectName | Input                                                          | Condition |
|------------|----------------------------------------------------------------|-----------|
| Item1      | @file imgs/login-button.png, filter-b contrast 200, error 4%   |           | 

**Following will happen as a result of this check**:

 	* Cognizant Intelligent Test Scripter takes both images and applies blur filter with radius 4.
	
	* It applies saturation filter with Level 0. That is, complete loss of color and change of images color to Grey.
	
    * It compares the image and builds a comparison map.
	
    * After these operations, it applies denoise filter with radius 5 pixels and removes noise from the generated map.
	
    * After all these operations, it counts the mismatching pixels.
	
**List of all available image filters**

** blur < radius>** - Blurs the image with the given radius of blur.

**saturation < level>** -Removes the colors with the given level. Zero value means complete loss of colors. At 100 value all the colors are left the same. At Level 50 the image is colored by half.

**contrast < level>** - Increases the contrast. The allowed range for level is between 0 to 258.

**denoise < radius>** - Removes noise from image. It is applicable only as a map-filter as it only works with black/white images. 

**quantinize < colorsAmount>** - Makes less colors on the image.

### **<u>Align</u>**

* **assertElementAlignedHoriz**

**Description**: This function will validate Horizontal Alignment of an object with another object.

**Input Format** : alignment error rate in px 

**Syntax** :

| ObjectName        | Input        | Condition            |
|-------------------|--------------|----------------------|
| PrimaryObjectName | @Parameter   | SecondaryObjectName  |

**Example:**

| ObjectName | Input     | Condition |
|------------|-----------|-----------|
| item1      | @all      | item2     |
| item1      | @all 10px | item2     |

| ObjectName     | Input     | Condition |
|----------------|-----------|-----------|
| PrimaryObject  | @top      | item2     |
| PrimaryObject  | @top 10px | item2     |

| ObjectName | Input          | Condition |
|------------|----------------|-----------|
| item1      | @bottom        | item2     |
| item1      | @bottom 10px   | item2     |
| item1      | @centered      | item2     |
| item1      | @centered 10px | item2     |

* **assertElementAlignedVert**

**Description**: This function will validate the Vertical Alignment of an object with another object.

**Input Format** : alignment error rate in px.

**Syntax:** 

| ObjectName        | Input        | Condition            |
|-------------------|--------------|----------------------|
| PrimaryObjectName | @Parameter   | SecondaryObjectName  |

**Example:**

| ObjectName    | Input       | Condition       |
|---------------|-------------|-----------------|
| item1         | @all        | item2           |
| item1         | @all 10px   | item2           |
| PrimaryObject | @left       | SecondaryObject |
| PrimaryObject | @left 10px  | SecondaryObject |

| ObjectName | Input          | Condition |
|------------|----------------|-----------|
| item1      | @right         | item2     |
| item1      | @right 10px    | item2     |
| item1      | @centered      | item2     |
| item1      | @centered 10px | item2     |

### **<u>Near</u>**

* **assertElementNear**

**Description**: This function will validate if the specified element is placed near another element.

**Input Format** :Locations

**Syntax:** 

| ObjectName        | Input        | Condition            |
|-------------------|--------------|----------------------|
| PrimaryObjectName | @Parameter   | SecondaryObjectName  |

**Example:**

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| textfield  | @10 px left  | button    |

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| button     | @10 px right | textfield |

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| textfield  | @5 px top    | button    |

| ObjectName | Input        | Condition |
|------------|--------------|-----------|
| button     | @5 px bottom | textfield |

| ObjectName  | Input              | Condition |
|-------------|--------------------|-----------|
| textfield   | @5 px bottom left  | button    |

| ObjectName  |  Input            | Condition  |
|-------------|-------------------|------------|
| button      |  @5 px top right  | textfield  |

| ObjectName | Input               | Condition |
|------------|---------------------|-----------|
| textfield  |@5 px top, 10 px left| button    |

### **<u>Pagedump</u>**

* **createPageDump**

**Description** :This function will create page dump for the user specified page. 

**Input Format** : PageName from ObjectRepository.

**Syntax:** 

| ObjectName | Input                       | Condition |
|------------|-----------------------------|-----------|
| Browser    | @PageNameInObjectRepository |           |

**Example:**

| ObjectName | Input    | Condition |
|------------|----------|-----------|
| Browser    | @Sample  |           |

### **<u>Contains</u>**

* **highlight**

**Description**:  This function will validate if specified element has a list of specified elements.

**Input Format** : Color in hexcode like **@#ff44ff**. If it is left empty red will be taken as default.

**Syntax:** 

| ObjectName | Input | Condition                            |
|------------|-------|--------------------------------------|
| Browser    |       | SecondarObjectName/RegularExpression |

**Example:**

*To check if an element contains another element

| ObjectName | Input | Condition |
|------------|-------|-----------|
| item1      |       | item2     |

*To check if an element contains more than one elements

| ObjectName | Input | Condition                |
|------------|-------|--------------------------|
| item1      |       | (item2 or item2 or item3)|

*You can also use asterisk to match all other objects. For if we have an object
menu and in it there other object like: menu-item1, menu-item2, menu-item3

| ObjectName | Input | Condition |
|------------|-------|-----------|
| menu       |       | item-(.*) |

* **assertElementContainsPartly**

**Description**: This function is used when an element is not completely within another element.

**Syntax:** 

| ObjectName | Input | Condition                            |
|------------|-------|--------------------------------------|
| Browser    |       | SecondarObjectName/RegularExpression |

**Example:**

| ObjectName | Input | Condition                |
|------------|-------|--------------------------|
| item1      |       | item2                    |
| item1      |       | (item1 or item2 or item3)|
| menu       |       | item-(.*)                |

### **<u>ColorScheme</u>**

* **assertElementColorScheme**

**Description**: This function verifies color distribution on object area. Galen takes a picture and then calculates the object’s area color spectrum so that you can later verify the usage for specific colors.

**Input Format** : @Expected color distribution.

**Syntax:**

| ObjectName | Input       | Condition |
|------------|-------------|-----------|
| ObjectName | @Parameter  |           |

**Example:**

| ObjectName | Input                                   | Condition |
|------------|-----------------------------------------|-----------|
| ObjectName | @50% white, 4 to 5 % black, 30% #f845b7 |           |

### **<u>Inside</u>**

* **assertElementInsidePartly**

**Description**: This function will validate if the specified element is placed partly within another element.

**Input Format** : Locations

**Syntax:** 

| ObjectName    | Input      | Condition       |
|---------------|------------|-----------------|
| PrimaryObject | @Parameter | SecondaryObject |

**Example:**

| ObjectName | Input           | Condition |
|------------|-----------------|-----------|
| button     |                 | box       |
| button     | @10 px top      | container |
| button     | @10 px bottom   | container |
| button     | @10 px left     | container |
| button     | @10 px right    | container |
| button     | @10 px top left | container |

| ObjectName | Input                               | Condition |
|------------|-------------------------------------|-----------|
| button     | @10 px left right, 20 px top bottom | container |

* **assertElementInside**

**Description**:  This function will validate if the specified element lies within another element.

**Input Format** : Locations

**Syntax:** 

| ObjectName    | Input      | Condition       |
|---------------|------------|-----------------|
| PrimaryObject | @Parameter | SecondaryObject |

**Example:**

| ObjectName | Input           | Condition |
|------------|-----------------|-----------|
| button     |                 | box       |

| ObjectName | Input           | Condition |
|------------|-----------------|-----------|
| button     | @10 px top      | container |
| button     | @10 px bottom   | container |
| button     | @10 px left     | container |
| button     | @10 px right    | container |
| button     | @10 px top left | container |

| ObjectName | Input                               | Condition |
|------------|-------------------------------------|-----------|
| button     | @10 px left right, 20 px top bottom | container |

### **<u>Direction</u>**

* **assertElementAbove**

**Description**: This function will validate if an element is present above another element.

**Input Format** :Range [optional]

**Syntax:** 

| ObjectName    | Input      | Condition       |
|---------------|------------|-----------------|
| PrimaryObject | @Parameter | SecondaryObject |

**Example:**

| ObjectName | Input  | Condition            |
|------------|--------|----------------------|
| caption    | @15 px | Secondary ObjectName |

* **assertElementBelow**

**Description**: This function will validate if an element is below another element.

**Input Format** :Range [optional]

**Syntax:** 

| ObjectName    | Input      | Condition       |
|---------------|------------|-----------------|
| PrimaryObject | @Parameter | SecondaryObject |

**Example:**

| ObjectName | Input  | Condition            |
|------------|--------|----------------------|
| caption    | @15 px | Secondary ObjectName |

* **assertElementLeftOf**

**Description**: This function will validate if the specified element is placed to the left of another element.

**Input Format** : Range in px 

**Syntax:** 

| ObjectName | Input      | Condition       |
|------------|------------|-----------------|
| Browser    | @Parameter | SecondaryObject |

**Example:**

| ObjectName | Input  | Condition            |
|------------|--------|----------------------|
| caption    | @10 px | Secondary ObjectName |

* **assertElementRightOf**

**Description**:  This function will validate if the specified element is placed at the right of another element.

**Syntax:** 

| ObjectName | Input      | Condition       |
|------------|------------|-----------------|
| Browser    | @Parameter | SecondaryObject |

**Example:**

| ObjectName | Input  | Condition            |
|------------|--------|----------------------|
| caption    | @10 px | Secondary ObjectName |

### **<u>Width and Height</u>**

* **assertElementWidthElement**

**Description**: This function will validate the width of the specified object with respect to the width of another element.

**Input Format** : @Parameter

**Syntax:** 

| ObjectName     | Input      | Condition                           |
|----------------|------------|-------------------------------------|
| Primary Object | @Parameter | Secondary Objectname/screen/viewport |
| Primary Object | @50 px     | Secondary Objectname                |

* **assertElementHeightElement**

**Description**: This function will validate the height of the specified object with respect to the height of another element.

Input Format : Range in %

**Syntax:** 

| ObjectName     | Input      | Condition                            |
|----------------|------------|--------------------------------------|
| Primary Object | @Parameter | Secondary Objectname/screen/viewport |
| Primary Object | @50%       | Secondary Objectname                 |
 
* **assertElementWidth**

**Description**: This function will verify the width of an object with an user provided data.

**Input Format** :@Parameter

**Syntax:** 

| ObjectName     | Input      | Condition |
|----------------|------------|-----------|
| Primary Object | @Parameter |           |

**Example:**

| ObjectName | Input  | Condition |
|------------|--------|-----------|
| ObjectName | @50 px |           |

* **assertElementHeight**

**Description**: This function will verify the height of an object with an expected data.

**Input Format** : @Parameter

**Syntax:** 

| ObjectName     | Input      | Condition |
|----------------|------------|-----------|
| Primary Object | @Parameter |           |

**Example:**

| ObjectName        | Input  | Condition |
|-------------------|--------|-----------|
| PrimaryObjectName | @50 px |           |
