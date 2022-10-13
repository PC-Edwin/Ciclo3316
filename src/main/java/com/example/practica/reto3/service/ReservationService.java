package com.example.practica.reto3.service;

import java.util.List;
import java.util.Optional;

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
            return reservationRepository.salvarReservation(reservation);
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

    public Reservation actualizarReservation(Reservation reservation) {
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= reservationRepository.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){
                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                if(reservation.getScore()!=null){
                    e.get().setScore(reservation.getScore());
                }
                reservationRepository.salvarReservation(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean borrarReservation(int idReservation) {
        boolean flag=false;
        Optional<Reservation> c= reservationRepository.getReservation(idReservation);
        if(c.isPresent()){
            reservationRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
}
