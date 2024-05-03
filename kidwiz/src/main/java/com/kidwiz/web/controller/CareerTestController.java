package com.kidwiz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kidwiz.web.service.CareernetApiService;

@RestController
@RequestMapping("/api/careernet")
public class CareerTestController {

	@Autowired
	private CareernetApiService careernetApiService;

    @GetMapping("/use-api")
    public String useApi() {
        return careernetApiService.callApi(); // Call the method within your service
    }

}
