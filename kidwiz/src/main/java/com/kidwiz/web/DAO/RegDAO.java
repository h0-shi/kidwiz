package com.kidwiz.web.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RegDAO {

	public int accept(String no); 
	

}
