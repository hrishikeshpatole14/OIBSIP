package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.DBConnection;
import model.Reservation;

public class ViewReservationService {

    public static ArrayList<Reservation> getAllReservations() {

        ArrayList<Reservation> reservationList = new ArrayList<>();

        String sql = "SELECT * FROM reservations";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {

                Reservation reservation = new Reservation(

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

                reservationList.add(reservation);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return reservationList;

    }

}