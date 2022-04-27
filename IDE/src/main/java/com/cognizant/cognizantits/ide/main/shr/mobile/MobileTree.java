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

import com.cognizant.cognizantits.datalib.or.mobile.MobileORPage;
import com.cognizant.cognizantits.ide.util.Notification;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 *
 * 
 */
public abstract class MobileTree {

    public void setTree(JTree tree) {
        this.tree = tree;
    }

    public JTree getTree() {
        return tree;
    }
    private JTree tree;

    public abstract void loadTree(String xml);

    protected String getAttribute(Node node, String attribute) {
        Node attr = node.getAttributes().getNamedItem(attribute);
        return attr == null ? null : attr.getTextContent();
    }

    protected void setAttributes(Node node, MobileTreeNode treeNode) {
        NamedNodeMap nodemap = node.getAttributes();
        for (int i = 0; i < nodemap.getLength(); i++) {
            Node attrnode = nodemap.item(i);
            treeNode.setAttribute(attrnode.getNodeName(), attrnode.getTextContent());
        }
    }

    public Boolean saveAsXML(MobileORPage node) {
        if (node != null) {
            String loc = node.getRepLocation();
            File file = new File(loc);
            if (!file.exists()) {
                file.mkdirs();
            }
            loc = loc + File.separator + "dump.xml";
            if (new File(loc).exists()) {
                int option = JOptionPane.showConfirmDialog(null, "Mapping already present.Do you want to overwrite?", "Overwrite", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    saveXML(loc);
                    return true;
                }
            } else {
                saveXML(loc);
                return true;
            }
        } else {
            Notification.show("Please Select a page from MOR to Map");
        }
        return false;
    }

    public abstract void saveXML(String fileName);

    public abstract String getDisplayName(Node node);

    public abstract MobileTreeNode getSelectedNode();

}
