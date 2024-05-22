package com.kidwiz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kidwiz.web.DAO.RsvBatisDAO;
import com.kidwiz.web.DTO.RsvDTO;

@Component
public class RsvBatisService {
	
	@Autowired
	private RsvBatisDAO rsvDAO;

	public List<RsvDTO> studentCoun(int id) {
		return rsvDAO.studentCoun(id);
	}

}
