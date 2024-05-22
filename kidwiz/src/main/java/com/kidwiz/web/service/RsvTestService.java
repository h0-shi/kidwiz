package com.kidwiz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidwiz.web.DAO.RsvTestDAO;
import com.kidwiz.web.DTO.RsvDTO;

@Service
public class RsvTestService {
	
	@Autowired
	private RsvTestDAO rsvTestDAO;

	public List<RsvDTO> getRsvsByProid(int proid) {
		return rsvTestDAO.findRsvByProid(proid);
	}

}
