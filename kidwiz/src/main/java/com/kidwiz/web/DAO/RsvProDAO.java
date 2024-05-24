package com.kidwiz.web.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RsvProDAO {

	List<Map<String,Object>> findRsvByProid(int proid);

	Map<String, Object> findRsvInfoByRsvno(Integer rsvno);

    void saveProResultWrite(@Param("rsvno") Integer rsvno, 
            @Param("goal") String goal, 
            @Param("content") String content, 
            @Param("summary") String summary, 
            @Param("homework") String homework, 
            @Param("opinion") String opinion);

	Map<String, Object> findProResultByRsvno(Integer rsvno);

	void updateProResult(@Param("rsvno") Integer rsvno, 
            @Param("goal") String goal, 
            @Param("content") String content, 
            @Param("summary") String summary, 
            @Param("homework") String homework, 
            @Param("opinion") String opinion);

}
