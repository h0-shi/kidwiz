package com.kidwiz.web.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kidwiz.web.DTO.RegDTO;

@Repository
@Mapper
public interface RegDAO {

	public int accept(String no); 
	
	public int regconInsert(RegDTO dto);

}
