package com.example.ecommerce.application.Controllers;

import com.example.ecommerce.application.Model.Product;
import com.example.ecommerce.application.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @PostMapping("/add-product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        try {
            if (productService.productExistsById(id)) {
                productService.deleteById(id);
                return ResponseEntity.ok()
                        .body("{\"message\":\"Successfully deleted product\",\"id\":\"" + id + "\"}");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"message\":\"No product found with \",\"id\":\"" + id + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\"Error occurred while deleting product\"}");
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestBody Product product){
        try {
            if(productService.productExistsById(id)){
                productService.updateProductById(id, product);
                return ResponseEntity.ok()
                        .body("{\"message\":\"Successfully updated product\",\"id\":\"" + id + "\"}");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"message\":\"No product found with \",\"id\":\"" + id + "\"}");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\"Error occurred while updating product\"}");
        }
    }
}
