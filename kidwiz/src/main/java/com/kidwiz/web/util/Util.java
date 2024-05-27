package com.kidwiz.web.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

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
	public static String extractExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
	
	public static Map<String, Object> fileUploadUtil(MultipartFile file) throws IllegalStateException, IOException{
		
		
		
		Map<String, Object> map = new HashMap<>();
		
		if(file.getSize()!=0) {
			String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String originalFileName = file.getOriginalFilename();
			String ext = extractExt(originalFileName);
			
			String saveFileName= currentTime + "." +ext;
			
			String pf = System.getProperty("user.dir");
			String ppf = new File(pf).getParent();
			String uploadFilePath = ppf+"\\vue_kidwiz\\public\\images"+"/"+saveFileName;
			
			
			File uploadFile = new File(uploadFilePath);
			
			if(!uploadFile.exists()) {
				uploadFile.mkdir();
			}
			
			Path path = Paths.get(uploadFilePath).toAbsolutePath();
			
			file.transferTo(path.toFile());
			
//            map.put("filePath", uploadFilePath);
            map.put("saveFileName", saveFileName);
//            map.put("originalFileName", originalFileName);
//            map.put("fileExt", ext);
//            map.put("fileSize", file.getSize());
		}
		
		
		return map;
	}
}
