package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Electeur;
import application.model.Winner;
import application.util.DBconnection;

/**
 *@author oussama erraji 
 */
public class WinnerDoa {
public Winner getWinner() {
	
	Connection conn=DBconnection.getConnection();
	Winner w=null;
	try {
		w=new Winner();
		String sql="select concat(c.nom,' ',c.prenom) as fullname,c.photo,p.nom,p.logo,count(*) as votes from candidat c, parti p,vote v where c.id_parti=p.id_parti and c.id_cand=v.id_cand and c.id_cand=(select v.id_cand from vote v group by v.id_cand order by count(*) desc limit 1)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			w.setFullname(rs.getString("fullname"));
			w.setImg(rs.getBytes("photo"));
			w.setPartiname(rs.getString("nom"));
			w.setLogo(rs.getBytes("logo"));
			w.setVotes(rs.getInt("votes"));
			
			
			
		}
		
		
	} catch (SQLException e2) {
		e2.printStackTrace();
	}
	return w;
	
}
}
