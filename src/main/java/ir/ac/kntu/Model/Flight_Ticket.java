package ir.ac.kntu.Model;

public class Flight_Ticket {
    private Integer id;
    private Integer passengers;
    private Integer price;
    private String flight_type;
    private String flight_class;

    public Flight_Ticket(Integer id, Integer passengers, Integer price, String flight_type) {
        this.id = id;
        this.passengers = passengers;
        this.price = price;
        this.flight_type = flight_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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
