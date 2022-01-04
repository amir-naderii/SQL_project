package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Bus_Reservation;
import ir.ac.kntu.Model.Flight_Reservation;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Flight_ReservationDao implements Repository<Flight_Reservation,Integer>{
    private HashMap<String, PreparedStatement> sqlStm = new HashMap<>();

    public Flight_ReservationDao(Connection con){
        sqlStatements(con);
    }

    private void sqlStatements(Connection con) {
        try {
            sqlStm.put("findByID",con.prepareStatement(
                    "SELECT BR.* FROM Fight_Reservation BR where BR.id = ?"
            ));
            sqlStm.put("findAll",con.prepareStatement(
                    "SELECT BR.* FROM Fight_Reservation BR"
            ));
            sqlStm.put("deleteByID",con.prepareStatement(
                    "DELETE FROM Fight_Reservation WHERE id = ?"
            ));
            sqlStm.put("insert",con.prepareStatement(
                    "INSERT INTO Fight_Reservation VALUES(?,?,?,?)"
            ));
            sqlStm.put("update",con.prepareStatement(
                    "UPDATE Fight_Reservation SET flight_ticket_id = ?, user_id  = ?, transaction_id = ? WHERE id = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Flight_Reservation extractFromResultSet(ResultSet Rs) {
        try {
            return new Flight_Reservation(Rs.getInt(1),
                    Rs.getInt(2), Rs.getInt(3), Rs.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Flight_Reservation findById(Integer ID) {
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
    public List<Flight_Reservation> findByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<Flight_Reservation> flightReservations = new ArrayList<>();
            for (Integer i : IDs) {
                stmt.setInt(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    Flight_Reservation flight_reservation = extractFromResultSet(Rs);
                    flightReservations.add(flight_reservation);
                }
            }
            return flightReservations;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Flight_Reservation> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            ArrayList<Flight_Reservation> flightReservations = new ArrayList<>();
            while (Rs.next()){
                Flight_Reservation flight_reservation = extractFromResultSet(Rs);
                flightReservations.add(flight_reservation);
            }
            return flightReservations;
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
    public Flight_Reservation save(Flight_Reservation E) {
        try {
            if(findById(E.getId()) == null){
                PreparedStatement stmt = sqlStm.get("insert");
                stmt.setInt(1,E.getId());
                stmt.setInt(2,E.getFlight_ticket_id());
                stmt.setInt(3,E.getUser_id());
                stmt.setInt(4,E.getTransaction_id());
                return E;
            }else{
                PreparedStatement stmt = sqlStm.get("update");
                stmt.setInt(1,E.getFlight_ticket_id());
                stmt.setInt(2,E.getUser_id());
                stmt.setInt(3,E.getTransaction_id());
                stmt.setInt(4,E.getId());
                return E;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
