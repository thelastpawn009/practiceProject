package com.example.demo.service;

import com.example.demo.model.Inventory;
import com.example.demo.model.Product;

import java.util.List;

public interface InventoryService {

    Product addProduct(Product product) throws Exception;
    Product removeProduct(Integer inventoryId, Integer productId, Integer quantity);
    List<Inventory> getAllInventory();
    Inventory addInventory (Inventory inventory);
}
