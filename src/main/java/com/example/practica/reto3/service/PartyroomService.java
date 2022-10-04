package com.example.practica.reto3.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.practica.reto3.model.Partyroom;
import com.example.practica.reto3.respository.PartyroomRepository;

@Service
public class PartyroomService {
    @Autowired
    private PartyroomRepository partyroomRepository;

    public List<Partyroom> obtenerPartyroomCompleta() {
        return partyroomRepository.obtenerPartyroomCompleta();
    }

    public Partyroom salvarPartyroom(Partyroom partyroom) {
        if (partyroom.getId()==null){
            return partyroomRepository.salvarPartyroom(partyroom);
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
        return partyroom;
    }
}
