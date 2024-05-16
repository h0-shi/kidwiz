package com.kidwiz.web.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface VueDAO {
	public List<Map<String, Object>> boardList(Map<String, Object> pageMap);

	public List<Map<String, Object>> getBoard(Map<String, Object> pageMap);

	public int boardWrite(Map<String, Object> map);

	public Map<String, Object> boardDetail(String bno);

	public int boardDel(String bno);

	public int boardUpdate(Map<String, Object> map);

	public int boardReply(Map<String, Object> map);

	public Map<String, Object> getPath(String bno);

	public List<Map<String, Object>> getGroupList(Map<String, Object> pageMap);

	public Map<String, Object> groupDetail(String gr_no);

	public List<Map<String, Object>> getGList(String con_cd);

	public String totalPage();

	public int totalGPage();

	public Map<String, Object> getCoun(String id);

	public void createGroup(Map<String, Object> map);

	public List<Map<String, Object>> getDay(Map<String, Object> dayMap);

	public String getGrNo(String title);


}
