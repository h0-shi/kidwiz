package com.kidwiz.web.Entity;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "notice_board")
@Comment("공지사항 게시판 토글형식")
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nno")
	@Comment("notice no")
	private Long nno;

	@Comment("notice 글 제목")
	private String ntitle;

	@Comment("notice 글 내용")
	private String ncontent;

}
