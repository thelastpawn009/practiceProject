package com.example.demo.controller;

import com.example.demo.model.Inventory;
import com.example.demo.service.InventoryService;
import com.example.demo.model.Product;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@Slf4j
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add-product")
    public Product addProduct (@RequestBody Product product) throws Exception {
        return inventoryService.addProduct(product);
    }
    @PostMapping("/add-inventory")
    public Inventory addInventory (@RequestBody Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }

    @DeleteMapping("/remove-product")

    public Product removeProduct(
            @RequestParam @NonNull Integer inventoryId,
            @RequestParam @NonNull Integer productId,
            @RequestParam @NonNull Integer quantity) {
        log.info("removeProduct inventoryId={} productId={} quantity={}", inventoryId, productId, quantity);
        return inventoryService.removeProduct(inventoryId, productId, quantity);
    }

    @GetMapping("/all-inventory")
    public List<Inventory> getAllInventory(){
        return inventoryService.getAllInventory();
    }

}
