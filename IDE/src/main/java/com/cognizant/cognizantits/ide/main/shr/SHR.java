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
package com.cognizant.cognizantits.ide.main.shr;

import com.cognizant.cognizantits.extension.server.ExtensionServer;
import com.cognizant.cognizantits.ide.main.mainui.AppMainFrame;
import com.cognizant.cognizantits.ide.main.shr.image.ImageSpy;
import com.cognizant.cognizantits.ide.main.shr.mobile.MobileObjectSpy;
import com.cognizant.cognizantits.ide.main.shr.web.ObjectHeal;
import com.cognizant.cognizantits.ide.main.shr.web.ObjectSpy;
import com.cognizant.cognizantits.ide.main.shr.web.Recorder;
import com.cognizant.cognizantits.ide.settings.AppSettings;

public class SHR {

    private final ObjectHeal objHeal;

    private final ObjectSpy objSpy;

    private final Recorder recorder;

    private final ImageSpy imageSpy;

    private final MobileObjectSpy mobileObjectSpy;

    public SHR(AppMainFrame sMainFrame) {
        objHeal = new ObjectHeal(sMainFrame);
        objSpy = new ObjectSpy(sMainFrame);
        recorder = new Recorder(sMainFrame);
        mobileObjectSpy = new MobileObjectSpy(sMainFrame);
        imageSpy = new ImageSpy(sMainFrame);
    }

    public void load() {
        objHeal.load();
        objSpy.load();
        recorder.load();
        mobileObjectSpy.load();
        imageSpy.load();
    }

    public void showObjectSpy() {
        if (objHeal.isVisible()) {
            objHeal.closeWindow();
        }
        if (objSpy.isVisible()) {
            objSpy.setState(ObjectSpy.NORMAL);
        } else {
            objSpy.pack();
            objSpy.setLocation(0, 0);
            objSpy.setSize(300, objSpy.getHeight() - 40);
            startServer();
            objSpy.start();
            objSpy.setVisible(true);
        }
    }

    public void showObjectHeal() {
        if (objSpy.isVisible()) {
            objSpy.closeWindow();
        }
        if (objHeal.isVisible()) {
            objHeal.setState(ObjectHeal.NORMAL);
        } else {
            objHeal.pack();
            objHeal.setLocation(0, 0);
            objHeal.setSize(400, objHeal.getHeight() - 40);
            startServer();
            objHeal.start();
            objHeal.setVisible(true);
        }
    }

    public void showMobileSpy() {
        if (mobileObjectSpy.isVisible()) {
            mobileObjectSpy.setState(MobileObjectSpy.NORMAL);
        } else {
            mobileObjectSpy.setLocationRelativeTo(null);
            mobileObjectSpy.setLocation(mobileObjectSpy.getLocation().x, 0);
            mobileObjectSpy.setVisible(true);
            mobileObjectSpy.reloadEmulators();
        }
    }

    public void showImageSpy() {
        if (imageSpy.isVisible()) {
            imageSpy.setState(ImageSpy.NORMAL);
        } else {
            imageSpy.showImageSpy();
            imageSpy.toFront();
        }
    }

    public void startRecorder() {
        if (objHeal.isVisible()) {
            objHeal.closeWindow();
        }
        if (objSpy.isVisible()) {
            objSpy.closeWindow();
        }
        startServer();
        recorder.start();
    }

    public void stopRecorder() {
        recorder.stop();
    }

    public void stopServerIfAny() {
        ExtensionServer.get().stop();
    }

    private void startServer() {
        int port = Integer.valueOf(AppSettings.get(AppSettings.APP_SETTINGS.ADDON_PORT.getKey()));
        ExtensionServer.get().startOn(port);
    }

}
