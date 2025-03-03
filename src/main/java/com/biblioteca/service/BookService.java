package com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.repository.BookRepository;
import com.example.biblioteca.model.Book;
@Service  // Indica que esta classe é um Service (Lógica de Negócio)
public class BookService {
   @Autowired
   private BookRepository bookRepository;
   // ✅ Buscar todos os livros
   public List<Book> getAllBooks() {
       return bookRepository.findAll();
   }
   // ✅ Buscar livro por ID
   public Optional<Book> getBookById(Long id) {
       return bookRepository.findById(id);
   }
   // ✅ Criar um novo livro
   public Book createBook(Book book) {
       return bookRepository.save(book);
   }
   // ✅ Atualizar um livro existente
   public Book updateBook(Long id, Book bookDetails) {
       Optional<Book> optionalBook = bookRepository.findById(id);
       if (optionalBook.isPresent()) {
           Book book = optionalBook.get();
           book.setTitle(bookDetails.getTitle());
           book.setAuthor(bookDetails.getAuthor());
           book.setPublicationYear(bookDetails.getPublicationYear());
           book.setPrice(bookDetails.getPrice());
           return bookRepository.save(book);
       }
       return null;
   }
   // ✅ Excluir um livro
   public boolean deleteBook(Long id) {
       if (bookRepository.existsById(id)) {
           bookRepository.deleteById(id);
           return true;
       }
       return false;
   }
}