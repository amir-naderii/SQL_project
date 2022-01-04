package ir.ac.kntu.Model;

import java.util.Date;

public class Bus {
    private Integer id;
    private String departure_city;
    private String departure_terminal;
    private String destination_city;
    private String destination_terminal;
    private Date travel_date;
    private String company;
    private Integer capacity;

    public Bus(Integer id, String departure_city, String departure_terminal, String destination_city,
               String destination_terminal, Date travel_date, Integer capacity) {
        this.id = id;
        this.departure_city = departure_city;
        this.departure_terminal = departure_terminal;
        this.destination_city = destination_city;
        this.destination_terminal = destination_terminal;
        this.travel_date = travel_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", departure_city='" + departure_city + '\'' +
                ", departure_terminal='" + departure_terminal + '\'' +
                ", destination_city='" + destination_city + '\'' +
                ", destination_terminal='" + destination_terminal + '\'' +
                ", travel_date=" + travel_date +
                ", company='" + company + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
