package com.kidwiz.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
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
	
	public List<Map<String, Object>> list(Map<String, Object> pageMap) {
		return vueDAO.boardList(pageMap);
	}

	public List<Map<String, Object>> getBoard(Map<String, Object> pageMap) {
		return vueDAO.getBoard(pageMap);
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

	public List<Map<String, Object>> getGroupList(Map<String, Object> pageMap) {
		// TODO Auto-generated method stub
		return vueDAO.getGroupList(pageMap);
	}

	public Map<String, Object> groupDetail(String gr_no) {
		// TODO Auto-generated method stub
		return vueDAO.groupDetail(gr_no);
	}

	public List<Map<String, Object>> getGList(String gr_no) {
		// TODO Auto-generated method stub
		return vueDAO.getGList(gr_no);
	}

	public String totalPage() {
		// TODO Auto-generated method stub
		return vueDAO.totalPage();
	}

	public int totalGPage() {
		// TODO Auto-generated method stub
		return vueDAO.totalGPage();
	}

	public Map<String, Object> getCoun(String id) {
		// TODO Auto-generated method stub
		return vueDAO.getCoun(id);
	}

	public void createGroup(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String[] day =((String) map.get("g_oper")).split(" ~ ");
		
//		System.out.println(day[0]+" / "+day[1]);
		Map<String, Object> dayMap = new HashMap<>();

		dayMap.put("startDay", day[0]);
		dayMap.put("endDay", day[1]);
		dayMap.put("day", map.get("g_day"));

		//System.out.println(map);
		
		List<Map<String, Object>> list = new ArrayList<>();
		list = vueDAO.getDay(dayMap);
		
		int i = 0;
		String up_gr_no="0";
		map.put("up_gr_no", up_gr_no);
		map.put("round", i);
		
		System.out.println(list);
		//System.out.println(map);
		
		for (Map<String, Object> map2 : list) {
			
			map.put("g_oper", map2.get("DT"));
			if(i == 0 ) {
				map.put("up_gr_no",map.get("gr_no"));
				vueDAO.createGroup(map);
				i++;
			} else{
				map.put("round", i);
				vueDAO.createGroup(map);
				i++;
			}
			
		}
	}

	public Map<String, Object> getMemberType(int id) {
		// TODO Auto-generated method stub
		return vueDAO.getMemberType(id);
	}

	public String getUpGrNo(String gr_no) {
		// TODO Auto-generated method stub
		return vueDAO.getUpGrNo(gr_no);
	}

	public void applyGroup(int id, String up_gr_no) {
		// TODO Auto-generated method stub
		
		List<String> list = vueDAO.getGrNo(up_gr_no);
		
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		for(String row : list) {
			map.put("up_gr_no", row);
			vueDAO.applyGroup(map);
		}
	}

	public int checkGroup(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return vueDAO.checkGroup(map);
	}

	public List<Map<String, Object>> getRsv(int id) {
		// TODO Auto-generated method stub
		return vueDAO.getRsv(id);
	}

}


























