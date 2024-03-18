package com.example.ecommerce.application.Repository;

import com.example.ecommerce.application.Model.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {

    @Query("{id: \"?0\"}")
    Product getProductById(ObjectId id);
}
