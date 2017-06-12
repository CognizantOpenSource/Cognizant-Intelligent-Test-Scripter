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
package com.cognizant.cognizantits.extension.server;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

public class EventSocket extends WebSocketAdapter {

    Session session;

    @Override
    public void onWebSocketConnect(Session sess) {
        this.session = sess;
        super.onWebSocketConnect(sess);
        ExtensionServer.get().addClient(this);
    }

    @Override
    public void onWebSocketText(String message) {
        super.onWebSocketText(message);
        ExtensionServer.get().onRecieve(message);
    }

    @Override
    public void onWebSocketClose(int statusCode, String reason) {
        super.onWebSocketClose(statusCode, reason);
        ExtensionServer.get().removeClient(this);
    }

    @Override
    public void onWebSocketError(Throwable cause) {
        super.onWebSocketError(cause);
        Logger.getLogger(EventSocket.class.getName()).log(Level.SEVERE, null, cause);
    }
}
