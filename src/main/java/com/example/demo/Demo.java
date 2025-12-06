package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Praveen J U
 * @Date 04/12/25
 */
@Entity
@Table(name = "demo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Demo {
    @GeneratedValue
    @Id
    Integer id;

    private String name;
}
