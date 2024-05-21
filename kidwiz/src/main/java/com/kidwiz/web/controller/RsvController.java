package com.kidwiz.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kidwiz.web.DTO.MemberDTO;
import com.kidwiz.web.DTO.RsvDTO;
import com.kidwiz.web.Entity.Member;
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
    public ResponseEntity<List<RsvDTO>> getAllReservations() {
        logger.info("getAllReservations 호출");
        List<RsvDTO> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createReservation(@RequestBody RsvDTO reservationDto) {
    	logger.info("createReservation 호출: {}", reservationDto);
    	reservationService.createReservation(reservationDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
 // 240521 새로운 회원 정보 API 추가
    @GetMapping("/members/{id}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable int id) {
        logger.info("getMemberById 호출: {}", id);
        MemberDTO member = reservationService.getMemberById(id); // 서비스에서 회원 정보 가져오기
        if (member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}