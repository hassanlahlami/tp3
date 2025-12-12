package com.testic.tp3;

import com.testic.tp3.model.entity.Member;
import com.testic.tp3.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)

public class MemberRepositoryTest {

    @Autowired
    private MemberRepository repository;

    @Test
    void testSaveAndFind() {
        Member member = new Member();
        member.setName("Alice");
        member.setAddress("123 Street");
        member.setPhoneNumber("123456789");

        repository.save(member);

        List<Member> members = repository.findAll();
        assertEquals(1, members.size());
        assertEquals("Alice", members.get(0).getName());
    }
}
