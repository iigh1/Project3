package com.example.javabootcamphw15.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {

    @NotNull(message = "is cannot be null")
    @Size(min=3, message = "id should be 3 at least")
    private int id;
    @NotEmpty(message = "username cannot be empty")
    @Size(min = 5, max = 10, message = "username should be between 5 and 10")
    private String username;
    @NotNull(message = "password cannot be empty")
    @Size(min=6, max = 10, message = "password length should be between 6 and 10")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\\\d).{6,}$" ,message = "Password must have characters and digits.")
    private String password;
    @NotNull(message = "email cannot be empty")
    @Email(message = "must input a valid email")
    private String email;
    @NotEmpty(message = "role cannot be empty")
    @Pattern(regexp = "'admin '|'customer '", message = "Role must be either 'Admin' or 'Customer'.")
    private String role;
    @NotNull(message = "balance cannot be empty")
    @Positive
    private double balance;
}
