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

/**
 *
 * 
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "name",
    "desc",
    "ref"
})
public class Meta {

    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("ref")
    private String ref;

    @JsonProperty("attributes")
    private com.cognizant.cognizantits.datalib.model.Attributes attributes = new com.cognizant.cognizantits.datalib.model.Attributes();
    @JsonProperty("tags")
    private com.cognizant.cognizantits.datalib.model.Tags tags = new com.cognizant.cognizantits.datalib.model.Tags();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    @JsonProperty("ref")
    public void setRef(String _class) {
        this.ref = _class;
    }

    @JsonProperty("desc")
    public String getDesc() {
        return desc;
    }

    @JsonProperty("desc")
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @JsonProperty("attributes")
    public com.cognizant.cognizantits.datalib.model.Attributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(com.cognizant.cognizantits.datalib.model.Attributes attributes) {
        this.attributes = attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes.addAll(attributes);
    }

    @JsonProperty("tags")
    public com.cognizant.cognizantits.datalib.model.Tags getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(com.cognizant.cognizantits.datalib.model.Tags tags) {
        this.tags = tags;
    }

    @JsonIgnore
    public void setTags(List<Tag> tags) {
        this.tags.clear();
        this.tags.addAll(tags);
    }

    public enum Props {
        attribute, tag
    }

    public enum Attributes {
        type, scenario, testcase, reusable, release, testset
    }

    public enum Tags {
        smoke, uat, load;

        @Override
        public String toString() {
            return "@" + name();
        }
    }

    public static Meta scenario() {
        Meta meta = create(Props.attribute.name(), Attributes.scenario.name());
        meta.setDesc("High level classification of test requirement/cases grouped together");
        meta.setRef(Attribute.class.getName());
        return meta;
    }

    public static Meta smoke() {
        Meta meta = createTag(Tags.smoke.toString());
        meta.setDesc("Non-exhaustive set of tests that aim at ensuring that the most important functions work");
        return meta;
    }

    public static Meta load() {
        return createTag(Tags.load.toString());
    }

    public static Meta uat() {
        return createTag(Tags.uat.toString());
    }

    public static Meta createTag(String name) {
        Meta meta = create(Props.tag.name(), name);
        meta.setRef(Tag.class.getName());
        return meta;
    }

    public static Meta create(String type, String name) {
        Meta meta = new Meta();
        meta.setName(name);
        meta.setType(type);
        return meta;
    }

    public static Meta createScenario(String name) {
        Meta meta = create(Attributes.scenario.name(), name);
        meta.setRef(Attribute.class.getName());
        return meta;
    }

    public static List<Meta> def() {
        return Arrays.asList(scenario(), smoke(), uat(), load());
    }

    @JsonIgnore
    public boolean equals(Meta m) {
        return Objects.equals(m.getType(), getType())
                && Objects.equals(m.getName(), getName());
    }

    @JsonIgnore
    public Tag toTag() {
        return Tag.create(name);
    }

    @JsonIgnore
    public boolean isTag() {
        return Props.tag.name().equals(type);
    }
}
