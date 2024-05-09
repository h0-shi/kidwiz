package com.kidwiz.web.login;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UpdatePassword {

    public static void main(String[] args) {
        // 비밀번호 업데이트 로직
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "12341234";  // 예시 비밀번호
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("Encoded Password: " + encodedPassword);
        // 이 출력된 해시 값을 데이터베이스에 업데이트하는 SQL 쿼리를 실행
    }
}
