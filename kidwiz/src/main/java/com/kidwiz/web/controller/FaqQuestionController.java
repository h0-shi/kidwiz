package com.kidwiz.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<FaqQuestion> getQuestionById(@PathVariable(name = "id") Long fid) {
	    FaqQuestion question = faqQuestionService.getQuestionById(fid);
	    if (question != null) {
	        return ResponseEntity.ok(question);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}


    @PostMapping
    public ResponseEntity<String> saveQuestion(@RequestBody FaqQuestion question) {
        try {
            faqQuestionService.saveQuestion(question);
            return ResponseEntity.ok("FAQ 글이 성공적으로 저장되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("질문 저장 중 오류가 발생했습니다.");
        }
    }
	
    @PutMapping("/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable(name = "id") Long id, @RequestBody FaqQuestion updatedQuestion) {
        try {
            faqQuestionService.updateQuestion(id, updatedQuestion);
            return ResponseEntity.ok("FAQ 글이 성공적으로 수정되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("질문 수정 중 오류가 발생했습니다.");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable(name = "id") Long id) {
        try {
            faqQuestionService.deleteQuestion(id);
            return ResponseEntity.ok("FAQ 글이 성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("질문 삭제 중 오류가 발생했습니다.");
        }
    }
    
    
    @GetMapping("/paged")
    public ResponseEntity<Map<String, Object>> getQuestionPaged(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {

        try {
            Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
            Page<FaqQuestion> questionPage = faqQuestionService.getQuestionsPaged(pageable);

            List<FaqQuestion> content = questionPage.getContent();
            System.out.println(content);
            System.out.println(questionPage);

            // 전체 글 개수를 기반으로 역순 번호 계산
            long totalElements = questionPage.getTotalElements();
            for (int i = 0; i < content.size(); i++) {
                content.get(i).setNumber(totalElements - (page * size) - i);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("questions", content);
            response.put("totalElements", totalElements);
            response.put("currentPage", page);
            response.put("hasMore", questionPage.hasNext());

            System.out.println("response 오는지 확인: " +response);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            System.err.println(" 에러 paged questions: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
