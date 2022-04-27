/*
 * Copyright 2014 - 2017 Cognizant Technology Solutions
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cognizant.cognizantits.engine.commands.protractorjs;

import com.cognizant.cognizantits.engine.core.RunManager;
import com.cognizant.cognizantits.engine.execution.run.TestCaseRunner;
import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.datalib.or.common.ORAttribute;
import com.cognizant.cognizantits.engine.commands.General;
import com.cognizant.cognizantits.engine.constants.FilePath;
import com.cognizant.cognizantits.engine.constants.SystemDefaults;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

/**
 *
 * @author 501942
 */
public class ProtractorCommands extends General {

	private StringBuilder sb;
	TestCaseRunner cntx;
	private static final Map<String, String> TEMPLATE = new HashMap<>();

	static {

		TEMPLATE.put("ng-bind", "by.binding('%s')");
		TEMPLATE.put("ng-model", "by.model('%s')");
		TEMPLATE.put("ng-repeat", "by.repeater('%s')");
		TEMPLATE.put("ng-options", "by.options('%s')");
		TEMPLATE.put("class", "by.className('%s')");
		TEMPLATE.put("css", "by.css('%s')");
		TEMPLATE.put("id", "by.id('%s')");
		TEMPLATE.put("link_text", "by.linkText('%s')");
		TEMPLATE.put("name", "by.name('%s')");
		TEMPLATE.put("type", "by.tagname('%s')");
		TEMPLATE.put("xpath", "by.xpath('%s')");
		TEMPLATE.put("relative_xpath", "by.xpath('%s')");

		TEMPLATE.put("buttonText", "by.buttonText('%s')");
		TEMPLATE.put("partialButtonText", "by.partialButtonText('%s')");
		TEMPLATE.put("cssContainingText", "by.cssContainingText('%s','%s')");
		TEMPLATE.put("ng-options", "by.options('%s')");
		TEMPLATE.put("deepCss", "by.deepCss('%s')");

	}

	public ProtractorCommands(CommandControl cc) {
		super(cc);
		cntx = ((TestCaseRunner) cc.context()).getRoot();
		if (!cntx.getVarMap().containsKey("protractorCommands")) {
			cntx.getVarMap().put("protractorCommands", new StringBuilder());
		}
		sb = (StringBuilder) cntx.getVarMap().get("protractorCommands");
	}

	static final Pattern INPUTS = Pattern.compile("([^{]+?)(?=\\})");

	@Action(object = ObjectType.PROTRACTORJS, desc = "initialize the ProtractorJS script/spec")

