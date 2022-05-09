/*
 * Copyright 2014 - 2019 Cognizant Technology Solutions
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
package com.cognizant.cognizantits.ide.main.mainui.components.testdesign.testcase.validation;

import com.cognizant.cognizantits.datalib.component.Scenario;
import com.cognizant.cognizantits.datalib.component.TestStep;
import com.cognizant.cognizantits.datalib.or.common.ORPageInf;
import com.cognizant.cognizantits.engine.support.methodInf.MethodInfoManager;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;
import java.util.Objects;
import javax.swing.JComponent;

/**
 *
 *
 */
public class ActionRenderer extends AbstractRenderer {

    final String actionNotPresent = "Action not avaliable/Not a valid action";
    final String reusableNotPresent = "Reusable is not avaliable in the Project";

    public ActionRenderer() {
        super("Action Shouldn't be empty.It should be either an action or Reusable");
    }

    @Override
    public void render(JComponent comp, TestStep step, Object value) {
        if (!step.isCommented()) {
            if (isEmpty(value)) {
                setEmpty(comp);
            } else if (step.isReusableStep()) {
                if (isReusablePresent(step)) {
                    setDefault(comp);
                } else {
                    setNotPresent(comp, reusableNotPresent);
                }
            } else if (step.isWebserviceStartStep()) {
                setWebserviceStart(comp);
            } else if (step.isWebserviceStopStep()) {
                setWebserviceStop(comp);
            } else if ((step.isWebserviceRequestStep())) {
                setWebserviceRequest(comp);
            } else if (isActionValid(step, value)) {
                setDefault(comp);
            } else {
                setNotPresent(comp, actionNotPresent);
            }
        } else {
            setDefault(comp);
        }
    }

    private Boolean isReusablePresent(TestStep step) {
        String[] data = step.getReusableData();
        Scenario scenario = step.getProject().getScenarioByName(data[0]);
        if (scenario != null) {
            return scenario.getTestCaseByName(data[1]) != null;
        }
        return false;
    }

    private String getDesc(Object value) {
        String val = MethodInfoManager.getDescriptionFor(
                value.toString());
        return val.isEmpty() ? null : val;
    }

    private Boolean isActionValid(TestStep step, Object value) {
        String action = Objects.toString(value, "").trim();
        String objectName = step.getObject();
        Boolean valid = false;

        switch (objectName) {
            case "Execute":
                valid = true;
                break;
            case "Browser":
                valid = MethodInfoManager.getMethodListFor(ObjectType.BROWSER)
                        .contains(action);
                break;
            case "App":
                valid = MethodInfoManager.getMethodListFor(ObjectType.APP)
                        .contains(action);
                break;
            case "Database":
                valid = MethodInfoManager.getMethodListFor(ObjectType.DATABASE)
                        .contains(action);
                break;
            case "ProtractorJS":
                valid = MethodInfoManager.getMethodListFor(ObjectType.PROTRACTORJS)
                        .contains(action);
                break;
	    case "Webservice":
                valid = MethodInfoManager.getMethodListFor(ObjectType.WEBSERVICE)
                        .contains(action);
                break;	
            default:
                if (isImageObject(step)) {
                    valid = MethodInfoManager.getMethodListFor(ObjectType.IMAGE)
                            .contains(action);
                } else if (isWebObject(step)) {
                    valid = MethodInfoManager.getMethodListFor(ObjectType.SELENIUM, ObjectType.WEB).contains(action);
                } else if (isMobileObject(step)) {
                    valid = MethodInfoManager.getMethodListFor(ObjectType.SELENIUM, ObjectType.MOBILE).contains(action);
                }
                break;
        }

        if (!valid) {
            valid = MethodInfoManager.getMethodListFor(ObjectType.ANY)
                    .contains(action);
        }
        return valid;
    }

    private boolean isImageObject(TestStep step) {
        ORPageInf page = step.getProject().
                getObjectRepository().getImageOR().getPageByName(step.getReference());
        return page != null && page.getObjectGroupByName(step.getObject()) != null;
    }

    private boolean isWebObject(TestStep step) {
        ORPageInf page = step.getProject().
                getObjectRepository().getWebOR().getPageByName(step.getReference());
        return page != null && page.getObjectGroupByName(step.getObject()) != null;
    }

    private boolean isMobileObject(TestStep step) {
        ORPageInf page = step.getProject().
                getObjectRepository().getMobileOR().getPageByName(step.getReference());
        return page != null && page.getObjectGroupByName(step.getObject()) != null;
    }
}
