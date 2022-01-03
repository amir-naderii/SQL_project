package ir.ac.kntu.Model;

public class Hotel_Reservation {
    private int id;
    private int hotel_ticket_id;
    private int user_id;
    private int transaction_id;

    public Hotel_Reservation(int id, int hotel_ticket_id, int user_id, int transaction_id) {
        this.id = id;
        this.hotel_ticket_id = hotel_ticket_id;
        this.user_id = user_id;
        this.transaction_id = transaction_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotel_id() {
        return hotel_ticket_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_ticket_id = hotel_id;
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
