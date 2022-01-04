package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Bus_Ticket;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionFactory {

    public static final String URL = "jdbc:sqlserver://localhost:1433;database=AliBaba";
    public static final String USER = "Tanaz";
    public static final String PASS = "tanaz";

    public static Connection getConnection()
    {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

}
