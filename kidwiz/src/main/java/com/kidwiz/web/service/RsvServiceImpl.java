package com.kidwiz.web.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kidwiz.web.DAO.RsvDAO;
import com.kidwiz.web.DTO.MemberDTO;
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
	public List<RsvDTO> getAllReservations(RsvDTO rsv) {
		logger.info("getAllReservations 호출");
		return reservationDAO.getAllReservations(rsv);
	}

	@Override
	@Transactional // 트랜잭션 관리
	public void createReservation(RsvDTO reservationDto) {
		logger.info("createReservation 호출: {}", reservationDto);
		// reservationDAO.insertReservation(reservationDto);

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

		// 240517 유효성 검사를 통과하지 못한 경우 데이터베이스에 삽입하지 않음
		if (reservationDto.getSid() == 0 || reservationDto.getProid() == 0 || reservationDto.getCtype() == null
				|| reservationDto.getCtime() == null || reservationDto.getCdate() == null
				|| reservationDto.getRsvdate() == null || reservationDto.getRsvmemo() == null) {
			logger.error("유효성 검사를 통과하지 못했습니다.");
			return;
		}

		reservationDAO.insertReservation(reservationDto);
	}

	@Override
	public MemberDTO getMemberById(int id) {
		logger.info("getMemberById 호출: {}", id);
		return reservationDAO.getMemberById(id);
	}

	@Override
	public List<RsvDTO> getAllReservations(String type, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getProId(String majorHead) {
		logger.info("getProId 호출: {}", majorHead);
		return reservationDAO.getProId(majorHead);
	}

	@Override
	public Integer getProId2(String CounselingType) {
		logger.info("getProId 호출: {}", CounselingType);
		return reservationDAO.getProId2(CounselingType);
	}
}