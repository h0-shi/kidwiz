package com.kidwiz.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface VueDAO {
	public List<Map<String, Object>> boardList();

}
