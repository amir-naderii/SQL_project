package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Bus_Reservation;
import ir.ac.kntu.Model.Bus_Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Bus_ReservationDao implements Repository<Bus_Reservation,Integer> {
    private HashMap<String, PreparedStatement> sqlStm = new HashMap<>();

    public Bus_ReservationDao(Connection con){
        sqlStatements(con);
    }

    private void sqlStatements(Connection con) {
        try {
            sqlStm.put("findByID",con.prepareStatement(
                    "SELECT BR.* FROM Bus_Reservation BR where BR.id = ?"
            ));
            sqlStm.put("findAll",con.prepareStatement(
                    "SELECT BR.* FROM Bus_Reservation BR"
            ));
            sqlStm.put("deleteByID",con.prepareStatement(
                    "DELETE FROM Bus_Reservation WHERE id = ?"
            ));
            sqlStm.put("insert",con.prepareStatement(
                    "INSERT INTO Bus_Reservation VALUES(?,?,?,?)"
            ));
            sqlStm.put("update",con.prepareStatement(
                    "UPDATE Bus_Reservation SET bus_ticket_id = ?, user_id  = ?, transaction_id = ? WHERE id = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Bus_Reservation extractFromResultSet(ResultSet Rs) {
        try {
            return new Bus_Reservation(Rs.getInt(1),
                    Rs.getInt(2), Rs.getInt(3), Rs.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Bus_Reservation findById(Integer ID) {
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
    public List<Bus_Reservation> findByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<Bus_Reservation> busReservations = new ArrayList<>();
            for (Integer i : IDs) {
                stmt.setInt(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    Bus_Reservation bus_reservation = extractFromResultSet(Rs);
                    busReservations.add(bus_reservation);
                }
            }
            return busReservations;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Bus_Reservation> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            ArrayList<Bus_Reservation> busReservations = new ArrayList<>();
            while (Rs.next()){
                Bus_Reservation bus_reservation = extractFromResultSet(Rs);
                busReservations.add(bus_reservation);
            }
            return busReservations;
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
    public Bus_Reservation save(Bus_Reservation E) {
        try {
            if(findById(E.getId()) == null){
                PreparedStatement stmt = sqlStm.get("insert");
                stmt.setInt(1,E.getId());
                stmt.setInt(2,E.getBus_id());
                stmt.setInt(3,E.getUser_id());
                stmt.setInt(4,E.getTransaction_id());
                return E;
            }else{
                PreparedStatement stmt = sqlStm.get("update");
                stmt.setInt(1,E.getBus_id());
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
