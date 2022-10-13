package com.example.practica.reto3.service;

import java.util.List;
import java.util.Optional;

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

    public Client actualizarClient(Client client) {
        if(client.getIdClient()!=null){
            Optional<Client> e= clientRepository.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getEmail()!=null){
                    e.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }

                clientRepository.salvarclient(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        } 
    }

    public boolean borrarClient(int idClient) {
        boolean flag=false;
        Optional<Client> c= clientRepository.getClient(idClient);
        if(c.isPresent()){
            clientRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
}
