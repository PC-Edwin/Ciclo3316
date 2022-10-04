package com.example.practica.reto3.model;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    
    // category to partyroom
    @OneToMany(mappedBy = "category") //mapear class category
    @JsonIgnoreProperties({"category"}) //ignorar obj definido en la class Partyroom -->(ManyToOne)
    private List<Partyroom> partyrooms; //obj class Partyroom --> "partyrooms" == nombre: "xxxxx" (vinculo)

    public List<Partyroom> getPartyrooms() {
        return partyrooms;
    }
    public void setPartyrooms(List<Partyroom> partyrooms) {
        this.partyrooms = partyrooms;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
