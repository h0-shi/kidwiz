package com.kidwiz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kidwiz.web.Entity.Notice;
import com.kidwiz.web.service.NoticeService;

@RestController
@RequestMapping("/api/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

    @GetMapping("/posts")
    public List<Notice> getNotices() {
        return noticeService.getAllNotices();
    }

    @PostMapping("/posts")
    public void addNotice(@RequestBody Notice newNotice) {
        noticeService.addNotice(newNotice);
    }  
}
