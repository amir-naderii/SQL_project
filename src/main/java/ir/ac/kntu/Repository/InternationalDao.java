package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Bus_Ticket;
import ir.ac.kntu.Model.Flight;
import ir.ac.kntu.Model.International;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class InternationalDao implements Repository<International, Integer>{
    private final HashMap<String, PreparedStatement> sqlStm = new HashMap<>();
    private FlightDao flightDao;

    public InternationalDao(Connection con){
        sqlStatements(con);
        flightDao = new FlightDao(con);
    }
    private void sqlStatements(Connection connection) {
        try {
            sqlStm.put("findByID",connection.prepareStatement(
                    "SELECT F.* FROM International I, Flight F WHERE " +
                            "I.flight_id = F.id AND I.flight_id = ?"
            ));
            sqlStm.put("findAll",connection.prepareStatement(
                    "SELECT F.* FROM International I, Flight F WHERE " +
                            "I.flight_id = F.id"
            ));

            sqlStm.put("insert",connection.prepareStatement(
                    "INSERT INTO International VALUES(?)"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private International extractFromResultSet(ResultSet Rs){
        try {
            return new International(Rs.getInt(1),
                    Rs.getString(2),Rs.getString(3),Rs.getString(4),
                    Rs.getString(5), Rs.getDate(6), Rs.getInt(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public International findById(Integer ID) {
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
    public List<International> findByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<International> internationals = new ArrayList<>();
            for (Integer i : IDs) {
                stmt.setInt(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    International international = extractFromResultSet(Rs);
                    internationals.add(international);
                }
            }
            return internationals;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<International> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            ArrayList<International> internationals = new ArrayList<>();
            while (Rs.next()){
                International international = extractFromResultSet(Rs);
                internationals.add(international);
            }
            return internationals;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean deleteByID(Integer ID) {
        return flightDao.deleteByID(ID);
    }

    @Override
    public Boolean DeleteByIDs(Collection<Integer> IDs) {
        return flightDao.DeleteByIDs(IDs);
    }

    @Override
    public International save(International E) {
        flightDao.save(E);
        if(flightDao.findById(E.getId()) != null){
            PreparedStatement stmt = sqlStm.get("insert");
            try {
                stmt.setInt(1,E.getId());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
