package com.kidwiz.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JobService {
	
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public String getJobs(String apiKey) {
//    	RestTemplate restTemplate = new RestTemplate();
//        String url = "https://apis.data.go.kr/1051000/recruitment/" + apiKey;
//        String response = restTemplate.getForObject(url + "?apiKey=" + apiKey, String.class);
//        return response;
//    }
}
