package com.example.ecommerce.application.Repository;

import com.example.ecommerce.application.Model.Category;
import com.example.ecommerce.application.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "SELECT u FROM Category u WHERE u.id = :id")
    Category getCategoryById(int id);

//    @Query(value = "SELECT u FROM Product u WHERE u.key = :value")
//    Category getCategoryByField(T key, T value);
}
