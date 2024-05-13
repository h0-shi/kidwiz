package com.kidwiz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kidwiz.web.DTO.FaqQuestion;
import com.kidwiz.web.service.FaqQuestionService;

@RestController
@RequestMapping("/api/faqquestions")
public class FaqQuestionController {
	
	@Autowired
	private FaqQuestionService faqQuestionService;
	
	@GetMapping
	public List<FaqQuestion> getAllQuestions(){
		return faqQuestionService.getAllQuestions();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FaqQuestion> getQuestionById(@PathVariable(name = "id") Long id) {
	    FaqQuestion question = faqQuestionService.getQuestionById(id);
	    if (question != null) {
	        return ResponseEntity.ok(question);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

    
	@PostMapping
	public ResponseEntity<String> saveQuestion(@RequestBody FaqQuestion questionDTO) {
	    try {
	        FaqQuestion question = new FaqQuestion(questionDTO.getTitle(), questionDTO.getContent(), questionDTO.getWriter());
	        faqQuestionService.saveQuestion(question);
	        return ResponseEntity.ok("질문이 성공적으로 저장되었습니다.");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("질문 저장 중 오류가 발생했습니다.");
	    }
	}
	

}