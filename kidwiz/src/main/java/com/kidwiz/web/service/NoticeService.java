package com.kidwiz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidwiz.web.Entity.Notice;
import com.kidwiz.web.repository.NoticeRepository;

@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public void addNotice(Notice notice) {
        noticeRepository.save(notice);
    }

	public List<Notice> getAllNotices() {
		return noticeRepository.findAll();
	}
}
