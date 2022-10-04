package com.example.practica.reto3.respository.crud;

import org.springframework.data.repository.CrudRepository;
import com.example.practica.reto3.model.Category;

public interface CategoryCrudRespositoryInterface extends CrudRepository<Category,Integer> {
    
}
