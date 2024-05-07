package com.kidwiz.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kidwiz.web.service.VueService;

@CrossOrigin
@RestController
public class VueController {
	
	@Autowired
	private VueService vueService;
	
	@GetMapping("/test")
	public String test() {
		List<Map<String, Object>> list = vueService.list();
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray(list);
		json.put("list", arr);
		return json.toString();
	}
	
	@GetMapping("/")
	public String index() {
		List<Map<String, Object>> list = vueService.list();
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray(list);
		json.put("list", arr);
		return json.toString();
	}
	
	@GetMapping("/api/BoardList")
	public String getBoard() {
		List<Map<String, Object>> list = vueService.getBoard();
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray(list);
		json.put("list",arr);
		
		
		return json.toString();
	}
	
	@PostMapping("/api/boardWrite")
	public int boardWrite(@RequestBody Map<String, Object> map) {
		int result = vueService.boardWrite(map);
		
		return result;
	}
	
	@GetMapping("/api/boardDetail")
	public String boardDetail(@RequestParam("bno") String bno) {
		Map<String, Object> list = vueService.boardDetail(bno);
		JSONObject json = new JSONObject();
		json.put("list", list);
		return json.toString();
	}
	
	@PostMapping("/api/boardDel")
	public String boardDel(@RequestParam("bno") String bno) {
		int result = vueService.boardDel(bno);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	@PostMapping("/api/boardUpdate")
	public String boardUpdate(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		int result = vueService.boardUpdate(map);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	@PostMapping("/api/boardReply")
	public String boardReply(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		int result = vueService.boardReply(map);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
}
