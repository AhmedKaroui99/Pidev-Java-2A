/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.module.main;

import animatefx.animation.FadeIn;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;

/**
 * FXML Controller class
 *
 * @author sarbo
 */
public class MainAssocie implements Initializable {
    @FXML
    private StackPane root;
    @FXML
    private HBox main;
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
    private VBox content;
    @FXML
    private VBox pageTitle;
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
    private StackPane pageBody;
    @FXML
    private ScrollPane body;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void paymentRedirect(MouseEvent event) {
    }
    
    @FXML
    private void ProfileRedirect(MouseEvent event) throws IOException {
        pageBody.getChildren().remove(body);
        Parent fxml = FXMLLoader.load(getClass().getResource("/com/gn/gui/AssocieProfile.fxml"));
        System.out.println(fxml.getChildrenUnmodifiable().get(1).toString());
        pageBody.getChildren().setAll(fxml);
        title.setText("Profile");
        new FadeIn(pageBody).play();

    }
    
}
