package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;
import model.Reservation;

public class SearchReservationService {

    public static Reservation searchReservation(String pnrNumber) {

        String sql = "SELECT * FROM reservations WHERE pnr_number = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, pnrNumber);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Reservation(

                        rs.getInt("reservation_id"),
                        rs.getString("pnr_number"),
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