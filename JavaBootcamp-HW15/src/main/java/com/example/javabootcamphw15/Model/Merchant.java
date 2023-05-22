package com.example.javabootcamphw15.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Merchant {

    @NotNull(message = "id cannot be empty")
    @Size(min=3 ,message = "id length should be 3")
    private int id;
    @NotEmpty(message = "name cannot be empty")
    @Size(min=3, message = "name length should be 3")
    private String name;
}
