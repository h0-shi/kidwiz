package com.kidwiz.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kidwiz.web.Entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	Member findByIdAndPassword(int id, String password);
	
	Member findById(int memberId);
}
