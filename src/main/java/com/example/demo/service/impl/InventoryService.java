package com.example.demo.service.impl;

import com.example.demo.model.Product;


public interface InventoryService {
    Product addProduct(Product product);
    Product removeProduct(Product product);
}
