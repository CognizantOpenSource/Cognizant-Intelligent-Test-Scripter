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

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.cognizant.cognizantits.extension.logger.LogUtil;
import com.cognizant.cognizantits.extension.conector.DataConnector;

/**
 *
 * @author 394173
 */
public class ExtensionServer {

    private static final Logger LOG = LogUtil.getLogger(ExtensionServer.class.getName());
    private static ExtensionServer server;

    private final EventServer socketServer;

    private String serverType = "startRecord";

    DataConnector receiever;

    public static ExtensionServer get() {
        if (server == null) {
            server = new ExtensionServer();
        }
        return server;
    }

    public void startOn(int port) {
        socketServer.setPort(port);
        socketServer.initSocketServer();
    }

    private ExtensionServer() {
        socketServer = new EventServer();
    }

    public void startSpy() {
        LOG.info("Launching Server for Spy");
        serverType = "startSpy";
        start();
    }

    public void startRecord() {
        LOG.info("Launching Server for Record");
        serverType = "startRecord";
        start();
    }

    public void startHeal() {
        LOG.info("Launching Server for Heal");
        serverType = "startHeal";
        start();
    }

    public ExtensionServer withDataReciever(DataConnector reciever) {
        this.receiever = reciever;
        return this;
    }

    public void start() {
        if (socketServer.isRunning()) {
            LOG.severe("Server already Running");
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    LOG.info("Starting Server");
                    socketServer.start();
                    LOG.info("Server Stopped");
                }
            }, "SocketServer").start();
        }
    }

    public void stop() {
        if (socketServer.isRunning()) {
            sendStopMessage();
            socketServer.stop();
        }
    }

    public void send(String cmd) {
        socketServer.broadcastMessage(cmd);
    }

    private void sendStopMessage() {
        send("{\"action\":\"serverStop\"}");
    }

    void addClient(EventSocket client) {
        try {
            client.session.getRemote().sendString(""
                    + "{"
                    + "\"action\":\"" + serverType + "\""
                    + "}");
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        socketServer.addwebsocketClient(client);
    }

    void removeClient(EventSocket aThis) {
        socketServer.removewebsocketClient(aThis);
    }

    void onRecieve(String data) {
        if (data.contains("")) {
            receiever.onRecieve(data, serverType.equals("startHeal"));
        }
    }

}
