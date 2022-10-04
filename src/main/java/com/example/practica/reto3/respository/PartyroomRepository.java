package com.example.practica.reto3.respository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.practica.reto3.model.Partyroom;
import com.example.practica.reto3.respository.crud.PartyroomCrudRepositoryInterface;


@Repository
public class PartyroomRepository {
    @Autowired
    private PartyroomCrudRepositoryInterface partyroomCrudRepositoryInterface;

    public List<Partyroom> obtenerPartyroomCompleta() {
        return (List<Partyroom>) partyroomCrudRepositoryInterface.findAll();
    }

    public Partyroom salvarPartyroom(Partyroom partyroom) {
        return partyroomCrudRepositoryInterface.save(partyroom);
    }
}
