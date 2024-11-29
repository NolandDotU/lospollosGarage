package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    public static Connection getCon() {
        try {
            // Load the MySQL JDBC Driver
            System.out.println("Loading MySQL JDBC Driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection to the database
            String url = "jdbc:mysql://localhost:3306/lospollos?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String user = "root"; // Replace with your MySQL username
            String password = ""; // Replace with your MySQL password (empty for XAMPP default)
            
            System.out.println("Connecting to database with URL: " + url);
            Connection con = DriverManager.getConnection(url, user, password);
            
            System.out.println("Connection established successfully!");
            return con;
        } catch (Exception e) {
            System.err.println("Failed to establish a database connection: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
