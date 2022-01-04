package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Bus_Ticket;
import ir.ac.kntu.Model.Flight;
import ir.ac.kntu.Model.Flight_Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Flight_TicketDao implements Repository<Flight_Ticket,Integer> {

    private final HashMap<String, PreparedStatement> sqlStm = new HashMap<>();

    public Flight_TicketDao(Connection con){
        sqlStatements(con);
    }

    private void sqlStatements(Connection connection) {
        try {
            sqlStm.put("findByID",connection.prepareStatement(
                    "SELECT FT.* FROM Flight_Ticket FT where FT.id = ?"
            ));
            sqlStm.put("findAll",connection.prepareStatement(
                    "SELECT FT.* FROM Flight_Ticket FT"
            ));
            sqlStm.put("deleteByID",connection.prepareStatement(
                    "DELETE FROM Flight_Ticket WHERE id = ?"
            ));
            sqlStm.put("insert",connection.prepareStatement(
                    "INSERT INTO Flight_Ticket VALUES(?,?,?,?,?)"
            ));
            sqlStm.put("update",connection.prepareStatement(
                    "UPDATE Flight_Ticket SET passengers = ?, price = ?, flight_type =?" +
                            ", flight_class = ? WHERE id = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Flight_Ticket extractFromResultSet(ResultSet Rs){
        try {
            return new Flight_Ticket(Rs.getInt(1),
                    Rs.getInt(2),Rs.getInt(3),Rs.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Flight_Ticket findById(Integer ID) {
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

    public List<Flight_Ticket> findByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<Flight_Ticket> flight_tickets = new ArrayList<>();
            for (Integer i : IDs) {
                stmt.setInt(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    Flight_Ticket flight_ticket = extractFromResultSet(Rs);
                    flight_tickets.add(flight_ticket);
                }
            }
            return flight_tickets;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Flight_Ticket> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            ArrayList<Flight_Ticket> flightTickets = new ArrayList<>();
            while (Rs.next()){
                Flight_Ticket flight_ticket = extractFromResultSet(Rs);
                flightTickets.add(flight_ticket);
            }
            return flightTickets;
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
    public Flight_Ticket save(Flight_Ticket E) {
        try {
            if(findById(E.getId()) == null){
                PreparedStatement stmt = sqlStm.get("insert");
                stmt.setInt(1,E.getId());
                stmt.setInt(2,E.getPassengers());
                stmt.setInt(3,E.getPrice());
                stmt.setString(4,E.getFlight_type());
                stmt.setString(5,E.getFlight_class());
                stmt.executeUpdate();
                return E;
            }else{
                PreparedStatement stmt = sqlStm.get("update");
                stmt.setInt(1,E.getPassengers());
                stmt.setInt(2,E.getPrice());
                stmt.setString(3,E.getFlight_type());
                stmt.setString(4,E.getFlight_class());
                stmt.setInt(5,E.getId());
                stmt.executeUpdate();
                return E;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
