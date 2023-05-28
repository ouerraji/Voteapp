package application.controller;

import java.net.URL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.util.DBconnection;
import application.model.Candidat;
import application.model.Electeur;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ElecteurController implements Initializable {
	public Connection cnx;
	public PreparedStatement pst;
	public ResultSet rs;
	@FXML
    private Button ButtonRechercher;

    @FXML
    private TextField EnterIDElecteur;

    @FXML
    private TextField EnterNomElecteur;

    @FXML
    private TextField EnterPrenomElecteur;

    @FXML
    private TableView<Electeur> TableElecteur;
    @FXML
    private TableColumn<Electeur, String> T;
    @FXML
    private TableColumn<Electeur, String> Tadresse;

    @FXML
    private TableColumn<Electeur, Date> Tdatenais;

    @FXML
    private TableColumn<Electeur, String> Temail;

    @FXML
    private TableColumn<Electeur, String> Tgenre;

    @FXML
    private TableColumn<Electeur, Integer> Tidelec;

    @FXML
    private TableColumn<Electeur, String> Tnom;

    @FXML
    private TableColumn<Electeur, String> Tpassword;

    @FXML
    private TableColumn<Electeur, String> Tprenom;

    @FXML
    private TableColumn<Electeur, String> tcin;
    public ObservableList<Electeur> data = FXCollections.observableArrayList();

    private Boolean CheckEmpty() {
    	return (EnterIDElecteur.getText().equals("") && EnterNomElecteur.getText().equals("") &&
    			EnterPrenomElecteur.getText().equals("") );}
    @FXML
    void ClickButtonRechercher(ActionEvent event) {
    	if(CheckEmpty()==true) {
    		Alert alert=new Alert(AlertType.ERROR);
        	alert.setTitle("Avertissement");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir au moins un champ");
            Optional<ButtonType> result = alert.showAndWait();
    	}else {
        	String electeurid=EnterIDElecteur.getText();
        	String electeurnom=EnterNomElecteur.getText();
        	String electeurprenom=EnterPrenomElecteur.getText();
        	EnterIDElecteur.clear();
        	EnterNomElecteur.clear();
        	EnterPrenomElecteur.clear();
        	TableElecteur.getItems().clear();
        	data.clear();
        	String query = "SELECT * FROM election.electeur WHERE ";
            List<String> conditions = new ArrayList<>();
            List<Object> parameters = new ArrayList<>();

            if (!electeurnom.isEmpty()) {
                conditions.add("nom LIKE ?");
                parameters.add("%" + electeurnom + "%");
            }

            if (!electeurprenom.isEmpty()) {
                conditions.add("prenom LIKE ?");
                parameters.add("%" + electeurprenom + "%");
            }

            if (!electeurid.isEmpty()) {
                conditions.add("id_cand = ?");
                parameters.add(electeurid);
            }
            
            query += String.join(" OR ", conditions);
            

        	
       
        		try {
        			
        			pst=cnx.prepareStatement(query);
    				int parameterIndex = 1;
                    for (Object parameter : parameters) {
                        pst.setObject(parameterIndex++, parameter);
                    }

    				rs=pst.executeQuery();
    				 while(rs.next()) {
    			   			System.out.println(rs);
    			   			Electeur e= new Electeur(rs.getInt("id_elec"),rs.getString("nom"),rs.getString("prenom"),rs.getString("Adresse"),rs.getString("email"),
    		    					rs.getString("password"),rs.getString("CIN"),rs.getString("genre").charAt(0),rs.getString("tel"),rs.getDate("Date_naissance"));
    				 data.add(e);
    				 }if(data.isEmpty()) {
    					 Alert alert=new Alert(AlertType.ERROR);
 			        	alert.setTitle("Avertissement");
 			            alert.setHeaderText(null);
 			            alert.setContentText("Aucun electeur trouvé");
 			            Optional<ButtonType> result = alert.showAndWait();
 				 }
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        		Tidelec.setCellValueFactory(new PropertyValueFactory<Electeur,Integer>("id_elec"));
            	Tnom.setCellValueFactory(new PropertyValueFactory<Electeur,String>("nom"));
            	Tprenom.setCellValueFactory(new PropertyValueFactory<Electeur,String>("prenom"));
            	Tgenre.setCellValueFactory(new PropertyValueFactory<Electeur,String>("genre"));
            	Tdatenais.setCellValueFactory(new PropertyValueFactory<Electeur,Date>("Date_Naissance"));
            	Tadresse.setCellValueFactory(new PropertyValueFactory<Electeur,String>("Adresse"));
            	Temail.setCellValueFactory(new PropertyValueFactory<Electeur,String>("Email"));
            	Tpassword.setCellValueFactory(new PropertyValueFactory<Electeur,String>("Password"));
            	tcin.setCellValueFactory(new PropertyValueFactory<Electeur,String>("CIN"));
            	T.setCellValueFactory(new PropertyValueFactory<Electeur,String>("tel"));
            	TableElecteur.setItems(data);
        	}};

    public void ShowElecteur(){
    	String query ="Select * from election.electeur";
    	try {
    		pst=cnx.prepareStatement(query);
    		rs=pst.executeQuery();
    		while(rs.next()) {
    			data.add(new Electeur(rs.getInt("id_elec"),rs.getString("nom"),rs.getString("prenom"),rs.getString("Adresse"),rs.getString("email"),
    					rs.getString("password"),rs.getString("CIN"),rs.getString("genre").charAt(0),rs.getString("tel"),rs.getDate("Date_Naissance")));
    		}
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	Tidelec.setCellValueFactory(new PropertyValueFactory<Electeur,Integer>("id_elec"));
    	Tnom.setCellValueFactory(new PropertyValueFactory<Electeur,String>("nom"));
    	Tprenom.setCellValueFactory(new PropertyValueFactory<Electeur,String>("prenom"));
    	Tgenre.setCellValueFactory(new PropertyValueFactory<Electeur,String>("genre"));
    	Tdatenais.setCellValueFactory(new PropertyValueFactory<Electeur,Date>("Date_Naissance"));
    	Tadresse.setCellValueFactory(new PropertyValueFactory<Electeur,String>("Adresse"));
    	Temail.setCellValueFactory(new PropertyValueFactory<Electeur,String>("Email"));
    	Tpassword.setCellValueFactory(new PropertyValueFactory<Electeur,String>("Password"));
    	tcin.setCellValueFactory(new PropertyValueFactory<Electeur,String>("CIN"));
    	T.setCellValueFactory(new PropertyValueFactory<Electeur,String>("tel"));
    	TableElecteur.setItems(data);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx =DBconnection.getConnection();	
		ShowElecteur();
		// TODO Auto-generated method stub
		
	}

}
