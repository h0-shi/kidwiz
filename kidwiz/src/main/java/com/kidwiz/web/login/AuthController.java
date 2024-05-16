//package com.kidwiz.web.login;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import lombok.Data;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//	@Autowired
//	private MemberService memberService;
//
//	@Autowired
//	private JwtUtil jwtUtil;
//
//	@PostMapping("/login")
//	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
//		Member member = memberService.login(loginRequest.getId(), loginRequest.getPw());
//		if (member != null) {
//			// HTTP 응답을 구성 : 로그인 성공시 JWT 토큰을 생성하여 반환합니다.
//			String token = jwtUtil.generateToken(loginRequest.getId());
//			return ResponseEntity.ok().body(new LoginResponse(member.getName(), token)); // 이름과 토큰을 반환
//		}
//		return ResponseEntity.badRequest().body("아이디와 비밀번호를 다시 확인해주세요");
//	}
//
//	// Spring Boot에서 클라이언트에게 보낼 응답을 캡슐화(보안)
//	@Data
//	static class LoginResponse {
//		private String name;
//		private String token;
//
//		// 생성자를 통해 이름과 토큰을 초기화
//		public LoginResponse(String name, String token) {
//			this.name = name;
//			this.token = token;
//		}
//	}
//}
//
//// 클라이언트로부터 받은 로그인 요청 데이터를 담는다
//@Data
//class LoginRequest {
//	private String id;
//	private String pw;
//}