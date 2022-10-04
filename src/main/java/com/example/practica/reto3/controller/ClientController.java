package com.example.practica.reto3.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica.reto3.model.Client;
import com.example.practica.reto3.service.ClientService;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin (origins ="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ClientController {
    @Autowired /*Instancia un objeto*/
    private ClientService clientService;

    @GetMapping("/all") /*define un metodo GET*/
    public List<Client>obtenerClientCompleto(){
        return clientService.obtenerClientCompleto();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)/*devuele valor 201*/
    public Client salvarClient(@RequestBody Client  client){
        return clientService.salvarclient(client);
    }
}
