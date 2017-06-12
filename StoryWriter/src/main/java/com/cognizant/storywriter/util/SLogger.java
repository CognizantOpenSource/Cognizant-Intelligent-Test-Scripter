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
package com.cognizant.storywriter.util;

/**
 *
 */
public class SLogger {

    public static boolean debug = true;

    public static void LOG(String HD, String MSG) {
        if (debug) {
            System.out.println("[" + HD + " : " + MSG + " ]");
        }
    }

    public static void LOGI(String MSG) {
        LOG("INFO ", MSG);
    }

    public static void LOGE(String MSG) {
        LOG("ERROR", MSG);
    }

    public static void LOGA(String MSG) {
        Notification.show(MSG);
    }
}
