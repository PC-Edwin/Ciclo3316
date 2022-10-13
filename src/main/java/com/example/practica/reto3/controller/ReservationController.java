package com.example.practica.reto3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica.reto3.model.Reservation;
import com.example.practica.reto3.service.ReservationService;



@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin (origins ="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all") /*define un metodo GET*/
    public List<Reservation> obtenerReservationCompleto(){
        return reservationService.obtenerReservationCompleto();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)/*devuele valor 201*/
    public Reservation salvarReservation(@RequestBody Reservation reservation){
        return reservationService.salvarReservation(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation actualizarCategory(@RequestBody Reservation reservation){
        return reservationService.actualizarReservation(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrarReservation(@PathVariable("id") int idReservation){
        return reservationService.borrarReservation(idReservation);
    }
    
}
