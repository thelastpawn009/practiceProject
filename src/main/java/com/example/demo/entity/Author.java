package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Entity - Parent in One-to-Many relationship
 * One Author can have many Books
 */
@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String email;
    
    private String country;
    
    // One-to-Many relationship with Book
    // CascadeType.ALL means when we save/delete an author, books are also saved/deleted
    // orphanRemoval = true means when a book is removed from the list, it's deleted from DB
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference  // Prevents infinite recursion in JSON serialization
    private List<Book> books = new ArrayList<>();
    
    // Helper method to add a book
    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }
    
    // Helper method to remove a book
    public void removeBook(Book book) {
        books.remove(book);
        book.setAuthor(null);
    }
}

