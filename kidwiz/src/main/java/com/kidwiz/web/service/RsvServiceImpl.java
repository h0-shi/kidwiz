package com.kidwiz.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kidwiz.web.DAO.RsvDAO;
import com.kidwiz.web.DTO.RsvDTO;

	@Service
	public class RsvServiceImpl implements RsvService {
	    private final RsvDAO reservationDAO;

	    public RsvServiceImpl(RsvDAO reservationDAO) {
	        this.reservationDAO = reservationDAO;
	    }

	    @Override
	    public List<RsvDTO> getAllReservations() {
	        return reservationDAO.getAllReservations();
	    }

	    @Override
	    public void createReservation(RsvDTO reservationDto) {
	        reservationDAO.insertReservation(reservationDto);
	    }
}
