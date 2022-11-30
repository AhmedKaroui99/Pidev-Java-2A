/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.module.main;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.facture;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import services.servicefacture;

/**
 * FXML Controller class
 *
 * @author Oasis
 */
public class FXMLfacturepController implements Initializable {

    @FXML
    private TextField tsclientid;
    @FXML
    private TextField tsmontant;
    @FXML
    private TextField tsdatef;
    @FXML
    private TableView<facture> tableview;
    @FXML
    private TableColumn<facture, Integer> idfacturecolonne;
    @FXML
    private TableColumn<facture, Integer> idRdvcolonnne;
    @FXML
    private TableColumn<facture, Integer> clientidcolonne;
    @FXML
    private TableColumn<facture, Float> montantColonne;
    @FXML
    private TableColumn<facture, String> datefColonne;
    @FXML
    private TableColumn<facture, Date> datefa;
    @FXML
    private TextField tsrecherche;
    @FXML
    private Button btnmodiffacture;
    @FXML
    private DatePicker datefact;
    @FXML
    private Button exporttoexcel;
    @FXML
    private TextField tsidRdv;
    @FXML
    private TextField tsidfacture;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Showfacture();
        addListenerToTable();
    }   
         public void Showfacture() {
          servicefacture tc = new servicefacture ();
        ObservableList<facture> list  = tc.getfactureList();
       clientidcolonne.setCellValueFactory(new PropertyValueFactory<facture,Integer>("clientid"));
       montantColonne.setCellValueFactory(new PropertyValueFactory<facture,Float>("montant"));
       datefColonne.setCellValueFactory(new PropertyValueFactory<facture,String>("datef"));
       datefa.setCellValueFactory(new PropertyValueFactory<facture,Date>("datefacture"));
       idRdvcolonnne.setCellValueFactory(new PropertyValueFactory<facture,Integer>("idRdv"));
       idfacturecolonne.setCellValueFactory(new PropertyValueFactory<facture,Integer>("idfacture"));
       




        tableview.setItems(list);
        FilteredList<facture> filteredData = new FilteredList<>(list,b-> true);
       tsrecherche.textProperty().addListener((observable,oldvalue,newvalue) -> {
        filteredData.setPredicate((facture crudfacture) -> {
            if (newvalue==null || newvalue.isEmpty()){
                return true;
            }
            String lowerCaseFilter = newvalue.toLowerCase();
                
            if (crudfacture.getDatef().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
            return true; 
            } if (String.valueOf(crudfacture.getMontant()).contains(lowerCaseFilter)) {
            return true; 
            }else  
             return false; 
            });
            
        SortedList<facture> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortedData); 
        });


    }
    

    @FXML
    private void ajoutpaiement(ActionEvent event) {
         if(((tsidRdv.getText().isEmpty() ||tsclientid.getText().isEmpty() || tsmontant.getText()== null|| tsdatef.getText()== null )))
         {
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("data invalide");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Verifier les champs vides");
             
             alert.showAndWait();
         }
         
         
          else{
        {
        servicefacture sp = new servicefacture();
        facture cf= new facture();
        cf.setIdRdv(parseInt(tsidRdv.getText()));
        cf.setClientid(parseInt(tsclientid.getText()));
        cf.setMontant(Float.parseFloat(tsmontant.getText()));
        cf.setDatef(tsdatef.getText());
        java.sql.Date date3 = java.sql.Date.valueOf(datefact.getValue());
         cf.setDatefacture(date3);
        sp.ajoutpaiement(cf);
         Showfacture();
         Notifications.create().title("Notifications").text("facture a ajouté").darkStyle().position(Pos.TOP_CENTER).showWarning();
         
         
    }
         }
    }
 
      

    @FXML
    private void supprimerpaiement(ActionEvent event) {
         if((( tsidfacture.getText().isEmpty() ||tsidRdv.getText().isEmpty() ||tsclientid.getText().isEmpty() || tsmontant.getText()== null|| tsdatef.getText()== null)))
         { 
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("data invalide");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Verifier les champs vides");
             
             alert.showAndWait();
         }
         
         
          else{
           facture c=tableview.getSelectionModel().getSelectedItem();
        if(c==null){
        
           System.out.println("Veillez choisir un facture");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("choisir un facture");
            alert.setHeaderText(null);
            alert.setContentText("Veillez choisir  à supprimer !");

            alert.showAndWait();
     
        }else{
          servicefacture sc = new servicefacture();
          int clientid  = c.getClientid();
          try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Supprimer facture ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez supprimer un facture! ");
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                     System.out.println("sup1");
                    sc.Supprimerfacture(c);
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("SUPPRIMER facture");
                    alert1.setHeaderText(null);
                    alert1.setContentText("la facture est supprimée");

                    alert1.showAndWait();
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
       Showfacture();
       Notifications.create().title("Notifications").text("facture a supprimé ").darkStyle().position(Pos.TOP_CENTER).showWarning();
    }
    }
            private void addListenerToTable(){
        servicefacture cs = new servicefacture();
        ObservableList<facture> list = cs.getfactureList();
        tableview.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            if(newSelection!=null){
                btnmodiffacture.setDisable(false);
                
                 tsidRdv.setText(String.valueOf(newSelection.getIdRdv()));
                tsclientid.setText(String.valueOf(newSelection.getClientid()));
        tsmontant.setText(String.valueOf(newSelection.getMontant()));
        tsdatef.setText(String.valueOf(newSelection.getDatef()));
        tsidfacture.setText(String.valueOf(newSelection.getIdfacture()));
        datefact.setValue((Instant.ofEpochMilli(newSelection.getDatefacture().getTime()).atZone(ZoneId.systemDefault()).toLocalDate()));
       
     
        
       
                
            }else{
        tsidRdv.setText("");
        tsclientid.setText("");
        tsmontant.setText("");
        tsdatef.setText("");
        datefact.setValue(null);
      
        
       
       
       
       
                btnmodiffacture.setDisable(false);
               
                
                
            }
    
    
      });  
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("rdvs.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show();
        
    }

    @FXML
    private void modiffa(ActionEvent event) {
             if(((tsidRdv.getText().isEmpty() ||tsclientid.getText().isEmpty() || tsmontant.getText()== null|| tsdatef.getText()== null)))
         { 
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("data invalide");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Verifier les champs vides");
             
             alert.showAndWait();
         }
         
         
          else{
          
            facture c=tableview.getSelectionModel().getSelectedItem();
        if(c==null){
        
           System.out.println("Veillez choisir la facture");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("choisir facture");
            alert.setHeaderText(null);
            alert.setContentText("Veillez choisir facture à modifier !");

            alert.showAndWait();
     
        }else{
          
          servicefacture sc = new servicefacture();
          int clientid = c.getClientid();
          try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("modifier facture ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez modifier! " );
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    c.setClientid(parseInt(tsclientid.getText()));
                    System.out.println(tsidfacture.getText());
                    c.setIdfacture(parseInt(tsidfacture.getText()));
                     c.setIdRdv(parseInt(tsidRdv.getText()));
        c.setMontant(parseFloat((tsmontant.getText())));
        c.setDatef((tsdatef.getText()));
//        c.setDatefacture(datefact.getValue());
java.sql.Date date3 = java.sql.Date.valueOf(datefact.getValue());
         c.setDatefacture(date3);

        

                    sc.modifierfacture(c);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
       Showfacture();
       Notifications.create().title("Notifications").text("facture a modifié").darkStyle().position(Pos.TOP_CENTER).showWarning();
        
    }
    }

    @FXML
    private void imprimerfacture(ActionEvent event) throws DocumentException, SQLException, ClassNotFoundException {
        
               try {
              Class.forName("com.mysql.jdbc.Driver");
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet3a", "root", "");
      PreparedStatement pt = con.prepareStatement("select * from facturepaiement");
            ResultSet rs = pt.executeQuery();
            
                       /* Step-2: Initialize PDF documents - logical objects */

                       Document my_pdf_report = new Document();

                       PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report_from_sql_using_java.pdf"));
                       
                        my_pdf_report.open();  
                       my_pdf_report.add(new Paragraph(new Date().toString()));
//                            Image img = Image.getInstance("C:\image.png");
//                            my_pdf_report.add(img);
                             my_pdf_report.add(new Paragraph("Listes des factures"));
                       my_pdf_report.addCreationDate();
              
                       
                       //we have four columns in our table
                       PdfPTable my_report_table = new PdfPTable(6);
                             
                       //create a cell object
                       PdfPCell table_cell;
                                          table_cell=new PdfPCell(new Phrase("idfacture"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                         table_cell=new PdfPCell(new Phrase("idRdv"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase(" clientid"));
                                      table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("montant"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                               
                                      table_cell=new PdfPCell(new Phrase("Email"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                        table_cell=new PdfPCell(new Phrase("Datefacture"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       
                                       
                                       
                                      while(rs.next()){
                                          String d=rs.getString("idf");
                                       table_cell=new PdfPCell(new Phrase(d));
                                       my_report_table.addCell(table_cell);
                                          String de=rs.getString("idRdv");
                                       table_cell=new PdfPCell(new Phrase(de));
                                       my_report_table.addCell(table_cell);
                                       String idRdv= rs.getString("clientid");
                                       table_cell=new PdfPCell(new Phrase(idRdv));
                                       my_report_table.addCell(table_cell);
                                       String type=rs.getString("montant");
                                       table_cell=new PdfPCell(new Phrase(type));
                                       my_report_table.addCell(table_cell);
                                       String ds=rs.getString("datef");
                                       table_cell=new PdfPCell(new Phrase(ds));
                                       my_report_table.addCell(table_cell);
                                        String dn=rs.getString("datefacture");
                                       table_cell=new PdfPCell(new Phrase(dn));
                                       my_report_table.addCell(table_cell);
                                       
                                       
                                               
                       }
                       /* Attach report table to PDF */
                       
                       my_pdf_report.add(my_report_table); 
                       
             System.out.println(my_pdf_report);
                       my_pdf_report.close();
                       JOptionPane.showMessageDialog(null, "imprimer avec succés");

                       /* Close all DB related objects */
                       rs.close();
                       pt.close(); 
                       con.close();               


       } catch (FileNotFoundException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
       }
    }

    @FXML
    private void tosendfacture(ActionEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("sendemailfacture.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show();
    }

    @FXML
    private void exporttoexcel(ActionEvent event) {
        
       
    }

    }


      

