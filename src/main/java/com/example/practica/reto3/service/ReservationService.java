package com.example.practica.reto3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica.reto3.model.Reservation;
import com.example.practica.reto3.respository.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> obtenerReservationCompleto() {
        return reservationRepository.obtenerReservationCompleto();
    }

    public Reservation salvarReservation(Reservation reservation) {
        if (reservation.getIdReservation()==null){
            return reservationRepository.salvarPartyroom(reservation);
        }
        else{

        /* Optional <Papeleria> papeleriaAuxiliar = papeleriaRepository.obtenerPapeleriaId(papeleria.getId());
           if (papeleriaAuxiliar.isEmpty()){
                 return papeleriaRepository.salvarPapeleria(papeleria);
             }
             else{
                 return papeleria;
             }*/
         }
        return reservation;
    }
}
