package com.testic.tp3.controller;

import com.testic.tp3.model.entity.Member;
import com.testic.tp3.service.MemberService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService service;

    public MemberController(MemberService service) { this.service = service; }

    @GetMapping
    public List<Member> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Member get(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Member create(@RequestBody Member member) { return service.save(member); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
