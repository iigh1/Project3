package com.example.javabootcamphw15.Controller;

import com.example.javabootcamphw15.ApiResponse.ApiResponse;
import com.example.javabootcamphw15.Model.MerchantStock;
import com.example.javabootcamphw15.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/stock")
@RequiredArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;


    //get
    @GetMapping("/get")
    public ResponseEntity getMerchantStock(){
        ArrayList<MerchantStock>merchantStocks=new ArrayList<>();
        return ResponseEntity.status(200).body(merchantStocks);
    }

    //add
    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors){

        if (errors.hasErrors()){
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }
        merchantStockService.addItem(merchantStock);
        return ResponseEntity.status(200).body("added");
    }

    //update

    @PostMapping("/update")
    public ResponseEntity updateMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors, @PathVariable int id){
        if (errors.hasErrors()){
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }
        boolean isUpdated = merchantStockService.updateItem(id,merchantStock);
        if (isUpdated){
            return ResponseEntity.status(200).body("updated");
        }
        return ResponseEntity.status(400).body("Wrong id ");
    }

    //delete

    @DeleteMapping("/delete")
    public ResponseEntity deleteMerchantStock(@PathVariable int id ){

        boolean isDeleted = merchantStockService.deleteItem(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }

}
