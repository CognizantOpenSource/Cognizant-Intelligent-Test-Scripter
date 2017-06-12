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
package com.cognizant.cognizantits.ide.main.shr.mobile.ios;

import com.cognizant.cognizantits.ide.main.shr.mobile.MobileUtil;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * 
 */
public class IOSUtil extends MobileUtil {

    @Override
    public void setScreenShotImageToLabelWResize(String base64Image) {
        super.setScreenShotImageToLabelWResize(base64Image);
    }

    @Override
    public ImageIcon getScreenShotImage() {
        setIOSScaleFactor(img);
        return super.getScreenShotImage();
    }

    private double iosScaleFactor;
    private static IOSUtil iosUtil;

    public static IOSUtil get() {
        if (iosUtil == null) {
            iosUtil = new IOSUtil();
        }
        return iosUtil;
    }

    public double getScaleFactor() {
        return iosScaleFactor * scaleFactor;
    }

    public void setIOSScaleFactor(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        if (width == 640 && height == 960) {
            // portrait 3.5" iphone with retina display
            iosScaleFactor = 2.0f;
        } else if (width == 960 && height == 640) {
            // landscape 3.5" iphone with retina display
            iosScaleFactor = 2.0f;
        } else if (width == 640 && height == 1136) {
            // portrait 4" iphone with retina display
            iosScaleFactor = 2.0f;
        } else if (width == 1136 && height == 640) {
            // landscape 4" iphone with retina display
            iosScaleFactor = 2.0f;
        } else if (width == 750 && height == 1334) {
            // portrait iphone 6
            iosScaleFactor = 2.0f;
        } else if (width == 1334 && height == 750) {
            // landscape iphone 6
            iosScaleFactor = 2.0f;
        } else if (width == 1242 && height == 2208) {
            // portrait iphone 6 plus
            iosScaleFactor = 3.0f;
        } else if (width == 2208 && height == 1242) {
            // landscape iphone 6 plus
            iosScaleFactor = 3.0f;
        } else if (width == 1536 && height == 2048) {
            // portrait ipad with retina display
            iosScaleFactor = 2.0f;
        } else if (width == 2048 && height == 1536) {
            // landscape ipad with retina display
            iosScaleFactor = 2.0f;
        } else {
            //For others
            iosScaleFactor = 1.0f;
        }
    }

}
