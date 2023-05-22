package com.example.javabootcamphw15.Controller;

import com.example.javabootcamphw15.ApiResponse.ApiResponse;
import com.example.javabootcamphw15.Model.Product;
import com.example.javabootcamphw15.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    //get

    @GetMapping("/get")
    public ResponseEntity getProduct(){
        ArrayList<Product> products= productService.getProducts();
         return ResponseEntity.status(200).body(products);
    }

    // add

    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product, Errors errors){

        if ((errors.hasErrors())){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        productService.addProduct(product);
        return ResponseEntity.status(200).body("product added");
    }

    // update

    @PostMapping("/update/{id}")
    public ResponseEntity updateProduct(@Valid @RequestBody Product product, Errors errors, @PathVariable int id){

        if ((errors.hasErrors())){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        boolean isUpdated = productService.updateProduct(id,product);

        if (isUpdated){
            return ResponseEntity.status(200).body("product updated");
        }
        return ResponseEntity.status(400).body("Wrong id");

    }

    //delete

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id ){

        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted){
            return ResponseEntity.status(200).body("Deleted product");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }


}
