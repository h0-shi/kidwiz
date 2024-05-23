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

}
