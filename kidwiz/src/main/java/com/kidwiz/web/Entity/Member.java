package com.kidwiz.web.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "members")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 100)
	private String email;

	// password 는 json 변환 시 제외
	@JsonIgnore
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 100)
    private String name;  
	
	@Column(length = 100)
    private int enteryear;
	
	@Column(length = 100)
    private int mno;
	
	@Column(length = 100)
    private int majorId;  
	
	@Column(length = 100)
    private String majorName;  
	
	@Column(length = 100)
    private String majorHead;  
	
	@Column
    private String dept;  
	
	@Column
    private String grade;
	
	@Column
    private String gender;
	
	@Column(length = 100)
    private String contact;
	
	@Column
	private LocalDate birthDate;
	
}