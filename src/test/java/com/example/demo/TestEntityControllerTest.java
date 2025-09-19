package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;

/**
 * Integration tests for TestEntityController
 */
@SpringBootTest
public class TestEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;


}
