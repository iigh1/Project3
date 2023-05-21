package com.example.javabootcamphw15.Controller;

import com.example.javabootcamphw15.ApiResponse.ApiResponse;
import com.example.javabootcamphw15.Model.User;
import com.example.javabootcamphw15.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //get
    @GetMapping("/get")
    public ResponseEntity getUser(){
        ArrayList<User> users= userService.getUser();
        return ResponseEntity.status(200).body(users);
    }

    //add

    @PutMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){

        if(errors.hasErrors()){
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }
        userService.addUser(user);
        return ResponseEntity.status(400).body("user added");
    }

    //update

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody User user , Errors errors, @PathVariable int id ){
        if ((errors.hasErrors())){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        boolean isUpdated = userService.updateUser(id,user);
        if (isUpdated){
            return ResponseEntity.status(200).body("user added");
        }
        return ResponseEntity.status(400).body("Wrong id ");
    }

    //delete

    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@PathVariable int id ){

        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted){
            return ResponseEntity.status(200).body("user deleted");
        }
        return ResponseEntity.status(400).body("wrong id");
    }




}
