package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.model.Candidat;
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

			PreparedStatement ps = conn
					.prepareStatement("SELECT concat(c.prenom,' ',c.nom) as name,c.photo,p.logo from candidat c,parti p where c.id_parti=p.id_parti");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Swipeinfo s = new Swipeinfo();

				s.setFullName(rs.getString("name"));
				s.setCandidatPicture(rs.getBytes("photo"));
				s.setPartiPicture(rs.getBytes("logo"));
				swipeinfos.add(s);

			}

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return swipeinfos;

	}

}
