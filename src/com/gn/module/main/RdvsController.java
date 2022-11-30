/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.module.main;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import entities.rendezvous;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Integer.parseInt;
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
import javafx.collections.FXCollections;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import services.servicesrendezvous;

/**
 * FXML Controller class
 *
 * @author Oasis
 */
public class RdvsController implements Initializable {
    servicesrendezvous ps = new servicesrendezvous();
    ObservableList<rendezvous> list = ps.getParkingList();
    ObservableList <String> tftypeList =FXCollections.observableArrayList("En ligne","en espéces");

    @FXML
    private TextField tfidRdv;
    @FXML
    private TextField tfclientid;
    @FXML
    private TextField tfdate;
    @FXML
    private TextField tfetat;
    @FXML
    private TextField tfassocieid;
    @FXML
    private TableView<rendezvous> Tableview;
    @FXML
    private TableColumn<rendezvous, Integer> idRdvColonne;
    @FXML
    private TableColumn<rendezvous, Integer> clientidColonne;
    @FXML
    private TableColumn<rendezvous, Integer> associeidColonne;
    @FXML
    private TableColumn<rendezvous, String> dateColonne;
    @FXML
    private TableColumn<rendezvous, String> etatColonne;
    @FXML
    private TableColumn<rendezvous, String> TypepaiementColonne;
    @FXML
    private TableColumn<rendezvous, Date> daterend;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button btnmodifier;
    @FXML
    private TextField tsrecherche;
    @FXML
    private ChoiceBox<String> tfTypepaiement;
    @FXML
    private Button btnspeak;
    @FXML
    private DatePicker daterendezvous;
    @FXML
    private ImageView imagespeak;
    rendezvous tc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Showrdv();
         addListenerToTable();
     tfTypepaiement.setItems(tftypeList);
  
    
    } 
    
     public void Showrdv() {
          servicesrendezvous tc = new servicesrendezvous ();
        ObservableList<rendezvous> list  = tc.getParkingList();
            idRdvColonne.setCellValueFactory(new PropertyValueFactory<rendezvous,Integer>("idRdv"));
        clientidColonne.setCellValueFactory(new PropertyValueFactory<rendezvous,Integer>("clientid"));
        associeidColonne.setCellValueFactory(new PropertyValueFactory<rendezvous,Integer>("associeid"));
       dateColonne.setCellValueFactory(new PropertyValueFactory<rendezvous,String>("date"));
       etatColonne.setCellValueFactory(new PropertyValueFactory<rendezvous,String>("etat"));
       TypepaiementColonne.setCellValueFactory(new PropertyValueFactory<rendezvous,String>("Typepaiement"));
        daterend.setCellValueFactory(new PropertyValueFactory<rendezvous,Date>("dater"));


        Tableview.setItems(list);
       FilteredList<rendezvous> filteredData = new FilteredList<>(list,b-> true);
       tsrecherche.textProperty().addListener((observable,oldvalue,newvalue) -> {
        filteredData.setPredicate((rendezvous rdv) -> {
            if (newvalue==null || newvalue.isEmpty()){
                return true;
            }
            String lowerCaseFilter = newvalue.toLowerCase();
                
            if (rdv.getDate().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
            return true; 
            } if (String.valueOf(rdv.getEtat()).contains(lowerCaseFilter)) {
            return true; 
            }
            if (String.valueOf(rdv.getTypepaiement()).contains(lowerCaseFilter)) {
            return true; 
            }
            else  
             return false; 
            });
        Tableview.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    if (newSelection != null) {
       tfidRdv.setText(String.valueOf(newSelection.getIdRdv()));
       tfclientid.setText(String.valueOf(newSelection.getClientid()));
       tfdate.setText(String.valueOf(newSelection.getDate()));
       tfetat.setText(String.valueOf(newSelection.getEtat()));
       tfTypepaiement.setValue(String.valueOf(newSelection.getTypepaiement()));
       this.tc= newSelection;            
    }
});
            
        SortedList<rendezvous> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(Tableview.comparatorProperty());
        Tableview.setItems(sortedData); 
        });

    }
     
       private void addListenerToTable(){
        servicesrendezvous cs = new servicesrendezvous();
        ObservableList<rendezvous> list = cs.getParkingList();
        Tableview.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            if(newSelection!=null){
                btnmodifier.setDisable(false);
                
                
                tfidRdv.setText(String.valueOf(newSelection.getIdRdv()));
        tfclientid.setText(String.valueOf(newSelection.getClientid()));
        tfassocieid.setText(String.valueOf(newSelection.getAssocieid()));
       tfdate.setText(newSelection.getDate());
        tfetat.setText(newSelection.getEtat());
        tfTypepaiement.setValue(newSelection.getTypepaiement());
//        daterendezvous.setValue(newSelection.getDater().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        daterendezvous.setValue(Instant.ofEpochMilli(newSelection.getDater().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
       
            }else{
                tfidRdv.setText("");
        tfclientid.setText("");
        tfassocieid.setText("");
        tfdate.setText("");
        tfetat.setText("");
        tfTypepaiement.setValue(null);
        
        daterendezvous.setValue(null);
       
       
       
       
                btnmodifier.setDisable(false);
               
                
                
            }
    
    
      });  
    }

    @FXML
    private void ajouterrdv(ActionEvent event) {
          if((( tfclientid.getText()== null|| tfassocieid.getText()== null|| tfdate.getText()== null)) || tfetat.getText()== null|| tfTypepaiement.getValue()== null)
         { 
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("data invalide");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Verifier les champs vides");
             
             alert.showAndWait();
         }
         
         
          else{
         servicesrendezvous sp = new servicesrendezvous();
        rendezvous p = new rendezvous();
//        p.setIdRdv(parseInt(tfidRdv.getText()));
        p.setClientid(parseInt(tfclientid.getText()));
        p.setAssocieid(parseInt(tfassocieid.getText()));
        p.setDate(tfdate.getText());
        p.setEtat(tfetat.getText());
        p.setTypepaiement(tfTypepaiement.getValue());
         java.sql.Date date2 = java.sql.Date.valueOf(daterendezvous.getValue());
         p.setDater(date2);
        sp.ajouterrdv(p);
          Showrdv();
          Notifications.create().title("Notifications").text("rendez-vous ajouté").darkStyle().position(Pos.TOP_CENTER).showWarning();
          
        
          
    }
    }

    @FXML
    private void supp(ActionEvent event) {
           if(((tfidRdv.getText().isEmpty() || tfclientid.getText()== null|| tfassocieid.getText()== null|| tfdate.getText()== null)) || tfetat.getText()== null|| tfTypepaiement.getValue()== null)
         { 
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("data invalide");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Verifier les champs vides");
             
             alert.showAndWait();
         }
         
         
          else{
         rendezvous c=Tableview.getSelectionModel().getSelectedItem();
        if(c==null){
        
           System.out.println("Veillez choisir un rendez-vous");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("choisir un rendez-vous");
            alert.setHeaderText(null);
            alert.setContentText("Veillez choisir  à supprimer !");

            alert.showAndWait();
     
        }else{
          servicesrendezvous sc = new servicesrendezvous();
          int clientid  = c.getClientid();
          try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Supprimer rendez-vous ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez supprimer un rendez-vous! ");
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                     System.out.println("sup1");
                    sc.Supprimerrendezvous(c);
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("SUPPRIMER rendez-vous");
                    alert1.setHeaderText(null);
                    alert1.setContentText("le rendez-vous est supprimée");

                    alert1.showAndWait();
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
       Showrdv();
        Notifications.create().title("Notifications").text("rendez-vous Supprimé").darkStyle().position(Pos.TOP_CENTER).showWarning();
    }
    }

    @FXML
    private void modifierrdv(ActionEvent event) {
        if(((tfidRdv.getText().isEmpty() || tfclientid.getText()== null|| tfassocieid.getText()== null|| tfdate.getText()== null)) || tfetat.getText()== null|| tfTypepaiement.getValue()== null)
         { 
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("data invalide");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Verifier les champs vides");
             
             alert.showAndWait();
         }
         
         
          else{
 
         rendezvous c=Tableview.getSelectionModel().getSelectedItem();
        if(c==null){
        
           System.out.println("Veillez choisir la facture");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("choisir facture");
            alert.setHeaderText(null);
            alert.setContentText("Veillez choisir facture à supprimer !");

            alert.showAndWait();
     
        }else{
          servicesrendezvous sc = new servicesrendezvous();
          int idRdv = c.getIdRdv();
          try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("modifier rendez-vous ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez modifier! " );
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    c.setIdRdv(parseInt(tfidRdv.getText()));
        c.setClientid(parseInt(tfclientid.getText()));
        c.setAssocieid(parseInt(tfassocieid.getText()));
        c.setDate(tfdate.getText());
        c.setEtat(tfetat.getText());
        c.setTypepaiement(tfTypepaiement.getValue());
       java.sql.Date date3 = java.sql.Date.valueOf(daterendezvous.getValue());
         c.setDater(date3);

                    sc.modifierrdv(c);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
              
        }
       Showrdv();
       Notifications.create().title("Notifications").text("rendez-vous modifié").darkStyle().position(Pos.TOP_CENTER).showWarning();
        
    
}
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLfacturep.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    @FXML
    private void imprimer(ActionEvent event) throws SQLException, DocumentException, ClassNotFoundException {
         try {
              Class.forName("com.mysql.jdbc.Driver");
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet3a", "root", "");
      PreparedStatement pt = con.prepareStatement("select * from rdv");
            ResultSet rs = pt.executeQuery();
            
////                       /* Step-2: Initialize PDF documents - logical objects */

                       Document my_pdf_report = new Document();

                       PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report_from_sql_using_java.pdf"));
                       
                        my_pdf_report.open();  
                       my_pdf_report.add(new Paragraph(new Date().toString()));
//                         Image img = Image.getInstance("‪‪C:\\Users\\Oasis\\Documents\\NetBeansProjects\\Application2\\src\\mootaz.png");
//                         img.setAlignment(Element.ALIGN_CENTER);
//                         img.scaleToFit(100, 100);
//                            my_pdf_report.add(img);
                             my_pdf_report.add(new Paragraph("Listes des rendez-vous"));
                       my_pdf_report.addCreationDate();
              
                       
                       //we have four columns in our table
                       PdfPTable my_report_table = new PdfPTable(7);
                             
                       //create a cell object
                       PdfPCell table_cell;
                       
                       
                                       table_cell=new PdfPCell(new Phrase(" idRdv"));
                                      table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("clientid"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("associeid"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("Email"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("etat"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("Typepaiement"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("Daterendezvous"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       
                                       

                                      while(rs.next()){
                                      
                                       String idRdv= rs.getString("idRdv");
                                       table_cell=new PdfPCell(new Phrase(idRdv));
                                       my_report_table.addCell(table_cell);
                                       String type=rs.getString("clientid");
                                       table_cell=new PdfPCell(new Phrase(type));
                                       my_report_table.addCell(table_cell);
                                       String ds=rs.getString("associeid");
                                       table_cell=new PdfPCell(new Phrase(ds));
                                       my_report_table.addCell(table_cell);
                                       String dd=rs.getString("date");
                                       table_cell=new PdfPCell(new Phrase(dd));
                                       my_report_table.addCell(table_cell);
                                        String df = rs.getString("etat");
                                       table_cell=new PdfPCell(new Phrase(df));
                                       my_report_table.addCell(table_cell);
                                        String dr = rs.getString("Typepaiement");
                                       table_cell=new PdfPCell(new Phrase(dr));
                                       my_report_table.addCell(table_cell); 
                                       String de = rs.getString("dater");
                                       table_cell=new PdfPCell(new Phrase(de));
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
    private void retourmenu(ActionEvent event) throws IOException {
        Parent d_page = FXMLLoader.load(getClass().getResource("FXMLmenu.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show();
        
    }

    @FXML
    private void constatistiques(ActionEvent event) throws IOException {
        Parent d_page = FXMLLoader.load(getClass().getResource("FXMLlinechart.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show();
        
    }

    @FXML
    private void email(ActionEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("sendmailrdv.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show();
        
    }

    @FXML
    private void calendar(ActionEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("calendrier.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show();
        
    }
    private static final String VOICENAME="kevin16";

    @FXML
    private void speak(ActionEvent event) {
               imagespeak.setVisible(true);
        Voice voice;
        VoiceManager vm=VoiceManager.getInstance();
        voice=vm.getVoice(VOICENAME);
        voice.allocate();
        try{
              voice.speak("hello It is my pleasure to welcome everyone to our application and thank you for your kindly visit  ");
//              voice.speak(tfclientid.getText());
//                voice.speak(tfetat.getText());
//                  voice.speak(tfdate.getText());
//                    voice.speak(tfTypepaiement.getValue());
            
        }catch(Exception e)
        {
            
        }
       
    }

    @FXML
    private void showdate(ActionEvent event) {
    }
    
}
