package com.kidwiz.web.service;

import com.kidwiz.web.DTO.JoblistsDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JoblistsService {
    public List<JoblistsDTO> getJobs() throws IOException {
        String url = "https://job.incruit.com/jobdb_list/searchjob.asp?occ2=574&occ1=120&rgn2=11";
        Document document = Jsoup.connect(url).get();

        List<JoblistsDTO> jobs = new ArrayList<>();
        Elements jobElements = document.select(".c_row"); // 공고 리스트 선택

        for (Element jobElement : jobElements) {
            String title = jobElement.select(".cell_mid .cl_top a").text();  // 채용 제목
            String company = jobElement.select(".cell_first .cpname").text();  // 회사 이름
            String location = jobElement.select(".cell_mid .cl_md span:nth-of-type(3)").text();  // 위치
            String date = jobElement.select(".cell_last .cl_btm span:nth-of-type(1)").text();  // 마감 날짜
            String detailLink = jobElement.select(".cell_mid .cl_top a").attr("href");  // 자세히 보기 링크

            // Debug logging
//            System.out.println("Title: " + title);
//            System.out.println("Company: " + company);
//            System.out.println("Location: " + location);
//            System.out.println("Date: " + date);
//            System.out.println("Detail Link: " + detailLink);

            JoblistsDTO job = new JoblistsDTO(title, company, location, date, detailLink);
            jobs.add(job);
        }

        return jobs;
    }
}
