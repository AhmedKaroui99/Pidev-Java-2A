/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;

import animatefx.animation.FadeIn;
import bcrypt.BCrypt;
import com.gn.module.main.Data;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import services.UserServices;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class NewPasswordController implements Initializable {
    @FXML
    private StackPane root;
    @FXML
    private StackPane sp1;
    @FXML
    private StackPane sp2;
    @FXML
    private HBox main;
    @FXML
    private VBox drawer1;
    @FXML
    private VBox content;
    @FXML
    private VBox pageTitle;
    @FXML
    private HBox barHeader;
    @FXML
    private Label title;
    @FXML
    private Label title1;
    @FXML
    private HBox barHeader1;
    @FXML
    private HBox barHeader11;
    @FXML
    private Label title2;
    @FXML
    private Button loginBtn;
    @FXML
    private Label forgetPasswordTitle;
    @FXML
    private JFXTextField newPassowrd;
    @FXML
    private JFXTextField cNewPassword;
    @FXML
    private Label title21;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void LoginRedirection(MouseEvent event) throws IOException {
        root.getChildren().remove(sp2);
        System.out.println(root.getChildren().toString());
        Parent fxml = FXMLLoader.load(getClass().getResource("Login.fxml"));
        System.out.println(fxml.getChildrenUnmodifiable().toString());
        root.getChildren().setAll(fxml);
        //title.setText("Payment");
        new FadeIn(root).play();
    }
    
    @FXML
    private void ChangePassword(MouseEvent event) throws SQLException {
        UserServices us = new UserServices();
        if (newPassowrd.getText().equals(cNewPassword.getText())) {
            String hashPassword = BCrypt.withDefaults().hashToString(12, newPassowrd.getText().toCharArray());
            us.updatePassword(hashPassword, Data.userToChangePassword.getId());
            TrayNotification tray = new TrayNotification("success","Mot de passe modifié avec succées",NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.seconds(5));
        }
    }
}
