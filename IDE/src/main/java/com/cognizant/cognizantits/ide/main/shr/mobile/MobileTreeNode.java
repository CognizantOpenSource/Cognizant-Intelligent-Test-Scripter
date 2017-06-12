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
package com.cognizant.cognizantits.ide.main.shr.mobile;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * 
 */
public abstract class MobileTreeNode extends DefaultMutableTreeNode {

    private final Map<String, String> attributes = new LinkedHashMap<>();

    public MobileTreeNode() {
    }

    public MobileTreeNode(String text) {
        setUserObject(text);
    }

    public Map getAttributes() {
        return attributes;
    }

    public String getAttribute(String value) {
        return attributes.get(value);
    }

    public void setAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public abstract Rect getBounds();

    public boolean findLeafMostNodesAtPoint(int px, int py, MinAreaFindNodeListener listener) {
        boolean foundInChild = false;
        for (int i = 0; i < getChildCount(); i++) {
            MobileTreeNode node = (MobileTreeNode) getChildAt(i);
            foundInChild |= node.findLeafMostNodesAtPoint(px, py, listener);
        }

        // checked all children, if at least one child covers the point, return directly
        if (foundInChild) {
            return true;
        }
        // check self if the node has no children, or no child nodes covers the point
        if (getBounds() != null) {
            Rect rect = getBounds();
            if (rect.getX() <= px
                    && px <= rect.getX() + rect.getWidth()
                    && rect.getY() <= py
                    && py <= rect.getY() + rect.getHeight()) {
                listener.onFoundNode(this);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public abstract String getId();

    public abstract String getText();

    public abstract String getClassName();

    public abstract String getValidName();

    public abstract String getPageName();
}
