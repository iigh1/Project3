package com.example.javabootcamphw15.Service;


import com.example.javabootcamphw15.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    ArrayList<User> users=new ArrayList<User>();

    //get

    public ArrayList<User> getUser() {
        return users;
    }

    //add

    public void addUser(User user){
        users.add(user);
    }

    //update

    public boolean updateUser(int id, User user){
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).getId()==id){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }

    //delete

    public  boolean deleteUser(int id){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId()==id){
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean search(int id, double price){
        for(int i = 0 ; i<users.size();i++)
            if(users.get(i).getId() == id){

    }
        if(users.get(id).getBalance() >= price) {
            users.get(id).setBalance(users.get(id).getBalance() - price);
        return true;
    }
        return false;
}
}
