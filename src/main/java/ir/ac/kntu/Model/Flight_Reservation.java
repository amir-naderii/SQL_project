package ir.ac.kntu.Model;

public class Flight_Reservation {
    private int id;
    private int flight_ticket_id;
    private int user_id;
    private int transaction;

    public Flight_Reservation(int id, int flight_ticket_id, int user_id, int transaction) {
        this.id = id;
        this.flight_ticket_id = flight_ticket_id;
        this.user_id = user_id;
        this.transaction = transaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlight_ticket_id() {
        return flight_ticket_id;
    }

    public void setFlight_ticket_id(int flight_ticket_id) {
        this.flight_ticket_id = flight_ticket_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTransaction() {
        return transaction;
    }

    public void setTransaction(int transaction) {
        this.transaction = transaction;
    }
}
