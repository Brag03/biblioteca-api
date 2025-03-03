package com.biblioteca.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.service.BookService;
import com.example.biblioteca.model.Book;

@RestController

@RequestMapping("/api/books")

public class BookController {

    @Autowired

    private BookService bookService;

    @GetMapping

    public List<Book> getAllBooks() {

        return bookService.getAllBooks();

    }

    @GetMapping("/{id}")

    public ResponseEntity<Book> getBookById(@PathVariable Long id) {

        Optional<Book> book = bookService.getBookById(id);

        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping

    public Book createBook(@RequestBody Book book) {

        return bookService.createBook(book);

    }

    @PutMapping("/{id}")

    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {

        Book updatedBook = bookService.updateBook(id, bookDetails);

        return updatedBook != null ? ResponseEntity.ok(updatedBook) : ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {

        return bookService.deleteBook(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

    }

} 