package com.example.ecommerce.application.Services;


import com.example.ecommerce.application.Model.User;
import com.example.ecommerce.application.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User userSignUp(User user){
        return userRepo.save(user);
    }

    public boolean userExists(User user){
        int userId = user.getId();
        return userRepo.existsById(userId);
    }

//    public String userLogin(User user){
//
//    }
}
