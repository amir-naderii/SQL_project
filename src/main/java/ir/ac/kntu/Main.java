package ir.ac.kntu;

import ir.ac.kntu.Model.Bus_Ticket;
import ir.ac.kntu.Model.Hotel;
import ir.ac.kntu.Model.Hotel_type;
import ir.ac.kntu.Model.International;
import ir.ac.kntu.Repository.Bus_TicketDao;
import ir.ac.kntu.Repository.ConnectionFactory;
import ir.ac.kntu.Repository.HotelDao;
import ir.ac.kntu.Repository.InternationalDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        Collection<Integer> IDs = new ArrayList<>();
        IDs.add(0);
        IDs.add(1);
        IDs.add(2);
        //Bus_TicketDao bus_ticketDao = new Bus_TicketDao(connection);
//        //System.out.println(bus_ticketDao.findById(0));
//        bus_ticketDao.findAll().forEach(System.out::println);
//        Hotel hotel = new Hotel(20, 5, 4, "Tehran", "Azadi", "Sobhane",
//                Hotel_type.HOTEL);
//
//        HotelDao hotelDao = new HotelDao(connection);
//        hotelDao.save(hotel);
        //bus_ticketDao.save(new Bus_Ticket(11,1,1,0, 10));
        International international = new International(100, "Tehran", "IKA",
                "Yazd", "YA", Date.valueOf("2021-2-2"), 1);
        InternationalDao internationalDao = new InternationalDao(connection);
        internationalDao.save(international);

    }

}
