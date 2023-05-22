package com.example.javabootcamphw15.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MerchantStock {

    @NotNull(message = "id cannot be empty")
    @Size(min=3, message = "id length should be 3 at least")
    private int id;
    @NotNull(message = "productId cannot be empty")
    @Size(min = 3, message = "productId length should be 3 at least")
    private int productId;
    @NotNull(message = "merchantId cannot be empty")
    @Size(min=3, message = "merchantId length should be 3 at least")
    private int merchantId;
    @NotNull(message = "stock cannot be empty")
    @Size(min=10, max=300, message = "stock should be have 10 to 300 items")
    private int stock;

}
