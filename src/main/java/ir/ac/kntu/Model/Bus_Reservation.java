package ir.ac.kntu.Model;

public class Bus_Reservation {
    private Integer id;
    private Integer bus_ticket_id;
    private Integer user_id;
    private Integer transaction_id;

    public Bus_Reservation(Integer id, Integer bus_ticket_id, Integer user_id, Integer transaction_id) {
        this.id = id;
        this.bus_ticket_id = bus_ticket_id;
        this.user_id = user_id;
        this.transaction_id = transaction_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBus_id() {
        return bus_ticket_id;
    }

    public void setBus_id(Integer bus_id) {
        this.bus_ticket_id = bus_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }
}
