//package com.kidwiz.web.login;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//
//import javax.crypto.SecretKey;
//
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class JwtUtil {
//    private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); // 보안을 위해 자동으로 안전한 키 생성
//
//    // 사용자 이름을 기반으로 JWT 토큰을 생성합니다.
//    public String generateToken(String id) {
//        return Jwts.builder()
//                .setSubject(id) // 토큰의 주제 설정, 사용자 id 로 설정
//                .setIssuedAt(new Date()) // 토큰의 발행 시간 설정
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 토큰의 만료 시간 설정(10시간 후)
//                .signWith(secretKey) // HS256 알고리즘과 비밀 키를 사용하여 토큰에 서명
//                .compact(); // 토큰을 문자열로 압축 및 반환
//    }
//
//    // 토큰에서 클레임을 추출합니다.
//    public Claims extractClaims(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(secretKey) // 서명 검증을 위해 사용된 비밀 키 설정
//                .build()
//                .parseClaimsJws(token) // 파싱하고 검증된 JWT를 반환
//                .getBody();
//    }
//
//    // 토큰에서 사용자 이름을 추출합니다.
//    public String extractUsername(String token) {
//        return extractClaims(token).getSubject();
//    }
//
//    // 토큰이 만료되었는지 확인합니다.
//    public boolean isTokenExpired(String token) {
//        return extractClaims(token).getExpiration().before(new Date());
//    }
//
//    // 토큰의 유효성을 검사합니다. 사용자 이름과 만료 날짜를 확인합니다.
//    public boolean validateToken(String token, String username) {
//        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
//    }
//}