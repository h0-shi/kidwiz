package com.kidwiz.web.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RsvProDAO {

	List<Map<String,Object>> findRsvByProid(int proid);

	Map<String, Object> findRsvInfoByRsvno(Integer rsvno);

}
