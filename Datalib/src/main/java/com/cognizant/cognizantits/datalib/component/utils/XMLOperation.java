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
package com.cognizant.cognizantits.datalib.component.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * 
 */
public class XMLOperation {

    public static Document initTreeOp() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            return docBuilder.newDocument();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static Document initTreeOp(String xmlPath) {
        try {
            if (new File(xmlPath).exists()) {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                return docBuilder.parse(xmlPath);
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Document initTreeOpFromString(String xml) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            return docBuilder.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Element getElement(String value, Element rootElement, String tag, String reference) {
        NodeList child = rootElement.getChildNodes();
        Element parentElement = null;
        int totalnodes = child.getLength();
        for (int i = 0; i < totalnodes; i++) {
            if (child.item(i).getNodeName().equalsIgnoreCase(tag) && child.item(i).getAttributes().getNamedItem(reference).getTextContent().equals(value)) {
                parentElement = (Element) child.item(i);
                return parentElement;
            }
        }
        return parentElement;
    }

    public static void finishTreeOp(Document doc, String xmlPath) {
        createFile(xmlPath);
        try (FileOutputStream fout = new FileOutputStream(xmlPath)) {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(fout);
            transformer.transform(source, result);
        } catch (TransformerException | IOException ex) {
            Logger.getLogger(XMLOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void createFile(String xmlPath) {
        File xml = new File(xmlPath);
        if (!xml.exists()) {
            try {
                xml.getParentFile().mkdirs();
                xml.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(XMLOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void removeAll(Node node) {
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node n = list.item(i);
            if (n.hasChildNodes()) {
                removeAll(n);
                node.removeChild(n);
            } else {
                node.removeChild(n);
            }
        }
    }

    public static void replaceParent(Element oldParent, Element newParent) {
        while (oldParent.hasChildNodes()) {
            newParent.appendChild(oldParent.getFirstChild());
        }
        oldParent.getParentNode().replaceChild(newParent, oldParent);
    }

    public static String getAttribute(Node node, String attribute) {
        Node attr = node.getAttributes().getNamedItem(attribute);
        return attr == null ? null : attr.getTextContent();
    }
}
