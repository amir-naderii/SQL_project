package ir.ac.kntu.Model;

import java.util.Date;

public class Domestic extends Flight {
    public Domestic(Integer id, String departure_city, String departure_airport, String destination_city,
                    String destination_airport, Date travel_date, Integer capacity) {
        super(id, departure_city, departure_airport, destination_city, destination_airport, travel_date, capacity);
    }
}
