package com.kidwiz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidwiz.web.DTO.FaqComment;
import com.kidwiz.web.repository.FaqCommentRepository;

@Service
public class FaqCommentService {

	@Autowired
	private FaqCommentRepository faqCommentRepository;
	
    public List<FaqComment> getAllCommentsByQuestionId(Long questionId) {
        return faqCommentRepository.findByFaqQuestionId(questionId);
    }
	public FaqComment saveComment(FaqComment faqComment) {
		return faqCommentRepository.save(faqComment);
	}
}
