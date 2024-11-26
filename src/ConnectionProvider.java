package loginandsignup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    
    // Replace these with your actual database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lospollos"; // Your database URL
    private static final String DB_USER = "root"; // Your database username
    private static final String DB_PASSWORD = ""; // Your database password
    
    // Method to get the database connection
    public static Connection getCon() {
        Connection con = null;
        
        try {
            // Load the MySQL JDBC driver (optional with newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception: " + e.getMessage());
        }
        
        return con;
    }
}
