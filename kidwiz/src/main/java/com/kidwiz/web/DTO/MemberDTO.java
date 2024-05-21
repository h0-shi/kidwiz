package com.kidwiz.web.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String name, major_name, major_head,sex, ph, dept;
	private int id;
	private LocalDate birthDay;

}
