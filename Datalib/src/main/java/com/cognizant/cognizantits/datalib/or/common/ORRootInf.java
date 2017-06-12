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
package com.cognizant.cognizantits.datalib.or.common;

import com.cognizant.cognizantits.datalib.or.ObjectRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.swing.tree.TreeNode;

/**
 *
 * 
 * @param <T>
 */
public interface ORRootInf<T extends ORPageInf> extends TreeNode {

    @JsonIgnore
    public T addPage();

    @JsonIgnore
    public T addPage(String pageName);

    @JsonIgnore
    public void deletePage(String pageName);

    public String getName();

    @JsonIgnore
    public ObjectRepository getObjectRepository();

    @JsonIgnore
    public T getPageByName(String pageName);

    public List<T> getPages();

    @JsonIgnore
    public Boolean isSaved();

    @JsonIgnore
    public void setSaved(Boolean saved);

    public void setName(String name);

    @JsonIgnore
    public void setObjectRepository(ObjectRepository objRep);

    public void setPages(List<T> pages);

    @JsonIgnore
    public TreeNode[] getPath();

    @JsonIgnore
    public String getRepLocation();

    @JsonIgnore
    public void sort();
}
