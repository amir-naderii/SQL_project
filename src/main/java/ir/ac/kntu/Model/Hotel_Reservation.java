package ir.ac.kntu.Model;

public class Hotel_Reservation {
    private Integer id;
    private Integer hotel_ticket_id;
    private Integer user_id;
    private Integer transaction_id;

    public Hotel_Reservation(Integer id, Integer hotel_ticket_id, Integer user_id, Integer transaction_id) {
        this.id = id;
        this.hotel_ticket_id = hotel_ticket_id;
        this.user_id = user_id;
        this.transaction_id = transaction_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotel_ticket_id() {
        return hotel_ticket_id;
    }

    public void setHotel_ticket_id(Integer hotel_id) {
        this.hotel_ticket_id = hotel_id;
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

    @Override
    public String toString() {
        return "Hotel_Reservation{" +
                "id=" + id +
                ", hotel_ticket_id=" + hotel_ticket_id +
                ", user_id=" + user_id +
                ", transaction_id=" + transaction_id +
                '}';
    }
}
