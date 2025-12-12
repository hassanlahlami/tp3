package com.testic.tp3;

import com.testic.tp3.model.entity.Book;
import com.testic.tp3.model.entity.Loan;
import com.testic.tp3.model.entity.Member;
import com.testic.tp3.repository.BookRepository;
import com.testic.tp3.repository.LoanRepository;
import com.testic.tp3.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)

public class LoanRepositoryTest {

    @Autowired
    private LoanRepository repository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    void testSaveAndFindByMember() {
        Member member = new Member();

        member.setName("Alice");
        memberRepository.save(member);
        Book book = new Book();
        book.setTitle("Spring");
        bookRepository.save(book);
        Loan loan = new Loan();
        loan.setMember(member);
        loan.setBook(book);
        loan.setLoanDate(LocalDate.now());
        loan.setReturnDate(LocalDate.now().plusDays(7));

        repository.save(loan);

        List<Loan> loans = repository.findByMemberId(member.getId());
        assertEquals(1, loans.size());
    }
}
