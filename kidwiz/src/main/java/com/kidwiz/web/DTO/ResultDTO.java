package com.kidwiz.web.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ResultDTO {
	
	 private String name, major_name, teacher, reg_no, time, regno, memo, proName; 
	 private String content, goal, summary, homework, opinion, contact, gender, birth_date;
	 private int age, stuNum, proNum, times, totalTimes, sub_no;
	 private LocalDate date;

}