package com.example.ecommerce.application.Repository;

import com.example.ecommerce.application.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //SELECT * FROM ecommerce_user
    //WHERE user_name = :userName;

    @Query(value = "SELECT u FROM User u WHERE u.name = :userName")
    User getUserByUsername(String userName);
}