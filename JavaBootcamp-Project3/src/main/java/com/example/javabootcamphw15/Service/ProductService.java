package com.example.javabootcamphw15.Service;

import com.example.javabootcamphw15.Model.Product;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class ProductService {

    ArrayList<Product> products = new ArrayList<Product>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);

    }

    public boolean updateProduct(int id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, product);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).getId() == id) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public int search(int id) {

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }

        }
        return -1;
    }

    public int getPrice(int id){
        return products.get(search(id)).getPrice();
    }

}
