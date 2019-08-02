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
package com.cognizant.cognizantits.datalib.settings;

/**
 *
 * 
 */
public class MailSettings extends AbstractPropSettings {

    public MailSettings(String location) {
        super(location, "MailSettings");
        if (isEmpty()) {
            loadDefault();
        }
    }

    private void loadDefault() {
        put("username", "domain\\username or username");
        put("password", "");
        put("from.mail", "");
        put("to.mail", "");
        put("msg.subject", "Execution Report - {{component}} - {{status}}");
        put("msg.Body", "");
        put("attach.reports", "true");
        put("attach.standaloneHtml", "false");
        put("attach.screenshots", "false");
        put("attach.console", "false");
        put("mail.smtp.host", "");
        put("mail.smtp.port", "");
        put("mail.smtp.ssl.trust", "Same as mail.smtp.host");
        put("mail.smtp.starttls.enable", "true");
        put("mail.smtp.starttls.required", "true");
        put("mail.smtp.auth", "true");
        put("mail.smtp.connectiontimeout", "10000");
        put("mail.debug", "false");
    }

}
