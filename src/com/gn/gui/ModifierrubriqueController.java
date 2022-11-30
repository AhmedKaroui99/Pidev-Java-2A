/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Rubrique;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import services.RubriqueCRUD;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class ModifierrubriqueController implements Initializable {

    @FXML
    private JFXTextField atitre;
    @FXML
    private JFXTextField abreve;
    @FXML
    private JFXTextField adetaille;
    @FXML
    private JFXButton modifier;
int idassocie;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    
    }
        

    void setTextField(int id,String titre, String breve,String detaille) {
       
        
        atitre.setText(titre);
        abreve.setText(breve);
        adetaille.setText(detaille);
        idassocie=id;
       
        
}
    @FXML
    private void ModifierrRubrique(ActionEvent event) {
        
        String titre= atitre.getText();
         
        String breve =abreve.getText();
        String detaille= adetaille.getText();
       
        if(atitre.getText().trim().isEmpty()|| abreve.getText().trim().isEmpty()|| adetaille.getText().trim().isEmpty()){
        Alert fail= new Alert(AlertType.ERROR);
        fail.setHeaderText("failure");
        fail.setContentText("Vous devez saisir tous les données!");
        fail.showAndWait();}else{
        
            setTextField(idassocie, titre, breve, detaille);
        Rubrique r = new Rubrique( idassocie,titre, breve,detaille);
            System.out.println("");
        RubriqueCRUD rcd = new RubriqueCRUD();
        rcd.modifierrubrique(r);
       
    }}}
    

