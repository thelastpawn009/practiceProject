package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public Product addProduct(Product product) {
        synchronized (this){
            Product productById = inventoryRepository.getProductById(product.getId());
            if(Objects.isNull(productById)) {
                return inventoryRepository.saveProduct(product);
            }

            Integer initialQuantity = productById.getQuantity();
            productById.setQuantity(initialQuantity+ product.getQuantity());
            inventoryRepository.saveProduct(productById);

            return productById;
        }
    }

    @Override
    public Product removeProduct(Product product) {
        synchronized (this){
            Product productById = inventoryRepository.getProductById(product.getId());
            if(Objects.isNull(productById)) {
                throw new RuntimeException("product doesnt exist");
            }
            Integer initialQuantity = productById.getQuantity();
            if(initialQuantity < product.getQuantity()){
                throw new RuntimeException("Quantity to be removed higher than initial quantity");
            }
            productById.setQuantity(initialQuantity-product.getQuantity());
            return inventoryRepository.saveProduct(productById);
        }
    }
}
