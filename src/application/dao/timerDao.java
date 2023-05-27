package application.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import application.util.DBconnection;

/**
 * @author oussama erraji
 */
public class timerDao {
	public void settime(Date start, Date end) {

		if (timedeja()) {
            updatetimer(start, end);
        } else {
            
            inserttimer(start, end);
        }

	}
	public void updatetimer(Date start, Date end) {
		Connection conn = DBconnection.getConnection();

		try {

			PreparedStatement ps = conn.prepareStatement("update settings set startDate = ?, enddate = ?");
			ps.setDate(1, start);
			ps.setDate(2, end);
			ps.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}

	}
	public void inserttimer(Date start, Date end) {
		Connection conn = DBconnection.getConnection();

		try {

			PreparedStatement ps = conn.prepareStatement("insert into settings(startDate,endDate) values(?,?)");
			ps.setDate(1, start);
			ps.setDate(2, end);
			ps.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}

	}
	 public boolean timedeja() {
		 Connection conn = DBconnection.getConnection();
	        try {
	             PreparedStatement ps = conn.prepareStatement("select count(*) from settings");
	             ResultSet rs = ps.executeQuery(); 

	            if (rs.next()) {
	                int count = rs.getInt(1);
	                return count > 0;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	 
	 public Date getStart() {
		 Connection conn = DBconnection.getConnection();

	        try {
	             PreparedStatement statement = conn.prepareStatement("select startDate from settings");
	             ResultSet resultSet = statement.executeQuery(); 

	            if (resultSet.next()) {
	                return resultSet.getDate("startDate");
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null; 
	    }
	 public Date getEnd() {
		 Connection conn = DBconnection.getConnection();

	        try {
	             PreparedStatement statement = conn.prepareStatement("select endDate from settings");
	             ResultSet resultSet = statement.executeQuery(); 

	            if (resultSet.next()) {
	                return resultSet.getDate("endDate");
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null; 
	    }
}
