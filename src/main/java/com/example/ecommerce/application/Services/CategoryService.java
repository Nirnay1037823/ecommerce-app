package com.example.ecommerce.application.Services;

import com.example.ecommerce.application.Model.Category;
import com.example.ecommerce.application.Model.Product;
import com.example.ecommerce.application.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepo;

    public Category saveCategory(Category category){
        return categoryRepo.save(category);
    }

    public List<Category> getAllCategory(){
        return categoryRepo.findAll();
    }

    public boolean categoryExistsById(int id){
        return categoryRepo.existsById(id);
    }
}
