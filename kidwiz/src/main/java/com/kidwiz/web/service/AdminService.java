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

	public List<Map<String, Object>> totalBoard() {
		// TODO Auto-generated method stub
		return adminDAO.totalBoard();
	}

	public int changeDb(Map<String, Object> row) {
		// TODO Auto-generated method stub
		if(row.get("pri_no").toString().length()>5) {
			if(row.get("pri_no").toString().substring(0,2).equals("gr")) {
				row.put("table_name", "group_consulting");
			} else if(row.get("pri_no").toString().substring(0,2).equals("bn")) {
				row.put("table_name", "board_consulting");
			}
		}else {
			row.put("table_name", "faq_question");
		}
		System.out.println(row);
		return adminDAO.changeDb(row);
	}

	public int admincheck(int id) {
		// TODO Auto-generated method stub
		return adminDAO.admincheck(id);
	}

}
