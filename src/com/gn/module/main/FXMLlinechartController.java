/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.module.main;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oasis
 */
public class FXMLlinechartController implements Initializable {

    @FXML
    private BarChart<?, ?> barchart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
     private Connection connectdb(){
        String url ="jdbc:mysql://localhost:3306/projet3a";
        String login="root";
        String pwd ="";
         try {
            Connection cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Cnx etablie");
        } catch (SQLException ex) {
            System.out.println("Problème de cnx");
            System.out.println(ex.getMessage());
        }
         return null;
        
    }

    @FXML
    private void loadst(ActionEvent event) {
        XYChart.Series set1=new XYChart.Series<>();
set1.getData().add(new XYChart.Data<>("Lundi",1));
set1.getData().add(new XYChart.Data<>("Mardi",2));
set1.getData().add(new XYChart.Data<>("Mercredi",3));
set1.getData().add(new XYChart.Data<>("Jeudi",4));
set1.getData().add(new XYChart.Data<>("Vendredi",5));
set1.getData().add(new XYChart.Data<>("Samedi",6));
set1.getData().add(new XYChart.Data<>("Dimanche",7));
barchart.getData().addAll(set1);
    }

    @FXML
    private void retourmenu(ActionEvent event) throws IOException {
        Parent d_page = FXMLLoader.load(getClass().getResource("rdvs.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show();
    }

    @FXML
    private void reto(ActionEvent event) throws IOException {
        Parent d_page = FXMLLoader.load(getClass().getResource("FXMLfacturep.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show();
    }
    
}
