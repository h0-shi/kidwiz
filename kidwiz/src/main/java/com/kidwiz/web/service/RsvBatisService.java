package com.kidwiz.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kidwiz.web.DAO.RsvBatisDAO;
import com.kidwiz.web.DTO.RsvDTO;

@Component
public class RsvBatisService {
	
	@Autowired
	private RsvBatisDAO rsvDAO;

	public List<Map<String, Object>> studentCoun(int id) {
		return rsvDAO.studentCoun(id);
	}

}
