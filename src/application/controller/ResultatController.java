package application.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.util.DBconnection;
import application.model.Resultat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ResultatController implements Initializable {
	public Connection cnx;
	public PreparedStatement ps;
	public ResultSet rs;

    @FXML
    private TableView<Resultat> TableResultat;

    @FXML
    private TableColumn<Resultat, Integer> Tclas;

    @FXML
    private TableColumn<Resultat, Date> Tdatenais;

    @FXML
    private TableColumn<Resultat, String> Tgenre;

    @FXML
    private TableColumn<Resultat, Integer> Tidcand;

    @FXML
    private TableColumn<Resultat, String> Tname;

    @FXML
    private TableColumn<Resultat, Integer> Tnbrv;

    @FXML
    private TableColumn<Resultat, Double> TprF;

    @FXML
    private TableColumn<Resultat, Double> TprM;

    @FXML
    private TableColumn<Resultat, Double> Tprvote;

    
    public ObservableList<Resultat> data = FXCollections.observableArrayList();

    
    public void Showresult(){
    String query ="SELECT c.id_cand AS id_cand, c.genre AS genre, CONCAT(c.prenom,' ', c.nom) AS name, c.Date_Naissance AS date_nais, COUNT(v.id_vote) AS nbrvotes, (COUNT(v.id_vote) * 100.0) / (SELECT COUNT(*) FROM vote) AS votes, ((SELECT COUNT(v.id_vote) FROM vote v JOIN electeur e ON e.id_elec=v.id_elec WHERE Genre='F' AND c.id_cand = v.id_cand) * 100) / COUNT(v.id_vote) AS votesF, ((SELECT COUNT(v.id_vote) FROM vote v JOIN electeur e ON e.id_elec=v.id_elec WHERE Genre='M' AND c.id_cand = v.id_cand) * 100) / COUNT(v.id_vote) AS votesM"
    		+ " FROM candidat c LEFT JOIN vote v ON c.id_cand = v.id_cand GROUP BY c.id_cand ORDER BY nbrvotes DESC;";
    try {
		ps=cnx.prepareStatement(query);
		rs=ps.executeQuery();
        int clas = 0;
		while(rs.next()) {
			clas++;
			data.add(new Resultat(clas,rs.getInt("id_cand"),rs.getString("genre"),rs.getString("name"),rs.getDate("date_nais"),rs.getInt("nbrvotes"),rs.getDouble("votes"),rs.getDouble("votesF"),rs.getDouble("votesM")));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    Tidcand.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("id_cand"));
	Tgenre.setCellValueFactory(new PropertyValueFactory<Resultat,String>("genre"));
	Tname.setCellValueFactory(new PropertyValueFactory<Resultat,String>("name"));
	Tdatenais.setCellValueFactory(new PropertyValueFactory<Resultat,Date>("date_nais"));
	Tnbrv.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("nbrvotes"));
	Tprvote.setCellValueFactory(new PropertyValueFactory<Resultat,Double>("votes"));	
	TprF.setCellValueFactory(new PropertyValueFactory<Resultat,Double>("votesF"));	
	TprM.setCellValueFactory(new PropertyValueFactory<Resultat,Double>("votesM"));	
    Tclas.setCellValueFactory(new PropertyValueFactory<Resultat, Integer>("clas"));
	TableResultat.setItems(data);

	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx =DBconnection.getConnection();	

		// TODO Auto-generated method stub
		Showresult();
	}

}
