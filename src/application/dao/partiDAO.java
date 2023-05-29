package application.dao;

import application.model.Parti;
import application.util.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class partiDAO {



	public int addparti(Parti parti, Connection connection) {
        int partyId = -1;

        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO `parti` (`Nom`, `logo`, `description`, `tel`) VALUES (?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, parti.getNom());
            ps.setBytes(2, parti.getLogo());
            ps.setString(3, parti.getDescription());
            ps.setString(4, parti.getTel());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                partyId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return partyId;
    }





    // Other methods...
}
