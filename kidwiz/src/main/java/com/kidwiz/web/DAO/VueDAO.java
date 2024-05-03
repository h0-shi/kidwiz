package com.kidwiz.web.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kidwiz.web.DTO.TestDTO;

@Repository
@Mapper
public interface VueDAO {
	public List<Map<String, Object>> boardList();

	public List<Map<String, Object>> getBoard();

	public int boardWrite(Map<String, Object> map);
	public int testInsert(TestDTO dto);

	public Map<String, Object> boardDetail(String bno);

	public int boardDel(String bno);

	public int boardUpdate(Map<String, Object> map);


}
