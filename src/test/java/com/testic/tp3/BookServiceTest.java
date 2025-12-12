package com.testic.tp3;

import com.testic.tp3.model.entity.Book;
import com.testic.tp3.repository.BookRepository;
import com.testic.tp3.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    private BookRepository repository;
    private BookService service;

    @BeforeEach
    void setup() {
        repository = mock(BookRepository.class);
        service = new BookService(repository);
    }

    @Test
    void testFindAll() {
        Book book = new Book();
        book.setTitle("Mockito Guide");
        when(repository.findAll()).thenReturn(List.of(book));

        List<Book> books = service.findAll();
        assertEquals(1, books.size());
        assertEquals("Mockito Guide", books.get(0).getTitle());
    }

    @Test
    void testFindById() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Spring Boot");
        when(repository.findById(1L)).thenReturn(Optional.of(book));

        Book found = service.findById(1L);
        assertEquals("Spring Boot", found.getTitle());
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setTitle("JUnit 5");
        when(repository.save(book)).thenReturn(book);

        Book saved = service.save(book);
        assertEquals("JUnit 5", saved.getTitle());
    }
}
