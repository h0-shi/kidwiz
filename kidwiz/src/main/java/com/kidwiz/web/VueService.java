package com.kidwiz.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueService {

	@Autowired
	private VueDAO vueDAO;
	
	public List<Map<String, Object>> list() {
		return vueDAO.boardList();
	}

}
