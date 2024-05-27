package com.kidwiz.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kidwiz.web.DAO.RegDAO;
import com.kidwiz.web.DTO.CardDTO;
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

	public List<RegDTO> regReservations(String date) {
		return regDAO.regReservations(date);
	}

	public Map<String, Object> getCounselorInfo(String id) {
		return regDAO.getCounselorInfo(id);
	}

	public Map<String, Object> getProInfo(String type) {
		return regDAO.getProInfo(type);
	}

	public List<RegDTO> checkRegRev(String date) {
		return regDAO.checkRegRev(date);
	}

	public List<RegDTO> rsvs(Map<String, Object> map) {
		return regDAO.rsvs(map);
	}

	public List<RegDTO> getScehdule(Map<String, Object> map) {
		return regDAO.getScehdule(map);
	}

	public List<Map<String, Object>> recentBoard(String id) {
		return regDAO.recentBoard(id);
	}

	public List<Map<String, Object>> need2Write(String id) {
		return regDAO.need2Write(id);
	}

	public int cardsWrite(List<CardDTO> cards) {
		return regDAO.cardWrite(cards);
	}

	public List<CardDTO> getCardNews() {
		return regDAO.getCardNews();
	}

	public List<CardDTO> cardDetail(String uuid) {
		return regDAO.cardDetail(uuid);
	}

}
