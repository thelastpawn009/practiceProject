package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.impl.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping("/add-product")
    Product addProduct(@RequestBody Product product) {
       return inventoryService.addProduct(product);
    }

    @PostMapping("/remove-product")
    Product removeProduct(@RequestBody Product product) {
        return inventoryService.removeProduct(product);
    }

}
