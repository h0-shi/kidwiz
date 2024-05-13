package com.kidwiz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidwiz.web.DTO.FaqQuestion;
import com.kidwiz.web.repository.FaqQuestionRepository;

@Service
public class FaqQuestionService {

	@Autowired
	private FaqQuestionRepository faqQuestionRepository;
	
	public List<FaqQuestion> getAllQuestions(){
		return faqQuestionRepository.findAll();
	}
	
	public FaqQuestion getQuestionById(Long fid) {
		return faqQuestionRepository.findById(fid).orElse(null);
	}

	public void saveQuestion(FaqQuestion questionDTO) {
		faqQuestionRepository.save(questionDTO);
	}
}
