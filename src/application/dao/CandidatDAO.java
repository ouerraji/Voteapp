package application.dao;

import java.sql.Connection;
import java.sql.Date;
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

	public boolean addCandidat(Candidat candidat, Connection connection) {
        boolean success = false;
        PreparedStatement ps = null;

        try {
            if (connection != null) {
                ps = connection.prepareStatement("INSERT INTO `candidat` (`nom`, `prenom`, `Genre`, `Date_Naissance`, `Adresse`, `Email`, `Password`, `CIN`, `photo`, `id_parti`) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                ps.setString(1, candidat.getNom());
                ps.setString(2, candidat.getPrenom());
                ps.setString(3, String.valueOf(candidat.getGenre()));
                ps.setDate(4, new Date(candidat.getDate_naissance().getTime()));
                ps.setString(5, candidat.getAdresse());
                ps.setString(6, candidat.getEmail());
                ps.setString(7, candidat.getPassword());
                ps.setString(8, candidat.getCin());
                ps.setBytes(9, candidat.getPhoto());
                ps.setInt(10, candidat.getParty().getId_parti());
                int rowsAffected = ps.executeUpdate();

                success = (rowsAffected > 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return success;
    }


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