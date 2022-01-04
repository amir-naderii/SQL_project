package ir.ac.kntu.Repository;

import ir.ac.kntu.Model.Flight_Reservation;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class Flight_ReservationDao implements Repository<Flight_Reservation,Integer>{

    @Override
    public Flight_Reservation findById(Integer integer) {
        return null;
    }

    @Override
    public List<Flight_Reservation> findByIDs(Collection<Integer> integers) {
        return null;
    }

    @Override
    public List<Flight_Reservation> findAll() {
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
    public Flight_Reservation save(Flight_Reservation E) {
        return null;
    }
}
