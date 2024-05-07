package com.kidwiz.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kidwiz.web.DTO.TestQuestion;

public interface TestQuestionRepository extends JpaRepository<TestQuestion, Long> {
	
    @Query("SELECT t.tcategory, t.ttitle FROM TestQuestion t WHERE t.qid = :qid")
    Object[] findCategoryAndTitleByQid(@Param("qid") Integer qid);
}


