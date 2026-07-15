package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;
import model.Reservation;

public class SearchReservationService {

    public static Reservation searchReservation(int reservationId) {

        String sql = "SELECT * FROM reservations WHERE reservation_id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            // Set Reservation ID
            ps.setInt(1, reservationId);

            // Execute Query
            ResultSet rs = ps.executeQuery();

            // If record found
            if (rs.next()) {

                return new Reservation(

                        rs.getInt("reservation_id"),
                        rs.getString("passenger_name"),
                        rs.getString("train_number"),
                        rs.getString("train_name"),
                        rs.getString("class_type"),
                        rs.getString("journey_date"),
                        rs.getString("from_station"),
                        rs.getString("to_station")

                );

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

}