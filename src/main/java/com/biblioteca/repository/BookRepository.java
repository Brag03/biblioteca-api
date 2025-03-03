package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.biblioteca.model.Book;
public interface BookRepository extends JpaRepository<Book, Long> {
}
