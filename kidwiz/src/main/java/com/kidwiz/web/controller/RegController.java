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

import com.kidwiz.web.DTO.MemberDTO;
import com.kidwiz.web.DTO.RegDTO;
import com.kidwiz.web.DTO.ResultDTO;
import com.kidwiz.web.service.RegService;
import com.kidwiz.web.service.VueService;

@RestController
public class RegController {
	
	@Autowired
	private VueService vueService;
	
	@Autowired
	private RegService regService;
	
	@PostMapping("/regconInsert")
	public int postTest(@RequestBody RegDTO test) {
		vueService.regconInsert(test);
		test.setReg_no("reg-"+String.format("%05d", test.getSub_no()));
		return regService.oneTimeRegInsert(test);
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
		return regService.oneTimeRegInsert(application);
	}
	
	@GetMapping("/regTotalCount")
	public int regTotalPage() {
		return regService.regTotalCount();
	}
	
	@GetMapping("/regResult")
	public List<RegDTO> regResult(@RequestParam("regno") String regno){
		List<RegDTO> result = regService.regResult(regno);
		
		return result;
	}
	
	@GetMapping("/memberDetail")
	public List<MemberDTO> memberDetail(@RequestParam("stuNum") String stuNum){
		List<MemberDTO> memberDetail = regService.memberDetail(stuNum);
		return memberDetail;
	}
	
	@PostMapping("/resultWrite")
	public int resultWrite(@RequestBody ResultDTO result) {
		int resultWrite = regService.resultWrite(result);
		return 1;
	}
	
	@GetMapping("/getRegResult")
	public List<RegDTO> getRegResult(@RequestParam("regno") String regno){
		List<RegDTO> regResult = regService.getRegResult(regno);
		return regResult; 
	}
	
	@PostMapping("/resultUpdate")
	public int resultUpdate(@RequestBody ResultDTO result) {
		int update = regService.resultUpdate(result);
		return update;
	}
}
