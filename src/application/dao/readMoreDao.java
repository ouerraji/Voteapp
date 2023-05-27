package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.readMore;
import application.util.DBconnection;

/**
 *@author oussama erraji 
 */
public class readMoreDao {
	public readMore getmore(int idcandidat) {
		Connection conn = DBconnection.getConnection();
		readMore r = null;

		try {
			r=new readMore();
			PreparedStatement ps = conn.prepareStatement("SELECT p.nom,p.logo,p.description from parti p,candidat c where c.id_parti=p.id_parti and c.id_cand = ?");
			ps.setInt(1, idcandidat);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				r.setNom(rs.getString("nom"));
                r.setLogoparti(rs.getBytes("logo"));
				r.setNom(rs.getString("nom"));
				r.setPromise(rs.getString("description"));
				

			}

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		return r;

	}

}
