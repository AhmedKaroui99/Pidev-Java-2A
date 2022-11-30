/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;

import animatefx.animation.FadeIn;
import com.gn.module.main.Data;
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
import services.UserServices;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class ForgetPasswordCodeController implements Initializable {
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
    private Label title22;
    @FXML
    private Label registerTitle;
    @FXML
    private Label forgetPasswordTitle;
    @FXML
    private JFXTextField code;

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
    private void Login(MouseEvent event) {
    }
    
    @FXML
    private void sendMail(MouseEvent event) throws SQLException, IOException {
        UserServices us = new UserServices();
        User u = us.findByCode(Integer.parseInt(code.getText()));
        Data.userToChangePassword = u;
        System.out.println(u.toString());
        System.out.println(Data.userToChangePassword.toString());
        //Parent fxml = FXMLLoader.load(getClass().getResource("newPasswordFXML.fxml"));
        //loginPane.getChildren().removeAll();
        //loginPane.getChildren().setAll(fxml);
    }
}
