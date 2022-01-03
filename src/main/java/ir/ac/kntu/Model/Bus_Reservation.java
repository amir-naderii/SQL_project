package ir.ac.kntu.Model;

public class Bus_Reservation {
    private int id;
    private int bus_ticket_id;
    private int user_id;
    private int transaction_id;

    public Bus_Reservation(int id, int bus_ticket_id, int user_id, int transaction_id) {
        this.id = id;
        this.bus_ticket_id = bus_ticket_id;
        this.user_id = user_id;
        this.transaction_id = transaction_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBus_id() {
        return bus_ticket_id;
    }

    public void setBus_id(int bus_id) {
        this.bus_ticket_id = bus_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }
}
