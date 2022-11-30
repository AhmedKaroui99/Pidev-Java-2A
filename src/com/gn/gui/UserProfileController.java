/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;

import animatefx.animation.FadeIn;
import com.gn.decorator.GNDecorator;
import com.gn.module.main.Data;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import entities.Client;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import services.ClientServices;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class UserProfileController implements Initializable {
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
    private JFXDatePicker date;
    @FXML
    private JFXTextField phone;
    @FXML
    private Label email;
    @FXML
    private Label role;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ClientServices cs = new ClientServices();
        try {
            Client c = cs.findByUserIdPopulated(Data.user.getId());
            this.email.setText(c.getEmail());
            this.role.setText(c.getRole());
            this.nom.setText(c.getNom());
            this.Prenom.setText(c.getPrenom());
            this.phone.setText(c.getPhone());
            System.out.println("d azd az daz "+c.getDdn());
            if (c.getDdn() != null ){
                this.date.setValue(c.getDdn().toLocalDate());
            }
            //LocalDate parse = LocalDate.parse(c.getDdn());  
            //LocalDate of = LocalDate.of(parse.getYear(), parse.getMonthValue(), parse.getDayOfMonth());
            //this.date.setValue(of);
             System.out.println("dzadazd");
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void update(MouseEvent event) throws IOException, SQLException {
        System.out.println("clicked");
        ClientServices cs = new ClientServices();
        Client c = new Client();
        c.setId(Data.user.getId());
        c.setEmail(Data.user.getEmail());
        c.setRole(Data.user.getRole());
        c.setNom(this.nom.getText());
        c.setPrenom( this.Prenom.getText());
        c.setPhone(this.phone.getText());
        LocalDate localDate = this.date.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        java.util.Date date = Date.from(instant);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        c.setDdn(sqlDate);
        boolean res = cs.updateClient(c);
        System.out.println(res);
        if (res) {
            System.out.println("updated Successfuly");
            TrayNotification tray = new TrayNotification("success","Profile modifié avec succées",NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.seconds(5));
        }
        
    }
    
    @FXML
    private void delete(MouseEvent event) throws IOException, SQLException {
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
            ClientServices cs = new ClientServices();
            Client c = new Client();
            c.setId(Data.user.getId());
            c.setEmail(Data.user.getEmail());
            c.setRole(Data.user.getRole());
            boolean res = cs.deleteClient(c);
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
