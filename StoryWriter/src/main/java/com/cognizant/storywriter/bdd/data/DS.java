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
package com.cognizant.storywriter.bdd.data;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 */
public class DS {

    public static String[] STEPTYPES = {"Given", "And", "When", "Then","But"};
    public static Set<String> STEPDIC = new LinkedHashSet();
    public static Set<String> VARSET = new LinkedHashSet();
    public static String LN = "\n";
    public static String TAB = "\t";
    public static String GSTORIES = "GivenStories";
    public static String META = "Meta";

    static {
        STEPDIC.addAll(Arrays.asList(new String[]{}));
    }

    public  static synchronized void update(String... vals) {
        if (STEPDIC.size() < 500 && vals != null && vals.length > 0) {
            for (String v : vals) {
                if (v != null && v.length() > 3) {
                    if (v.startsWith("<") && v.endsWith(">")) {
                        VARSET.add(v);
                    } else {
                        STEPDIC.add(v);
                    }
                }
            }
        }

    }

    public static synchronized void updateV(String... vals) {
        for (String v : vals) {
            if (v != null && v.length() > 3) {
                VARSET.add("<" + v + ">");
            }
        }

    }
}
