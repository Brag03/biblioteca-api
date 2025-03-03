package com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.repository.LoanRepository;
import com.example.biblioteca.model.Loan;
@Service
public class LoanService {
   @Autowired
   private LoanRepository loanRepository;
   // ✅ Buscar todos os empréstimos
   public List<Loan> getAllLoans() {
       return loanRepository.findAll();
   }
   // ✅ Buscar um empréstimo pelo ID
   public Optional<Loan> getLoanById(Long id) {
       return loanRepository.findById(id);
   }
   // ✅ Criar um novo empréstimo
   public Loan createLoan(Loan loan) {
       return loanRepository.save(loan);
   }
   // ✅ Atualizar um empréstimo existente
   public Loan updateLoan(Long id, Loan loanDetails) {
       Optional<Loan> optionalLoan = loanRepository.findById(id);
       if (optionalLoan.isPresent()) {
           Loan loan = optionalLoan.get();
           loan.setClient(loanDetails.getClient());
           loan.setLoanDate(loanDetails.getLoanDate());
           loan.setReturnDate(loanDetails.getReturnDate());
           loan.setActualReturnDate(loanDetails.getActualReturnDate());
           loan.setStatus(loanDetails.getStatus());
           return loanRepository.save(loan);
       }
       return null;
   }
   // ✅ Excluir um empréstimo
   public boolean deleteLoan(Long id) {
       if (loanRepository.existsById(id)) {
           loanRepository.deleteById(id);
           return true;
       }
       return false;
   }
}