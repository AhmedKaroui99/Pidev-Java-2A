/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Commentaire;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import services.CommentaireCrud;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class AjoutercommentaireController implements Initializable {

   
    @FXML
    private JFXTextField acontenucommentaire;
    @FXML
    private JFXTextField adatecommentaire;
    @FXML
    private JFXButton ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterCommentaire(ActionEvent event) {
        try {
        int idclient=1;
        String contenucommentaire= acontenucommentaire.getText();
        String datecommentaire= adatecommentaire.getText();
       
        if( acontenucommentaire.getText().trim().isEmpty()||adatecommentaire.getText().trim().isEmpty()){
        Alert fail= new Alert(AlertType.ERROR);
        fail.setHeaderText("failure");
        fail.setContentText("Vous devez saisir toutes les données!");
        fail.showAndWait();
    } else {
          Commentaire c = new Commentaire(idclient,contenucommentaire, datecommentaire);
        CommentaireCrud rcd = new CommentaireCrud();
        rcd.addcommentaire(c);
       // JOptionPane.showMessageDialog(null," Rubrique ajoutée avec sucées", "Ajout", 1);
        
        FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("Mescommentaires.fxml"));
            Parent root = loader.load();
            MescommentairesController pdc = loader.getController();
            
           acontenucommentaire.getScene().setRoot(root);
            } 
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    
}
    }
    


