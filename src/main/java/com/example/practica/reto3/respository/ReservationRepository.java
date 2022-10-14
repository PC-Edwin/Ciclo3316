package com.example.practica.reto3.respository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public Reservation salvarReservation(Reservation reservation) {
        return reservationCrudRepositoryInterface.save(reservation);
    }

    public Optional<Reservation> getReservation(int idReservation){
        return reservationCrudRepositoryInterface.findById(idReservation);
    }

    public void delete(Reservation reservation) {
        reservationCrudRepositoryInterface.delete(reservation);
    }

    public List<Reservation> ReservacionStatus(String status){
        return reservationCrudRepositoryInterface.findAllByStatus(status);
    }

    public List<Reservation> ReservacionTiempo(Date fechaInicial, Date fechaFinal){
        return reservationCrudRepositoryInterface.findAllByStartDateAfterAndStartDateBefore(fechaInicial, fechaFinal);
    }
       
    public   List<Object[]> reporteClientes() {
        return reservationCrudRepositoryInterface.reporteClientes();

    }
}
