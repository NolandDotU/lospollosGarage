package dao;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionProvider.getCon();
            if (con == null) {
                throw new RuntimeException("Failed to establish a database connection!");
            }
            st = con.createStatement();
//            st.executeUpdate(
//                "CREATE TABLE appuser (" +
//                "appuser_pk INT AUTO_INCREMENT PRIMARY KEY, " +
//                "userRole VARCHAR(50), " +
//                "name VARCHAR(200), " +
//                "mobileNumber VARCHAR(50), " +
//                "email VARCHAR(200), " +
//                "password VARCHAR(50), " +
//                "address VARCHAR(200), " +
//                "status VARCHAR(50))"
//            );
//            st.executeUpdate("insert into appuser (userRole, name, mobileNumber,email,password,address,status) value('SuperAdmin', 'Super Admin', '12345', 'superadmin@testemail.com', 'admin', 'Indonesia', 'true')");
            st.executeUpdate("create table category(category_pk int AUTO_INCREMENT primary key, name varchar(200))");
            JOptionPane.showMessageDialog(null, "Table created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
