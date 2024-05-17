package com.kidwiz.web.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.xml.bind.DatatypeConverter;

@Service("jwtService")
public class JwtServiceImpl implements JwtService {

	private String secretKey = "abbci2ioadij@@@ai17a662###8139!!!18ausudahd178316738687687@@ad6g";

	// 토큰 만들기
	@Override
	public String getToken(String key, Object value) {

		Date expTime = new Date();
		expTime.setTime(expTime.getTime() + 1000 * 60 * 30); // 토큰 만료 시간 : 30분
		byte[] secretByteKey = DatatypeConverter.parseBase64Binary(secretKey);
		Key signKey = new SecretKeySpec(secretByteKey, SignatureAlgorithm.HS256.getJcaName());

		Map<String, Object> headerMap = new HashMap<>();
		headerMap.put("typ", "JWT");
		headerMap.put("alg", "HS256");

		Map<String, Object> map = new HashMap<>();
		map.put(key, value);

		JwtBuilder builder = Jwts.builder().setHeader(headerMap).setClaims(map).setExpiration(expTime).signWith(signKey,
				SignatureAlgorithm.HS256);

		return builder.compact();
	}

	@Override
	public Claims getClaims(String token) {
		// 토큰값이 null 이 아니고 비어있지 않으면
		if (token != null && !"".equals(token)) {
			try {
				byte[] secretByteKey = DatatypeConverter.parseBase64Binary(secretKey);
				Key signKey = new SecretKeySpec(secretByteKey, SignatureAlgorithm.HS256.getJcaName());
				return Jwts.parserBuilder().setSigningKey(signKey).build().parseClaimsJws(token).getBody();
			} catch (ExpiredJwtException e) {
				// 만료됨
			} catch (JwtException e) {
				// 유효하지 않음
			}
		}
		// 문제 있으면 null return
		return null;
	}
	
	@Override
	public boolean isValid(String token) {
		
		return this.getClaims(token) != null;
	}

    @Override
    public int getId(String token) {
        Claims claims = this.getClaims(token);

        if (claims != null) {
        	// id 값을 int 로 
            return Integer.parseInt(claims.get("id").toString());
        }
        	// null 이면 0 리턴
        return 0;
    }


}
