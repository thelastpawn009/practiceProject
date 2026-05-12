package com.example.demo.model;

import enums.ProductType;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    int id;
    String name;
    ProductType productType;
    int quantity;
    Integer inventoryId;
}
