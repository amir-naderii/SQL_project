package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Hotel_Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Hotel_ReservationDao implements Repository<Hotel_Reservation,Integer> {
    private HashMap<String, PreparedStatement> sqlStm = new HashMap<>();

    public Hotel_ReservationDao(Connection con){
        sqlStatements(con);
    }

    private void sqlStatements(Connection con) {
        try {
            sqlStm.put("findByID",con.prepareStatement(
                    "SELECT HR.* FROM Hotel_Reservation HR where HR.id = ?"
            ));
            sqlStm.put("findAll",con.prepareStatement(
                    "SELECT HR.* FROM Hotel_Reservation HR"
            ));
            sqlStm.put("deleteByID",con.prepareStatement(
                    "DELETE FROM Hotel_Reservation WHERE id = ?"
            ));
            sqlStm.put("insert",con.prepareStatement(
                    "INSERT INTO Hotel_Reservation VALUES(?,?,?,?)"
            ));
            sqlStm.put("update",con.prepareStatement(
                    "UPDATE Hotel_Reservation SET hotel_ticket_id = ?, user_id  = ?, transaction_id = ? WHERE id = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Hotel_Reservation extractFromResultSet(ResultSet Rs) {
        try {
            return new Hotel_Reservation(Rs.getInt(1),
                    Rs.getInt(2), Rs.getInt(3), Rs.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Hotel_Reservation findById(Integer ID) {
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
    public List<Hotel_Reservation> findByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<Hotel_Reservation> hotel_reservations = new ArrayList<>();
            for (Integer i : IDs) {
                stmt.setInt(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    Hotel_Reservation hotel_reservation = extractFromResultSet(Rs);
                    hotel_reservations.add(hotel_reservation);
                }
            }
            return hotel_reservations;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Hotel_Reservation> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            ArrayList<Hotel_Reservation> hotel_reservations = new ArrayList<>();
            while (Rs.next()){
                Hotel_Reservation hotel_reservation = extractFromResultSet(Rs);
                hotel_reservations.add(hotel_reservation);
            }
            return hotel_reservations;
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
    public Hotel_Reservation save(Hotel_Reservation E) {
        try {
            if(findById(E.getId()) == null){
                PreparedStatement stmt = sqlStm.get("insert");
                stmt.setInt(1,E.getId());
                stmt.setInt(2,E.getHotel_ticket_id());
                stmt.setInt(3,E.getUser_id());
                stmt.setInt(4,E.getTransaction_id());
                stmt.executeUpdate();
                return E;
            }else{
                PreparedStatement stmt = sqlStm.get("update");
                stmt.setInt(1,E.getHotel_ticket_id());
                stmt.setInt(2,E.getUser_id());
                stmt.setInt(3,E.getTransaction_id());
                stmt.setInt(4,E.getId());
                stmt.executeUpdate();
                return E;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
