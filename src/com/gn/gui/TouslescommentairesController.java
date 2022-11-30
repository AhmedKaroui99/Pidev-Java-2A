/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Commentaire;
import java.io.IOException;

import javafx.geometry.Insets;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import services.CommentaireCrud;
import utils.MyConnection;


/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class TouslescommentairesController implements Initializable {
    
   
    @FXML
    private TableColumn<Commentaire, String> contenucommentaire;
     @FXML
    private TableColumn<Commentaire, String> datecommentaire;
    

    private Button rubrique;
    private Button commentaire;
    ObservableList<Commentaire>  CommentaireList = FXCollections.observableArrayList();
     @FXML
    private TableView<Commentaire> tablecommentaire;
    @FXML
    private TextField search;
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         {
      
       
      
        
        String requete = "SELECT contenucommentaire,datecommentaire FROM `commentaire`";
            PreparedStatement pst;
     try {
         pst = new MyConnection().cn.prepareStatement(requete);
     
        ResultSet resultSet = pst.executeQuery();
        
            while (resultSet.next()){
                CommentaireList.add(new  Commentaire(
                       resultSet.getString("contenucommentaire"),
                        resultSet.getString("datecommentaire")));
                      
                       
                 
     
        contenucommentaire.setCellValueFactory(new PropertyValueFactory<>("contenucommentaire"));
         datecommentaire.setCellValueFactory(new PropertyValueFactory<>("datecommentaire"));
       
   
        
       
         tablecommentaire.setItems(CommentaireList);
         
        
    }    
                
            }catch (SQLException ex) {
         Logger.getLogger(TouslescommentairesController.class.getName()).log(Level.SEVERE, null, ex);
     }
       
    } 
    }    
 

    private void go_to_rubrique(ActionEvent event) {
          try {
            FXMLLoader fxmll= new FXMLLoader(getClass().getResource("Rubriques.fxml"));
            Parent root= fxmll.load();
            rubrique.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void go_to_commentaire(ActionEvent event) {
          try {
            FXMLLoader fxmll= new FXMLLoader(getClass().getResource("Commentaires.fxml"));
            Parent root= fxmll.load();
            commentaire.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void serach(KeyEvent event) {
        search.setOnKeyReleased(e->{
         String requete = "SELECT * FROM `commentaire` where contenucommentaire LIKE '%"+search.getText()+"%'" ;
            PreparedStatement pst;
     try {
         pst = new MyConnection().cn.prepareStatement(requete);
     
        ResultSet resultSet = pst.executeQuery();
         
        CommentaireList.clear();
            while (resultSet.next()){
                CommentaireList.add(new  Commentaire(
                        resultSet.getInt("idcommentaire"),
                        resultSet.getInt("clientid"),
                        resultSet.getString("contenucommentaire"),
                        resultSet.getString("datecommentaire")));
                tablecommentaire.setItems(CommentaireList);
                 
            }}catch (SQLException ex) {
         Logger.getLogger(CommentairesController.class.getName()).log(Level.SEVERE, null, ex);
     }
     });
    }

    
}
