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
package com.cognizant.cognizantits.qcconnection.qualitycenter;

import com4j.Com4jObject;
import java.io.File;
import java.util.List;
import com.cognizant.cognizantits.qcconnection.qcupdation.ClassFactory;
import com.cognizant.cognizantits.qcconnection.qcupdation.IAttachment;
import com.cognizant.cognizantits.qcconnection.qcupdation.IAttachmentFactory;
import com.cognizant.cognizantits.qcconnection.qcupdation.IBaseFactory;
import com.cognizant.cognizantits.qcconnection.qcupdation.IExtendedStorage;
import com.cognizant.cognizantits.qcconnection.qcupdation.IList;
import com.cognizant.cognizantits.qcconnection.qcupdation.IRun;
import com.cognizant.cognizantits.qcconnection.qcupdation.IRunFactory;
import com.cognizant.cognizantits.qcconnection.qcupdation.ITDConnection4;
import com.cognizant.cognizantits.qcconnection.qcupdation.ITSTest;
import com.cognizant.cognizantits.qcconnection.qcupdation.ITestSet;
import com.cognizant.cognizantits.qcconnection.qcupdation.ITestSetFactory;
import com.cognizant.cognizantits.qcconnection.qcupdation.ITestSetFolder;
import com.cognizant.cognizantits.qcconnection.qcupdation.ITestSetTreeManager;

public class QualityCenter {

    public ITDConnection4 QClogin(String Url, String LoginID, String Password, String Domain, String Project) {
        ITDConnection4 itdc = ClassFactory.createTDConnection();
        itdc.initConnectionEx(Url);
        itdc.login(LoginID, Password);
        itdc.connect(Domain, Project);

        if (itdc.connected()) {
            System.out.println("QC Login Successful");
        } else {
            System.out.println("QC Login Failed");
        }
        return itdc;
    }

    public boolean QCUpdateTCStatus(ITDConnection4 QCloginObj, String TestSetPath, String TSName, String SCName, String TCName, String TCPrefix, String RunName, String Status, List<File> attach) {

         TCName = TCPrefix + TCName;
        ITestSetTreeManager testsettreemanager
                = (ITestSetTreeManager) QCloginObj.testSetTreeManager().queryInterface(ITestSetTreeManager.class);
        ITestSetFolder testsetfolder = null;
        try {
            testsetfolder
                    = (ITestSetFolder) testsettreemanager.nodeByPath(TestSetPath).queryInterface(ITestSetFolder.class);
        } catch (Exception ex) {
            System.out.println("ERROR : Invalid TestSet Path - [" + TestSetPath
                    + "] !");
            return false;
        }
        if (testsetfolder.path() != null) {
            ITestSetFactory testsetfactory
                    = (ITestSetFactory) testsetfolder.testSetFactory().queryInterface(ITestSetFactory.class);
            IList TestSetList = testsetfactory.newList("");
            boolean TCFound = false;
            boolean TSFound = false;
            for (Com4jObject obj : TestSetList) {
                ITestSet testset
                        = (ITestSet) obj.queryInterface(ITestSet.class);
                if (testset.name().contentEquals(TSName)) {
                    TSFound = true;
                    IBaseFactory obj2 = (IBaseFactory) testset.tsTestFactory().queryInterface(IBaseFactory.class);
                    IList tstestlist = obj2.newList("");
                    for (Com4jObject obj3 : tstestlist) {
                        ITSTest tstest = (ITSTest) obj3.queryInterface(ITSTest.class);
                        if (tstest.name().contentEquals(TCName)) {
                            TCFound = true;
                            IRunFactory runfactory = (IRunFactory) tstest.runFactory().queryInterface(
                                    IRunFactory.class);
                            IRun run = (IRun) runfactory.addItem(RunName).queryInterface(IRun.class);
                            IAttachmentFactory attachfac = (IAttachmentFactory) run.attachments().queryInterface(
                                    IAttachmentFactory.class);
                            if (!attach.isEmpty()) {
                                System.out.println("INFO :  Uploading Attachments!");
                                for (File toUpload : attach) {
                                    try {
                                        IAttachment attach2 = (IAttachment) attachfac.addItem(toUpload.getName()).queryInterface(
                                                IAttachment.class);
                                        attach2.post();
                                        IExtendedStorage extnd2 = (IExtendedStorage) attach2.attachmentStorage().queryInterface(
                                                IExtendedStorage.class);
                                        extnd2.clientPath(toUpload.getParentFile().getAbsolutePath());
                                        extnd2.save(toUpload.getName(), true);
                                        System.out.println("INFO :  Uploaded - "+toUpload.getName());
                                    } catch (Exception ex) {
                                        System.out.println("ERROR :  Unable to Load Attachment  - ["
                                                + toUpload.getName()
                                                + "] !");
                                        return false;
                                    }
                                }
                            } else {
                                System.out.println("INFO :  No Attachments to Upload!");
                            }
                            run.status(Status);
                            run.post();
                        }
                    }
                }
            }
            if ((TSFound) && (TCFound)) {
                return true;
            }
            if (!TSFound) {
                System.out.println("Not Fount : TestSet Name - [" + TSName
                        + "] !");
            }
            if (!TCFound) {
                System.out.println("Not Fount : TestCase Name - [" + TCName
                        + "] !");
            }
            return false;
        }
        System.out.println("Not Fount : TestSet Path - [" + TestSetPath
                + "] !");
        return false;
    }
}
