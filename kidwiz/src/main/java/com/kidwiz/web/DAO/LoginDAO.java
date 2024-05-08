package com.kidwiz.web.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kidwiz.web.DTO.LoginDTO;

@Mapper
public interface LoginDAO {
	LoginDTO findUserBysid(@Param("sid") String sid);

}
