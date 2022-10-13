package com.example.practica.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica.reto3.model.Message;
import com.example.practica.reto3.respository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> obtenerMessage() {
        return messageRepository.obtenerMessage();
    }

    public Message salvarMessage(Message message) {
        if (message.getIdMessage()==null){
            return messageRepository.salvarMessage(message);
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
        return message;
    }

    public Message actualizarMessage(Message message) {
        if(message.getIdMessage()!=null){
            Optional<Message> e= messageRepository.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                messageRepository.salvarMessage(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean borrarMessage(int idMessage) {
        boolean flag=false;
        Optional<Message> c= messageRepository.getMessage(idMessage);
        if(c.isPresent()){
            messageRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
}
