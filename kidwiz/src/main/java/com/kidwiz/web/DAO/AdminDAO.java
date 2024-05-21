package com.kidwiz.web.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminDAO {

	List<Map<String, Object>> getMember();

	int changeGrade(Map<String, Object> row);

	List<Map<String, Object>> totalBoard();

	int changeDb(Map<String, Object> row);

}
