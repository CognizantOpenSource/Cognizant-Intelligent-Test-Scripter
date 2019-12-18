Steps to install CITS Chrome and IE Add-on:
==========================================

Chrome
========
1- cognizantits.crx file is used only for Test case debugging. Drag and drop .crx file on chrome browser is not supported.
2- launch this link "https://chrome.google.com/webstore/detail/cognizant-intelligent-tes/eghfogfdhadandcigjcccdfhlohcgljn" in chrome and click on "Add to Chrome"

CITS IE Add-on
================

1- Uninstall the older version of CITS IE Toolbar

2- Download the latest release from this GitHub link "https://github.com/CognizantQAHub/Cognizant-Intelligent-Test-Scripter-IE-Toolbar/releases" and install


Steps to install certificate:
============================

Chrome and Internet Explorer
================================

1-launch Ext_Certificate.cert file.

2-Click on the install certificate option.

3-Navigate to next and choose option "Place all certificates in the following store".

4-Browse and choose "Trusted Root Certification Authorities".

5-Click on the next and finish it



Firefox
========

1-Launch Cognizant Intelligent Test Scripter and open either Spy,Heal or Recorder.

2-Launch firefox browser and navigate to Options>Advanced>Certificates.

3-Select the option "Select one automatically".

4-Click on View Certificate,navigate to Servers and then click on Add exception.

5-Give the URL as https://localhost:8887.

6-Click on the "Get Certificate" and "Confirm Security Exception".

7-In case you are facing any challenges adding the security certificate ,make sure to perform following operations:
	a)Open Internet Options.
	b)Navigate to Connections>Lan Settings>Advanced
	c)In the exceptions area add "localhost".
	d)Save the settings and again try to add certificate.
