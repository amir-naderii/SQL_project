package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class HotelDao implements Repository<Hotel,Integer> {
    private final HashMap<String, PreparedStatement> sqlStm = new HashMap<>();

    public HotelDao(Connection con){
        sqlStatements(con);
    }

    private void sqlStatements(Connection connection) {
        try {
            sqlStm.put("findByID",connection.prepareStatement(
                    "SELECT H.* FROM Hotel H where H.id = ?"
            ));
            sqlStm.put("findAll",connection.prepareStatement(
                    "SELECT H.* FROM Hotel H"
            ));
            sqlStm.put("deleteByID",connection.prepareStatement(
                    "DELETE FROM Hotel WHERE id = ?"
            ));
            sqlStm.put("insert",connection.prepareStatement(
                    "INSERT INTO Hotel VALUES(?,?,?,?,?,?,?)"
            ));
            sqlStm.put("update",connection.prepareStatement(
                    "UPDATE Hotel SET stars = ?, popularity = ?," +
                            " address = ?, name = ?, facilities =?," +
                            " hotel_type = ? WHERE id = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Hotel extractFromResultSet(ResultSet Rs){
        try {
            return new Hotel(Rs.getInt(1),
                    Rs.getInt(2),Rs.getInt(3),Rs.getString(4),
                    Rs.getString(5), Rs.getString(6), Rs.getInt(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Hotel findById(Integer ID) {
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

    public List<Hotel> findByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<Hotel> Hotels = new ArrayList<>();
            for (Integer i : IDs) {
                stmt.setInt(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    Hotel hotel = extractFromResultSet(Rs);
                    Hotels.add(hotel);
                }
            }
            return Hotels;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Hotel> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            ArrayList<Hotel> hotels = new ArrayList<>();
            while (Rs.next()){
                Hotel hotel = extractFromResultSet(Rs);
                hotels.add(hotel);
            }
            return hotels;
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

    public Hotel save(Hotel E) {
        try {
            if(findById(E.getId()) == null){
                PreparedStatement stmt = sqlStm.get("insert");
                stmt.setInt(1,E.getId());
                stmt.setInt(2,E.getStars());
                stmt.setInt(3,E.getPopularity());
                stmt.setString(4,E.getAddress());
                stmt.setString(5,E.getName());
                stmt.setString(6, E.getFacilities());
                stmt.setInt(7, E.getHotel_type());
                stmt.executeUpdate();
                return E;
            }else{
                PreparedStatement stmt = sqlStm.get("update");
                stmt.setInt(1,E.getStars());
                stmt.setInt(2,E.getPopularity());
                stmt.setString(3,E.getAddress());
                stmt.setString(4,E.getName());
                stmt.setString(5, E.getFacilities());
                stmt.setInt(6, E.getHotel_type());
                stmt.setInt(7, E.getId());
                stmt.executeUpdate();
                return E;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
