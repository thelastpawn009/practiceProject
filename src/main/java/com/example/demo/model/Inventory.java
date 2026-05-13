package com.example.demo.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    Integer id;
    List<Product> products;
}
