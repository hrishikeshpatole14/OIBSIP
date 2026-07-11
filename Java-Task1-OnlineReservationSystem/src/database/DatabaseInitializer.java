package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void main(String[] args) {

        String url = "jdbc:sqlite:database/reservation.db";

        try {
            Connection con = DriverManager.getConnection(url);

            Statement stmt = con.createStatement();

            // Create Users Table
            String usersTable = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "username TEXT NOT NULL UNIQUE,"
                    + "password TEXT NOT NULL"
                    + ");";

            stmt.execute(usersTable);

            // Create Reservations Table
            String reservationTable = "CREATE TABLE IF NOT EXISTS reservations ("
                    + "reservation_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "passenger_name TEXT NOT NULL,"
                    + "train_number TEXT NOT NULL,"
                    + "train_name TEXT NOT NULL,"
                    + "class_type TEXT NOT NULL,"
                    + "journey_date TEXT NOT NULL,"
                    + "from_station TEXT NOT NULL,"
                    + "to_station TEXT NOT NULL"
                    + ");";

            stmt.execute(reservationTable);

            System.out.println("Database tables created successfully!");

            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}