package com.kidwiz.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kidwiz.web.DTO.CardDTO;
import com.kidwiz.web.DTO.MemberDTO;
import com.kidwiz.web.DTO.RegDTO;
import com.kidwiz.web.DTO.ResultDTO;
import com.kidwiz.web.service.JwtService;
import com.kidwiz.web.service.RegService;
import com.kidwiz.web.service.VueService;
import com.kidwiz.web.util.Util;

@RestController
public class RegController {
	
	@Autowired
	private VueService vueService;
	
	@Autowired
	private RegService regService;
	
	@Autowired
	private JwtService jwtService;
	
	@GetMapping("/regRev")
	public String regRev(@RequestParam(name="page", required = false) String page, @RequestParam(name="total", required = false) String total) {
		System.out.println(page==null);		
		if(page==null) {
			page="1";
		}
		if(total == null) {
			total = "1";
		}
		Map<String, Object> pageMap = Util.pageMap(Integer.parseInt(total),Integer.parseInt(page));
		List<Map<String, Object>> list = regService.regRev(pageMap);
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray(list);
		json.put("list", arr);
		json.put("pageMap", pageMap);
		
		return json.toString();
	}
	
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
		System.out.println(application.getProNum()+"여기야*-*--*--*-");
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
	public List<MemberDTO> memberDetail(@RequestParam("id") String id){
		List<MemberDTO> memberDetail = regService.memberDetail(id);		
		return memberDetail;
	}
	
	@GetMapping("/getProInfo")
	public Map<String, Object> getProInfo(@RequestParam("major") String type){
		Map<String, Object> memberDetail = regService.getProInfo(type);		
		return memberDetail;
	}
	
	@PostMapping("/resultWrite")
	public int resultWrite(@RequestBody ResultDTO result) {
		int resultWrite = regService.resultWrite(result);
		return resultWrite;
	}
	
	@GetMapping("/getRegResult")
	public List<RegDTO> getRegResult(@RequestParam("regno") String regno){
		List<RegDTO> regResult = regService.getRegResult(regno);
		return regResult; 
	}
	
	@PostMapping("/resultUpdate")
	public int resultUpdate(@RequestBody ResultDTO result) {
		System.out.println(result.getRegno());
		int update = regService.resultUpdate(result);
		
		return update;
	}
	
	@GetMapping("/regAcess")
	public int regAcess(@CookieValue(value = "token", required = false) String token) {
		if(token == null) {
			return 0;
		}		
		
		int id = jwtService.getId(token);
		if(id == 0) {
			return 0;
		}
		
		String major = regService.getMajor(id);		
		if(major.equals("전문상담")) {
			return 1;
		} else {
			return 0;
		}		
	}
	
	@GetMapping("/getRegInfo")
	public Map<String, Object> getRegInfo(@RequestParam("regno") String regno) {
		Map<String, Object> map = regService.getRegInfo(regno);		
		return map;
	}
	
	@GetMapping("/regReservations")
	public List<RegDTO> regReservations(@RequestParam("date") String date){
		List<RegDTO> regReservations = regService.regReservations(date);
		return regReservations;
	}
	
	@GetMapping("/getCounselorInfo")
	public Map<String, Object> getCounselorInfo(@RequestParam("id") String id){
		Map<String, Object> map = regService.getCounselorInfo(id);
		return map;
	}
	
	@GetMapping("/checkRegRev")
	public List<RegDTO> checkRegRev(@RequestParam("date") String date){
		List<RegDTO> checkRegRev = regService.checkRegRev(date);
		return checkRegRev;
	}
	
	@GetMapping("/rsvs")
	public List<RegDTO> rsvs(@RequestParam("date") String date, @RequestParam("id") String id, @RequestParam("grade") String grade){
		int auto = Integer.parseInt(grade);
		if(auto < 2) {
			grade = "일반사용자";
		} else {
			grade= "관리자";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("grade", grade);
		map.put("date", date);
		List<RegDTO> rsvs = regService.rsvs(map);
		return rsvs;
	}
	
	@GetMapping("/getScehdule")
	public List<RegDTO> getScehdule(@RequestParam("id") String id, @RequestParam("grade") String grade){
		int auto = Integer.parseInt(grade);
		if(auto < 2) {
			grade = "일반사용자";
		} else {
			grade= "관리자";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("grade", grade);
		List<RegDTO> getScehdule = regService.getScehdule(map);
		return getScehdule;
	}
	
	@GetMapping("/recentBoard")
	public List<Map<String, Object>> recentBoard(@RequestParam("id") String id){
		List<Map<String, Object>> recentBoard = regService.recentBoard(id);
		return recentBoard;
	}
	
	@GetMapping("/need2Write")
	public List<Map<String, Object>> need2Write(@RequestParam("id") String id){
		List<Map<String, Object>> need2Write = regService.need2Write(id);
		return need2Write;
	}
	
	@PostMapping(value="cardWrite", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Object cardWrite(@RequestParam("c1") MultipartFile[] c1,
			@RequestPart("info") CardDTO cardDTO) throws IllegalStateException, IOException {
						
		UUID uuid = UUID.randomUUID();
						
		String uuidNum = uuid.toString();
		List<CardDTO> cards = new ArrayList<CardDTO>();
		
		String pf = System.getProperty("user.dir");
		String ppf = new File(pf).getParent();
		String upfile = ppf+"\\vue_kidwiz\\public\\images\\cardNews\\"+uuid;
		
		for (MultipartFile mf : c1) {
			String fileName = mf.getOriginalFilename();
			File saveFile = new File(upfile, uuidNum+"_"+fileName);
			
			CardDTO card = new CardDTO();
			card.setCn_uuid(uuidNum);
			card.setCn_name(uuidNum+"_"+fileName);
			card.setCn_title(cardDTO.getCn_title());
			card.setCn_exp(cardDTO.getCn_exp());
			
			cards.add(card);
			if(!saveFile.exists()) {
				try {
					saveFile.mkdirs();
					System.out.println("폴더 생성");
				} catch (Exception e) {
				}
			}			
			mf.transferTo(saveFile);			
		}		
		
		int result = regService.cardsWrite(cards);
		return result;
	}
	
	@GetMapping("/getCardNews")
	public List<CardDTO> getCardNews(){
		List<CardDTO> cards = regService.getCardNews();
		return cards;
	}
	
	@GetMapping("/cardDetail")
	public List<CardDTO> cardDetail(@RequestParam("uuid") String uuid){
		List<CardDTO> cardDetail = regService.cardDetail(uuid);
		return cardDetail;
	}
	
}
