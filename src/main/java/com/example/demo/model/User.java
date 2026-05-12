package com.example.demo.model;

import lombok.*;

import java.util.Map;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    int id;
    int name;
    Map<String, String> metaData;
}
