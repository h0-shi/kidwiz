package com.kidwiz.web.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Util {
	
	public static Map<String, Object> pageMap(int totalcount,int currentpage){
		
		int pageNum =10;
		double doubleTotalCount = (double) totalcount;
		int pageBlcok = 10;
		int totalpage = (int) Math.ceil((doubleTotalCount/pageNum));
		
		int startpage = ((currentpage -1) / pageBlcok) * pageBlcok + 1;
		int endpage = startpage*pageBlcok > totalpage ? totalpage : startpage*pageBlcok;
		
		
		int startRow = (currentpage-1) * pageNum;
		int endRow = startRow * pageNum > totalcount ? totalcount : startRow * pageNum;
		Map<String, Object> map = new HashMap<>();
		
		List<Integer> pagelist = new ArrayList<>();
		
		for(int i = startpage;i<=endpage;i++) {
			pagelist.add(i);
		}
		
		map.put("pagelist", pagelist);
		map.put("startpage", startpage);
		map.put("totalpage", totalpage);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("currentpage", currentpage);
		System.out.println(map);
		
		return map;
	}
	public static Map<String, Object> pageGMap(int totalcount,int currentpage){
		
		int pageNum =8;
		int pageBlcok = 5;
		int totalpage = (int) Math.ceil((totalcount/pageNum));	
		
		int startpage = ((currentpage -1) / pageBlcok) * pageBlcok + 1;
		int endpage = startpage*pageBlcok > totalpage ? totalpage : startpage*pageBlcok;
		
		
		int startRow = (currentpage-1) * pageNum;
		int endRow = startRow * pageNum > totalcount ? totalcount : startRow * pageNum;
		Map<String, Object> map = new HashMap<>();
		
		List<Integer> pagelist = new ArrayList<>();
		
		for(int i = startpage;i<=endpage;i++) {
			pagelist.add(i);
		}
		
		map.put("pagelist", pagelist);
		map.put("startpage", startpage);
		map.put("totalpage", totalpage);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("currentpage", currentpage);
		
		return map;
	}
}
