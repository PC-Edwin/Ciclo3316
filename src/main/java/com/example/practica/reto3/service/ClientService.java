package com.example.practica.reto3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica.reto3.model.Client;
import com.example.practica.reto3.respository.ClientRespository;


@Service
public class ClientService {
    @Autowired
    private ClientRespository clientRepository;

    public List<Client> obtenerClientCompleto() {
        return clientRepository.obtenerClientCompleto();
    }

    public Client salvarclient(Client client) {
        if (client.getIdClient()==null){
            return clientRepository.salvarclient(client);
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
        return client;
    }
}