	public void protractor_initialize() {
		try {

			sb.append(String.format("describe('%s', function() {it('should be created', async function() { \r\n"
					+ "await browser.driver.manage().window().maximize();", cntx.getTestCase().getName()));

			Report.updateTestLog(Action, "Command to initialize the protractor spec script", Status.PASSNS);

		} catch (Exception e) {
			Report.updateTestLog(Action, "Command to initialize the protractor spec script", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Command to open an url", input = InputType.YES)
	public void protractor_open() {
		try {
			String resolved = resolveTestData(Input);
			sb.append(String.format("await browser.get('%s'); \n", resolved));

			Report.updateTestLog(Action, "Open URL \"" + resolved + "\"", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Open URL ", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Command to send text to web element", input = InputType.YES)
	public void protractor_set() {
		try {
			String resolved = resolveTestData(Input);
			String property = resolveproperty();

			sb.append(String.format("await element(%s).sendKeys('%s'); \n", resolveObjectProperty(property), resolved));

			Report.updateTestLog(Action, "Set " + ObjectName + " with a value \"" + resolved + "\"", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Set " + ObjectName + " with a value ", Status.FAILNS);

		}
	}

	@Action(object = ObjectType.WEB, desc = "Command to click on web element")
	public void protractor_click() {
		try {
			String property = resolveproperty();
			sb.append(String.format("await element(%s).click(); \n", resolveObjectProperty(property)));

			System.out.println("commadn " + sb.toString());
			Report.updateTestLog(Action, "Click on " + ObjectName, Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Click on " + ObjectName, Status.FAILNS);
		}
	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Enable/Disable Protractor to wait for Angular $http and $timeout tasks", input = InputType.YES)
	public void protractor_waitForAngularEnabled() {
		try {
			String resolved = resolveTestData(Input);
			sb.append(String.format("await browser.waitForAngularEnabled(%s); \n", resolved));

			Report.updateTestLog(Action, "Enable/Disable Protractor to wait for Angular $http and $timeout tasks",
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Enable/Disable Protractor to wait for Angular $http and $timeout tasks",
					Status.FAILNS);
		}
	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Restart the executing browser session")
	public void protractor_browserRestart() {
		try {
			sb.append(String.format("await browser.restart(); await browser.driver.manage().window().maximize(); "));

			Report.updateTestLog(Action, "Restart Browser", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Restart Browser", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Refresh the current page")
	public void protractor_refresh() {
		try {
			sb.append(String.format("await browser.refresh(); \n"));

			Report.updateTestLog(Action, "Instruct webdriver to refresh page", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Instruct webdriver to refresh page", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Instruct webdriver to perform sleep operation for given time", input = InputType.YES)
	public void protractor_sleep() {
		try {
			String resolved = resolveTestData(Input);
			sb.append(String.format("await browser.sleep(%s); \n", resolved));

			Report.updateTestLog(Action, "Instruct webdriver to perform sleep operation for " + resolved + "ms",
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Instruct webdriver to perform sleep operation ", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Get the page source of the current page")
	public void protractor_browserGetPageSource() {
		try {

			sb.append(String.format(
					"var src = await browser.getPageSource();console.log('Page source code is - ' + src);  \n"));

			Report.updateTestLog(Action, "Get the page source of the current page", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Get the page source of the current page", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Instruct webdriver to perform browser close action")
	public void protractor_browserClose() {
		try {
			sb.append(String.format("await browser.close(); \n"));

			Report.updateTestLog(Action, "Instruct webdriver to perform browser close action", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Instruct webdriver to perform browser close action", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Get the URL of the current page")
	public void protractor_getCurrentUrl() {
		try {

			sb.append(String
					.format("var url = await browser.getCurrentUrl(); console.log('Current URL is - ' + url);  \n"));

			Report.updateTestLog(Action, "Get the URL of the current page", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Get the URL of the current page", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Get the title of the current page")
	public void protractor_getTitle() {
		try {

			sb.append(String
					.format("var title = await browser.getTitle();  console.log('Current Title is - ' + title); \n"));

			Report.updateTestLog(Action, "Get the title of the current page", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Get the title of the current page", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Take screenshot of the current page", input = InputType.YES)
	public void protractor_takeScreenshot() {
		try {

			File Rfile = new File(FilePath.getCurrentResultsPath() + File.separator + "ProtractorImages");
			if (!Rfile.exists()) {
				if (Rfile.mkdir()) {
					// System.out.println("Img folder created" + Rfile.getAbsolutePath());
				}

			}

			String screenshot_path = Rfile.getAbsoluteFile() + File.separator + resolveTestData(Input);
			screenshot_path = screenshot_path.replace("\\", "/");

			sb.append(String.format("var fs = require('fs'); \r\n"
					+ "        	function writeScreenShot(data, filename) {   \r\n"
					+ "        	var stream = fs.createWriteStream(filename); stream.write(new Buffer(data, 'base64')); stream.end();  \r\n"
					+ "        	}    \r\n" + "        	 \r\n"
					+ "        	await browser.takeScreenshot().then(function (png) {  \r\n"
					+ "        	writeScreenShot(png, '%s');     }); \n", screenshot_path));

			Report.updateTestLog(Action, "Screenshot taken and is available in the location " + screenshot_path,
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Take screenshot of the current page", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Assert if the element is present in the page")
	public void protractor_AssertElementPresent() {
		try {

			String property = resolveproperty();

			sb.append(String.format("var presence = await element(%s).isPresent(); \r\n" + "if(presence === true)\r\n"
					+ " console.log('The element " + ObjectName + " is actually present') ; \r\n" + "else\r\n"
					+ " console.log('The element " + ObjectName + " is actually absent'); "
					+ "await expect(presence).toBe(true);", resolveObjectProperty(property)));

			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is present in the page",
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is present in the page",
					Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Assert if the element is absent in the page")
	public void protractor_AssertElementAbsent() {
		try {

			String property = resolveproperty();

			sb.append(String.format("var presence = await element(%s).isPresent(); \r\n" + "if(presence === true)\r\n"
					+ " console.log('The element " + ObjectName + " is actually present') ; \r\n" + "else\r\n"
					+ " console.log('The element " + ObjectName + " is actually absent'); "
					+ "await expect(presence).toBe(false);", resolveObjectProperty(property)));

			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is absent in the page",
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is absent in the page",
					Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Get the id value of the element")
	public void protractor_getElementId() {
		try {

			String property = resolveproperty();

			sb.append(String.format(
					"var id = await element(%s).getId(); console.log('The element " + ObjectName + "ID  is - ' + id);",
					resolveObjectProperty(property)));

			Report.updateTestLog(Action, "Get the id value of the element", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Get the id value of the element", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Get the attribute value of element", input = InputType.YES)
	public void protractor_getElementAttribute() {
		try {
			String property = resolveproperty();

			String resolved = resolveTestData(Input);
			sb.append(String.format(
					"var attr = await element(%s).getAttribute('%s'); console.log('The Attribute value is - ' + attr); \n",
					resolveObjectProperty(property), resolved));

			Report.updateTestLog(Action, "Get the attribute- " + resolved + " value of element", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Get the given attribute value of element", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Get the text of the given element")
	public void protractor_getElementText() {
		try {
			String property = resolveproperty();

			sb.append(String.format(
					"var res = await element(%s).getText(); console.log('The element Text  is - ' + res);  \n",
					resolveObjectProperty(property)));

			Report.updateTestLog(Action, "Get the text of the given element", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Get the text of the given element", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Assert if the  element is enabled in the page")
	public void protractor_AssertElementEnabled() {
		try {

			String property = resolveproperty();

			sb.append(String.format("var enable = await element(%s).isEnabled();\r\n" + "if(enable === true)\r\n"
					+ "console.log('The element " + ObjectName + " is actually enabled') ;\r\n" + "else\r\n"
					+ "console.log('The element " + ObjectName + " is actually not enabled');\r\n"
					+ "await expect(enable).toBe(true);", resolveObjectProperty(property)));

			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is enabled in the page",
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is enabled in the page",
					Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Assert if the  element is not enabled in the page")
	public void protractor_AssertElementNotEnabled() {
		try {

			String property = resolveproperty();

			sb.append(String.format("var enable = await element(%s).isEnabled();\r\n" + "if(enable === true)\r\n"
					+ "console.log('The element " + ObjectName + " is actually enabled') ;\r\n" + "else\r\n"
					+ "console.log('The element " + ObjectName + " is actually not enabled');\r\n"
					+ "await expect(enable).toBe(false);", resolveObjectProperty(property)));

			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is not enabled in the page",
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is not enabled in the page",
					Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Check if the element is Selected in the page")
	public void protractor_AssertElementSelected() {
		try {

			String property = resolveproperty();

			sb.append(String.format("var select = await element(%s).isSelected();\r\n" + "if(select === true)\r\n"
					+ "console.log('The element " + ObjectName + " is actually selected') ;\r\n" + "else\r\n"
					+ "console.log('The element " + ObjectName + " is actually not selected');\r\n"
					+ "await expect(select).toBe(true);", resolveObjectProperty(property)));

			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is Selected in the page",
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is Selected in the page",
					Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Check if the element is not Selected in the page")
	public void protractor_AssertElementNotSelected() {
		try {

			String property = resolveproperty();

			sb.append(String.format("var select = await element(%s).isSelected();\r\n" + "if(select === true)\r\n"
					+ "console.log('The element " + ObjectName + " is actually selected') ;\r\n" + "else\r\n"
					+ "console.log('The element " + ObjectName + " is actually not selected');\r\n"
					+ "await expect(select).toBe(false);", resolveObjectProperty(property)));

			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is not Selected in the page",
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is not Selected in the page",
					Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Check if element is displayed")
	public void protractor_AssertElementDisplayed() {
		try {

			String property = resolveproperty();

			sb.append(String.format("var display= await element(%s).isDisplayed();\r\n" + "if(display === true)\r\n"
					+ "console.log('The element " + ObjectName + " is actually displayed') ;\r\n" + "else\r\n"
					+ "console.log('The element " + ObjectName + " is actually not displayed');\r\n"
					+ "await expect(display).toBe(true);", resolveObjectProperty(property)));

			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is displayed in the page",
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is displayed in the page",
					Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Check if element is not displayed")
	public void protractor_AssertElementNotDisplayed() {
		try {

			String property = resolveproperty();

			sb.append(String.format("var display= await element(%s).isDisplayed();\r\n" + "if(display === true)\r\n"
					+ "console.log('The element " + ObjectName + " is actually displayed') ;\r\n" + "else\r\n"
					+ "console.log('The element " + ObjectName + " is actually not displayed');\r\n"
					+ "await expect(display).toBe(false);", resolveObjectProperty(property)));

			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is not displayed in the page",
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Check if the element " + ObjectName + " is not displayed in the page",
					Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Submit the given element")
	public void protractor_submitElement() {
		try {
			String property = resolveproperty();

			sb.append(String.format("await element(%s).submit(); \n", resolveObjectProperty(property)));

			Report.updateTestLog(Action, "Submit the given element " + ObjectName, Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Submit the given element " + ObjectName, Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Clear the content of the given element")
	public void protractor_clearElement() {
		try {
			String property = resolveproperty();

			sb.append(String.format("await element(%s).clear(); \n", resolveObjectProperty(property)));

			Report.updateTestLog(Action, "Clear the content of the given element " + ObjectName, Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Clear the content of the given element " + ObjectName, Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Take screenshot of the given element", input = InputType.YES)
	public void protractor_takeElementScreenshot() {
		try {

			String property = resolveproperty();

			File Rfile = new File(FilePath.getCurrentResultsPath() + File.separator + "ProtractorImages");
			if (!Rfile.exists()) {
				if (Rfile.mkdir()) {
					// System.out.println("Img folder created" + Rfile.getAbsolutePath());
				}

			}

			String screenshot_path = Rfile.getAbsoluteFile() + File.separator + resolveTestData(Input);
			screenshot_path = screenshot_path.replace("\\", "/");

			sb.append(String.format("var fs = require('fs'); \r\n"
					+ "        	function writeScreenShot(data, filename) {   \r\n"
					+ "        	var stream = fs.createWriteStream(filename); stream.write(new Buffer(data, 'base64')); stream.end();  \r\n"
					+ "        	}    \r\n" + "        	 \r\n"
					+ "        	await element(%s).takeScreenshot().then(function (png) {  \r\n"
					+ "        	writeScreenShot(png, '%s');     }); \n", resolveObjectProperty(property),
					screenshot_path));

			Report.updateTestLog(Action, "Screenshot taken in the location " + screenshot_path, Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Take screenshot of the given element", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Wait for the alert to be present")
	public void protractor_alertToBePresent() {
		try {
			// only one input which is the waittime configuraiton>options

			sb.append(String.format(
					"await browser.wait(protractor.ExpectedConditions.alertIsPresent(), %s, 'There is no alert present'); \n",
					SystemDefaults.waitTime + "000"));

			Report.updateTestLog(Action, "Wait for the alert to be present", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Wait for the alert to be present", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Wait for element to be clickable")
	public void protractor_elementToBeClickable() {
		try {

			String property = resolveproperty();

			sb.append(String.format(
					"await browser.wait(protractor.ExpectedConditions.elementToBeClickable(element(%s)),%s, 'Element "
							+ ObjectName + " has not become clickable');",
					resolveObjectProperty(property), SystemDefaults.waitTime + "000"));

			Report.updateTestLog(Action, "Wait for element " + ObjectName + " to be clickable", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Wait for element " + ObjectName + " to be clickable", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Wait for the element to contain the given text", input = InputType.YES)
	public void protractor_textToBePresentInElement() {
		try {
			// only one input under input column which is the text

			String resolved = resolveTestData(Input);
			String property = resolveproperty();

			sb.append(String.format("console.log('Waiting for " + ObjectName + " text to be present' );"
					+ "await browser.wait(protractor.ExpectedConditions.textToBePresentInElement(element(%s),'%s'),%s, 'Element "
					+ ObjectName + "  does not contain the text');\r\n",

					resolveObjectProperty(property), resolved, SystemDefaults.waitTime + "000"));// set the time out

			Report.updateTestLog(Action, "Wait for the element " + ObjectName + " to contain the given text" + resolved,
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Wait for the element " + ObjectName + " to contain the given text",
					Status.FAILNS);
		}
	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Wait for the title of the page to contain", input = InputType.YES)
	public void protractor_titleContains() {
		try {
			// text is the only input
			String resolved = resolveTestData(Input);

			sb.append(String.format(
					"await browser.wait(protractor.ExpectedConditions.titleContains('%s'),%s, 'The title does not contain the text');",
					resolved, SystemDefaults.waitTime + "000"));

			Report.updateTestLog(Action, "Wait for the title of the page to contain the text" + resolved,
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Wait for the title of the page to contain the given text", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Wait for the title of the page to be equal to the given value", input = InputType.YES)
	public void protractor_titleIs() {
		try {

			String resolved = resolveTestData(Input);
			sb.append(String.format(
					"await browser.wait(protractor.ExpectedConditions.titleIs('%s'),%s, 'The title is not equal to the given text');",
					resolved, SystemDefaults.waitTime + "000"));

			Report.updateTestLog(Action, "Wait for the title of the page to be equal to the given value " + resolved,
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Wait for the title of the page to be equal to the given value",
					Status.FAILNS);
		}
	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Wait for the URL of the page to contain", input = InputType.YES)
	public void protractor_urlContains() {
		try {

			String resolved = resolveTestData(Input);
			sb.append(String.format(
					"await browser.wait(protractor.ExpectedConditions.urlContains('%s'),%s, 'The URL does not contain the given text');",
					resolved, SystemDefaults.waitTime + "000"));

			Report.updateTestLog(Action, "Wait for the URL of the page to contain the given text - " + resolved,
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Wait for the URL of the page to contain the given text", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Wait for the URL of the page to be equal to the given value", input = InputType.YES)
	public void protractor_urlIs() {
		try {

			String resolved = resolveTestData(Input);
			sb.append(String.format(
					"await browser.wait(protractor.ExpectedConditions.urlIs('%s'),%s, 'The URL is not equal to the given text');",
					resolved, SystemDefaults.waitTime + "000"));

			Report.updateTestLog(Action, "Wait for the URL of the page to be equal to the given value - " + resolved,
					Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Wait for the URL of the page to be equal to the given value", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Wait for the element to be present")
	public void protractor_presenceOfElement() {
		try {

			String property = resolveproperty();

			sb.append(String.format(
					"await browser.wait(protractor.ExpectedConditions.presenceOf(element(%s)),%s, 'The element "
							+ ObjectName + " is not present');",
					resolveObjectProperty(property), SystemDefaults.waitTime + "000"));

			Report.updateTestLog(Action, "Wait for the element to be present", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Wait for the element to be present", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Wait for the stalenees of the given element")
	public void protractor_stalenessOfElement() {
		try {

			String property = resolveproperty();

			sb.append(String.format(
					"await browser.wait(protractor.ExpectedConditions.stalenessOf(element(%s)),%s, 'Element "
							+ ObjectName + " is still present' );",
					resolveObjectProperty(property), SystemDefaults.waitTime + "000"));

			Report.updateTestLog(Action, "Wait for the stalenees of the given element", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Wait for the stalenees of the given element", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Wait for the element to be visible")
	public void protractor_visibilityOfElement() {
		try {
			String property = resolveproperty();

			sb.append(String.format(
					"await browser.wait(protractor.ExpectedConditions.visibilityOf(element(%s)),%s, 'The element  "
							+ ObjectName + " has become invisible');",
					resolveObjectProperty(property), SystemDefaults.waitTime + "000"));

			Report.updateTestLog(Action, "Wait for the element to be visible", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Wait for the element to be visible", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Wait for the element to be invisible")
	public void protractor_InvisibilityOfElement() {
		try {
			String property = resolveproperty();

			sb.append(String.format(
					"await browser.wait(protractor.ExpectedConditions.invisibilityOf(element(%s)),%s, 'The element "
							+ ObjectName + " has become visible');",
					resolveObjectProperty(property), SystemDefaults.waitTime + "000"));

			Report.updateTestLog(Action, "Wait for the element to be invisible", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Wait for the element to be invisible", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.WEB, desc = "Wait for the element to be Selected")
	public void protractor_elementToBeSelected() {
		try {

			String property = resolveproperty();
			sb.append(String.format(
					"await browser.wait(protractor.ExpectedConditions.elementToBeSelected(element(%s)),%s,'The element "
							+ ObjectName + " is not selected yet');",
					resolveObjectProperty(property), SystemDefaults.waitTime + "000"));

			Report.updateTestLog(Action, "Wait for the element to be Selected", Status.PASSNS);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Wait for the element to be Selected", Status.FAILNS);
		}
	}

	@Action(object = ObjectType.ANY, desc = "Execute the given javascript command on the window in focus", input = InputType.YES)
	public void protractor_executeScript() {
		try {
			if (ObjectName.equals("ProtractorJS")) {
				sb.append(String.format(
						"var res = await browser.executeScript('%s'); console.log('The result of Javascript expression' + res);",
						resolveTestData(Input)));
				Report.updateTestLog(Action, "Execute the given javascript command on the window in focus",
						Status.PASSNS);
			} else {
				String property = resolveproperty();
				sb.append(String.format("var el = await element(%s);", resolveObjectProperty(property)));
				sb.append(String.format(
						"var tag = await browser.executeScript('%s', el); console.log('The result of Javascript expression' + tag);",
						resolveTestData(Input)));
				Report.updateTestLog(Action, "Execute the given javascript command on the window in focus",
						Status.PASSNS);
			}

		} catch (Exception e) {
			Report.updateTestLog(Action, "Execute the given javascript command on the window in focus", Status.FAILNS);
		}

	}

	@Action(object = ObjectType.WEB, desc = "Switch to the frame which is defined as a frame element")
	public void protractor_switchToFrame() {
		try {
			String property = resolveproperty();
			sb.append(String.format("await browser.switchTo().frame(element(%s).getWebElement());",
					resolveObjectProperty(property)));
			Report.updateTestLog(Action, "Switch to the frame which is defined as a frame element", Status.PASSNS);

		} catch (Exception e) {
			Report.updateTestLog(Action, "Switch to the frame which is defined as a frame element", Status.FAILNS);
		}

	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Switch to the default content")
	public void protractor_switchToDefaultContent() {
		try {
			sb.append(String.format("await browser.switchTo().defaultContent();"));
			Report.updateTestLog(Action, "Switch to the default content", Status.PASSNS);

		} catch (Exception e) {
			Report.updateTestLog(Action, "Switch to the default content", Status.FAILNS);
		}

	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Switch to alert and print the alert text")
	public void protractor_getAlertText() {
		try {
			sb.append(String.format(
					"var text = await browser.switchTo().alert().getText();console.log('The alert text is - ' + text);"));
			Report.updateTestLog(Action, "Switch to alert and print the alert text", Status.PASSNS);

		} catch (Exception e) {
			Report.updateTestLog(Action, "Switch to alert and print the alert text", Status.FAILNS);
		}

	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Switch to alert and dismiss it")
	public void protractor_dismissAlert() {
		try {
			sb.append(String.format("await browser.switchTo().alert().dismiss();"));
			Report.updateTestLog(Action, "Switch to alert and dismiss it", Status.PASSNS);

		} catch (Exception e) {
			Report.updateTestLog(Action, "Switch to alert and dismiss it", Status.FAILNS);
		}

	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Switch to alert and accept it")
	public void protractor_acceptAlert() {
		try {
			sb.append(String.format("await browser.switchTo().alert().accept();"));
			Report.updateTestLog(Action, "Switch to alert and accept it", Status.PASSNS);

		} catch (Exception e) {
			Report.updateTestLog(Action, "Switch to alert and accept it", Status.FAILNS);
		}

	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Switch to alert and answer it", input = InputType.YES)
	public void protractor_answerAlert() {
		try {
			sb.append(String.format("await browser.switchTo().alert().sendKeys('%s');", resolveTestData(Input)));
			Report.updateTestLog(Action, "Switch to alert and answer it", Status.PASSNS);

		} catch (Exception e) {
			Report.updateTestLog(Action, "Switch to alert and answer it", Status.FAILNS);
		}

	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Create Your own customised Protractor Spec file", input = InputType.YES, condition = InputType.YES)
	public void protractor_customSpec() {// define ur custom spec file script content under input column and spec file
											// name under condition column

		try {

			File file = new File(RunManager.getGlobalSettings().getProjectPath() + File.separator + Condition);

			// System.out.println("File is created!");
			FileUtils.writeStringToFile(file, resolveTestData(Input));

			Report.updateTestLog(
					Action, "Spec file created in the following path - "
							+ RunManager.getGlobalSettings().getProjectPath() + File.separator + Condition,
					Status.PASSNS);
		} catch (Exception e) {

			Report.updateTestLog(Action, "Error in trying to create a custom spec file", Status.FAILNS);
		}

	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Command to Run an External Spec File ", input = InputType.YES)
	public void RunExternalConfig() throws IOException, InterruptedException {
		// user needs to give external config file name and ensure that location is same
		// as - inside project

		try {

			SessionId s = ((RemoteWebDriver) Driver).getSessionId();

			Random rand = new Random();

			int n = rand.nextInt(50) + 1;

			String config_file_path = "cd " + RunManager.getGlobalSettings().getProjectPath();

			File logfile = new File(
					RunManager.getGlobalSettings().getProjectPath() + File.separator + n + "Results.log");

			String command = "protractor  " + resolveTestData(Input) + " --seleniumSessionId=" + s.toString() + " > "
					+ n + "Results.log";

			String mac_command = "protractor " + "\"" + RunManager.getGlobalSettings().getProjectPath() + File.separator
					+ resolveTestData(Input) + "\"" + " --seleniumSessionId=" + s.toString() + " > " + "\""
					+ logfile.getAbsolutePath() + "\"";

			String OS = null;
			OS = System.getProperty("os.name");
			File tempScript = null;

			if (OS.toUpperCase().contains("WINDOWS")) {
				Process p = Runtime.getRuntime().exec("cmd /c " + config_file_path + " && " + command);
				p.waitFor();
			} else if (OS.toUpperCase().contains("MAC")) {
				String npmpath = getUserDefinedData("PATHNAME");
				tempScript = createTempScript(npmpath, mac_command);
				ProcessBuilder pb = new ProcessBuilder("bash", tempScript.toString());
				pb.inheritIO();
				Process p = pb.start();
				p.waitFor();

			}

			String logmessage = FileUtils.readFileToString(logfile);
			File proresults = new File(FilePath.getCurrentResultsPath() + File.separator + "ProtractorConsole_"
					+ resolveTestData(Input) + ".txt");
			if (!proresults.exists()) {
				proresults.createNewFile();
			}
			FileUtils.copyFile(logfile, proresults);

			if (org.apache.commons.lang3.StringUtils.containsIgnoreCase(logmessage, "0 failures")) {
				Report.updateTestLog(Action,
						"Spec file execution completed successfully - Full execution report available here - "
								+ proresults.getAbsolutePath(),
						Status.PASSNS);
			} else {
				Report.updateTestLog(Action, "Spec file executed completed -  Full execution report available here - "
						+ proresults.getAbsolutePath(), Status.FAILNS);
			}
			logfile.delete();
		} catch (Exception e) {

			Report.updateTestLog("RunExternalConfig", e.getMessage(), Status.FAILNS);
		}

	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Terminate the ProtractorJS script", input = InputType.YES)

	public void protractor_terminate() {
		try {

			sb.append("await browser.close(); \n");
			sb.append("});});");

			File SpecReport = new File(FilePath.getCurrentResultsPath() + File.separator + "ProtractorSpecs");
			if (!SpecReport.exists()) {
				if (SpecReport.mkdir()) {
					// System.out.println("Spec folder created " + SpecReport.getAbsolutePath());
				}

			}

			File file = new File(
					RunManager.getGlobalSettings().getProjectPath() + File.separator + resolveTestData(Input));

			File DestFile = new File(SpecReport.getAbsolutePath() + File.separator + resolveTestData(Input));

			// System.out.println("File is created!");
			FileUtils.writeStringToFile(file, sb.toString());

			sb.setLength(0);

			FileUtils.copyFile(file, DestFile);

			Report.updateTestLog(Action, "Spec file created in project location - " + SpecReport.getAbsolutePath(),
					Status.PASSNS);
		} catch (Exception e) {

			Report.updateTestLog(Action, "Error in trying to create spec file", Status.FAILNS);
		}

	}

	@Action(object = ObjectType.PROTRACTORJS, desc = "Command to execute above commands created in a spec file through ProtractorJS", input = InputType.YES)
	public void RunSpec() throws IOException, InterruptedException {
		try {

			// user provides the name of the spec file - ,custom or what CITS created, to
			// run
			// ensure that spec file location whose name is given under input column, is
			// inside the project location

			// code to copy config form configuraiton in to project if not done already
			Random rand = new Random();

			int n = rand.nextInt(50) + 1;

			String srcfile = FilePath.getConfigurationPath() + File.separator + "conf.js";
			String desfile = RunManager.getGlobalSettings().getProjectPath() + File.separator + "conf" + n + ".js";

			File file1 = new File(srcfile);
			File file2 = new File(desfile);

			File logfile = new File(
					RunManager.getGlobalSettings().getProjectPath() + File.separator + n + "Results.log");

			// needed for mac

			if (!logfile.exists()) {
				logfile.createNewFile();
			}

			if (!file2.exists()) {
				FileUtils.copyFile(file1, file2);
			}

			// code to update the config file in destination with user given spec file
			String des = "specs: ['" + resolveTestData(Input) + "']";

			FileUtils.writeStringToFile(file2, FileUtils.readFileToString(file2).replaceAll("specs:.*", des));

			String config_file_path = "cd " + RunManager.getGlobalSettings().getProjectPath();

			SessionId s = ((RemoteWebDriver) Driver).getSessionId();

			String command = "protractor  " + "conf" + n + ".js" + " --seleniumSessionId=" + s.toString() + " > " + n
					+ "Results.log";

			String mac_command = "protractor " + "\"" + RunManager.getGlobalSettings().getProjectPath() + File.separator
					+ "conf" + n + ".js" + "\"" + " --seleniumSessionId=" + s.toString() + " > " + "\""
					+ logfile.getAbsolutePath() + "\"";

			String OS = null;
			OS = System.getProperty("os.name");
			File tempScript = null;

			if (OS.toUpperCase().contains("WINDOWS")) {
				Process p = Runtime.getRuntime().exec("cmd /c " + config_file_path + "&&" + command);
				p.waitFor();
			}

			if (OS.toUpperCase().contains("MAC")) {
				String npmpath = getUserDefinedData("PATHNAME");
				tempScript = createTempScript(npmpath, mac_command);
				ProcessBuilder pb = new ProcessBuilder("bash", tempScript.toString());
				pb.inheritIO();
				Process p = pb.start();
				p.waitFor();

			}

			String logmessage = FileUtils.readFileToString(logfile);
			File proresults = new File(FilePath.getCurrentResultsPath() + File.separator + "ProtractorConsole_"
					+ resolveTestData(Input) + ".txt");
			if (!proresults.exists()) {
				proresults.createNewFile();
			}

			FileUtils.copyFile(logfile, proresults);

			if (org.apache.commons.lang3.StringUtils.containsIgnoreCase(logmessage, "0 failures")) {
				Report.updateTestLog(Action,
						"Spec file execution completed successfully - Full execution report available here - "
								+ proresults.getAbsolutePath(),
						Status.PASSNS);
			} else {
				Report.updateTestLog(Action, "Spec file executed completed -  Full execution report available here - "
						+ proresults.getAbsolutePath(), Status.FAILNS);
			}

			if (logfile != null && logfile.exists())
				logfile.delete();

			if (file2 != null && file2.exists())
				file2.delete();

			if (tempScript != null && tempScript.exists())
				tempScript.delete();

			File file = new File(
					RunManager.getGlobalSettings().getProjectPath() + File.separator + resolveTestData(Input));
			if (file != null && file.exists())
				file.delete();

		} catch (Exception e) {

			Report.updateTestLog("Runprotractorspec", e.getMessage(), Status.FAILNS);
		}
	}

	private File createTempScript(String npmpath, String protcmd) throws IOException {
		File tempScript = File.createTempFile("script", null);
		Writer streamWriter = new OutputStreamWriter(new FileOutputStream(tempScript));
		PrintWriter printwriter = new PrintWriter(streamWriter);

		printwriter.println("#!/bin/bash");
		printwriter.println("echo $PATH");
		printwriter.println("PATH=$PATH:" + npmpath);
		printwriter.println("echo $PATH");

		printwriter.println(protcmd);
		printwriter.close();
		return tempScript;

	}

	private String resolveTestData(String testdata) {

		if (!testdata.startsWith("@")) {
			if (testdata.contains("%")) {
				return getVar(testdata);

			} else if ((testdata.contains(":") & testdata.split(":").length == 2)) {
				String[] sheet = testdata.split(":");
				return userData.getData(sheet[0], sheet[1]);
			}
		}

		return testdata.substring(1);
	}

	private String resolveObjectProperty(String property) {
		if (!TEMPLATE.get(property).isEmpty()) {

			if (TEMPLATE.get(property).equals("by.cssContainingText('%s','%s')"))
				return String.format(TEMPLATE.get(property),
						AObject.getWebObject(Reference, ObjectName).getAttributeByName(property).split(",")[0],
						AObject.getWebObject(Reference, ObjectName).getAttributeByName(property).split(",")[1]);

			return String.format(TEMPLATE.get(property),
					AObject.getWebObject(Reference, ObjectName).getAttributeByName(property));
		} else {
			return null;
		}

	}

	private String resolveproperty() {
		List<ORAttribute> proprties = AObject.getWebObject(Reference, ObjectName).getAttributes();
		for (ORAttribute E : proprties) {
			// System.out.println("the name is " + E.getName() + "the value is " +
			// E.getValue());
			if (E.getValue() != null & !E.getValue().isEmpty()) {
				return E.getName();
			}

		}

		return null;

	}
}
