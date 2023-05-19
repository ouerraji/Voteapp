package application.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.model.Electeur;
import application.util.DBconnection;

/**
 * @author oussama erraji
 */
public class ElecteurDAO {
public void addElecteur(Electeur e) {
Connection conn=DBconnection.getConnection();
try {
	PreparedStatement ps=conn.prepareStatement("insert into electeur(Nom,Prenom,Genre,Date_Naissance,Adresse,Email,Password,tel,CIN) values (?,?,?,?,?,?,?,?,?) ");
	ps.setString(1, e.getNom());
	ps.setString(2, e.getPrenom());
	ps.setString(3, String.valueOf(e.getGenre()));
	ps.setDate(4,(Date) e.getDate_Naissance());
	ps.setString(5,e.getAdresse());
	ps.setString(6, e.getEmail());
	ps.setString(7, e.getPassword());
	ps.setString(8, e.getTel());
	ps.setString(9, e.getCIN());
	ps.executeUpdate();
	
	
} catch (SQLException e2) {
	e2.printStackTrace();
}
	
}
public void updateElecteur(Electeur e) {
	Connection conn=DBconnection.getConnection();
	try {
		PreparedStatement ps=conn.prepareStatement("update electeur set Nom=?,Prenom=?, Genre=?, Date_Naissance=?, Adresse=?, Email=? Password=?,Tel=?,Cin=?");
		ps.setString(1, e.getNom());
		ps.setString(2, e.getPrenom());
		ps.setString(3, String.valueOf(e.getGenre()));
		ps.setDate(4,(Date) e.getDate_Naissance());
		ps.setString(5,e.getAdresse());
		ps.setString(6, e.getEmail());
		ps.setString(7, e.getPassword());
		ps.setString(8, e.getTel());
		ps.setString(9, e.getCIN());
		ps.executeUpdate();
		
		
	} catch (SQLException e2) {
		e2.printStackTrace();
	}
	
	
}
public void deleteElecteur(int id) {
	Connection conn=DBconnection.getConnection();
	try {
		PreparedStatement ps=conn.prepareStatement("delete from electeur where id_elc="+id);
		ps.executeUpdate();
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
public Electeur getElecteur(int id) {
	Connection conn=DBconnection.getConnection();
	Electeur e=null;
	try {
		e=new Electeur();
		PreparedStatement ps=conn.prepareStatement("select * from electeur where id_elc="+id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			e.setId_elec(rs.getInt("id_elec"));
			e.setNom(rs.getString("Nom"));
			e.setPrenom(rs.getString("Prenom"));
			e.setGenre(rs.getString("Genre").charAt(0));
			e.setDate_Naissance(rs.getDate("Date_Naissance"));
			e.setAdresse(rs.getString("Adresse"));
			e.setEmail(rs.getString("Email"));
			e.setPassword(rs.getString("Password"));
			e.setTel(rs.getString("tel"));
			e.setCIN(rs.getString("CIN"));
			
			
		}
		
		
	} catch (SQLException e2) {
		e2.printStackTrace();
	}
	return e;
	
}
public ArrayList<Electeur> getElecteurs() {
	Connection conn=DBconnection.getConnection();
	ArrayList<Electeur> electeurs=new ArrayList<>();
	try {
		
		PreparedStatement ps=conn.prepareStatement("select * from electeur");
		ps.executeUpdate();
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Electeur e=new Electeur();
			e.setId_elec(rs.getInt("id_elec"));
			e.setNom(rs.getString("Nom"));
			e.setPrenom(rs.getString("Prenom"));
			e.setGenre(rs.getString("Genre").charAt(0));
			e.setDate_Naissance(rs.getDate("Date_Naissance"));
			e.setAdresse(rs.getString("Adresse"));
			e.setEmail(rs.getString("Email"));
			e.setPassword(rs.getString("Password"));
			e.setTel(rs.getString("tel"));
			e.setCIN(rs.getString("CIN"));
			electeurs.add(e);
			
			
		}
		
		
	} catch (SQLException e2) {
		e2.printStackTrace();
	}
	return electeurs;
	
}
}
