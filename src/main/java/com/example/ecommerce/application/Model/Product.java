package com.example.ecommerce.application.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ecommerce_product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private int price;

    @Column(name = "product_description")
    private String description;

}
