package com.testic.tp3.repository;

import com.testic.tp3.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
