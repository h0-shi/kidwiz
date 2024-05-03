package com.kidwiz.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kidwiz.web.DTO.TestDTO;
import com.kidwiz.web.service.RegService;
import com.kidwiz.web.service.VueService;

@RestController
public class Test {
	
	@Autowired
	private VueService vueService;
	
	@Autowired
	private RegService regService;
	
	@PostMapping("/testPost")
	public String postTest(@RequestBody TestDTO test) {
		vueService.testInsert(test);
		System.out.println("-------------");
		System.out.println(test.getMajor());
		System.out.println(test.getTeacher());
		return "실험중";
	}
	
	@PostMapping("/accept")
	public String accept(@RequestBody Map<String, Object> ac) {
		System.out.println(ac.get("no"));
		int num = regService.accept(ac.get("no")+"");
		System.out.println(num+" : 결과");
		return "성공";
	}
}
