package com.kidwiz.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidwiz.web.DTO.TestResult;
import com.kidwiz.web.Entity.Member;
import com.kidwiz.web.repository.MemberRepository;
import com.kidwiz.web.repository.TestResultRepository;

@Service
public class MemberService {

	@Autowired
	private TestResultRepository testResultRepository;
	
    @Autowired
    private MemberRepository memberRepository;
    
    // 가장 최근의 테스트 결과를 반환하는 메서드로 수정
    public TestResult getUserTestResult(int memberId) {
        return testResultRepository.findFirstByMemberIdOrderByTdateDesc(memberId);
    }

    public Member getUserById(int memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }
}