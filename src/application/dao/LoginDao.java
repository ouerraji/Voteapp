package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.util.DBconnection;
import javafx.scene.paint.Color;

/**
 *@author oussama erraji 
 */
public class LoginDao {
    public String logIn(String email,String password) {
    	Connection conn=DBconnection.getConnection();
    	String type = null;
        try{
            PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM `electeur` WHERE Email = ? and Password = ?");
            ps1.setString(1, email);
            ps1.setString(2, password);
            ResultSet rs1 = ps1.executeQuery();
            
            PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM `candidat` WHERE Email = ? and Password = ?");
            ps2.setString(1, email);
            ps2.setString(2, password);
            ResultSet rs2 = ps2.executeQuery();
            
            PreparedStatement ps3 = conn.prepareStatement("SELECT * FROM `admins` WHERE Email = ? and Password = ?");
            ps3.setString(1, email);
            ps3.setString(2, password);
            ResultSet rs3 = ps3.executeQuery();
        if (rs1.next()) {
                
                type= "electeur";
            }
            
            else if (rs2.next()) {
                
                type= "candidat";
            }
            else if (rs3.next()) {
                
                type= "admin";
            }
            else {
                
                type ="false";
            }
        }catch(SQLException e){
                e.printStackTrace();
        }
		return type;
		
        
    }
}
