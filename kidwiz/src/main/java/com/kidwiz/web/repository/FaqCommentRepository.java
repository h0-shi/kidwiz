package com.kidwiz.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidwiz.web.DTO.FaqComment;

public interface FaqCommentRepository extends JpaRepository<FaqComment, Long>{


	List<FaqComment> findByFaqQuestionId(Long questionId);

}
