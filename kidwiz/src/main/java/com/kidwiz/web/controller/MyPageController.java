//package com.kidwiz.web.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CookieValue;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
//
//import com.kidwiz.web.Entity.Cart;
//import com.kidwiz.web.Entity.Item;
//import com.kidwiz.web.Entity.Member;
//import com.kidwiz.web.repository.CartRepository;
//import com.kidwiz.web.repository.ItemRepository;
//import com.kidwiz.web.repository.MemberRepository;
//import com.kidwiz.web.service.JwtService;
//
//@RestController
//public class MyPageController {
//	
//	@Autowired
//    MemberRepository memberRepository;
//	
//	@Autowired
//    JwtService jwtService;
//	
//	// 내정보 출력하기
//    @GetMapping("/api/myinfo")
//    public ResponseEntity getMyInfo(@CookieValue(value = "token", required = false) String token) {
//    	
//    	System.out.println("내정보 토큰이 있다?: " + token);
//
//        if (!jwtService.isValid(token)) {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
//        }
//
//        int memberId = jwtService.getId(token); // 토큰으로부터 member의 id를 추출
//        List<Member> myInfo = memberRepository.findById(memberId);
//        
//        return new ResponseEntity<>(myInfo, HttpStatus.OK);
//    }
//}
