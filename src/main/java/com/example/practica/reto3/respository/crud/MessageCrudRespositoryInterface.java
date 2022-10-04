package com.example.practica.reto3.respository.crud;

import org.springframework.data.repository.CrudRepository;

import com.example.practica.reto3.model.Message;

public interface MessageCrudRespositoryInterface extends CrudRepository<Message, Integer> {
    
}
