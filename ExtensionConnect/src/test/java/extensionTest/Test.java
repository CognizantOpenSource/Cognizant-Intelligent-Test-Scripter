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
 */
package extensionTest;

import com.cognizant.cognizantits.extension.conector.DataConnector;
import com.cognizant.cognizantits.extension.extensionPojo.addonObject.RecordObject;
import com.cognizant.cognizantits.extension.extensionPojo.heal.FindResults;
import com.cognizant.cognizantits.extension.server.ExtensionServer;

/**
 *
 * @author 394173
 */
public class Test {

    public static void main(String[] args) {
        ExtensionServer.get().startOn(8887);
        ExtensionServer.get().withDataReciever(new DataConnector() {
            @Override
            public void onRecieve(RecordObject rObject) {
                System.out.println(rObject.getObjectname());
            }

            @Override
            public void onRecieve(FindResults rObject) {

            }

        }).startSpy();
    }
}
