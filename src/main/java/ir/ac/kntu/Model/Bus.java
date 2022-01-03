package ir.ac.kntu.Model;

import java.util.Date;

public class Bus {
    private int id;
    private String departure_city;
    private String departure_terminal;
    private String destination_city;
    private String destination_terminal;
    private Date travel_date;
    private String company;

    public Bus(int id, String departure_city, String departure_terminal, String destination_city, String destination_terminal, Date travel_date, String company) {
        this.id = id;
        this.departure_city = departure_city;
        this.departure_terminal = departure_terminal;
        this.destination_city = destination_city;
        this.destination_terminal = destination_terminal;
        this.travel_date = travel_date;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getDeparture_terminal() {
        return departure_terminal;
    }

    public void setDeparture_terminal(String departure_terminal) {
        this.departure_terminal = departure_terminal;
    }

    public String getDestination_city() {
        return destination_city;
    }

    public void setDestination_city(String destination_city) {
        this.destination_city = destination_city;
    }

    public String getDestination_terminal() {
        return destination_terminal;
    }

    public void setDestination_terminal(String destination_terminal) {
        this.destination_terminal = destination_terminal;
    }

    public Date getTravel_date() {
        return travel_date;
    }

    public void setTravel_date(Date travel_date) {
        this.travel_date = travel_date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
