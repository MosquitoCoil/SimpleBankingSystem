package util;
import java.sql.*;
import java.sql.Connection;


public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/banking_db?zeroDateTimeBehavior=convertToNull";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Database Connected: " + URL);
            System.out.println("Database Connected!");
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
        return null;
    }
}
