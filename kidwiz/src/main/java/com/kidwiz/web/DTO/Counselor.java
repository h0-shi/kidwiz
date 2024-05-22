package com.kidwiz.web.DTO;

import lombok.Data;

@Data
public class Counselor {
	
	private int id, experience;
	private String name, title, image, bio, expertise, certifications, email, greeting;

}
