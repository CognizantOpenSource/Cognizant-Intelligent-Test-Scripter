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

import com.cognizant.cognizantits.datalib.component.utils.XMLOperation;
import com.cognizant.cognizantits.ide.main.shr.mobile.MobileTree;
import com.cognizant.cognizantits.ide.main.utils.fileoperation.FileOptions;
import java.io.File;
import javax.swing.tree.DefaultTreeModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * 
 */
public class IOSTree extends MobileTree {

    private static IOSTree andTree;
    private String xmlContent;

    public static IOSTree get() {
        if (andTree == null) {
            andTree = new IOSTree();
        }
        return andTree;
    }

    @Override
    public void loadTree(String xml) {
        xmlContent = xml;
        Document doc;
        if (new File(xml).exists()) {
            doc = XMLOperation.initTreeOp(xml);
        } else {
            doc = XMLOperation.initTreeOpFromString(xml);
        }
        Element rootElement = doc.getDocumentElement();
        IOSTreeNode rootNode = new IOSTreeNode(rootElement.getTagName());
        rootNode.setAttribute("tag", rootElement.getTagName());
        loadNodes(rootElement, rootNode);
        DefaultTreeModel newModel = new DefaultTreeModel(rootNode);
        getTree().setModel(newModel);
    }

    private IOSTreeNode loadNodes(Element parent, IOSTreeNode parentNode) {
        NodeList nodeList = parent.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                IOSTreeNode treeNode = new IOSTreeNode(getDisplayName(node));
                setAttributes(node, treeNode);
                treeNode.setAttribute("tag", node.getNodeName());
                loadNodes((Element) node, treeNode);
                parentNode.add(treeNode);
            }
        }
        return null;
    }

    @Override
    public String getDisplayName(Node node) {
        String type = node.getNodeName();
        String name = getAttribute(node, "name");
        name = name != null ? " " + name : "";
        return "[" + type + "]" + name;
    }

    @Override
    public IOSTreeNode getSelectedNode() {
        Object selected = getTree().getSelectionPath().getLastPathComponent();
        if (selected instanceof IOSTreeNode) {
            return (IOSTreeNode) selected;
        }
        return null;
    }

    @Override
    public void saveXML(String fileName) {
        if (xmlContent != null) {
            if (new File(xmlContent).exists()) {
                FileOptions.copyFileAs(xmlContent, fileName);
            } else {
                FileOptions.createFile(fileName, xmlContent);
            }
        }
    }

}
