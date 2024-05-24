package com.kidwiz.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidwiz.web.DAO.RsvProDAO;

@Service
public class RsvProService {
	
	@Autowired
	private RsvProDAO rsvProDAO;

	public List<Map<String,Object>> getRsvsByProid(int proid) {
		return rsvProDAO.findRsvByProid(proid);
	}

	public Map<String, Object> getRsvInfoByRsvno(Integer rsvno) {
		return rsvProDAO.findRsvInfoByRsvno(rsvno);
	}

	public void saveProResultWrite(Integer rsvno, Map<String, Object> payload) {
		String goal = (String) payload.get("goal");
		String content = (String) payload.get("content");
		String summary = (String) payload.get("summary");
		String homework = (String) payload.get("homework");
		String opinion = (String) payload.get("opinion");

		rsvProDAO.saveProResultWrite(rsvno, goal, content, summary, homework, opinion);
	}

	public Map<String, Object> getProResultByRsvno(Integer rsvno) {
		return rsvProDAO.findProResultByRsvno(rsvno);
	}

	public void updateProResult(Integer rsvno, Map<String, Object> payload) {
		String goal = (String) payload.get("goal");
		String content = (String) payload.get("content");
		String summary = (String) payload.get("summary");
		String homework = (String) payload.get("homework");
		String opinion = (String) payload.get("opinion");
		
		rsvProDAO.updateProResult(rsvno, goal, content, summary, homework, opinion);
	}

}
