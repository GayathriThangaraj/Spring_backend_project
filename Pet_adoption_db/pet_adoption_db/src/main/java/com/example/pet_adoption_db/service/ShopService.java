package com.example.pet_adoption_db.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pet_adoption_db.model.Shop;
import com.example.pet_adoption_db.repository.ShopRepo;

@Service
public class ShopService {
    @Autowired
    ShopRepo sr;

    public Shop create(Shop s)
    {
        return sr.save(s);
    }
    public List<Shop> getall()
    {
        return sr.findAll();
    }
    public Shop getShopById(String name) 
    {
        return sr.findById(name).orElse(null);
    }
    public boolean update(String name,Shop s)
    {
        if(this.getShopById(name)==null)
        {
            return false;
        }
        try{
            sr.save(s);
        }
        catch(Exception e)
        {
            return false;
        }
        return  true;
    }
    public boolean delete(String name)
    {
        if(this.getShopById(name)==null)
        {
            return false;
        }
        sr.deleteById(name);
        return true;
    }
    
    
}

