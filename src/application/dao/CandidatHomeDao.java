package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.util.DBconnection;
import application.model.Candidat;

/**
 *@author oussama erraji 
 */
public class CandidatHomeDao {
	public Candidat LoadCandidat(int id) {
	    Connection conn = DBconnection.getConnection();

	    String sqlc = "SELECT concat(c.nom,'  ',c.prenom) as fullname, c.photo, c.CIN, p.Nom, (SELECT COUNT(id_elec) FROM vote WHERE id_cand = c.id_cand) AS nbrVotes FROM candidat c, parti p WHERE c.id_parti = p.id_parti AND c.id_cand = ?";

	    Candidat cand = null;
	    try {
	        PreparedStatement ps = conn.prepareStatement(sqlc);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            cand = new Candidat();
	            String fullname = rs.getString("fullname");
	            cand.setFullname(fullname);
	            String part = rs.getString("p.Nom");
	            cand.setParti(part);
	            String CIN = rs.getString("c.CIN");
	            cand.setCIN(CIN);
	            int nbVotes = rs.getInt("nbrVotes");
	            cand.setNbrVotes(nbVotes);
	            byte[] photo = rs.getBytes("c.photo");
	            cand.setPhoto(photo);
	        }

	       
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } 

	    return cand;
	}
	public int getIdCandidat(String mail) {
		int idcandidat = 0;
		Connection conn = DBconnection.getConnection();

		try {

			PreparedStatement ps = conn.prepareStatement("select id_cand from candidat where Email= ?");
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				idcandidat = rs.getInt("id_cand");

			}

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return idcandidat;

	}
}
