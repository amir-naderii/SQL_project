package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.User_Info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class User_InfoDao implements Repository<User_Info, String> {
    private final HashMap<String, PreparedStatement> sqlStm = new HashMap<>();

    public User_InfoDao(Connection con){
        sqlStatements(con);
    }

    private void sqlStatements(Connection connection) {
        try {
            sqlStm.put("findByID",connection.prepareStatement(
                    "SELECT UI.* FROM User_Info UI where UI.id_number = ?"
            ));
            sqlStm.put("findAll",connection.prepareStatement(
                    "SELECT User_Info.* FROM User_Info"
            ));
            sqlStm.put("deleteByID",connection.prepareStatement(
                    "DELETE FROM User_Info WHERE id_number = ?"
            ));
            sqlStm.put("insert",connection.prepareStatement(
                    "INSERT INTO User_Info VALUES(?,?,?,?,?,?,?)"
            ));
            sqlStm.put("update",connection.prepareStatement(
                    "UPDATE User_Info SET email = ?, phone_number = ?, full_name" +
                            ", gender = ?, birth_date = ?, Pass WHERE id_number = ?"
            ));
            sqlStm.put("findPass", connection.prepareStatement(
                    "SELECT UI.pass FROM User_Info UI WHERE UI.id_number = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User_Info extractFromResultSet(ResultSet Rs){
        try {
            return new User_Info(Rs.getString(1), Rs.getString(2),
                    Rs.getString(3),Rs.getString(4), Rs.getString(5),
                    Rs.getDate(6), Rs.getString(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User_Info findById(String ID) {
        try{
            PreparedStatement stmt = sqlStm.get("findByID");
            stmt.setString(1,ID);
            ResultSet Rs = stmt.executeQuery();
            if(Rs.next()){
                return extractFromResultSet(Rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User_Info> findByIDs(Collection<String> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<User_Info> user_infos = new ArrayList<>();
            for (String i : IDs) {
                stmt.setString(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    User_Info user_info = extractFromResultSet(Rs);
                    user_infos.add(user_info);
                }
            }
            return user_infos;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User_Info> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            ArrayList<User_Info> user_infos = new ArrayList<>();
            while (Rs.next()){
                User_Info user_info = extractFromResultSet(Rs);
                user_infos.add(user_info);
            }
            return user_infos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean deleteByID(String ID) {
        try{
            PreparedStatement stmt = sqlStm.get("deleteByID");
            stmt.setString(1,ID);
            int result = stmt.executeUpdate();
            if(result == 1)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean DeleteByIDs(Collection<String> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("deleteByID");
            for (String i:IDs) {
                stmt.setString(1,i);
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

    public User_Info save(User_Info E) {
        try {
            if(findById(E.getId_number()) == null){
                PreparedStatement stmt = sqlStm.get("insert");
                stmt.setString(1,E.getId_number());
                stmt.setString(2,E.getEmail());
                stmt.setString(3,E.getPhone_number());
                stmt.setString(4,E.getFull_name());
                stmt.setString(5,E.getGender());
                stmt.setDate(6, (java.sql.Date)E.getBirth_date());
                stmt.setString(7, E.getPass());
                stmt.executeUpdate();
                return E;
            }else{
                PreparedStatement stmt = sqlStm.get("update");
                stmt.setString(1,E.getEmail());
                stmt.setString(2,E.getPhone_number());
                stmt.setString(3,E.getFull_name());
                stmt.setString(4,E.getGender());
                stmt.setDate(5, (java.sql.Date)E.getBirth_date());
                stmt.setString(6, E.getPass());
                stmt.setString(7, E.getId_number());
                stmt.executeUpdate();
                return E;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String findPass(String ID) {
        try{
            PreparedStatement stmt = sqlStm.get("findByID");
            stmt.setString(1,ID);
            ResultSet Rs = stmt.executeQuery();
            if(Rs.next()){
                return extractFromResultSet(Rs).getPass();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
