package ir.ac.kntu.Model;

public class Bus_Ticket {
    private int id;
    private int passengers;
    private int price;
    private String company;
    private int bus_id;

    public Bus_Ticket(int id, int passengers, int price, int bus_id) {
        this.id = id;
        this.passengers = passengers;
        this.price = price;
        this.bus_id = bus_id;
    }

    public Bus_Ticket(int id, int passengers, int price, String company, int bus_id) {
        this.id = id;
        this.passengers = passengers;
        this.price = price;
        this.company = company;
        this.bus_id = bus_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getBus_id() {
        return bus_id;
    }

    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }
}
