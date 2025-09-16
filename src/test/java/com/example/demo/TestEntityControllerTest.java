package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureTestMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Integration tests for TestEntityController
 */
@SpringBootTest
@AutoConfigureTestMvc
public class TestEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSaveAndFindAllTestEntities() throws Exception {
        // Create a test entity
        TestEntity testEntity = new TestEntity("testuser", "test@example.com", "password123");

        // Test saving the entity
        mockMvc.perform(MockMvcRequestBuilders.post("/api/test-entities")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testEntity)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("testuser"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("test@example.com"))
                .andDo(print());

        // Test finding all entities
        mockMvc.perform(MockMvcRequestBuilders.get("/api/test-entities"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andDo(print());
    }

    @Test
    public void testGetAllTestEntitiesWhenEmpty() throws Exception {
        // Test finding all entities when none exist
        mockMvc.perform(MockMvcRequestBuilders.get("/api/test-entities"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(print());
    }
}
