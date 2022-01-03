package ir.ac.kntu.Model;

import java.util.Date;

public class Hotel_Ticket {
    private int id;
    private int price;
    private Date check_in;
    private Date check_out;
    private int hotel_id;
    private int room_id;

    public Hotel_Ticket(int id, int price, Date check_in, Date check_out, int hotel_id, int room_id) {
        this.id = id;
        this.price = price;
        this.check_in = check_in;
        this.check_out = check_out;
        this.hotel_id = hotel_id;
        this.room_id = room_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
}
