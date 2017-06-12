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
import java.util.List;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * 
 * @param <T>
 * @param <R>
 */
public interface ORPageInf<T extends ORObjectInf, R extends ORRootInf> extends TreeNode {

    @JsonIgnore
    public T addObject();

    @JsonIgnore
    public ObjectGroup<T> addObjectGroup();

    @JsonIgnore
    public T addObject(String objectName);

    @JsonIgnore
    public ObjectGroup<T> addObjectGroup(String groupName);

    @JsonIgnore
    public void deleteObjectGroup(String groupName);

    @JsonIgnore
    public void removeFromParent();

    public String getName();

    @JsonIgnore
    public ObjectGroup<T> getObjectGroupByName(String groupName);

    public List<ObjectGroup<T>> getObjectGroups();

    @JsonIgnore
    public R getRoot();

    public void setName(String name);

    public void setObjectGroups(List<ObjectGroup<T>> objectGroups);

    @JsonIgnore
    public void setRoot(R root);

    @JsonIgnore
    public TreeNode[] getPath();

    @JsonIgnore
    public T getNewObject(String objectName, ObjectGroup<T> group);

    @JsonIgnore
    public Boolean rename(String newName);

    @JsonIgnore
    public String getRepLocation();

    @JsonIgnore
    public void sort();

    @JsonIgnore
    public TreePath getTreePath();
}
