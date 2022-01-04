package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Bus_Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Bus_TicketDao implements Repository<Bus_Ticket,Integer> {
    HashMap<String, PreparedStatement> sqlStm = new HashMap<>();

    private void sqlStatements(Connection connection) {
        try {
            sqlStm.put("findById",connection.prepareStatement(
               "SELECT BT.* FROM Bus_Ticket BT where BT.id = ?"
            ));
            sqlStm.put("findAll",connection.prepareStatement(
                    "SELECT BT.* FROM Bus_Ticket BT"
            ));
            sqlStm.put("deleteByID",connection.prepareStatement(
                    "DELETE FROM Bus_Ticekt BT WHERE BT.id = ?"
            ));
            sqlStm.put("insert",connection.prepareStatement(
                    "INSERT INTO Bus_Ticekt SET VALUES(?,?,?,?)"
            ));
            sqlStm.put("update",connection.prepareStatement(
                    "UPDATE Bus_Ticket SET id = ?, passengers = ?, price = ?, bus_id = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Bus_Ticket findById(Integer ID) {
        try{
            PreparedStatement stmt = sqlStm.get("findByID");
            stmt.setInt(1,ID);
            ResultSet Rs = stmt.executeQuery();
            if(Rs.next()){
                Bus_Ticket bus_ticket = new Bus_Ticket(Rs.getInt(0),
                        Rs.getInt(1),Rs.getInt(2),Rs.getInt(3));
                return bus_ticket;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Bus_Ticket> findByIDs(Collection<Integer> IDs) {

        return null;
    }

    @Override
    public List<Bus_Ticket> findAll() {
        return null;
    }

    @Override
    public Boolean deleteByID(Integer ID) {
        return null;
    }

    @Override
    public Boolean DeleteByIDs(Collection<Integer> IDs) {
        return null;
    }

    @Override
    public Bus_Ticket save(Bus_Ticket E) {
        return null;
    }
}
