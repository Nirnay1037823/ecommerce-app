package com.example.ecommerce.application.Repository;

import com.example.ecommerce.application.Model.Category;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, ObjectId> {
    @Query("{id: \"?0\"}")
    Category getCategoryById(ObjectId id);

//    @Query(value = "SELECT u FROM Category u WHERE u.key = :value")
//    List<Category> getCategoryByField(String key, String value);
}
