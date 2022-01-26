package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class RoomDao implements Repository<Room,Integer> {
    private HashMap<String, PreparedStatement> sqlStm = new HashMap<>();

    public RoomDao(Connection con){
        sqlStatements(con);
    }

    private void sqlStatements(Connection con) {
        try {
            sqlStm.put("findByID",con.prepareStatement(
                    "SELECT R.* FROM Room R where R.id = ?"
            ));
            sqlStm.put("findAll",con.prepareStatement(
                    "SELECT R.* FROM Room R"
            ));
            sqlStm.put("deleteByID",con.prepareStatement(
                    "DELETE FROM Room WHERE id = ?"
            ));
            sqlStm.put("insert",con.prepareStatement(
                    "INSERT INTO Room VALUES(?,?,?,?)"
            ));
            sqlStm.put("update",con.prepareStatement(
                    "UPDATE Room SET hotel_id = ?, type  = ?, capacity = ? WHERE id = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Room extractFromResultSet(ResultSet Rs) {
        try {
            return new Room(Rs.getInt(1),
                    Rs.getInt(2), Rs.getString(3), Rs.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Room findById(Integer ID) {
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

    public List<Room> findByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<Room> rooms = new ArrayList<>();
            for (Integer i : IDs) {
                stmt.setInt(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    Room room = extractFromResultSet(Rs);
                    rooms.add(room);
                }
            }
            return rooms;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Room> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            ArrayList<Room> rooms = new ArrayList<>();
            while (Rs.next()){
                Room room = extractFromResultSet(Rs);
                rooms.add(room);
            }
            return rooms;
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
        return null;
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

    public Room save(Room E) {
        try {
            if(findById(E.getId()) == null){
                PreparedStatement stmt = sqlStm.get("insert");
                stmt.setInt(1,E.getId());
                stmt.setInt(2,E.getHotel_id());
                stmt.setString(3,E.getType());
                stmt.setInt(4,E.getCapacity());
                stmt.executeUpdate();
                return E;
            }else{
                PreparedStatement stmt = sqlStm.get("update");
                stmt.setInt(1,E.getHotel_id());
                stmt.setString(2,E.getType());
                stmt.setInt(3,E.getCapacity());
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
