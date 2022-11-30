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
 * FXML Controller class
 *
 * @author werte
 */
public class StreamingController implements Initializable {

    MainController mainController;
    Scene mainscene;
    private Stage stage;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    void start(Stage stage) {
        System.out.println("Streaming is ready");
        this.stage=stage;
        mainscene = stage.getScene();
        
       
    }
@FXML
    private void BACKmain(ActionEvent event) throws IOException 
    {
        Parent mainParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene mainScene = new Scene (mainParent);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
        
        
       
        
    }
}
