package ir.ac.kntu.Repository;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String URL = "jdbc:sqlserver://localhost:1433;database=AliBaba";
    public static final String USER = "Tanaz";
    public static final String PASS = "tanaz";

    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    /**
     * Test Connection
     */
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        //Statement stmt = connection.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * " +
//                "FROM [User] WHERE id=" + 5);
        //System.out.println(rs.getInt("id"));
    }

}
