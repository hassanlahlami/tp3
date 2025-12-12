package com.testic.tp3;

import com.testic.tp3.model.entity.Book;
import com.testic.tp3.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)

public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    void testSaveAndFind() {
        Book book = new Book();
        book.setTitle("Spring Boot");
        book.setAuthor("Author 1");
        book.setGenre("Programming");

        repository.save(book);

        List<Book> books = repository.findAll();
        assertEquals(1, books.size());
        assertEquals("Spring Boot", books.get(0).getTitle());
    }

    @Test
    void testDeleteBook() {
        Book book = new Book();
        book.setTitle("Java 101");
        repository.save(book);
        repository.deleteById(book.getId());
        assertTrue(repository.findAll().isEmpty());
    }
}
