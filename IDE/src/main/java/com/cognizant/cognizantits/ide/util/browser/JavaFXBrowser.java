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
package com.cognizant.cognizantits.ide.util.browser;

import java.awt.Component;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 *
 */
public class JavaFXBrowser implements Browser {

    private final JFXPanel fxPanel = new JFXPanel();
    private WebEngine webEngine;
    WebView webView;

    @Override
    public void load() {
        Platform.runLater(new Runnable() { // this will run initFX as JavaFX-Thread
            @Override
            public void run() {
                webView = new WebView();
                fxPanel.setScene(new Scene(webView));
                webEngine = webView.getEngine();
            }
        });
    }

    @Override
    public Component getComponent() {
        return fxPanel;
    }

    @Override
    public void setUrl(final String url) {
        Platform.runLater(() -> webEngine.load(url));
    }

    @Override
    public void quit() {
    }

    @Override
    public void back() {
        Platform.runLater(new Runnable() { // this will run initFX as JavaFX-Thread
            @Override
            public void run() {
                if (webEngine.getHistory().getCurrentIndex() > 0) {
                    webEngine.getHistory().go(- 1);
                }
            }
        });
    }

    @Override
    public void next() {
        Platform.runLater(new Runnable() { // this will run initFX as JavaFX-Thread
            @Override
            public void run() {
                if (webEngine.getHistory().getMaxSize() > webEngine.getHistory().getCurrentIndex()) {
                    webEngine.getHistory().go(1);
                }
            }
        });
    }

    @Override
    public String getUrl() {
        return webEngine.getLocation();
    }

}
