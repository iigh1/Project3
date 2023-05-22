package com.example.javabootcamphw15.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Category {

    @NotNull(message = "id cannot be empty")
    @Size(min=3, message = "id should be at least 3")
    private int id;
    @NotEmpty(message = "name cannot be empty")
    @Size(min=3, message = "name letters should be at least 3")
    private String name;

}
