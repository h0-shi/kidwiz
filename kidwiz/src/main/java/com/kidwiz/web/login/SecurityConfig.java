/*package com.kidwiz.web.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // CSRF 설정 비활성화 (개발 단계에서 테스트 용도)
            .csrf().disable()

            // CORS 설정 활성화 (필요한 경우에만)
            .cors().and()

            // 권한 요청 설정
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/error", "/logout").permitAll() // 로그인, 에러 페이지, 로그아웃은 누구나 접근 가능
                .anyRequest().authenticated()) // 나머지 요청은 인증 필요

            // 로그인 설정
            .formLogin(form -> form
                .loginPage("/login") // 로그인 페이지 경로 (소문자 사용)
                .loginProcessingUrl("/login") // 로그인 처리 경로 (소문자 사용)
                .defaultSuccessUrl("/", true) // 로그인 성공 후 기본 리디렉션 경로
                .failureUrl("/login?error=true") // 로그인 실패 시 리디렉션 경로
                .permitAll())

            // 로그아웃 설정
            .logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그아웃 URL 매칭
                .logoutSuccessUrl("/login?logout") // 로그아웃 성공 후 리디렉션 경로
                .deleteCookies("JSESSIONID") // 로그아웃 시 쿠키 삭제
                .permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}*/