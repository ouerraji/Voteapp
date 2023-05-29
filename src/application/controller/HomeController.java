package application.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import application.dao.CandidatHomeDao;
import application.dao.LoginDao;
import application.dao.swipeDao;
import application.dao.timerDao;
import application.model.Candidat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



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
            	timerDao dao2 =new timerDao();
            	Date end=dao2.getEnd();
            	Date now=new Date(); 
            	if(now.after(end)) {
            		try {
                 	   FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/winner.fxml"));
                        Parent root = loader.load();

                        Scene scene = new Scene(root);

                        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        

                        Stage newStage = new Stage();
                        newStage.setTitle("Winner");
                        newStage.setScene(scene);
                        newStage.show();
                        
                     } catch (IOException ex) {
                         System.err.println(ex.getMessage());
                     }
            	}
            	else {
               try {
            	   CandidatHomeDao candidatHomeDao=new CandidatHomeDao();
            	   int currentCandidatid=candidatHomeDao.getIdCandidat(txtEmail.getText().toString());
            	   
            	   Candidat c=new Candidat();
                c=candidatHomeDao.LoadCandidat(currentCandidatid);
               	
            	   FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/CandidatHome.fxml"));
                   Parent root = loader.load();
                  CandidatHomeController candidatHomeController=loader.getController();
                  candidatHomeController.displayCandidat(c);
                  
                  
                   

                   Scene scene = new Scene(root);

                   Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   

                   Stage newStage = new Stage();
                   newStage.setTitle("Profil");
                   newStage.setScene(scene);
                   newStage.show();
                   
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }}
            case "electeur" -> {
            	timerDao dao2 =new timerDao();
            	Date end=dao2.getEnd();
            	Date now=new Date(); 
            	if(now.after(end)) {
            		try {
                 	   FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/winner.fxml"));
                        Parent root = loader.load();
                        

                        Scene scene = new Scene(root);

                        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        

                        Stage newStage = new Stage();
                        newStage.setTitle("Winner");
                        newStage.setScene(scene);
                        newStage.show();
                        
                     } catch (IOException ex) {
                         System.err.println(ex.getMessage());
                     }
            	}
            	else {
            	swipeDao swipeDao=new swipeDao();
            	int currentId=swipeDao.getIdElecteur(txtEmail.getText().toString());
            	
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/swipe.fxml"));
                   Parent root = loader.load();
                   swipeController swipeController=loader.getController();
                   swipeController.setId_elec(currentId);

                   Scene scene = new Scene(root);

                   Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   

                   Stage newStage = new Stage();
                   newStage.setTitle("Candidats");
                   newStage.setScene(scene);
                   newStage.show();
                   
                    
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }}
            case "admin" -> {
            	LoginDao loginDao=new LoginDao();
            	String currentNameAdmin=loginDao.getFullnameAdmin(txtEmail.getText().toString());
            
            	
                try {
                	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/All.fxml"));
                    Parent root = loader.load();
                    AllController allController=loader.getController();
                    allController.setname(currentNameAdmin);

                    Scene scene = new Scene(root);

                    Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    currentStage.close();

                    Stage newStage = new Stage();
                    newStage.setTitle("Administration");
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
    	
    	 try{
             FXMLLoader fxmlLoader = new FXMLLoader();
             fxmlLoader.setLocation(getClass().getResource("/application/view/ChoixCompte.fxml"));
             DialogPane choixDialogPane = fxmlLoader.load();
             
             Dialog<ButtonType> dialog = new Dialog<>();
             dialog.setDialogPane(choixDialogPane);
             dialog.setTitle("Choisir le type de votre compte");
             Optional<ButtonType> clickedButton = dialog.showAndWait();
                     
                     
             }catch(IOException e){
             e.printStackTrace();
             }
            
            
        
    }
   
}
