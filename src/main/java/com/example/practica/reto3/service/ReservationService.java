package com.example.practica.reto3.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica.reto3.model.Client;
import com.example.practica.reto3.model.Reservation;
import com.example.practica.reto3.reportes.ContadorClientes;
import com.example.practica.reto3.reportes.StatusReservas;
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


    public StatusReservas ReservacionStatus(){
       
        List<Reservation> completed = reservationRepository.ReservacionStatus("completed");
        List<Reservation> cancelled = reservationRepository.ReservacionStatus("cancelled");

        return new StatusReservas(completed.size(), cancelled.size());
    }

    public List<Reservation> ReservacionTiempo(String fechaInicial,String fechaFinal){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date fechaUno = new Date();
        Date fechaDos = new Date();

        try {
            fechaUno = parser.parse(fechaInicial);
            fechaDos = parser.parse(fechaFinal);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (fechaUno.before(fechaDos)) {
            return reservationRepository.ReservacionTiempo(fechaUno, fechaDos);
        } else {
            return new ArrayList<>();
        }
    }

  

    public List<ContadorClientes> reporteClientes() {        
        List<ContadorClientes> resultado = new ArrayList<>();
        List<Object[]> reporte = reservationRepository.reporteClientes();
        System.out.println(reporte);
        for (int i = 0; i < reporte.size(); i++) {
            resultado.add(new ContadorClientes((Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        return resultado;
    }
}
