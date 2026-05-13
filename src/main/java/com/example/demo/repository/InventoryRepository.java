package com.example.demo.repository;

import com.example.demo.model.Inventory;
import com.example.demo.model.Product;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface InventoryRepository {
    Product getProductById (Integer productId);
    Product saveProduct(Product product);

}
//Inventory {
//    id,
//            List<Product>
//}
//
//Product {
//    id,
//            name
//    quantity,
//            inventoryId,
//}