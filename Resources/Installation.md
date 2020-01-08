# Cognizant Intelligent Test Scripter

## How to Install

Make sure you have downloaded and extracted the `cognizant-intelligent-test-scripter-*-setup.zip` from [releases](https://github.com/CognizantQAHub/Cognizant-Intelligent-Test-Scripter/releases/latest)

> *installation_location* mentioned below is the location where you have extracted the zip

### Installing Browser Extensions

Chrome

 * [https://chrome.google.com/webstore/detail/cognizant-intelligent-tes/eghfogfdhadandcigjcccdfhlohcgljn?hl=en-US](https://chrome.google.com/webstore/detail/cognizant-intelligent-tes/eghfogfdhadandcigjcccdfhlohcgljn?hl=en-US)


Firefox

 * Open Firefox and check the version
 * If Firefox Version >= 66, Drag and drop the `cognizantits.xpi` which is located in `installation_location/Extensions/FireFox` into `Firefox` Browser
 * For Firefox older version, install the Patch Fix and Drag and drop the `cognizantits.xpi`
 
 Firefox Version | Patch Fix link
 ----------------|----------------
 47-56 | [Patch Fix for 47-56](https://addons.mozilla.org/en-US/firefox/addon/disabled-add-on-fix-52-56/)
 57-60 | [Patch Fox for 57-60](https://addons.mozilla.org/en-US/firefox/addon/disabled-add-on-fix-57-60/)
 61-65 | [Patch Fix for 61-65](https://addons.mozilla.org/en-US/firefox/addon/disabled-add-on-fix-61-65/)
  
  > [Refer this link for more details](https://blog.mozilla.org/addons/2019/05/04/update-regarding-add-ons-in-firefox/)
  
 
Internet Explorer
 
 * If you have older version of CITS IE Toolbar installed in the machine, uninstall the older version of CITS IE Toolbar.
 
 * Download the Latest version of [CITS_IE_Toolbar from here](https://github.com/CognizantQAHub/Cognizant-Intelligent-Test-Scripter-IE-Toolbar/releases/latest)

 * Follow the Installation docs from [here](https://github.com/CognizantQAHub/Cognizant-Intelligent-Test-Scripter-IE-Toolbar#requirements)

### Installing Extension Certificate

Open the `Ext_Certificate.cer` file which is in `installation_location/Extensions` . 

For Windows

To install the Certificate, perform the following steps in the Certificate window that is displayed:
 * Click the Install Certificate button

 * Click the Next button and select Place all certificates in the following store.

 * Browse and select Trusted Root Certification Authorities

 * Click the Next button followed by Finish.

For Mac

 * Double-click `Ext_Certificate.cer`. This will bring up the Keychain Access utility. Enter your password to unlock it.

 * Be sure you add the certificate to the System keychain, not the login keychain. Click "Always Trust," even though this doesn't seem to do anything.

 * After it has been added, double-click it. You may have to authenticate again.

 * Expand the "Trust" section.

 * "When using this certificate," set to "Always Trust"

 * Or Open Terminal and then enter 

 ```
 sudo security add-trusted-cert -d -r trustRoot -k /Library/Keychains/System.keychain Ext_Certificate.cer
 ```

## Launching UI

For Windows

Double Click the `Run.bat` to launch the UI

For Mac

Open Terminal in the installation location and then type

`chmod +x Run.command`

Double Click the `Run.command` to launch the UI

If you see **It's Downloaded From Internet Warning** then enter the following command in terminal

`xattr -d -r com.apple.quarantine /path/to/cognizant-intelligent-test-scripter`

In case of Mac, replace the drivers in `/path/to/cognizant-intelligent-test-scripter/lib/Drivers` location with the corresponding binaries for Mac OS. Also mention the path of the same in the `Configuration --> Browser Configuration` window in CITS IDE. 

For example, in case of chrome driver, please remove the `.exe` from the `ChromeDriverPath` property in the `Configure Browsers` window.

For Linux

* [Refer this link to work with CITS tool on Linux Platform](https://cognizantqahub.github.io/Cognizant-Intelligent-Test-Scripter-Helpdoc/faq/linux.html)

### Sikuli OCR support

If you are using Image Based Automation of `Cognizant Intelligent Test Scripter` and want to perform [OCR](https://en.wikipedia.org/wiki/Optical_character_recognition) related actions, then you have to download and configure the dependent files for Mac and Linux Platform

To enable Sikuli OCR support, required Tesseract 4.1.0 OCR files should be added.

Mac :

* [Refer the link to install Tesseract 4.1.0](https://github.com/RaiMan/SikuliX1/wiki/macOS-Linux:-Support-libraries-for-Tess4J-Tesseract-4-OCR)

The Tesseract files will be available in the below location

```
~/Library/Application Support/Sikulix/SikulixTesseract/tessdata
```

Linux: 

* [Refer these link to install opencv](https://sikulix-2014.readthedocs.io/en/latest/newslinux.html#getting-the-opencv-support-ready)
* [Refer the link to install Tesseract 4.1.0](https://github.com/RaiMan/SikuliX1/wiki/macOS-Linux:-Support-libraries-for-Tess4J-Tesseract-4-OCR)

The Tesseract files will be available in the below location

```
~/.Sikulix/SikulixTesseract/tessdata
```

Windows :

In Windows, tesseract 4.1.0 files will be automatically loaded in the below location

```	
%APPDATA%\Roaming\Sikulix\SikulixTesseract\tessdata	
```

=======
###  Demo Project Details


**AccessibilityActions Test case:**  Execute this test case against chrome browser to understand the accessibility actions supported by CITS, out of the box

**AngularJS_Test:** Execute this test case against any browser. Objects in this test case are identified through "ngwebdriver" api integrated with CITS

**DemoTestcase:** Covers basic automation flow in the URL "http://toolsqa.com/automation-practice-form/"

**Iterations&SubIterations:** Demonstrates the usage of iterating the same test steps for multiple sets of test data from datasheet

**LayoutTesting:** Demonstrates basic Galen actions that can be executed against any web browser

**DBTest:** Demonstrates database testing actions available in CITS

**ChromeEmulator_Iphone5:** Execute against the browser "Emulator_Iphone5". Navigate to "Configure Browsers" to know about this emulator

**Iphone5_UserAgent:** Execute against the browser "Iphone5_UA". Navigate to "Configure Browsers" to know about this emulator

**WebFlow_ChromeRWD:**  Execute against the browser "ChromeRWD". Navigate to "Configure Browsers" to know about this emulator

**image_Web:** Demonstrates the usage of basic image actions in CITS. Execute this test case against a browser and there are chances of failure due to resolution mismatches, hence please update the corresponding image object taken from your machine.

**WindowsAppUsingSikuli:** Covers a basic flow in calculator app. Execute this test case against "No browser" option and there are chances of failure due to resolution mismatches, hence please update the corresponding image object taken from your machine.

**Mobile_Browser:** Covers a basic smoke flow to test mobile browsers. Create an emulator for mobile browser execution employing the necessary desired capabilities required by Appium in order to execute this test case.

**Mobile_Native:** Covers a basic smoke flow to test Android Calculator application. Create an emulator for mobile native app execution employing the necessary desired capabilities required by Appium in order to execute this test case.

**WebPagePerformanceTesting:** Demonstrates the use of the action "capturePageTimings" to perform web page performance testing


~~~Check out this [sikuli issue](https://answers.launchpad.net/sikuli/+faq/27090) for more details.~~~



