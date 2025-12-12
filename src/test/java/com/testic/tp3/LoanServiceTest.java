package com.testic.tp3;

import com.testic.tp3.model.entity.Loan;
import com.testic.tp3.repository.LoanRepository;
import com.testic.tp3.service.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoanServiceTest {

    private LoanRepository repository;
    private LoanService service;

    @BeforeEach
    void setup() {
        repository = mock(LoanRepository.class);
        service = new LoanService(repository);
    }

    @Test
    void testFindByBookId() {
        Loan loan = new Loan();
        loan.setId(1L);
        when(repository.findByBookId(1L)).thenReturn(List.of(loan));

        List<Loan> loans = service.findByBookId(1L);
        assertEquals(1, loans.size());
    }

    @Test
    void testSaveLoan() {
        Loan loan = new Loan();
        loan.setLoanDate(LocalDate.now());
        when(repository.save(loan)).thenReturn(loan);

        Loan saved = service.save(loan);
        assertNotNull(saved.getLoanDate());
    }
}
