package com.example.ecommerce.application.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ecommerce_user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_password1")
    private String password1;


    @Column(name = "user_password2")
    private String password2;

    @Column(name = "user_email")
    private String email;
}
