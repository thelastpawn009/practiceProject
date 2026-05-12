package com.example.demo.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    int id;
    String name;
    List<Product> productList;
    LocalDateTime orderDate;

}
