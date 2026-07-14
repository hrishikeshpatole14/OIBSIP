package service;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;

import database.DBConnection;

public class ReservationService {

    public static boolean addReservation(
            String passengerName,
            String trainNumber,
            String trainName,
            String classType,
            String journeyDate,
            String source,
            String destination) {

        String sql = "INSERT INTO reservations(passenger_name, train_number, train_name, class_type, journey_date, from_station, to_station) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            // ADD THESE TWO LINES
            File db = new File("database/reservation.db");
            System.out.println("Database Path: " + db.getAbsolutePath());

            ps.setString(1, passengerName);
            ps.setString(2, trainNumber);
            ps.setString(3, trainName);
            ps.setString(4, classType);
            ps.setString(5, journeyDate);
            ps.setString(6, source);
            ps.setString(7, destination);

            System.out.println("Trying to insert reservation...");
            int rows = ps.executeUpdate();
            System.out.println("Inserted Successfully");

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}