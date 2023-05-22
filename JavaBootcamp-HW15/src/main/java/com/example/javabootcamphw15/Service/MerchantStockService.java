package com.example.javabootcamphw15.Service;

import com.example.javabootcamphw15.Model.MerchantStock;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStocks=new ArrayList<>();


    //get

    public ArrayList<MerchantStock> getMerchantStocks() {
        return merchantStocks;
    }


    //add

    public void addItem(MerchantStock merchantStock){
        merchantStocks.add(merchantStock);
    }

    //update
    public boolean updateItem(int id , MerchantStock merchantStock){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId()==id){
                merchantStocks.set(i,merchantStock);
                return true;
            }

        }
        return false;
    }

    //delete

    public boolean deleteItem(int id){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId()==id){
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }

    //user add product to a merchantStock
    public boolean addProductToStock(int merchantId , int productId , int stock ){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getMerchantId()==merchantId && merchantStocks.contains(productId)){
                merchantStocks.get(merchantId).setStock(merchantStocks.get(merchantId).getStock() + 1);
                return true;

            }
        }
        return false;

    }

    public int search(int id) {
        for (int i = 0; i < merchantStocks.size(); i++)
            if (merchantStocks.get(i).getId() == id) {
                return i;

            }
        return 0;
    }

    public int searchStock(int productId, int merchantId){
        for(int i = 0 ; i<merchantStocks.size();i++)
            if(merchantStocks.get(i).getProductId()== productId && merchantStocks.get(i).getMerchantId()== merchantId )
                return i;
        return -1;
    }

    public void addStock(int id ){
        merchantStocks.get(id).setStock(merchantStocks.get(id).getStock() + 1);
    }

    public boolean minusStock(int id){
        if(merchantStocks.get(id).getStock() >= 0) {
            merchantStocks.get(id).setStock(merchantStocks.get(id).getStock() - 1);
            return true;
        }
        return false;

    }
}
