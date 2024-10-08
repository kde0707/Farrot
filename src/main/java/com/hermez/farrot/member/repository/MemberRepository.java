package com.hermez.farrot.member.repository;

import com.hermez.farrot.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByEmail(String email);
    Optional<Member> findById(Integer id);
    Optional<Member> findByNickname(String nickname);
}
