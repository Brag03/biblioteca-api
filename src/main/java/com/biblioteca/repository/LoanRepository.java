package com.biblioteca.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.biblioteca.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> { } 
