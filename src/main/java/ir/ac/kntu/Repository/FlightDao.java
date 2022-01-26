package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class FlightDao implements Repository<Flight,Integer> {

    private final HashMap<String, PreparedStatement> sqlStm = new HashMap<>();

    public FlightDao(Connection con){
        sqlStatements(con);
    }

    private void sqlStatements(Connection connection) {
        try {
            sqlStm.put("findByID",connection.prepareStatement(
                    "SELECT F.* FROM Flight F where F.id = ?"
            ));
            sqlStm.put("findAll",connection.prepareStatement(
                    "SELECT F.* FROM Flight F"
            ));
            sqlStm.put("deleteByID",connection.prepareStatement(
                    "DELETE FROM Flight WHERE id = ?"
            ));
            sqlStm.put("insert",connection.prepareStatement(
                    "INSERT INTO Flight VALUES(?,?,?,?,?,?,?,?)"
            ));
            sqlStm.put("update",connection.prepareStatement(
                    "UPDATE Flight SET departure_city = ?, departure_airport = ?," +
                            " destination_city = ?, destination_airport = ?, travel_date =?," +
                            " capacity = ?, company = ? WHERE id = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Flight extractFromResultSet(ResultSet Rs){
        try {
            return new Flight(Rs.getInt(1),
                    Rs.getString(2),Rs.getString(3),Rs.getString(4),
                    Rs.getString(5), Rs.getDate(6), Rs.getInt(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Flight findById(Integer ID) {
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
    public List<Flight> findByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<Flight> flights = new ArrayList<>();
            for (Integer i : IDs) {
                stmt.setInt(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    Flight flight = extractFromResultSet(Rs);
                    flights.add(flight);
                }
            }
            return flights;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Flight> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            ArrayList<Flight> flights = new ArrayList<>();
            while (Rs.next()){
                Flight flight = extractFromResultSet(Rs);
                flights.add(flight);
            }
            return flights;
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
    public Flight save(Flight E) {
        try {
            if(findById(E.getId()) == null){
                PreparedStatement stmt = sqlStm.get("insert");
                stmt.setInt(1,E.getId());
                stmt.setString(2,E.getDeparture_city());
                stmt.setString(3,E.getDeparture_airport());
                stmt.setString(4,E.getDestination_city());
                stmt.setString(5,E.getDestination_airport());
                stmt.setDate(6, (java.sql.Date) E.getTravel_date());
                stmt.setInt(7, E.getCapacity());
                stmt.setString(8, E.getCompany());
                stmt.executeUpdate();
                return E;
            }else{
                PreparedStatement stmt = sqlStm.get("update");
                stmt.setString(1,E.getDeparture_city());
                stmt.setString(2,E.getDeparture_airport());
                stmt.setString(3,E.getDestination_city());
                stmt.setString(4,E.getDestination_airport());
                stmt.setDate(5,(java.sql.Date) E.getTravel_date());
                stmt.setInt(6, E.getCapacity());
                stmt.setString(7, E.getCompany());
                stmt.setInt(8, E.getId());
                stmt.executeUpdate();
                return E;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
