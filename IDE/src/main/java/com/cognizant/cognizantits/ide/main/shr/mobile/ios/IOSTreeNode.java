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

import com.cognizant.cognizantits.ide.main.shr.mobile.MobileTreeNode;
import com.cognizant.cognizantits.ide.main.shr.mobile.Rect;

/**
 *
 * 
 */
public class IOSTreeNode extends MobileTreeNode {

    public IOSTreeNode() {
    }

    public IOSTreeNode(String text) {
        setUserObject(text);
    }

    @Override
    public Rect getBounds() {
        Rect rect = new Rect();
        rect.setX(getValue(getAttribute("x")) * IOSUtil.get().getScaleFactor());
        rect.setY(getValue(getAttribute("y")) * IOSUtil.get().getScaleFactor());
        rect.setWidth(getValue(getAttribute("width")) * IOSUtil.get().getScaleFactor());
        rect.setHeight(getValue(getAttribute("height")) * IOSUtil.get().getScaleFactor());
        return rect;
    }

    private double getValue(String val) {
        if (val != null && !val.trim().isEmpty()) {
            return Double.parseDouble(val);
        }
        return 0;
    }

    @Override
    public String getId() {
        return getAttribute("id");
    }

    @Override
    public String getText() {
        return getAttribute("label");
    }

    @Override
    public String getClassName() {
        return "";
    }

    @Override
    public String getValidName() {
        String name = getAttribute("name");
        if (!name.trim().isEmpty()) {
            return name;
        }
        name = getAttribute("label");
        if (!name.trim().isEmpty()) {
            return name;
        }
        name = getAttribute("value");
        if (!name.trim().isEmpty()) {
            return name;
        }
        name = getAttribute("tag");
        if (!name.trim().isEmpty()) {
            return name;
        }
        return "Object";
    }

    @Override
    public String getPageName() {
        return ((IOSTreeNode) getRoot().getChildAt(0)).getAttribute("name");
    }
}
