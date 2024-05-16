package com.kidwiz.web.service;

import io.jsonwebtoken.Claims;

public interface JwtService {
	
	String getToken(String key, Object value);

	// 토큰값 받기
	Claims getClaims(String token);

	boolean isValid(String token);

	// 토큰에서 사용자 id 가져오기
	int getId(String token);

}
