package ir.ac.kntu.Model;

public class Room {
    private Integer id;
    private Integer hotel_id;
    private String type;
    private Integer capacity;

    public Room(Integer id, Integer hotel_id, String type, Integer capacity) {
        this.id = id;
        this.hotel_id = hotel_id;
        this.type = type;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
