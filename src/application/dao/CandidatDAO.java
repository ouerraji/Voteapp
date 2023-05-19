package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Main;
import application.model.Candidat;
import application.model.Electeur;
import application.util.DBconnection;

/**
 *@author oussama erraji 
 */
public class CandidatDAO {

	
public ArrayList<Candidat> getCandidats() {
		Connection conn=DBconnection.getConnection();
		ArrayList<Candidat> candidats=new ArrayList<>();
		try {
			
			PreparedStatement ps=conn.prepareStatement("select * from candidat");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Candidat c=new Candidat();
				c.setId_cand(rs.getInt("id_cand"));
				c.setNom(rs.getString("Nom"));
				c.setPrenom(rs.getString("Prenom"));
				c.setGenre(rs.getString("Genre").charAt(0));
				c.setDate_Naiss(rs.getDate("Date_Naissance"));
				c.setAdresse(rs.getString("Adresse"));
				c.setEmail(rs.getString("Email"));
				c.setPassword(rs.getString("Password"));
				c.setCIN(rs.getString("CIN"));
				c.setPhoto(rs.getBytes("photo"));
				c.setId_cand(rs.getInt("id_parti"));

				candidats.add(c);
				
				
			}
			
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return candidats;
		
}

}