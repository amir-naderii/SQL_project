package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Domestic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class DomesticDao implements Repository<Domestic, Integer>{
    private final HashMap<String, PreparedStatement> sqlStm = new HashMap<>();
    private FlightDao flightDao;

    public DomesticDao(Connection con){
        sqlStatements(con);
        flightDao = new FlightDao(con);
    }
    private void sqlStatements(Connection connection) {
        try {
            sqlStm.put("findByID",connection.prepareStatement(
                    "SELECT F.* FROM Domestic I, Flight F WHERE " +
                            "I.flight_id = F.id AND I.flight_id = ?"
            ));
            sqlStm.put("findAll",connection.prepareStatement(
                    "SELECT F.* FROM Domestic I, Flight F WHERE " +
                            "I.flight_id = F.id"
            ));

            sqlStm.put("insert",connection.prepareStatement(
                    "INSERT INTO Domestic VALUES(?)"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Domestic extractFromResultSet(ResultSet Rs){
        try {
            return new Domestic(Rs.getInt(1),
                    Rs.getString(2),Rs.getString(3),Rs.getString(4),
                    Rs.getString(5), Rs.getDate(6), Rs.getInt(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Domestic findById(Integer ID) {
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
    public List<Domestic> findByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<Domestic> domestics = new ArrayList<>();
            for (Integer i : IDs) {
                stmt.setInt(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    Domestic domestic = extractFromResultSet(Rs);
                    domestics.add(domestic);
                }
            }
            return domestics;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Domestic> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            ArrayList<Domestic> domestics = new ArrayList<>();
            while (Rs.next()){
                Domestic domestic = extractFromResultSet(Rs);
                domestics.add(domestic);
            }
            return domestics;
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
    public Domestic save(Domestic E) {
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
