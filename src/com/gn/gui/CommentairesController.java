/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;

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
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class CommentairesController implements Initializable {

    private Button rubrique;
    private Button commentaire;
    private Button touslescommentaires;
    private Button mescommentaires;
    @FXML
    private StackPane root;
    @FXML
    private StackPane sp2;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void go_to_tous_les_commentaires(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("/com/gn/gui/Touslescommentaires.fxml"));
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
    private void go_to_mes_commentaires(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("/com/gn/gui/Mescommentaires.fxml"));
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
