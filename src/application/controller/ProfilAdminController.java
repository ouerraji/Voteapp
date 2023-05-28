package application.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import application.util.DBconnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ProfilAdminController implements Initializable {
	public Connection cnx;
	public PreparedStatement ps,pst;
	public ResultSet rst,rs;
	  private Boolean CheckEmpty() {
	    	return (EnterEmail.getText().equals("") || EnterCIN.getText().equals("") ||
	    			EnterAncienmdps.getText().equals("") || ConfirmNvmdps.getText().equals("") || EnterNvmdps.getText().equals(""));}
    @FXML
    private Button ButtonModifier;

    @FXML
    private Button Buttonmdpsoublie;

    @FXML
    private PasswordField ConfirmNvmdps;

    @FXML
    private PasswordField EnterAncienmdps;

    @FXML
    private TextField EnterCIN;

    @FXML
    private TextField EnterEmail;

    @FXML
    private PasswordField EnterNvmdps;

    @FXML
    void ClickModifier(ActionEvent event) {
        if (CheckEmpty() == true) {
        	
            EnterAncienmdps.clear();
            EnterNvmdps.clear();
            ConfirmNvmdps.clear();
        	Alert alert=new Alert(AlertType.ERROR);
        	alert.setTitle("Avertissement");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs");
            Optional<ButtonType> result = alert.showAndWait();
        }else {
            String cinn = EnterCIN.getText();
            String emaill = EnterEmail.getText();
            String mdps = EnterAncienmdps.getText();
            String nwmdps = EnterNvmdps.getText();
            String cnwmdps = ConfirmNvmdps.getText();
           // String idadmin = 
            System.out.println(" "+cinn+" "+emaill+" "+mdps);
            String selectQuery = "SELECT cin, Email, password FROM election.admins WHERE id_admin=1"; //id_admin=? !!
            try {
                ps = cnx.prepareStatement(selectQuery);
                //ps.setString(1, idadmin);
                ResultSet rst = ps.executeQuery();
                if (rst.next()) {
                	if(rst.getString("password").equals(mdps) && rst.getString("cin").equals(cinn)&& rst.getString("Email").equals(emaill)){
                        System.out.println("toutes les données existent");
                    String updateQuery = "UPDATE election.admins SET password = ? where id_admin=1"; //id_admin=?

                    pst=cnx.prepareStatement(updateQuery);
                    pst.setString(1, nwmdps);
                    //pst.setString(2, idadmin);
                    if(nwmdps.equals(cnwmdps)) {
                    int r = pst.executeUpdate();
                    if (r > 0) {
                    	EnterCIN.clear();
                        EnterEmail.clear();
                        EnterAncienmdps.clear();
                        EnterNvmdps.clear();
                        ConfirmNvmdps.clear();
                    	Alert alert=new Alert(AlertType.INFORMATION);
                    	alert.setTitle("UPDATE PASSWORD");
                        alert.setHeaderText(null);
                        alert.setContentText("Mot de passe modifié avec succès");
                        Optional<ButtonType> result = alert.showAndWait();
                    } else {
                    	
                        System.out.println("Mot de passe n'est pas modifié");
                    }
                    }else {
                    EnterNvmdps.clear();
                    ConfirmNvmdps.clear();
                    	Alert alert=new Alert(AlertType.ERROR);
                    	alert.setTitle("Avertissement");
                        alert.setHeaderText(null);
                        alert.setContentText("Le mot de passe et sa confirmation ne correspondent pas");
                        Optional<ButtonType> result = alert.showAndWait();
                    }
                	}else {
                        EnterAncienmdps.clear();
                        EnterNvmdps.clear();
                        ConfirmNvmdps.clear();
                	Alert alert=new Alert(AlertType.WARNING);
                	alert.setTitle("Avertissement");
                    alert.setHeaderText(null);
                    alert.setContentText("Le mot de passe entré est incorrect, réessayez!");
                    Optional<ButtonType> result = alert.showAndWait();
                        }
                        	
                        }
                
                       
            }  catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx =DBconnection.getConnection();	

		// TODO Auto-generated method stub
		
	}

}
