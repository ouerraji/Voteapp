package application.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import application.model.Candidat;
import application.model.Electeur;
import application.model.Swipeinfo;
import application.util.DBconnection;

/**
 * @author oussama erraji
 */
public class swipeDao {
	public ArrayList<Swipeinfo> getSwipeinfos() {
		Connection conn = DBconnection.getConnection();
		ArrayList<Swipeinfo> swipeinfos = new ArrayList<>();
		try {

			PreparedStatement ps = conn.prepareStatement(
					"SELECT c.id_cand,concat(c.prenom,' ',c.nom) as name,c.photo,p.logo from candidat c,parti p where c.id_parti=p.id_parti");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Swipeinfo s = new Swipeinfo();

				s.setFullName(rs.getString("name"));
				s.setCandidatPicture(rs.getBytes("photo"));
				s.setPartiPicture(rs.getBytes("logo"));
				s.setId_candidat(rs.getInt("id_cand"));
				swipeinfos.add(s);

			}

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return swipeinfos;

	}

	public int getIdElecteur(String mail) {
		int idElecteur = 0;
		Connection conn = DBconnection.getConnection();

		try {

			PreparedStatement ps = conn.prepareStatement("select id_elec from electeur where Email= ?");
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				idElecteur = rs.getInt("id_elec");

			}

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return idElecteur;

	}

	public void inserVote(int idElec, Timestamp timestamp, int idCandidat) {
		Connection conn = DBconnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into vote(id_elec,date,id_cand) values (?,?,?) ");
			ps.setInt(1, idElec);
			ps.setTimestamp(2, timestamp);
			ps.setInt(3, idCandidat);
			ps.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	public boolean ALreadyVoted(int electeurId) {
		Connection conn = DBconnection.getConnection();

	    try {
	         PreparedStatement ps = conn.prepareStatement("SELECT id_elec FROM vote WHERE id_elec = ?"); 
	        ps.setInt(1, electeurId);
	        ResultSet resultSet = ps.executeQuery();
	        return resultSet.next();
	        }
	     catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false; 
	}

}
