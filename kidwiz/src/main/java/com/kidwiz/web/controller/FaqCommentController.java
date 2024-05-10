package com.kidwiz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kidwiz.web.DTO.FaqComment;
import com.kidwiz.web.service.FaqCommentService;

@RestController
@RequestMapping("/api/comments")
public class FaqCommentController {
	
	@Autowired
	private FaqCommentService faqCommentService;
	
	@GetMapping("/{questionId}")
	public List<FaqComment> getAllCommentsByQuestionId(@PathVariable Long questionId){
		return faqCommentService.getAllCommentsByQuestionId(questionId);
	}
	
	@PostMapping
	public FaqComment addComment(@RequestBody FaqComment faqComment) {
		return faqCommentService.saveComment(faqComment);
	}
}
