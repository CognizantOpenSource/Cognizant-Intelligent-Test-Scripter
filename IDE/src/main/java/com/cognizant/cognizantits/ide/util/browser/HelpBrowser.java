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

import com.cognizant.cognizantits.engine.support.DesktopApi;
import java.io.File;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * 
 */
public class HelpBrowser extends JavaFXBrowser {

    private ContextMenu contextMenu;
    private MenuItem open;

    @Override
    public void load() {
        super.load();
        Platform.runLater(new Runnable() { // this will run initFX as JavaFX-Thread
            @Override
            public void run() {
                webView.setContextMenuEnabled(false);
                contextMenu = new ContextMenu();
                open = new MenuItem("Open in browser");
                addActionListener();
                addContextMenuListener();
                contextMenu.getItems().addAll(open);
            }
        });

    }

    private void addActionListener() {
        open.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                DesktopApi.open(new File("Help" + File.separator + "index.html"));
            }
        });
    }

    private void addContextMenuListener() {
        webView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouse) {
                if (mouse.getButton() == MouseButton.SECONDARY) {
                    contextMenu.show(webView, mouse.getScreenX(), mouse.getScreenY());
                } else {
                    contextMenu.hide();
                }
            }
        });
    }
}
