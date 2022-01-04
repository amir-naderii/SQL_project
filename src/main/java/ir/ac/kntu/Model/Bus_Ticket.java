package ir.ac.kntu.Model;

public class Bus_Ticket {
    private Integer id;
    private Integer passengers;
    private Integer price;
    private Integer bus_id;

    @Override
    public String toString() {
        return "Bus_Ticket{" +
                "id=" + id +
                ", passengers=" + passengers +
                ", price=" + price +
                ", bus_id=" + bus_id +
                '}';
    }

    public Bus_Ticket(Integer id, Integer passengers, Integer price, Integer bus_id) {
        this.id = id;
        this.passengers = passengers;
        this.price = price;
        this.bus_id = bus_id;
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

    public Integer getBus_id() {
        return bus_id;
    }

    public void setBus_id(Integer bus_id) {
        this.bus_id = bus_id;
    }
}
