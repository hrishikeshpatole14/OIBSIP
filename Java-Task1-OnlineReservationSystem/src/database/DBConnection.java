package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:sqlite:database/reservation.db";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

        File file = new File("database/reservation.db");
        System.out.println("Database Path:");
        System.out.println(file.getAbsolutePath());

        Connection con = getConnection();

        if (con != null) {
            System.out.println("Database Connected Successfully!");
        }
    }
}