package com.kidwiz.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidwiz.web.DTO.TestAnswer;
import com.kidwiz.web.DTO.TestQuestion;


public interface TestRepository extends JpaRepository<TestAnswer, Long> {

	void save(TestQuestion testQuestion);


}
