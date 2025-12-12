package com.testic.tp3.controller;

import com.testic.tp3.model.entity.Book;
import com.testic.tp3.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService service;
    public BookController(BookService service) { this.service = service; }

    @GetMapping
    public List<Book> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Book get(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Book create(@RequestBody Book book) { return service.save(book); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
