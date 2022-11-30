/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;

import com.gn.decorator.GNDecorator;
import com.gn.module.main.Data;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Associe;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import services.AssocieServices;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class AsscoieProfileController implements Initializable {
    @FXML
    private StackPane root;
    @FXML
    private StackPane sp1;
    @FXML
    private StackPane sp2;
    @FXML
    private HBox main;
    @FXML
    private VBox content;
    @FXML
    private JFXTextField Prenom;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField phone;
    @FXML
    private Label email;
    @FXML
    private Label role;
    @FXML
    private JFXComboBox<String> type;
    @FXML
    private JFXTextField contactMail;
    @FXML
    private JFXTextField nbreMaxClientParJours;
    @FXML
    private JFXTextField longitude;
    @FXML
    private JFXTextField latitude;
    @FXML
    private JFXTextArea description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.type.getItems().add("Spa");
        this.type.getItems().add("Thalasso");  
        this.type.getItems().add("Coach Prive");   
        this.type.getItems().add("regime alimentaire");   
        this.type.getItems().add("centre de relaxation");   
        //this.map.getEngine().load("http://tuniaos.com/amine/map.html");
        AssocieServices as = new AssocieServices();
        try {
            Associe a = as.findByUserIdPopulated(Data.user.getId());
            this.email.setText(a.getEmail());
            this.role.setText(a.getRole());
            this.nom.setText(a.getNom());
            this.Prenom.setText(a.getPrenom());
            this.type.setValue(a.getType());
            this.description.setText(a.getDescription());
            this.contactMail.setText(a.getContactMail());
            this.phone.setText(String.valueOf(a.getContactTel()));
            this.latitude.setText(a.getLatitude());
            this.longitude.setText(a.getLongitude());
            this.nbreMaxClientParJours.setText(String.valueOf(a.getNbreMaxClientParJours()));
        } catch (Exception e) {
        }
    }    

    @FXML
    private void update(MouseEvent event) throws SQLException {
        System.out.println("clicked");
        AssocieServices as = new AssocieServices();
        Associe a = new Associe();
        a.setId(Data.user.getId());
        a.setEmail(Data.user.getEmail());
        a.setRole(Data.user.getRole());
        a.setNom(this.nom.getText());
        a.setPrenom( this.Prenom.getText());

        a.setNom(this.nom.getText());
        a.setPrenom(this.Prenom.getText());
        a.setType(this.type.getValue());
        a.setDescription(this.description.getText());
        a.setContactMail(this.contactMail.getText());
        a.setContactTel(Integer.parseInt(this.phone.getText()));
        a.setLatitude(this.latitude.getText());
        a.setLongitude(this.longitude.getText());
        a.setNbreMaxClientParJours(Integer.parseInt(this.nbreMaxClientParJours.getText()));
        boolean res = as.updateAssocie(a);
        System.out.println(res);
        if (res) {
            System.out.println("updated Successfuly");
        }
    }

    @FXML
    private void delete(MouseEvent event) throws SQLException, IOException {
        System.out.println("clicked");
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation est essetielle");
        alert.setHeaderText("Vous etes sure de vouloir supprimer votre compte ?");

        ButtonType buttonTypeOne = new ButtonType("Oui");
        ButtonType buttonTypeCancel = new ButtonType("Non", ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            // ... user chose "One"
            System.out.println("delete");
            AssocieServices cs = new AssocieServices();
            Associe c = new Associe();
            c.setId(Data.user.getId());
            c.setEmail(Data.user.getEmail());
            c.setRole(Data.user.getRole());
            boolean res = cs.deleteAssocie(c);
            System.out.println(res);
            if (res) {
                System.out.println(" updated Successfuly");
                TrayNotification tray = new TrayNotification("success","Profile supprimé avec succées",NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.seconds(5));
            }
            Parent newRoot = FXMLLoader.load(getClass().getResource("/com/gn/gui/Login.fxml"));
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
            decorator.setContent(newRoot);
            decorator.show();
        System.exit(0);
        } else {
            // ... user chose CANCEL or closed the dialog
            System.out.println("no delete");
        }
    }
    
}
