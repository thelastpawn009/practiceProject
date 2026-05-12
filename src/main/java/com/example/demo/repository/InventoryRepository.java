package com.example.demo.repository;

import com.example.demo.model.Inventory;
import com.example.demo.model.Product;
import com.example.demo.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Slf4j
public class InventoryRepository {
    private final Map<Integer, Inventory> inventoryStore  = new HashMap<>();

    public Optional<Inventory> getById(int inventoryId) {
        return Optional.ofNullable(inventoryStore.get(inventoryId));
    }
    public void save(Inventory inventory) {
        inventoryStore.put(inventory.getId(), inventory);
    }
    public Inventory addInventory(Inventory inventory) {
        log.info("Inventory to be added : {} ", inventory);
        inventoryStore.put(inventory.getId(),inventory);
        return inventory;
    }
   public List<Inventory> getAllInventory(){
        List<Inventory> allInventory = new ArrayList<>();
        allInventory.addAll(inventoryStore.values());
        return allInventory;
   }
}
