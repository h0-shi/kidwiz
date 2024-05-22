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

	// 로그인
	@PostMapping("/api/account/login")
	public ResponseEntity login(@RequestBody Map<String, String> params, HttpServletResponse res) {
		
		// id 를 int 형으로 변환
		int id = Integer.parseInt(params.get("id"));
		
		Member member = memberRepository.findByIdAndPassword(id, params.get("password"));

		if (member != null) {
			int tokenid = member.getId();
			String token = jwtService.getToken("id", tokenid);

//			Cookie cookie = new Cookie("token", token);
//			cookie.setHttpOnly(true);
//			cookie.setPath("/");

//			res.addCookie(cookie);
			
			// 직접 Set-Cookie 헤더 추가
	        String cookieValue = String.format("token=%s; HttpOnly; SameSite=None; Secure; Path=/", token);
	        res.addHeader("Set-Cookie", cookieValue);

	        System.out.println("Token: " + token);
			System.out.println("TokenID: " + tokenid);
            System.out.println("Cookie: " + cookieValue);
            
            //Member 객체의 모든 필드가 JSON으로 변환되어 클라이언트에 반환(password : @JsonIgnore)
			return new ResponseEntity<>(member, HttpStatus.OK);
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	// 로그아웃
	@PostMapping("/api/account/logout")
    public ResponseEntity logout(HttpServletResponse res) {
		
		System.out.println("로그아웃 합니다");
		
        Cookie cookie = new Cookie("token", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        res.addCookie(cookie);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// 토큰값으로 사용자 여부 확인
	@GetMapping("/api/account/check")
	public ResponseEntity check(@CookieValue(value = "token", required = false) String token) {

		System.out.println("check! 토큰이 있다?: " + token);

		Claims claims = jwtService.getClaims(token);

		System.out.println("check! Claims 있다?: " + claims);

		if (claims != null) {
			int id = Integer.parseInt(claims.get("id").toString());
			Member member = memberRepository.findById(id);
			return new ResponseEntity<>(member, HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	// 비밀번호 수정
	@PostMapping("api/account/changepassword")
	public ResponseEntity changepassword(@RequestBody Map<String, String> params,
			@CookieValue(value = "token") String token) {
		
		// 토큰 확인
		Claims claims = jwtService.getClaims(token);
		if(claims == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		// claims 에서 id 값 추출하기
		int id = Integer.parseInt(claims.get("id").toString());
		Member member = memberRepository.findById(id);
		
		if(member != null) {
			member.setPassword(params.get("newPassword"));
			memberRepository.save(member);
			
			return new ResponseEntity<>(member, HttpStatus.OK);
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

}
