package com.example.ecommerce.application.Controllers;


import com.example.ecommerce.application.Model.User;
import com.example.ecommerce.application.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins ="*",allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<User> save(@RequestBody User newUser) {
        try {
            //Check if password1 == password2(confirm password), registers successfully only if both equal
            String password = newUser.getPassword1();
            String confirmPassword = newUser.getPassword2();
            if(password.equals(confirmPassword)){
                User savedUser = userService.userSignUp(newUser);
                return ResponseEntity.ok(savedUser);
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        try {
            String loggedInUser = userService.userLogin(user.getName(), user.getPassword1());
            System.out.println(loggedInUser);
            if (loggedInUser != null) {
                return ResponseEntity.ok(loggedInUser);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
