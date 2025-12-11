package com.testic.tp3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testCreateBook() {
        Book book = new Book();
        book.setTitle("Test Title");
        book.setAuthor("Author");
        book.setGenre("Genre");

        Book saved = bookRepository.save(book);

        assertNotNull(saved.getId());
        assertEquals("Test Title", saved.getTitle());
    }
    @Test
    void testFindBookByTitle() {
        // Arrange
        Book book1 = new Book();
        book1.setTitle("Harry Potter");
        book1.setAuthor("J.K. Rowling");
        book1.setGenre("Fantasy");
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setTitle("The Hobbit");
        book2.setAuthor("J.R.R. Tolkien");
        book2.setGenre("Fantasy");
        bookRepository.save(book2);
        List<Book> books = bookRepository.findAll(); // on récupère tous les livres
        Optional<Book> found = books.stream()
                .filter(b -> b.getTitle().equals("Harry Potter"))
                .findFirst();

        // Assert
        assertFalse(!found.isPresent());
        assertEquals("J.K. Rowling", found.get().getAuthor());
    }
}