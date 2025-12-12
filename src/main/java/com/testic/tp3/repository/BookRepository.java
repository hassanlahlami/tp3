package com.testic.tp3.repository;

import com.testic.tp3.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
