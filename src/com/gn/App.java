/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn;

import com.gn.decorator.GNDecorator;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author SBS
 */
public class App extends Application {

    @Override
    public void stop() throws Exception {
        Platform.exit();
        System.exit(0);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/gn/gui/Login.fxml"));
        GNDecorator decorator = new GNDecorator();
        decorator.setIcon(null);
        decorator.setTitle("Healine");
        decorator.setResizable(true);
        
        decorator.fullBody();
        decorator.getScene().getStylesheets().addAll(
                getClass().getResource("/com/gn/theme/css/fonts.css").toExternalForm(),
                getClass().getResource("/com/gn/theme/css/material-color.css").toExternalForm(),
                getClass().getResource("/com/gn/theme/css/skeleton.css").toExternalForm(),
                getClass().getResource("/com/gn/theme/css/bootstrap.css").toExternalForm(),
                getClass().getResource("/com/gn/theme/css/shape.css").toExternalForm(),
                getClass().getResource("/com/gn/theme/css/typographic.css").toExternalForm(),
                getClass().getResource("/com/gn/theme/css/helpers.css").toExternalForm(),
                getClass().getResource("/com/gn/theme/css/light-green.css").toExternalForm(),
                getClass().getResource("/com/gn/theme/css/master.css").toExternalForm()
        );
//
        decorator.getStage().getIcons().add(new Image("/com/gn/theme/img/logo_1.png"));
        decorator.setContent(root);
        decorator.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
