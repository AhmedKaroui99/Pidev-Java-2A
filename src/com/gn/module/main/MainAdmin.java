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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class MainAdmin implements Initializable {
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
    @FXML
    private ToggleButton home11111;
    @FXML
    private ToggleButton home111111;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            pageBody.getChildren().remove(body);
            Parent fxml;
            fxml = FXMLLoader.load(getClass().getResource("/com/gn/gui/Rubriqueadmin.fxml"));
            System.out.println(fxml.getChildrenUnmodifiable().get(1).toString());
            pageBody.getChildren().setAll(fxml);
            title.setText("Rubriques");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void UsersHandleRedirect(MouseEvent event) throws IOException {
        pageBody.getChildren().remove(body);
        Parent fxml = FXMLLoader.load(getClass().getResource("/com/gn/gui/AdminHandleUsers.fxml"));
        System.out.println(fxml.getChildrenUnmodifiable().get(1).toString());
        pageBody.getChildren().setAll(fxml);
        title.setText("Gestion des utilisateurs");
        new FadeIn(pageBody).play();
    }
    
    @FXML
    private void RubriqueRedirect(MouseEvent event) {
        try {
            pageBody.getChildren().remove(body);
            Parent fxml;
            fxml = FXMLLoader.load(getClass().getResource("/com/gn/gui/Rubriqueadmin.fxml"));
            System.out.println(fxml.getChildrenUnmodifiable().get(1).toString());
            pageBody.getChildren().setAll(fxml);
            title.setText("Gestion des rubriques");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void CommentairesRedirection(MouseEvent event) {
        try {
            pageBody.getChildren().remove(body);
            Parent fxml;
            fxml = FXMLLoader.load(getClass().getResource("/com/gn/gui/Commentaireadmin.fxml"));
            System.out.println(fxml.getChildrenUnmodifiable().get(1).toString());
            pageBody.getChildren().setAll(fxml);
            title.setText("Gestion des commentaires");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
