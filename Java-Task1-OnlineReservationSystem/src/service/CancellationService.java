package service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.DBConnection;

public class CancellationService {

    public static boolean cancelReservation(int reservationId) {

        String sql = "DELETE FROM reservations WHERE reservation_id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, reservationId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }
}