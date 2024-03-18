package com.example.ecommerce.application.Repository;

import com.example.ecommerce.application.Model.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    //SELECT * FROM ecommerce_user
    //WHERE user_name = :userName;

    @Query("{name: \"?0\"}")
    User getUserByUsername(String userName);
}
