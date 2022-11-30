/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;

import com.gn.module.main.Data;
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
public class MescommentairesController implements Initializable {
    
    @FXML
    private TableColumn<Commentaire, Integer> idcommentaire;
     @FXML
    private TableColumn<Commentaire, Integer> clientid;
    @FXML
    private TableColumn<Commentaire, String> contenucommentaire;
    @FXML
    private TableColumn<Commentaire, String> datecommentaire;
    @FXML
    private TableColumn<Commentaire, String> action;

    ObservableList<Commentaire>  CommentaireList = FXCollections.observableArrayList();
     @FXML
    private TableView<Commentaire> tablecommentaire;
    @FXML
    private Button ajout;
   
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        {
      
       
      
            System.out.println(Data.client);
        String requete = "SELECT * FROM `commentaire` where clientid='"+Data.client.getIdClient()+"'";
            PreparedStatement pst;
     try {
         pst = new MyConnection().cn.prepareStatement(requete);
        ResultSet resultSet = pst.executeQuery();
        
            while (resultSet.next()){
                CommentaireList.add(new  Commentaire(
                        resultSet.getInt("idcommentaire"),
                        resultSet.getInt("clientid"),
                        resultSet.getString("contenucommentaire"),
                        resultSet.getString("datecommentaire")));
                       
                 
        idcommentaire.setCellValueFactory(new PropertyValueFactory<>("idcommentaire"));
        clientid.setCellValueFactory(new PropertyValueFactory<>("clientid"));
        contenucommentaire.setCellValueFactory(new PropertyValueFactory<>("contenucommentaire"));
        datecommentaire.setCellValueFactory(new PropertyValueFactory<>("datecommentaire"));
   
        
         //add cell of button edit 
         Callback<TableColumn<Commentaire, String>, TableCell<Commentaire, String>> cellFoctory = (TableColumn<Commentaire, String> param) -> {
            // make cell containing buttons
            final TableCell<Commentaire, String> cell;
                    cell = new TableCell<Commentaire, String>() {
                        @Override
                        public void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            //that cell created only on non-empty rows
                            if (empty) {
                                setGraphic(null);
                                setText(null);
                                
                            } else {
                                
                                FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                                FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL);
                                
                                deleteIcon.setStyle(
                                        " -fx-cursor: hand ;"
                                                + "-glyph-size:28px;"
                                                + "-fx-fill:#ff1744;"
                                );
                                editIcon.setStyle(
                                        " -fx-cursor: hand ;"
                                                + "-glyph-size:28px;"
                                                + "-fx-fill:#00E676;"
                                );
                                deleteIcon.setOnMouseClicked((MouseEvent event)-> {
                                    
                                    
                                    
                                    Commentaire commentaire = (Commentaire) tablecommentaire.getSelectionModel().getSelectedItem();
                                    CommentaireCrud rcd = new CommentaireCrud();
                                    rcd.supprimer_commentaire(commentaire.getIdcommentaire());
                                    
                                    refreshTable();
                                });
                                editIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                          try {
                                Commentaire r  = tablecommentaire.getSelectionModel().getSelectedItem();
                                FXMLLoader loader = new FXMLLoader ();
                                loader.setLocation(getClass().getResource("modifiercommentaire.fxml"));
                                
                                loader.load();
                                
                                ModifiercommentaireController ModifierCommentaireController = loader.getController();
                                
                                ModifierCommentaireController.setTextField(
                                        r.getContenucommentaire());
                                Parent parent = loader.getRoot();
                                Stage stage = new Stage();
                                stage.setScene(new Scene(parent));
                                stage.initStyle(StageStyle.UTILITY);
                                stage.show();
                            } catch (IOException ex) {
                                Logger.getLogger(MescommentairesController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });
                                
                                
                                HBox managebtn = new HBox(editIcon, deleteIcon);
                                managebtn.setStyle("-fx-alignment:center");
                                HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                                HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));
                                
                                setGraphic(managebtn);
                                
                                setText(null);
                                
                            }
                        }
                        
                    };

            return cell;
        };
         action.setCellFactory(cellFoctory);
         tablecommentaire.setItems(CommentaireList);
        
    }    
                
            }catch (SQLException ex) {
         Logger.getLogger(MescommentairesController.class.getName()).log(Level.SEVERE, null, ex);
     }
       
    } 
    }    
    private void refreshTable() {
        
            CommentaireList.clear();
            
             String requete = "SELECT * FROM `commentaire`where clientid=1";
            PreparedStatement pst;
     try {
         pst = new MyConnection().cn.prepareStatement(requete);
     
        ResultSet resultSet = pst.executeQuery();
        
            
                
            
           while (resultSet.next()){
                CommentaireList.add(new  Commentaire(
                        resultSet.getInt("idcommentaire"),
                        resultSet.getInt("clientid"),
                        resultSet.getString("contenucommentaire"),
                        resultSet.getString("datecommentaire")));
                tablecommentaire.setItems(CommentaireList);
                 
                
            }
            
            
        } catch (SQLException ex) {
           // Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    

    

    @FXML
    private void go_to_ajoutercommentaire(ActionEvent event) {
         try {
            FXMLLoader fxmll= new FXMLLoader(getClass().getResource("Ajoutercommentaire.fxml"));
            Parent root= fxmll.load();
            ajout.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
}
