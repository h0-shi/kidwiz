package com.kidwiz.web.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
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
    	
    	List<Map<String, Object>> response = jobService.getJobs(apiKey);
        
    	JSONObject json = new JSONObject();
    	JSONArray arr = new JSONArray(response);
    	
    	json.put("list", arr);
    	
        return json.toString();
    }
}
