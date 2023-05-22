package com.example.javabootcamphw15.Service;

import com.example.javabootcamphw15.Model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {

    ArrayList<Category>categories=new ArrayList<>();

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void addCategories(Category category){
        categories.add(category);
    }

    public boolean updateCategories(int id , Category category){
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId()==id){
                categories.set(i,category);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCategories(int id){
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId()==id){
                categories.remove(i);
                return true;
            }
        }
        return false;
    }
}
