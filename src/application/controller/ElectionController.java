package application.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;
import application.util.DBconnection;
import application.model.ChercherVotes;
import application.model.Election;
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

public class ElectionController implements Initializable {
	public Connection cnx;
	public PreparedStatement pst,ps;
	public ResultSet rs,rst;

    @FXML
    private Button ButtonRechercher;

    @FXML
    private TextField EnterCandidat;

 

    @FXML
    private TableView<Election> TableElection;

    @FXML
    private TableView<ChercherVotes> Tablesearch;

    @FXML
    private TableColumn<Election, Date> Tdatevote;

    @FXML
    private TableColumn<Election, Integer> Tidcand;

    @FXML
    private TableColumn<ChercherVotes, Integer> Tidcand2;

    @FXML
    private TableColumn<Election, Integer> Tidelec;

    @FXML
    private TableColumn<Election, Integer> Tidvote;

    @FXML
    private TableColumn<ChercherVotes, Integer> Tnbrvotes;

    @FXML
    private TableColumn<ChercherVotes, String> Tnomcand;

    @FXML
    public ObservableList<Election> data = FXCollections.observableArrayList();
    public ObservableList<ChercherVotes> data2 = FXCollections.observableArrayList();
    
    private Boolean CheckEmpty() {
    	return (EnterCandidat.getText().equals(""));}
    @FXML
    void ClickButtonRechercher(ActionEvent event) {
    	if(CheckEmpty()==true) {
    		Alert alert=new Alert(AlertType.ERROR);
        	alert.setTitle("Avertissement");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir l'id du candidat recherché");
            Optional<ButtonType> result = alert.showAndWait();
    	}else { String candidatid=EnterCandidat.getText();
   	EnterCandidat.clear();
	EnterCandidat.clear();
	Tablesearch.getItems().clear();
	String querry ="Select candidat.id_cand AS id,CONCAT(candidat.prenom, ' ', candidat.nom) AS name ,COUNT(vote.id_vote) AS nombre_votes FROM candidat LEFT JOIN vote  ON(candidat.id_cand = vote.id_cand) where candidat.id_cand=? "
			;
			
	try {
		ps=cnx.prepareStatement(querry);
		ps.setString(1,candidatid);
		rst=ps.executeQuery();
		 if(rst.next()) {  
	data2.setAll(new ChercherVotes(rst.getInt("id"),rst.getString("name"),rst.getInt("nombre_votes")));
		 }else {
			    Alert alert=new Alert(AlertType.ERROR);
	        	alert.setTitle("Avertissement");
	            alert.setHeaderText(null);
	            alert.setContentText("Candidat recherché n'existe pas ");
	            Optional<ButtonType> rt = alert.showAndWait();
		 }

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace(); 
		 }
	Tidcand2.setCellValueFactory(new PropertyValueFactory<ChercherVotes,Integer>("id"));
	Tnomcand.setCellValueFactory(new PropertyValueFactory<ChercherVotes,String>("name"));
	Tnbrvotes.setCellValueFactory(new PropertyValueFactory<ChercherVotes,Integer>("nombre_votes"));
	Tablesearch.setItems(data2);
	
    	};
    }

   
   
    
    public void ShowElection(){
    	String query ="Select * from election.vote order by date DESC";
    	try {
    		pst=cnx.prepareStatement(query);
    		rs=pst.executeQuery();
    		while(rs.next()) {
    			data.add(new Election(rs.getInt("id_cand"),rs.getInt("id_elec"),rs.getInt("id_vote"),rs.getDate("date")));
    		}
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	Tidelec.setCellValueFactory(new PropertyValueFactory<Election,Integer>("id_elec"));
    	Tidcand.setCellValueFactory(new PropertyValueFactory<Election,Integer>("id_cand"));
    	Tidvote.setCellValueFactory(new PropertyValueFactory<Election,Integer>("id_vote"));
    	Tdatevote.setCellValueFactory(new PropertyValueFactory<Election,Date>("date"));
    	TableElection.setItems(data);
    }
   // public void ShowVoteforCand(){
    

     

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx =DBconnection.getConnection();	
		ShowElection();
		// TODO Auto-generated method stub
		
	}

}
