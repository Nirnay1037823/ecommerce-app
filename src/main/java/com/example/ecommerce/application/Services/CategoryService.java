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

    public void deleteById(int id){
        categoryRepo.deleteById(id);
    }

    public void updateCategoryById(int id, Category updateCategoryData){
        Category existingCategory = categoryRepo.getCategoryById(id);

        String updateCategoryDataName = updateCategoryData.getName();
        if(updateCategoryDataName != null){
            existingCategory.setName(updateCategoryDataName);
        }

        String updateCategoryDataDescription = updateCategoryData.getDescription();
        if(updateCategoryDataDescription!=null){
            existingCategory.setDescription(updateCategoryDataDescription);
        }

        List<Product> updateCategoryDataProductList = updateCategoryData.getProductList();
        if(!updateCategoryDataProductList.isEmpty()){
            existingCategory.setProductList(updateCategoryDataProductList);
        }

        categoryRepo.save(existingCategory);
    }

    public void linkCategoryWithProduct(int id, List<Product> newProducts){
        Category existingCategory = categoryRepo.getCategoryById(id);

        List<Product> existingCategoryProductList = existingCategory.getProductList();

        existingCategoryProductList.addAll(newProducts);

        existingCategory.setProductList(existingCategoryProductList);

        categoryRepo.save(existingCategory);
    }

    public List<Category> findCategoryByField(String key, String value){
        return categoryRepo.getCategoryByField(key,value);
    }
}
