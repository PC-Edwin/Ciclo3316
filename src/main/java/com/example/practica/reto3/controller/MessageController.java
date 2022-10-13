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

import com.example.practica.reto3.model.Message;
import com.example.practica.reto3.service.MessageService;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin (origins ="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> obtenerMessage(){
        return messageService.obtenerMessage();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)/*devuele valor 201*/
    public Message salvarMessage(@RequestBody Message  message){
        return messageService.salvarMessage(message);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message actualizarMessage(@RequestBody Message message){
        return messageService.actualizarMessage(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrarMessage(@PathVariable("id") int idMessage){
        return messageService.borrarMessage(idMessage);
    }
}
