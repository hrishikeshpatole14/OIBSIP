package service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.DBConnection;

public class CancellationService {

    public static boolean cancelReservation(String pnrNumber) {

        String sql = "DELETE FROM reservations WHERE pnr_number = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, pnrNumber);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }
}