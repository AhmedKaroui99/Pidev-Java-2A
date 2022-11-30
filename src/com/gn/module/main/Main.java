/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.module.main;

import animatefx.animation.FadeIn;
import com.gn.decorator.GNDecorator;
import java.io.IOException;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

/**
 *
 * @author SBS
 */
public class Main implements Initializable {
    @FXML
    private StackPane root;
    @FXML
    private HBox main;
    @FXML
    private VBox content;
    @FXML
    private HBox barHeader;
    @FXML
    private Label title;
    @FXML
    private HBox searchBox;
    @FXML
    private Button clear;
    @FXML
    private SVGPath searchIcon;
    @FXML
    private TextField search;
    @FXML
    private ScrollPane body;
    @FXML
    private VBox drawer1;
    @FXML
    private ScrollPane scroll;
    @FXML
    private VBox views;
    @FXML
    private ToggleButton home1;
    @FXML
    private ToggleGroup group;
    @FXML
    private ToggleButton home11;
    @FXML
    private ToggleButton home111;
    @FXML
    private ToggleButton home1111;
    @FXML
    private ToggleButton home11111;
    @FXML
    private VBox pageTitle;
    @FXML
    private StackPane pageBody;
    @FXML
    private Button Profile;
    @FXML
    private TableView<?> tablerubrique;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> titre;
    @FXML
    private TableColumn<?, ?> breve;
    @FXML
    private TableColumn<?, ?> detaille;
    @FXML
    private TableColumn<?, ?> action;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            pageBody.getChildren().remove(body);
            Parent fxml;
            fxml = FXMLLoader.load(getClass().getResource("/com/gn/gui/Rubriques.fxml"));
            System.out.println(fxml.getChildrenUnmodifiable().get(1).toString());
            pageBody.getChildren().setAll(fxml);
            title.setText("Rubriques");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void paymentRedirect(MouseEvent event) throws IOException {
        pageBody.getChildren().remove(body);
        Parent fxml = FXMLLoader.load(getClass().getResource("main.fxml"));
        System.out.println(fxml.getChildrenUnmodifiable().get(1).toString());
        pageBody.getChildren().setAll(fxml);
        title.setText("Payment");
    }
    
    @FXML
    private void ProfileRedirect(MouseEvent event) throws IOException {
        pageBody.getChildren().remove(body);
        Parent fxml = FXMLLoader.load(getClass().getResource("/com/gn/gui/UserProfile.fxml"));
        System.out.println(fxml.getChildrenUnmodifiable().get(1).toString());
        pageBody.getChildren().setAll(fxml);
        title.setText("Profile");
        new FadeIn(pageBody).play();

    }

    @FXML
    private void RubriqueRedirect(MouseEvent event) throws IOException {
        pageBody.getChildren().remove(body);
        Parent fxml = FXMLLoader.load(getClass().getResource("/com/gn/gui/Rubriques.fxml"));
        System.out.println(fxml.getChildrenUnmodifiable().get(1).toString());
        pageBody.getChildren().setAll(fxml);
        title.setText("Rubriques");
    }

    @FXML
    private void CommentaireRedirection(MouseEvent event) throws IOException {
        pageBody.getChildren().remove(body);
        Parent fxml = FXMLLoader.load(getClass().getResource("/com/gn/gui/Commentaires.fxml"));
        System.out.println(fxml.getChildrenUnmodifiable().get(1).toString());
        pageBody.getChildren().setAll(fxml);
        title.setText("Commentaires");
        new FadeIn(pageBody).play();
    }
    
    @FXML
    private void RendezVousRedirection(MouseEvent event) throws IOException {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("/com/gn/module/main/videoplayer.fxml"));
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
