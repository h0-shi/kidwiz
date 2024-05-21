package com.kidwiz.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidwiz.web.DAO.AdminDAO;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	
	public List<Map<String, Object>> getMember() {
		// TODO Auto-generated method stub
		return adminDAO.getMember();
	}

	public int changeGrade(Map<String, Object> row) {
		// TODO Auto-generated method stub
		return adminDAO.changeGrade(row);
	}

}
