package com.example.practica.reto3.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.practica.reto3.model.Message;
import com.example.practica.reto3.respository.crud.MessageCrudRespositoryInterface;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRespositoryInterface messageCrudRespositoryInterface;

    public List<Message> obtenerMessage() {
        return (List<Message>) messageCrudRespositoryInterface.findAll();
    }

    public Message salvarMessage(Message message) {
        return messageCrudRespositoryInterface.save(message);
    }

    public Optional<Message> getMessage(int idMessage){
        return messageCrudRespositoryInterface.findById(idMessage);
    }

    public void delete(Message message) {
        messageCrudRespositoryInterface.delete(message);
    }
    
}
