package com.example.ecommerce.application.Services;

import com.example.ecommerce.application.Model.Product;
import com.example.ecommerce.application.Repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository prodRepo;

    public Product saveProduct(Product product){
        return prodRepo.save(product);
    }

    public List<Product> getAllProducts(){
        return prodRepo.findAll();
    }

    public boolean productExistsById(ObjectId id){
        return prodRepo.existsById(id);
    }

    public void deleteById(ObjectId id){
        prodRepo.deleteById(id);
    }

    public void updateProductById(ObjectId id, Product updateProductData){
        Product existingProduct = prodRepo.getProductById(id);

        String updateProductName = updateProductData.getName();
        if(updateProductName != null){
            existingProduct.setName(updateProductName);
        }

        Integer updateProductPrice = updateProductData.getPrice();
        if(updateProductPrice!=null){
            existingProduct.setPrice(updateProductPrice);
        }

        String updateProductDescription = updateProductData.getDescription();
        if(updateProductDescription!=null){
            existingProduct.setDescription(updateProductDescription);
        }

        prodRepo.save(existingProduct);
    }
}
