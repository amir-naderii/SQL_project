package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Hotel_Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Hotel_TicketDao implements Repository<Hotel_Ticket,Integer> {
    private final HashMap<String, PreparedStatement> sqlStm = new HashMap<>();

    public Hotel_TicketDao(Connection con){
        sqlStatements(con);
    }

    private void sqlStatements(Connection connection) {
        try {
            sqlStm.put("findByID",connection.prepareStatement(
                    "SELECT HT.* FROM Hotel_Ticket HT where HT.id = ?"
            ));
            sqlStm.put("findAll",connection.prepareStatement(
                    "SELECT HT.* FROM Hotel_Ticket HT"
            ));
            sqlStm.put("deleteByID",connection.prepareStatement(
                    "DELETE FROM Hotel_Ticket WHERE id = ?"
            ));
            sqlStm.put("insert",connection.prepareStatement(
                    "INSERT INTO Hotel_Ticket VALUES(?,?,?,?,?,?)"
            ));
            sqlStm.put("update",connection.prepareStatement(
                    "UPDATE Hotel_Ticket SET price = ?, check_in = ?, check_out = ?," +
                            "hotel_id = ?, room_id WHERE id = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Hotel_Ticket extractFromResultSet(ResultSet Rs){
        try {
            return new Hotel_Ticket(Rs.getInt(1),
                    Rs.getInt(2),Rs.getDate(3),Rs.getDate(4),
                    Rs.getInt(5), Rs.getInt(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Hotel_Ticket findById(Integer ID) {
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
    public List<Hotel_Ticket> findByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<Hotel_Ticket> hotelTickets = new ArrayList<>();
            for (Integer i : IDs) {
                stmt.setInt(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    Hotel_Ticket hotel_ticket = extractFromResultSet(Rs);
                    hotelTickets.add(hotel_ticket);
                }
            }
            return hotelTickets;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Hotel_Ticket> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            ArrayList<Hotel_Ticket> hotelTickets = new ArrayList<>();
            while (Rs.next()){
                Hotel_Ticket hotel_ticket = extractFromResultSet(Rs);
                hotelTickets.add(hotel_ticket);
            }
            return hotelTickets;
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
    public Hotel_Ticket save(Hotel_Ticket E) {
        try {
            if(findById(E.getId()) == null){
                PreparedStatement stmt = sqlStm.get("insert");
                stmt.setInt(1,E.getId());
                stmt.setInt(2,E.getPrice());
                stmt.setDate(3,(java.sql.Date) E.getCheck_in());
                stmt.setDate(4,(java.sql.Date) E.getCheck_out());
                stmt.setInt(5, E.getHotel_id());
                stmt.setInt(6, E.getRoom_id());
                stmt.executeUpdate();
                return E;
            }else{
                PreparedStatement stmt = sqlStm.get("update");
                stmt.setInt(1,E.getPrice());
                stmt.setDate(2,(java.sql.Date) E.getCheck_in());
                stmt.setDate(3,(java.sql.Date) E.getCheck_out());
                stmt.setInt(4, E.getHotel_id());
                stmt.setInt(5, E.getRoom_id());
                stmt.setInt(6,E.getId());
                stmt.executeUpdate();
                return E;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
