package com.example.javabootcamphw15.Service;


import com.example.javabootcamphw15.Model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant> merchants=new ArrayList<>();

    public ArrayList<Merchant> getMerchants() {
        return merchants;
    }


    //dd

    public void addMerchant(Merchant merchant){
        merchants.add(merchant);
    }

    //update
    public boolean updateMerchant(int id , Merchant merchant){
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId()==id){
                merchants.set(i,merchant);
                return true;
            }
        }
        return false;
    }
    //delete
    public boolean deleteMerchant(int id ){

        for (int i = 0; i <merchants.size() ; i++) {
            if (merchants.get(i).getId()==id){
                merchants.remove(i);
                return true;
            }
        }
        return false;
    }

}
