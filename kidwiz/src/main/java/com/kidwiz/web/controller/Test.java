package com.kidwiz.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kidwiz.web.DTO.TestDTO;

@RestController
public class Test {
	
	@PostMapping("/testPost")
	public String postTest(@RequestBody TestDTO test) {
		System.out.println(test);
		return "실험중";
	}

}
