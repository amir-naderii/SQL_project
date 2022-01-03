package ir.ac.kntu.Model;

public class Hotel {
    private Integer id;
    private Integer stars;
    private Integer popularity;
    private String address;
    private String name;
    private String facilities;
    private Hotel_type hotel_type;

    public Hotel(Integer id, Integer stars, Integer popularity, String address, String name, String facilities, Hotel_type hotel_type) {
        this.id = id;
        this.stars = stars;
        this.popularity = popularity;
        this.address = address;
        this.name = name;
        this.facilities = facilities;
        this.hotel_type = hotel_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public Hotel_type getHotel_type() {
        return hotel_type;
    }

    public void setHotel_type(Hotel_type hotel_type) {
        this.hotel_type = hotel_type;
    }
}
