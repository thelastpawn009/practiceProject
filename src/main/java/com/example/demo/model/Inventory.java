package com.example.demo.model;


import lombok.*;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Inventory {
    int id;
    List<Product> products;
}
