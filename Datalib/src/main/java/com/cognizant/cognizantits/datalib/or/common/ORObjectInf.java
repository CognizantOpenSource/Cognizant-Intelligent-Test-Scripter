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

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.swing.table.TableModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * 
 */
public interface ORObjectInf extends TreeNode, TableModel {

    public String getName();

    public void setName(String name);

    @JsonIgnore
    public void setParent(ObjectGroup group);

    @JsonIgnore
    public TreeNode[] getPath();

    @JsonIgnore
    public ORPageInf getPage();

    @JsonIgnore
    public void removeFromParent();

    @JsonIgnore
    public Boolean rename(String newName);

    @JsonIgnore
    public String getRepLocation();

    @JsonIgnore
    public ORObjectInf clone(ORObjectInf obj);

    @JsonIgnore
    @Override
    public ObjectGroup getParent();

    @JsonIgnore
    public TreePath getTreePath();

    @JsonIgnore
    public Boolean isEqualOf(ORObjectInf object);

}
