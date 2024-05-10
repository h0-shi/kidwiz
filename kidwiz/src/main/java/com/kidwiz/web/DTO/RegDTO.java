package com.kidwiz.web.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegDTO {
	
 private String name, major, teacher, reg_no, time;
 private int age, stuNum;
 private LocalDate date;
}
