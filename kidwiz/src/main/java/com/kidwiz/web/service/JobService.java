package com.kidwiz.web.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JobService {
	
    @Autowired
    private RestTemplate restTemplate;

    public List<Map<String, Object>> getJobs(String apiKey) {
        String url = "https://apis.data.go.kr/1051000/recruitment/list?serviceKey="+apiKey+"&numOfRows=10&pageNo=1";
        List<Map<String, Object>> list = new ArrayList<>();
        try {
        	URL u = new URL(url);
        	HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        	conn.setRequestMethod("GET");
        	conn.setRequestProperty("Accept", "application/json");
			
            // 응답 코드 확인
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
            }

            // 응답 데이터 읽기
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            // 연결 종료
            conn.disconnect();
            // JSON 문자열을 JSON 객체로 파싱
            String jsonString = sb.toString();
            JSONObject jsonObject = new JSONObject(jsonString);
            
            JSONArray arr = jsonObject.getJSONArray("result");
            // 데이터 출력
            for (int i = 0; i < arr.length(); i++) {
            	JSONObject j = arr.getJSONObject(i);
            	Map<String, Object> map = new HashMap<>();
            	map.put("recrutPbancTtl", j.getString("recrutPbancTtl"));
            	map.put("instNm", j.getString("instNm"));
            	map.put("hireTypeNmLst", j.getString("hireTypeNmLst"));
            	map.put("workRgnNmLst", j.getString("workRgnNmLst"));
            	map.put("pbancBgngYmd", j.getString("pbancBgngYmd"));
            	map.put("pbancEndYmd", j.getString("pbancEndYmd"));
            	map.put("srcUrl", j.getString("srcUrl"));
            	list.add(map);
            }
        	
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        //String test =restTemplate.getForObject(url, String.class);
        return list;
    }
}
