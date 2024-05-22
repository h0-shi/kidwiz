package com.kidwiz.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kidwiz.web.service.JwtService;
import com.kidwiz.web.service.VueService;
import com.kidwiz.web.util.Util;

@CrossOrigin
@RestController
public class VueController {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private VueService vueService;
	
	@GetMapping("/")
	public String index() {
		return "";
	}
	
	@GetMapping("/api/BoardList")
	public String getBoard(@RequestParam("currentpage")int currentpage) {
		String totalpage = vueService.totalPage();
		
		Map<String, Object> pageMap = Util.pageMap(Integer.parseInt(totalpage),currentpage);
		List<Map<String, Object>> list = vueService.getBoard(pageMap);
		
		
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray(list);
		json.put("list",arr);
		json.put("pageMap", pageMap);
		
		//test
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
	
	@GetMapping("/api/getPath")
	public String getPath(@RequestParam("bno") String bno) {
		Map<String, Object> list = vueService.getPath(bno);
		JSONObject json = new JSONObject();
		json.put("list", list);
		return json.toString();
	}
	
	@GetMapping("/api/getGroupList")
	public String getGroupList(@RequestParam("currentpage")int currentpage) {
		int totalcount = vueService.totalGPage();
		Map<String, Object> pageMap = Util.pageGMap(totalcount, currentpage);
		List<Map<String, Object>> list = vueService.getGroupList(pageMap);
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray(list);
		
		json.put("list", arr);
		json.put("pageMap", pageMap);
		return json.toString();
	}
	
	@GetMapping("/api/groupDetail")
	public String groupDetail(@RequestParam("gr_no") String gr_no) {
		Map<String, Object> map = vueService.groupDetail(gr_no);

		List<Map<String, Object>> glist = vueService.getGList(gr_no);
		JSONObject json = new JSONObject();
		json.put("list", map);
		json.put("glist", glist);
		return json.toString();
	}
	@GetMapping("/api/getcoun")
	public String getcoun(@RequestParam("id") String id) {
		
		Map<String, Object> map = vueService.getCoun(id);
		JSONObject json = new JSONObject();
		json.put("map", map);
		return json.toString();
	}
	
	@PostMapping("/api/createGroup")
    public String createGroup(@RequestParam("image") MultipartFile image,
    		@RequestParam("request") String requestJson) throws IllegalStateException, IOException {
        // 이미지와 JSON 데이터를 받아 처리하는 로직을 작성합니다.
        // 예를 들어, 이미지를 저장하고 JSON 데이터를 파싱하여 필요한 작업을 수행합니다.
		Map<String, Object> map;
		 
		ObjectMapper objectMapper = new ObjectMapper();
        
		map = objectMapper.readValue(requestJson, Map.class);
		
		
		map.put("image", Util.fileUploadUtil(image).get("saveFileName"));
		
		vueService.createGroup(map);
		
        return "성공";
    }
	
	@PostMapping("/api/getMemberType")
	public ResponseEntity getMemberType(@CookieValue(value = "token", required = false) String token) {
		//TODO: process POST request
		
		if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
		
		int id = jwtService.getId(token);
		System.out.println(id);
		Map<String,Object> list = vueService.getMemberType(id);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
}





















