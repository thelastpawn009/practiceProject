package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProductRepository {
    public final Map<Integer, Product> productStore = new HashMap<>();


    public Optional<Product> getById(int productId){
        return Optional.ofNullable(productStore.get(productId));
    }
}
