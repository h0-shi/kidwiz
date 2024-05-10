package com.kidwiz.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidwiz.web.DTO.FaqQuestion;

public interface FaqQuestionRepository extends JpaRepository<FaqQuestion, Long>{

	List<FaqQuestion> findAll();

}
