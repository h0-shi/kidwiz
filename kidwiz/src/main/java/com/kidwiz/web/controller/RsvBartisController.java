package com.kidwiz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kidwiz.web.DTO.RsvDTO;
import com.kidwiz.web.service.JwtService;
import com.kidwiz.web.service.RsvBatisService;


@RestController
public class RsvBartisController {
	
	@Autowired
	private RsvBatisService rsvService;
	
	@Autowired
	private JwtService jwtService;
	
	@GetMapping("/studentCoun")
	public List<RsvDTO> studentCoun(@CookieValue(value = "token", required = false) String token){
		int id = jwtService.getId(token);				
		List<RsvDTO> list = rsvService.studentCoun(id);		
		return list;
	}

}
