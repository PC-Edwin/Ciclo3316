package com.example.practica.reto3.respository.crud;

import org.springframework.data.repository.CrudRepository;
import com.example.practica.reto3.model.Reservation;

public interface ReservationCrudRepositoryInterface extends CrudRepository<Reservation,Integer> {
    
}
