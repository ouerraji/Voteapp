package application.controller;

import java.io.IOException;

import application.dao.LoginDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



/**
 * FXML Controller class
 *
 * @author hp
 */
public class HomeController {

    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPswrd;
    @FXML
    private Label btnForgot;
    
    @FXML
    private Label lbError;
    @FXML
    private Button btnConnecter;
    @FXML
    private Button btnCreerCompte;   

    
    @FXML
    void connecterClicked(ActionEvent event) {
    	LoginDao dao=new LoginDao();
    	String type=dao.logIn(txtEmail.getText().toString(),txtPswrd.getText().toString());
    	

    	
        switch (type) {
            case "candidat" -> {
               try {
            	   FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/swipe.fxml"));
                   Parent root = loader.load();

                   Scene scene = new Scene(root);

                   Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   currentStage.close();

                   Stage newStage = new Stage();
                   newStage.setScene(scene);
                   newStage.show();
                    
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            case "electeur" -> {
            	System.out.println("eleecteur");

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/swipe.fxml"));
                   Parent root = loader.load();

                   Scene scene = new Scene(root);

                   Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   currentStage.close();

                   Stage newStage = new Stage();
                   newStage.setScene(scene);
                   newStage.show();
                    
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            case "admin" -> {

                try {
                	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/swipe.fxml"));
                    Parent root = loader.load();

                    Scene scene = new Scene(root);

                    Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    currentStage.close();

                    Stage newStage = new Stage();
                    newStage.setScene(scene);
                    newStage.show();
                    
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            default -> {
            	if (txtEmail.getText().isEmpty() || txtPswrd.getText().isEmpty()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erreur de connexion");
                    alert.setHeaderText(null);
                    alert.setContentText("Veuillez saisir votre e-mail et votre mot de passe !");
                    alert.showAndWait();}
            	else {
            	Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur de connexion");
                alert.setHeaderText(null);
                alert.setContentText("E-mail ou mot de passe incorrect !");
                alert.showAndWait();}

            }
        }
    }
    
    @FXML
    void CreerClicked(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/choixCompte.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.show();
            
            
        
    }
   
}
