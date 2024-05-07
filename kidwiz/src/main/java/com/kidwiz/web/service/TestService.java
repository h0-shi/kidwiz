package com.kidwiz.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kidwiz.web.DTO.TestAnswer;
import com.kidwiz.web.DTO.TestQuestion;
import com.kidwiz.web.DTO.TestResult;
import com.kidwiz.web.repository.TestQuestionRepository;
import com.kidwiz.web.repository.TestRepository;
import com.kidwiz.web.repository.TestResultRepository;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestQuestionRepository testQuestionRepository;
    
    @Autowired
    private TestResultRepository testResultRepository;

    @Transactional
    public void saveTestQuestion(TestQuestion testQuestion) {
        Object[] categoryAndTitle = testQuestionRepository.findCategoryAndTitleByQid(testQuestion.getQid());

        if (categoryAndTitle != null && categoryAndTitle.length == 2) {
            testQuestion.setTcategory((String) categoryAndTitle[0]);
            testQuestion.setTtitle((String) categoryAndTitle[1]);
            testRepository.save(testQuestion);
        } else {
            throw new IllegalStateException("Unable to retrieve category and title for qid: " + testQuestion.getQid());
        }
    }

    @Transactional
    public void saveTest(TestAnswer testAnswer) {
        testRepository.save(testAnswer);
    }

    @Transactional
    public void saveTestResult(TestResult testResult) {
        testResultRepository.save(testResult);
    }
}
