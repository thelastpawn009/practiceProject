package com.example.demo.config;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Data Initializer - Loads sample data on application startup
 * This demonstrates the One-to-Many relationship between Author and Book
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {
    
    private final AuthorRepository authorRepository;
    
    @Override
    public void run(String... args) {
        log.info("🚀 Initializing sample data for One-to-Many relationship demo...");
        
        // Create Author 1: J.K. Rowling with books
        Author jkRowling = new Author();
        jkRowling.setName("J.K. Rowling");
        jkRowling.setEmail("jk.rowling@example.com");
        jkRowling.setCountry("UK");
        
        Book hp1 = new Book();
        hp1.setTitle("Harry Potter and the Philosopher's Stone");
        hp1.setIsbn("978-0439708180");
        hp1.setPrice(29.99);
        hp1.setPublishedYear(1997);
        
        Book hp2 = new Book();
        hp2.setTitle("Harry Potter and the Chamber of Secrets");
        hp2.setIsbn("978-0439064873");
        hp2.setPrice(32.99);
        hp2.setPublishedYear(1998);
        
        Book hp3 = new Book();
        hp3.setTitle("Harry Potter and the Prisoner of Azkaban");
        hp3.setIsbn("978-0439136365");
        hp3.setPrice(34.99);
        hp3.setPublishedYear(1999);
        
        jkRowling.addBook(hp1);
        jkRowling.addBook(hp2);
        jkRowling.addBook(hp3);
        
        authorRepository.save(jkRowling);
        log.info("✅ Created Author: {} with {} books", jkRowling.getName(), jkRowling.getBooks().size());
        
        // Create Author 2: George R.R. Martin with books
        Author grrMartin = new Author();
        grrMartin.setName("George R.R. Martin");
        grrMartin.setEmail("grrm@example.com");
        grrMartin.setCountry("USA");
        
        Book got1 = new Book();
        got1.setTitle("A Game of Thrones");
        got1.setIsbn("978-0553103540");
        got1.setPrice(39.99);
        got1.setPublishedYear(1996);
        
        Book got2 = new Book();
        got2.setTitle("A Clash of Kings");
        got2.setIsbn("978-0553108033");
        got2.setPrice(42.99);
        got2.setPublishedYear(1998);
        
        grrMartin.addBook(got1);
        grrMartin.addBook(got2);
        
        authorRepository.save(grrMartin);
        log.info("✅ Created Author: {} with {} books", grrMartin.getName(), grrMartin.getBooks().size());
        
        // Create Author 3: J.R.R. Tolkien with books
        Author jrrTolkien = new Author();
        jrrTolkien.setName("J.R.R. Tolkien");
        jrrTolkien.setEmail("jrr.tolkien@example.com");
        jrrTolkien.setCountry("UK");
        
        Book lotr1 = new Book();
        lotr1.setTitle("The Fellowship of the Ring");
        lotr1.setIsbn("978-0618346257");
        lotr1.setPrice(27.99);
        lotr1.setPublishedYear(1954);
        
        Book lotr2 = new Book();
        lotr2.setTitle("The Two Towers");
        lotr2.setIsbn("978-0618346264");
        lotr2.setPrice(28.99);
        lotr2.setPublishedYear(1954);
        
        Book hobbit = new Book();
        hobbit.setTitle("The Hobbit");
        hobbit.setIsbn("978-0618002214");
        hobbit.setPrice(24.99);
        hobbit.setPublishedYear(1937);
        
        jrrTolkien.addBook(lotr1);
        jrrTolkien.addBook(lotr2);
        jrrTolkien.addBook(hobbit);
        
        authorRepository.save(jrrTolkien);
        log.info("✅ Created Author: {} with {} books", jrrTolkien.getName(), jrrTolkien.getBooks().size());
        
        log.info("📚 Sample data initialized successfully!");
        log.info("📊 Total Authors: {}", authorRepository.count());
        log.info("🎯 You can now test the API endpoints at http://localhost:8888/api");
    }
}

