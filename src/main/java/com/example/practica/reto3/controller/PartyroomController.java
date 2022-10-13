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

import com.example.practica.reto3.model.Partyroom;
import com.example.practica.reto3.service.PartyroomService;

@RestController
@RequestMapping("/api/Partyroom")
@CrossOrigin (origins ="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class PartyroomController {
    @Autowired /*Instancia un objeto*/
    private PartyroomService partyroomService;

    @GetMapping("/all") /*define un metodo GET*/
    public List<Partyroom> obtenerPartyroomCompleta(){
        return partyroomService.obtenerPartyroomCompleta();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)/*devuele valor 201*/
    public Partyroom salvarPartyroom(@RequestBody Partyroom partyroom){
        return partyroomService.salvarPartyroom(partyroom);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom actualizarPartyroom(@RequestBody Partyroom partyroom){
        return partyroomService.actualizarPartyroom(partyroom);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrarPartyroom(@PathVariable("id") int id){
        return partyroomService.borrarPartyroom(id);
    }
}
