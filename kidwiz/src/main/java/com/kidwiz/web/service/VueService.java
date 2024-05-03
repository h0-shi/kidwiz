package com.kidwiz.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidwiz.web.DAO.VueDAO;

@Service
public class VueService {

	@Autowired
	private VueDAO vueDAO;
	
	public List<Map<String, Object>> list() {
		return vueDAO.boardList();
	}

	public List<Map<String, Object>> getBoard() {
		return vueDAO.getBoard();
	}

	public int boardWrite(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return vueDAO.boardWrite(map);
	}

	public Map<String, Object> boardDetail(String bno) {
		// TODO Auto-generated method stub
		return vueDAO.boardDetail(bno);
	}

}
