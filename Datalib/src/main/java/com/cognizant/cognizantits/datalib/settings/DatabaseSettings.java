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
public class DatabaseSettings extends AbstractPropSettings {

    public DatabaseSettings(String location) {
        super(location, "DBSettings");
        if (isEmpty()) {
            loadDefault();
        }
    }

    private void loadDefault() {
        put("db.connection.string", "jdbc:<Database>://<Host>:<Port>/<Database name>");
        put("db.user", "");
        put("db.password", "");
        put("db.driver", "");
        put("db.commit", "True");
        put("db.timeout", "30");
    }
}
