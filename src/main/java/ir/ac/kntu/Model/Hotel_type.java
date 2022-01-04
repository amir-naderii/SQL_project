package ir.ac.kntu.Model;

public enum Hotel_type {
    HOTEL(0),
    HOTEL_APARTMENT(1),
    HUSTLE(2);
    public final Integer id;

    private Hotel_type(Integer id) {
        this.id = id;
    }
}
