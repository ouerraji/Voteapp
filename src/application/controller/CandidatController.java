package application.controller;

import java.net.URL;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;
import application.util.DBconnection;
import application.model.Candidat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CandidatController implements Initializable{
	public Connection cnx;
	public PreparedStatement pst,ps;
	public ResultSet rs,rst;
    

    @FXML
    private Button ButtonRechercher;

    @FXML
    private TextField EnterIDCandidat;

    @FXML
    private TextField EnterNomCandidat;

    @FXML
    private TextField EnterPrenomCandidat;


    @FXML
    private TableView<Candidat> TableCandidat;

    @FXML
    private TableColumn<Candidat, String> Tadresse;

    @FXML
    private TableColumn<Candidat, String> Tcin;

    @FXML
    private TableColumn<Candidat, Date> Tdatenais;

    @FXML
    private TableColumn<Candidat, String> Temail;

    @FXML
    private TableColumn<Candidat, String> Tgenre;

    @FXML
    private TableColumn<Candidat, Integer> Tidcand;

    @FXML
    private TableColumn<Candidat, Integer> Tidparti;

    @FXML
    private TableColumn<Candidat,String> Tnom;

    @FXML
    private TableColumn<Candidat, String> Tpassword;

  

    @FXML
    private TableColumn<Candidat, String> Tprenom;
    public ObservableList<Candidat> data = FXCollections.observableArrayList();
    public ObservableList<Candidat> dataa = FXCollections.observableArrayList();
    
    private Boolean CheckEmpty() {
    	return (EnterIDCandidat.getText().equals("") && EnterNomCandidat.getText().equals("") &&
    			EnterPrenomCandidat.getText().equals("") );}

@FXML
     void ClickButtonRechercher(ActionEvent event) {
    	if(CheckEmpty()==true) {
    		Alert alert=new Alert(AlertType.ERROR);
        	alert.setTitle("Avertissement");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir au moins un champ");
            Optional<ButtonType> result = alert.showAndWait();
    	}else {
    	String candidatid=EnterIDCandidat.getText();
    	String candidatnom=EnterNomCandidat.getText();
    	String candidatprenom=EnterPrenomCandidat.getText();
    	EnterIDCandidat.clear();
    	EnterNomCandidat.clear();
    	EnterPrenomCandidat.clear();
    	TableCandidat.getItems().clear();
    	dataa.clear();
    	
    	String query = "SELECT * FROM election.candidat WHERE ";
        List<String> conditions = new ArrayList<>();
        List<Object> parameters = new ArrayList<>();

        if (!candidatnom.isEmpty()) {
            conditions.add("nom LIKE ?");
            parameters.add("%" + candidatnom + "%");
        }

        if (!candidatprenom.isEmpty()) {
            conditions.add("prenom LIKE ?");
            parameters.add("%" + candidatprenom + "%");
        }

        if (!candidatid.isEmpty()) {
            conditions.add("id_cand = ?");
            parameters.add(candidatid);
        }
        query += String.join(" OR ", conditions);
        


    		try {
				ps=cnx.prepareStatement(query);
				int parameterIndex = 1;
                for (Object parameter : parameters) {
                    ps.setObject(parameterIndex++, parameter);
                }
	    		

				rst=ps.executeQuery();
				 while(rst.next()) {
			
					Candidat c=new Candidat(rst.getInt("id_cand"),rst.getInt("id_parti"),rst.getString("nom"),rst.getString("prenom"),rst.getString("Adresse"),rst.getString("Email"),rst.getString("Password"),rst.getString("CIN"),rst.getString("genre").charAt(0),rst.getDate("Date_naissance"));
					//System.out.println(c);
					dataa.add(c);
				 
				 }if(dataa.isEmpty()) {
					 Alert alert=new Alert(AlertType.ERROR);
			        	alert.setTitle("Avertissement");
			            alert.setHeaderText(null);
			            alert.setContentText("Aucun candidat trouvé");
			            Optional<ButtonType> result = alert.showAndWait();
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Tpassword.setCellValueFactory(new PropertyValueFactory<Candidat,String>("Password"));
    		Tadresse.setCellValueFactory(new PropertyValueFactory<Candidat,String>("Adresse"));
    		Tidcand.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("id_cand"));
    		Tidparti.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("id_parti"));
    		Tnom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("nom"));
    		Tprenom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("prenom"));
    		Temail.setCellValueFactory(new PropertyValueFactory<Candidat,String>("Email"));
    		Tcin.setCellValueFactory(new PropertyValueFactory<Candidat,String>("cin"));
    		Tgenre.setCellValueFactory(new PropertyValueFactory<Candidat,String>("genre"));
    		Tdatenais.setCellValueFactory(new PropertyValueFactory<Candidat,Date>("Date_naissance"));
    		TableCandidat.setItems(dataa);
    	}};

public void ShowCandidat(){
	String query ="Select * from election.candidat";
	try {
		pst=cnx.prepareStatement(query);
		rs=pst.executeQuery();
		while(rs.next()) {
			data.add(new Candidat(rs.getInt("id_cand"),rs.getInt("id_parti"),rs.getString("nom"),rs.getString("prenom"),rs.getString("Adresse"),rs.getString("Email"),rs.getString("Password"),rs.getString("CIN"),rs.getString("genre").charAt(0),rs.getDate("Date_naissance")));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Tpassword.setCellValueFactory(new PropertyValueFactory<Candidat,String>("Password"));
	Tadresse.setCellValueFactory(new PropertyValueFactory<Candidat,String>("Adresse"));
	Tidcand.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("id_cand"));
	Tidparti.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("id_parti"));
	Tnom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("nom"));
	Tprenom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("prenom"));
	Temail.setCellValueFactory(new PropertyValueFactory<Candidat,String>("Email"));
	Tcin.setCellValueFactory(new PropertyValueFactory<Candidat,String>("cin"));
	Tgenre.setCellValueFactory(new PropertyValueFactory<Candidat,String>("genre"));
	Tdatenais.setCellValueFactory(new PropertyValueFactory<Candidat,Date>("Date_naissance"));
	TableCandidat.setItems(data);
};

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx =DBconnection.getConnection();	
		ShowCandidat();
		
		// TODO Auto-generated method stub
		
	}

}
