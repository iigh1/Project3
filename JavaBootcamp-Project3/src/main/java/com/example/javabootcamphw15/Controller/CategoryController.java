package com.example.javabootcamphw15.Controller;

import com.example.javabootcamphw15.ApiResponse.ApiResponse;
import com.example.javabootcamphw15.Model.Category;
import com.example.javabootcamphw15.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    //get

    @GetMapping("/get")
    public ResponseEntity getCategory(){

        ArrayList<Category>categories=categoryService.getCategories();
        return ResponseEntity.status(200).body(categories);
    }

    //add

    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category category, Errors errors){

        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }
        categoryService.addCategories(category);
        return ResponseEntity.status(200).body("category added");
    }

    //update

    @PutMapping("/update")
    public ResponseEntity updateCategory(@Valid @RequestBody Category category, Errors errors,@PathVariable int id ){

        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }
        boolean isUpdated = categoryService.updateCategories(id,category);

        if (isUpdated){
            return ResponseEntity.status(200).body("category updated");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }

    //delete

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable int id ){

        boolean isDeleted = categoryService.deleteCategories(id);

        if (isDeleted){
            return ResponseEntity.status(200).body("category deleted");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }

}
