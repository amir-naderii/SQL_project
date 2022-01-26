package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Flight_Ticket_Relation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Flight_Ticket_RelationDao implements Repository<Flight_Ticket_Relation,Integer> {
    private HashMap<String, PreparedStatement> sqlStm = new HashMap<>();

    public Flight_Ticket_RelationDao(Connection con){
        sqlStatements(con);
    }

    private void sqlStatements(Connection con) {
        try {
            sqlStm.put("findByID",con.prepareStatement(
                    "SELECT FTR.* FROM Flight_Ticket_Relation FTR where FTR.id = ?"
            ));
            sqlStm.put("findAll",con.prepareStatement(
                    "SELECT FTR.* FROM Flight_Ticket_Relation FTR"
            ));
            sqlStm.put("deleteByID",con.prepareStatement(
                    "DELETE FROM Flight_Ticket_Relation WHERE id = ?"
            ));
            sqlStm.put("insert",con.prepareStatement(
                    "INSERT INTO Flight_Ticket_Relation VALUES(?,?,?)"
            ));
            sqlStm.put("update",con.prepareStatement(
                    "UPDATE Flight_Ticket_Relation SET flight_ticket_id = ?, flight_id  = ? WHERE id = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Flight_Ticket_Relation extractFromResultSet(ResultSet Rs) {
        try {
            return new Flight_Ticket_Relation(Rs.getInt(1),
                    Rs.getInt(2), Rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Flight_Ticket_Relation findById(Integer ID) {
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
    public List<Flight_Ticket_Relation> findByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<Flight_Ticket_Relation> flight_ticket_relations = new ArrayList<>();
            for (Integer i : IDs) {
                stmt.setInt(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    Flight_Ticket_Relation flight_ticket_relation = extractFromResultSet(Rs);
                    flight_ticket_relations.add(flight_ticket_relation);
                }
            }
            return flight_ticket_relations;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Flight_Ticket_Relation> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            ArrayList<Flight_Ticket_Relation> flight_ticket_relations = new ArrayList<>();
            while (Rs.next()){
                Flight_Ticket_Relation flight_ticket_relation = extractFromResultSet(Rs);
                flight_ticket_relations.add(flight_ticket_relation);
            }
            return flight_ticket_relations;
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
    public Flight_Ticket_Relation save(Flight_Ticket_Relation E) {
        try {
            if(findById(E.getId()) == null){
                PreparedStatement stmt = sqlStm.get("insert");
                stmt.setInt(1,E.getId());
                stmt.setInt(2,E.getFlight_id());
                stmt.setInt(3,E.getFlight_ticket_id());
                stmt.executeUpdate();
                return E;
            }else{
                PreparedStatement stmt = sqlStm.get("update");
                stmt.setInt(1,E.getFlight_ticket_id());
                stmt.setInt(2,E.getFlight_id());
                stmt.setInt(3,E.getId());
                stmt.executeUpdate();
                return E;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
