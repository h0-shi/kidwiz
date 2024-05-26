package com.kidwiz.web.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kidwiz.web.DTO.Counselor;

@Repository
@Mapper
public interface VueDAO {
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


	public void createGroup(Map<String, Object> map);

	public List<Map<String, Object>> getDay(Map<String, Object> dayMap);

	public Map<String, Object> getMemberType(int id);

	public String getUpGrNo(String gr_no);

	public List<String> getGrNo(String up_gr_no);


	public void applyGroup(Map<String, Object> map);

	public int checkGroup(Map<String, Object> map);

	public List<Map<String, Object>> getRsv(int id);

	public List<Counselor> counselorList();

	public int counselorcheck(int id);

	public Object getOrdernum(Map<String, Object> map);

	public int boardInsertUpdate(Map<String, Object> map);

	public String boardWriteAfter(Map<String, Object> map);

	public String writerCheck(String up_bno);

	public void updateUpgrno(Map<String, Object> map);

	public String selectUpGrNo(Map<String, Object> map);


}
