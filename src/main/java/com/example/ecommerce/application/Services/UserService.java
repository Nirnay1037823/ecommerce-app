package com.example.ecommerce.application.Services;


import com.example.ecommerce.application.Model.User;
import com.example.ecommerce.application.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepo;

    private TokenService tokenService;

    @Autowired
    public UserService(UserRepository userRepo, TokenService tokenService) {
        this.userRepo = userRepo;
        this.tokenService = tokenService;
    }

    public User userSignUp(User user){
        return userRepo.save(user);
    }


    public boolean userExistsByUsername(String userName){
        Optional<User> userExists = Optional.ofNullable(userRepo.getUserByUsername(userName));
        if(!userExists.isEmpty()){
            return true;
        }
        return false;
    }

    public String userLogin(String userName, String inputPassword){
        if(userExistsByUsername(userName)){
            User user = userRepo.getUserByUsername(userName);
            String userPass = user.getPassword1();
            if(userPass.equals(inputPassword)){
                return "{" +
                        "\"message\":"+"Successfully Logged in\",\n"+
                        "\"data\": "+user+",\n"+
                        "\"Email: " + user.getEmail() + "\n"+
                        "\"token: " + tokenService.createToken(user.getId()) +
                        "}";
            }
        }
        return "{" +
                "\"message\":"+"Authentication Failed\",\n"+
                "}";
    }
}
