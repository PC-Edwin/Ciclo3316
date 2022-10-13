package com.example.practica.reto3.service;

import java.util.List;
import java.util.Optional;

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

    public Partyroom actualizarPartyroom(Partyroom partyroom) {
        if(partyroom.getId()!=null){
            Optional<Partyroom> e= partyroomRepository.getPartyroom(partyroom.getId());
            if(!e.isEmpty()){
                if(partyroom.getName()!=null){
                    e.get().setName(partyroom.getName());
                }
                if(partyroom.getOwner()!=null){
                    e.get().setOwner(partyroom.getOwner());
                }
                if(partyroom.getCapacity()!=null){
                    e.get().setCapacity(partyroom.getCapacity());
                }
                if(partyroom.getDescription()!=null){
                    e.get().setDescription(partyroom.getDescription());
                }
                partyroomRepository.salvarPartyroom(e.get());
                return e.get();
            }else{
                return partyroom;
            }
        }else{
            return partyroom;
        }
    }

    public boolean borrarPartyroom(int id) {
        boolean flag=false;
        Optional<Partyroom> c= partyroomRepository.getPartyroom(id);
        if(c.isPresent()){
            partyroomRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
}
