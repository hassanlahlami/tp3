package com.testic.tp3;

import com.testic.tp3.model.entity.Member;
import com.testic.tp3.repository.MemberRepository;
import com.testic.tp3.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MemberServiceTest {

    private MemberRepository repository;
    private MemberService service;

    @BeforeEach
    void setup() {
        repository = mock(MemberRepository.class);
        service = new MemberService(repository);
    }

    @Test
    void testFindAll() {
        Member member = new Member();
        member.setName("Bob");
        when(repository.findAll()).thenReturn(List.of(member));

        List<Member> members = service.findAll();
        assertEquals(1, members.size());
        assertEquals("Bob", members.get(0).getName());
    }

    @Test
    void testFindById() {
        Member member = new Member();
        member.setId(1L);
        member.setName("Charlie");
        when(repository.findById(1L)).thenReturn(Optional.of(member));

        Member found = service.findById(1L);
        assertEquals("Charlie", found.getName());
    }
}
