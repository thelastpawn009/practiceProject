package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {
    
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    
    // CREATE - Create a book for an author
    public Book createBook(Long authorId, Book book) {
        Author author = authorService.getAuthorById(authorId);
        book.setAuthor(author);
        return bookRepository.save(book);
    }
    
    // READ - Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    // READ - Get book by ID
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }
    
    // READ - Get all books by author
    public List<Book> getBooksByAuthorId(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }
    
    // READ - Get book by ISBN
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new RuntimeException("Book not found with ISBN: " + isbn));
    }
    
    // READ - Search books by title
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
    
    // READ - Get books by price range
    public List<Book> getBooksByPriceLessThan(Double price) {
        return bookRepository.findByPriceLessThan(price);
    }
    
    // UPDATE
    public Book updateBook(Long id, Book bookDetails) {
        Book book = getBookById(id);
        book.setTitle(bookDetails.getTitle());
        book.setIsbn(bookDetails.getIsbn());
        book.setPrice(bookDetails.getPrice());
        book.setPublishedYear(bookDetails.getPublishedYear());
        return bookRepository.save(book);
    }
    
    // UPDATE - Change book's author
    public Book changeBookAuthor(Long bookId, Long newAuthorId) {
        Book book = getBookById(bookId);
        Author newAuthor = authorService.getAuthorById(newAuthorId);
        book.setAuthor(newAuthor);
        return bookRepository.save(book);
    }
    
    // DELETE
    public void deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }
}

