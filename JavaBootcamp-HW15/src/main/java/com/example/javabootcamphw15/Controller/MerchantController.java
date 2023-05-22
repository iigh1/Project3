package com.example.javabootcamphw15.Controller;

import com.example.javabootcamphw15.ApiResponse.ApiResponse;
import com.example.javabootcamphw15.Model.Merchant;
import com.example.javabootcamphw15.Model.Product;
import com.example.javabootcamphw15.Service.MerchantService;
import com.example.javabootcamphw15.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;
    private final MerchantStockService merchantStockService;

    //get

    @GetMapping("/get")
    public ResponseEntity getMerchant(){
        ArrayList<Merchant>merchants=merchantService.getMerchants();
        return ResponseEntity.status(200).body(merchants);
    }
    //add

    @PostMapping("/add")
    public  ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant, Errors errors){
        if (errors.hasErrors()){
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("merchant added");
    }

    //update

    @PutMapping("/update{id}")
    public ResponseEntity updateMerchant(@Valid @RequestBody Merchant merchant, Errors errors, @PathVariable int id){
        if (errors.hasErrors()){
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }
        boolean isUpdated = merchantService.updateMerchant(id,merchant);

        if (isUpdated){
            return ResponseEntity.status(200).body("merchant added");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }

    //delete

    @DeleteMapping("/delete")
    public ResponseEntity deleteMerchant(@PathVariable int id){
        boolean isDeleted = merchantService.deleteMerchant(id);

        if (isDeleted){
            return ResponseEntity.status(200).body("merchant deleted");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }

    @PutMapping("/addStock")
    public ResponseEntity addProductToStock(@Valid @RequestBody Product product , Errors errors, @PathVariable int merchantId ,int productId,int stock){
        if (errors.hasErrors()){
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }

        boolean isAdded = merchantStockService.addProductToStock(merchantId,productId,stock);
        if (isAdded){
            return ResponseEntity.status(200).body("added");
        }
        return ResponseEntity.status(400).body("not added");

    }
}
