package com.example.javabootcamphw15.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {

    @NotEmpty(message = "id cannot be empty")
    @Size(min=3, message = "id letters should at least 3 character")
    private int id;
    @NotEmpty(message = "name cannot be empty")
    @Size(min=3, max = 8, message = "name length should be at least 3 letters")
    private String name;
    @NotNull(message = "price cannot be empty")
    @Positive(message = "price should be positive")
    private int price;
    @NotNull(message = "categoryID cannot be empty")
    @Size(min=3 , message = "categoryID should be at least 3 character")
    private int categoryID;

}
