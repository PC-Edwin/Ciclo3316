package com.example.practica.reto3.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.practica.reto3.model.Category;
import com.example.practica.reto3.respository.crud.CategoryCrudRespositoryInterface;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRespositoryInterface categoryCrudRespositoryInterface;

    public List<Category> obtenerCategoryCompleto() {
        return (List<Category>) categoryCrudRespositoryInterface.findAll();
    }

    public Category salvarCategory(Category category) {
        return categoryCrudRespositoryInterface.save(category);
    }

    public Optional<Category> getCategory(int id){
        return categoryCrudRespositoryInterface.findById(id);
    }

    public void delete(Category category) {
        categoryCrudRespositoryInterface.delete(category);
    }


}
