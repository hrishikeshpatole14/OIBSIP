package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertDefaultUser {

    public static void insertAdmin() {

        String sql = "INSERT OR IGNORE INTO users(username, password) VALUES (?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, "admin");
            ps.setString(2, "admin123");

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Default Admin User Created Successfully.");
            } else {
                System.out.println("Admin User Already Exists.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        insertAdmin();

    }
}