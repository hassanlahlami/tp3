package com.testic.tp3;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
