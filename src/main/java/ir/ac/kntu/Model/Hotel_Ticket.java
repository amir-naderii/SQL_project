package ir.ac.kntu.Model;

import java.util.Date;

public class Hotel_Ticket {
    private Integer id;
    private Integer price;
    private Date check_in;
    private Date check_out;
    private Integer hotel_id;
    private Integer room_id;

    public Hotel_Ticket(Integer id, Integer price, Date check_in, Date check_out, Integer hotel_id, Integer room_id) {
        this.id = id;
        this.price = price;
        this.check_in = check_in;
        this.check_out = check_out;
        this.hotel_id = hotel_id;
        this.room_id = room_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    @Override
    public String toString() {
        return "Hotel_Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", check_in=" + check_in +
                ", check_out=" + check_out +
                ", hotel_id=" + hotel_id +
                ", room_id=" + room_id +
                '}';
    }
}
