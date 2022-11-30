/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;

import animatefx.animation.FadeIn;
import bcrypt.BCrypt;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javax.mail.MessagingException;
import services.UserServices;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utils.email;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class RegisterController implements Initializable {
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
    private JFXTextField email;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXPasswordField cpassword;
    @FXML
    private JFXComboBox<String> roleCB;
    @FXML
    private Label title2;
    @FXML
    private Label title21;
    @FXML
    private Button registerBtn;
    @FXML
    private Label title211;
    @FXML
    private Label title2111;
    @FXML
    private Label title22111;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.roleCB.getItems().add("associe");
        this.roleCB.getItems().add("client");     
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
    private void register(MouseEvent event) throws IOException, MessagingException {
        try {
            UserServices us = new UserServices();
            if(validate(email.getText())) {
                if (cpassword.getText().toString().equals(password.getText().toString())) {
                    String hashPassword = BCrypt.withDefaults().hashToString(12, password.getText().toCharArray());
                    String hashMail = BCrypt.withDefaults().hashToString(12, email.getText().toCharArray());
                    us.register(email.getText(), hashPassword, this.roleCB.getValue().toString(), hashMail);
                    System.out.println(password.getText());
                    System.out.println(cpassword.getText().toString().equals(password.getText().toString()) );
                    System.out.println(email.getText());
                    System.out.println(this.roleCB.getValue());
                    email e = new email();
                    String sujet = "Healine, compte crée avec succés";
                    e.sendEmail(email.getText() , sujet, hashMail);
                    TrayNotification tray = new TrayNotification("Success","Merci d'avoir rejoindre notre communauté ",NotificationType.SUCCESS);
                    tray.showAndDismiss(Duration.seconds(5));
                    FacebookClient fbClient = new DefaultFacebookClient("EAAC7C913ZBn8BANIDpLQ8wKKSZCYXIyv90H34KIrk7ZBXoZCjyVr1llCxTzD4aZAOCQGUvXycdVtGFlVrPRwkRTan6VF0gySn3K1a1T4J6pypr8CbZCoxxmZBosWl24I7PN06eJuTl65qxV7qiDd70TyOaCZBFnyWcecA0JZBqsccBMdBkk01j0mNulCRZATQ9hxYBoRkPx2X0rQZDZD");
                    FacebookType response = fbClient.publish("feed", FacebookType.class,Parameter.with("message", "l'utilisateur "+ email.getText() + " vien de rejoindre notre communauté"));
                } else {
                    TrayNotification tray = new TrayNotification("Error","Mot de passe non confirmé",NotificationType.ERROR);
                    tray.showAndDismiss(Duration.seconds(5));
                }    
            } else {
                TrayNotification tray = new TrayNotification("Error","Vérifier votre email",NotificationType.ERROR);
                tray.showAndDismiss(Duration.seconds(5));
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static final Pattern VALIDEMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{1,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
            Matcher matcher = VALIDEMAIL.matcher(emailStr);
            return matcher.find();
    }
}
