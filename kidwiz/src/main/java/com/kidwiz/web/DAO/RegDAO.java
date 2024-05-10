package com.kidwiz.web.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kidwiz.web.DTO.RegDTO;

@Repository
@Mapper
public interface RegDAO {

	public int accept(String no); 
	
	public int regconInsert(RegDTO dto);

	public List<RegDTO> regDetail(String rgno);

	public List<Map<String, Object>> timetable();

	public int regSubmit(RegDTO application);

}
