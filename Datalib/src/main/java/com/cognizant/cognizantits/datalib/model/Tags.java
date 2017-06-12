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
package com.cognizant.cognizantits.datalib.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

/**
 *
 * 
 */
public class Tags extends ArrayList<Tag> {

    @Override
    public boolean add(Tag t) {
        if (!contains(t.getValue())) {
            return super.add(t);
        }
        return false;
    }

    public boolean add(String t) {
        return add(Tag.create(t));
    }

    public boolean add(Enum t) {
        return add(t.name());
    }

    public boolean addAll(List<Tag> t) {
        if (Objects.nonNull(t)) {
            return super.addAll(t);
        }
        return false;
    }

    public Tag get(String tag) {
        return find(tag).get();
    }

    public boolean contains(String tag) {
        return find(tag).isPresent();
    }

    public Optional<Tag> find(String value) {
        return stream().filter(tag -> equals(tag::getValue, value)).findFirst();
    }

    public static boolean equals(Supplier<Object> supplier, Object val) {
        return Objects.equals(supplier.get(), val);
    }
    
    public void removeTag(Tag t){
        find(t.getValue()).ifPresent(this::remove);
    }

}
