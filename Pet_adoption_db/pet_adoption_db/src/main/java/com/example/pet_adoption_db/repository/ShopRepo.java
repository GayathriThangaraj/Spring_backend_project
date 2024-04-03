package com.example.pet_adoption_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pet_adoption_db.model.Shop;

public interface ShopRepo extends JpaRepository<Shop,String>{

    
} 