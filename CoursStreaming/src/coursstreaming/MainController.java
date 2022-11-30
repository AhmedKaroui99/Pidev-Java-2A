/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursstreaming;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author werte
 */
public class MainController implements Initializable {
    
   private Stage stage ;
  private Scene mainscene;
 
  private CoursController coursController ;
  private MainController mainController;

    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void start(Stage stage) {
        System.out.println("main is ready");
        this.stage=stage;
        mainscene = stage.getScene();
        
       
    }
@FXML
    private void AddCours(ActionEvent event) throws IOException 
    {
        Parent coursParent = FXMLLoader.load(getClass().getResource("Cours.fxml"));
        Scene coursScene = new Scene (coursParent);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(coursScene);
        window.show();
        
        
       
        
    }

    @FXML
    private void AddStreaming(ActionEvent event) throws IOException  {
         Parent streamingParent = FXMLLoader.load(getClass().getResource("Streaming.fxml"));
        Scene streamingScene = new Scene (streamingParent);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(streamingScene);
        window.show();
    }

}