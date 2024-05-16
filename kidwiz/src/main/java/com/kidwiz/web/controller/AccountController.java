package com.kidwiz.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kidwiz.web.Entity.Member;
import com.kidwiz.web.repository.MemberRepository;
import com.kidwiz.web.service.JwtService;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class AccountController {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	JwtService jwtService;

	@PostMapping("/api/account/login")
	public ResponseEntity login(@RequestBody Map<String, String> params, HttpServletResponse res) {
		Member member = memberRepository.findByEmailAndPassword(params.get("email"), params.get("password"));

		if (member != null) {
			int id = member.getId();
			String token = jwtService.getToken("id", id);

//			Cookie cookie = new Cookie("token", token);
//			cookie.setHttpOnly(true);
//			cookie.setPath("/");

//			res.addCookie(cookie);
			
			// 직접 Set-Cookie 헤더 추가
	        String cookieValue = String.format("token=%s; HttpOnly; SameSite=None; Secure; Path=/", token);
	        res.addHeader("Set-Cookie", cookieValue);


			System.out.println("ID: " + id);
            System.out.println("Token: " + token);
            System.out.println("Cookie: " + cookieValue);
            
			return new ResponseEntity<>(id, HttpStatus.OK);
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	// 토큰값으로 사용자 여부 확인
	@GetMapping("/api/account/check")
	public ResponseEntity check(@CookieValue(value = "token", required = false) String token) {

		System.out.println("토큰이 있다?: " + token);

		Claims claims = jwtService.getClaims(token);

		System.out.println("Claims 있다?: " + claims);

		if (claims != null) {
			int id = Integer.parseInt(claims.get("id").toString());
			return new ResponseEntity<>(id, HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
