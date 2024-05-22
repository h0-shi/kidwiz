package com.kidwiz.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kidwiz.web.DAO.RegDAO;
import com.kidwiz.web.DTO.MemberDTO;
import com.kidwiz.web.DTO.RegDTO;
import com.kidwiz.web.DTO.ResultDTO;

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

	public List<Map<String, Object>> timetable() {
		return regDAO.timetable();
	}

	public int regTotalCount() {
		return regDAO.regTotalCount();
	}
	
	public List<RegDTO> regResult(String regno){
		return regDAO.regResult(regno);
	}

	public List<MemberDTO> memberDetail(String id) {
		return regDAO.memberDetail(id);
	}

	public int resultWrite(ResultDTO result) {
		return regDAO.resultWrite(result);
	}

	public List<RegDTO> getRegResult(String regno) {
		return regDAO.getRegResult(regno);
	}

	public int oneTimeRegInsert(RegDTO test) {
		return regDAO.oneTimeRegInsert(test);
	}

	public int resultUpdate(ResultDTO result) {
		return regDAO.resultUpdate(result);
	}

	public String getMajor(int id) {
		return regDAO.getMajor(id);
	}

	public List<Map<String, Object>> regRev(Map<String, Object> pageMap) {
		return regDAO.regRev(pageMap);
	}

	public Map<String, Object> getRegInfo(String regno) {
		return regDAO.getRegInfo(regno);
	}

}
