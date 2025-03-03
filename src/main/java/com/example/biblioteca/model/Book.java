package com.example.biblioteca.model;

import com.example.biblioteca.model.enums.BookStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(nullable = false)
   private String title;
   @Column(nullable = false)
   private String author;
   @Column(nullable = false)
   private int publicationYear;
   @Column(nullable = false)
   private int pages;
   @Column(nullable = false)
   private double price;
   @Enumerated(EnumType.STRING)
   @Column(nullable = false)
   private BookStatus status;
   
   public Long getId() {
       return id;
   }
   public void setId(Long id) {
this.id = id;
   }
   public String getTitle() {
       return title;
   }
   public void setTitle(String title) {
       this.title = title;
   }
   public String getAuthor() {
       return author;
   }
   public void setAuthor(String author) {
       this.author = author;
   }
   public int getPublicationYear() {
       return publicationYear;
   }
   public void setPublicationYear(int publicationYear) {
       this.publicationYear = publicationYear;
   }
   public int getPages() {
       return pages;
   }
   public void setPages(int pages) {
       this.pages = pages;
   }
   public double getPrice() {
       return price;
   }
   public void setPrice(double price) {
       this.price = price;
   }
   public BookStatus getStatus() {
       return status;
   }
   public void setStatus(BookStatus status) {
       this.status = status;
   }
}
