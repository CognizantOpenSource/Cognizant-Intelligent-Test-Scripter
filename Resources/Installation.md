# Cognizant Intelligent Test Scripter

## How to Install

Make sure you have downloaded and extracted the `cognizant-intelligent-test-scripter-*-setup.zip` from [releases](https://github.com/CognizantQAHub/Cognizant-Intelligent-Test-Scripter/releases/latest)

> *installation_location* mentioned below is the location where you have extracted the zip

### Installing Browser Extensions

Chrome

 * [https://chrome.google.com/webstore/detail/cognizant-intelligent-tes/eghfogfdhadandcigjcccdfhlohcgljn?hl=en-US](https://chrome.google.com/webstore/detail/cognizant-intelligent-tes/eghfogfdhadandcigjcccdfhlohcgljn?hl=en-US)


Firefox

 * Open Firefox
 * Drag and drop the `cognizantits.xpi` which is located in `installation_location/Extensions/FireFox` into `Firefox` Browser
 
Internet Explorer

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

### Sikuli OCR support

If you are using Image Based Automation of `Cognizant Intelligent Test Scripter` and want to perform [OCR](https://en.wikipedia.org/wiki/Optical_character_recognition) related actions, then you have to download and configure the dependent files as explained below.

To enable Sikuli OCR support, required Tesseract language files should be added.

Download data files form here,
* [Data file for English v3.02](https://sourceforge.net/projects/tesseract-ocr-alt/files/tesseract-ocr-3.02.eng.tar.gz/download)

* [For other languages](https://github.com/tesseract-ocr/tesseract/wiki/Data-Files)


Create the below folder structure if not present

Windows :   
```
%APPDATA%\Sikulix\SikulixTesseract\tessdata
```

Mac :
```
~/Library/Application Support/Sikulix/SikulixTesseract/tessdata
```

Linux: 

```
~/.Sikulix/SikulixTesseract/tessdata
```

Extract `tesseract-ocr-3.02.eng.tar.gz`  

Copy the data-files from the extracted directory( `zip/tesseract-ocr/tessdata`) to the above created folder.

~~~Check out this [sikuli issue](https://answers.launchpad.net/sikuli/+faq/27090) for more details.~~~


