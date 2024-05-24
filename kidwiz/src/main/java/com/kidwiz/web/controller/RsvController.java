package com.kidwiz.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kidwiz.web.DTO.MemberDTO;
import com.kidwiz.web.DTO.RsvDTO;
import com.kidwiz.web.service.RsvService;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "http://localhost:8080") // Vue.js 개발 서버 URL
public class RsvController {
	private final RsvService reservationService;
	private static final Logger logger = LoggerFactory.getLogger(RsvController.class);

	public RsvController(RsvService reservationService) {
		this.reservationService = reservationService;
	}

	@GetMapping
	public ResponseEntity<List<RsvDTO>> getAllReservations(@RequestParam("date") String date,
			@RequestParam("type") String ctype) {
		System.out.println(date + ctype + "여기입니다------");
		logger.info("getAllReservations 호출");
		RsvDTO rsv = new RsvDTO();
		rsv.setDate(date);
		rsv.setCtype(ctype);
		List<RsvDTO> reservations = reservationService.getAllReservations(ctype, date);
		System.out.println(reservations);
		return new ResponseEntity<>(reservations, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> createReservation(@RequestBody RsvDTO reservationDto) {
		logger.info("createReservation 호출: {}", reservationDto);
		reservationService.createReservation(reservationDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// 240521 새로운 회원 정보 API 추가
	@GetMapping("/members")
	public ResponseEntity<MemberDTO> getMemberById(@RequestParam("studentID") String studentID) {
		logger.info("getMemberById 호출: {}", studentID);
		int id = Integer.parseInt(studentID);
		MemberDTO member = reservationService.getMemberById(id); // 서비스에서 회원 정보 가져오기
		if (member == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(member, HttpStatus.OK);
	}

	// 지도교수 id 가져오기
	@GetMapping("/getProId")
	public ResponseEntity<Integer> getProId(@RequestParam("majorHead") String majorHead) {
		logger.info("getProId 호출: {}", majorHead);
		System.out.println("-----------------------------");
		System.out.println(majorHead);
		Integer proId = reservationService.getProId(majorHead);
		if (proId != null) {
			return ResponseEntity.ok(proId);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	// 상담사 id 가져오기

	@GetMapping("/getCounselorId")
	public ResponseEntity<Integer> getCounselorId(@RequestParam("CounselingType") String CounselingType) {
	    logger.info("getCounselorId 호출: {}", CounselingType);
	    Integer counselorId = reservationService.getCounselorId(CounselingType);
	    if (counselorId != null) {
	        return ResponseEntity.ok(counselorId);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}
}