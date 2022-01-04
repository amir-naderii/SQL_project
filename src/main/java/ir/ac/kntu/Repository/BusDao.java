package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Bus;
import ir.ac.kntu.Model.Bus_Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
                    "INSERT INTO Bus VALUES(?,?,?,?,?,?,?,?)"
            ));
            sqlStm.put("update",connection.prepareStatement(
                    "UPDATE Bus SET departure_city = ?, departure_terminal = ?, destination_city = ?, " +
                            "destination_terminal = ?, travel_date = ?, company = ?, capacity = ? WHERE id = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Bus extractFromResultSet(ResultSet Rs) {
        try {
            return new Bus(Rs.getInt(1),
                    Rs.getString(2), Rs.getString(3), Rs.getString(4),
                    Rs.getString(5), Rs.getDate(6), Rs.getInt(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Bus findById(Integer ID) {
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

    public List<Bus> findByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<Bus> buses = new ArrayList<>();
            for (Integer i : IDs) {
                stmt.setInt(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    Bus bus = extractFromResultSet(Rs);
                    buses.add(bus);
                }
            }
            return buses;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Bus> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            ArrayList<Bus> buses = new ArrayList<>();
            while (Rs.next()){
                Bus bus = extractFromResultSet(Rs);
                buses.add(bus);
            }
            return buses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

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

    public Bus save(Bus E) {
        try {
            if(findById(E.getId()) == null){
                PreparedStatement stmt = sqlStm.get("insert");
                stmt.setInt(1,E.getId());
                stmt.setString(2,E.getDeparture_city());
                stmt.setString(3,E.getDeparture_terminal());
                stmt.setString(4,E.getDestination_city());
                stmt.setString(5,E.getDestination_terminal());
                stmt.setDate(6,(java.sql.Date) E.getTravel_date());
                stmt.setInt(7,E.getCapacity());
                stmt.setString(8,E.getCompany());
                stmt.executeUpdate();
                return E;
            }else{
                PreparedStatement stmt = sqlStm.get("update");
                stmt.setString(1,E.getDeparture_city());
                stmt.setString(2,E.getDeparture_terminal());
                stmt.setString(3,E.getDestination_city());
                stmt.setString(4,E.getDestination_terminal());
                stmt.setDate(5,(java.sql.Date) E.getTravel_date());
                stmt.setInt(6,E.getCapacity());
                stmt.setString(7,E.getCompany());
                stmt.setInt(8,E.getId());
                stmt.executeUpdate();
                return E;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
