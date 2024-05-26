package com.kidwiz.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kidwiz.web.DTO.FaqQuestion;
import com.kidwiz.web.repository.FaqQuestionRepository;

@Service
public class FaqQuestionService {

    @Autowired
    private FaqQuestionRepository faqQuestionRepository;

    public List<FaqQuestion> getAllQuestions() {
        return faqQuestionRepository.findAll();
    }

    public FaqQuestion getQuestionById(Long questionId) { // 메서드 이름 변경
        return faqQuestionRepository.findById(questionId).orElse(null);
      }

    public void saveQuestion(FaqQuestion question) {
        faqQuestionRepository.save(question);
    }

    public void updateQuestion(Long id, FaqQuestion updatedQuestion) {
        Optional<FaqQuestion> optionalQuestion = faqQuestionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            FaqQuestion question = optionalQuestion.get();
            
         // 아래 라인 추가
            question.setId(updatedQuestion.getId());
            question.setTitle(updatedQuestion.getTitle());
            question.setContent(updatedQuestion.getContent());
            question.setWriter(updatedQuestion.getWriter());
            question.setDate(updatedQuestion.getDate());
            faqQuestionRepository.save(question);
        }
    }

    public void deleteQuestion(Long id) {
        faqQuestionRepository.deleteById(id);
    }
    
	public Page<FaqQuestion> getQuestionsPaged(Pageable pageable) {
		// findAll()이 아니라, faq_del이 0인 글만 조회
		return faqQuestionRepository.findByFaqdel(0, pageable); 
	}
}

