package com.kidwiz.web.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kidwiz.web.DAO.RsvDAO;
import com.kidwiz.web.DTO.RsvDTO;

import jakarta.transaction.Transactional;

	@Service
	public class RsvServiceImpl implements RsvService {
	    private final RsvDAO reservationDAO;
	    private static final Logger logger = LoggerFactory.getLogger(RsvServiceImpl.class);


	    public RsvServiceImpl(RsvDAO reservationDAO) {
	        this.reservationDAO = reservationDAO;
	    }

	    @Override
	    public List<RsvDTO> getAllReservations() {
	        logger.info("getAllReservations 호출");
	        return reservationDAO.getAllReservations();
	    }

	    @Override
	    @Transactional  // 트랜잭션 관리
	    public void createReservation(RsvDTO reservationDto) {
	        logger.info("createReservation 호출: {}", reservationDto);
	        //reservationDAO.insertReservation(reservationDto);
	        
	     // DTO 데이터 유효성 검사
	        if (reservationDto == null) {
	            logger.error("reservationDto is null");
	            return;
	        }
	        if (reservationDto.getSid() == 0) {
	            logger.error("SID is not set");
	        }
	        if (reservationDto.getProid() == 0) {
	            logger.error("ProID is not set");
	        }
	        if (reservationDto.getCtype() == null || reservationDto.getCtype().isEmpty()) {
	            logger.error("Ctype is not set");
	        }
	        if (reservationDto.getCtime() == null || reservationDto.getCtime().isEmpty()) {
	            logger.error("Ctime is not set");
	        }
	        if (reservationDto.getCdate() == null) {
	            logger.error("Cdate is not set");
	        }
	        if (reservationDto.getRsvdate() == null) {
	            logger.error("Rsvdate is not set");
	        }
	        if (reservationDto.getRsvmemo() == null || reservationDto.getRsvmemo().isEmpty()) {
	            logger.error("Rsvmemo is not set");
	        }

	        reservationDAO.insertReservation(reservationDto);
	    }
	        
	    
}
