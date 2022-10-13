package com.example.practica.reto3.service;
import java.util.List;
import java.util.Optional;

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

    public Category actualizarCategory(Category category) {
        if(category.getId()!=null){
            Optional<Category> e= categoryRepository.getCategory(category.getId());
            if(!e.isEmpty()){
                if(category.getDescription()!=null){
                    e.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    e.get().setName(category.getName());
                }
                categoryRepository.salvarCategory(e.get());
                return e.get();
            }else{
                return category;
            }
        }else{
            return category;
        }    
    }

    public boolean borrarCategory(int id) {
        boolean flag=false;
        Optional<Category> c= categoryRepository.getCategory(id);
        if(c.isPresent()){
            categoryRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
    
}
