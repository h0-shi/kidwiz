package com.kidwiz.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kidwiz.web.service.JwtService;
import com.kidwiz.web.service.RsvProService;

import io.jsonwebtoken.Claims;

@RestController
public class RsvProController {

	@Autowired
	JwtService jwtService;

	@Autowired
	RsvProService rsvProService;

	// 상담사별 예약 학생 출력하기
	@GetMapping("/api/rsv/list")
	public ResponseEntity getRsv(@CookieValue(value = "token", required = false) String token) {

		if (!jwtService.isValid(token)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}

		// 토큰으로부터 claims 출력
		Claims claims = jwtService.getClaims(token);

		// 토큰으로부터 id 출력
		int proid = jwtService.getId(token);

		// proid로 예약 데이터 가져오기
		List<Map<String, Object>> rsvs = rsvProService.getRsvsByProid(proid);

		return new ResponseEntity<>(rsvs, HttpStatus.OK);

	}

	// 상담일지 info 출력
	@GetMapping("/api/rsv/{rsvno}")
	public ResponseEntity getRsvInfo(@PathVariable("rsvno") Integer rsvno,
			@CookieValue(value = "token", required = false) String token) {

		System.out.println("들어오나"+rsvno);
		
		// 토큰값이 유효하지 않으면
		if (!jwtService.isValid(token)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}

		// rsvno 정보 담기
		Map<String, Object> rsvnoinfo = rsvProService.getRsvInfoByRsvno(rsvno);
		
		return new ResponseEntity<>(rsvnoinfo, HttpStatus.OK);
	}

	@PostMapping("/api/rsv/{rsvno}/save")
	public ResponseEntity saveRsvResult(@PathVariable("rsvno") Integer rsvno,
            @RequestBody Map<String, Object> payload,
            @CookieValue(value = "token", required = false) String token) {
		
		System.out.println("rsvno: " + rsvno);
        System.out.println("Payload: " + payload);
        
        return ResponseEntity.ok("Data saved successfully");
	}
}
