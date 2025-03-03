package com.example.biblioteca.model;
import java.time.LocalDate;

import com.example.biblioteca.model.enums.LoanStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

@Table(name = "loans")

public class Loan {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne

    @JoinColumn(name = "book_id", nullable = false)

    private Book book; // Relacionamento com livro emprestado

    @Column(nullable = false)

    private String client; // Nome do cliente que realizou o empréstimo

    @Column(nullable = false)

    private LocalDate loanDate; // Data do empréstimo

    @Column(nullable = false)

    private LocalDate returnDate; // Data prevista para devolução

    private LocalDate actualReturnDate; // Data real de devolução

    @Enumerated(EnumType.STRING)

    @Column(nullable = false)

    private LoanStatus status; // Status do empréstimo
    
    // ✅ Construtor vazio
    public Loan() {}
    // ✅ Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
 this.id = id;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }
    public LocalDate getLoanDate() {
        return loanDate;
    }
    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }
    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }
    public LoanStatus getStatus() {
        return status;
    }
    public void setStatus(LoanStatus status) {
        this.status = status;
    }

} 