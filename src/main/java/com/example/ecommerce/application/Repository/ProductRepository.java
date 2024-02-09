package com.example.ecommerce.application.Repository;

import com.example.ecommerce.application.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT u FROM Product u WHERE u.id = :id")
    Product getProductById(int id);
}
