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
package com.cognizant.cognizantits.ide.util.data;

/**
 *
 *
 */
public class Header {

    public static final String ACTION = "ACTION";
    public static final String MSG = "MSG";

    public static final String LICENSEMODE = "LMODE";
    public static final String LICENSEDAYS = "LDAYS";

    public static final String LICENSESTATUS = "LSTAT";
    public static final String LICENSE = "LIC";

    public static class Action {

        public static final String COMM_MSG = "COMMMSG";
        public static final String LICENSE_REQUEST = "LICREQ";
        public static final String LICENSE_RESPONSE = "LICRES";
        public static final String BCAST = "BCAST";
    }

    public static class Info {

        public static final String HOSTNAME = "HNAME";
        public static final String MAC = "MAC";
        public static final String IP = "IP";
        public static final String USER = "UNAME";
        public static final String PRODUCT_ID = "PID";
        public static final String PRODUCT_VERSION = "PVERSN";
        public static final String PRODUCT_BUILD = "BVERSN";

    }

    public static class LMODE {

        public static final String OFFLINE = "OFFLINE";
        public static final String ONLINE = "ONLINE";
    }

    public static class Status {

        public static final String GRANTED = "LGRANT";
        public static final String DENIED = "LDEND";
    }
    private Header(){
        
    }

}
