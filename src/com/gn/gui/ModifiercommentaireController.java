/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Commentaire;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import services.CommentaireCrud;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class ModifiercommentaireController implements Initializable {

   

   
    @FXML
    private JFXTextField acontenucommentaire;
    
    @FXML
    private JFXButton modifier;
int idcl;
int idcm;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setTextField( String contenucommentaire) {
       
        
        acontenucommentaire.setText(contenucommentaire);
    
        
    }
    
    @FXML
    private void ModifierCommentaire(ActionEvent event) {
        
        String contenucommentaire= acontenucommentaire.getText();
        
      
       
        if( acontenucommentaire.getText().trim().isEmpty()){
        Alert fail= new Alert(AlertType.ERROR);
        fail.setHeaderText("failure");
        fail.setContentText("Vous devez saisir tous les données!");
        fail.showAndWait();}else{
        
            setTextField( contenucommentaire);
        Commentaire c = new Commentaire(contenucommentaire);
            System.out.println("Commentairemodifie");
        CommentaireCrud rcd = new CommentaireCrud();
        rcd.modifiercommentaire(c);
       
    }
    }
    
}
