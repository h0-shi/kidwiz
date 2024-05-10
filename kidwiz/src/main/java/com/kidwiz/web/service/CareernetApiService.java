package com.kidwiz.web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CareernetApiService {

    private final WebClient webClient;

    public CareernetApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://example.com").build();
    }
    
	public String callApi() {
        String response = this.webClient.get()  // GET 요청
                .uri("/api/path")  // 요청할 URI
                .retrieve()  // 응답 검색
                .bodyToMono(String.class)  // 응답 본문을 String으로 변환
                .block();  // 비동기 요청을 동기 요청으로 변환 (주의: 실제 프로덕션 환경에서는 block() 사용을 지양해야 함)
        return response;
    }

}
