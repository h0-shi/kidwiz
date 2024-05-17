package com.kidwiz.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kidwiz.web.Entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	Member findByEmailAndPassword(String email, String password);
	
	Member findById(int memberId);
}
