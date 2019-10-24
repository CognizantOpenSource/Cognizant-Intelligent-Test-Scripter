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
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.cognizantits.extension.logger.LogUtil;
import com.cognizant.cognizantits.extension.util.Encrypt;
import java.io.InputStream;
import java.util.Properties;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.ssl.SslContextFactory;

public class EventServer {

    private static final Logger LOG = LogUtil.getLogger(EventServer.class.getName());

    private int port = 8887;
    private Server server;
    private final List<EventSocket> websocketClients = new CopyOnWriteArrayList<>();

    public void initSocketServer() {
        server = new Server();
        ServerConnector connector = getServerConnector();
        server.addConnector(connector);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.addServlet(new ServletHolder(new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
                try {
                    resp.setContentType("text/html; charset=utf-8");
                    resp.setStatus(HttpServletResponse.SC_OK);
                    resp.getWriter().println("<div class=\"svg\" style=\"display: flex;align-items: center;justify-content: center;margin-top: 10%;\">\n"
                            + "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\" viewBox=\"-265 235 30 30\" >\n"
                            + "    <g fill=\"white\" stroke=\"#8EC343\" stroke-width=\"3\">\n"
                            + "      <circle  cx=\"-250.5\" cy=\"249.5\" r=\"10\"/>\n"
                            + "      <path d=\"M-257 250l4 3.6 8-8\"/>\n"
                            + "    </g>\n"
                            + "  </svg>\n"
                            + "</div>");
                } catch (Exception ex) {

                }
            }
        }), "/status/*");
        server.setHandler(context);

        // Add a websocket to a specific path spec
        ServletHolder holderEvents = new ServletHolder("ws-events", EventServlet.class);
        context.addServlet(holderEvents, "/");

    }

    private SslConnectionFactory getSSLConnectionFactory() {
        Resource keyStoreResource = null;
        try {
            keyStoreResource = Resource.newClassPathResource("localhost");
            System.out.println(keyStoreResource);
        } catch (Exception ex) {
            Logger.getLogger(EventServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        SslContextFactory sslContextFactory = new SslContextFactory();
        sslContextFactory.setKeyStoreResource(keyStoreResource);
        String secret = readresource();
        sslContextFactory.setKeyStorePassword(Encrypt.getInstance().decrypt(secret));
        sslContextFactory.setKeyManagerPassword(Encrypt.getInstance().decrypt(secret));
        return new SslConnectionFactory(sslContextFactory, HttpVersion.HTTP_1_1.asString());
    }

    private ServerConnector getServerConnector() {
        SslConnectionFactory sslConnectionFactory = getSSLConnectionFactory();
        HttpConnectionFactory httpConnectionFactory = new HttpConnectionFactory(new HttpConfiguration());
        ServerConnector connector = new ServerConnector(server, sslConnectionFactory, httpConnectionFactory);
        connector.setPort(port);
        return connector;
    }

    public void start() {
        try {
            if (server.isStopped()) {
                server.start();
                server.join();
            }
        } catch (SocketTimeoutException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    public void stop() {
        try {
            if (server.isStarted()) {
                server.stop();
                server.join();
                initSocketServer();
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    public Boolean isRunning() {
        return server != null && server.isRunning();
    }

    public void addwebsocketClient(EventSocket socket) {
        websocketClients.add(socket);
    }

    public void removewebsocketClient(EventSocket socket) {
        websocketClients.remove(socket);
    }

    public void broadcastMessage(String message) {
        for (EventSocket client : websocketClients) {
            if (client.session.isOpen()) {
                client.session.getRemote().sendStringByFuture(message);
            }
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int newPort) {
        port = newPort;
    }

    private String readresource() {
        InputStream in = EventServer.class.getClassLoader().getResourceAsStream("util.PROPERTIES");
        try {
            if (in == null) {
                Logger.getLogger(EventServer.class.getName()).log(Level.SEVERE, "Property file not exist");
            } else {
                Properties prop = new Properties();
                prop.load(in);
                return prop.getProperty("extn.connect");
            }
        } catch (IOException e) {
            Logger.getLogger(EventServer.class.getName()).log(Level.SEVERE, e.getMessage());
        }
        return null;
    }
}
