package ir.ac.kntu;

import ir.ac.kntu.Repository.*;
import org.w3c.dom.Entity;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Collection;
import java.util.HashMap;

public class AliBaba {
    private HashMap<String, Repository> entityDaos;

    public AliBaba(Connection con) {
        entityDaos = new HashMap<>();
        entityDaos.put("BR", new Bus_ReservationDao(con));
        entityDaos.put("BT", new Bus_TicketDao(con));
        entityDaos.put("B", new BusDao(con));
        entityDaos.put("D", new DomesticDao(con));
        entityDaos.put("FR", new Flight_ReservationDao(con));
        entityDaos.put("FTR", new Flight_Ticket_RelationDao(con));
        entityDaos.put("FT", new Flight_TicketDao(con));
        entityDaos.put("F", new FlightDao(con));
        entityDaos.put("HR", new Hotel_ReservationDao(con));
        entityDaos.put("HT", new Hotel_TicketDao(con));
        entityDaos.put("H", new HotelDao(con));
        entityDaos.put("I", new InternationalDao(con));
        entityDaos.put("R", new RoomDao(con));
        entityDaos.put("T", new TransactionDao(con));
        entityDaos.put("U", new UserDao(con));
        entityDaos.put("UI", new User_InfoDao(con));
    }

    public void findAll(String repName) {
        for (Object o : entityDaos.get(repName).findAll()) {
            System.out.println(o.toString());
        }
    }

    public void findByIDs(String repName, Collection<Integer> IDs) {
        for (Object o : entityDaos.get(repName).findByIDs(IDs)) {
            System.out.println(o.toString());
        }
    }

    public Object findByID(String repName, Integer ID) {
        if (repName.equals("UI")) {
            String id = String.valueOf(ID);
            System.out.println(entityDaos.get(repName).findById(id).toString());
            return entityDaos.get(repName).findById(id);
        }
        if (entityDaos.get(repName).findById(ID)!= null) {
            System.out.println(entityDaos.get(repName).findById(ID).toString());
        }
        return entityDaos.get(repName).findById(ID);
    }

    public void deleteByID(String repName, Integer ID) {
        if (entityDaos.get(repName).deleteByID(ID)) {
            System.out.println("Object deleted successfully");
        }
    }

    public void deleteByIDs(String repName, Collection<Integer> IDs) {
        if (entityDaos.get(repName).DeleteByIDs(IDs)) {
            System.out.println("Objects deleted successfully");
        }
    }

    public void save(String repName, Object E) {
        if (entityDaos.get(repName).save(E) != null) {
            System.out.println("Object saved successfully");
        }
    }

    public User_InfoDao user_infoDao() {
        return (User_InfoDao) entityDaos.get("UI");
    }

    public Object findByIDNoPrint(String repName, Integer ID) {
        return entityDaos.get(repName).findById(ID);
    }

}
