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

import com.biblioteca.service.LoanService;
import com.example.biblioteca.model.Loan;

@RestController

@RequestMapping("/api/loans")

public class LoanController {

    @Autowired

    private LoanService loanService;

    // ✅ GET - Listar todos os empréstimos

    @GetMapping

    public List<Loan> getAllLoans() {

        return loanService.getAllLoans();

    }

    // ✅ GET - Buscar um empréstimo por ID

    @GetMapping("/{id}")

    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {

        Optional<Loan> loan = loanService.getLoanById(id);

        return loan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    // ✅ POST - Criar um novo empréstimo

    @PostMapping

    public Loan createLoan(@RequestBody Loan loan) {

        return loanService.createLoan(loan);

    }

    // ✅ PUT - Atualizar um empréstimo existente

    @PutMapping("/{id}")

    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody Loan loanDetails) {

        Loan updatedLoan = loanService.updateLoan(id, loanDetails);

        return updatedLoan != null ? ResponseEntity.ok(updatedLoan) : ResponseEntity.notFound().build();

    }

    // ✅ DELETE - Excluir um empréstimo pelo ID

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {

        return loanService.deleteLoan(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

    }

} 