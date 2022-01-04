package ir.ac.kntu.Model;

public class Flight_Reservation {
    private Integer id;
    private Integer flight_ticket_id;
    private Integer user_id;
    private Integer transaction;

    public Flight_Reservation(Integer id, Integer flight_ticket_id, Integer user_id, Integer transaction) {
        this.id = id;
        this.flight_ticket_id = flight_ticket_id;
        this.user_id = user_id;
        this.transaction = transaction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlight_ticket_id() {
        return flight_ticket_id;
    }

    public void setFlight_ticket_id(Integer flight_ticket_id) {
        this.flight_ticket_id = flight_ticket_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTransaction() {
        return transaction;
    }

    public void setTransaction(Integer transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Flight_Reservation{" +
                "id=" + id +
                ", flight_ticket_id=" + flight_ticket_id +
                ", user_id=" + user_id +
                ", transaction=" + transaction +
                '}';
    }
}
