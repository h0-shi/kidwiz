package com.kidwiz.web.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kidwiz.web.service.AdminService;
import com.kidwiz.web.service.JwtService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private JwtService jwtService;
	
	@GetMapping("/api/admin/member")
	public String getMember() {
		
		List<Map<String, Object>> map = adminService.getMember();
		
		JSONObject json = new JSONObject();
		JSONArray arr= new JSONArray(map);
		json.put("member", arr);

		return json.toString();
	}
	
	@PostMapping("/api/admin/changeGrade")
	public int changeGrade(@RequestBody Map<String, Object> row) {
		
		return adminService.changeGrade(row);
	}
	
	@GetMapping("/api/admin/totalBoard")
	public String totalBoard() {
		
		List<Map<String, Object>> list = adminService.totalBoard();
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray(list);
		
		json.put("list", arr);
		
		return json.toString();
	}

	@PostMapping("/api/admin/changeDb")
	public int changeDb(@RequestBody Map<String, Object> row) {
		return adminService.changeDb(row);
	}
	
	@PostMapping("/api/admin/admincheck")
	public ResponseEntity admincheck(@CookieValue (value = "token", required = false) String token) {
		//TODO: process POST request
		
		int check = 0;
		
    	// 토큰값이 유효하지 않으면
        if (!jwtService.isValid(token)) {
        	return new ResponseEntity<>(check,HttpStatus.OK);
        }
        check = adminService.admincheck(jwtService.getId(token));
        
		return new ResponseEntity<>(check,HttpStatus.OK);
	}
	
}























