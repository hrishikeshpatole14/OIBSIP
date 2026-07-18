package service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.DBConnection;

public class ReservationService {

    public static String addReservation(
            String passengerName,
            String trainNumber,
            String trainName,
            String classType,
            String journeyDate,
            String source,
            String destination) {

        // Generate Random 6-digit PNR
        String pnrNumber = "PNR" + (100000 + (int)(Math.random() * 900000));

        String sql = "INSERT INTO reservations("
                + "pnr_number,"
                + "passenger_name,"
                + "train_number,"
                + "train_name,"
                + "class_type,"
                + "journey_date,"
                + "from_station,"
                + "to_station"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, pnrNumber);
            ps.setString(2, passengerName);
            ps.setString(3, trainNumber);
            ps.setString(4, trainName);
            ps.setString(5, classType);
            ps.setString(6, journeyDate);
            ps.setString(7, source);
            ps.setString(8, destination);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                return pnrNumber;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}