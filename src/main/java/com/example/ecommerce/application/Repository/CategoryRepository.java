package com.example.ecommerce.application.Repository;

import com.example.ecommerce.application.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
