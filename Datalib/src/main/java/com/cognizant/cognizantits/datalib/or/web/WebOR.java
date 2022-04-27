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
package com.cognizant.cognizantits.datalib.or.web;

import com.cognizant.cognizantits.datalib.or.ObjectRepository;
import com.cognizant.cognizantits.datalib.or.common.ORRootInf;
import com.cognizant.cognizantits.datalib.or.common.ORUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.swing.tree.TreeNode;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JacksonXmlRootElement(localName = "Root")
public class WebOR implements ORRootInf<WebORPage> {

    public final static List<String> OBJECT_PROPS
            = new ArrayList<>(Arrays.asList(
                    "name",
                    "id",
                    "link_text",
                    "relative_xpath",
                    "xpath",
                    "class",
                    "css",
                    "type"));

    @JacksonXmlProperty(isAttribute = true, localName = "ref")
    private String name;

    @JacksonXmlProperty(localName = "Page")
    @JacksonXmlElementWrapper(useWrapping = false, localName = "Page")
    private List<WebORPage> pages;

    @JacksonXmlProperty(isAttribute = true)
    private String type;

    @JsonIgnore
    private ObjectRepository objectRepository;

    @JsonIgnore
    private Boolean saved = true;

    public WebOR() {
        this.pages = new ArrayList<>();
    }

    public WebOR(String name) {
        this.name = name;
        this.type = "OR";
        this.pages = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override 
    public List<WebORPage> getPages() {
        return pages;
    }

    @Override
    public void setPages(List<WebORPage> pages) {
        this.pages = pages;
        for (WebORPage page : pages) {
            page.setRoot(this);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    @Override
    public WebORPage getPageByName(String pageName) {
        for (WebORPage page : pages) {
            if (page.getName().equalsIgnoreCase(pageName)) {
                return page;
            }
        }
        return null;
    }

    @JsonIgnore
    public WebORPage getPageByTitle(String title) {
        for (WebORPage page : pages) {
            if (page.getTitle().equals(title)) {
                return page;
            }
        }
        return null;
    }

    @JsonIgnore
    @Override
    public WebORPage addPage() {
        String pName = "WPage";
        int i = 0;
        String pageName;
        do {
            pageName = pName + i++;
        } while (getPageByName(pageName) != null);

        return addPage(pageName);
    }

    @JsonIgnore
    @Override
    public WebORPage addPage(String pageName) {
        if (getPageByName(pageName) == null) {
            WebORPage page = new WebORPage(pageName, this);
            pages.add(page);
            new File(page.getRepLocation()).mkdirs();
            setSaved(false);
            return page;
        }
        return null;
    }

    @JsonIgnore
    @Override
    public void deletePage(String pageName) {
        WebORPage page = getPageByName(pageName);
        if (page != null) {
            pages.remove(page);
            setSaved(false);
        }
    }

    @JsonIgnore
    @Override
    public void setObjectRepository(ObjectRepository objRep) {
        this.objectRepository = objRep;
    }

    @JsonIgnore
    @Override
    public ObjectRepository getObjectRepository() {
        return objectRepository;
    }

    @JsonIgnore
    @Override
    public TreeNode getChildAt(int i) {
        return pages.get(i);
    }

    @JsonIgnore
    @Override
    public int getChildCount() {
        return pages == null ? 0
                : pages.size();
    }

    @JsonIgnore
    @Override
    public TreeNode getParent() {
        return null;
    }

    @JsonIgnore
    @Override
    public int getIndex(TreeNode tn) {
        return pages.indexOf(tn);
    }

    @JsonIgnore
    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isLeaf() {
        return getChildCount() == 0;
    }

    @JsonIgnore
    @Override
    public Enumeration children() {
        return Collections.enumeration(pages);
    }

    @Override
    public String toString() {
        return name;
    }

    @JsonIgnore
    @Override
    public Boolean isSaved() {
        return saved;
    }

    @JsonIgnore
    @Override
    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    @JsonIgnore
    @Override
    public TreeNode[] getPath() {
        return new TreeNode[]{this};
    }

    @JsonIgnore
    @Override
    public String getRepLocation() {
        return getObjectRepository().getORRepLocation();
    }

    @JsonIgnore
    @Override
    public void sort() {
        ORUtils.sort(this);
    }
}
