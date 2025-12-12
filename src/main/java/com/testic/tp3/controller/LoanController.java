package com.testic.tp3.controller;
import com.testic.tp3.model.entity.Loan;
import com.testic.tp3.service.LoanService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private final LoanService service;

    public LoanController(LoanService service) { this.service = service; }

    @GetMapping
    public List<Loan> all() { return service.findAll(); }

    @GetMapping("/member/{memberId}")
    public List<Loan> byMember(@PathVariable Long memberId) { return service.findByMemberId(memberId); }

    @GetMapping("/book/{bookId}")
    public List<Loan> byBook(@PathVariable Long bookId) { return service.findByBookId(bookId); }

    @PostMapping
    public Loan create(@RequestBody Loan loan) { return service.save(loan); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
