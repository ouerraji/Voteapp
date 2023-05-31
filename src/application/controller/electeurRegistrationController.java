package application.controller;


import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import application.model.*;
import application.dao.*;

public class electeurRegistrationController implements Initializable {

    @FXML
    private Label adresselabel;

    @FXML
    private TextField adressetxt;

    @FXML
    private Hyperlink auth;

    @FXML
    private Label cinlabel;

    @FXML
    private TextField cintxt;

    @FXML
    private Label coemaillabel;

    @FXML
    private PasswordField copasswordtxt;

    @FXML
    private Label confirmlabel;

    @FXML
    private TextField confirmtxt;
    
    @FXML
    private Button inscrire;

    @FXML
    private DatePicker dateinput;

    @FXML
    private Label datelabel;

    @FXML
    private Label emaillabel;

    @FXML
    private TextField emailtxt;

    @FXML
    private ChoiceBox<String> genrechoice;
    public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		genrechoice.getItems().add("Homme");
		genrechoice.getItems().add("Femme");

		
	}    
    

    @FXML
    private Label genrelabel;

    @FXML
    private Label nomlabel;

    @FXML
    private TextField nomtxtfield;

    @FXML
    private Label passwordlabel;

    @FXML
    private PasswordField passwordtx;

    @FXML
    private Label prenomlabel;

    @FXML
    private TextField prenomtxt;

    @FXML
    private Label telelabel;

    @FXML
    private TextField teletx;

    @FXML
    private Label titleform;

    @FXML
    private ImageView votingonline;

    @FXML
    void authentificationclicked(ActionEvent event) {

    }

    @FXML
    void dejainscritlabel(MouseEvent event) {

    }

    @FXML
    void inscrireclicked(ActionEvent event) throws IOException {
    	
    	if (nomtxtfield.getText().isEmpty() || prenomtxt.getText().isEmpty() || dateinput.getValue()==null || genrechoice.getValue()==null || adressetxt.getText().isEmpty() || confirmtxt.getText().isEmpty() || passwordtx.getText().isEmpty() || copasswordtxt.getText().isEmpty() || cintxt.getText().isEmpty() || teletx.getText().isEmpty() ) {
			Alert alert=new Alert(AlertType.ERROR);
    	alert.setTitle("Avertissement");
        alert.setHeaderText(null);
        
        alert.setContentText("Veuillez remplir tous les champs.");
        Optional<ButtonType> result = alert.showAndWait();
		}
    	else if (!emailtxt.getText().equals(confirmtxt.getText())){
    		Alert alert=new Alert(AlertType.ERROR);
    	alert.setTitle("Avertissement");
        alert.setHeaderText(null);
        
        alert.setContentText("L'adresse email et sa confirmation ne correspondent pas");
        Optional<ButtonType> result = alert.showAndWait();
    	}
    	else if( !passwordtx.getText().equals(copasswordtxt.getText())){
    		Alert alert=new Alert(AlertType.ERROR);
    	alert.setTitle("Avertissement");
        alert.setHeaderText(null);
        
        alert.setContentText("Le mot de passe et sa confirmation ne correspondent pas");
        Optional<ButtonType> result = alert.showAndWait();
    		
    	}else {
    		Electeur e=new Electeur();
    		e.setNom(nomtxtfield.getText());
    		e.setPrenom(prenomtxt.getText());
    		e.setDate_Naissance(Date.valueOf(dateinput.getValue()));
    		e.setGenre(genrechoice.getValue().charAt(0));
    		e.setAdresse(adressetxt.getText());
    		e.setEmail(emailtxt.getText());
    		e.setPassword(passwordtx.getText());
    		e.setTel(teletx.getText());
    		e.setCIN(cintxt.getText());
    		ElecteurDAO dao=new ElecteurDAO();
    		dao.addElecteur(e);
    		
    		Alert alert=new Alert(AlertType.INFORMATION);
        	alert.setTitle("Inscription réussie");
            alert.setHeaderText(null);
            
            alert.setContentText("L'inscription a réussi !");
            Optional<ButtonType> result = alert.showAndWait();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Home.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();

		}
    }

	

}
