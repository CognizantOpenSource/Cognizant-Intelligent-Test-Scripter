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
package com.cognizant.cognizantits.engine.commands;

import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;

final class WebButton extends Command {

	/*
	 * Methods for different actions WebButton
	 */
	public WebButton(CommandControl cc) {
		super(cc);
	}

	@Action(object = ObjectType.SELENIUM, desc ="Object [<Object> is enabled]")
	public void isEnabled() {

		if (Element != null) {
			if (Element.isEnabled()) {
				Report.updateTestLog("isEnabled",
						"Web Element is enabled", Status.PASS);
			} else {
				Report.updateTestLog("isEnabled",
						"Web Element is not enabled", Status.FAIL);
			}
		} else {
			Report.updateTestLog("isEnabled", "Element not found", Status.FAIL);
		}

	}

}
