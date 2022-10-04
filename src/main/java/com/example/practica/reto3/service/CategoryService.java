package com.example.practica.reto3.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica.reto3.model.Category;
import com.example.practica.reto3.respository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> obtenerCategoryCompleto() {
        return categoryRepository.obtenerCategoryCompleto();
    }

    public Category salvarCategory(Category category) {
        if (category.getId()==null){
            return categoryRepository.salvarCategory(category);
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
        return category;
    }
    
}
