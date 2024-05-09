package com.kidwiz.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidwiz.web.DAO.RegDAO;
import com.kidwiz.web.DAO.VueDAO;
import com.kidwiz.web.DTO.RegDTO;

@Service
public class VueService {

	@Autowired
	private VueDAO vueDAO;
	
	@Autowired
	private RegDAO regDAO;
	
	public List<Map<String, Object>> list() {
		return vueDAO.boardList();
	}

	public List<Map<String, Object>> getBoard() {
		return vueDAO.getBoard();
	}

	public int regconInsert(RegDTO dto) {
		return regDAO.regconInsert(dto);
	}
	
	public int boardWrite(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return vueDAO.boardWrite(map);
	}

	public Map<String, Object> boardDetail(String bno) {
		// TODO Auto-generated method stub
		return vueDAO.boardDetail(bno);
	}

	public int boardDel(String bno) {
		// TODO Auto-generated method stub
		return vueDAO.boardDel(bno);
	}

	public int boardUpdate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return vueDAO.boardUpdate(map);
	}

	public int boardReply(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return vueDAO.boardReply(map);
	}

	public Map<String, Object> getPath(String bno) {
		// TODO Auto-generated method stub
		return vueDAO.getPath(bno);
	}

}
