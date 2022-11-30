/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Rubrique;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
//import services.Email;
import services.RubriqueCRUD;
import utils.email;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class AjouterrubriqueController implements Initializable {

    @FXML
    private JFXButton ajouter;
    @FXML
    private JFXTextField aid;
    @FXML
    private JFXTextField atitre;
    @FXML
    private JFXTextField abreve;
    @FXML
    private JFXTextField adetaille;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterrRubrique(ActionEvent event) throws MessagingException {
        try {
        Integer id = Integer.parseInt(aid.getText());
        String titre= atitre.getText();
        String breve= abreve.getText();
        String detaille= adetaille.getText();
        if(aid.getText().trim().isEmpty()|| atitre.getText().trim().isEmpty()|| abreve.getText().trim().isEmpty()||adetaille.getText().trim().isEmpty()){
        Alert fail= new Alert(AlertType.ERROR);
        fail.setHeaderText("failure");
        fail.setContentText("Vous devez saisir toutes les données!");
        fail.showAndWait();
    } else {
          Rubrique r = new Rubrique( id, titre,breve, detaille);
        RubriqueCRUD rcd = new RubriqueCRUD();
        rcd.addrubrique(r);
       // JOptionPane.showMessageDialog(null," Rubrique ajoutée avec sucées", "Ajout", 1);
        
        FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("Rubriqueadmin.fxml"));
            Parent root = loader.load();
            RubriqueadminController pdc = loader.getController();
     
            aid.getScene().setRoot(root);
            email E=new email();
            String sujet="Rubrique Ajoutée";
            String messgae="Votre rubrique a ete ajoute avec succes";
            E.sendEmailRebrique("ahmed.karoui@esprit.tn", sujet, messgae);
            } 
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    
}}
