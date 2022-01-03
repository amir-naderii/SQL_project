package ir.ac.kntu.Model;

public class Flight_Ticket {
    private int id;
    private int passengers;
    private int price;
    private String flight_type;
    private String flight_class;

    public Flight_Ticket(int id, int passengers, int price, String flight_type) {
        this.id = id;
        this.passengers = passengers;
        this.price = price;
        this.flight_type = flight_type;
    }

    public Flight_Ticket(int id, int passengers, int price, String flight_type, String flight_class) {
        this.id = id;
        this.passengers = passengers;
        this.price = price;
        this.flight_type = flight_type;
        this.flight_class = flight_class;
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

    public String getFlight_type() {
        return flight_type;
    }

    public void setFlight_type(String flight_type) {
        this.flight_type = flight_type;
    }

    public String getFlight_class() {
        return flight_class;
    }

    public void setFlight_class(String flight_class) {
        this.flight_class = flight_class;
    }
}
