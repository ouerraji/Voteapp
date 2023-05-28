package application.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.util.DBconnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class AccueilController implements Initializable{
	public Connection cnx;
	public PreparedStatement pst;
	public ResultSet rs;

    @FXML
    private AnchorPane Anchor2;

    @FXML
    private Label NombreCandidatsTotal;

    @FXML
    private Label NombreElecteursTotal;

    @FXML
    private Label NombreVotesTotal;

    @FXML
    private Label nbvoteaujr;

    public void nombreCand() {
    	String query="SELECT COUNT(*) AS n FROM election.candidat";
    	try {
            pst = cnx.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                int n = rs.getInt("n");
                NombreCandidatsTotal.setText(Integer.toString(n)+" Candidats");
                }} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

    	
    }
    public void nombreElec() {
    	String query="SELECT COUNT(*) AS n FROM election.electeur";
    	try {
            pst = cnx.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                int n = rs.getInt("n");
                NombreElecteursTotal.setText(Integer.toString(n)+" Electeurs");
                }} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	
    }
    public void nombreVt() {
    	String query="SELECT COUNT(*) AS n FROM election.vote";
    	try {
            pst = cnx.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                int n = rs.getInt("n");
                NombreVotesTotal.setText(Integer.toString(n)+" Votes");
                }} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	
    	
    }
    public void nombreVtjr() {
    	String query="SELECT COUNT(*) AS n FROM election.vote WHERE DATE(date) = CURDATE();";
    	try {
            pst = cnx.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                int n = rs.getInt("n");
                nbvoteaujr.setText(Integer.toString(n)+" Votes ");
                }} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx =DBconnection.getConnection();	
		nombreCand();
		nombreElec();
		nombreVt();
		nombreVtjr();
		// TODO Auto-generated method stub
		
	}

    
 
}
