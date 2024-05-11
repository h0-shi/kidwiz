package com.kidwiz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kidwiz.web.DAO.RegDAO;
import com.kidwiz.web.DTO.RegDTO;

@Component
public class RegService {

	@Autowired
	private RegDAO regDAO;
	
	public int accept(String no) {
		return regDAO.accept(no);
	}

	public List<RegDTO> regDetail(String rgno) {
		return regDAO.regDetail(rgno);
	}

}
