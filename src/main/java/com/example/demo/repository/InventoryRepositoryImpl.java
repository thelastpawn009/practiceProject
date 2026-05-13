package com.example.demo.repository;

import com.example.demo.model.Inventory;
import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InventoryRepositoryImpl implements InventoryRepository {

    private final ConcurrentHashMap<Integer, Product> inventoryMap = new ConcurrentHashMap<>();


    @Override
    public Product getProductById(Integer productId) {
        Product product = inventoryMap.get(productId);
        if(Objects.isNull(product)){
            return null;
        }
        return product;
    }

    @Override
    public Product saveProduct(Product product) {
        inventoryMap.put(product.getId(), product);
        return product;
    }
}
