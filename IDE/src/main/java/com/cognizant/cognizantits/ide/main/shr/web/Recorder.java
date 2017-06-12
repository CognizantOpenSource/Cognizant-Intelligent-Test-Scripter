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
package com.cognizant.cognizantits.ide.main.shr.web;

import com.cognizant.cognizantits.datalib.component.TestStep;
import com.cognizant.cognizantits.datalib.or.common.ObjectGroup;
import com.cognizant.cognizantits.datalib.or.web.WebOR;
import com.cognizant.cognizantits.datalib.or.web.WebORObject;
import com.cognizant.cognizantits.datalib.or.web.WebORPage;
import com.cognizant.cognizantits.engine.support.methodInf.MethodInfoManager;
import com.cognizant.cognizantits.extension.conector.DataConnector;
import com.cognizant.cognizantits.extension.extensionPojo.addonObject.Prop;
import com.cognizant.cognizantits.extension.extensionPojo.addonObject.RecordObject;
import com.cognizant.cognizantits.extension.extensionPojo.heal.FindResults;
import com.cognizant.cognizantits.extension.server.ExtensionServer;
import com.cognizant.cognizantits.ide.main.mainui.AppMainFrame;
import com.cognizant.cognizantits.ide.util.Utility;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class Recorder {

    private static final Logger LOG = Logger.getLogger(Recorder.class.getName());

    WebORObject dummyObject;
    DataConnector dataConnector;
    WebOR webOR;

    private final AppMainFrame sMainFrame;

    public Recorder(AppMainFrame sMainFrame) {
        this.sMainFrame = sMainFrame;
        dummyObject = new WebORObject();
        dataConnector = new DataConnector() {
            @Override
            public void onRecieve(RecordObject rObject) {
                try {
                    setValues(rObject);
                } catch (Exception ex) {
                    Logger.getLogger(Recorder.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onRecieve(FindResults rObject) {
                //
            }
        };
    }

    public void load() {
        this.webOR = sMainFrame.getProject().getObjectRepository().getWebOR();
    }

    public void start() {
        ExtensionServer.get().withDataReciever(dataConnector).startRecord();
    }

    public void stop() {
        ExtensionServer.get().withDataReciever(dataConnector).stop();
        sMainFrame.getTestDesign().getObjectRepo().getWebOR().getObjectTree().reload();
    }

    private void setValues(RecordObject rObject) {
        if (rObject.getType().equalsIgnoreCase("object")) {
            setValuesForObject(rObject);
        }
        addAsStep(rObject);
    }

    private void addAsStep(RecordObject rObject) {
        LOG.info(String.format("%s[%s] - %s - %s",
                rObject.getType(),
                rObject.getObjectname(),
                rObject.getMethod(),
                rObject.getInput()));

        String input = Objects.toString(rObject.getInput(), "");
        if (rObject.getMethod() == null) {
            rObject.setMethod("");
        }
        if (rObject.getMethod().equalsIgnoreCase("setencrypted")) {
            input = "@" + Utility.encrypt(input.substring(1));
        } else if (rObject.getMethod().equalsIgnoreCase("capturepagetimings")) {
            input = "@" + input.substring(1).replaceAll("[^a-zA-Z0-9-]", "_").replaceAll("__+", "_");
        }
        String objName = rObject.getType().equalsIgnoreCase("object") ? rObject.getObjectname() : rObject.getType();
        String description = getDescription(rObject.getMethod());
        String reference = rObject.getPage() != null ? rObject.getPage().getName() : "";
        addStep(objName, description, rObject.getMethod(), input, reference);
    }

    private String getDescription(String method) {
        return MethodInfoManager.getDescriptionFor(method);
    }

    public void addStep(String objectName, String description, String method, String data, String pageName) {
        TestStep lastStep = sMainFrame.getTestDesign().getTestCaseComp().getLastStep();
        TestStep testStep = new TestStep(sMainFrame.getTestDesign()
                .getTestCaseComp().getCurrentTestCase());
        testStep.setObject(objectName);
        testStep.setAction(method);
        testStep.setDescription(description);
        testStep.setInput(data);
        testStep.setReference(pageName);
        if (lastStep == null || !lastStep.isDuplicate(testStep)) {
            testStep.copyValuesTo(sMainFrame.getTestDesign().getTestCaseComp().addRow());
        }

    }

    private void setValuesForObject(RecordObject rObject) {
        dummyObject.setName(rObject.getObjectname());
        dummyObject.setFrame(Objects.toString(rObject.getFrame(), ""));
        for (Prop object : rObject.getProp()) {
            dummyObject.addNewAttribute(object.getProp());
            dummyObject.setAttributeByName(object.getProp(), Objects.toString(object.getVal(), ""));
        }
        saveObjectToRep(rObject);
    }

    private void saveObjectToRep(RecordObject rObject) {
        WebORPage page = webOR.getPageByTitle(rObject.getPage().getTitle());
        if (page == null) {
            String pageName = rObject.getPage().getName();
            int i = 1;
            while (webOR.getPageByName(pageName) != null) {
                pageName = rObject.getPage().getName() + i++;
            }
            page = webOR.addPage(pageName);
            page.setTitle(rObject.getPage().getTitle());
        }
        saveObjectToPage(page, rObject);
    }

    private void saveObjectToPage(WebORPage page, RecordObject rObject) {
        WebORObject dupObj = findDuplicate(page);
        if (dupObj == null) {
            String objName = Objects.toString(rObject.getObjectname(), "Object");
            int i = 1;
            while (page.getObjectGroupByName(objName) != null) {
                objName = rObject.getObjectname() + i++;
            }
            rObject.setObjectname(objName);
            rObject.getPage().setName(page.getName());
            WebORObject newObj = page.addObject(objName);
            dummyObject.clone(newObj);
            LOG.log(Level.INFO, "Object Added : {0}", objName);
        } else {
            rObject.setObjectname(dupObj.getName());
            rObject.getPage().setName(dupObj.getPage().getName());
            LOG.log(Level.WARNING, "Object Already Present\nPage : {0}\nObject : {1}", new Object[]{page.getName(), dupObj.getName()});
        }
    }

    private WebORObject findDuplicate(WebORPage page) {
        for (ObjectGroup<WebORObject> objectGroup : page.getObjectGroups()) {
            for (WebORObject object : objectGroup.getObjects()) {
                if (object.isEqualOf(dummyObject)) {
                    return object;
                }
            }
        }
        return null;
    }

}
