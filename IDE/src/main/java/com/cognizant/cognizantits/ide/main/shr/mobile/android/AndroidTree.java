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
package com.cognizant.cognizantits.ide.main.shr.mobile.android;

import com.cognizant.cognizantits.datalib.component.utils.XMLOperation;
import com.cognizant.cognizantits.ide.main.shr.mobile.MobileTree;
import com.cognizant.cognizantits.ide.main.utils.fileoperation.FileOptions;
import javax.swing.tree.DefaultTreeModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * 
 */
public class AndroidTree extends MobileTree {

    private static AndroidTree andTree;
    private String rotation;

    public static AndroidTree get() {
        if (andTree == null) {
            andTree = new AndroidTree();
        }
        return andTree;
    }

    public String getRotation() {
        return rotation != null ? rotation : "0";
    }

    @Override
    public void loadTree(String xml) {
        Document doc = XMLOperation.initTreeOp(xml);
        Element rootElement = doc.getDocumentElement();
        rotation = getAttribute(rootElement, "rotation");
        AndroidTreeNode rootNode = new AndroidTreeNode(rootElement.getTagName());
        rootNode.setAttribute("Location", xml);
        loadNodes(rootElement, rootNode);
        DefaultTreeModel newModel = new DefaultTreeModel(rootNode);
        getTree().setModel(newModel);
    }

    private AndroidTreeNode loadNodes(Element parent, AndroidTreeNode parentNode) {
        NodeList nodeList = parent.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                AndroidTreeNode treeNode = new AndroidTreeNode(getDisplayName(node));
                setAttributes(node, treeNode);
                loadNodes((Element) node, treeNode);
                parentNode.add(treeNode);
            }
        }
        return null;
    }

    @Override
    public String getDisplayName(Node node) {
        String className = getAttribute(node, "class");
        if (className == null) {
            return null;
        }
        String text = getAttribute(node, "text");
        if (text == null) {
            return null;
        }
        String contentDescription = getAttribute(node, "content-desc");
        if (contentDescription == null) {
            return null;
        }
        String index = getAttribute(node, "index");
        if (index == null) {
            return null;
        }
        String bounds = getAttribute(node, "bounds");
        if (bounds == null) {
            return null;
        }
        // shorten the standard class names, otherwise it takes up too much space on UI
        className = className.replace("android.widget.", "");
        className = className.replace("android.view.", "");
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        builder.append(index);
        builder.append(") ");
        builder.append(className);
        if (!text.isEmpty()) {
            builder.append(':');
            builder.append(text);
        }
        if (!contentDescription.isEmpty()) {
            builder.append(" {");
            builder.append(contentDescription);
            builder.append('}');
        }
        builder.append(' ');
        builder.append(bounds);
        return builder.toString();
    }

    @Override
    public AndroidTreeNode getSelectedNode() {
        Object selected = getTree().getSelectionPath().getLastPathComponent();
        if (selected instanceof AndroidTreeNode) {
            return (AndroidTreeNode) selected;
        }
        return null;
    }

    @Override
    public void saveXML(String fileName) {
        AndroidTreeNode root = (AndroidTreeNode) getTree().getModel().getRoot();
        String file = root.getAttribute("Location");
        if (file != null) {
            FileOptions.copyFileAs(file, fileName);
        }
    }
}
