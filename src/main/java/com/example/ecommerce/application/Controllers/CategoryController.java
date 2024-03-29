package com.example.ecommerce.application.Controllers;

import com.example.ecommerce.application.Model.Category;
import com.example.ecommerce.application.Model.Product;
import com.example.ecommerce.application.Services.CategoryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin(origins ="*",allowedHeaders = "*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> category = categoryService.getAllCategory();
        return ResponseEntity.ok().body(category);
    }

    @PostMapping("/add-category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable ObjectId id) {
        try {
            if (categoryService.categoryExistsById(id)) {
                categoryService.deleteById(id);
                return ResponseEntity.ok()
                        .body("{\"message\":\"Successfully deleted category\",\"id\":\"" + id + "\"}");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"message\":\"No category found with \",\"id\":\"" + id + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\"Error occurred while deleting category\"}");
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable ObjectId id,@RequestBody Category category){
        try {
            if(categoryService.categoryExistsById(id)){
                categoryService.updateCategoryById(id, category);
                return ResponseEntity.ok()
                        .body("{\"message\":\"Successfully updated category\",\"id\":\"" + id + "\"}");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"message\":\"No category found with \",\"id\":\"" + id + "\"}");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\"Error occurred while updating category\"}");
        }
    }
    @PostMapping("/products-with-category/{id}")
    public ResponseEntity<String> linkProductWithCategory(@PathVariable ObjectId id,@RequestBody List<Product> products){
        try {
            if(categoryService.categoryExistsById(id)){
                categoryService.linkCategoryWithProduct(id, products);
                return ResponseEntity.ok()
                        .body("{\"message\":\"Successfully updated category\",\"id\":\"" + id + "\"}");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"message\":\"No category found with \",\"id\":\"" + id + "\"}");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\"Error occurred while updating category\"}");
        }
    }

//    @PostMapping("/getByField")
//    public ResponseEntity<String> getCategoryByField(@RequestBody String key, String value){
//        try{
//            List<Category> resultCategory = categoryService.findCategoryByField(key,value);
//            return ResponseEntity.ok().body(resultCategory.toString());
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("{\"message\":\"Error occurred while deleting category\"}");
//        }
//    }
}
