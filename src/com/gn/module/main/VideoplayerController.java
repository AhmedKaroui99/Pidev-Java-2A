/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.module.main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oasis
 */
public class VideoplayerController implements Initializable {

    @FXML
    private MediaView mv;
    private  MediaPlayer mp;
   private  Media media;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         String path=new File("D:/Esprit/3eme/PIDEV/mootaz/pidev/src/assets/mid.mp4").getAbsolutePath();
    media=new Media(new File(path).toURI().toString());
    mp=new MediaPlayer(media);
    mv.setMediaPlayer(mp);
    mp.setAutoPlay(true);
        DoubleProperty width=mv.fitWidthProperty();
         DoubleProperty height=mv.fitWidthProperty();
         width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
    }    

    @FXML
    private void menu(ActionEvent event) throws IOException {
          Parent d_page = FXMLLoader.load(getClass().getResource("FXMLmenu.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show();
    }

    @FXML
    private void pause(ActionEvent event) {
         mp.pause();
    }

    @FXML
    private void paly(ActionEvent event) {
         mp.play();
        mp.setRate(1);
    }

    @FXML
    private void reload(ActionEvent event) {
         mp.seek(mp.getStartTime());
        mp.play();
    }
    
}
