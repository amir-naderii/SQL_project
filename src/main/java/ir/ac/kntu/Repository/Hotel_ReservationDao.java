package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Hotel_Reservation;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class Hotel_ReservationDao implements Repository<Hotel_Reservation,Integer> {

    @Override
    public Hotel_Reservation findById(Integer integer) {
        return null;
    }

    @Override
    public List<Hotel_Reservation> findByIDs(Collection<Integer> integers) {
        return null;
    }

    @Override
    public List<Hotel_Reservation> findAll() {
        return null;
    }

    @Override
    public Boolean deleteByID(Integer integer) {
        return null;
    }

    @Override
    public Boolean DeleteByIDs(Collection<Integer> integers) {
        return null;
    }

    @Override
    public Hotel_Reservation save(Hotel_Reservation E) {
        return null;
    }
}
