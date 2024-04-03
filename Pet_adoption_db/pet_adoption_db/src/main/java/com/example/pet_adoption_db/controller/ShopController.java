package com.example.pet_adoption_db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pet_adoption_db.model.Shop;
import com.example.pet_adoption_db.service.ShopService;

@RestController
public class ShopController {
    @Autowired
    ShopService ss;
    
    @PostMapping("/postshop")
    public ResponseEntity<Shop> add( @RequestBody Shop s)
    {
        Shop shops=ss.create(s);
        return new ResponseEntity<>(shops,HttpStatus.CREATED);
    }

    @GetMapping("/getshop")
    public ResponseEntity<java.util.List<Shop>> showLoginDate()
    {
        return new ResponseEntity<>(ss.getall(),HttpStatus.OK);
    }

    @PutMapping("/putshop/{name}")
    public ResponseEntity<Shop> putMethodName(@PathVariable("name") String name, @RequestBody Shop s) {
        if(ss.update(name,s) == true)
        {
            return new ResponseEntity<>(s,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/deleteshop/{name}")
    public ResponseEntity<Boolean> delete(@PathVariable("name") String name)
    {
        if(ss.delete(name) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
