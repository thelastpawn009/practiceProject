package com.example.demo.repository;

import com.example.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    
    // Custom query methods
    Optional<Author> findByEmail(String email);
    
    List<Author> findByCountry(String country);
    
    List<Author> findByNameContainingIgnoreCase(String name);
}

