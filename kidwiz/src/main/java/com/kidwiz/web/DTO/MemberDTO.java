package com.kidwiz.web.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String name, major_name, major_head, gender, contact;
	private int id, grade;
	private LocalDate birth_date;

}
