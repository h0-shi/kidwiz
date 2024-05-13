package com.kidwiz.web.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kidwiz.web.DTO.RegDTO;
import com.kidwiz.web.service.RegService;
import com.kidwiz.web.service.VueService;

@RestController
public class RegController {
	
	@Autowired
	private VueService vueService;
	
	@Autowired
	private RegService regService;
	
	@PostMapping("/testPost")
	public String postTest(@RequestBody RegDTO test) {
		vueService.regconInsert(test);
		System.out.println("-------------");
		System.out.println(test.getMajor());
		System.out.println(test.getTeacher());
		return "실험중";
	}
	
	@PostMapping("/accept")
	public String accept(@RequestBody Map<String, Object> ac) {
		int num = regService.accept(ac.get("reg_no")+"");
		return "성공";
	}
	
	@GetMapping("/regDetail")
	public List<RegDTO> regDetail(@RequestParam("rgno") String rgno) {
		List<RegDTO> regDetail = regService.regDetail(rgno); 
		return regDetail;
	}
	
	@GetMapping("/timetable")
	public List<Map<String, Object>> timeTable(){
		List<Map<String, Object>> timetable = regService.timetable();
		return timetable;
	}
	
	@PostMapping("/regSubmit")
	public int regSubmit(@RequestBody RegDTO application) {
		return regService.regSubmit(application);
	}
	
	@GetMapping("/regTotalCount")
	public int regTotalPage() {
		return regService.regTotalCount();
	}
}
