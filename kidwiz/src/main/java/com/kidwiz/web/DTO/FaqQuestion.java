package com.kidwiz.web.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "faq_question")
public class FaqQuestion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="question_id")
    private Long id;
	
	@Column(name="writer")
	private String writer;
	
    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    
    public FaqQuestion(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
    
    public FaqQuestion() {
        // 기본 생성자
    }
    
    
}
