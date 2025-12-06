package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthorService {
    
    private final AuthorRepository authorRepository;
    
    // CREATE
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }
    
    // READ - Get all authors
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
    
    // READ - Get author by ID
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
    }
    
    // READ - Get author by email
    public Author getAuthorByEmail(String email) {
        return authorRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Author not found with email: " + email));
    }
    
    // READ - Get authors by country
    public List<Author> getAuthorsByCountry(String country) {
        return authorRepository.findByCountry(country);
    }
    
    // READ - Search authors by name
    public List<Author> searchAuthorsByName(String name) {
        return authorRepository.findByNameContainingIgnoreCase(name);
    }
    
    // UPDATE
    public Author updateAuthor(Long id, Author authorDetails) {
        Author author = getAuthorById(id);
        author.setName(authorDetails.getName());
        author.setEmail(authorDetails.getEmail());
        author.setCountry(authorDetails.getCountry());
        return authorRepository.save(author);
    }
    
    // DELETE
    public void deleteAuthor(Long id) {
        Author author = getAuthorById(id);
        authorRepository.delete(author);
    }
    
    // Get author with all books
    public Author getAuthorWithBooks(Long id) {
        Author author = getAuthorById(id);
        // Trigger lazy loading of books
        author.getBooks().size();
        return author;
    }
}

