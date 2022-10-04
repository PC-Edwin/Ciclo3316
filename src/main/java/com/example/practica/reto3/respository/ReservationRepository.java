package com.example.practica.reto3.respository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.practica.reto3.model.Reservation;
import com.example.practica.reto3.respository.crud.ReservationCrudRepositoryInterface;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepositoryInterface reservationCrudRepositoryInterface;

    public List<Reservation> obtenerReservationCompleto() {
        return (List<Reservation>) reservationCrudRepositoryInterface.findAll();
    }

    public Reservation salvarPartyroom(Reservation reservation) {
        return reservationCrudRepositoryInterface.save(reservation);
    }
}
