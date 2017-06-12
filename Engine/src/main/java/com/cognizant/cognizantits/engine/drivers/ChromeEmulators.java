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
package com.cognizant.cognizantits.engine.drivers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Reference https://chromium.googlesource.com/chromium/src/+/48.0.2564.111/third_party/WebKit/Source/devtools/front_end/emulated_devices/module.json
 * 
 */
public class ChromeEmulators {

    public static List<String> getEmulatorsList() {
        return new ArrayList<>(Arrays.asList("Apple iPhone 4",
                "Apple iPhone 5",
                "Apple iPhone 6",
                "Apple iPhone 6 Plus",
                "BlackBerry Z30",
                "Google Nexus 4",
                "Google Nexus 5",
                "Google Nexus 6",
                "LG Optimus L70",
                "Nokia N9",
                "Nokia Lumia 520",
                "Samsung Galaxy S III",
                "Samsung Galaxy S4",
                "Amazon Kindle Fire HDX",
                "Apple iPad Mini",
                "Apple iPad",
                "BlackBerry PlayBook",
                "Google Nexus 10",
                "Google Nexus 7",
                "Samsung Galaxy Note 3",
                "Samsung Galaxy Note II",
                "Laptop with touch",
                "Laptop with HiDPI screen",
                "Laptop with MDPI screen"));
    }
}
