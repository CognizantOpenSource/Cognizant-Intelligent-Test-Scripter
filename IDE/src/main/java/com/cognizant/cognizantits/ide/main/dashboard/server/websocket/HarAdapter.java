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
package com.cognizant.cognizantits.ide.main.dashboard.server.websocket;

import com.cognizant.cognizantits.ide.main.dashboard.server.Handler;
import com.cognizant.cognizantits.ide.main.dashboard.server.HarCompareHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;
import org.json.simple.JSONObject;

/**
 *
 * 
 */
public class HarAdapter extends WebSocketAdapter {

    private static final Logger LOG = Logger.getLogger(HarAdapter.class.getName());

    Session session;
    Handler handler;

    @Override
    public void onWebSocketConnect(Session sess) {
        this.session = sess;
        HarCompareHandler.onConnect(this);
    }

    @Override
    public void onWebSocketText(String message) {
        try {
            this.handler.onMessage(this, message);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    public void onWebSocketClose(int statusCode, String reason) {
        HarCompareHandler.onClose(this, reason);
    }

    @Override
    public void onWebSocketError(Throwable cause) {
        LOG.log(Level.SEVERE, "{0} : {1}", new Object[]{cause.getMessage(), session.getRemoteAddress().getHostString()});
    }

    @Override
    public Session getSession() {
        return session;
    }

    public void serHandler(Handler h) {
        this.handler = h;
    }

    public void send(String data) {
        try {
            getSession().getRemote().sendStringByFuture(data);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public String IP() {
        if (getSession() != null) {
            return getSession().getRemoteAddress().getAddress().getHostAddress();
        } else {
            return "NA";
        }
    }

    public void stopServer(JSONObject data) throws Exception {
        throw new Exception("Access restricted.");
    }

}
