/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;

import animatefx.animation.FadeIn;
import bcrypt.BCrypt;
import com.gn.module.main.Data;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entities.User;
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
import services.ClientServices;
import services.UserServices;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class LoginController implements Initializable {
    @FXML
    private StackPane root;
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
    private JFXTextField email;
    @FXML
    private JFXPasswordField password;
    @FXML
    private Label title2;
    @FXML
    private Label title21;
    @FXML
    private Button loginBtn;
    @FXML
    private Label title22;
    @FXML
    private StackPane sp1;
    @FXML
    private StackPane sp2;
    @FXML
    private Label registerTitle;
    @FXML
    private Label forgetPasswordTitle;
    @FXML
    private Label codeTitle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void Login(MouseEvent event) throws IOException, SQLException {
        
        UserServices us = new UserServices();
        User u = us.login(email.getText().toString(), password.getText().toString());
        System.out.println(password.getText());
        System.out.println(email.getText());
        System.out.println("\n hedha l user : \n");
        System.out.println(u.toString());
        byte[] passbyte;
        BCrypt.Result resultStrict = BCrypt.verifyer().verify(password.getText().toCharArray(), u.getPassword());
        Boolean resultStrictbool = resultStrict.verified;
        System.out.println("rezxs : "+ resultStrict.toString());
        if(resultStrictbool) {
            TrayNotification tray = new TrayNotification("success","Bienvenue",NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.seconds(5));
            Data.user = u;
            if (u.getRole().equals("client")) {
                ClientServices cs = new ClientServices();
                Data.client = cs.findByUserIdPopulated(u.getId());
                root.getChildren().remove(sp2);
                System.out.println(root.getChildren().toString());
                Parent fxml = FXMLLoader.load(getClass().getResource("/com/gn/module/main/main.fxml"));
                System.out.println(fxml.getChildrenUnmodifiable().toString());
                root.getChildren().setAll(fxml);
                //title.setText("Payment");
                new FadeIn(root).play();
            } else if (u.getRole().equals("associe")) {
                root.getChildren().remove(sp2);
                System.out.println(root.getChildren().toString());
                Parent fxml = FXMLLoader.load(getClass().getResource("/com/gn/module/main/mainAssocie.fxml"));
                System.out.println(fxml.getChildrenUnmodifiable().toString());
                root.getChildren().setAll(fxml);
                //title.setText("Payment");
                new FadeIn(root).play();
            } else if (u.getRole().equals("admin")) {
                root.getChildren().remove(sp2);
                System.out.println(root.getChildren().toString());
                Parent fxml = FXMLLoader.load(getClass().getResource("/com/gn/module/main/mainAdmin.fxml"));
                System.out.println(fxml.getChildrenUnmodifiable().toString());
                root.getChildren().setAll(fxml);
                //title.setText("Payment");
                new FadeIn(root).play();
            }
        } else {
            TrayNotification tray = new TrayNotification("Error","Vérifier vos informations",NotificationType.ERROR);
            tray.showAndDismiss(Duration.seconds(5));
        }
        
        
    }
    
    @FXML
    private void RegisterRedirection(MouseEvent event) throws IOException {
        root.getChildren().remove(sp2);
        System.out.println(root.getChildren().toString());
        Parent fxml = FXMLLoader.load(getClass().getResource("Register.fxml"));
        System.out.println(fxml.getChildrenUnmodifiable().toString());
        root.getChildren().setAll(fxml);
        //title.setText("Payment");
        new FadeIn(root).play();
    }
    
    @FXML
    private void forgetPasswordRedirection(MouseEvent event) throws IOException {
        root.getChildren().remove(sp2);
        System.out.println(root.getChildren().toString());
        Parent fxml = FXMLLoader.load(getClass().getResource("ForgetPassword.fxml"));
        System.out.println(fxml.getChildrenUnmodifiable().toString());
        root.getChildren().setAll(fxml);
        //title.setText("Payment");
        new FadeIn(root).play();
    }
    
    @FXML
    private void fpCodeRedirection(MouseEvent event) throws IOException {
        root.getChildren().remove(sp2);
        System.out.println(root.getChildren().toString());
        Parent fxml = FXMLLoader.load(getClass().getResource("ForgetPasswordCode.fxml"));
        System.out.println(fxml.getChildrenUnmodifiable().toString());
        root.getChildren().setAll(fxml);
        //title.setText("Payment");
        new FadeIn(root).play();
        
    }
    
}
