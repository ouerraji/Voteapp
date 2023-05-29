package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ChoixCompteController implements Initializable {

    @FXML
    private Button btnCandidat;
    @FXML
    private Button btnelecteur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void handleButtonAction(ActionEvent event){
    
        if(event.getSource()== btnCandidat){
            try{
              Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.close();
                        
                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/application/view/I1.fxml")));
                        stage.setScene(scene);
                        stage.setTitle("Inscription du Candidat");
                        stage.show();
             } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }                   
        }
        
        else if(event.getSource()== btnelecteur){
            try{
              Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.close();
                        
                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/application/view/electeurRegistration.fxml")));
                        stage.setScene(scene);
                        stage.setTitle("Inscription du Electeur");
                        stage.show();
             } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }                   
        }
        
        
        
        
        
        
        
    
    
    
    
    
    }
    
    
    
    
    
    
    
}
