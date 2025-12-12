package com.testic.tp3.service;

import com.testic.tp3.model.entity.Loan;
import com.testic.tp3.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    private final LoanRepository repository;

    public LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    public Loan save(Loan loan) {
        return repository.save(loan);
    }

    public List<Loan> findAll() {
        return repository.findAll();
    }

    public List<Loan> findByMemberId(Long memberId) {
        return repository.findByMemberId(memberId);
    }

    public List<Loan> findByBookId(Long bookId) {
        return repository.findByBookId(bookId);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}