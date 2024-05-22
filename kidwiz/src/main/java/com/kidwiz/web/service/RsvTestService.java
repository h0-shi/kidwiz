package com.kidwiz.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidwiz.web.DAO.RsvTestDAO;

@Service
public class RsvTestService {
	
	@Autowired
	private RsvTestDAO rsvTestDAO;

	public List<Map<String,Object>> getRsvsByProid(int proid) {
		return rsvTestDAO.findRsvByProid(proid);
	}

}
