/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Rubrique;
import java.io.IOException;
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
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import services.RubriqueCRUD;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class YogaController implements Initializable {

    private Button rubrique;
    @FXML
       private TableView<Rubrique> tablerubrique;
     @FXML
    private TableColumn<Rubrique, Integer> id;
    @FXML
    private TableColumn<Rubrique, String > titre;
    @FXML
    private TableColumn<Rubrique, String> breve;
    @FXML
    private TableColumn<Rubrique, String> detaille;
    @FXML
    private TableColumn<Rubrique, String> action;
ObservableList<Rubrique>  RubriqueList = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        {String requete = "SELECT * FROM `rubrique` where titre='yoga'";
            PreparedStatement pst;
     try {
         pst = new MyConnection().cn.prepareStatement(requete);
     
        ResultSet resultSet = pst.executeQuery();
        
            while (resultSet.next()){
                RubriqueList.add(new  Rubrique(
                        resultSet.getInt("associeid"),
                        resultSet.getString("titre"),
                        resultSet.getString("descriptionbreve"),
                        resultSet.getString("descriptiondetaille")));
                       
                 
        id.setCellValueFactory(new PropertyValueFactory<>("associeid"));
        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        breve.setCellValueFactory(new PropertyValueFactory<>("descriptiondetaille"));
        detaille.setCellValueFactory(new PropertyValueFactory<>("descriptionbreve"));
   
        
         //add cell of button edit 
         Callback<TableColumn<Rubrique, String>, TableCell<Rubrique, String>> cellFoctory = (TableColumn<Rubrique, String> param) -> {
            // make cell containing buttons
            final TableCell<Rubrique, String> cell = new TableCell<Rubrique, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

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
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                            
                              
                                Rubrique rubrique = tablerubrique.getSelectionModel().getSelectedItem();
                                RubriqueCRUD rcd = new RubriqueCRUD();
                                rcd.Supprimer_Rubrique(rubrique.getAssocieid());
                                  
                                 refreshTable();
                                
                             
                              

                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                           try {
                                Rubrique r  = tablerubrique.getSelectionModel().getSelectedItem();
                                FXMLLoader loader = new FXMLLoader ();
                                loader.setLocation(getClass().getResource("modifierrubrique.fxml"));
                                
                                loader.load();
                                
                                ModifierrubriqueController modifierRubriqueController = loader.getController();
                                
                                modifierRubriqueController.setTextField(r.getAssocieid(), r.getTitre(),
                                        r.getDescriptionbreve(),r.getDescriptiondetaille());
                                Parent parent = loader.getRoot();
                                Stage stage = new Stage();
                                stage.setScene(new Scene(parent));
                                stage.initStyle(StageStyle.UTILITY);
                                stage.show();
                            } catch (IOException ex) {
                                Logger.getLogger(RubriquesController.class.getName()).log(Level.SEVERE, null, ex);
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
         tablerubrique.setItems(RubriqueList);
        
    }    
                
            }catch (SQLException ex) {
         Logger.getLogger(RubriquesController.class.getName()).log(Level.SEVERE, null, ex);
     }
       
    }    
    }    
    
    
    private void refreshTable() {
        
            RubriqueList.clear();
            
             String requete = "SELECT * FROM `rubrique` where titre='yoga'";
            PreparedStatement pst;
     try {
         pst = new MyConnection().cn.prepareStatement(requete);
     
        ResultSet resultSet = pst.executeQuery();
        
            
                
            
           while (resultSet.next()){
                RubriqueList.add(new  Rubrique(
                        resultSet.getInt("associeid"),
                        resultSet.getString("titre"),
                        resultSet.getString("descriptionbreve"),
                        resultSet.getString("descriptiondetaille")));
                tablerubrique.setItems(RubriqueList);
                
            }
            
            
        } catch (SQLException ex) {
           // Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    


    
}
