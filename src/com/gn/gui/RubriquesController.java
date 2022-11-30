/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;

import animatefx.animation.FadeIn;
import com.gn.App;
import com.gn.decorator.GNDecorator;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class RubriquesController implements Initializable {

    @FXML
    private StackPane root;
    @FXML
    private HBox main;
    @FXML
    private VBox content;
    @FXML
    private StackPane pageBody;
    @FXML
    private Button yoga;
    @FXML
    private Button meditation;
    @FXML
    private StackPane sp2;
    @FXML
    private Button massages;
    @FXML
    private Button acuponcture;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void go_to_yoga(ActionEvent event) throws IOException {
      Parent root = FXMLLoader.load(getClass().getResource("/com/gn/gui/Yoga.fxml"));
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

    @FXML
    private void go_to_massages(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/gn/gui/Massages.fxml"));
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

    @FXML
    private void go_to_meditation(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/com/gn/gui/Meditation.fxml"));
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

    @FXML
    private void go_to_acuponcture(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("/com/gn/gui/Acuponcture.fxml"));
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

    
}
