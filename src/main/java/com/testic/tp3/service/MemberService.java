package com.testic.tp3.service;

import com.testic.tp3.model.entity.Member;
import com.testic.tp3.repository.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member save(Member member) {
        return repository.save(member);
    }

    public List<Member> findAll() {
        return repository.findAll();
    }

    public Member findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
