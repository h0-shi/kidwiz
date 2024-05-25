package com.kidwiz.web.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kidwiz.web.DTO.RsvDTO;

@Repository
@Mapper
public interface RsvBatisDAO {

	List<Map<String, Object>> studentCoun(int id);

}
