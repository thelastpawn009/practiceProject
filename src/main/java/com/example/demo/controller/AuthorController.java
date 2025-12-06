package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Author CRUD operations
 */
@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    
    private final AuthorService authorService;
    
    // CREATE - POST /api/authors
    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author createdAuthor = authorService.createAuthor(author);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }
    
    // READ - GET /api/authors
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }
    
    // READ - GET /api/authors/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Author author = authorService.getAuthorById(id);
        return ResponseEntity.ok(author);
    }
    
    // READ - GET /api/authors/{id}/with-books
    @GetMapping("/{id}/with-books")
    public ResponseEntity<Author> getAuthorWithBooks(@PathVariable Long id) {
        Author author = authorService.getAuthorWithBooks(id);
        return ResponseEntity.ok(author);
    }
    
    // READ - GET /api/authors/email/{email}
    @GetMapping("/email/{email}")
    public ResponseEntity<Author> getAuthorByEmail(@PathVariable String email) {
        Author author = authorService.getAuthorByEmail(email);
        return ResponseEntity.ok(author);
    }
    
    // READ - GET /api/authors/country/{country}
    @GetMapping("/country/{country}")
    public ResponseEntity<List<Author>> getAuthorsByCountry(@PathVariable String country) {
        List<Author> authors = authorService.getAuthorsByCountry(country);
        return ResponseEntity.ok(authors);
    }
    
    // READ - GET /api/authors/search?name=xyz
    @GetMapping("/search")
    public ResponseEntity<List<Author>> searchAuthorsByName(@RequestParam String name) {
        List<Author> authors = authorService.searchAuthorsByName(name);
        return ResponseEntity.ok(authors);
    }
    
    // UPDATE - PUT /api/authors/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        Author updatedAuthor = authorService.updateAuthor(id, author);
        return ResponseEntity.ok(updatedAuthor);
    }
    
    // DELETE - DELETE /api/authors/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}

