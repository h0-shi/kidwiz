package com.kidwiz.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	// HTTP 보안 설정 구성. 인증방식, 접근권한, 로그인 페이지, 로그아웃 등 설정
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				authz -> authz.requestMatchers("/", "/home", "/resources/**").permitAll().anyRequest().authenticated())
				.formLogin(form -> form
						.loginPage("/login")
						.usernameParameter("userId") // 아이디 필드 이름
						.passwordParameter("password") // 비밀번호 필드 이름
						.permitAll())
				.logout(logout -> logout.permitAll());
		System.out.println("안녕");
		return http.build();
	}

	// 비밀번호 안전하게 처리
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
