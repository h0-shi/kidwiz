package com.kidwiz.web.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "majors")
public class Major {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int majorId;

	@Column(length = 100)
	private String majorName;

	@Column(length = 100)
	private String majorHead;
	
}