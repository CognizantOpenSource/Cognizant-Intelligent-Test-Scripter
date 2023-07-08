# **Troubleshooting**
-------------------------------

## Error in Connection

Follow the below steps for such scenario:

**Checking Connection status and establishing the same**

**For Chrome and Firefox:**

Follow the steps below to troubleshoot the "error in Connection" error message, 
 
 * Open the **options window, right-click** the add-on to launch options window in **chrome** and use the shortcut **Ctrl+Shift+O** in firefox for the same.

 * Launch **spy or heal or record** from the IDE 

 * Click on **Test Connection**, use the default port **8887**, this port can also be changed as per your choice.

 * If you are getting a **red bulb**, the certificate is not installed properly, so click on the bulb again, you will be navigated to the url **https://localhost:8887/status**, you need to give "**Proceed to unsafe**" in chrome and **Add exception** in Firefox to get to this link

 * If you do not get this message then you need to install the certificates manually.


> **NOTE**: A green bulb indicates that the connection between browser extension and the UI is established and is working fine.

------------------------------------------

## Unable To Open The Tool After Introducing Your Custom Method

This happens when the **cognizant-intelligent-test-scripter-engine-<version_number>.jar** found in **Cognizant Intelligent Test Scripter
installation_location/lib**, gets corrupted while exporting the **cognizant-intelligenttest-scripter-engine-<version_number>.jar** back from **Engine** or while inject script is performed. You might get an exception stating that **main class not found**.

To overcome this issue, always take a backup of the **cognizant-intelligent-testscripter-engine-<version_number>.jar** before you export the jar from **Engine**. So even when the jar is corrupt you can still replace the existing jar by the new one. Also do not change the name of the **cognizant-intelligent-test-scripter-engine-<version_number>.jar** available inside the lib folder.

Another alternative is to delete the **recent items** file present in the installation location when Cognizant Intelligent Test Scripter is closed and open again.

> **Note:** Please do not take the back up in the same location or inside the lib folder. Place it in a different location.

If you face this issue after performing inject script then delete the **.class file** of your custom method found in the **userdefined** folder of installation location and close and reopen.

> **Note:** This could also be because the **.jar** files present in the **location\lib\commands** might have got corrupted. So you can simply remove those files to open Cognizant Intelligent Test Scripter.



**How To Hard Code Java Path Variable For Cognizant Intelligent Test Scripter**

> It is possible to hard code the java path in the **Run.bat** file.Refer the section below on how it can be done.

**Prerequisites**

Following must be installed in your system:

 * Cognizant Intelligent Test Scripter setup

 * Java

 **How to do it?**

 * Navigate to the location where **Cognizant Intelligent Test Scripter** is installed in your system.

 * Right-click the **Run** batch file.

 * Click the edit option in the context menu.

 * Give the path of the **jre** location under the **'SET PATH'** like this, **SET PATH="C:\Program Files\Java\jdk1.x.x_xx\jre\bin"**.

 * Save the file.

 * Double-click the **Run.bat** file and launch Application.