package com.dum.OnlineBookstore.service;

import com.dum.OnlineBookstore.model.Category;
import com.dum.OnlineBookstore.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    public final CategoryRepo categoryRepo;

    //POST
    public Category saveCategory(Category category){
        return categoryRepo.save(category);
    }
    //PUT
    public Category updateCategory(Category category){
        return categoryRepo.save(category);
    }

    //DELETE
    public void deleteCategory(Long id){
        categoryRepo.deleteById(id);
    }

    //GET




}
