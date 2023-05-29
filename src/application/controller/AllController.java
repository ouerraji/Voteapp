package application.controller;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import application.util.DBconnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AllController implements Initializable{
private Parent fxml;
public Connection cnx;
public PreparedStatement pst;
public ResultSet rs;
    @FXML
    private AnchorPane Anchor1;

    @FXML
    private AnchorPane Anchor2;

    @FXML
    private AnchorPane Anchor3;

    @FXML
    private Button ButtonAccueil;

    @FXML
    private Button ButtonCandidat;

    @FXML
    private Button ButtonElecteur;

    @FXML
    private Button ButtonElection;

    @FXML
    private Button ButtonLogout;

    @FXML
    private Button ButtonParti;

    @FXML
    private Button ButtonResultat;

    @FXML
    private Button EspaceAdmin;

    @FXML
    private Label NomaAdmin;
    
   




	@FXML
    private Label NombreCandidatsTotal;

    @FXML
    private Label NombreElecteursTotal;

    @FXML
    private Label NombreVotesTotal;

    @FXML
    private Pane Pane1;
    @FXML
    void ClickButtonAccueil(MouseEvent event) {
    	ButtonCalendrier.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonAccueil.setStyle("-fx-background-color: #016e7a; -fx-text-fill: white;");
    	ButtonCandidat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElecteur.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElection.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonParti.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonResultat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonLogout.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	try {
			fxml = FXMLLoader.load(getClass().getResource("/application/view/Accueil.fxml"));
			Anchor2.getChildren().removeAll();
	    	Anchor2.getChildren().setAll(fxml);
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void ClickButtonAdmin(ActionEvent event) {
    	ButtonCalendrier.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonAccueil.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonCandidat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElecteur.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElection.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonParti.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonResultat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonLogout.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");

     	try {
			fxml = FXMLLoader.load(getClass().getResource("/application/view/ProfilAdmin.fxml"));
			Anchor2.getChildren().removeAll();
	    	Anchor2.getChildren().setAll(fxml);
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void ClickButtonCandidat(MouseEvent event) {
    	ButtonCalendrier.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonAccueil.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonCandidat.setStyle("-fx-background-color: #016e7a; -fx-text-fill: white;");
    	ButtonElecteur.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElection.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonParti.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonResultat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonLogout.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	try {
			fxml = FXMLLoader.load(getClass().getResource("/application/view/Candidat.fxml"));
			Anchor2.getChildren().removeAll();
	    	Anchor2.getChildren().setAll(fxml);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void ClickButtonElecteur(MouseEvent event) {
    	ButtonCalendrier.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonAccueil.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonCandidat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElecteur.setStyle("-fx-background-color: #016e7a; -fx-text-fill: white;");
    	ButtonElection.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonParti.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonResultat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonLogout.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
      	try {
			fxml = FXMLLoader.load(getClass().getResource("/application/view/Electeur.fxml"));
			Anchor2.getChildren().removeAll();
	    	Anchor2.getChildren().setAll(fxml);
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }
    @FXML
    private Button ButtonCalendrier;
    @FXML
    void ClickButtonCalendrier(MouseEvent event) {
    	ButtonCalendrier.setStyle("-fx-background-color: #016e7a; -fx-text-fill: white;");
    	ButtonAccueil.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonCandidat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElecteur.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElection.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonParti.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonResultat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonLogout.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	try {
			fxml = FXMLLoader.load(getClass().getResource("/application/view/time.fxml")); 
			Anchor2.getChildren().removeAll();
	    	Anchor2.getChildren().setAll(fxml);
	    	
		} catch (IOException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		
		}

    }
    @FXML
    void ClickButtonElection(MouseEvent event) {
    	ButtonCalendrier.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonAccueil.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonCandidat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElecteur.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElection.setStyle("-fx-background-color: #016e7a; -fx-text-fill: white;");
    	ButtonParti.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonResultat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonLogout.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
     	try {
			fxml = FXMLLoader.load(getClass().getResource("/application/view/Election.fxml"));
			Anchor2.getChildren().removeAll();
	    	Anchor2.getChildren().setAll(fxml);
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void ClickButtonLogout(MouseEvent event) {
    	ButtonCalendrier.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonAccueil.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonCandidat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElecteur.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElection.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonParti.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonResultat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonLogout.setStyle("-fx-background-color: #016e7a; -fx-text-fill: white;");
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("LOG OUT");
        alert.setHeaderText(null);
        alert.setContentText("Vous allez etre deconnecter de votre espace administrateur");
        Optional<ButtonType> result = alert.showAndWait();
        try {
      	   FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Home.fxml"));
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
        //

    }

    @FXML
    void ClickButtonParti(MouseEvent event) {
    	ButtonCalendrier.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
      	ButtonAccueil.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonCandidat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElecteur.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElection.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonParti.setStyle("-fx-background-color: #016e7a; -fx-text-fill: white;");
    	ButtonResultat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonLogout.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
     	try {
			fxml = FXMLLoader.load(getClass().getResource("/application/view/Parti.fxml"));
			Anchor2.getChildren().removeAll();
	    	Anchor2.getChildren().setAll(fxml);
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void ClickButtonResultat(MouseEvent event) {
    	ButtonCalendrier.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonAccueil.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonCandidat.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElecteur.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonElection.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonParti.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
    	ButtonResultat.setStyle("-fx-background-color: #016e7a; -fx-text-fill: white;");
    	ButtonLogout.setStyle("-fx-background-color: #018594; -fx-text-fill: white;");
     	try {
			fxml = FXMLLoader.load(getClass().getResource("/application/view/Resultat.fxml"));
			Anchor2.getChildren().removeAll();
	    	Anchor2.getChildren().setAll(fxml);
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	cnx =DBconnection.getConnection();
	//NomaAdmin.setText("Hello");
	
	}
	public void setname(String nom) {
		NomaAdmin.setText(nom);
	}

}
