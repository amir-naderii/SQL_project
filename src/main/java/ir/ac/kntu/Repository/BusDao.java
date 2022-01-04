package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BusDao implements Repository<Bus,Integer> {
    private final HashMap<String, PreparedStatement> sqlStm = new HashMap<>();

    public BusDao(Connection con){
        sqlStatements(con);
    }

    private void sqlStatements(Connection connection) {
        try {
            sqlStm.put("findByID",connection.prepareStatement(
                    "SELECT B.* FROM Bus B where B.id = ?"
            ));
            sqlStm.put("findAll",connection.prepareStatement(
                    "SELECT B.* FROM Bus B"
            ));
            sqlStm.put("deleteByID",connection.prepareStatement(
                    "DELETE FROM Bus WHERE Bus.id = ?"
            ));
            sqlStm.put("insert",connection.prepareStatement(
                    "INSERT INTO Bus VALUES(?,?,?,?,?,?,?)"
            ));
            sqlStm.put("update",connection.prepareStatement(
                    "UPDATE Bus SET departure_city = ?, departure_terminal = ?, destination_city = ?, " +
                            "destination_terminal = ?, travel_date = ?, company = ? WHERE id = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Bus findById(Integer integer) {
        return null;
    }

    public List<Bus> findByIDs(Collection ids) {
        return null;
    }

    public List<Bus> findAll() {
        return null;
    }

    public Boolean deleteByID(Integer integer) {
        return null;
    }

    public Boolean DeleteByIDs(Collection<Integer> integers) {
        return null;
    }

    public Bus save(Bus E) {
        return null;
    }
}
