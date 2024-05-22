package com.kidwiz.web.service;

import java.util.List;
import java.util.Map;

import com.kidwiz.web.DTO.MemberDTO;
import com.kidwiz.web.DTO.RsvDTO;

public interface RsvService {

    List<RsvDTO> getAllReservations(String type, String date);
    void createReservation(RsvDTO reservationDto);

    MemberDTO getMemberById(int id);
	List<RsvDTO> getAllReservations(RsvDTO rsv);
	Integer getProId(String majorHead);
	Integer getCounselorId(String CounselingType);
}
