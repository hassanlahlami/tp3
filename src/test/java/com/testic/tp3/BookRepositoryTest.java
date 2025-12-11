package com.testic.tp3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

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
}