package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    Integer id;
    Integer quantity;
    String name;
}
