package com.example.demo.service.impl;

import com.example.demo.model.Inventory;
import com.example.demo.model.Product;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;



    @Override
    public Product addProduct(Product product) throws Exception {
        Integer inventoryId = product.getInventoryId();
        if(Objects.isNull(inventoryId)) {
            throw new Exception("Inventory id cannot be null");
        }
        synchronized (this) {
            Optional<Inventory> inventory = inventoryRepository.getById(inventoryId);
            if(!inventory.isPresent()) {
                throw new Exception("Inventory id not found");
            }

            List<Product> products = inventory.get().getProducts();
            Optional<Product> optionalProduct = products.stream().filter(product1 -> product1.getId() == product.getId()).findFirst();
            if(optionalProduct.isPresent()){
                optionalProduct.get().setQuantity(optionalProduct.get().getQuantity()+product.getQuantity());
            }
            else {
                products.add(product);
            }
            inventoryRepository.save(inventory.get());
            Optional<Product> optionalProductAdded = products.stream().filter(product1 -> product1.getId() == product.getId()).findFirst();
            return optionalProductAdded.get() ;
        }
    }

    @Override
    public Product removeProduct(Integer inventoryId, Integer productId, Integer quantity) {
        synchronized (this) {
            Optional<Inventory> optionalInventory = inventoryRepository.getById(inventoryId);
            if (!optionalInventory.isPresent()) {
                log.error("No inventory id : {} exist", inventoryId);
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No inventory with id: " + inventoryId);
            }
            List<Product> products = optionalInventory.get().getProducts();
            if (products == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventory " + inventoryId + " has no products");
            }
            Optional<Product> optionalProduct = products.stream()
                    .filter(product -> product.getId() == productId)
                    .findFirst();
            if (optionalProduct.isEmpty()) {
                log.error("No product id : {} exist in inventory {}", productId, inventoryId);
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "No product with id " + productId + " in inventory " + inventoryId);
            }
            int available = optionalProduct.get().getQuantity();
            if (available < quantity) {
                log.info(
                        "Insufficient stock: inventory={}, product={}, requested={}, available={}",
                        inventoryId,
                        productId,
                        quantity,
                        available);
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"ldjfldjfd");
            }
            Integer existingQuantity = optionalProduct.get().getQuantity();
            optionalProduct.get().setQuantity(existingQuantity - quantity);
            inventoryRepository.save(optionalInventory.get());
            return optionalProduct.get();
        }
    }
    public List<Inventory> getAllInventory() {
        return inventoryRepository.getAllInventory();
    }

    @Override
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.addInventory(inventory);
    }
}
