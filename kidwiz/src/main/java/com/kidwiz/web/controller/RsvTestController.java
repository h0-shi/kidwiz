package com.kidwiz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kidwiz.web.DTO.RsvDTO;
import com.kidwiz.web.service.JwtService;
import com.kidwiz.web.service.RsvTestService;

import io.jsonwebtoken.Claims;

@RestController
public class RsvTestController {

	@Autowired
    JwtService jwtService;
	
	@Autowired
	RsvTestService rsvTestService;
	
	// 상담사별 예약 학생 출력하기
	@GetMapping("/api/rsv/test")
    public ResponseEntity getRsvTest(@CookieValue(value = "token", required = false) String token) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        // 토큰으로부터 claims 출력
        Claims claims = jwtService.getClaims(token);
        
        // 토큰으로부터 id 출력
        int proid = jwtService.getId(token);
        
        // proid로 예약 데이터 가져오기
        List<RsvDTO> rsvs = rsvTestService.getRsvsByProid(proid);
        
        return new ResponseEntity<>(rsvs, HttpStatus.OK);
        
//        List<Cart> carts = cartRepository.findByMemberId(memberId);
//        // 카트의 itemId 값들만 list 형태로 출력
//        List<Integer> itemIds = carts.stream().map(Cart::getItemId).toList();
//        List<Item> items = itemRepository.findByIdIn(itemIds);
//
//        return new ResponseEntity<>(items, HttpStatus.OK);
//        
//		if (claims != null) {
//			int id = Integer.parseInt(claims.get("id").toString());
//			Member member = memberRepository.findById(id);
//			return new ResponseEntity<>(member, HttpStatus.OK);
//		}
    }
}
