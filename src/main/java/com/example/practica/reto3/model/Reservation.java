package com.example.practica.reto3.model;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    
    private Date startDate; 
    private Date devolutionDate;
    private String status="created";

    // reservation to partyrom
    @ManyToOne
    @JoinColumn(name = "partyroom")
    @JsonIgnoreProperties({"reservations"})
    private Partyroom partyroom;

    // reservation to client
    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    
    private String score;
 
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Partyroom getPartyroom() {
        return partyroom;
    }


    public void setPartyroom(Partyroom partyroom) {
        this.partyroom = partyroom;
    }


    public Integer getIdReservation() {
        return idReservation;
    }


    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
  

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Date getStartDate() {
        return startDate;
    }

   
    public void setStartDate(String startDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date fechaConvertida=null;
        try {
            Date parsed =  (Date) dateFormat.parse(startDate);
            fechaConvertida = new java.sql.Date(parsed.getTime());
            this.startDate  =  fechaConvertida;
        } catch(Exception e) {
            System.out.println("Error occurred"+ e.getMessage());
        }       
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }


    public void setDevolutionDate(String devolutionDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date fechaConvertida=null;
        try {
            Date parsed =  (Date) dateFormat.parse(devolutionDate);
            fechaConvertida = new java.sql.Date(parsed.getTime());
            this.devolutionDate  =  fechaConvertida;
        } catch(Exception e) {
            System.out.println("Error occurred"+ e.getMessage());
        }  
    }
    
    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
