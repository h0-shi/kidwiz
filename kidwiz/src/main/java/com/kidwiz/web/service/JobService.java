package com.kidwiz.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JobService {
	
    @Autowired
    private RestTemplate restTemplate;

    public String getJobs(String apiKey) {
        String url = "http://apis.data.go.kr/1051000/recruitment/list?serviceKey=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }
}
