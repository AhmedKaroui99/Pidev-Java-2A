/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.module.main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oasis
 */
public class CalendrierController implements Initializable {

    @FXML
    private DatePicker date;
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Label labelclock;
    @FXML
    private Label lb3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    private void calendar(ActionEvent event) {
        date=new DatePicker();
        date.setPromptText("Date of rendez-vous");
        date.setMaxWidth(300);
    }
public void clock(){
        Calendar cal=new GregorianCalendar();
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int month=cal.get(Calendar.MONTH);
        int year=cal.get(Calendar.YEAR);
          
        
        int second=cal.get(Calendar.SECOND);
        int minutes=cal.get(Calendar.MINUTE);
        int heure=cal.get(Calendar.HOUR);
        labelclock.setText(+heure+":"+minutes+":"+second);
        
        
        
    
}


    @FXML
    private void showcalendar(ActionEvent event) {
         LocalDate Id=date.getValue();
        lb1.setText(Id.toString());
        lb2.setText("Date du rendez-vous");
        lb3.setText("Time");
        clock();
        
        
    }

    @FXML
    private void re(ActionEvent event) throws IOException {
           Parent d_page = FXMLLoader.load(getClass().getResource("rdvs.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show();
        
    }

    @FXML
    private void fa(ActionEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("FXMLfacturep.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show();
        
    }
    
}
