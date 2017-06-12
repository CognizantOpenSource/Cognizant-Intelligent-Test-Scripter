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
package com.cognizant.cognizantits.gridnode;

import com.cognizant.cognizantits.gridnode.GridController.Browsers;
import com.cognizant.cognizantits.gridnode.GridController.Methods;
import com.cognizant.cognizantits.gridnode.GridController.ParseJSON;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

/**
 *
 * @author 499538
 */
public class GridNode extends Application {

    public final TableView<Browsers> table = new TableView<>();
    public static ObservableList<Browsers> data;
    final HBox hb = new HBox();
    ParseJSON jsonCall = new ParseJSON();
    Methods methods = new Methods();

    @Override
    public void init() {
        data = jsonCall.getBrData();
        if (data == null || data.isEmpty()) {
            List<Browsers> brList = new ArrayList<>();
            brList.add(new Browsers("Chrome", "1"));
            data = FXCollections.observableArrayList(brList);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        //*********************************** Layout settings
        BorderPane rtpane = new BorderPane();
        Scene scene = new Scene(rtpane, 360, 450);
        primaryStage.setTitle("Grid Node");
        primaryStage.getIcons().add(new Image("/favicon.png"));

        //**********************************top panel code
        ToggleButton tb1 = new ToggleButton("Tabular");
        ToggleButton tb2 = new ToggleButton("Desciptive");
        ToggleGroup group = new ToggleGroup();
        tb1.setToggleGroup(group);
        tb2.setToggleGroup(group);
        GridPane tgrid = new GridPane();
        tgrid.add(tb1, 0, 0);
        tgrid.add(tb2, 1, 0);
        tb1.setSelected(true);
        rtpane.setTop(tgrid);
        tgrid.setAlignment(Pos.TOP_CENTER);
        tgrid.setHgap(8);
        tgrid.setPadding(new Insets(10, 25, 0, 40));

        //**********************************Center Panel Code
        GridPane grid = new GridPane();
        rtpane.setCenter(grid);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(5, 25, 20, 25));
        //row 1
        Label srv = new Label("Server :");
        grid.add(srv, 0, 1);
        TextField srvIP = new TextField();
        grid.add(srvIP, 0, 2);
        srvIP.setPromptText("IP address");

        TextField srvPort = new TextField();
        grid.add(srvPort, 1, 2);
        srvPort.setPromptText("Port");
        //row 2
        Label client = new Label("Client :");
        grid.add(client, 0, 3);
        Label brLabel = new Label("Total browser instances :");
        grid.add(brLabel, 1, 3);
        TextField clientPort = new TextField();
        grid.add(clientPort, 0, 4);
        clientPort.setPromptText("Port");

        Spinner brVal = new Spinner(1, 30, 1);
        brVal.setEditable(true);
        grid.add(brVal, 1, 4);

        table.setEditable(true);
        TableColumn brName = new TableColumn("Browser");
        TableColumn maxInstance = new TableColumn("Max Instances");
        maxInstance.setEditable(true);
        // set table values
        brName.setCellValueFactory(new PropertyValueFactory<>("browser"));
        maxInstance.setCellValueFactory(new PropertyValueFactory<>("maxInst"));

        brName.setCellFactory(TextFieldTableCell.<Browsers>forTableColumn());
        maxInstance.setCellFactory(TextFieldTableCell.<Browsers>forTableColumn());
        brName.setOnEditCommit(new EventHandler<CellEditEvent<Browsers, String>>() {
            @Override
            public void handle(CellEditEvent<Browsers, String> evt) {
                ((Browsers) evt.getTableView().getItems().get(evt.getTablePosition().getRow())).setBrowser(evt.getNewValue());
            }
        });
        maxInstance.setOnEditCommit(new EventHandler<CellEditEvent<Browsers, String>>() {
            @Override
            public void handle(CellEditEvent<Browsers, String> evt) {
                ((Browsers) evt.getTableView().getItems().get(evt.getTablePosition().getRow())).setMaxInst(evt.getNewValue());
            }
        });

        table.setItems(FXCollections.observableArrayList(data));
        table.getColumns().addAll(brName, maxInstance);

        brName.prefWidthProperty().bind(table.widthProperty().multiply(0.49));
        maxInstance.prefWidthProperty().bind(table.widthProperty().multiply(0.5));
        maxInstance.setResizable(false);
        final Label label = new Label("Browsers :");

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(label, table, hb);
        grid.add(vbox, 0, 5);
        GridPane.setColumnSpan(vbox, 2);

        // add table row
        final TextField addbr = new TextField();
        addbr.setPromptText("Browser");
        addbr.setMinWidth(100);

        final TextField addInst = new TextField();
        addInst.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        addInst.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    alert.setContentText("Only integer value accepted!");
                    alert.showAndWait();
                }
            }
        });
        addInst.setMinWidth(50);
        addInst.setPromptText("Max Instance");

        final Button addBtn = new Button("Add");
        addBtn.setMinWidth(50);
        addBtn.setOnAction((ActionEvent e) -> {
            if (methods.validate(addbr, addInst)) {
                data.add(new Browsers(addbr.getText(), addInst.getText()));
                addbr.clear();
                addInst.clear();
            }
        });

        hb.getChildren().addAll(addbr, addInst, addBtn);
        hb.setSpacing(3);

        //**********************************Bottom Panel Code
        final Button start = new Button("Start");
        GridPane bgrid = new GridPane();
        rtpane.setBottom(bgrid);
        bgrid.add(start, 0, 0);
        start.setMinWidth(150);
        bgrid.setAlignment(Pos.TOP_CENTER);
        bgrid.setPadding(new Insets(0, 25, 20, 25));

        scene.getStylesheets().add("/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();

        start.setOnAction((ActionEvent e) -> {
            try {
                if (tb1.isSelected()) {
                    if (!srvIP.getText().trim().isEmpty() && !srvPort.getText().trim().isEmpty() && !clientPort.getText().trim().isEmpty() && data.size() != 0) {
                        jsonCall.saveJson(data, srvIP.getText(), srvPort.getText(), Long.parseLong(clientPort.getText()), (int) brVal.getValue());
                        if (methods.isWindows()) {
                            Runtime.getRuntime().exec("cmd /c start init.bat");
                        } else {
                            Runtime.getRuntime().exec("/usr/bin/open -a Terminal init.command");
                        }
                    } else {
                        alert.setContentText("All fields are compulsory!");
                        alert.showAndWait();
                    }
                } else {
                    jsonCall.saveTA(jsonCall.tArea.getText());
                    if (methods.isWindows()) {
                        Runtime.getRuntime().exec("cmd /c start init.bat");
                    } else {
                        Runtime.getRuntime().exec("/usr/bin/open -a Terminal init.command");
                    }
                }
            } catch (NumberFormatException | IOException ex) {
                Logger.getLogger(GridNode.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        final BooleanProperty firstTime = new SimpleBooleanProperty(true); // Variable to store the focus on stage load
        srvIP.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue && firstTime.get()) {
                grid.requestFocus(); // Delegate the focus to container
                firstTime.setValue(false); // Variable value changed for future references
            }
        });

        ChangeListener cl = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("[0-9]+")) {
                    alert.setContentText("Only integer value accepted!");
                    alert.showAndWait();
                }
            }
        };

        clientPort.textProperty().addListener(cl);
        srvPort.textProperty().addListener(cl);

        //toggle buttons event
        group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) -> {
            if (tb2.isSelected()) {
                rtpane.setCenter(jsonCall.jsonHandler(primaryStage));
            } else if (tb1.isSelected()) {
                rtpane.setCenter(grid);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
