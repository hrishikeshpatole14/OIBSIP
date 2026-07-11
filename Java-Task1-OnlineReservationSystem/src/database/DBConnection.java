package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection("jdbc:sqlite:database/reservation.db");

            if (con != null) {
                System.out.println("Database Connected Successfully!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}