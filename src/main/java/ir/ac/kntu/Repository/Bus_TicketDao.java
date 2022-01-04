package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Bus_Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Bus_TicketDao implements Repository<Bus_Ticket,Integer> {
    private final HashMap<String, PreparedStatement> sqlStm = new HashMap<>();

    public Bus_TicketDao(Connection con){
        sqlStatements(con);
    }

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
                    "UPDATE Bus_Ticket SET passengers = ?, price = ?, bus_id = ? WHERE id = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Bus_Ticket extractFromResultSet(ResultSet Rs){
        try {
            return new Bus_Ticket(Rs.getInt(0),
                    Rs.getInt(1),Rs.getInt(2),Rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Bus_Ticket findById(Integer ID) {
        try{
            PreparedStatement stmt = sqlStm.get("findByID");
            stmt.setInt(1,ID);
            ResultSet Rs = stmt.executeQuery();
            if(Rs.next()){
                return extractFromResultSet(Rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Bus_Ticket> findByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<Bus_Ticket> busTickets = new ArrayList<>();
            for (Integer i : IDs) {
                stmt.setInt(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    Bus_Ticket bus_ticket = extractFromResultSet(Rs);
                    busTickets.add(bus_ticket);
                }
            }
            return busTickets;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Bus_Ticket> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            ArrayList<Bus_Ticket> busTickets = new ArrayList<>();
            while (Rs.next()){
                Bus_Ticket bus_ticket = extractFromResultSet(Rs);
                busTickets.add(bus_ticket);
            }
            return busTickets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean deleteByID(Integer ID) {
        try{
            PreparedStatement stmt = sqlStm.get("deleteByID");
            stmt.setInt(1,ID);
            int result = stmt.executeUpdate();
            if(result == 1)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean DeleteByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("deleteByID");
            for (Integer i:IDs) {
                stmt.setInt(1,i);
                int result = stmt.executeUpdate();
                if(result != 1)
                    return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Bus_Ticket save(Bus_Ticket E) {
        try {
            if(findById(E.getId()) == null){
                PreparedStatement stmt = sqlStm.get("insert");
                stmt.setInt(1,E.getId());
                stmt.setInt(2,E.getPassengers());
                stmt.setInt(3,E.getPrice());
                stmt.setInt(4,E.getBus_id());
                return E;
            }else{
                PreparedStatement stmt = sqlStm.get("update");
                stmt.setInt(1,E.getPassengers());
                stmt.setInt(2,E.getPrice());
                stmt.setInt(3,E.getBus_id());
                stmt.setInt(4,E.getId());
                return E;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
