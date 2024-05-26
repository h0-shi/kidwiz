package com.kidwiz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kidwiz.web.service.JobService;

@RestController
public class JobController {
	
    @Autowired
    private JobService jobService;

    @GetMapping("api/jobs")
    public String getJobs(@RequestParam(name = "apiKey") String apiKey) {
    	
        String response = jobService.getJobs(apiKey);
        System.out.println(apiKey);
        System.out.println(response);
        
        return response;
    }
}
