package com.kidwiz.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kidwiz.web.DAO.RegDAO;

@Component
public class RegService {

	@Autowired
	private RegDAO regDAO;
	
	public int accept(String no) {
		return regDAO.accept(no);
	}

}
