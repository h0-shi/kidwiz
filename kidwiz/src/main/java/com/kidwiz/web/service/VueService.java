package com.kidwiz.web.service;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidwiz.web.DAO.VueDAO;
import com.kidwiz.web.DTO.TestDTO;

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

	public int testInsert(TestDTO dto) {
		return vueDAO.testInsert(dto);
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

	public List<Map<String, Object>> getGroupList() {
		// TODO Auto-generated method stub
		return vueDAO.getGroupList();
	}

	public Map<String, Object> groupDetail(String gr_no) {
		// TODO Auto-generated method stub
		return vueDAO.groupDetail(gr_no);
	}

	public List<Map<String, Object>> getGList(String con_cd) {
		// TODO Auto-generated method stub
		return vueDAO.getGList(con_cd);
	}

}
