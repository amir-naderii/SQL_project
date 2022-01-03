package ir.ac.kntu.Model;

public class Flight_Ticket_Relation {
    private int id;
    private int flight_id;
    private int flight_ticket_id;

    public Flight_Ticket_Relation(int id, int flight_id, int flight_ticket_id) {
        this.id = id;
        this.flight_id = flight_id;
        this.flight_ticket_id = flight_ticket_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public int getFlight_ticket_id() {
        return flight_ticket_id;
    }

    public void setFlight_ticket_id(int flight_ticket_id) {
        this.flight_ticket_id = flight_ticket_id;
    }
}
