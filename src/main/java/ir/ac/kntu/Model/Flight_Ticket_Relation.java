package ir.ac.kntu.Model;

public class Flight_Ticket_Relation {
    private Integer id;
    private Integer flight_id;
    private Integer flight_ticket_id;

    public Flight_Ticket_Relation(Integer id, Integer flight_id, Integer flight_ticket_id) {
        this.id = id;
        this.flight_id = flight_id;
        this.flight_ticket_id = flight_ticket_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Integer flight_id) {
        this.flight_id = flight_id;
    }

    public Integer getFlight_ticket_id() {
        return flight_ticket_id;
    }

    public void setFlight_ticket_id(Integer flight_ticket_id) {
        this.flight_ticket_id = flight_ticket_id;
    }

    @Override
    public String toString() {
        return "Flight_Ticket_Relation{" +
                "id=" + id +
                ", flight_id=" + flight_id +
                ", flight_ticket_id=" + flight_ticket_id +
                '}';
    }
}
