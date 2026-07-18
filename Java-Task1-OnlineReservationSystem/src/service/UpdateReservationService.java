package service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.DBConnection;

public class UpdateReservationService {

    public static boolean updateReservation(
            String pnrNumber,
            String passengerName,
            String trainNumber,
            String trainName,
            String classType,
            String journeyDate,
            String source,
            String destination) {

        String sql = "UPDATE reservations SET "
                + "passenger_name = ?, "
                + "train_number = ?, "
                + "train_name = ?, "
                + "class_type = ?, "
                + "journey_date = ?, "
                + "from_station = ?, "
                + "to_station = ? "
                + "WHERE pnr_number = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, passengerName);
            ps.setString(2, trainNumber);
            ps.setString(3, trainName);
            ps.setString(4, classType);
            ps.setString(5, journeyDate);
            ps.setString(6, source);
            ps.setString(7, destination);
            ps.setString(8, pnrNumber);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }
}