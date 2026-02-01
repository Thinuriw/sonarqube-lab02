package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {

    // Pull secrets from environment variables instead of hardcoding
    private static final String DB_URL =
            System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost/db");
    private static final String DB_USER =
            System.getenv().getOrDefault("DB_USER", "root");
    private static final String DB_PASSWORD =
            System.getenv().getOrDefault("DB_PASSWORD", "");

    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // FIXED: SQL Injection + closes resources
    public void findUser(String username) throws Exception {
        String sql = "SELECT * FROM users WHERE name = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                }
            }
        }
    }

    // FIXED: SQL Injection + closes resources
    public void deleteUser(String username) throws Exception {
        String sql = "DELETE FROM users WHERE name = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.executeUpdate();
        }
    }
}
