package com.kidwiz.web.DTO;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
import lombok.NoArgsConstructor;

// ResultData(DTO) 클래스는 TestQuestion, TestAnswer, TestResult 엔티티 간의 데이터 전송을 위해 사용

@NoArgsConstructor
@JsonAutoDetect
@Data

public class ResultData {
    private int totalScore;
    private String recommendedJobs;
    private List<String> personalTraits;
    private LocalDateTime tdate;
    
    private List<Integer> userAnswersArray;

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public String getRecommendedJobs() {
		return recommendedJobs;
	}

	public void setRecommendedJobs(String recommendedJobs) {
		this.recommendedJobs = recommendedJobs;
	}

	public List<String> getPersonalTraits() {
		return personalTraits;
	}

	public void setPersonalTraits(List<String> personalTraits) {
		this.personalTraits = personalTraits;
	}

	public LocalDateTime getTdate() {
		return tdate;
	}

	public void setTdate(LocalDateTime tdate) {
		this.tdate = tdate;
	}

	public List<Integer> getUserAnswersArray() {
		return userAnswersArray;
	}

	public void setUserAnswersArray(List<Integer> userAnswersArray) {
		this.userAnswersArray = userAnswersArray;
	}
}