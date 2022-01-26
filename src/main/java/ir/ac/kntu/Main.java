package ir.ac.kntu;

import ir.ac.kntu.Repository.ConnectionFactory;
import ir.ac.kntu.Repository.TransactionDao;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        AliBaba aliBaba = new AliBaba(connection);
        Menu menu = new Menu(aliBaba);

        menu.printMenu();
    }

}
