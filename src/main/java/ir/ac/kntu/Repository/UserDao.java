package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Hotel_Ticket;
import ir.ac.kntu.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserDao implements Repository<User,Integer> {
    private final HashMap<String, PreparedStatement> sqlStm = new HashMap<>();

    public UserDao(Connection con){
        sqlStatements(con);
    }

    private void sqlStatements(Connection connection) {
        try {
            sqlStm.put("findByID",connection.prepareStatement(
                    "SELECT U.* FROM [User] U where U.id = ?"
            ));
            sqlStm.put("findAll",connection.prepareStatement(
                    "SELECT U.* FROM [User] U"
            ));
            sqlStm.put("deleteByID",connection.prepareStatement(
                    "DELETE FROM [User] WHERE id = ?"
            ));
            sqlStm.put("insert",connection.prepareStatement(
                    "INSERT INTO [User] VALUES(?,?,?,?,?,?)"
            ));
            sqlStm.put("update",connection.prepareStatement(
                    "UPDATE [User] SET credit = ?, user_info_id = ?, creation_date = ?," +
                            "modification_date = ?, modification_reason = ? WHERE id = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User extractFromResultSet(ResultSet Rs){
        try {
            return new User(Rs.getInt(1), Rs.getInt(2),
                    Rs.getString(3), Rs.getDate(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(Integer ID) {
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
    public List<User> findByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<User> users = new ArrayList<>();
            for (Integer i : IDs) {
                stmt.setInt(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    User user = extractFromResultSet(Rs);
                    users.add(user);
                }
            }
            return users;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            ArrayList<User> users = new ArrayList<>();
            while (Rs.next()){
                User user = extractFromResultSet(Rs);
                users.add(user);
            }
            return users;
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
    public User save(User E) {
        try {
            if(findById(E.getId()) == null){
                PreparedStatement stmt = sqlStm.get("insert");
                stmt.setInt(1,E.getId());
                stmt.setInt(2,E.getCredit());
                stmt.setString(3,E.getUser_info_id());
                stmt.setDate(4,(java.sql.Date) E.getCreation_date());
                stmt.setDate(5, (java.sql.Date) E.getModification_date());
                stmt.setString(6, E.getModification_reason());
                return E;
            }else{
                PreparedStatement stmt = sqlStm.get("update");
                stmt.setInt(1,E.getCredit());
                stmt.setString(2,E.getUser_info_id());
                stmt.setDate(3,(java.sql.Date) E.getCreation_date());
                stmt.setDate(4, (java.sql.Date) E.getModification_date());
                stmt.setString(5, E.getModification_reason());
                stmt.setInt(6,E.getId());
                return E;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
