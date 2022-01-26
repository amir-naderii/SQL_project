package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TransactionDao implements Repository<Transaction,Integer> {
    private final HashMap<String, PreparedStatement> sqlStm = new HashMap<>();

    public TransactionDao(Connection con){
        sqlStatements(con);
    }

    private void sqlStatements(Connection connection) {
        try {
            sqlStm.put("findByID",connection.prepareStatement(
                    "SELECT T.* FROM [Transaction] T where T.id = ?"
            ));
            sqlStm.put("findAll",connection.prepareStatement(
                    "SELECT T.* FROM [Transaction] T"
            ));
            sqlStm.put("deleteByID",connection.prepareStatement(
                    "DELETE FROM [Transaction] WHERE id = ?"
            ));
            sqlStm.put("insert",connection.prepareStatement(
                    "INSERT INTO [Transaction] VALUES(?,?,?,?,?,?)"
            ));
            sqlStm.put("update",connection.prepareStatement(
                    "UPDATE [Transaction] SET date = ?, amount = ?," +
                            " credit_card_number = ?, charge_user_id = ?, type =?" +
                            " WHERE id = ?"
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Transaction extractFromResultSet(ResultSet Rs){
        try {
            return new Transaction(Rs.getInt(1),
                    Rs.getDate(2),Rs.getInt(3),Rs.getString(4),
                    Rs.getInt(5), Rs.getString(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Transaction findById(Integer ID) {
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

    public List<Transaction> findByIDs(Collection<Integer> IDs) {
        try {
            PreparedStatement stmt = sqlStm.get("findByID");
            ArrayList<Transaction> Transactions = new ArrayList<>();
            for (Integer i : IDs) {
                stmt.setInt(1, i);
                ResultSet Rs = stmt.executeQuery();
                if(Rs.next()) {
                    Transaction transaction = extractFromResultSet(Rs);
                    Transactions.add(transaction);
                }
            }
            return Transactions;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Transaction> findAll() {
        try {
            PreparedStatement stmt = sqlStm.get("findAll");
            ResultSet Rs = stmt.executeQuery();
            if (Rs == null) {
                System.out.println("'bia");
            }
            ArrayList<Transaction> transactions = new ArrayList<>();
            while (Rs.next()){
                Transaction transaction = extractFromResultSet(Rs);
                transactions.add(transaction);
            }
            return transactions;
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

    public Transaction save(Transaction E) {
        try {
            if(findById(E.getId()) == null){
                PreparedStatement stmt = sqlStm.get("insert");
                stmt.setInt(1, E.getId());
                stmt.setDate(2, (java.sql.Date) E.getDate());
                stmt.setInt(3, E.getAmount());
                stmt.setString(4, E.getCredit_card_number());
                stmt.setInt(5, E.getCharge_user_id());
                stmt.setString(6, E.getType());
                stmt.executeUpdate();
                return E;
            }else{
                PreparedStatement stmt = sqlStm.get("update");
                stmt.setDate(1, (java.sql.Date) E.getDate());
                stmt.setInt(2, E.getAmount());
                stmt.setString(3, E.getCredit_card_number());
                stmt.setInt(4, E.getCharge_user_id());
                stmt.setString(5, E.getType());
                stmt.setInt(6, E.getId());
                stmt.executeUpdate();
                return E;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
