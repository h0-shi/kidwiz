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

	public int regSubmit(RegDTO application) {
		return regDAO.regSubmit(application);
	}

	public int regTotalCount() {
		return regDAO.regTotalCount();
	}
	
	public List<RegDTO> regResult(String regno){
		return regDAO.regResult(regno);
	}

	public List<MemberDTO> memberDetail(String stuNum) {
		return regDAO.memberDetail(stuNum);
	}

	public int resultWrite(ResultDTO result) {
		return regDAO.resultWrite(result);
	}

	public List<RegDTO> getRegResult(String regno) {
		return regDAO.getRegResult(regno);
	}

}
