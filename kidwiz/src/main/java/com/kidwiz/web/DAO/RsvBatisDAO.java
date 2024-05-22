package com.kidwiz.web.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kidwiz.web.DTO.RsvDTO;

@Repository
@Mapper
public interface RsvBatisDAO {

	List<RsvDTO> studentCoun(int id);

}
