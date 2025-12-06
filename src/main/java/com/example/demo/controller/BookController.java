package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Book CRUD operations
 */
@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    
    private final BookService bookService;
    
    // CREATE - POST /api/books?authorId=1
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestParam Long authorId, @RequestBody Book book) {
        Book createdBook = bookService.createBook(authorId, book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }
    
    // READ - GET /api/books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }
    
    // READ - GET /api/books/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }
    
    // READ - GET /api/books/author/{authorId}
    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable Long authorId) {
        List<Book> books = bookService.getBooksByAuthorId(authorId);
        return ResponseEntity.ok(books);
    }
    
    // READ - GET /api/books/isbn/{isbn}
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        Book book = bookService.getBookByIsbn(isbn);
        return ResponseEntity.ok(book);
    }
    
    // READ - GET /api/books/search?title=xyz
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooksByTitle(@RequestParam String title) {
        List<Book> books = bookService.searchBooksByTitle(title);
        return ResponseEntity.ok(books);
    }
    
    // READ - GET /api/books/price-less-than?price=50
    @GetMapping("/price-less-than")
    public ResponseEntity<List<Book>> getBooksByPriceLessThan(@RequestParam Double price) {
        List<Book> books = bookService.getBooksByPriceLessThan(price);
        return ResponseEntity.ok(books);
    }
    
    // UPDATE - PUT /api/books/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok(updatedBook);
    }
    
    // UPDATE - PUT /api/books/{id}/change-author?newAuthorId=2
    @PutMapping("/{id}/change-author")
    public ResponseEntity<Book> changeBookAuthor(@PathVariable Long id, @RequestParam Long newAuthorId) {
        Book updatedBook = bookService.changeBookAuthor(id, newAuthorId);
        return ResponseEntity.ok(updatedBook);
    }
    
    // DELETE - DELETE /api/books/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}

